package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.appsflyer.internal.bq */
public class C1452bq extends C1461bw {
    public final Map<String, Object> values = new HashMap();

    public C1452bq(Runnable runnable) {
        super("google", runnable);
    }

    public static boolean AFKeystoreWrapper(@NonNull Context context) {
        C1387af.AFInAppEventParameterName();
        if (C1387af.AFInAppEventParameterName(C1387af.AFInAppEventType(context), "appsFlyerCount", false) > 0) {
            AFLogger.AFKeystoreWrapper("Install referrer will not load, the counter > 1, ");
            return false;
        }
        try {
            Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            if (C1381ac.values(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.AFInAppEventType("Install referrer is allowed");
                return true;
            }
            AFLogger.AFInAppEventType("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder("Class ");
            sb.append("com.android.installreferrer.api.InstallReferrerClient");
            sb.append(" not found");
            AFLogger.AFKeystoreWrapper(sb.toString());
            return false;
        } catch (Throwable th) {
            AFLogger.values("An error occurred while trying to verify manifest : ".concat("com.android.installreferrer.api.InstallReferrerClient"), th);
            return false;
        }
    }

    public final void AFInAppEventType(final Context context) {
        if (AFKeystoreWrapper(context)) {
            values();
            try {
                final InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
                AFLogger.AFInAppEventType("Connecting to Install Referrer Library...");
                build.startConnection(new InstallReferrerStateListener() {
                    public final void onInstallReferrerServiceDisconnected() {
                        AFLogger.AFInAppEventType("Install Referrer service disconnected");
                    }

                    /* JADX WARNING: Can't wrap try/catch for region: R(11:17|(1:19)|20|21|22|23|25|26|27|28|(1:30)) */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x012c */
                    /* JADX WARNING: Removed duplicated region for block: B:30:0x0132 A[Catch:{ all -> 0x0147 }] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void onInstallReferrerSetupFinished(int r9) {
                        /*
                            r8 = this;
                            java.lang.String r0 = "instant"
                            java.lang.String r1 = "ReferrerClient: InstallReferrer is not ready"
                            java.lang.String r2 = "err"
                            com.appsflyer.internal.bq r3 = com.appsflyer.internal.C1452bq.this
                            java.util.Map<java.lang.String, java.lang.Object> r3 = r3.values
                            java.lang.String r4 = java.lang.String.valueOf(r9)
                            java.lang.String r5 = "code"
                            r3.put(r5, r4)
                            com.appsflyer.internal.bq r3 = com.appsflyer.internal.C1452bq.this
                            java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFKeystoreWrapper
                            android.content.Context r4 = r3
                            java.lang.String r5 = "com.android.vending"
                            long r6 = com.appsflyer.internal.C1381ac.AFKeystoreWrapper(r4, r5)
                            java.lang.Long r4 = java.lang.Long.valueOf(r6)
                            java.lang.String r6 = "api_ver"
                            r3.put(r6, r4)
                            com.appsflyer.internal.bq r3 = com.appsflyer.internal.C1452bq.this
                            java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFKeystoreWrapper
                            android.content.Context r4 = r3
                            java.lang.String r4 = com.appsflyer.internal.C1381ac.AFInAppEventParameterName(r4, r5)
                            java.lang.String r5 = "api_ver_name"
                            r3.put(r5, r4)
                            r3 = -1
                            java.lang.String r4 = "response"
                            if (r9 == r3) goto L_0x0168
                            if (r9 == 0) goto L_0x007e
                            r0 = 1
                            if (r9 == r0) goto L_0x006e
                            r0 = 2
                            if (r9 == r0) goto L_0x005e
                            r0 = 3
                            if (r9 == r0) goto L_0x004e
                            java.lang.String r9 = "responseCode not found."
                            com.appsflyer.AFLogger.AFVersionDeclaration(r9)
                            goto L_0x0176
                        L_0x004e:
                            java.lang.String r9 = "InstallReferrer DEVELOPER_ERROR"
                            com.appsflyer.AFLogger.AFVersionDeclaration(r9)
                            com.appsflyer.internal.bq r9 = com.appsflyer.internal.C1452bq.this
                            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.AFKeystoreWrapper
                            java.lang.String r0 = "DEVELOPER_ERROR"
                            r9.put(r4, r0)
                            goto L_0x0176
                        L_0x005e:
                            java.lang.String r9 = "InstallReferrer FEATURE_NOT_SUPPORTED"
                            com.appsflyer.AFLogger.AFVersionDeclaration(r9)
                            com.appsflyer.internal.bq r9 = com.appsflyer.internal.C1452bq.this
                            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.AFKeystoreWrapper
                            java.lang.String r0 = "FEATURE_NOT_SUPPORTED"
                            r9.put(r4, r0)
                            goto L_0x0176
                        L_0x006e:
                            com.appsflyer.internal.bq r9 = com.appsflyer.internal.C1452bq.this
                            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.AFKeystoreWrapper
                            java.lang.String r0 = "SERVICE_UNAVAILABLE"
                            r9.put(r4, r0)
                            java.lang.String r9 = "InstallReferrer not supported"
                            com.appsflyer.AFLogger.AFVersionDeclaration(r9)
                            goto L_0x0176
                        L_0x007e:
                            com.appsflyer.internal.bq r9 = com.appsflyer.internal.C1452bq.this
                            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.AFKeystoreWrapper
                            java.lang.String r3 = "OK"
                            r9.put(r4, r3)
                            java.lang.String r9 = "InstallReferrer connected"
                            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r9)     // Catch:{ all -> 0x0147 }
                            com.android.installreferrer.api.InstallReferrerClient r9 = r0     // Catch:{ all -> 0x0147 }
                            boolean r9 = r9.isReady()     // Catch:{ all -> 0x0147 }
                            if (r9 == 0) goto L_0x013c
                            com.android.installreferrer.api.InstallReferrerClient r9 = r0     // Catch:{ all -> 0x0147 }
                            com.android.installreferrer.api.ReferrerDetails r9 = r9.getInstallReferrer()     // Catch:{ all -> 0x0147 }
                            java.lang.String r1 = r9.getInstallReferrer()     // Catch:{ all -> 0x0147 }
                            if (r1 == 0) goto L_0x00b2
                            com.appsflyer.internal.bq r3 = com.appsflyer.internal.C1452bq.this     // Catch:{ all -> 0x0147 }
                            java.util.Map<java.lang.String, java.lang.Object> r3 = r3.values     // Catch:{ all -> 0x0147 }
                            java.lang.String r4 = "val"
                            r3.put(r4, r1)     // Catch:{ all -> 0x0147 }
                            com.appsflyer.internal.bq r3 = com.appsflyer.internal.C1452bq.this     // Catch:{ all -> 0x0147 }
                            java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFKeystoreWrapper     // Catch:{ all -> 0x0147 }
                            java.lang.String r4 = "referrer"
                            r3.put(r4, r1)     // Catch:{ all -> 0x0147 }
                        L_0x00b2:
                            long r3 = r9.getReferrerClickTimestampSeconds()     // Catch:{ all -> 0x0147 }
                            com.appsflyer.internal.bq r1 = com.appsflyer.internal.C1452bq.this     // Catch:{ all -> 0x0147 }
                            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.values     // Catch:{ all -> 0x0147 }
                            java.lang.String r5 = "clk"
                            java.lang.String r6 = java.lang.Long.toString(r3)     // Catch:{ all -> 0x0147 }
                            r1.put(r5, r6)     // Catch:{ all -> 0x0147 }
                            com.appsflyer.internal.bq r1 = com.appsflyer.internal.C1452bq.this     // Catch:{ all -> 0x0147 }
                            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0147 }
                            java.lang.String r5 = "click_ts"
                            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0147 }
                            r1.put(r5, r3)     // Catch:{ all -> 0x0147 }
                            long r3 = r9.getInstallBeginTimestampSeconds()     // Catch:{ all -> 0x0147 }
                            com.appsflyer.internal.bq r1 = com.appsflyer.internal.C1452bq.this     // Catch:{ all -> 0x0147 }
                            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.values     // Catch:{ all -> 0x0147 }
                            java.lang.String r5 = "install"
                            java.lang.String r6 = java.lang.Long.toString(r3)     // Catch:{ all -> 0x0147 }
                            r1.put(r5, r6)     // Catch:{ all -> 0x0147 }
                            com.appsflyer.internal.bq r1 = com.appsflyer.internal.C1452bq.this     // Catch:{ all -> 0x0147 }
                            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0147 }
                            java.lang.String r5 = "install_begin_ts"
                            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0147 }
                            r1.put(r5, r3)     // Catch:{ all -> 0x0147 }
                            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0147 }
                            r1.<init>()     // Catch:{ all -> 0x0147 }
                            boolean r3 = r9.getGooglePlayInstantParam()     // Catch:{ NoSuchMethodError -> 0x0109 }
                            com.appsflyer.internal.bq r4 = com.appsflyer.internal.C1452bq.this     // Catch:{ NoSuchMethodError -> 0x0109 }
                            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.values     // Catch:{ NoSuchMethodError -> 0x0109 }
                            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)     // Catch:{ NoSuchMethodError -> 0x0109 }
                            r4.put(r0, r5)     // Catch:{ NoSuchMethodError -> 0x0109 }
                            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ NoSuchMethodError -> 0x0109 }
                            r1.put(r0, r3)     // Catch:{ NoSuchMethodError -> 0x0109 }
                        L_0x0109:
                            java.lang.String r0 = "click_server_ts"
                            long r3 = r9.getReferrerClickTimestampServerSeconds()     // Catch:{ NoSuchMethodError -> 0x012c }
                            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ NoSuchMethodError -> 0x012c }
                            r1.put(r0, r3)     // Catch:{ NoSuchMethodError -> 0x012c }
                            java.lang.String r0 = "install_begin_server_ts"
                            long r3 = r9.getInstallBeginTimestampServerSeconds()     // Catch:{ NoSuchMethodError -> 0x012c }
                            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ NoSuchMethodError -> 0x012c }
                            r1.put(r0, r3)     // Catch:{ NoSuchMethodError -> 0x012c }
                            java.lang.String r0 = "install_version"
                            java.lang.String r9 = r9.getInstallVersion()     // Catch:{ NoSuchMethodError -> 0x012c }
                            r1.put(r0, r9)     // Catch:{ NoSuchMethodError -> 0x012c }
                        L_0x012c:
                            boolean r9 = r1.isEmpty()     // Catch:{ all -> 0x0147 }
                            if (r9 != 0) goto L_0x0176
                            com.appsflyer.internal.bq r9 = com.appsflyer.internal.C1452bq.this     // Catch:{ all -> 0x0147 }
                            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.AFKeystoreWrapper     // Catch:{ all -> 0x0147 }
                            java.lang.String r0 = "google_custom"
                            r9.put(r0, r1)     // Catch:{ all -> 0x0147 }
                            goto L_0x0176
                        L_0x013c:
                            com.appsflyer.AFLogger.AFVersionDeclaration(r1)     // Catch:{ all -> 0x0147 }
                            com.appsflyer.internal.bq r9 = com.appsflyer.internal.C1452bq.this     // Catch:{ all -> 0x0147 }
                            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.values     // Catch:{ all -> 0x0147 }
                            r9.put(r2, r1)     // Catch:{ all -> 0x0147 }
                            goto L_0x0176
                        L_0x0147:
                            r9 = move-exception
                            java.lang.String r0 = "Failed to get install referrer: "
                            java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r0)
                            java.lang.String r1 = r9.getMessage()
                            r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            com.appsflyer.AFLogger.AFVersionDeclaration(r0)
                            com.appsflyer.internal.bq r0 = com.appsflyer.internal.C1452bq.this
                            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.values
                            java.lang.String r9 = r9.getMessage()
                            r0.put(r2, r9)
                            goto L_0x0176
                        L_0x0168:
                            java.lang.String r9 = "InstallReferrer SERVICE_DISCONNECTED"
                            com.appsflyer.AFLogger.AFVersionDeclaration(r9)
                            com.appsflyer.internal.bq r9 = com.appsflyer.internal.C1452bq.this
                            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.AFKeystoreWrapper
                            java.lang.String r0 = "SERVICE_DISCONNECTED"
                            r9.put(r4, r0)
                        L_0x0176:
                            java.lang.String r9 = "Install Referrer collected locally"
                            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r9)
                            com.appsflyer.internal.bq r9 = com.appsflyer.internal.C1452bq.this
                            r9.AFKeystoreWrapper()
                            com.android.installreferrer.api.InstallReferrerClient r9 = r0
                            r9.endConnection()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1452bq.C14532.onInstallReferrerSetupFinished(int):void");
                    }
                });
            } catch (Throwable th) {
                AFLogger.values("referrerClient -> startConnection", th);
            }
        }
    }
}
