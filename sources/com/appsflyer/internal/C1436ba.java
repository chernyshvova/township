package com.appsflyer.internal;

import android.app.Application;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.appsflyer.internal.ba */
public final class C1436ba implements Runnable {
    public static final List<String> AFInAppEventType = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});
    @VisibleForTesting
    public static String values = "https://%sgcdsdk.%s/install_data/v4.0/";
    public final ScheduledExecutorService AFInAppEventParameterName;
    public final String AFKeystoreWrapper;
    public final int AFLogger$LogLevel;
    public final C1387af AFVersionDeclaration;
    public final AtomicInteger init;
    public final Application valueOf;

    public C1436ba(C1387af afVar, Application application, String str) {
        if (C1486n.valueOf == null) {
            C1486n.valueOf = new C1486n();
        }
        this.AFInAppEventParameterName = C1486n.valueOf.values();
        this.init = new AtomicInteger(0);
        this.AFVersionDeclaration = afVar;
        this.valueOf = application;
        this.AFKeystoreWrapper = str;
        this.AFLogger$LogLevel = 0;
    }

    public static void AFInAppEventParameterName(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
        sb.append(map.toString());
        AFLogger.AFInAppEventType(sb.toString());
        C1387af.AFKeystoreWrapper.onConversionDataSuccess(map);
    }

    public static void values(String str) {
        if (C1387af.AFKeystoreWrapper != null) {
            AFLogger.AFInAppEventType("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            C1387af.AFKeystoreWrapper.onConversionDataFail(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0126 A[Catch:{ bb -> 0x0261, all -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0194 A[Catch:{ bb -> 0x0261, all -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0292 A[Catch:{ all -> 0x02c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02a1 A[Catch:{ all -> 0x02c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02b6 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "is_first_launch"
            java.lang.String r2 = "af_siteid"
            java.lang.String r3 = r1.AFKeystoreWrapper
            if (r3 == 0) goto L_0x02d0
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0012
            goto L_0x02d0
        L_0x0012:
            com.appsflyer.internal.af r3 = r1.AFVersionDeclaration
            boolean r3 = r3.isStopped()
            if (r3 == 0) goto L_0x0025
            java.lang.String r0 = "[GCD-E03] 'isStopTracking' enabled"
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0)
            java.lang.String r0 = "'isStopTracking' enabled"
            values(r0)
            return
        L_0x0025:
            java.util.concurrent.atomic.AtomicInteger r3 = r1.init
            r3.incrementAndGet()
            r3 = 0
            r6 = 2
            android.app.Application r7 = r1.valueOf     // Catch:{ all -> 0x028d }
            if (r7 != 0) goto L_0x0040
            java.lang.String r0 = "[GCD-E06] Context null"
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0)     // Catch:{ all -> 0x028d }
            java.lang.String r0 = "Context null"
            values(r0)     // Catch:{ all -> 0x028d }
            java.util.concurrent.atomic.AtomicInteger r0 = r1.init
            r0.decrementAndGet()
            return
        L_0x0040:
            com.appsflyer.internal.af r7 = r1.AFVersionDeclaration     // Catch:{ all -> 0x028d }
            android.app.Application r8 = r1.valueOf     // Catch:{ all -> 0x028d }
            com.appsflyer.internal.af r9 = r1.AFVersionDeclaration     // Catch:{ all -> 0x028d }
            android.app.Application r10 = r1.valueOf     // Catch:{ all -> 0x028d }
            java.lang.String r9 = r9.AFInAppEventParameterName((android.content.Context) r10)     // Catch:{ all -> 0x028d }
            java.lang.String r7 = r7.AFInAppEventParameterName((android.content.Context) r8, (java.lang.String) r9)     // Catch:{ all -> 0x028d }
            java.lang.String r8 = ""
            r9 = 1
            r10 = 0
            if (r7 == 0) goto L_0x0076
            java.util.List<java.lang.String> r11 = AFInAppEventType     // Catch:{ all -> 0x028d }
            java.lang.String r12 = r7.toLowerCase()     // Catch:{ all -> 0x028d }
            boolean r11 = r11.contains(r12)     // Catch:{ all -> 0x028d }
            if (r11 != 0) goto L_0x0069
            java.lang.String r11 = "-"
            java.lang.String r7 = r11.concat(r7)     // Catch:{ all -> 0x028d }
            goto L_0x0077
        L_0x0069:
            java.lang.String r11 = "AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix."
            java.lang.Object[] r12 = new java.lang.Object[r9]     // Catch:{ all -> 0x028d }
            r12[r10] = r7     // Catch:{ all -> 0x028d }
            java.lang.String r7 = java.lang.String.format(r11, r12)     // Catch:{ all -> 0x028d }
            com.appsflyer.AFLogger.AFVersionDeclaration(r7)     // Catch:{ all -> 0x028d }
        L_0x0076:
            r7 = r8
        L_0x0077:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r11.<init>()     // Catch:{ all -> 0x028d }
            java.lang.String r12 = values     // Catch:{ all -> 0x028d }
            java.lang.Object[] r13 = new java.lang.Object[r6]     // Catch:{ all -> 0x028d }
            com.appsflyer.AppsFlyerLib r14 = com.appsflyer.AppsFlyerLib.getInstance()     // Catch:{ all -> 0x028d }
            java.lang.String r14 = r14.getHostPrefix()     // Catch:{ all -> 0x028d }
            r13[r10] = r14     // Catch:{ all -> 0x028d }
            com.appsflyer.internal.af r14 = com.appsflyer.internal.C1387af.AFInAppEventParameterName()     // Catch:{ all -> 0x028d }
            java.lang.String r14 = r14.getHostName()     // Catch:{ all -> 0x028d }
            r13[r9] = r14     // Catch:{ all -> 0x028d }
            java.lang.String r12 = java.lang.String.format(r12, r13)     // Catch:{ all -> 0x028d }
            r11.append(r12)     // Catch:{ all -> 0x028d }
            android.app.Application r12 = r1.valueOf     // Catch:{ all -> 0x028d }
            java.lang.String r12 = r12.getPackageName()     // Catch:{ all -> 0x028d }
            r11.append(r12)     // Catch:{ all -> 0x028d }
            r11.append(r7)     // Catch:{ all -> 0x028d }
            java.lang.String r7 = "?devkey="
            r11.append(r7)     // Catch:{ all -> 0x028d }
            java.lang.String r7 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x028d }
            r11.append(r7)     // Catch:{ all -> 0x028d }
            java.lang.String r7 = "&device_id="
            r11.append(r7)     // Catch:{ all -> 0x028d }
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x028d }
            android.app.Application r12 = r1.valueOf     // Catch:{ all -> 0x028d }
            r7.<init>(r12)     // Catch:{ all -> 0x028d }
            java.lang.String r7 = com.appsflyer.internal.C1412ak.AFKeystoreWrapper(r7)     // Catch:{ all -> 0x028d }
            r11.append(r7)     // Catch:{ all -> 0x028d }
            java.lang.String r7 = r11.toString()     // Catch:{ all -> 0x028d }
            com.appsflyer.internal.am r11 = com.appsflyer.internal.C1414am.AFKeystoreWrapper()     // Catch:{ all -> 0x028d }
            java.lang.String r12 = "server_request"
            java.lang.String[] r8 = new java.lang.String[]{r8}     // Catch:{ all -> 0x028d }
            r11.valueOf(r12, r7, r8)     // Catch:{ all -> 0x028d }
            java.lang.String r8 = "[GCD-B01] URL: "
            java.lang.String r11 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x028d }
            java.lang.String r8 = r8.concat(r11)     // Catch:{ all -> 0x028d }
            com.appsflyer.internal.C1415an.AFKeystoreWrapper(r8)     // Catch:{ all -> 0x028d }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x028d }
            java.net.URL r8 = new java.net.URL     // Catch:{ all -> 0x028d }
            r8.<init>(r7)     // Catch:{ all -> 0x028d }
            java.net.URLConnection r8 = r8.openConnection()     // Catch:{ all -> 0x028d }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ all -> 0x028d }
            java.lang.String r3 = "GET"
            r8.setRequestMethod(r3)     // Catch:{ all -> 0x028a }
            r3 = 10000(0x2710, float:1.4013E-41)
            r8.setConnectTimeout(r3)     // Catch:{ all -> 0x028a }
            java.lang.String r3 = "Connection"
            java.lang.String r13 = "close"
            r8.setRequestProperty(r3, r13)     // Catch:{ all -> 0x028a }
            r8.connect()     // Catch:{ all -> 0x028a }
            int r3 = r8.getResponseCode()     // Catch:{ all -> 0x028a }
            java.lang.String r13 = com.appsflyer.internal.C1387af.AFInAppEventType((java.net.HttpURLConnection) r8)     // Catch:{ all -> 0x028a }
            com.appsflyer.internal.am r14 = com.appsflyer.internal.C1414am.AFKeystoreWrapper()     // Catch:{ all -> 0x028a }
            java.lang.String r15 = "server_response"
            java.lang.String[] r4 = new java.lang.String[r6]     // Catch:{ all -> 0x028a }
            java.lang.String r5 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x028a }
            r4[r10] = r5     // Catch:{ all -> 0x028a }
            r4[r9] = r13     // Catch:{ all -> 0x028a }
            r14.valueOf(r15, r7, r4)     // Catch:{ all -> 0x028a }
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 404(0x194, float:5.66E-43)
            if (r3 == r4) goto L_0x0154
            if (r3 != r5) goto L_0x0129
            goto L_0x0154
        L_0x0129:
            r0 = 403(0x193, float:5.65E-43)
            if (r3 == r0) goto L_0x0131
            r0 = 500(0x1f4, float:7.0E-43)
            if (r3 < r0) goto L_0x0145
        L_0x0131:
            int r0 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x028a }
            if (r0 >= r6) goto L_0x0145
            com.appsflyer.internal.ba r0 = new com.appsflyer.internal.ba     // Catch:{ all -> 0x028a }
            r0.<init>(r1)     // Catch:{ all -> 0x028a }
            java.util.concurrent.ScheduledExecutorService r2 = r0.AFInAppEventParameterName     // Catch:{ all -> 0x028a }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x028a }
            r4 = 10
            com.appsflyer.internal.C1387af.AFInAppEventParameterName(r2, r0, r4, r3)     // Catch:{ all -> 0x028a }
            goto L_0x0281
        L_0x0145:
            java.lang.String r0 = "Error connection to server: "
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x028a }
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x028a }
            values(r0)     // Catch:{ all -> 0x028a }
            goto L_0x0281
        L_0x0154:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x028a }
            r4.<init>()     // Catch:{ all -> 0x028a }
            java.lang.String r7 = "net"
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x028a }
            long r14 = r14 - r11
            r4.put(r7, r14)     // Catch:{ all -> 0x028a }
            java.lang.String r7 = "retries"
            int r11 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x028a }
            r4.put(r7, r11)     // Catch:{ all -> 0x028a }
            com.appsflyer.internal.af r7 = r1.AFVersionDeclaration     // Catch:{ all -> 0x028a }
            com.appsflyer.internal.aw r7 = r7.AFLogger$LogLevel     // Catch:{ all -> 0x028a }
            java.lang.String r11 = "gcd"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x028a }
            android.content.SharedPreferences r7 = r7.AFInAppEventType     // Catch:{ all -> 0x028a }
            android.content.SharedPreferences$Editor r7 = r7.edit()     // Catch:{ all -> 0x028a }
            android.content.SharedPreferences$Editor r4 = r7.putString(r11, r4)     // Catch:{ all -> 0x028a }
            r4.apply()     // Catch:{ all -> 0x028a }
            java.lang.String r4 = "Attribution data: "
            java.lang.String r7 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x028a }
            java.lang.String r4 = r4.concat(r7)     // Catch:{ all -> 0x028a }
            com.appsflyer.internal.C1415an.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x028a }
            int r4 = r13.length()     // Catch:{ all -> 0x028a }
            if (r4 <= 0) goto L_0x0281
            java.util.Map r4 = com.appsflyer.internal.C1432ay.AFInAppEventParameterName(r13)     // Catch:{ all -> 0x028a }
            java.lang.String r7 = "iscache"
            java.lang.Object r7 = r4.get(r7)     // Catch:{ all -> 0x028a }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x028a }
            if (r3 != r5) goto L_0x01ba
            java.lang.String r3 = "error_reason"
            r4.remove(r3)     // Catch:{ all -> 0x028a }
            java.lang.String r3 = "status_code"
            r4.remove(r3)     // Catch:{ all -> 0x028a }
            java.lang.String r3 = "af_status"
            java.lang.String r5 = "Organic"
            r4.put(r3, r5)     // Catch:{ all -> 0x028a }
            java.lang.String r3 = "af_message"
            java.lang.String r5 = "organic install"
            r4.put(r3, r5)     // Catch:{ all -> 0x028a }
        L_0x01ba:
            if (r7 == 0) goto L_0x01cf
            boolean r3 = r7.booleanValue()     // Catch:{ all -> 0x028a }
            if (r3 != 0) goto L_0x01cf
            com.appsflyer.internal.af r3 = r1.AFVersionDeclaration     // Catch:{ all -> 0x028a }
            android.app.Application r5 = r1.valueOf     // Catch:{ all -> 0x028a }
            java.lang.String r7 = "appsflyerConversionDataCacheExpiration"
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x028a }
            r3.valueOf((android.content.Context) r5, (java.lang.String) r7, (long) r11)     // Catch:{ all -> 0x028a }
        L_0x01cf:
            boolean r3 = r4.containsKey(r2)     // Catch:{ all -> 0x028a }
            java.lang.String r5 = "[Invite] Detected App-Invite via channel: "
            java.lang.String r7 = "af_channel"
            if (r3 == 0) goto L_0x0204
            boolean r3 = r4.containsKey(r7)     // Catch:{ all -> 0x028a }
            if (r3 == 0) goto L_0x01f3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x028a }
            r3.<init>(r5)     // Catch:{ all -> 0x028a }
            java.lang.Object r11 = r4.get(r7)     // Catch:{ all -> 0x028a }
            r3.append(r11)     // Catch:{ all -> 0x028a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x028a }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r3)     // Catch:{ all -> 0x028a }
            goto L_0x0204
        L_0x01f3:
            java.lang.String r3 = "[CrossPromotion] App was installed via %s's Cross Promotion"
            java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ all -> 0x028a }
            java.lang.Object r12 = r4.get(r2)     // Catch:{ all -> 0x028a }
            r11[r10] = r12     // Catch:{ all -> 0x028a }
            java.lang.String r3 = java.lang.String.format(r3, r11)     // Catch:{ all -> 0x028a }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r3)     // Catch:{ all -> 0x028a }
        L_0x0204:
            boolean r2 = r4.containsKey(r2)     // Catch:{ all -> 0x028a }
            if (r2 == 0) goto L_0x021d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x028a }
            r2.<init>(r5)     // Catch:{ all -> 0x028a }
            java.lang.Object r3 = r4.get(r7)     // Catch:{ all -> 0x028a }
            r2.append(r3)     // Catch:{ all -> 0x028a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x028a }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r2)     // Catch:{ all -> 0x028a }
        L_0x021d:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x028a }
            r4.put(r0, r2)     // Catch:{ all -> 0x028a }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x028a }
            r2.<init>(r4)     // Catch:{ all -> 0x028a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x028a }
            java.lang.String r3 = "attributionId"
            if (r2 == 0) goto L_0x0235
            android.app.Application r5 = r1.valueOf     // Catch:{ all -> 0x028a }
            com.appsflyer.internal.C1387af.AFInAppEventParameterName((android.content.Context) r5, (java.lang.String) r3, (java.lang.String) r2)     // Catch:{ all -> 0x028a }
            goto L_0x023a
        L_0x0235:
            android.app.Application r2 = r1.valueOf     // Catch:{ all -> 0x028a }
            com.appsflyer.internal.C1387af.AFInAppEventParameterName((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r13)     // Catch:{ all -> 0x028a }
        L_0x023a:
            com.appsflyer.AppsFlyerConversionListener r2 = com.appsflyer.internal.C1387af.AFKeystoreWrapper     // Catch:{ all -> 0x028a }
            if (r2 == 0) goto L_0x0281
            java.util.concurrent.atomic.AtomicInteger r2 = r1.init     // Catch:{ all -> 0x028a }
            int r2 = r2.intValue()     // Catch:{ all -> 0x028a }
            if (r2 > r9) goto L_0x0281
            android.app.Application r2 = r1.valueOf     // Catch:{ bb -> 0x0261 }
            java.util.Map r2 = com.appsflyer.internal.C1432ay.values(r2)     // Catch:{ bb -> 0x0261 }
            android.app.Application r3 = r1.valueOf     // Catch:{ bb -> 0x0261 }
            android.content.SharedPreferences r3 = com.appsflyer.internal.C1387af.AFInAppEventType((android.content.Context) r3)     // Catch:{ bb -> 0x0261 }
            java.lang.String r5 = "sixtyDayConversionData"
            boolean r3 = r3.getBoolean(r5, r10)     // Catch:{ bb -> 0x0261 }
            if (r3 != 0) goto L_0x025f
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ bb -> 0x0261 }
            r2.put(r0, r3)     // Catch:{ bb -> 0x0261 }
        L_0x025f:
            r4 = r2
            goto L_0x0267
        L_0x0261:
            r0 = move-exception
            java.lang.String r2 = "Exception while trying to fetch attribution data. "
            com.appsflyer.AFLogger.values(r2, r0)     // Catch:{ all -> 0x028a }
        L_0x0267:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x028a }
            java.lang.String r2 = "[GCD-A02] Calling onConversionDataSuccess with:\n"
            r0.<init>(r2)     // Catch:{ all -> 0x028a }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x028a }
            r0.append(r2)     // Catch:{ all -> 0x028a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x028a }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0)     // Catch:{ all -> 0x028a }
            com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.internal.C1387af.AFKeystoreWrapper     // Catch:{ all -> 0x028a }
            r0.onConversionDataSuccess(r4)     // Catch:{ all -> 0x028a }
        L_0x0281:
            java.util.concurrent.atomic.AtomicInteger r0 = r1.init
            r0.decrementAndGet()
            r8.disconnect()
            goto L_0x02b9
        L_0x028a:
            r0 = move-exception
            r3 = r8
            goto L_0x028e
        L_0x028d:
            r0 = move-exception
        L_0x028e:
            int r2 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x02c4 }
            if (r2 >= r6) goto L_0x02a1
            com.appsflyer.internal.ba r2 = new com.appsflyer.internal.ba     // Catch:{ all -> 0x02c4 }
            r2.<init>(r1)     // Catch:{ all -> 0x02c4 }
            java.util.concurrent.ScheduledExecutorService r4 = r2.AFInAppEventParameterName     // Catch:{ all -> 0x02c4 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x02c4 }
            r6 = 10
            com.appsflyer.internal.C1387af.AFInAppEventParameterName(r4, r2, r6, r5)     // Catch:{ all -> 0x02c4 }
            goto L_0x02a8
        L_0x02a1:
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x02c4 }
            values(r2)     // Catch:{ all -> 0x02c4 }
        L_0x02a8:
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x02c4 }
            com.appsflyer.AFLogger.values(r2, r0)     // Catch:{ all -> 0x02c4 }
            java.util.concurrent.atomic.AtomicInteger r0 = r1.init
            r0.decrementAndGet()
            if (r3 == 0) goto L_0x02b9
            r3.disconnect()
        L_0x02b9:
            java.util.concurrent.ScheduledExecutorService r0 = r1.AFInAppEventParameterName
            r0.shutdown()
            java.lang.String r0 = "[GCD-A03] Server retrieving attempt finished"
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0)
            return
        L_0x02c4:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicInteger r2 = r1.init
            r2.decrementAndGet()
            if (r3 == 0) goto L_0x02cf
            r3.disconnect()
        L_0x02cf:
            throw r0
        L_0x02d0:
            java.lang.String r0 = "[GCD-E05] AppsFlyer dev key is missing"
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0)
            java.lang.String r0 = "AppsFlyer dev key is missing"
            values(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1436ba.run():void");
    }

    public C1436ba(C1436ba baVar) {
        if (C1486n.valueOf == null) {
            C1486n.valueOf = new C1486n();
        }
        this.AFInAppEventParameterName = C1486n.valueOf.values();
        this.init = new AtomicInteger(0);
        this.AFVersionDeclaration = baVar.AFVersionDeclaration;
        this.valueOf = baVar.valueOf;
        this.AFKeystoreWrapper = baVar.AFKeystoreWrapper;
        this.AFLogger$LogLevel = baVar.AFLogger$LogLevel + 1;
    }
}
