package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.appsflyer.internal.C1471d;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.helpshift.p042db.legacy_profile.tables.ProfileTable;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.appsflyer.internal.az */
public final class C1433az extends C1443bh {
    @VisibleForTesting
    public static String onAppOpenAttributionNative;
    public final SharedPreferences onAttributionFailureNative;

    static {
        StringBuilder sb = new StringBuilder("https://%sregister.%s/api/v");
        sb.append(C1387af.AFInAppEventType);
        onAppOpenAttributionNative = sb.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1433az(@androidx.annotation.NonNull android.content.Context r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = onAppOpenAttributionNative
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.appsflyer.AppsFlyerLib r3 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r3 = r3.getHostPrefix()
            r4 = 0
            r2[r4] = r3
            com.appsflyer.internal.af r3 = com.appsflyer.internal.C1387af.AFInAppEventParameterName()
            java.lang.String r3 = r3.getHostName()
            r4 = 1
            r2[r4] = r3
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.append(r1)
            java.lang.String r1 = r10.getPackageName()
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r9
            r8 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            android.content.SharedPreferences r10 = com.appsflyer.internal.C1387af.AFInAppEventType((android.content.Context) r10)
            r9.onAttributionFailureNative = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1433az.<init>(android.content.Context):void");
    }

    public static boolean values(Context context) {
        if (AppsFlyerLib.getInstance().isStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
            if (C1381ac.values(context, new Intent("com.google.firebase.MESSAGING_EVENT", (Uri) null, context, FirebaseMessagingServiceListener.class))) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.values("An error occurred while trying to verify manifest declarations: ", th);
        }
    }

    @Nullable
    public C1483m AFInAppEventParameterName() {
        String string;
        String string2;
        String string3 = this.onAttributionFailureNative.getString("afUninstallToken", (String) null);
        long j = this.onAttributionFailureNative.getLong("afUninstallToken_received_time", 0);
        boolean z = this.onAttributionFailureNative.getBoolean("afUninstallToken_queued", false);
        this.onAttributionFailureNative.edit().putBoolean("afUninstallToken_queued", false).apply();
        if (string3 == null && (string2 = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] split = string2.split(",");
            string3 = split[split.length - 1];
        }
        if (j == 0 && (string = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] split2 = string.split(",");
            if (split2.length >= 2) {
                try {
                    j = Long.parseLong(split2[split2.length - 2]);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (string3 != null) {
            return new C1483m(string3, j, z);
        }
        return null;
    }

    public final void AFKeystoreWrapper(String str) {
        if (str != null) {
            AFLogger.AFInAppEventParameterName("Firebase Refreshed Token = ".concat(str));
            C1483m AFInAppEventParameterName = AFInAppEventParameterName();
            if (AFInAppEventParameterName == null || !str.equals(AFInAppEventParameterName.AFKeystoreWrapper)) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = C1387af.AFKeystoreWrapper(this.onAttributionFailureNative) && (AFInAppEventParameterName == null || currentTimeMillis - AFInAppEventParameterName.AFInAppEventType > TimeUnit.SECONDS.toMillis(2));
                AFInAppEventParameterName(new C1483m(str, currentTimeMillis, !z));
                if (z) {
                    valueOf(str);
                }
            }
        }
    }

    public void valueOf(String str) {
        Application application = this.valueOf;
        final C1387af AFInAppEventParameterName = C1387af.AFInAppEventParameterName();
        if (C1387af.AFInAppEventType()) {
            AFLogger.AFInAppEventParameterName("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        String valueOf = C1387af.valueOf(AppsFlyerProperties.AF_KEY);
        if (valueOf == null) {
            AFLogger.AFVersionDeclaration("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = application.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(application.getPackageName(), 0);
            this.AFInAppEventType.put("app_version_code", Integer.toString(packageInfo.versionCode));
            this.AFInAppEventType.put("app_version_name", packageInfo.versionName);
            this.AFInAppEventType.put("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j = packageInfo.firstInstallTime;
            this.AFInAppEventType.put("installDate", C1387af.AFInAppEventType(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), j));
        } catch (Throwable th) {
            AFLogger.values("Exception while collecting application version info.", th);
        }
        C1387af.AFKeystoreWrapper((Context) application, (Map<String, ? super String>) this.AFInAppEventType);
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string != null) {
            this.AFInAppEventType.put("appUserId", string);
        }
        try {
            this.AFInAppEventType.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
            this.AFInAppEventType.put("brand", Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.values("Exception while collecting device brand and model.", th2);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            this.AFInAppEventType.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        C1471d.C1472a.C1473d AFKeystoreWrapper = C1380ab.AFKeystoreWrapper(application.getContentResolver());
        if (AFKeystoreWrapper != null) {
            this.AFInAppEventType.put("amazon_aid", AFKeystoreWrapper.valueOf);
            this.AFInAppEventType.put("amazon_aid_limit", String.valueOf(AFKeystoreWrapper.AFInAppEventType));
        }
        String string2 = AppsFlyerProperties.getInstance().getString("advertiserId");
        if (string2 != null) {
            this.AFInAppEventType.put("advertiserId", string2);
        }
        this.AFInAppEventType.put("devkey", valueOf);
        this.AFInAppEventType.put(ProfileTable.Columns.COLUMN_UID, C1412ak.AFKeystoreWrapper(new WeakReference(application)));
        this.AFInAppEventType.put("af_gcm_token", str);
        this.AFInAppEventType.put("launch_counter", Integer.toString(C1387af.AFInAppEventParameterName(this.onAttributionFailureNative, "appsFlyerCount", false)));
        this.AFInAppEventType.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        String AFInAppEventParameterName2 = AFInAppEventParameterName.AFInAppEventParameterName((Context) application);
        if (AFInAppEventParameterName2 != null) {
            this.AFInAppEventType.put("channel", AFInAppEventParameterName2);
        }
        new Thread(new Runnable() {
            public final void run() {
                try {
                    C1433az azVar = C1433az.this;
                    azVar.onConversionDataSuccess = AFInAppEventParameterName.isStopped();
                    HttpURLConnection values2 = new C1482k(azVar).values();
                    if (values2 != null) {
                        if (values2.getResponseCode() == 200) {
                            C1433az.AFKeystoreWrapper(C1433az.this);
                        }
                        values2.disconnect();
                    }
                } catch (Throwable th) {
                    AFLogger.values(th.getMessage(), th);
                }
            }
        }).start();
    }

    public static boolean values(@NonNull SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("sentRegisterRequestToAF", false);
    }

    public static /* synthetic */ void AFKeystoreWrapper(C1433az azVar) {
        azVar.onAttributionFailureNative.edit().putBoolean("sentRegisterRequestToAF", true).apply();
        AFLogger.AFInAppEventType("Successfully registered for Uninstall Tracking");
    }

    private void AFInAppEventParameterName(C1483m mVar) {
        this.onAttributionFailureNative.edit().putString("afUninstallToken", mVar.AFKeystoreWrapper).putLong("afUninstallToken_received_time", mVar.AFInAppEventType).putBoolean("afUninstallToken_queued", mVar.AFKeystoreWrapper()).apply();
    }
}
