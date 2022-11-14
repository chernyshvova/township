package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.LoggingBehavior;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.security.CertificateUtil;
import com.helpshift.util.ErrorReportProvider;
import com.vungle.warren.log.LogEntry;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionLogger.kt */
public final class SessionLogger {
    public static final long[] INACTIVE_SECONDS_QUANTA = {300000, 900000, 1800000, 3600000, 21600000, 43200000, ErrorReportProvider.BATCH_TIME, 172800000, 259200000, UserSettingsManager.TIMEOUT_7D, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    public static final SessionLogger INSTANCE = new SessionLogger();
    public static final String PACKAGE_CHECKSUM = "PCKGCHKSUM";
    public static final String TAG = SessionLogger.class.getCanonicalName();

    private final String computePackageChecksum(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String stringPlus = Intrinsics.stringPlus("PCKGCHKSUM;", packageManager.getPackageInfo(context.getPackageName(), 0).versionName);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String string = sharedPreferences.getString(stringPlus, (String) null);
            if (string != null && string.length() == 32) {
                return string;
            }
            HashUtils hashUtils = HashUtils.INSTANCE;
            String computeChecksumWithPackageManager = HashUtils.computeChecksumWithPackageManager(context, (Long) null);
            if (computeChecksumWithPackageManager == null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                HashUtils hashUtils2 = HashUtils.INSTANCE;
                computeChecksumWithPackageManager = HashUtils.computeChecksum(applicationInfo.sourceDir);
            }
            sharedPreferences.edit().putString(stringPlus, computeChecksumWithPackageManager).apply();
            return computeChecksumWithPackageManager;
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final int getQuantaIndex(long j) {
        Class<SessionLogger> cls = SessionLogger.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        int i = 0;
        while (i < INACTIVE_SECONDS_QUANTA.length && INACTIVE_SECONDS_QUANTA[i] < j) {
            try {
                i++;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return 0;
            }
        }
        return i;
    }

    public static final void logActivateApp(String str, SourceApplicationInfo sourceApplicationInfo, String str2, Context context) {
        Class<SessionLogger> cls = SessionLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "activityName");
                Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
                String str3 = "Unclassified";
                if (sourceApplicationInfo != null) {
                    String sourceApplicationInfo2 = sourceApplicationInfo.toString();
                    if (sourceApplicationInfo2 != null) {
                        str3 = sourceApplicationInfo2;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str3);
                bundle.putString(AppEventsConstants.EVENT_PARAM_PACKAGE_FP, INSTANCE.computePackageChecksum(context));
                CertificateUtil certificateUtil = CertificateUtil.INSTANCE;
                bundle.putString(AppEventsConstants.EVENT_PARAM_APP_CERT_HASH, CertificateUtil.getCertificateHash(context));
                InternalAppEventsLogger createInstance = InternalAppEventsLogger.Companion.createInstance(str, str2, (AccessToken) null);
                createInstance.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
                if (InternalAppEventsLogger.Companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                    createInstance.flush();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void logClockSkewEvent() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                String str = TAG;
                Intrinsics.checkNotNull(str);
                companion.log(loggingBehavior, str, "Clock skew detected");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final void logDeactivateApp(String str, SessionInfo sessionInfo, String str2) {
        long j;
        String str3 = str;
        Class<SessionLogger> cls = SessionLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "activityName");
                if (sessionInfo != null) {
                    Long diskRestoreTime = sessionInfo.getDiskRestoreTime();
                    long j2 = 0;
                    if (diskRestoreTime == null) {
                        Long sessionLastEventTime = sessionInfo.getSessionLastEventTime();
                        j = 0 - (sessionLastEventTime == null ? 0 : sessionLastEventTime.longValue());
                    } else {
                        j = diskRestoreTime.longValue();
                    }
                    if (j < 0) {
                        INSTANCE.logClockSkewEvent();
                        j = 0;
                    }
                    long sessionLength = sessionInfo.getSessionLength();
                    if (sessionLength < 0) {
                        INSTANCE.logClockSkewEvent();
                        sessionLength = 0;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, sessionInfo.getInterruptionCount());
                    String format = String.format(Locale.ROOT, "session_quanta_%d", Arrays.copyOf(new Object[]{Integer.valueOf(getQuantaIndex(j))}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                    bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, format);
                    SourceApplicationInfo sourceApplicationInfo = sessionInfo.getSourceApplicationInfo();
                    String str4 = "Unclassified";
                    if (sourceApplicationInfo != null) {
                        String sourceApplicationInfo2 = sourceApplicationInfo.toString();
                        if (sourceApplicationInfo2 != null) {
                            str4 = sourceApplicationInfo2;
                        }
                    }
                    bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str4);
                    Long sessionLastEventTime2 = sessionInfo.getSessionLastEventTime();
                    if (sessionLastEventTime2 != null) {
                        j2 = sessionLastEventTime2.longValue();
                    }
                    bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, j2 / ((long) 1000));
                    InternalAppEventsLogger createInstance = InternalAppEventsLogger.Companion.createInstance(str, str2, (AccessToken) null);
                    double d = (double) sessionLength;
                    double d2 = (double) 1000;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    createInstance.logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, d / d2, bundle);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
