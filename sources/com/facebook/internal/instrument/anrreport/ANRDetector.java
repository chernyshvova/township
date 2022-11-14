package com.facebook.internal.instrument.anrreport;

import android.app.ActivityManager;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: ANRDetector.kt */
public final class ANRDetector {
    public static final int DETECTION_INTERVAL_IN_MS = 500;
    public static final ANRDetector INSTANCE = new ANRDetector();
    public static final Runnable anrDetectorRunnable = $$Lambda$uE1dCF2iduQZmZLAjiovuK3Fhw.INSTANCE;
    public static final int myUid = Process.myUid();
    public static String previousStackTrace = "";
    public static final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: anrDetectorRunnable$lambda-0  reason: not valid java name */
    public static final void m3642anrDetectorRunnable$lambda0() {
        Class<ANRDetector> cls = ANRDetector.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Object systemService = FacebookSdk.getApplicationContext().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                if (systemService != null) {
                    checkProcessError((ActivityManager) systemService);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @VisibleForTesting
    public static final void checkProcessError(ActivityManager activityManager) {
        Class<ANRDetector> cls = ANRDetector.class;
        if (!CrashShieldHandler.isObjectCrashing(cls) && activityManager != null) {
            try {
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2 && processErrorStateInfo.uid == myUid) {
                            Thread thread = Looper.getMainLooper().getThread();
                            Intrinsics.checkNotNullExpressionValue(thread, "getMainLooper().thread");
                            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
                            String stackTrace = InstrumentUtility.getStackTrace(thread);
                            if (!Intrinsics.areEqual(stackTrace, previousStackTrace)) {
                                InstrumentUtility instrumentUtility2 = InstrumentUtility.INSTANCE;
                                if (InstrumentUtility.isSDKRelatedThread(thread)) {
                                    previousStackTrace = stackTrace;
                                    InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                                    InstrumentData.Builder.build(processErrorStateInfo.shortMsg, stackTrace).save();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @VisibleForTesting
    public static final void start() {
        Class<ANRDetector> cls = ANRDetector.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                scheduledExecutorService.scheduleAtFixedRate(anrDetectorRunnable, 0, (long) 500, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
