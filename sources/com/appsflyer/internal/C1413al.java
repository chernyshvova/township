package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;

/* renamed from: com.appsflyer.internal.al */
public abstract class C1413al implements Runnable {
    public static String AFInAppEventType = "v2";
    public static long AppsFlyer2dXConversionCallback = 0;
    public static char[] init = null;
    public static int onAttributionFailureNative = 0;
    public static int onInstallConversionFailureNative = 1;
    public static String valueOf;
    public final C1387af AFInAppEventParameterName;
    public final String AFKeystoreWrapper;
    public final String AFLogger$LogLevel = UUID.randomUUID().toString();
    public final Map<String, Object> AFVersionDeclaration = AFKeystoreWrapper();
    public final Context getLevel;
    public String values;

    static {
        AFInAppEventParameterName();
        StringBuilder sb = new StringBuilder("https://%sonelink.%s/shortlink-sdk/");
        sb.append(AFInAppEventType);
        valueOf = sb.toString();
        int i = onInstallConversionFailureNative + 91;
        onAttributionFailureNative = i % 128;
        int i2 = i % 2;
    }

    public C1413al(C1387af afVar, Context context, String str) {
        this.AFInAppEventParameterName = afVar;
        this.getLevel = context;
        this.AFKeystoreWrapper = str;
    }

    public static String AFInAppEventParameterName(int i, char c, int i2) {
        int i3 = onAttributionFailureNative + 85;
        onInstallConversionFailureNative = i3 % 128;
        int i4 = i3 % 2;
        char[] cArr = new char[i2];
        int i5 = 0;
        int i6 = onInstallConversionFailureNative + 45;
        onAttributionFailureNative = i6 % 128;
        int i7 = i6 % 2;
        while (true) {
            if ((i5 < i2 ? 4 : 'T') == 'T') {
                return new String(cArr);
            }
            cArr[i5] = (char) ((int) ((((long) init[i + i5]) ^ (((long) i5) * AppsFlyer2dXConversionCallback)) ^ ((long) c)));
            i5++;
        }
    }

    public static void AFInAppEventParameterName() {
        init = new char[]{45555, 34683, 56513, 5612, 27495, 41150, 63942, 53018, 1214, 24032, 37654, 59474};
        AppsFlyer2dXConversionCallback = 5266227840004863663L;
    }

    public abstract String AFInAppEventType();

    public abstract void AFInAppEventType(HttpsURLConnection httpsURLConnection) throws JSONException, IOException;

    public final void AFKeystoreWrapper(HttpsURLConnection httpsURLConnection, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, AFInAppEventType);
        String join = TextUtils.join("⁣", arrayList.toArray());
        StringBuilder sb = new StringBuilder();
        sb.append(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        sb.append(this.AFLogger$LogLevel);
        sb.append(AFInAppEventType);
        httpsURLConnection.setRequestProperty(AFInAppEventParameterName(1 - (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)), (char) (45490 - Color.argb(0, 0, 0, 0)), 12 - Color.argb(0, 0, 0, 0)).intern(), C1407ai.values(join, sb.toString()));
        int i = onAttributionFailureNative + 55;
        onInstallConversionFailureNative = i % 128;
        if (i % 2 == 0) {
            int i2 = 13 / 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r6.AFInAppEventType()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "oneLinkUrl: "
            java.lang.String r2 = r3.concat(r2)
            com.appsflyer.AFLogger.AFKeystoreWrapper(r2)
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x006a }
            r2.<init>(r1)     // Catch:{ all -> 0x006a }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ all -> 0x006a }
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ all -> 0x006a }
            java.lang.String r3 = "content-type"
            java.lang.String r4 = "application/json"
            r2.setRequestProperty(r3, r4)     // Catch:{ all -> 0x006a }
            r3 = 3000(0xbb8, float:4.204E-42)
            r2.setReadTimeout(r3)     // Catch:{ all -> 0x006a }
            r2.setConnectTimeout(r3)     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r6.AFKeystoreWrapper     // Catch:{ all -> 0x006a }
            r2.setRequestMethod(r3)     // Catch:{ all -> 0x006a }
            r6.AFInAppEventType(r2)     // Catch:{ all -> 0x006a }
            int r3 = r2.getResponseCode()     // Catch:{ all -> 0x006a }
            java.lang.String r2 = com.appsflyer.internal.C1387af.AFInAppEventType((java.net.HttpURLConnection) r2)     // Catch:{ all -> 0x006a }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x0051
            int r3 = onAttributionFailureNative
            int r3 = r3 + 33
            int r4 = r3 % 128
            onInstallConversionFailureNative = r4
            int r3 = r3 % 2
            java.lang.String r3 = "Status 200 ok"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r3)     // Catch:{ all -> 0x0068 }
            goto L_0x0093
        L_0x0051:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            java.lang.String r4 = "Response code = "
            r0.<init>(r4)     // Catch:{ all -> 0x0068 }
            r0.append(r3)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = " content = "
            r0.append(r3)     // Catch:{ all -> 0x0068 }
            r0.append(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0068 }
            goto L_0x0093
        L_0x0068:
            r0 = move-exception
            goto L_0x006e
        L_0x006a:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L_0x006e:
            java.lang.String r3 = java.lang.String.valueOf(r1)
            java.lang.String r4 = "Error while calling "
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.values(r3, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " stacktrace: "
            r3.append(r1)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x0093:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r3 = 65
            if (r1 == 0) goto L_0x009e
            r1 = 65
            goto L_0x00a0
        L_0x009e:
            r1 = 61
        L_0x00a0:
            if (r1 == r3) goto L_0x00b3
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Connection error: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.AFVersionDeclaration(r0)
            r6.valueOf()
            return
        L_0x00b3:
            int r0 = onInstallConversionFailureNative
            int r0 = r0 + 75
            int r1 = r0 % 128
            onAttributionFailureNative = r1
            int r0 = r0 % 2
            r1 = 29
            if (r0 == 0) goto L_0x00c4
            r0 = 29
            goto L_0x00c6
        L_0x00c4:
            r0 = 74
        L_0x00c6:
            java.lang.String r3 = "Connection call succeeded: "
            if (r0 == r1) goto L_0x00d9
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r0 = r3.concat(r0)
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)
            r6.values(r2)
            return
        L_0x00d9:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r0 = r3.concat(r0)
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)
            r6.values(r2)
            r0 = 1
            int r0 = r0 / 0
            return
        L_0x00eb:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1413al.run():void");
    }

    public abstract void valueOf();

    public abstract void values(String str);

    private Map<String, Object> AFKeystoreWrapper() {
        HashMap outline28 = GeneratedOutlineSupport.outline28("build_number", "6.3.0");
        outline28.put("counter", Integer.valueOf(C1387af.AFInAppEventParameterName(C1387af.AFInAppEventType(this.getLevel), "appsFlyerCount", false)));
        outline28.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        outline28.put("brand", Build.BRAND);
        outline28.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        try {
            outline28.put("app_version_name", this.getLevel.getPackageManager().getPackageInfo(this.getLevel.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        outline28.put("app_id", this.getLevel.getPackageName());
        outline28.put("platformextension", new C1408aj().values());
        int i = onInstallConversionFailureNative + 69;
        onAttributionFailureNative = i % 128;
        int i2 = i % 2;
        return outline28;
    }
}
