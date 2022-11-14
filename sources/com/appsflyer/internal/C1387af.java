package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AFVersionDeclaration;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.C1400ah;
import com.appsflyer.internal.C1418aq;
import com.appsflyer.internal.C1461bw;
import com.appsflyer.internal.C1471d;
import com.appsflyer.internal.C1483m;
import com.appsflyer.internal.C1489u;
import com.appsflyer.internal.C1497y;
import com.facebook.LegacyTokenHelper;
import com.facebook.applinks.AppLinkData;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.VideoUploader;
import com.google.android.gms.common.GoogleApiAvailability;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.p042db.legacy_profile.tables.ProfileTable;
import com.swrve.sdk.SwrveImp;
import com.vungle.warren.VisionController;
import com.vungle.warren.VungleApiClient;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.af */
public final class C1387af extends AppsFlyerLib {
    public static final String AFInAppEventParameterName = "6.3";
    public static final String AFInAppEventType;
    public static AppsFlyerConversionListener AFKeystoreWrapper = null;
    public static String onAppOpenAttribution = null;
    public static String onAppOpenAttributionNative = "https://%sstats.%s/stats";
    @VisibleForTesting
    public static C1387af onAttributionFailure = new C1387af();
    @VisibleForTesting
    public static String onConversionDataFail = null;
    public static String onConversionDataSuccess = null;
    public static final String onDeepLinkingNative;
    public static String onInstallConversionDataLoadedNative = null;
    public static String onInstallConversionFailureNative = null;
    public static AppsFlyerInAppPurchaseValidatorListener valueOf = null;
    public static final String values = "98";
    public C1430aw AFLogger$LogLevel;
    public String AFVersionDeclaration;
    public String AppsFlyer2dXConversionCallback;
    public boolean AppsFlyerConversionListener = false;
    public long AppsFlyerInAppPurchaseValidatorListener = TimeUnit.SECONDS.toMillis(5);
    public ScheduledExecutorService AppsFlyerLib = null;
    public final C1408aj enableLocationCollection = new C1408aj();
    public String getInstance;
    @VisibleForTesting
    public long getLevel;
    public Map<String, Object> getOutOfStore;
    public boolean getSdkVersion = false;
    public String[] init;
    @Nullable
    public C1461bw[] onAttributionFailureNative;
    public long onDeepLinking = -1;
    public Map<Long, String> onPause;
    public long onValidateInApp = -1;
    public long onValidateInAppFailure;
    public final JSONObject setAdditionalData = new JSONObject();
    public boolean setAndroidIdData;
    public C1427au setAppInviteOneLink;
    public String setCustomerIdAndLogSession;
    public boolean setCustomerUserId = false;
    public boolean setDebugLog = false;
    public Application setImeiData;
    public boolean setOaidData = false;
    public boolean setPhoneNumber = false;
    public SharedPreferences setUserEmails;
    public boolean stop;
    public long updateServerUninstallToken;
    public Map<String, Object> waitForCustomerUserId;

    /* renamed from: com.appsflyer.internal.af$7 */
    public static /* synthetic */ class C13957 {
        public static final /* synthetic */ int[] AFInAppEventParameterName;
        public static final /* synthetic */ int[] AFKeystoreWrapper;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
        static {
            /*
                com.appsflyer.internal.bw$d[] r0 = com.appsflyer.internal.C1461bw.C1463d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                AFKeystoreWrapper = r0
                r1 = 2
                r2 = 1
                com.appsflyer.internal.bw$d r3 = com.appsflyer.internal.C1461bw.C1463d.FINISHED     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = AFKeystoreWrapper     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.appsflyer.internal.bw$d r3 = com.appsflyer.internal.C1461bw.C1463d.STARTED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                AFInAppEventParameterName = r0
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r3 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                int[] r0 = AFInAppEventParameterName     // Catch:{ NoSuchFieldError -> 0x0029 }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r2 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x0029 }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1387af.C13957.<clinit>():void");
        }
    }

    /* renamed from: com.appsflyer.internal.af$a */
    public class C1396a implements Runnable {
        public final C1480h AFInAppEventType;

        public /* synthetic */ C1396a(C1387af afVar, C1480h hVar, byte b) {
            this(hVar);
        }

        public final void run() {
            C1387af.AFInAppEventParameterName(C1387af.this, this.AFInAppEventType);
        }

        public C1396a(C1480h hVar) {
            this.AFInAppEventType = hVar;
        }
    }

    /* renamed from: com.appsflyer.internal.af$b */
    public class C1397b implements Runnable {
        public final Application AFKeystoreWrapper;

        public C1397b(Context context) {
            this.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }

        public final void run() {
            if (!C1387af.this.AppsFlyerConversionListener) {
                C1387af.this.getLevel = System.currentTimeMillis();
                boolean unused = C1387af.this.AppsFlyerConversionListener = true;
                try {
                    String valueOf2 = C1387af.valueOf(AppsFlyerProperties.AF_KEY);
                    C1399ag.AFInAppEventType();
                    for (C1481i next : C1399ag.values(this.AFKeystoreWrapper)) {
                        StringBuilder sb = new StringBuilder("resending request: ");
                        sb.append(next.AFInAppEventType);
                        AFLogger.AFInAppEventParameterName(sb.toString());
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            long parseLong = Long.parseLong(next.valueOf, 10);
                            C1387af afVar = C1387af.this;
                            C1440be beVar = new C1440be();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(next.AFInAppEventType);
                            sb2.append("&isCachedRequest=true&timeincache=");
                            sb2.append((currentTimeMillis - parseLong) / 1000);
                            C1480h values = beVar.values(sb2.toString());
                            values.getLevel = next.values();
                            values.AFLogger$LogLevel = valueOf2;
                            Application application = this.AFKeystoreWrapper;
                            if (application != null) {
                                values.valueOf = (Application) application.getApplicationContext();
                            }
                            values.init = next.valueOf;
                            values.onInstallConversionDataLoadedNative = false;
                            C1387af.AFKeystoreWrapper(afVar, values);
                        } catch (Exception e) {
                            AFLogger.values("Failed to resend cached request", e);
                        }
                    }
                } catch (Exception e2) {
                    AFLogger.values("failed to check cache. ", e2);
                } catch (Throwable th) {
                    boolean unused2 = C1387af.this.AppsFlyerConversionListener = false;
                    throw th;
                }
                boolean unused3 = C1387af.this.AppsFlyerConversionListener = false;
                C1387af.this.AppsFlyerLib.shutdown();
                ScheduledExecutorService unused4 = C1387af.this.AppsFlyerLib = null;
            }
        }
    }

    /* renamed from: com.appsflyer.internal.af$c */
    public class C1398c implements Runnable {
        public final C1480h values;

        public /* synthetic */ C1398c(C1387af afVar, C1480h hVar, byte b) {
            this(hVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: byte[]} */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x021a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x021b, code lost:
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x022d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x022e, code lost:
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x0239, code lost:
            r0.onError(com.appsflyer.attribution.RequestError.NETWORK_FAILURE, r12.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0151, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0152, code lost:
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0.getMessage(), r0);
            r2 = r1.values.values;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x015d, code lost:
            if (r2 != null) goto L_0x015f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x015f, code lost:
            r2.onError(com.appsflyer.attribution.RequestError.NETWORK_FAILURE, r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0169, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x016a, code lost:
            r12 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0190, code lost:
            r2.mkdir();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0195, code lost:
            r2 = r2.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0199, code lost:
            if (r2 == null) goto L_0x01a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a0, code lost:
            com.appsflyer.AFLogger.AFInAppEventParameterName("reached cache limit, not caching request");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a7, code lost:
            com.appsflyer.AFLogger.AFInAppEventParameterName("caching request...");
            r2 = new java.io.File(com.appsflyer.internal.C1399ag.valueOf(r9), java.lang.Long.toString(java.lang.System.currentTimeMillis()));
            r2.createNewFile();
            r4 = new java.io.OutputStreamWriter(new java.io.FileOutputStream(r2.getPath(), true));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            r4.write("version=");
            r4.write(r0.AFInAppEventParameterName);
            r4.write(10);
            r4.write("url=");
            r4.write(r0.AFInAppEventType);
            r4.write(10);
            r4.write("data=");
            r4.write(android.util.Base64.encodeToString(r0.values(), 2));
            r4.write(10);
            r4.flush();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0204, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0205, code lost:
            r2 = r0;
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0208, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0209, code lost:
            r3 = r4;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x0216 A[SYNTHETIC, Splitter:B:100:0x0216] */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0229 A[SYNTHETIC, Splitter:B:106:0x0229] */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0239  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0151 A[ExcHandler: all (r0v23 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:32:0x00de] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0190 A[Catch:{ Exception -> 0x020e }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0195 A[Catch:{ Exception -> 0x020e }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r16 = this;
                r1 = r16
                com.appsflyer.internal.h r0 = r1.values
                java.util.Map r2 = r0.valueOf()
                com.appsflyer.internal.h r0 = r1.values
                boolean r0 = r0.AFInAppEventType()
                com.appsflyer.internal.h r3 = r1.values
                java.lang.String r4 = r3.onInstallConversionFailureNative
                int r5 = r3.onDeepLinkingNative
                android.app.Application r9 = r3.valueOf
                com.appsflyer.internal.af r3 = com.appsflyer.internal.C1387af.this
                boolean r3 = r3.isStopped()
                if (r3 == 0) goto L_0x002c
                com.appsflyer.internal.h r0 = r1.values
                com.appsflyer.attribution.AppsFlyerRequestListener r0 = r0.values
                if (r0 == 0) goto L_0x002b
                int r2 = com.appsflyer.attribution.RequestError.STOP_TRACKING
                java.lang.String r3 = com.appsflyer.internal.C1426at.AFInAppEventType
                r0.onError(r2, r3)
            L_0x002b:
                return
            L_0x002c:
                r3 = 0
                byte[] r6 = new byte[r3]
                r7 = 2
                r8 = 1
                if (r0 == 0) goto L_0x00c6
                if (r5 > r7) goto L_0x00c6
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                com.appsflyer.internal.af r10 = com.appsflyer.internal.C1387af.this
                com.appsflyer.internal.bw[] r10 = r10.onAttributionFailureNative
                if (r10 == 0) goto L_0x00a8
                com.appsflyer.internal.af r10 = com.appsflyer.internal.C1387af.this
                com.appsflyer.internal.bw[] r10 = r10.onAttributionFailureNative
                int r11 = r10.length
                r12 = 0
            L_0x004a:
                if (r12 >= r11) goto L_0x00a8
                r13 = r10[r12]
                boolean r14 = r13 instanceof com.appsflyer.internal.C1452bq
                int[] r15 = com.appsflyer.internal.C1387af.C13957.AFKeystoreWrapper
                com.appsflyer.internal.bw$d r3 = r13.AFInAppEventType
                int r3 = r3.ordinal()
                r3 = r15[r3]
                if (r3 == r8) goto L_0x0082
                if (r3 == r7) goto L_0x005f
                goto L_0x00a4
            L_0x005f:
                if (r5 != r7) goto L_0x00a4
                if (r14 != 0) goto L_0x00a4
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.lang.String r14 = "source"
                java.lang.String r13 = r13.valueOf
                r3.put(r14, r13)
                java.lang.String r13 = "response"
                java.lang.String r14 = "TIMEOUT"
                r3.put(r13, r14)
                com.appsflyer.internal.bs r13 = new com.appsflyer.internal.bs
                r13.<init>()
                r3.putAll(r13)
                r0.add(r3)
                goto L_0x00a4
            L_0x0082:
                if (r14 == 0) goto L_0x009f
                java.lang.String r3 = "rfr"
                r14 = r13
                com.appsflyer.internal.bq r14 = (com.appsflyer.internal.C1452bq) r14
                java.util.Map<java.lang.String, java.lang.Object> r14 = r14.values
                r2.put(r3, r14)
                android.content.SharedPreferences r3 = com.appsflyer.internal.C1387af.AFInAppEventType((android.content.Context) r9)
                android.content.SharedPreferences$Editor r3 = r3.edit()
                java.lang.String r14 = "newGPReferrerSent"
                android.content.SharedPreferences$Editor r3 = r3.putBoolean(r14, r8)
                r3.apply()
            L_0x009f:
                java.util.Map<java.lang.String, java.lang.Object> r3 = r13.AFKeystoreWrapper
                r0.add(r3)
            L_0x00a4:
                int r12 = r12 + 1
                r3 = 0
                goto L_0x004a
            L_0x00a8:
                boolean r3 = r0.isEmpty()
                if (r3 != 0) goto L_0x00b3
                java.lang.String r3 = "referrers"
                r2.put(r3, r0)
            L_0x00b3:
                com.appsflyer.internal.af r0 = com.appsflyer.internal.C1387af.this
                java.util.Map r0 = r0.waitForCustomerUserId
                if (r0 == 0) goto L_0x00c6
                java.lang.String r0 = "fb_ddl"
                com.appsflyer.internal.af r3 = com.appsflyer.internal.C1387af.this
                java.util.Map r3 = r3.waitForCustomerUserId
                r2.put(r0, r3)
            L_0x00c6:
                com.appsflyer.internal.h r0 = r1.values
                boolean r0 = r0 instanceof com.appsflyer.internal.C1441bf
                if (r0 != 0) goto L_0x00dd
                com.appsflyer.internal.d$a r0 = new com.appsflyer.internal.d$a
                r0.<init>(r2, r9)
                r2.putAll(r0)
                com.appsflyer.internal.af r0 = com.appsflyer.internal.C1387af.this
                java.util.Map r0 = r0.valueOf()
                r2.putAll(r0)
            L_0x00dd:
                r3 = 0
                com.appsflyer.internal.h r0 = r1.values     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
                com.appsflyer.internal.h r5 = r1.values     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
                boolean r5 = r5 instanceof com.appsflyer.internal.C1441bf     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
                if (r5 == 0) goto L_0x00ef
                java.lang.String r5 = "af_key"
                java.lang.Object r5 = r2.get(r5)     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
                goto L_0x00f7
            L_0x00ef:
                java.lang.String r5 = "appsflyerKey"
                java.lang.Object r5 = r2.get(r5)     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
            L_0x00f7:
                r0.AFLogger$LogLevel = r5     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
                monitor-enter(r2)     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
                com.appsflyer.internal.h r0 = r1.values     // Catch:{ all -> 0x014e }
                java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0145 }
                r10 = 0
                r5[r10] = r0     // Catch:{ all -> 0x0145 }
                r0 = 0
                float r11 = android.util.TypedValue.complexToFraction(r10, r0, r0)     // Catch:{ all -> 0x0145 }
                int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
                int r0 = r0 + 48
                int r10 = android.os.Process.myTid()     // Catch:{ all -> 0x0145 }
                int r10 = r10 >> 22
                char r10 = (char) r10     // Catch:{ all -> 0x0145 }
                int r11 = android.view.ViewConfiguration.getScrollBarSize()     // Catch:{ all -> 0x0145 }
                int r11 = r11 >> 8
                int r11 = r11 + 24
                java.lang.Object r0 = com.appsflyer.internal.C1435b.values(r0, r10, r11)     // Catch:{ all -> 0x0145 }
                java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x0145 }
                java.lang.String r10 = "AFInAppEventType"
                java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ all -> 0x0145 }
                java.lang.Class<com.appsflyer.internal.h> r12 = com.appsflyer.internal.C1480h.class
                r13 = 0
                r11[r13] = r12     // Catch:{ all -> 0x0145 }
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r10, r11)     // Catch:{ all -> 0x0145 }
                java.lang.Object r0 = r0.invoke(r3, r5)     // Catch:{ all -> 0x0145 }
                r5 = r0
                byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x0145 }
                monitor-exit(r2)     // Catch:{ all -> 0x0142 }
                com.appsflyer.internal.af r0 = com.appsflyer.internal.C1387af.this     // Catch:{ IOException -> 0x013e, all -> 0x0151 }
                com.appsflyer.internal.h r2 = r1.values     // Catch:{ IOException -> 0x013e, all -> 0x0151 }
                r2.getLevel = r5     // Catch:{ IOException -> 0x013e, all -> 0x0151 }
                com.appsflyer.internal.C1387af.AFKeystoreWrapper((com.appsflyer.internal.C1387af) r0, (com.appsflyer.internal.C1480h) r2)     // Catch:{ IOException -> 0x013e, all -> 0x0151 }
                return
            L_0x013e:
                r0 = move-exception
                r12 = r0
                r6 = r5
                goto L_0x016b
            L_0x0142:
                r0 = move-exception
                r6 = r5
                goto L_0x014f
            L_0x0145:
                r0 = move-exception
                java.lang.Throwable r5 = r0.getCause()     // Catch:{ all -> 0x014e }
                if (r5 == 0) goto L_0x014d
                throw r5     // Catch:{ all -> 0x014e }
            L_0x014d:
                throw r0     // Catch:{ all -> 0x014e }
            L_0x014e:
                r0 = move-exception
            L_0x014f:
                monitor-exit(r2)     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
                throw r0     // Catch:{ IOException -> 0x0169, all -> 0x0151 }
            L_0x0151:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                com.appsflyer.AFLogger.AFInAppEventParameterName((java.lang.String) r2, (java.lang.Throwable) r0)
                com.appsflyer.internal.h r2 = r1.values
                com.appsflyer.attribution.AppsFlyerRequestListener r2 = r2.values
                if (r2 == 0) goto L_0x0168
                int r3 = com.appsflyer.attribution.RequestError.NETWORK_FAILURE
                java.lang.String r0 = r0.getMessage()
                r2.onError(r3, r0)
            L_0x0168:
                return
            L_0x0169:
                r0 = move-exception
                r12 = r0
            L_0x016b:
                java.lang.String r0 = "Exception while sending request to server. "
                com.appsflyer.AFLogger.values(r0, r12)
                if (r6 == 0) goto L_0x0233
                if (r9 == 0) goto L_0x0233
                java.lang.String r0 = "&isCachedRequest=true&timeincache="
                boolean r0 = r4.contains(r0)
                if (r0 != 0) goto L_0x0233
                com.appsflyer.internal.C1399ag.AFInAppEventType()
                com.appsflyer.internal.i r0 = new com.appsflyer.internal.i
                java.lang.String r2 = "6.3.0"
                r0.<init>(r4, r6, r2)
                java.io.File r2 = com.appsflyer.internal.C1399ag.valueOf(r9)     // Catch:{ Exception -> 0x020e }
                boolean r4 = r2.exists()     // Catch:{ Exception -> 0x020e }
                if (r4 != 0) goto L_0x0195
                r2.mkdir()     // Catch:{ Exception -> 0x020e }
                goto L_0x021f
            L_0x0195:
                java.io.File[] r2 = r2.listFiles()     // Catch:{ Exception -> 0x020e }
                if (r2 == 0) goto L_0x01a7
                int r2 = r2.length     // Catch:{ Exception -> 0x020e }
                r4 = 40
                if (r2 <= r4) goto L_0x01a7
                java.lang.String r0 = "reached cache limit, not caching request"
                com.appsflyer.AFLogger.AFInAppEventParameterName(r0)     // Catch:{ Exception -> 0x020e }
                goto L_0x021f
            L_0x01a7:
                java.lang.String r2 = "caching request..."
                com.appsflyer.AFLogger.AFInAppEventParameterName(r2)     // Catch:{ Exception -> 0x020e }
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x020e }
                java.io.File r4 = com.appsflyer.internal.C1399ag.valueOf(r9)     // Catch:{ Exception -> 0x020e }
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x020e }
                java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ Exception -> 0x020e }
                r2.<init>(r4, r5)     // Catch:{ Exception -> 0x020e }
                r2.createNewFile()     // Catch:{ Exception -> 0x020e }
                java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x020e }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x020e }
                java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x020e }
                r5.<init>(r2, r8)     // Catch:{ Exception -> 0x020e }
                r4.<init>(r5)     // Catch:{ Exception -> 0x020e }
                java.lang.String r2 = "version="
                r4.write(r2)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                java.lang.String r2 = r0.AFInAppEventParameterName     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                r4.write(r2)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                r2 = 10
                r4.write(r2)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                java.lang.String r3 = "url="
                r4.write(r3)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                java.lang.String r3 = r0.AFInAppEventType     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                r4.write(r3)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                r4.write(r2)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                java.lang.String r3 = "data="
                r4.write(r3)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                byte[] r0 = r0.values()     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                java.lang.String r0 = android.util.Base64.encodeToString(r0, r7)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                r4.write(r0)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                r4.write(r2)     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                r4.flush()     // Catch:{ Exception -> 0x0208, all -> 0x0204 }
                r4.close()     // Catch:{ IOException -> 0x021a }
                goto L_0x021f
            L_0x0204:
                r0 = move-exception
                r2 = r0
                r3 = r4
                goto L_0x0227
            L_0x0208:
                r0 = move-exception
                r3 = r4
                goto L_0x020f
            L_0x020b:
                r0 = move-exception
                r2 = r0
                goto L_0x0227
            L_0x020e:
                r0 = move-exception
            L_0x020f:
                java.lang.String r2 = "Could not cache request"
                com.appsflyer.AFLogger.values(r2, r0)     // Catch:{ all -> 0x020b }
                if (r3 == 0) goto L_0x021f
                r3.close()     // Catch:{ IOException -> 0x021a }
                goto L_0x021f
            L_0x021a:
                r0 = move-exception
                r2 = r0
                com.appsflyer.AFLogger.AFInAppEventType((java.lang.Throwable) r2)
            L_0x021f:
                java.lang.String r0 = r12.getMessage()
                com.appsflyer.AFLogger.values(r0, r12)
                goto L_0x0233
            L_0x0227:
                if (r3 == 0) goto L_0x0232
                r3.close()     // Catch:{ IOException -> 0x022d }
                goto L_0x0232
            L_0x022d:
                r0 = move-exception
                r3 = r0
                com.appsflyer.AFLogger.AFInAppEventType((java.lang.Throwable) r3)
            L_0x0232:
                throw r2
            L_0x0233:
                com.appsflyer.internal.h r0 = r1.values
                com.appsflyer.attribution.AppsFlyerRequestListener r0 = r0.values
                if (r0 == 0) goto L_0x0242
                int r2 = com.appsflyer.attribution.RequestError.NETWORK_FAILURE
                java.lang.String r3 = r12.getMessage()
                r0.onError(r2, r3)
            L_0x0242:
                com.appsflyer.internal.af r6 = com.appsflyer.internal.C1387af.this
                com.appsflyer.internal.h r7 = r1.values
                java.lang.String r8 = r7.AFLogger$LogLevel
                android.content.SharedPreferences r10 = com.appsflyer.internal.C1387af.AFInAppEventType((android.content.Context) r9)
                r11 = 0
                com.appsflyer.internal.C1432ay.AFKeystoreWrapper(r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1387af.C1398c.run():void");
        }

        public C1398c(C1480h hVar) {
            this.values = hVar;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(AFInAppEventParameterName);
        sb.append("/androidevent?buildnumber=6.3.0&app_id=");
        AFInAppEventType = sb.toString();
        StringBuilder sb2 = new StringBuilder("https://%sadrevenue.%s/api/v");
        sb2.append(AFInAppEventParameterName);
        sb2.append("/android?buildnumber=6.3.0&app_id=");
        onInstallConversionDataLoadedNative = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(AFInAppEventParameterName);
        sb3.append("/androidevent?app_id=");
        onDeepLinkingNative = sb3.toString();
        StringBuilder sb4 = new StringBuilder("https://%sconversions.%s/api/v");
        sb4.append(onDeepLinkingNative);
        onInstallConversionFailureNative = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%slaunches.%s/api/v");
        sb5.append(onDeepLinkingNative);
        onConversionDataSuccess = sb5.toString();
        StringBuilder sb6 = new StringBuilder("https://%sinapps.%s/api/v");
        sb6.append(onDeepLinkingNative);
        onAppOpenAttribution = sb6.toString();
        StringBuilder sb7 = new StringBuilder("https://%sattr.%s/api/v");
        sb7.append(onDeepLinkingNative);
        onConversionDataFail = sb7.toString();
    }

    @VisibleForTesting
    public C1387af() {
        AFVersionDeclaration.init();
    }

    public final void addPushNotificationDeepLinkPath(String... strArr) {
        List asList = Arrays.asList(strArr);
        List<List<String>> list = C1474f.AFInAppEventParameterName().AppsFlyer2dXConversionCallback;
        if (!list.contains(asList)) {
            list.add(asList);
        }
    }

    public final void anonymizeUser(boolean z) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "anonymizeUser", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        C1474f AFInAppEventParameterName2 = C1474f.AFInAppEventParameterName();
        AFInAppEventParameterName2.getLevel = str;
        AFInAppEventParameterName2.AFVersionDeclaration = map;
    }

    public final void enableFacebookDeferredApplinks(boolean z) {
        this.setCustomerUserId = z;
    }

    public final AppsFlyerLib enableLocationCollection(boolean z) {
        this.getSdkVersion = z;
        return this;
    }

    public final String getAppsFlyerUID(Context context) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "getAppsFlyerUID", new String[0]);
        return C1412ak.AFKeystoreWrapper(new WeakReference(context));
    }

    public final String getAttributionId(Context context) {
        try {
            return new C1386ae(context).AFKeystoreWrapper();
        } catch (Throwable th) {
            AFLogger.values("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    public final String getHostName() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host");
        return string != null ? string : "appsflyer.com";
    }

    public final String getHostPrefix() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host_prefix");
        return string != null ? string : "";
    }

    public final String getOutOfStore(Context context) {
        String str;
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        if (context == null) {
            str = null;
        } else {
            str = values("AF_STORE", context.getPackageManager(), context.getPackageName());
        }
        if (str != null) {
            return str;
        }
        AFLogger.AFInAppEventParameterName("No out-of-store value set");
        return null;
    }

    public final String getSdkVersion() {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "getSdkVersion", new String[0]);
        StringBuilder sb = new StringBuilder("version: 6.3.0 (build ");
        sb.append(values);
        sb.append(")");
        return sb.toString();
    }

    public final boolean isPreInstalledApp(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.values("Could not check if app is pre installed", e);
        }
    }

    public final boolean isStopped() {
        return this.setDebugLog;
    }

    public final void logEvent(@NonNull Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        HashMap hashMap;
        C1447bl blVar = new C1447bl();
        if (context != null) {
            blVar.valueOf = (Application) context.getApplicationContext();
        }
        blVar.AFVersionDeclaration = str;
        Activity activity = null;
        if (map == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(map);
        }
        blVar.AFKeystoreWrapper = hashMap;
        blVar.values = appsFlyerRequestListener;
        C1414am AFKeystoreWrapper2 = C1414am.AFKeystoreWrapper();
        String[] strArr = new String[2];
        strArr[0] = str;
        Map map2 = blVar.AFKeystoreWrapper;
        if (map2 == null) {
            map2 = new HashMap();
        }
        strArr[1] = new JSONObject(map2).toString();
        AFKeystoreWrapper2.valueOf("public_api_call", "logEvent", strArr);
        if (str != null) {
            C1500z.valueOf(context).valueOf();
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        AFKeystoreWrapper((C1480h) blVar, activity);
    }

    public final void logLocation(Context context, double d, double d2) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "logLocation", String.valueOf(d), String.valueOf(d2));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d2));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d));
        values(context, AFInAppEventType.LOCATION_COORDINATES, (Map<String, Object>) hashMap);
    }

    public final void logSession(Context context) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "logSession", new String[0]);
        C1414am.AFKeystoreWrapper().AFInAppEventParameterName = false;
        values(context, (String) null, (Map<String, Object>) null);
    }

    public final void onPause(Context context) {
        C1400ah.C1406e eVar = C1400ah.AFInAppEventType;
        if (eVar != null) {
            eVar.valueOf(context);
        }
    }

    public final void performOnAppAttribution(@NonNull Context context, @NonNull URI uri) {
        if (uri == null || uri.toString().isEmpty()) {
            StringBuilder sb = new StringBuilder("Link is \"");
            sb.append(uri);
            sb.append("\"");
            C1425as.AFInAppEventType(sb.toString());
        } else if (context == null) {
            StringBuilder sb2 = new StringBuilder("Context is \"");
            sb2.append(context);
            sb2.append("\"");
            C1425as.AFInAppEventType(sb2.toString());
        } else {
            C1474f.AFInAppEventParameterName().AFInAppEventType(context, new HashMap(), Uri.parse(uri.toString()));
        }
    }

    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "registerConversionListener", new String[0]);
        if (appsFlyerConversionListener != null) {
            AFKeystoreWrapper = appsFlyerConversionListener;
        }
    }

    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "registerValidatorListener", new String[0]);
        AFLogger.AFInAppEventType("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.AFInAppEventType("registerValidatorListener null listener");
        } else {
            valueOf = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    public final void sendAdRevenue(Context context, Map<String, Object> map) {
        C1441bf bfVar = new C1441bf();
        if (context != null) {
            bfVar.valueOf = (Application) context.getApplicationContext();
        }
        bfVar.AFKeystoreWrapper = map;
        Application application = bfVar.valueOf;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(String.format(onInstallConversionDataLoadedNative, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), onAttributionFailure.getHostName()}));
        outline24.append(application.getPackageName());
        String obj = outline24.toString();
        SharedPreferences AFInAppEventType2 = AFInAppEventType((Context) application);
        int AFInAppEventParameterName2 = AFInAppEventParameterName(AFInAppEventType2, "appsFlyerCount", false);
        int AFInAppEventParameterName3 = AFInAppEventParameterName(AFInAppEventType2, "appsFlyerAdRevenueCount", true);
        HashMap hashMap = new HashMap();
        hashMap.put("ad_network", bfVar.AFKeystoreWrapper);
        hashMap.put("adrevenue_counter", Integer.valueOf(AFInAppEventParameterName3));
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        hashMap.put("af_key", string);
        hashMap.put("launch_counter", Integer.valueOf(AFInAppEventParameterName2));
        hashMap.put("af_timestamp", Long.toString(new Date().getTime()));
        hashMap.put(ProfileTable.Columns.COLUMN_UID, C1412ak.AFKeystoreWrapper(new WeakReference(application)));
        String string2 = AppsFlyerProperties.getInstance().getString("advertiserId");
        hashMap.put("advertiserIdEnabled", AppsFlyerProperties.getInstance().getString("advertiserIdEnabled"));
        if (string2 != null) {
            hashMap.put("advertiserId", string2);
        }
        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Build.DEVICE);
        values((Context) application, (Map<String, Object>) hashMap);
        try {
            PackageInfo packageInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            long j = packageInfo.firstInstallTime;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("install_date", simpleDateFormat.format(new Date(j)));
            String string3 = AFInAppEventType2.getString("appsFlyerFirstInstall", (String) null);
            if (string3 == null) {
                string3 = values(simpleDateFormat, (Context) application);
            }
            hashMap.put("first_launch_date", string3);
        } catch (Throwable th) {
            AFLogger.values("AdRevenue - Exception while collecting app version data ", th);
        }
        C1480h AFKeystoreWrapper2 = bfVar.values(obj).AFKeystoreWrapper(hashMap);
        AFKeystoreWrapper2.onDeepLinkingNative = AFInAppEventParameterName2;
        AFKeystoreWrapper2.AFLogger$LogLevel = string;
        C1398c cVar = new C1398c(this, AFKeystoreWrapper2, (byte) 0);
        if (C1486n.valueOf == null) {
            C1486n.valueOf = new C1486n();
        }
        AFInAppEventParameterName(C1486n.valueOf.values(), cVar, 1, TimeUnit.MILLISECONDS);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPushNotificationData(@androidx.annotation.NonNull android.app.Activity r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "c"
            java.lang.String r2 = "pid"
            r3 = 1
            r4 = 0
            r5 = 2
            java.lang.String r6 = "public_api_call"
            java.lang.String r7 = "sendPushNotificationData"
            if (r17 == 0) goto L_0x003d
            android.content.Intent r8 = r17.getIntent()
            if (r8 == 0) goto L_0x003d
            com.appsflyer.internal.am r8 = com.appsflyer.internal.C1414am.AFKeystoreWrapper()
            java.lang.String[] r9 = new java.lang.String[r5]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r4] = r10
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r10 = "activity_intent_"
            r4.<init>(r10)
            android.content.Intent r10 = r17.getIntent()
            java.lang.String r10 = r10.toString()
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            r9[r3] = r4
            r8.valueOf(r6, r7, r9)
            goto L_0x0060
        L_0x003d:
            if (r17 == 0) goto L_0x0053
            com.appsflyer.internal.am r8 = com.appsflyer.internal.C1414am.AFKeystoreWrapper()
            java.lang.String[] r9 = new java.lang.String[r5]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r4] = r10
            java.lang.String r4 = "activity_intent_null"
            r9[r3] = r4
            r8.valueOf(r6, r7, r9)
            goto L_0x0060
        L_0x0053:
            com.appsflyer.internal.am r3 = com.appsflyer.internal.C1414am.AFKeystoreWrapper()
            java.lang.String r4 = "activity_null"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r3.valueOf(r6, r7, r4)
        L_0x0060:
            java.lang.String r3 = AFKeystoreWrapper((android.app.Activity) r17)
            r1.getInstance = r3
            if (r3 == 0) goto L_0x016d
            long r3 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.onPause
            java.lang.String r7 = ")"
            if (r6 != 0) goto L_0x0081
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.onPause = r0
            r10 = r3
            goto L_0x012f
        L_0x0081:
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0114 }
            java.lang.String r8 = "pushPayloadMaxAging"
            r9 = 1800000(0x1b7740, double:8.89318E-318)
            long r8 = r6.getLong(r8, r9)     // Catch:{ all -> 0x0114 }
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.onPause     // Catch:{ all -> 0x0114 }
            java.util.Set r6 = r6.keySet()     // Catch:{ all -> 0x0114 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0114 }
            r10 = r3
        L_0x0099:
            boolean r12 = r6.hasNext()     // Catch:{ all -> 0x0112 }
            if (r12 == 0) goto L_0x012f
            java.lang.Object r12 = r6.next()     // Catch:{ all -> 0x0112 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x0112 }
            java.lang.String r14 = r1.getInstance     // Catch:{ all -> 0x0112 }
            r13.<init>(r14)     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0112 }
            java.util.Map<java.lang.Long, java.lang.String> r15 = r1.onPause     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r15.get(r12)     // Catch:{ all -> 0x0112 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0112 }
            r14.<init>(r15)     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r13.opt(r2)     // Catch:{ all -> 0x0112 }
            java.lang.Object r5 = r14.opt(r2)     // Catch:{ all -> 0x0112 }
            boolean r5 = r15.equals(r5)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x00f5
            java.lang.Object r5 = r13.opt(r0)     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r14.opt(r0)     // Catch:{ all -> 0x0112 }
            boolean r5 = r5.equals(r15)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x00f5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ all -> 0x0112 }
            r0.append(r14)     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ all -> 0x0112 }
            r0.append(r13)     // Catch:{ all -> 0x0112 }
            r0.append(r7)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0112 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)     // Catch:{ all -> 0x0112 }
            r0 = 0
            r1.getInstance = r0     // Catch:{ all -> 0x0112 }
            return
        L_0x00f5:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0112 }
            long r13 = r3 - r13
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x0104
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.onPause     // Catch:{ all -> 0x0112 }
            r5.remove(r12)     // Catch:{ all -> 0x0112 }
        L_0x0104:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0112 }
            int r5 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r5 > 0) goto L_0x0110
            long r10 = r12.longValue()     // Catch:{ all -> 0x0112 }
        L_0x0110:
            r5 = 2
            goto L_0x0099
        L_0x0112:
            r0 = move-exception
            goto L_0x0116
        L_0x0114:
            r0 = move-exception
            r10 = r3
        L_0x0116:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Error while handling push notification measurement: "
            r2.<init>(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.values(r2, r0)
        L_0x012f:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r5 = 2
            int r0 = r0.getInt(r2, r5)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.onPause
            int r2 = r2.size()
            if (r2 != r0) goto L_0x015f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r10)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.onPause
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            r0.remove(r2)
        L_0x015f:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.onPause
            java.lang.Long r2 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = r1.getInstance
            r0.put(r2, r3)
            r16.start(r17)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1387af.sendPushNotificationData(android.app.Activity):void");
    }

    public final void setAdditionalData(Map<String, Object> map) {
        if (map != null) {
            C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setAdditionalData", map.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(map).toString());
        }
    }

    public final void setAndroidIdData(String str) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setAndroidIdData", str);
        this.AFVersionDeclaration = str;
    }

    public final void setAppId(String str) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setAppId", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_ID, str);
    }

    public final void setAppInviteOneLink(String str) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setAppInviteOneLink", str);
        AFLogger.AFInAppEventParameterName("setAppInviteOneLink = ".concat(String.valueOf(str)));
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove("onelinkVersion");
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_ID, str);
    }

    public final void setCollectAndroidID(boolean z) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setCollectAndroidID", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
    }

    public final void setCollectIMEI(boolean z) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setCollectIMEI", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
    }

    public final void setCollectOaid(boolean z) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setCollectOaid", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
    }

    public final void setCurrencyCode(String str) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
    }

    public final void setCustomerIdAndLogSession(String str, @NonNull Context context) {
        if (context == null) {
            return;
        }
        if (AFInAppEventType()) {
            setCustomerUserId(str);
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
            StringBuilder sb = new StringBuilder("CustomerUserId set: ");
            sb.append(str);
            sb.append(" - Initializing AppsFlyer Tacking");
            AFLogger.AFInAppEventParameterName(sb.toString(), true);
            String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (referrer == null) {
                referrer = "";
            }
            if (context instanceof Activity) {
                ((Activity) context).getIntent();
            }
            C1444bi biVar = new C1444bi();
            biVar.valueOf = (Application) context.getApplicationContext();
            biVar.AFVersionDeclaration = null;
            biVar.AFLogger$LogLevel = string;
            biVar.AFKeystoreWrapper = null;
            biVar.AppsFlyer2dXConversionCallback = referrer;
            biVar.AFInAppEventParameterName = null;
            values((C1480h) biVar);
            return;
        }
        setCustomerUserId(str);
        AFLogger.AFInAppEventParameterName("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
    }

    public final void setCustomerUserId(String str) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setCustomerUserId", str);
        AFLogger.AFInAppEventParameterName("setCustomerUserId = ".concat(String.valueOf(str)));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_USER_ID, str);
    }

    public final void setDebugLog(boolean z) {
        setLogLevel(z ? AFLogger.LogLevel.DEBUG : AFLogger.LogLevel.NONE);
    }

    public final void setExtension(String str) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    public final void setHost(String str, String str2) {
        if (str != null) {
            AppsFlyerProperties.getInstance().set("custom_host_prefix", str);
        }
        if (str2 == null || str2.isEmpty()) {
            AFLogger.AFVersionDeclaration("hostName cannot be null or empty");
        } else {
            AppsFlyerProperties.getInstance().set("custom_host", str2);
        }
    }

    public final void setImeiData(String str) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setImeiData", str);
        this.AppsFlyer2dXConversionCallback = str;
    }

    public final void setIsUpdate(boolean z) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    public final void setLogLevel(@NonNull AFLogger.LogLevel logLevel) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "log", String.valueOf(logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()));
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    public final void setMinTimeBetweenSessions(int i) {
        this.AppsFlyerInAppPurchaseValidatorListener = TimeUnit.SECONDS.toMillis((long) i);
    }

    public final void setOaidData(String str) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setOaidData", str);
        C1380ab.AFInAppEventType = str;
    }

    public final void setOneLinkCustomDomain(String... strArr) {
        AFLogger.AFInAppEventType(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        C1474f.AFLogger$LogLevel = strArr;
    }

    public final void setOutOfStore(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.AFInAppEventParameterName("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.valueOf("Cannot set setOutOfStore with null");
    }

    public final void setPartnerData(@NonNull String str, Map<String, Object> map) {
        if (this.setAppInviteOneLink == null) {
            this.setAppInviteOneLink = new C1427au();
        }
        C1427au auVar = this.setAppInviteOneLink;
        if (str == null || str.isEmpty()) {
            AFLogger.AFVersionDeclaration("Partner ID is missing or `null`");
        } else if (map == null || map.isEmpty()) {
            AFLogger.AFVersionDeclaration(auVar.valueOf.remove(str) == null ? "Partner data is missing or `null`" : "Cleared partner data for ".concat(str));
        } else {
            StringBuilder sb = new StringBuilder("Setting partner data for ");
            sb.append(str);
            sb.append(": ");
            sb.append(map);
            AFLogger.AFInAppEventType(sb.toString());
            int length = new JSONObject(map).toString().length();
            if (length > 1000) {
                AFLogger.AFVersionDeclaration("Partner data 1000 characters limit exceeded");
                HashMap hashMap = new HashMap();
                hashMap.put("error", "limit exceeded: ".concat(String.valueOf(length)));
                auVar.AFInAppEventParameterName.put(str, hashMap);
                return;
            }
            auVar.valueOf.put(str, map);
            auVar.AFInAppEventParameterName.remove(str);
        }
    }

    public final void setPhoneNumber(String str) {
        this.setCustomerIdAndLogSession = C1407ai.valueOf(str);
    }

    public final void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.AFInAppEventType("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("pid", str);
            } catch (JSONException e) {
                AFLogger.values(e.getMessage(), e);
            }
        }
        if (str2 != null) {
            jSONObject.put("c", str2);
        }
        if (str3 != null) {
            jSONObject.put("af_siteid", str3);
        }
        if (jSONObject.has("pid")) {
            AppsFlyerProperties.getInstance().set("preInstallName", jSONObject.toString());
            return;
        }
        AFLogger.AFVersionDeclaration("Cannot set preinstall attribution data without a media source");
    }

    public final void setResolveDeepLinkURLs(String... strArr) {
        AFLogger.AFInAppEventType(String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)}));
        C1474f.AFKeystoreWrapper = strArr;
    }

    public final void setSharingFilter(@NonNull String... strArr) {
        if (strArr != null && !Arrays.equals(this.init, new String[]{"all"})) {
            Pattern compile = Pattern.compile("[\\d\\w_]{1,45}");
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (str == null || !compile.matcher(str).matches()) {
                    AFLogger.AFVersionDeclaration("Invalid partner name :".concat(String.valueOf(str)));
                } else {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                this.init = (String[]) arrayList.toArray(new String[0]);
            } else {
                this.init = null;
            }
        }
    }

    public final void setSharingFilterForAllPartners() {
        this.init = new String[]{"all"};
    }

    public final void setUserEmails(String... strArr) {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
    }

    public final void start(@NonNull Context context) {
        start(context, (String) null);
    }

    public final void stop(boolean z, Context context) {
        this.setDebugLog = z;
        C1399ag.AFInAppEventType();
        try {
            File valueOf2 = C1399ag.valueOf(context);
            if (!valueOf2.exists()) {
                valueOf2.mkdir();
            } else {
                for (File file : valueOf2.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file.getName());
                    AFLogger.AFInAppEventParameterName(sb.toString());
                    C1399ag.values(C1399ag.AFKeystoreWrapper(file).valueOf, context);
                }
            }
        } catch (Exception e) {
            AFLogger.values("Could not cache request", e);
        }
        if (this.setDebugLog) {
            SharedPreferences.Editor edit = AFInAppEventType(context).edit();
            edit.putBoolean("is_stop_tracking_used", true);
            edit.apply();
        }
    }

    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener) {
        C1474f.AFInAppEventParameterName().AFInAppEventType = deepLinkListener;
    }

    public final void unregisterConversionListener() {
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "unregisterConversionListener", new String[0]);
        AFKeystoreWrapper = null;
    }

    public final void updateServerUninstallToken(Context context, String str) {
        new C1433az(context).AFKeystoreWrapper(str);
    }

    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Context context2 = context;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        C1414am AFKeystoreWrapper2 = C1414am.AFKeystoreWrapper();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str6;
        strArr[3] = str7;
        strArr[4] = str8;
        strArr[5] = map == null ? "" : map.toString();
        AFKeystoreWrapper2.valueOf("public_api_call", "validateAndTrackInAppPurchase", strArr);
        if (!isStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str3);
            sb.append(" ");
            sb.append(str7);
            sb.append(" ");
            sb.append(str8);
            AFLogger.AFInAppEventParameterName(sb.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = valueOf;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (context2 instanceof Activity) {
            ((Activity) context2).getIntent();
        }
        new Thread(new C1378aa(applicationContext, string, str, str2, str3, str4, str5, map)).start();
    }

    public final void waitForCustomerUserId(boolean z) {
        AFLogger.AFInAppEventParameterName("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
    }

    public static C1387af AFInAppEventParameterName() {
        return onAttributionFailure;
    }

    public static boolean AFVersionDeclaration(Context context) {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                return true;
            }
        } catch (Throwable th) {
            AFLogger.values("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.values("WARNING:  Google Play Services is unavailable. ", e);
            return false;
        }
    }

    private boolean AppsFlyer2dXConversionCallback() {
        Map<String, Object> map = this.getOutOfStore;
        return map != null && !map.isEmpty();
    }

    public static boolean getLevel(Context context) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
                        NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
                        if (networkCapabilities2.hasTransport(4) && !networkCapabilities2.hasCapability(15)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e) {
                    AFLogger.values("Failed collecting ivc data", e);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e2) {
                    AFLogger.values("Failed collecting ivc data", e2);
                }
            }
        }
        return false;
    }

    public static void valueOf(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        if (jSONArray2.getLong(i2) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                            i2++;
                            str = next;
                        }
                    }
                    continue;
                } catch (JSONException unused2) {
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    public final void AFInAppEventType(Context context, Intent intent) {
        if (intent.getStringExtra("appsflyer_preinstall") != null) {
            String stringExtra = intent.getStringExtra("appsflyer_preinstall");
            try {
                if (new JSONObject(stringExtra).has("pid")) {
                    AppsFlyerProperties.getInstance().set("preInstallName", stringExtra);
                } else {
                    AFLogger.AFVersionDeclaration("Cannot set preinstall attribution data without a media source");
                }
            } catch (JSONException e) {
                AFLogger.values("Error parsing JSON for preinstall", e);
            }
        }
        AFLogger.AFInAppEventParameterName("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String stringExtra2 = intent.getStringExtra(SwrveImp.REFERRER);
        AFLogger.AFInAppEventParameterName("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            SharedPreferences.Editor edit = AFInAppEventType(context).edit();
            edit.putString(SwrveImp.REFERRER, stringExtra2);
            edit.apply();
            AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
            instance.set("AF_REFERRER", stringExtra2);
            instance.AFInAppEventType = stringExtra2;
            if (AppsFlyerProperties.getInstance().AFKeystoreWrapper()) {
                AFLogger.AFInAppEventParameterName("onReceive: isLaunchCalled");
                C1439bd bdVar = new C1439bd();
                if (context != null) {
                    bdVar.valueOf = (Application) context.getApplicationContext();
                }
                bdVar.AppsFlyer2dXConversionCallback = stringExtra2;
                if (stringExtra2.length() > 5 && valueOf((C1480h) bdVar, AFInAppEventType(context))) {
                    if (C1486n.valueOf == null) {
                        C1486n.valueOf = new C1486n();
                    }
                    AFInAppEventParameterName(C1486n.valueOf.values(), new C1396a(this, bdVar, (byte) 0), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public final AppsFlyerLib init(@NonNull String str, AppsFlyerConversionListener appsFlyerConversionListener, @NonNull Context context) {
        if (this.setAndroidIdData) {
            return this;
        }
        this.setAndroidIdData = true;
        if (context != null) {
            if (this.AFLogger$LogLevel == null) {
                this.AFLogger$LogLevel = new C1430aw(context);
            }
            C1430aw awVar = this.AFLogger$LogLevel;
            if (awVar.AFKeystoreWrapper()) {
                awVar.AFInAppEventType.edit().putLong("init_ts", System.currentTimeMillis()).apply();
            }
            this.setImeiData = (Application) context.getApplicationContext();
            final C1452bq bqVar = new C1452bq(new Runnable() {
                public final void run() {
                    if (C1486n.valueOf == null) {
                        C1486n.valueOf = new C1486n();
                    }
                    C1387af.AFInAppEventParameterName(C1486n.valueOf.values(), new Runnable() {
                        public final void run() {
                            try {
                                C1442bg bgVar = new C1442bg();
                                Application AFInAppEventParameterName = C1387af.this.setImeiData;
                                if (AFInAppEventParameterName != null) {
                                    bgVar.valueOf = (Application) AFInAppEventParameterName.getApplicationContext();
                                }
                                if (C1387af.this.valueOf((C1480h) bgVar, C1387af.AFInAppEventType((Context) C1387af.this.setImeiData))) {
                                    C1387af.AFInAppEventParameterName(C1387af.this, (C1480h) bgVar);
                                }
                            } catch (Throwable th) {
                                AFLogger.values(th.getMessage(), th);
                            }
                        }
                    }, 0, TimeUnit.MILLISECONDS);
                }
            });
            C13913 r4 = new Runnable() {
                public final void run() {
                    SharedPreferences AFInAppEventType2 = C1387af.AFInAppEventType((Context) C1387af.this.setImeiData);
                    boolean z = false;
                    int AFInAppEventParameterName2 = C1387af.AFInAppEventParameterName(AFInAppEventType2, "appsFlyerCount", false);
                    boolean z2 = AFInAppEventType2.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false);
                    if (bqVar.AFInAppEventType == C1461bw.C1463d.NOT_STARTED) {
                        z = true;
                    }
                    if (AFInAppEventParameterName2 != 1) {
                        return;
                    }
                    if (z || z2) {
                        C1387af afVar = C1387af.this;
                        C1442bg bgVar = new C1442bg();
                        Application AFInAppEventParameterName3 = C1387af.this.setImeiData;
                        if (AFInAppEventParameterName3 != null) {
                            bgVar.valueOf = (Application) AFInAppEventParameterName3.getApplicationContext();
                        }
                        C1387af.AFInAppEventParameterName(afVar, (C1480h) bgVar);
                    }
                }
            };
            C1461bw[] bwVarArr = {bqVar, new C1454br(r4), new C1458bu(r4)};
            this.onAttributionFailureNative = bwVarArr;
            for (C1461bw AFInAppEventType2 : bwVarArr) {
                AFInAppEventType2.AFInAppEventType(this.setImeiData);
            }
            this.setPhoneNumber = valueOf(context);
            C1431ax.AFInAppEventParameterName = this.setImeiData;
        } else {
            AFLogger.AFVersionDeclaration("context is null, Google Install Referrer will be not initialized");
        }
        C1414am AFKeystoreWrapper2 = C1414am.AFKeystoreWrapper();
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = appsFlyerConversionListener == null ? "null" : "conversionDataListener";
        AFKeystoreWrapper2.valueOf("public_api_call", "init", strArr);
        AFLogger.values(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{"6.3.0", values}));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
        C1415an.valueOf(str);
        AFKeystoreWrapper = appsFlyerConversionListener;
        return this;
    }

    public final void start(@NonNull Context context, String str) {
        start(context, str, (AppsFlyerRequestListener) null);
    }

    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener, long j) {
        C1420ar.onAppOpenAttributionNative = j;
        subscribeForDeepLink(deepLinkListener);
    }

    public static void AFInAppEventParameterName(Context context, String str, String str2) {
        SharedPreferences.Editor edit = AFInAppEventType(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static float AppsFlyer2dXConversionCallback(Context context) {
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return 50.0f;
            }
            return (((float) intExtra) / ((float) intExtra2)) * 100.0f;
        } catch (Throwable th) {
            AFLogger.values(th.getMessage(), th);
            return 1.0f;
        }
    }

    public static boolean values(String str, boolean z) {
        return AppsFlyerProperties.getInstance().getBoolean(str, z);
    }

    public final void start(@NonNull Context context, String str, AppsFlyerRequestListener appsFlyerRequestListener) {
        final String str2 = str;
        final AppsFlyerRequestListener appsFlyerRequestListener2 = appsFlyerRequestListener;
        if (C1400ah.AFInAppEventType == null) {
            if (!this.setAndroidIdData) {
                AFLogger.AFVersionDeclaration("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
                if (str2 == null) {
                    if (appsFlyerRequestListener2 != null) {
                        appsFlyerRequestListener2.onError(RequestError.NO_DEV_KEY, C1426at.AFInAppEventParameterName);
                        return;
                    }
                    return;
                }
            }
            this.setImeiData = (Application) context.getApplicationContext();
            C1414am.AFKeystoreWrapper().valueOf("public_api_call", VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE, str2);
            AFLogger.AFInAppEventParameterName(String.format("Starting AppsFlyer: (v%s.%s)", new Object[]{"6.3.0", values}));
            StringBuilder sb = new StringBuilder("Build Number: ");
            sb.append(values);
            AFLogger.AFInAppEventParameterName(sb.toString());
            AppsFlyerProperties.getInstance().loadProperties(this.setImeiData.getApplicationContext());
            if (!TextUtils.isEmpty(str)) {
                AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str2);
                C1415an.valueOf(str);
            } else if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY))) {
                AFLogger.AFVersionDeclaration("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                if (appsFlyerRequestListener2 != null) {
                    appsFlyerRequestListener2.onError(RequestError.NO_DEV_KEY, C1426at.AFInAppEventParameterName);
                    return;
                }
                return;
            }
            Context baseContext = this.setImeiData.getBaseContext();
            try {
                if ((baseContext.getPackageManager().getPackageInfo(baseContext.getPackageName(), 0).applicationInfo.flags & 32768) != 0) {
                    if (baseContext.getResources().getIdentifier("appsflyer_backup_rules", "xml", baseContext.getPackageName()) != 0) {
                        AFLogger.AFInAppEventParameterName("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                    } else {
                        AFLogger.valueOf("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
                    }
                }
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("checkBackupRules Exception: ");
                sb2.append(e.toString());
                AFLogger.AFKeystoreWrapper(sb2.toString());
            }
            if (this.setCustomerUserId) {
                Context applicationContext = this.setImeiData.getApplicationContext();
                this.waitForCustomerUserId = new HashMap();
                final long currentTimeMillis = System.currentTimeMillis();
                C13924 r9 = new C1483m.C1485d() {
                    public final void AFInAppEventType(String str) {
                        C1387af.this.waitForCustomerUserId.put("error", str);
                    }

                    public final void values(String str, String str2, String str3) {
                        if (str != null) {
                            AFLogger.AFInAppEventParameterName("Facebook Deferred AppLink data received: ".concat(str));
                            C1387af.this.waitForCustomerUserId.put("link", str);
                            if (str2 != null) {
                                C1387af.this.waitForCustomerUserId.put("target_url", str2);
                            }
                            if (str3 != null) {
                                HashMap hashMap = new HashMap();
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("promo_code", str3);
                                hashMap.put("deeplink_context", hashMap2);
                                C1387af.this.waitForCustomerUserId.put("extras", hashMap);
                            }
                        } else {
                            C1387af.this.waitForCustomerUserId.put("link", "");
                        }
                        C1387af.this.waitForCustomerUserId.put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                };
                try {
                    Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{applicationContext});
                    Class<?> cls = Class.forName(AppLinkData.TAG);
                    Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
                    Method method = cls.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls2});
                    C1483m.C14844 r13 = new InvocationHandler(cls, r9) {
                        public /* synthetic */ C1485d AFInAppEventParameterName;
                        public /* synthetic */ Class values;

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.m.4.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.m.4.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    };
                    Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r13);
                    String string = applicationContext.getString(applicationContext.getResources().getIdentifier("facebook_app_id", LegacyTokenHelper.TYPE_STRING, applicationContext.getPackageName()));
                    if (TextUtils.isEmpty(string)) {
                        r9.AFInAppEventType("Facebook app id not defined in resources");
                    } else {
                        method.invoke((Object) null, new Object[]{applicationContext, string, newProxyInstance});
                    }
                } catch (NoSuchMethodException e2) {
                    r9.AFInAppEventType(e2.toString());
                } catch (InvocationTargetException e3) {
                    r9.AFInAppEventType(e3.toString());
                } catch (ClassNotFoundException e4) {
                    r9.AFInAppEventType(e4.toString());
                } catch (IllegalAccessException e5) {
                    r9.AFInAppEventType(e5.toString());
                }
            }
            C1400ah.AFInAppEventType(context, new C1400ah.C1406e() {
                public final void AFInAppEventType(Activity activity) {
                    long unused = C1387af.this.onValidateInAppFailure = System.currentTimeMillis();
                    C1387af afVar = C1387af.this;
                    if (afVar.AFLogger$LogLevel == null) {
                        afVar.AFLogger$LogLevel = new C1430aw(activity);
                    }
                    C1430aw awVar = afVar.AFLogger$LogLevel;
                    if (awVar.AFKeystoreWrapper()) {
                        awVar.AFInAppEventType.edit().putLong("fg_ts", System.currentTimeMillis()).apply();
                    }
                    int AFInAppEventParameterName2 = C1387af.AFInAppEventParameterName(C1387af.AFInAppEventType((Context) activity), "appsFlyerCount", false);
                    if (AFInAppEventParameterName2 == 0) {
                        try {
                            C1387af.this.setAdditionalData.put("init_to_fg", C1387af.this.onValidateInAppFailure - C1387af.this.AFLogger$LogLevel.AFInAppEventType.getLong("init_ts", 0));
                        } catch (JSONException unused2) {
                        }
                    }
                    AFLogger.AFInAppEventParameterName("onBecameForeground");
                    if (AFInAppEventParameterName2 < 2) {
                        C1500z valueOf2 = C1500z.valueOf((Context) activity);
                        valueOf2.AFInAppEventParameterName.post(valueOf2.getLevel);
                        valueOf2.AFInAppEventParameterName.post(valueOf2.values);
                    }
                    C1444bi biVar = new C1444bi();
                    C1474f AFInAppEventParameterName3 = C1474f.AFInAppEventParameterName();
                    Map<String, Object> valueOf3 = biVar.valueOf();
                    C1430aw awVar2 = C1387af.this.AFLogger$LogLevel;
                    SharedPreferences AFInAppEventType = C1387af.AFInAppEventType((Context) activity);
                    boolean z = AFInAppEventType.getBoolean("ddl_sent", false);
                    C1387af.AFInAppEventParameterName();
                    int AFInAppEventParameterName4 = C1387af.AFInAppEventParameterName(AFInAppEventType, "appsFlyerCount", false);
                    if (!AFInAppEventParameterName3.values(activity.getIntent(), activity, valueOf3) && AFInAppEventParameterName3.AFInAppEventType != null && AFInAppEventParameterName4 == 0 && !z) {
                        C1420ar arVar = new C1420ar(activity.getApplicationContext(), awVar2);
                        AFLogger.AFInAppEventType("[DDL] start");
                        FutureTask futureTask = new FutureTask(new Callable<DeepLinkResult>() {
                            public final /* synthetic */ java.lang.Object call(
/*
Method generation error in method: com.appsflyer.internal.ar.3.call():java.lang.Object, dex: classes.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.ar.3.call():java.lang.Object, class status: UNLOADED
                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            
*/
                        });
                        new Thread(futureTask).start();
                        try {
                            arVar.AFInAppEventParameterName((DeepLinkResult) futureTask.get(C1420ar.onAppOpenAttributionNative, TimeUnit.MILLISECONDS));
                        } catch (InterruptedException | ExecutionException e) {
                            AFLogger.AFInAppEventParameterName("[DDL] Error occurred", e);
                            arVar.AFInAppEventParameterName(new DeepLinkResult((DeepLink) null, e.getCause() instanceof IOException ? DeepLinkResult.Error.NETWORK : DeepLinkResult.Error.UNEXPECTED));
                        } catch (TimeoutException unused3) {
                            StringBuilder sb = new StringBuilder("[DDL] Timeout, didn't manage to find deferred deep link after ");
                            sb.append(arVar.onAttributionFailureNative);
                            sb.append(" attempt(s) within ");
                            sb.append(C1420ar.onAppOpenAttributionNative);
                            sb.append(" milliseconds");
                            AFLogger.AFInAppEventType(sb.toString());
                            arVar.AFInAppEventParameterName(new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.TIMEOUT));
                        }
                    }
                    C1387af afVar2 = C1387af.this;
                    biVar.valueOf = (Application) activity.getApplicationContext();
                    biVar.AFLogger$LogLevel = str2;
                    biVar.values = appsFlyerRequestListener2;
                    afVar2.AFKeystoreWrapper((C1480h) biVar, activity);
                }

                public final void valueOf(Context context) {
                    AFLogger.AFInAppEventParameterName("onBecameBackground");
                    long unused = C1387af.this.updateServerUninstallToken = System.currentTimeMillis();
                    long AFVersionDeclaration = C1387af.this.updateServerUninstallToken - C1387af.this.onValidateInAppFailure;
                    if (AFVersionDeclaration > 0 && AFVersionDeclaration < 1000) {
                        AFVersionDeclaration = 1000;
                    }
                    C1387af afVar = C1387af.this;
                    if (afVar.AFLogger$LogLevel == null) {
                        afVar.AFLogger$LogLevel = new C1430aw(context);
                    }
                    afVar.AFLogger$LogLevel.AFInAppEventType.edit().putLong("prev_session_dur", TimeUnit.MILLISECONDS.toSeconds(AFVersionDeclaration)).apply();
                    AFLogger.AFInAppEventParameterName("callStatsBackground background call");
                    C1387af.this.valueOf((WeakReference<Context>) new WeakReference(context));
                    C1414am AFKeystoreWrapper = C1414am.AFKeystoreWrapper();
                    if (AFKeystoreWrapper.AFLogger$LogLevel()) {
                        AFKeystoreWrapper.AFInAppEventParameterName();
                        if (context != null) {
                            C1414am.AFInAppEventParameterName(context.getPackageName(), context.getPackageManager());
                        }
                        AFKeystoreWrapper.AFInAppEventType();
                    } else {
                        AFLogger.AFInAppEventType("RD status is OFF");
                    }
                    if (C1486n.valueOf == null) {
                        C1486n.valueOf = new C1486n();
                    }
                    C1486n nVar = C1486n.valueOf;
                    try {
                        C1486n.AFInAppEventParameterName(nVar.AFInAppEventParameterName);
                        if (nVar.AFInAppEventType instanceof ThreadPoolExecutor) {
                            C1486n.AFInAppEventParameterName((ThreadPoolExecutor) nVar.AFInAppEventType);
                        }
                    } catch (Throwable th) {
                        AFLogger.values("failed to stop Executors", th);
                    }
                    C1500z valueOf2 = C1500z.valueOf(context);
                    valueOf2.AFInAppEventParameterName.post(valueOf2.getLevel);
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void values(android.content.Context r4) {
        /*
            boolean r0 = com.appsflyer.internal.C1381ac.AFKeystoreWrapper()
            if (r0 == 0) goto L_0x000e
            r0 = 23
            java.lang.String r1 = "OPPO device found"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r1)
            goto L_0x0010
        L_0x000e:
            r0 = 18
        L_0x0010:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x00c1
            java.lang.String r0 = "keyPropDisableAFKeystore"
            r1 = 1
            boolean r0 = values((java.lang.String) r0, (boolean) r1)
            if (r0 != 0) goto L_0x00c1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "OS SDK is="
            r0.<init>(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r0.append(r2)
            java.lang.String r2 = "; use KeyStore"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)
            com.appsflyer.AFKeystoreWrapper r0 = new com.appsflyer.AFKeystoreWrapper
            r0.<init>(r4)
            boolean r2 = r0.AFInAppEventParameterName()
            if (r2 != 0) goto L_0x0056
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            java.lang.String r4 = com.appsflyer.internal.C1412ak.AFKeystoreWrapper(r1)
            r0.AFKeystoreWrapper = r4
            r4 = 0
            r0.values = r4
            java.lang.String r4 = r0.AFKeystoreWrapper()
            r0.valueOf(r4)
            goto L_0x009f
        L_0x0056:
            java.lang.String r4 = r0.AFKeystoreWrapper()
            java.lang.Object r2 = r0.AFInAppEventType
            monitor-enter(r2)
            int r3 = r0.values     // Catch:{ all -> 0x00be }
            int r3 = r3 + r1
            r0.values = r3     // Catch:{ all -> 0x00be }
            java.lang.String r1 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00be }
            java.lang.String r1 = r1.concat(r3)     // Catch:{ all -> 0x00be }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r1)     // Catch:{ all -> 0x00be }
            java.lang.Object r1 = r0.AFInAppEventType     // Catch:{ KeyStoreException -> 0x007c }
            monitor-enter(r1)     // Catch:{ KeyStoreException -> 0x007c }
            java.security.KeyStore r3 = r0.valueOf     // Catch:{ all -> 0x0079 }
            r3.deleteEntry(r4)     // Catch:{ all -> 0x0079 }
            monitor-exit(r1)     // Catch:{ all -> 0x0079 }
            goto L_0x0097
        L_0x0079:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ KeyStoreException -> 0x007c }
            throw r4     // Catch:{ KeyStoreException -> 0x007c }
        L_0x007c:
            r4 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            java.lang.String r3 = "Exception "
            r1.<init>(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x00be }
            r1.append(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = " occurred"
            r1.append(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00be }
            com.appsflyer.AFLogger.values(r1, r4)     // Catch:{ all -> 0x00be }
        L_0x0097:
            monitor-exit(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r0.AFKeystoreWrapper()
            r0.valueOf(r4)
        L_0x009f:
            java.lang.String r4 = "KSAppsFlyerId"
            java.lang.String r1 = r0.valueOf()
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            r2.set((java.lang.String) r4, (java.lang.String) r1)
            java.lang.String r4 = "KSAppsFlyerRICounter"
            int r0 = r0.AFInAppEventType()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            r1.set((java.lang.String) r4, (java.lang.String) r0)
            return
        L_0x00be:
            r4 = move-exception
            monitor-exit(r2)
            throw r4
        L_0x00c1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "OS SDK is="
            r4.<init>(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r4.append(r0)
            java.lang.String r0 = "; no KeyStore usage"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.AFKeystoreWrapper(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1387af.values(android.content.Context):void");
    }

    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        C1414am.AFKeystoreWrapper().valueOf("public_api_call", "setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        String str = null;
        for (String str2 : strArr) {
            if (C13957.AFInAppEventParameterName[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(C1407ai.valueOf(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    private boolean AFKeystoreWrapper() {
        if (this.onDeepLinking > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.onDeepLinking;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            long j = this.onDeepLinking;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date(j));
            long j2 = this.onValidateInApp;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format2 = simpleDateFormat.format(new Date(j2));
            if (currentTimeMillis < this.AppsFlyerInAppPurchaseValidatorListener && !isStopped()) {
                AFLogger.AFInAppEventParameterName(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{format, format2, Long.valueOf(currentTimeMillis), Long.valueOf(this.AppsFlyerInAppPurchaseValidatorListener)}));
                return true;
            } else if (!isStopped()) {
                AFLogger.AFInAppEventParameterName(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{format, format2, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isStopped()) {
            AFLogger.AFInAppEventParameterName("Sending first launch for this session!");
        }
        return false;
    }

    public static String AFInAppEventParameterName(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable th) {
            AFLogger.values(th.getMessage(), th);
            return null;
        }
    }

    @Nullable
    public final String AFInAppEventParameterName(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("channel");
        if (string == null) {
            string = context == null ? null : values("CHANNEL", context.getPackageManager(), context.getPackageName());
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    public final void logEvent(Context context, String str, Map<String, Object> map) {
        logEvent(context, str, map, (AppsFlyerRequestListener) null);
    }

    public final String AFInAppEventParameterName(Context context, String str) {
        SharedPreferences AFInAppEventType2 = AFInAppEventType(context);
        if (AFInAppEventType2.contains("CACHED_CHANNEL")) {
            return AFInAppEventType2.getString("CACHED_CHANNEL", (String) null);
        }
        SharedPreferences.Editor edit = AFInAppEventType(context).edit();
        edit.putString("CACHED_CHANNEL", str);
        edit.apply();
        return str;
    }

    public final void valueOf(Context context, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        AFLogger.AFInAppEventType("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = AFInAppEventType(context).getString("extraReferrers", (String) null);
            if (string == null) {
                jSONObject = new JSONObject();
                jSONArray = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str)) {
                    jSONArray2 = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray2 = new JSONArray();
                }
                JSONObject jSONObject3 = jSONObject2;
                jSONArray = jSONArray2;
                jSONObject = jSONObject3;
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                valueOf(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            String jSONObject4 = jSONObject.toString();
            SharedPreferences.Editor edit = AFInAppEventType(context).edit();
            edit.putString("extraReferrers", jSONObject4);
            edit.apply();
        } catch (JSONException unused) {
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.values(sb.toString(), th);
        }
    }

    public static int AFInAppEventParameterName(SharedPreferences sharedPreferences, String str, boolean z) {
        int i = sharedPreferences.getInt(str, 0);
        if (z) {
            i++;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.apply();
        }
        if (C1414am.AFKeystoreWrapper().AFLogger$LogLevel()) {
            C1414am.AFKeystoreWrapper().values(String.valueOf(i));
        }
        return i;
    }

    public static boolean AFKeystoreWrapper(@NonNull SharedPreferences sharedPreferences) {
        return Boolean.parseBoolean(sharedPreferences.getString("sentSuccessfully", (String) null));
    }

    public static String AFKeystoreWrapper(Activity activity) {
        Intent intent;
        String str = null;
        if (!(activity == null || (intent = activity.getIntent()) == null)) {
            try {
                Bundle extras = intent.getExtras();
                if (!(extras == null || (str = extras.getString("af")) == null)) {
                    AFLogger.AFInAppEventParameterName("Push Notification received af payload = ".concat(str));
                    extras.remove("af");
                    activity.setIntent(intent.putExtras(extras));
                }
            } catch (Throwable th) {
                AFLogger.values(th.getMessage(), th);
            }
        }
        return str;
    }

    public static boolean init(Context context) {
        if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) || !AFVersionDeclaration(context)) {
            return true;
        }
        return false;
    }

    public static void AFInAppEventParameterName(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.schedule(runnable, j, timeUnit);
                    return;
                }
            } catch (RejectedExecutionException e) {
                AFLogger.values("scheduleJob failed with RejectedExecutionException Exception", e);
                return;
            } catch (Throwable th) {
                AFLogger.values("scheduleJob failed with Exception", th);
                return;
            }
        }
        AFLogger.AFVersionDeclaration("scheduler is null, shut downed or terminated");
    }

    public static boolean AFKeystoreWrapper(Context context) {
        return !AFInAppEventType(context).contains("appsFlyerCount");
    }

    private void values(Context context, String str, Map<String, Object> map) {
        C1447bl blVar = new C1447bl();
        if (context != null) {
            blVar.valueOf = (Application) context.getApplicationContext();
        }
        blVar.AFVersionDeclaration = str;
        blVar.AFKeystoreWrapper = map;
        AFKeystoreWrapper((C1480h) blVar, context instanceof Activity ? (Activity) context : null);
    }

    public static File AFKeystoreWrapper(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.trim().length() > 0) {
                return new File(str.trim());
            }
            return null;
        } catch (Throwable th) {
            AFLogger.values(th.getMessage(), th);
            return null;
        }
    }

    public static /* synthetic */ void AFInAppEventParameterName(C1387af afVar, C1480h hVar) {
        String str;
        ScheduledExecutorService scheduledExecutorService;
        Application application = hVar.valueOf;
        String str2 = hVar.AFVersionDeclaration;
        if (application == null) {
            AFLogger.AFInAppEventType("sendWithEvent - got null context. skipping event/launch.");
            return;
        }
        SharedPreferences AFInAppEventType2 = AFInAppEventType((Context) application);
        AppsFlyerProperties.getInstance().saveProperties(AFInAppEventType2);
        if (!afVar.isStopped()) {
            StringBuilder sb = new StringBuilder("sendWithEvent from activity: ");
            sb.append(application.getClass().getName());
            AFLogger.AFInAppEventParameterName(sb.toString());
        }
        int i = 1;
        int i2 = 0;
        boolean z = str2 == null;
        boolean z2 = hVar instanceof C1439bd;
        boolean z3 = hVar instanceof C1442bg;
        hVar.onInstallConversionDataLoadedNative = z;
        Map<String, Object> valueOf2 = afVar.valueOf(hVar);
        String str3 = (String) valueOf2.get("appsflyerKey");
        if (str3 == null || str3.length() == 0) {
            AFLogger.AFInAppEventType("Not sending data yet, waiting for dev key");
            AppsFlyerRequestListener appsFlyerRequestListener = hVar.values;
            if (appsFlyerRequestListener != null) {
                appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, C1426at.AFInAppEventParameterName);
                return;
            }
            return;
        }
        if (!afVar.isStopped()) {
            AFLogger.AFInAppEventParameterName("AppsFlyerLib.sendWithEvent");
        }
        int AFInAppEventParameterName2 = AFInAppEventParameterName(AFInAppEventType2, "appsFlyerCount", false);
        if (z3 || z2) {
            str = String.format(onConversionDataFail, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), onAttributionFailure.getHostName()});
        } else if (!z) {
            str = String.format(onAppOpenAttribution, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), onAttributionFailure.getHostName()});
        } else if (AFInAppEventParameterName2 < 2) {
            str = String.format(onInstallConversionFailureNative, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), onAttributionFailure.getHostName()});
        } else {
            str = String.format(onConversionDataSuccess, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), onAttributionFailure.getHostName()});
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(str);
        outline24.append(application.getPackageName());
        String obj = outline24.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append("&buildnumber=6.3.0");
        String obj2 = sb2.toString();
        String AFInAppEventParameterName3 = afVar.AFInAppEventParameterName((Context) application);
        if (AFInAppEventParameterName3 != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj2);
            sb3.append("&channel=");
            sb3.append(AFInAppEventParameterName3);
            obj2 = sb3.toString();
        }
        if (!(AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) && valueOf2.get("advertiserId") != null) {
            try {
                if (TextUtils.isEmpty(afVar.AFVersionDeclaration) && valueOf2.remove(VungleApiClient.ANDROID_ID) != null) {
                    AFLogger.AFInAppEventParameterName("validateGaidAndIMEI :: removing: android_id");
                }
                if (TextUtils.isEmpty(afVar.AppsFlyer2dXConversionCallback) && valueOf2.remove("imei") != null) {
                    AFLogger.AFInAppEventParameterName("validateGaidAndIMEI :: removing: imei");
                }
            } catch (Exception e) {
                AFLogger.values("failed to remove IMEI or AndroidID key from params; ", e);
            }
        }
        C1480h AFKeystoreWrapper2 = hVar.values(obj2).AFKeystoreWrapper(valueOf2);
        AFKeystoreWrapper2.onDeepLinkingNative = AFInAppEventParameterName2;
        C1398c cVar = new C1398c(afVar, AFKeystoreWrapper2, (byte) 0);
        if (z) {
            C1461bw[] bwVarArr = afVar.onAttributionFailureNative;
            if (bwVarArr != null) {
                int length = bwVarArr.length;
                int i3 = 0;
                while (i2 < length) {
                    C1461bw bwVar = bwVarArr[i2];
                    if (bwVar.AFInAppEventType == C1461bw.C1463d.STARTED) {
                        StringBuilder sb4 = new StringBuilder("Failed to get ");
                        sb4.append(bwVar.valueOf);
                        sb4.append(" referrer, wait ...");
                        AFLogger.AFInAppEventType(sb4.toString());
                        i3 = 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            if (afVar.setCustomerUserId && !afVar.values()) {
                AFLogger.AFInAppEventType("fetching Facebook deferred AppLink data, wait ...");
                i2 = 1;
            }
            if (!afVar.setPhoneNumber || afVar.AppsFlyer2dXConversionCallback()) {
                i = i2;
            }
        } else {
            i = 0;
        }
        if (C1474f.valueOf) {
            AFLogger.AFKeystoreWrapper("ESP deeplink: execute launch on SerialExecutor");
            if (C1486n.valueOf == null) {
                C1486n.valueOf = new C1486n();
            }
            C1486n nVar = C1486n.valueOf;
            if (nVar.AFKeystoreWrapper == null) {
                nVar.AFKeystoreWrapper = Executors.newSingleThreadScheduledExecutor(nVar.values);
            }
            scheduledExecutorService = nVar.AFKeystoreWrapper;
        } else {
            if (C1486n.valueOf == null) {
                C1486n.valueOf = new C1486n();
            }
            scheduledExecutorService = C1486n.valueOf.values();
        }
        AFInAppEventParameterName(scheduledExecutorService, cVar, i != 0 ? 500 : 0, TimeUnit.MILLISECONDS);
    }

    public static void AFInAppEventType(Context context, String str) {
        SharedPreferences.Editor edit = AFInAppEventType(context).edit();
        edit.putBoolean(str, true);
        edit.apply();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r6 = com.appsflyer.internal.C1416ao.values(r6);
     */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void AFKeystoreWrapper(@androidx.annotation.NonNull com.appsflyer.internal.C1480h r5, @androidx.annotation.Nullable android.app.Activity r6) {
        /*
            r4 = this;
            android.app.Application r0 = r5.valueOf
            java.lang.String r1 = ""
            if (r6 == 0) goto L_0x0011
            android.net.Uri r6 = com.appsflyer.internal.C1416ao.values(r6)
            if (r6 == 0) goto L_0x0011
            java.lang.String r6 = r6.toString()
            goto L_0x0012
        L_0x0011:
            r6 = r1
        L_0x0012:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r3 = "AppsFlyerKey"
            java.lang.String r2 = r2.getString(r3)
            if (r2 != 0) goto L_0x002f
            java.lang.String r6 = "[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.AFVersionDeclaration(r6)
            com.appsflyer.attribution.AppsFlyerRequestListener r5 = r5.values
            if (r5 == 0) goto L_0x002e
            int r6 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.C1426at.AFInAppEventParameterName
            r5.onError(r6, r0)
        L_0x002e:
            return
        L_0x002f:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r2.getReferrer(r0)
            if (r0 != 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r0
        L_0x003b:
            r5.AppsFlyer2dXConversionCallback = r1
            r5.AFInAppEventParameterName = r6
            r4.values((com.appsflyer.internal.C1480h) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1387af.AFKeystoreWrapper(com.appsflyer.internal.h, android.app.Activity):void");
    }

    private boolean values() {
        Map<String, Object> map = this.waitForCustomerUserId;
        return map != null && !map.isEmpty();
    }

    public static void values(Context context, Map<String, Object> map) {
        WindowManager windowManager = (WindowManager) context.getSystemService(VisionController.WINDOW);
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            map.put("sc_o", rotation != 0 ? rotation != 1 ? rotation != 2 ? rotation != 3 ? "" : "lr" : "pr" : AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL : AnalyticsEventKey.PROTOCOL);
        }
    }

    public static boolean AFInAppEventType() {
        if (!values(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false) || AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) != null) {
            return false;
        }
        return true;
    }

    public static String AFInAppEventType(SimpleDateFormat simpleDateFormat, long j) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date(j));
    }

    public static String values(@Nullable String str) {
        String str2;
        if (str == null) {
            return null;
        }
        if (!str.matches("fb\\d*?://authorize.*") || !str.contains("access_token")) {
            return str;
        }
        int indexOf = str.indexOf(63);
        if (indexOf == -1) {
            str2 = "";
        } else {
            str2 = str.substring(indexOf);
        }
        if (str2.length() == 0) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        if (str2.contains("&")) {
            arrayList = new ArrayList(Arrays.asList(str2.split("&")));
        } else {
            arrayList.add(str2);
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (str3.contains("access_token")) {
                it.remove();
            } else {
                if (sb.length() != 0) {
                    sb.append("&");
                } else if (!str3.startsWith("?")) {
                    sb.append("?");
                }
                sb.append(str3);
            }
        }
        return str.replace(str2, sb.toString());
    }

    public final void valueOf(Context context, String str, long j) {
        SharedPreferences.Editor edit = AFInAppEventType(context).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static Map<String, Object> AFInAppEventType(Map<String, Object> map) {
        if (map.containsKey("meta")) {
            return (Map) map.get("meta");
        }
        HashMap hashMap = new HashMap();
        map.put("meta", hashMap);
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[SYNTHETIC, Splitter:B:29:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069 A[Catch:{ all -> 0x003b }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFInAppEventType(java.net.HttpURLConnection r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r2 = r7.getErrorStream()     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x0010
            java.io.InputStream r2 = r7.getInputStream()     // Catch:{ all -> 0x0047 }
        L_0x0010:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0047 }
            r3.<init>(r2)     // Catch:{ all -> 0x0047 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0045 }
            r2.<init>(r3)     // Catch:{ all -> 0x0045 }
            r1 = 0
        L_0x001b:
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x0034
            if (r1 == 0) goto L_0x002a
            r1 = 10
            java.lang.Character r1 = java.lang.Character.valueOf(r1)     // Catch:{ all -> 0x0040 }
            goto L_0x002c
        L_0x002a:
            java.lang.String r1 = ""
        L_0x002c:
            r0.append(r1)     // Catch:{ all -> 0x0040 }
            r0.append(r4)     // Catch:{ all -> 0x0040 }
            r1 = 1
            goto L_0x001b
        L_0x0034:
            r2.close()     // Catch:{ all -> 0x003b }
            r3.close()     // Catch:{ all -> 0x003b }
            goto L_0x006c
        L_0x003b:
            r7 = move-exception
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.Throwable) r7)
            goto L_0x006c
        L_0x0040:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0049
        L_0x0045:
            r2 = move-exception
            goto L_0x0049
        L_0x0047:
            r2 = move-exception
            r3 = r1
        L_0x0049:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r5 = "Could not read connection response from: "
            r4.<init>(r5)     // Catch:{ all -> 0x008f }
            java.net.URL r7 = r7.getURL()     // Catch:{ all -> 0x008f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008f }
            r4.append(r7)     // Catch:{ all -> 0x008f }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x008f }
            com.appsflyer.AFLogger.values(r7, r2)     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ all -> 0x003b }
        L_0x0067:
            if (r3 == 0) goto L_0x006c
            r3.close()     // Catch:{ all -> 0x003b }
        L_0x006c:
            java.lang.String r7 = r0.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0076 }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x0076 }
            return r7
        L_0x0076:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r7 = r0.toString()     // Catch:{ JSONException -> 0x0085 }
            return r7
        L_0x0085:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r7 = r7.toString()
            return r7
        L_0x008f:
            r7 = move-exception
            if (r1 == 0) goto L_0x0098
            r1.close()     // Catch:{ all -> 0x0096 }
            goto L_0x0098
        L_0x0096:
            r0 = move-exception
            goto L_0x009e
        L_0x0098:
            if (r3 == 0) goto L_0x00a1
            r3.close()     // Catch:{ all -> 0x0096 }
            goto L_0x00a1
        L_0x009e:
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.Throwable) r0)
        L_0x00a1:
            goto L_0x00a3
        L_0x00a2:
            throw r7
        L_0x00a3:
            goto L_0x00a2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1387af.AFInAppEventType(java.net.HttpURLConnection):java.lang.String");
    }

    public static String valueOf(String str) {
        return AppsFlyerProperties.getInstance().getString(str);
    }

    public static void AFKeystoreWrapper(Context context, Map<String, ? super String> map) {
        C1489u uVar = C1489u.C1491e.values;
        C1489u.C1490a values2 = C1489u.values(context);
        map.put("network", values2.AFInAppEventType);
        String str = values2.AFInAppEventParameterName;
        if (str != null) {
            map.put("operator", str);
        }
        String str2 = values2.valueOf;
        if (str2 != null) {
            map.put("carrier", str2);
        }
    }

    private boolean valueOf(Context context) {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            this.getOutOfStore = new ConcurrentHashMap();
            C13935 r4 = new C1497y.C1499e() {
                public final void AFInAppEventParameterName(@NonNull String str, @NonNull String str2) {
                    C1387af.this.getOutOfStore.put("signedData", str);
                    C1387af.this.getOutOfStore.put("signature", str2);
                    C1387af.this.getOutOfStore.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.AFInAppEventParameterName("Successfully retrieved Google LVL data.");
                }

                public final void AFInAppEventType(String str, Exception exc) {
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    C1387af.this.getOutOfStore.put("error", message);
                    AFLogger.AFInAppEventParameterName(str, (Throwable) exc);
                }
            };
            try {
                Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                C1497y.C14985 r7 = new InvocationHandler(r4) {
                    public /* synthetic */ C1499e values;

                    public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.y.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.y.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                method.invoke((Object) null, new Object[]{Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r7)});
            } catch (ClassNotFoundException e) {
                r4.AFInAppEventType(e.getClass().getSimpleName(), e);
            } catch (NoSuchMethodException e2) {
                r4.AFInAppEventType(e2.getClass().getSimpleName(), e2);
            } catch (IllegalAccessException e3) {
                r4.AFInAppEventType(e3.getClass().getSimpleName(), e3);
            } catch (InvocationTargetException e4) {
                r4.AFInAppEventType(e4.getClass().getSimpleName(), e4);
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static /* synthetic */ void AFKeystoreWrapper(C1387af afVar, C1480h hVar) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder("url: ");
        sb.append(hVar.onInstallConversionFailureNative);
        AFLogger.AFInAppEventParameterName(sb.toString());
        if (hVar.init != null) {
            str = Base64.encodeToString(hVar.values(), 2);
            AFLogger.AFInAppEventParameterName("cached data: ".concat(String.valueOf(str)));
        } else {
            str = new JSONObject(hVar.valueOf()).toString();
            String replaceAll = str.replaceAll("\\p{C}", "*Non-printing character*");
            if (!replaceAll.equals(str)) {
                AFLogger.AFVersionDeclaration("Payload contains non-printing characters");
                str = replaceAll;
            }
            C1415an.AFKeystoreWrapper("data: ".concat(str));
        }
        C1414am.AFKeystoreWrapper().valueOf("server_request", hVar.onInstallConversionFailureNative, str);
        try {
            afVar.AFInAppEventType(hVar);
        } catch (IOException e) {
            AFLogger.values("Exception in sendRequestToServer. ", e);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                afVar.AFInAppEventType(hVar.values(hVar.onInstallConversionFailureNative.replace("https:", "http:")));
                return;
            }
            StringBuilder sb2 = new StringBuilder("failed to send request to server. ");
            sb2.append(e.getLocalizedMessage());
            AFLogger.AFInAppEventParameterName(sb2.toString());
            throw e;
        }
    }

    public final void valueOf(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.AFInAppEventParameterName("app went to background");
            SharedPreferences AFInAppEventType2 = AFInAppEventType(weakReference.get());
            AppsFlyerProperties.getInstance().saveProperties(AFInAppEventType2);
            long j = this.updateServerUninstallToken - this.onValidateInAppFailure;
            HashMap hashMap = new HashMap();
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (string == null) {
                AFLogger.AFVersionDeclaration("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            String string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            C1471d.C1472a.C1473d AFKeystoreWrapper2 = C1380ab.AFKeystoreWrapper(weakReference.get().getContentResolver());
            if (AFKeystoreWrapper2 != null) {
                hashMap.put("amazon_aid", AFKeystoreWrapper2.valueOf);
                hashMap.put("amazon_aid_limit", String.valueOf(AFKeystoreWrapper2.AFInAppEventType));
            }
            String string3 = AppsFlyerProperties.getInstance().getString("advertiserId");
            if (string3 != null) {
                hashMap.put("advertiserId", string3);
            }
            hashMap.put("app_id", weakReference.get().getPackageName());
            hashMap.put("devkey", string);
            hashMap.put(ProfileTable.Columns.COLUMN_UID, C1412ak.AFKeystoreWrapper(weakReference));
            hashMap.put("time_in_app", String.valueOf(j / 1000));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", "Android");
            hashMap.put("launch_counter", Integer.toString(AFInAppEventParameterName(AFInAppEventType2, "appsFlyerCount", false)));
            hashMap.put("channel", AFInAppEventParameterName(weakReference.get()));
            if (string2 == null) {
                string2 = "";
            }
            hashMap.put("originalAppsflyerId", string2);
            if (this.setOaidData) {
                try {
                    AFLogger.AFInAppEventType("Running callStats task");
                    C1449bn bnVar = new C1449bn();
                    bnVar.onConversionDataSuccess = isStopped();
                    new Thread(new C1482k((C1443bh) bnVar.AFKeystoreWrapper(hashMap).values(String.format(onAppOpenAttributionNative, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), onAttributionFailure.getHostName()})))).start();
                } catch (Throwable th) {
                    AFLogger.values("Could not send callStats request", th);
                }
            } else {
                AFLogger.AFInAppEventType("Stats call is disabled, ignore ...");
            }
        }
    }

    @Nullable
    public static String values(String str, PackageManager packageManager, String str2) {
        Object obj;
        try {
            Bundle bundle = packageManager.getApplicationInfo(str2, 128).metaData;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Could not find ");
            sb.append(str);
            sb.append(" value in the manifest");
            AFLogger.values(sb.toString(), th);
            return null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[SYNTHETIC, Splitter:B:16:0x0031] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0028=Splitter:B:13:0x0028, B:22:0x003f=Splitter:B:22:0x003f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String values(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r3)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.values(r0, r5)
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            goto L_0x0028
        L_0x0026:
            r4 = move-exception
            r2 = r0
        L_0x0028:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.values(r5, r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
            goto L_0x0059
        L_0x0035:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.values(r5, r4)
            goto L_0x0059
        L_0x003e:
            r2 = r0
        L_0x003f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x005a }
            r5.append(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
        L_0x0059:
            return r0
        L_0x005a:
            r4 = move-exception
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.values(r0, r5)
        L_0x0069:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1387af.values(java.io.File, java.lang.String):java.lang.String");
    }

    public static SharedPreferences AFInAppEventType(Context context) {
        C1387af afVar = onAttributionFailure;
        if (afVar.setUserEmails == null) {
            afVar.setUserEmails = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        }
        return onAttributionFailure.setUserEmails;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:25|26|27|28|(2:30|31)|32|33|(1:35)|36|(6:(1:40)|(1:42)|(1:44)(2:45|(2:47|(1:49)(2:50|(3:52|(1:54)|55))))|56|(1:60)|61)(1:(1:63))|64|65|66) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x009b */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f0 A[ADDED_TO_REGION, Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0182 A[Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b9 A[SYNTHETIC, Splitter:B:71:0x01b9] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFInAppEventType(com.appsflyer.internal.C1480h r17) throws java.io.IOException {
        /*
            r16 = this;
            r8 = r16
            r0 = r17
            java.net.URL r1 = new java.net.URL
            java.lang.String r2 = r0.onInstallConversionFailureNative
            r1.<init>(r2)
            byte[] r2 = r17.values()
            java.lang.String r3 = r0.AFLogger$LogLevel
            java.lang.String r4 = r0.init
            boolean r5 = r17.AFInAppEventType()
            android.app.Application r6 = r0.valueOf
            com.appsflyer.attribution.AppsFlyerRequestListener r7 = r0.values
            r10 = 1
            if (r5 == 0) goto L_0x0024
            int r11 = r0.onDeepLinkingNative
            if (r11 != r10) goto L_0x0024
            r11 = 1
            goto L_0x0025
        L_0x0024:
            r11 = 0
        L_0x0025:
            if (r11 == 0) goto L_0x003a
            org.json.JSONObject r12 = r8.setAdditionalData     // Catch:{ JSONException -> 0x0035 }
            java.lang.String r13 = "from_fg"
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0035 }
            long r9 = r8.onValidateInAppFailure     // Catch:{ JSONException -> 0x0035 }
            long r14 = r14 - r9
            r12.put(r13, r14)     // Catch:{ JSONException -> 0x0035 }
        L_0x0035:
            long r9 = java.lang.System.currentTimeMillis()
            goto L_0x003c
        L_0x003a:
            r9 = 0
        L_0x003c:
            java.net.URLConnection r13 = r1.openConnection()     // Catch:{ all -> 0x01c0 }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ all -> 0x01c0 }
            java.lang.String r14 = "POST"
            r13.setRequestMethod(r14)     // Catch:{ all -> 0x01bd }
            int r14 = r2.length     // Catch:{ all -> 0x01bd }
            java.lang.String r15 = "Content-Length"
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x01bd }
            r13.setRequestProperty(r15, r14)     // Catch:{ all -> 0x01bd }
            java.lang.String r14 = "Content-Type"
            boolean r15 = r17.AFKeystoreWrapper()     // Catch:{ all -> 0x01bd }
            if (r15 == 0) goto L_0x005c
            java.lang.String r15 = "application/octet-stream"
            goto L_0x005e
        L_0x005c:
            java.lang.String r15 = "application/json"
        L_0x005e:
            r13.setRequestProperty(r14, r15)     // Catch:{ all -> 0x01bd }
            r14 = 10000(0x2710, float:1.4013E-41)
            r13.setConnectTimeout(r14)     // Catch:{ all -> 0x01bd }
            r14 = 1
            r13.setDoOutput(r14)     // Catch:{ all -> 0x01bd }
            com.appsflyer.AppsFlyerProperties r15 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x01bd }
            java.lang.String r12 = "http_cache"
            boolean r12 = r15.getBoolean(r12, r14)     // Catch:{ all -> 0x01bd }
            if (r12 != 0) goto L_0x007a
            r12 = 0
            r13.setUseCaches(r12)     // Catch:{ all -> 0x01bd }
        L_0x007a:
            java.io.DataOutputStream r12 = new java.io.DataOutputStream     // Catch:{ all -> 0x01b5 }
            java.io.OutputStream r14 = r13.getOutputStream()     // Catch:{ all -> 0x01b5 }
            r12.<init>(r14)     // Catch:{ all -> 0x01b5 }
            r12.write(r2)     // Catch:{ all -> 0x01b3 }
            r12.close()     // Catch:{ all -> 0x01bd }
            int r2 = r13.getResponseCode()     // Catch:{ all -> 0x01bd }
            if (r11 == 0) goto L_0x009b
            org.json.JSONObject r11 = r8.setAdditionalData     // Catch:{ JSONException -> 0x009b }
            java.lang.String r12 = "net"
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x009b }
            long r14 = r14 - r9
            r11.put(r12, r14)     // Catch:{ JSONException -> 0x009b }
        L_0x009b:
            com.appsflyer.internal.aw r9 = r8.AFLogger$LogLevel     // Catch:{ all -> 0x01bd }
            if (r9 != 0) goto L_0x00a6
            com.appsflyer.internal.aw r9 = new com.appsflyer.internal.aw     // Catch:{ all -> 0x01bd }
            r9.<init>(r6)     // Catch:{ all -> 0x01bd }
            r8.AFLogger$LogLevel = r9     // Catch:{ all -> 0x01bd }
        L_0x00a6:
            com.appsflyer.internal.aw r9 = r8.AFLogger$LogLevel     // Catch:{ all -> 0x01bd }
            java.lang.String r10 = "first_launch"
            org.json.JSONObject r11 = r8.setAdditionalData     // Catch:{ all -> 0x01bd }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences r9 = r9.AFInAppEventType     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences$Editor r9 = r9.putString(r10, r11)     // Catch:{ all -> 0x01bd }
            r9.apply()     // Catch:{ all -> 0x01bd }
            java.lang.String r9 = AFInAppEventType((java.net.HttpURLConnection) r13)     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.am r10 = com.appsflyer.internal.C1414am.AFKeystoreWrapper()     // Catch:{ all -> 0x01bd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01bd }
            java.lang.String r11 = "server_response"
            r12 = 2
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ all -> 0x01bd }
            java.lang.String r14 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x01bd }
            r15 = 0
            r12[r15] = r14     // Catch:{ all -> 0x01bd }
            r14 = 1
            r12[r14] = r9     // Catch:{ all -> 0x01bd }
            r10.valueOf(r11, r1, r12)     // Catch:{ all -> 0x01bd }
            java.lang.String r1 = "response code: "
            java.lang.String r10 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x01bd }
            java.lang.String r1 = r1.concat(r10)     // Catch:{ all -> 0x01bd }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r1)     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences r10 = AFInAppEventType((android.content.Context) r6)     // Catch:{ all -> 0x01bd }
            r1 = 200(0xc8, float:2.8E-43)
            if (r2 != r1) goto L_0x0182
            if (r6 == 0) goto L_0x00fa
            if (r5 == 0) goto L_0x00fa
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01bd }
            r8.onValidateInApp = r11     // Catch:{ all -> 0x01bd }
        L_0x00fa:
            if (r7 == 0) goto L_0x00ff
            r7.onSuccess()     // Catch:{ all -> 0x01bd }
        L_0x00ff:
            if (r4 == 0) goto L_0x0108
            com.appsflyer.internal.C1399ag.AFInAppEventType()     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.C1399ag.values(r4, r6)     // Catch:{ all -> 0x01bd }
            goto L_0x0151
        L_0x0108:
            java.lang.String r1 = "sentSuccessfully"
            java.lang.String r4 = "true"
            android.content.SharedPreferences r5 = AFInAppEventType((android.content.Context) r6)     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x01bd }
            r5.putString(r1, r4)     // Catch:{ all -> 0x01bd }
            r5.apply()     // Catch:{ all -> 0x01bd }
            boolean r1 = r8.AppsFlyerConversionListener     // Catch:{ all -> 0x01bd }
            if (r1 != 0) goto L_0x0151
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01bd }
            long r11 = r8.getLevel     // Catch:{ all -> 0x01bd }
            long r4 = r4 - r11
            r11 = 15000(0x3a98, double:7.411E-320)
            int r1 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x012c
            goto L_0x0151
        L_0x012c:
            java.util.concurrent.ScheduledExecutorService r1 = r8.AppsFlyerLib     // Catch:{ all -> 0x01bd }
            if (r1 != 0) goto L_0x0151
            com.appsflyer.internal.n r1 = com.appsflyer.internal.C1486n.valueOf     // Catch:{ all -> 0x01bd }
            if (r1 != 0) goto L_0x013b
            com.appsflyer.internal.n r1 = new com.appsflyer.internal.n     // Catch:{ all -> 0x01bd }
            r1.<init>()     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.C1486n.valueOf = r1     // Catch:{ all -> 0x01bd }
        L_0x013b:
            com.appsflyer.internal.n r1 = com.appsflyer.internal.C1486n.valueOf     // Catch:{ all -> 0x01bd }
            java.util.concurrent.ScheduledThreadPoolExecutor r1 = r1.values()     // Catch:{ all -> 0x01bd }
            r8.AppsFlyerLib = r1     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.af$b r1 = new com.appsflyer.internal.af$b     // Catch:{ all -> 0x01bd }
            r1.<init>(r6)     // Catch:{ all -> 0x01bd }
            java.util.concurrent.ScheduledExecutorService r4 = r8.AppsFlyerLib     // Catch:{ all -> 0x01bd }
            r11 = 1
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x01bd }
            AFInAppEventParameterName(r4, r1, r11, r5)     // Catch:{ all -> 0x01bd }
        L_0x0151:
            com.appsflyer.internal.az r1 = new com.appsflyer.internal.az     // Catch:{ all -> 0x01bd }
            r1.<init>(r6)     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.m r4 = r1.AFInAppEventParameterName()     // Catch:{ all -> 0x01bd }
            if (r4 == 0) goto L_0x0174
            boolean r5 = r4.AFKeystoreWrapper()     // Catch:{ all -> 0x01bd }
            if (r5 == 0) goto L_0x0174
            java.lang.String r4 = r4.AFKeystoreWrapper     // Catch:{ all -> 0x01bd }
            java.lang.String r5 = "Resending Uninstall token to AF servers: "
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x01bd }
            java.lang.String r5 = r5.concat(r7)     // Catch:{ all -> 0x01bd }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r5)     // Catch:{ all -> 0x01bd }
            r1.valueOf(r4)     // Catch:{ all -> 0x01bd }
        L_0x0174:
            org.json.JSONObject r1 = com.appsflyer.internal.C1417ap.values(r9)     // Catch:{ all -> 0x01bd }
            java.lang.String r4 = "send_background"
            r5 = 0
            boolean r1 = r1.optBoolean(r4, r5)     // Catch:{ all -> 0x01bd }
            r8.setOaidData = r1     // Catch:{ all -> 0x01bd }
            goto L_0x019f
        L_0x0182:
            if (r7 == 0) goto L_0x019f
            int r1 = com.appsflyer.attribution.RequestError.RESPONSE_CODE_FAILURE     // Catch:{ all -> 0x01bd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bd }
            r4.<init>()     // Catch:{ all -> 0x01bd }
            java.lang.String r5 = com.appsflyer.internal.C1426at.AFKeystoreWrapper     // Catch:{ all -> 0x01bd }
            r4.append(r5)     // Catch:{ all -> 0x01bd }
            java.lang.String r5 = " "
            r4.append(r5)     // Catch:{ all -> 0x01bd }
            r4.append(r2)     // Catch:{ all -> 0x01bd }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01bd }
            r7.onError(r1, r4)     // Catch:{ all -> 0x01bd }
        L_0x019f:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01bd }
            r9 = 0
            r1 = r16
            r2 = r17
            r4 = r6
            r5 = r10
            r6 = r7
            r7 = r9
            com.appsflyer.internal.C1432ay.AFKeystoreWrapper(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x01bd }
            r13.disconnect()
            return
        L_0x01b3:
            r0 = move-exception
            goto L_0x01b7
        L_0x01b5:
            r0 = move-exception
            r12 = 0
        L_0x01b7:
            if (r12 == 0) goto L_0x01bc
            r12.close()     // Catch:{ all -> 0x01bd }
        L_0x01bc:
            throw r0     // Catch:{ all -> 0x01bd }
        L_0x01bd:
            r0 = move-exception
            r12 = r13
            goto L_0x01c2
        L_0x01c0:
            r0 = move-exception
            r12 = 0
        L_0x01c2:
            if (r12 == 0) goto L_0x01c7
            r12.disconnect()
        L_0x01c7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1387af.AFInAppEventType(com.appsflyer.internal.h):void");
    }

    private String values(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        String string = AFInAppEventType(context).getString("appsFlyerFirstInstall", (String) null);
        if (string == null) {
            if (AFKeystoreWrapper(context)) {
                AFLogger.AFInAppEventType("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
            } else {
                str = "";
            }
            string = str;
            SharedPreferences.Editor edit = AFInAppEventType(context).edit();
            edit.putString("appsFlyerFirstInstall", string);
            edit.apply();
        }
        AFLogger.AFInAppEventParameterName("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    private void values(C1480h hVar) {
        boolean z = hVar.AFVersionDeclaration == null;
        if (AFInAppEventType()) {
            AFLogger.AFInAppEventParameterName("CustomerUserId not set, reporting is disabled", true);
            return;
        }
        if (z) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                AFLogger.AFInAppEventParameterName("Allowing multiple launches within a 5 second time window.");
            } else if (AFKeystoreWrapper()) {
                AppsFlyerRequestListener appsFlyerRequestListener = hVar.values;
                if (appsFlyerRequestListener != null) {
                    appsFlyerRequestListener.onError(RequestError.EVENT_TIMEOUT, C1426at.valueOf);
                    return;
                }
                return;
            }
            this.onDeepLinking = System.currentTimeMillis();
        }
        if (C1486n.valueOf == null) {
            C1486n.valueOf = new C1486n();
        }
        AFInAppEventParameterName(C1486n.valueOf.values(), new C1396a(this, hVar, (byte) 0), 0, TimeUnit.MILLISECONDS);
    }

    public final void valueOf(Context context, Map<String, Object> map, Uri uri) {
        if (!map.containsKey("af_deeplink")) {
            String values2 = values(uri.toString());
            C1474f AFInAppEventParameterName2 = C1474f.AFInAppEventParameterName();
            String str = AFInAppEventParameterName2.getLevel;
            if (!(str == null || AFInAppEventParameterName2.AFVersionDeclaration == null || !values2.contains(str))) {
                Uri.Builder buildUpon = Uri.parse(values2).buildUpon();
                Uri.Builder buildUpon2 = Uri.EMPTY.buildUpon();
                for (Map.Entry next : AFInAppEventParameterName2.AFVersionDeclaration.entrySet()) {
                    buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                    buildUpon2.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                }
                values2 = buildUpon.build().toString();
                map.put("appended_query_params", buildUpon2.build().getEncodedQuery());
            }
            map.put("af_deeplink", values2);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        C1418aq aqVar = new C1418aq(uri, this, context);
        if (aqVar.AFInAppEventType) {
            map.put("isBrandedDomain", Boolean.TRUE);
        }
        C1381ac.AFInAppEventType(context, hashMap, uri);
        if (aqVar.AFKeystoreWrapper()) {
            aqVar.AFInAppEventParameterName = new C1418aq.C1419d() {
                public final void AFKeystoreWrapper(Map<String, String> map) {
                    for (String next : map.keySet()) {
                        hashMap.put(next, map.get(next));
                    }
                    C1425as.AFInAppEventType((Map<String, String>) hashMap);
                }

                public final void valueOf(String str) {
                    C1425as.AFInAppEventType(str);
                }
            };
            if (C1486n.valueOf == null) {
                C1486n.valueOf = new C1486n();
            }
            C1486n.valueOf.AFInAppEventParameterName().execute(aqVar);
            return;
        }
        C1425as.AFInAppEventType((Map<String, String>) hashMap);
    }

    public static boolean valueOf(File file) {
        return file == null || !file.exists();
    }

    public final Map<String, Object> valueOf() {
        HashMap hashMap = new HashMap();
        if (AppsFlyer2dXConversionCallback()) {
            hashMap.put("lvl", this.getOutOfStore);
        } else if (this.setPhoneNumber) {
            HashMap hashMap2 = new HashMap();
            this.getOutOfStore = hashMap2;
            hashMap2.put("error", "operation timed out.");
            hashMap.put("lvl", this.getOutOfStore);
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public boolean valueOf(C1480h hVar, SharedPreferences sharedPreferences) {
        int AFInAppEventParameterName2 = AFInAppEventParameterName(sharedPreferences, "appsFlyerCount", false);
        return (!sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false) && AFInAppEventParameterName2 == 1) || (AFInAppEventParameterName2 == 1 && !(hVar instanceof C1442bg));
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x020d */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x027f A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0362 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0375 A[Catch:{ Exception -> 0x037b }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03bc A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03c2 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03f7 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0410 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x049f A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x04b4 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04b5 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04c9 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x04d6 A[SYNTHETIC, Splitter:B:219:0x04d6] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x04f4 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0503 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0510 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0516 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x052d A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0545 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x055c A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x058a A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x05a6 A[SYNTHETIC, Splitter:B:256:0x05a6] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x05c5 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x05d8  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x05df A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0635 A[SYNTHETIC, Splitter:B:293:0x0635] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x063d A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0662 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0678 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0695 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x06ce A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x06d8 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x06ee A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x06f9 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x0727 A[SYNTHETIC, Splitter:B:350:0x0727] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x07e1 A[Catch:{ all -> 0x0855 }] */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0889 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x0892 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x08c7 A[SYNTHETIC, Splitter:B:433:0x08c7] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0913 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x0939 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x096d A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x096f A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x097f  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0a03 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:484:0x0a04 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:487:0x0a3f A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:509:0x0baa A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0c5f A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:516:0x0c67 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0211 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0220 A[SYNTHETIC, Splitter:B:81:0x0220] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x022c A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0254 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0263 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0266 A[Catch:{ Exception -> 0x00a1, all -> 0x0c73 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> valueOf(com.appsflyer.internal.C1480h r29) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            java.lang.String r3 = "yyyy-MM-dd_HHmmssZ"
            java.lang.String r4 = "use cached IMEI: "
            java.lang.String r5 = "uid"
            java.lang.String r6 = "appid"
            java.lang.String r7 = "INSTALL_STORE"
            java.lang.String r8 = "gcd"
            java.lang.String r9 = "prev_event_name"
            java.lang.String r10 = "preInstallName"
            android.app.Application r11 = r2.valueOf
            java.lang.String r12 = r2.AFLogger$LogLevel
            java.lang.String r13 = r2.AFVersionDeclaration
            org.json.JSONObject r14 = new org.json.JSONObject
            java.util.Map<java.lang.String, java.lang.Object> r15 = r2.AFKeystoreWrapper
            if (r15 != 0) goto L_0x0026
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
        L_0x0026:
            r14.<init>(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = r2.AppsFlyer2dXConversionCallback
            r16 = r3
            android.content.SharedPreferences r3 = AFInAppEventType((android.content.Context) r11)
            r17 = r5
            boolean r5 = r29.AFInAppEventType()
            r18 = r4
            java.lang.String r4 = r2.AFInAppEventParameterName
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFInAppEventType
            com.appsflyer.internal.C1380ab.AFKeystoreWrapper(r11, r2)
            java.util.Date r19 = new java.util.Date
            r19.<init>()
            r20 = r6
            r21 = r7
            long r6 = r19.getTime()
            r19 = r4
            java.lang.String r4 = java.lang.Long.toString(r6)
            r22 = r12
            java.lang.String r12 = "af_timestamp"
            r2.put(r12, r4)
            java.lang.String r4 = com.appsflyer.internal.C1471d.AFInAppEventType(r11, r6)
            if (r4 == 0) goto L_0x0069
            java.lang.String r6 = "cksm_v1"
            r2.put(r6, r4)
        L_0x0069:
            boolean r4 = r28.isStopped()     // Catch:{ all -> 0x0c73 }
            if (r4 != 0) goto L_0x0087
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "******* sendTrackingWithEvent: "
            r4.<init>(r6)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x007b
            java.lang.String r6 = "Launch"
            goto L_0x007c
        L_0x007b:
            r6 = r13
        L_0x007c:
            r4.append(r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r4)     // Catch:{ all -> 0x0c73 }
            goto L_0x008c
        L_0x0087:
            java.lang.String r4 = "Reporting has been stopped"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r4)     // Catch:{ all -> 0x0c73 }
        L_0x008c:
            com.appsflyer.internal.C1399ag.AFInAppEventType()     // Catch:{ all -> 0x0c73 }
            java.io.File r4 = com.appsflyer.internal.C1399ag.valueOf(r11)     // Catch:{ Exception -> 0x00a1 }
            boolean r4 = r4.exists()     // Catch:{ Exception -> 0x00a1 }
            if (r4 != 0) goto L_0x00a8
            java.io.File r4 = com.appsflyer.internal.C1399ag.valueOf(r11)     // Catch:{ Exception -> 0x00a1 }
            r4.mkdir()     // Catch:{ Exception -> 0x00a1 }
            goto L_0x00a8
        L_0x00a1:
            r0 = move-exception
            r4 = r0
            java.lang.String r6 = "Could not create cache directory"
            com.appsflyer.AFLogger.values(r6, r4)     // Catch:{ all -> 0x0c73 }
        L_0x00a8:
            android.content.pm.PackageManager r4 = r11.getPackageManager()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r6 = r11.getPackageName()     // Catch:{ Exception -> 0x00e4 }
            r7 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r6, r7)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String[] r4 = r4.requestedPermissions     // Catch:{ Exception -> 0x00e4 }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r6 = "android.permission.INTERNET"
            boolean r6 = r4.contains(r6)     // Catch:{ Exception -> 0x00e4 }
            if (r6 != 0) goto L_0x00c9
            java.lang.String r6 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.AFVersionDeclaration(r6)     // Catch:{ Exception -> 0x00e4 }
        L_0x00c9:
            java.lang.String r6 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = r4.contains(r6)     // Catch:{ Exception -> 0x00e4 }
            if (r6 != 0) goto L_0x00d6
            java.lang.String r6 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.AFVersionDeclaration(r6)     // Catch:{ Exception -> 0x00e4 }
        L_0x00d6:
            java.lang.String r6 = "android.permission.ACCESS_WIFI_STATE"
            boolean r4 = r4.contains(r6)     // Catch:{ Exception -> 0x00e4 }
            if (r4 != 0) goto L_0x00eb
            java.lang.String r4 = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.AFVersionDeclaration(r4)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00eb
        L_0x00e4:
            r0 = move-exception
            r4 = r0
            java.lang.String r6 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.values(r6, r4)     // Catch:{ all -> 0x0c73 }
        L_0x00eb:
            java.lang.String r4 = "af_events_api"
            java.lang.String r6 = "1"
            r2.put(r4, r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "brand"
            java.lang.String r6 = android.os.Build.BRAND     // Catch:{ all -> 0x0c73 }
            r2.put(r4, r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "device"
            java.lang.String r6 = android.os.Build.DEVICE     // Catch:{ all -> 0x0c73 }
            r2.put(r4, r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "product"
            java.lang.String r6 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0c73 }
            r2.put(r4, r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "sdk"
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0c73 }
            r2.put(r4, r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "model"
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x0c73 }
            r2.put(r4, r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "deviceType"
            java.lang.String r6 = android.os.Build.TYPE     // Catch:{ all -> 0x0c73 }
            r2.put(r4, r6)     // Catch:{ all -> 0x0c73 }
            values((android.content.Context) r11, (java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            com.appsflyer.internal.aw r6 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x0c73 }
            if (r6 != 0) goto L_0x0132
            com.appsflyer.internal.aw r6 = new com.appsflyer.internal.aw     // Catch:{ all -> 0x0c73 }
            r6.<init>(r11)     // Catch:{ all -> 0x0c73 }
            r1.AFLogger$LogLevel = r6     // Catch:{ all -> 0x0c73 }
        L_0x0132:
            com.appsflyer.internal.aw r6 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x0c73 }
            r29 = r12
            r7 = r13
            if (r5 == 0) goto L_0x02b2
            boolean r9 = AFKeystoreWrapper((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            if (r9 == 0) goto L_0x0189
            boolean r9 = r4.isOtherSdkStringDisabled()     // Catch:{ all -> 0x0c73 }
            if (r9 != 0) goto L_0x0152
            float r9 = AppsFlyer2dXConversionCallback((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            java.lang.String r13 = "batteryLevel"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0c73 }
            r2.put(r13, r9)     // Catch:{ all -> 0x0c73 }
        L_0x0152:
            values((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0c73 }
            r13 = 23
            if (r9 < r13) goto L_0x0164
            java.lang.Class<android.app.UiModeManager> r9 = android.app.UiModeManager.class
            java.lang.Object r9 = r11.getSystemService(r9)     // Catch:{ all -> 0x0c73 }
            android.app.UiModeManager r9 = (android.app.UiModeManager) r9     // Catch:{ all -> 0x0c73 }
            goto L_0x016c
        L_0x0164:
            java.lang.String r9 = "uimode"
            java.lang.Object r9 = r11.getSystemService(r9)     // Catch:{ all -> 0x0c73 }
            android.app.UiModeManager r9 = (android.app.UiModeManager) r9     // Catch:{ all -> 0x0c73 }
        L_0x016c:
            if (r9 == 0) goto L_0x017c
            int r9 = r9.getCurrentModeType()     // Catch:{ all -> 0x0c73 }
            r13 = 4
            if (r9 != r13) goto L_0x017c
            java.lang.String r9 = "tv"
            java.lang.Boolean r13 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0c73 }
            r2.put(r9, r13)     // Catch:{ all -> 0x0c73 }
        L_0x017c:
            boolean r9 = com.appsflyer.internal.C1438bc.AFKeystoreWrapper(r11)     // Catch:{ all -> 0x0c73 }
            if (r9 == 0) goto L_0x0189
            java.lang.String r9 = "inst_app"
            java.lang.Boolean r13 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0c73 }
            r2.put(r9, r13)     // Catch:{ all -> 0x0c73 }
        L_0x0189:
            java.lang.String r9 = "timepassedsincelastlaunch"
            android.content.SharedPreferences r13 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            java.lang.String r12 = "AppsFlyerTimePassedSincePrevLaunch"
            r23 = r5
            r24 = r6
            r5 = 0
            long r12 = r13.getLong(r12, r5)     // Catch:{ all -> 0x0c73 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0c73 }
            r27 = r10
            java.lang.String r10 = "AppsFlyerTimePassedSincePrevLaunch"
            r1.valueOf((android.content.Context) r11, (java.lang.String) r10, (long) r5)     // Catch:{ all -> 0x0c73 }
            r25 = 0
            int r10 = (r12 > r25 ? 1 : (r12 == r25 ? 0 : -1))
            if (r10 <= 0) goto L_0x01b1
            long r5 = r5 - r12
            r12 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r12
            goto L_0x01b3
        L_0x01b1:
            r5 = -1
        L_0x01b3:
            java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ all -> 0x0c73 }
            r2.put(r9, r5)     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "oneLinkSlug"
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = "onelinkVersion"
            java.lang.String r6 = r6.getString(r9)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x01d5
            java.lang.String r9 = "onelink_id"
            r2.put(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x01d5:
            if (r6 == 0) goto L_0x01dc
            java.lang.String r5 = "onelink_ver"
            r2.put(r5, r6)     // Catch:{ all -> 0x0c73 }
        L_0x01dc:
            com.appsflyer.internal.aw r5 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x0c73 }
            android.content.SharedPreferences r5 = r5.AFInAppEventType     // Catch:{ all -> 0x0c73 }
            r6 = 0
            java.lang.String r5 = r5.getString(r8, r6)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x020d
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x020d }
            r6.<init>(r5)     // Catch:{ JSONException -> 0x020d }
            java.util.Map r5 = com.appsflyer.internal.C1482k.AFInAppEventParameterName(r6)     // Catch:{ JSONException -> 0x020d }
            boolean r6 = r5.isEmpty()     // Catch:{ JSONException -> 0x020d }
            if (r6 != 0) goto L_0x020d
            java.util.Map r6 = AFInAppEventType((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ JSONException -> 0x020d }
            r6.put(r8, r5)     // Catch:{ JSONException -> 0x020d }
            com.appsflyer.internal.aw r5 = r1.AFLogger$LogLevel     // Catch:{ JSONException -> 0x020d }
            android.content.SharedPreferences r5 = r5.AFInAppEventType     // Catch:{ JSONException -> 0x020d }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ JSONException -> 0x020d }
            r6 = 0
            android.content.SharedPreferences$Editor r5 = r5.putString(r8, r6)     // Catch:{ JSONException -> 0x020d }
            r5.apply()     // Catch:{ JSONException -> 0x020d }
        L_0x020d:
            java.lang.String r5 = r1.setCustomerIdAndLogSession     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0218
            java.lang.String r5 = "phone"
            java.lang.String r6 = r1.setCustomerIdAndLogSession     // Catch:{ all -> 0x0c73 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0c73 }
        L_0x0218:
            boolean r5 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "referrer"
            if (r5 != 0) goto L_0x0223
            r2.put(r6, r15)     // Catch:{ all -> 0x0c73 }
        L_0x0223:
            java.lang.String r5 = "extraReferrers"
            r8 = 0
            java.lang.String r5 = r3.getString(r5, r8)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0231
            java.lang.String r8 = "extraReferrers"
            r2.put(r8, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0231:
            java.lang.String r5 = r4.getReferrer(r11)     // Catch:{ all -> 0x0c73 }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0c73 }
            if (r8 != 0) goto L_0x0244
            java.lang.Object r8 = r2.get(r6)     // Catch:{ all -> 0x0c73 }
            if (r8 != 0) goto L_0x0244
            r2.put(r6, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0244:
            java.lang.String r5 = "prev_session_dur"
            r6 = r24
            android.content.SharedPreferences r8 = r6.AFInAppEventType     // Catch:{ all -> 0x0c73 }
            r9 = 0
            long r12 = r8.getLong(r5, r9)     // Catch:{ all -> 0x0c73 }
            int r5 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x025d
            java.lang.String r5 = "prev_session_dur"
            java.lang.Long r8 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0c73 }
            r2.put(r5, r8)     // Catch:{ all -> 0x0c73 }
        L_0x025d:
            java.lang.String r5 = "exception_number"
            android.app.Application r8 = com.appsflyer.internal.C1431ax.AFInAppEventParameterName     // Catch:{ all -> 0x0c73 }
            if (r8 != 0) goto L_0x0266
            r12 = -1
            goto L_0x0274
        L_0x0266:
            android.app.Application r8 = com.appsflyer.internal.C1431ax.AFInAppEventParameterName     // Catch:{ all -> 0x0c73 }
            android.content.SharedPreferences r8 = AFInAppEventType((android.content.Context) r8)     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = "exception_number"
            r12 = 0
            long r12 = r8.getLong(r9, r12)     // Catch:{ all -> 0x0c73 }
        L_0x0274:
            java.lang.Long r8 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0c73 }
            r2.put(r5, r8)     // Catch:{ all -> 0x0c73 }
            com.appsflyer.internal.au r5 = r1.setAppInviteOneLink     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x02aa
            com.appsflyer.internal.au r5 = r1.setAppInviteOneLink     // Catch:{ all -> 0x0c73 }
            java.util.Map<java.lang.String, java.lang.Object> r8 = r5.valueOf     // Catch:{ all -> 0x0c73 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0c73 }
            if (r8 != 0) goto L_0x0290
            java.lang.String r8 = "partner_data"
            java.util.Map<java.lang.String, java.lang.Object> r9 = r5.valueOf     // Catch:{ all -> 0x0c73 }
            r2.put(r8, r9)     // Catch:{ all -> 0x0c73 }
        L_0x0290:
            java.util.Map<java.lang.String, java.lang.Object> r8 = r5.AFInAppEventParameterName     // Catch:{ all -> 0x0c73 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0c73 }
            if (r8 != 0) goto L_0x02aa
            java.util.Map r8 = AFInAppEventType((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = "partner_data"
            java.util.Map<java.lang.String, java.lang.Object> r10 = r5.AFInAppEventParameterName     // Catch:{ all -> 0x0c73 }
            r8.put(r9, r10)     // Catch:{ all -> 0x0c73 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x0c73 }
            r8.<init>()     // Catch:{ all -> 0x0c73 }
            r5.AFInAppEventParameterName = r8     // Catch:{ all -> 0x0c73 }
        L_0x02aa:
            r25 = r3
            r26 = r4
            r24 = r6
            goto L_0x032a
        L_0x02b2:
            r23 = r5
            r27 = r10
            android.content.SharedPreferences r5 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            android.content.SharedPreferences$Editor r8 = r5.edit()     // Catch:{ all -> 0x0c73 }
            r10 = 0
            java.lang.String r12 = r5.getString(r9, r10)     // Catch:{ Exception -> 0x031d }
            java.lang.String r10 = "prev_event_timestamp"
            java.lang.String r13 = "prev_event_value"
            if (r12 == 0) goto L_0x0304
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x031d }
            r15.<init>()     // Catch:{ Exception -> 0x031d }
            r24 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02fe }
            r6.<init>()     // Catch:{ Exception -> 0x02fe }
            r25 = r3
            r26 = r4
            r3 = -1
            long r3 = r5.getLong(r10, r3)     // Catch:{ Exception -> 0x031b }
            r6.append(r3)     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x031b }
            r15.put(r10, r3)     // Catch:{ Exception -> 0x031b }
            r3 = 0
            java.lang.String r4 = r5.getString(r13, r3)     // Catch:{ Exception -> 0x031b }
            r15.put(r13, r4)     // Catch:{ Exception -> 0x031b }
            r15.put(r9, r12)     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "prev_event"
            java.lang.String r4 = r15.toString()     // Catch:{ Exception -> 0x031b }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x031b }
            goto L_0x030a
        L_0x02fe:
            r0 = move-exception
            r25 = r3
            r26 = r4
            goto L_0x0324
        L_0x0304:
            r25 = r3
            r26 = r4
            r24 = r6
        L_0x030a:
            r8.putString(r9, r7)     // Catch:{ Exception -> 0x031b }
            r8.putString(r13, r14)     // Catch:{ Exception -> 0x031b }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x031b }
            r8.putLong(r10, r3)     // Catch:{ Exception -> 0x031b }
            r8.apply()     // Catch:{ Exception -> 0x031b }
            goto L_0x032a
        L_0x031b:
            r0 = move-exception
            goto L_0x0324
        L_0x031d:
            r0 = move-exception
            r25 = r3
            r26 = r4
            r24 = r6
        L_0x0324:
            r3 = r0
            java.lang.String r4 = "Error while processing previous event."
            com.appsflyer.AFLogger.values(r4, r3)     // Catch:{ all -> 0x0c73 }
        L_0x032a:
            java.lang.String r3 = "KSAppsFlyerId"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "KSAppsFlyerRICounter"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x0356
            if (r4 == 0) goto L_0x0356
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0c73 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0c73 }
            if (r5 <= 0) goto L_0x0356
            java.lang.String r5 = "reinstallCounter"
            r2.put(r5, r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "originalAppsflyerId"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c73 }
        L_0x0356:
            java.lang.String r3 = "additionalCustomData"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x0367
            java.lang.String r4 = "customData"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c73 }
        L_0x0367:
            android.content.pm.PackageManager r3 = r11.getPackageManager()     // Catch:{ Exception -> 0x037b }
            java.lang.String r4 = r11.getPackageName()     // Catch:{ Exception -> 0x037b }
            java.lang.String r3 = r3.getInstallerPackageName(r4)     // Catch:{ Exception -> 0x037b }
            if (r3 == 0) goto L_0x0382
            java.lang.String r4 = "installer_package"
            r2.put(r4, r3)     // Catch:{ Exception -> 0x037b }
            goto L_0x0382
        L_0x037b:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.values(r4, r3)     // Catch:{ all -> 0x0c73 }
        L_0x0382:
            java.lang.String r3 = "sdkExtension"
            r4 = r26
            java.lang.String r3 = r4.getString(r3)     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x0397
            int r5 = r3.length()     // Catch:{ all -> 0x0c73 }
            if (r5 <= 0) goto L_0x0397
            java.lang.String r5 = "sdkExtension"
            r2.put(r5, r3)     // Catch:{ all -> 0x0c73 }
        L_0x0397:
            java.lang.String r3 = r1.AFInAppEventParameterName((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = r1.AFInAppEventParameterName((android.content.Context) r11, (java.lang.String) r3)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x03a7
            boolean r6 = r5.equals(r3)     // Catch:{ all -> 0x0c73 }
            if (r6 == 0) goto L_0x03ab
        L_0x03a7:
            if (r5 != 0) goto L_0x03b0
            if (r3 == 0) goto L_0x03b0
        L_0x03ab:
            java.lang.String r5 = "af_latestchannel"
            r2.put(r5, r3)     // Catch:{ all -> 0x0c73 }
        L_0x03b0:
            android.content.SharedPreferences r3 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            r5 = r21
            boolean r6 = r3.contains(r5)     // Catch:{ all -> 0x0c73 }
            if (r6 == 0) goto L_0x03c2
            r6 = 0
            java.lang.String r3 = r3.getString(r5, r6)     // Catch:{ all -> 0x0c73 }
            goto L_0x03f5
        L_0x03c2:
            boolean r3 = AFKeystoreWrapper((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x03e6
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "api_store_value"
            java.lang.String r3 = r3.getString(r6)     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x03d5
            goto L_0x03e7
        L_0x03d5:
            java.lang.String r3 = "AF_STORE"
            if (r11 == 0) goto L_0x03e6
            android.content.pm.PackageManager r6 = r11.getPackageManager()     // Catch:{ all -> 0x0c73 }
            java.lang.String r8 = r11.getPackageName()     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = values((java.lang.String) r3, (android.content.pm.PackageManager) r6, (java.lang.String) r8)     // Catch:{ all -> 0x0c73 }
            goto L_0x03e7
        L_0x03e6:
            r3 = 0
        L_0x03e7:
            android.content.SharedPreferences r6 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ all -> 0x0c73 }
            r6.putString(r5, r3)     // Catch:{ all -> 0x0c73 }
            r6.apply()     // Catch:{ all -> 0x0c73 }
        L_0x03f5:
            if (r3 == 0) goto L_0x0400
            java.lang.String r5 = "af_installstore"
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x0c73 }
            r2.put(r5, r3)     // Catch:{ all -> 0x0c73 }
        L_0x0400:
            android.content.SharedPreferences r3 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            r6 = r27
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0c73 }
            if (r5 != 0) goto L_0x049d
            boolean r8 = r3.contains(r6)     // Catch:{ all -> 0x0c73 }
            if (r8 == 0) goto L_0x041e
            r5 = 0
            java.lang.String r3 = r3.getString(r6, r5)     // Catch:{ all -> 0x0c73 }
            r5 = r3
            goto L_0x0494
        L_0x041e:
            boolean r3 = AFKeystoreWrapper((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x0484
            java.lang.String r3 = "ro.appsflyer.preinstall.path"
            java.lang.String r3 = AFInAppEventParameterName((java.lang.String) r3)     // Catch:{ all -> 0x0c73 }
            java.io.File r3 = AFKeystoreWrapper((java.lang.String) r3)     // Catch:{ all -> 0x0c73 }
            boolean r5 = valueOf((java.io.File) r3)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0446
            java.lang.String r3 = "AF_PRE_INSTALL_PATH"
            android.content.pm.PackageManager r5 = r11.getPackageManager()     // Catch:{ all -> 0x0c73 }
            java.lang.String r8 = r11.getPackageName()     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = values((java.lang.String) r3, (android.content.pm.PackageManager) r5, (java.lang.String) r8)     // Catch:{ all -> 0x0c73 }
            java.io.File r3 = AFKeystoreWrapper((java.lang.String) r3)     // Catch:{ all -> 0x0c73 }
        L_0x0446:
            boolean r5 = valueOf((java.io.File) r3)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0452
            java.lang.String r3 = "/data/local/tmp/pre_install.appsflyer"
            java.io.File r3 = AFKeystoreWrapper((java.lang.String) r3)     // Catch:{ all -> 0x0c73 }
        L_0x0452:
            boolean r5 = valueOf((java.io.File) r3)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x045e
            java.lang.String r3 = "/etc/pre_install.appsflyer"
            java.io.File r3 = AFKeystoreWrapper((java.lang.String) r3)     // Catch:{ all -> 0x0c73 }
        L_0x045e:
            boolean r5 = valueOf((java.io.File) r3)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0466
            r3 = 0
            goto L_0x046e
        L_0x0466:
            java.lang.String r5 = r11.getPackageName()     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = values((java.io.File) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0c73 }
        L_0x046e:
            if (r3 == 0) goto L_0x0471
            goto L_0x0483
        L_0x0471:
            java.lang.String r3 = "AF_PRE_INSTALL_NAME"
            if (r11 != 0) goto L_0x0477
            r3 = 0
            goto L_0x0483
        L_0x0477:
            android.content.pm.PackageManager r5 = r11.getPackageManager()     // Catch:{ all -> 0x0c73 }
            java.lang.String r8 = r11.getPackageName()     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = values((java.lang.String) r3, (android.content.pm.PackageManager) r5, (java.lang.String) r8)     // Catch:{ all -> 0x0c73 }
        L_0x0483:
            r5 = r3
        L_0x0484:
            if (r5 == 0) goto L_0x0494
            android.content.SharedPreferences r3 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0c73 }
            r3.putString(r6, r5)     // Catch:{ all -> 0x0c73 }
            r3.apply()     // Catch:{ all -> 0x0c73 }
        L_0x0494:
            if (r5 == 0) goto L_0x049d
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            r3.set((java.lang.String) r6, (java.lang.String) r5)     // Catch:{ all -> 0x0c73 }
        L_0x049d:
            if (r5 == 0) goto L_0x04a8
            java.lang.String r3 = "af_preinstall_name"
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ all -> 0x0c73 }
            r2.put(r3, r5)     // Catch:{ all -> 0x0c73 }
        L_0x04a8:
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = "api_store_value"
            java.lang.String r3 = r3.getString(r5)     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x04b5
            goto L_0x04c7
        L_0x04b5:
            java.lang.String r3 = "AF_STORE"
            if (r11 != 0) goto L_0x04bb
            r3 = 0
            goto L_0x04c7
        L_0x04bb:
            android.content.pm.PackageManager r5 = r11.getPackageManager()     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = r11.getPackageName()     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = values((java.lang.String) r3, (android.content.pm.PackageManager) r5, (java.lang.String) r6)     // Catch:{ all -> 0x0c73 }
        L_0x04c7:
            if (r3 == 0) goto L_0x04d2
            java.lang.String r5 = "af_currentstore"
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x0c73 }
            r2.put(r5, r3)     // Catch:{ all -> 0x0c73 }
        L_0x04d2:
            java.lang.String r3 = "appsflyerKey"
            if (r22 == 0) goto L_0x04e2
            int r5 = r22.length()     // Catch:{ all -> 0x0c73 }
            if (r5 <= 0) goto L_0x04e2
            r5 = r22
            r2.put(r3, r5)     // Catch:{ all -> 0x0c73 }
            goto L_0x04f7
        L_0x04e2:
            java.lang.String r5 = "AppsFlyerKey"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0c67
            int r6 = r5.length()     // Catch:{ all -> 0x0c73 }
            if (r6 <= 0) goto L_0x0c67
            r2.put(r3, r5)     // Catch:{ all -> 0x0c73 }
        L_0x04f7:
            java.lang.String r5 = "AppUserId"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0508
            java.lang.String r6 = "appUserId"
            r2.put(r6, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0508:
            java.lang.String r5 = "userEmails"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0516
            java.lang.String r6 = "user_emails"
            r2.put(r6, r5)     // Catch:{ all -> 0x0c73 }
            goto L_0x052b
        L_0x0516:
            java.lang.String r5 = "userEmail"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x052b
            java.lang.String r6 = "sha1_el"
            java.lang.String r5 = com.appsflyer.internal.C1407ai.AFKeystoreWrapper(r5)     // Catch:{ all -> 0x0c73 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0c73 }
        L_0x052b:
            if (r7 == 0) goto L_0x0539
            java.lang.String r5 = "eventName"
            r2.put(r5, r7)     // Catch:{ all -> 0x0c73 }
            if (r14 == 0) goto L_0x0539
            java.lang.String r5 = "eventValue"
            r2.put(r5, r14)     // Catch:{ all -> 0x0c73 }
        L_0x0539:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            r6 = r20
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0550
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0c73 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0550:
            java.lang.String r5 = "currencyCode"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x057e
            int r6 = r5.length()     // Catch:{ all -> 0x0c73 }
            r8 = 3
            if (r6 == r8) goto L_0x0579
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            java.lang.String r8 = "WARNING: currency code should be 3 characters!!! '"
            r6.<init>(r8)     // Catch:{ all -> 0x0c73 }
            r6.append(r5)     // Catch:{ all -> 0x0c73 }
            java.lang.String r8 = "' is not a legal value."
            r6.append(r8)     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AFLogger.AFVersionDeclaration(r6)     // Catch:{ all -> 0x0c73 }
        L_0x0579:
            java.lang.String r6 = "currency"
            r2.put(r6, r5)     // Catch:{ all -> 0x0c73 }
        L_0x057e:
            java.lang.String r5 = "IS_UPDATE"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x058f
            java.lang.String r6 = "isUpdate"
            r2.put(r6, r5)     // Catch:{ all -> 0x0c73 }
        L_0x058f:
            boolean r5 = r1.isPreInstalledApp(r11)     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "af_preinstalled"
            java.lang.String r5 = java.lang.Boolean.toString(r5)     // Catch:{ all -> 0x0c73 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = "collectFacebookAttrId"
            r6 = 1
            boolean r5 = r4.getBoolean(r5, r6)     // Catch:{ all -> 0x0c73 }
            r8 = 0
            if (r5 == 0) goto L_0x05ca
            android.content.pm.PackageManager r5 = r11.getPackageManager()     // Catch:{ NameNotFoundException -> 0x05bd, all -> 0x05b4 }
            java.lang.String r9 = "com.facebook.katana"
            r5.getApplicationInfo(r9, r8)     // Catch:{ NameNotFoundException -> 0x05bd, all -> 0x05b4 }
            java.lang.String r5 = r1.getAttributionId(r11)     // Catch:{ NameNotFoundException -> 0x05bd, all -> 0x05b4 }
            goto L_0x05c3
        L_0x05b4:
            r0 = move-exception
            r5 = r0
            java.lang.String r9 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.values(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x05bb:
            r5 = 0
            goto L_0x05c3
        L_0x05bd:
            java.lang.String r5 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.AFVersionDeclaration(r5)     // Catch:{ all -> 0x0c73 }
            goto L_0x05bb
        L_0x05c3:
            if (r5 == 0) goto L_0x05ca
            java.lang.String r9 = "fb"
            r2.put(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x05ca:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = "deviceTrackingDisabled"
            boolean r9 = r5.getBoolean(r9, r8)     // Catch:{ all -> 0x0c73 }
            java.lang.String r10 = "true"
            if (r9 == 0) goto L_0x05df
            java.lang.String r5 = "deviceTrackingDisabled"
            r2.put(r5, r10)     // Catch:{ all -> 0x0c73 }
            goto L_0x071a
        L_0x05df:
            android.content.SharedPreferences r9 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            java.lang.String r12 = "collectIMEI"
            boolean r12 = r5.getBoolean(r12, r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r13 = "imeiCached"
            r14 = 0
            java.lang.String r13 = r9.getString(r13, r14)     // Catch:{ all -> 0x0c73 }
            if (r12 == 0) goto L_0x0657
            java.lang.String r12 = r1.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0c73 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0c73 }
            if (r12 == 0) goto L_0x0657
            boolean r12 = init((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            if (r12 == 0) goto L_0x065f
            java.lang.String r12 = "phone"
            java.lang.Object r12 = r11.getSystemService(r12)     // Catch:{ InvocationTargetException -> 0x0644, Exception -> 0x062f }
            android.telephony.TelephonyManager r12 = (android.telephony.TelephonyManager) r12     // Catch:{ InvocationTargetException -> 0x0644, Exception -> 0x062f }
            java.lang.Class r14 = r12.getClass()     // Catch:{ InvocationTargetException -> 0x0644, Exception -> 0x062f }
            java.lang.String r15 = "getDeviceId"
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch:{ InvocationTargetException -> 0x0644, Exception -> 0x062f }
            java.lang.reflect.Method r6 = r14.getMethod(r15, r6)     // Catch:{ InvocationTargetException -> 0x0644, Exception -> 0x062f }
            java.lang.Object[] r14 = new java.lang.Object[r8]     // Catch:{ InvocationTargetException -> 0x0644, Exception -> 0x062f }
            java.lang.Object r6 = r6.invoke(r12, r14)     // Catch:{ InvocationTargetException -> 0x0644, Exception -> 0x062f }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ InvocationTargetException -> 0x0644, Exception -> 0x062f }
            if (r6 == 0) goto L_0x061f
            goto L_0x065d
        L_0x061f:
            if (r13 == 0) goto L_0x065f
            r6 = r18
            java.lang.String r12 = r6.concat(r13)     // Catch:{ InvocationTargetException -> 0x062d, Exception -> 0x062b }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r12)     // Catch:{ InvocationTargetException -> 0x062d, Exception -> 0x062b }
            goto L_0x0660
        L_0x062b:
            r0 = move-exception
            goto L_0x0632
        L_0x062d:
            goto L_0x0646
        L_0x062f:
            r0 = move-exception
            r6 = r18
        L_0x0632:
            r12 = r0
            if (r13 == 0) goto L_0x063d
            java.lang.String r6 = r6.concat(r13)     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r6)     // Catch:{ all -> 0x0c73 }
            goto L_0x063e
        L_0x063d:
            r13 = 0
        L_0x063e:
            java.lang.String r6 = "WARNING: other reason: "
            com.appsflyer.AFLogger.values(r6, r12)     // Catch:{ all -> 0x0c73 }
            goto L_0x0660
        L_0x0644:
            r6 = r18
        L_0x0646:
            if (r13 == 0) goto L_0x0650
            java.lang.String r6 = r6.concat(r13)     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r6)     // Catch:{ all -> 0x0c73 }
            goto L_0x0651
        L_0x0650:
            r13 = 0
        L_0x0651:
            java.lang.String r6 = "WARNING: READ_PHONE_STATE is missing."
            com.appsflyer.AFLogger.AFVersionDeclaration(r6)     // Catch:{ all -> 0x0c73 }
            goto L_0x0660
        L_0x0657:
            java.lang.String r6 = r1.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0c73 }
            if (r6 == 0) goto L_0x065f
            java.lang.String r6 = r1.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0c73 }
        L_0x065d:
            r13 = r6
            goto L_0x0660
        L_0x065f:
            r13 = 0
        L_0x0660:
            if (r13 == 0) goto L_0x0678
            java.lang.String r6 = "imeiCached"
            android.content.SharedPreferences r12 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            android.content.SharedPreferences$Editor r12 = r12.edit()     // Catch:{ all -> 0x0c73 }
            r12.putString(r6, r13)     // Catch:{ all -> 0x0c73 }
            r12.apply()     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "imei"
            r2.put(r6, r13)     // Catch:{ all -> 0x0c73 }
            goto L_0x067d
        L_0x0678:
            java.lang.String r6 = "IMEI was not collected."
            com.appsflyer.AFLogger.AFInAppEventParameterName(r6)     // Catch:{ all -> 0x0c73 }
        L_0x067d:
            java.lang.String r6 = "collectAndroidId"
            r12 = 1
            boolean r5 = r5.getBoolean(r6, r12)     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "androidIdCached"
            r12 = 0
            java.lang.String r6 = r9.getString(r6, r12)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x06ce
            java.lang.String r5 = r1.AFVersionDeclaration     // Catch:{ all -> 0x0c73 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x06ce
            boolean r5 = init((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x06d5
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x06b6 }
            java.lang.String r9 = "android_id"
            java.lang.String r5 = android.provider.Settings.Secure.getString(r5, r9)     // Catch:{ Exception -> 0x06b6 }
            if (r5 == 0) goto L_0x06a8
            goto L_0x06d6
        L_0x06a8:
            if (r6 == 0) goto L_0x06b4
            java.lang.String r5 = "use cached AndroidId: "
            java.lang.String r5 = r5.concat(r6)     // Catch:{ Exception -> 0x06b6 }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r5)     // Catch:{ Exception -> 0x06b6 }
            goto L_0x06cc
        L_0x06b4:
            r6 = 0
            goto L_0x06cc
        L_0x06b6:
            r0 = move-exception
            r5 = r0
            if (r6 == 0) goto L_0x06c4
            java.lang.String r9 = "use cached AndroidId: "
            java.lang.String r9 = r9.concat(r6)     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r9)     // Catch:{ all -> 0x0c73 }
            goto L_0x06c5
        L_0x06c4:
            r6 = 0
        L_0x06c5:
            java.lang.String r9 = r5.getMessage()     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AFLogger.values(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x06cc:
            r5 = r6
            goto L_0x06d6
        L_0x06ce:
            java.lang.String r5 = r1.AFVersionDeclaration     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x06d5
            java.lang.String r5 = r1.AFVersionDeclaration     // Catch:{ all -> 0x0c73 }
            goto L_0x06d6
        L_0x06d5:
            r5 = 0
        L_0x06d6:
            if (r5 == 0) goto L_0x06ee
            java.lang.String r6 = "androidIdCached"
            android.content.SharedPreferences r9 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ all -> 0x0c73 }
            r9.putString(r6, r5)     // Catch:{ all -> 0x0c73 }
            r9.apply()     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "android_id"
            r2.put(r6, r5)     // Catch:{ all -> 0x0c73 }
            goto L_0x06f3
        L_0x06ee:
            java.lang.String r5 = "Android ID was not collected."
            com.appsflyer.AFLogger.AFInAppEventParameterName(r5)     // Catch:{ all -> 0x0c73 }
        L_0x06f3:
            com.appsflyer.internal.d$a$d r5 = com.appsflyer.internal.C1380ab.AFInAppEventType(r11)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x071a
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0c73 }
            r6.<init>()     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = "isManual"
            java.lang.Boolean r12 = r5.values     // Catch:{ all -> 0x0c73 }
            r6.put(r9, r12)     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = "val"
            java.lang.String r12 = r5.valueOf     // Catch:{ all -> 0x0c73 }
            r6.put(r9, r12)     // Catch:{ all -> 0x0c73 }
            java.lang.Boolean r5 = r5.AFInAppEventType     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0715
            java.lang.String r9 = "isLat"
            r6.put(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0715:
            java.lang.String r5 = "oaid"
            r2.put(r5, r6)     // Catch:{ all -> 0x0c73 }
        L_0x071a:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x072d }
            r5.<init>(r11)     // Catch:{ Exception -> 0x072d }
            java.lang.String r5 = com.appsflyer.internal.C1412ak.AFKeystoreWrapper(r5)     // Catch:{ Exception -> 0x072d }
            r6 = r17
            if (r5 == 0) goto L_0x0746
            r2.put(r6, r5)     // Catch:{ Exception -> 0x072b }
            goto L_0x0746
        L_0x072b:
            r0 = move-exception
            goto L_0x0730
        L_0x072d:
            r0 = move-exception
            r6 = r17
        L_0x0730:
            r5 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            java.lang.String r12 = "ERROR: could not get uid "
            r9.<init>(r12)     // Catch:{ all -> 0x0c73 }
            java.lang.String r12 = r5.getMessage()     // Catch:{ all -> 0x0c73 }
            r9.append(r12)     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AFLogger.values(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0746:
            java.lang.String r5 = "lang"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0754 }
            java.lang.String r9 = r9.getDisplayLanguage()     // Catch:{ Exception -> 0x0754 }
            r2.put(r5, r9)     // Catch:{ Exception -> 0x0754 }
            goto L_0x075b
        L_0x0754:
            r0 = move-exception
            r5 = r0
            java.lang.String r9 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.values(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x075b:
            java.lang.String r5 = "lang_code"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0769 }
            java.lang.String r9 = r9.getLanguage()     // Catch:{ Exception -> 0x0769 }
            r2.put(r5, r9)     // Catch:{ Exception -> 0x0769 }
            goto L_0x0770
        L_0x0769:
            r0 = move-exception
            r5 = r0
            java.lang.String r9 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.values(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0770:
            java.lang.String r5 = "country"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x077e }
            java.lang.String r9 = r9.getCountry()     // Catch:{ Exception -> 0x077e }
            r2.put(r5, r9)     // Catch:{ Exception -> 0x077e }
            goto L_0x0785
        L_0x077e:
            r0 = move-exception
            r5 = r0
            java.lang.String r9 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.values(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0785:
            java.lang.String r5 = "platformextension"
            com.appsflyer.internal.aj r9 = r1.enableLocationCollection     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = r9.values()     // Catch:{ all -> 0x0c73 }
            r2.put(r5, r9)     // Catch:{ all -> 0x0c73 }
            AFKeystoreWrapper((android.content.Context) r11, (java.util.Map<java.lang.String, ? super java.lang.String>) r2)     // Catch:{ all -> 0x0c73 }
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0c73 }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0c73 }
            r12 = r16
            r5.<init>(r12, r9)     // Catch:{ all -> 0x0c73 }
            android.content.pm.PackageManager r9 = r11.getPackageManager()     // Catch:{ Exception -> 0x07c2 }
            java.lang.String r13 = r11.getPackageName()     // Catch:{ Exception -> 0x07c2 }
            android.content.pm.PackageInfo r9 = r9.getPackageInfo(r13, r8)     // Catch:{ Exception -> 0x07c2 }
            long r13 = r9.firstInstallTime     // Catch:{ Exception -> 0x07c2 }
            java.lang.String r9 = "installDate"
            java.lang.String r15 = "UTC"
            java.util.TimeZone r15 = java.util.TimeZone.getTimeZone(r15)     // Catch:{ Exception -> 0x07c2 }
            r5.setTimeZone(r15)     // Catch:{ Exception -> 0x07c2 }
            java.util.Date r15 = new java.util.Date     // Catch:{ Exception -> 0x07c2 }
            r15.<init>(r13)     // Catch:{ Exception -> 0x07c2 }
            java.lang.String r13 = r5.format(r15)     // Catch:{ Exception -> 0x07c2 }
            r2.put(r9, r13)     // Catch:{ Exception -> 0x07c2 }
            goto L_0x07c9
        L_0x07c2:
            r0 = move-exception
            r9 = r0
            java.lang.String r13 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.values(r13, r9)     // Catch:{ all -> 0x0c73 }
        L_0x07c9:
            android.content.pm.PackageManager r9 = r11.getPackageManager()     // Catch:{ all -> 0x085d }
            java.lang.String r13 = r11.getPackageName()     // Catch:{ all -> 0x085d }
            android.content.pm.PackageInfo r9 = r9.getPackageInfo(r13, r8)     // Catch:{ all -> 0x085d }
            java.lang.String r13 = "versionCode"
            r14 = r25
            int r13 = r14.getInt(r13, r8)     // Catch:{ all -> 0x0855 }
            int r15 = r9.versionCode     // Catch:{ all -> 0x0855 }
            if (r15 <= r13) goto L_0x07f3
            java.lang.String r13 = "versionCode"
            int r15 = r9.versionCode     // Catch:{ all -> 0x0855 }
            android.content.SharedPreferences r16 = AFInAppEventType((android.content.Context) r11)     // Catch:{ all -> 0x0855 }
            android.content.SharedPreferences$Editor r8 = r16.edit()     // Catch:{ all -> 0x0855 }
            r8.putInt(r13, r15)     // Catch:{ all -> 0x0855 }
            r8.apply()     // Catch:{ all -> 0x0855 }
        L_0x07f3:
            java.lang.String r8 = "app_version_code"
            int r13 = r9.versionCode     // Catch:{ all -> 0x0855 }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ all -> 0x0855 }
            r2.put(r8, r13)     // Catch:{ all -> 0x0855 }
            java.lang.String r8 = "app_version_name"
            java.lang.String r13 = r9.versionName     // Catch:{ all -> 0x0855 }
            r2.put(r8, r13)     // Catch:{ all -> 0x0855 }
            r8 = r3
            r26 = r4
            long r3 = r9.firstInstallTime     // Catch:{ all -> 0x084f }
            r13 = r8
            long r8 = r9.lastUpdateTime     // Catch:{ all -> 0x0849 }
            java.lang.String r15 = "date1"
            r16 = r6
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0847 }
            r18 = r13
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ all -> 0x0845 }
            r6.<init>(r12, r13)     // Catch:{ all -> 0x0845 }
            java.util.Date r13 = new java.util.Date     // Catch:{ all -> 0x0845 }
            r13.<init>(r3)     // Catch:{ all -> 0x0845 }
            java.lang.String r3 = r6.format(r13)     // Catch:{ all -> 0x0845 }
            r2.put(r15, r3)     // Catch:{ all -> 0x0845 }
            java.lang.String r3 = "date2"
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0845 }
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ all -> 0x0845 }
            r4.<init>(r12, r6)     // Catch:{ all -> 0x0845 }
            java.util.Date r6 = new java.util.Date     // Catch:{ all -> 0x0845 }
            r6.<init>(r8)     // Catch:{ all -> 0x0845 }
            java.lang.String r4 = r4.format(r6)     // Catch:{ all -> 0x0845 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0845 }
            java.lang.String r3 = r1.values((java.text.SimpleDateFormat) r5, (android.content.Context) r11)     // Catch:{ all -> 0x0845 }
            java.lang.String r4 = "firstLaunchDate"
            r2.put(r4, r3)     // Catch:{ all -> 0x0845 }
            goto L_0x086c
        L_0x0845:
            r0 = move-exception
            goto L_0x0866
        L_0x0847:
            r0 = move-exception
            goto L_0x084c
        L_0x0849:
            r0 = move-exception
            r16 = r6
        L_0x084c:
            r18 = r13
            goto L_0x0866
        L_0x084f:
            r0 = move-exception
            r16 = r6
            r18 = r8
            goto L_0x0866
        L_0x0855:
            r0 = move-exception
            r18 = r3
            r26 = r4
            r16 = r6
            goto L_0x0866
        L_0x085d:
            r0 = move-exception
            r18 = r3
            r26 = r4
            r16 = r6
            r14 = r25
        L_0x0866:
            r3 = r0
            java.lang.String r4 = "Exception while collecting app version data "
            com.appsflyer.AFLogger.values(r4, r3)     // Catch:{ all -> 0x0c73 }
        L_0x086c:
            boolean r3 = com.appsflyer.internal.C1433az.values((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            r1.stop = r3     // Catch:{ all -> 0x0c73 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "didConfigureTokenRefreshService="
            r3.<init>(r4)     // Catch:{ all -> 0x0c73 }
            boolean r4 = r1.stop     // Catch:{ all -> 0x0c73 }
            r3.append(r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r3)     // Catch:{ all -> 0x0c73 }
            boolean r3 = r1.stop     // Catch:{ all -> 0x0c73 }
            if (r3 != 0) goto L_0x0890
            java.lang.String r3 = "tokenRefreshConfigured"
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0c73 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c73 }
        L_0x0890:
            if (r23 == 0) goto L_0x08c3
            java.lang.String r3 = r1.getInstance     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x08b9
            java.lang.String r3 = "af_deeplink"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x08a4
            java.lang.String r3 = "Skip 'af' payload as deeplink was found by path"
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r3)     // Catch:{ all -> 0x0c73 }
            goto L_0x08b9
        L_0x08a4:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r1.getInstance     // Catch:{ all -> 0x0c73 }
            r3.<init>(r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "isPush"
            r3.put(r4, r10)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "af_deeplink"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0c73 }
            r2.put(r4, r3)     // Catch:{ all -> 0x0c73 }
        L_0x08b9:
            r3 = 0
            r1.getInstance = r3     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "open_referrer"
            r4 = r19
            r2.put(r3, r4)     // Catch:{ all -> 0x0c73 }
        L_0x08c3:
            java.lang.String r3 = "sensors"
            if (r23 != 0) goto L_0x0907
            com.appsflyer.internal.z r4 = com.appsflyer.internal.C1500z.valueOf((android.content.Context) r11)     // Catch:{ Exception -> 0x08f0 }
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x08f0 }
            r5.<init>()     // Catch:{ Exception -> 0x08f0 }
            java.util.List r4 = r4.AFInAppEventParameterName()     // Catch:{ Exception -> 0x08f0 }
            boolean r6 = r4.isEmpty()     // Catch:{ Exception -> 0x08f0 }
            if (r6 != 0) goto L_0x08e7
            com.appsflyer.internal.g r6 = new com.appsflyer.internal.g     // Catch:{ Exception -> 0x08f0 }
            r6.<init>()     // Catch:{ Exception -> 0x08f0 }
            java.util.Map r4 = r6.AFInAppEventType(r4)     // Catch:{ Exception -> 0x08f0 }
            r5.put(r3, r4)     // Catch:{ Exception -> 0x08f0 }
            goto L_0x08ec
        L_0x08e7:
            java.lang.String r4 = "na"
            r5.put(r3, r4)     // Catch:{ Exception -> 0x08f0 }
        L_0x08ec:
            r2.putAll(r5)     // Catch:{ Exception -> 0x08f0 }
            goto L_0x0907
        L_0x08f0:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "Unexpected exception from AFSensorManager: "
            r5.<init>(r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0c73 }
            r5.append(r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0c73 }
            com.appsflyer.AFLogger.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x0c73 }
        L_0x0907:
            java.lang.String r4 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0c73 }
            if (r4 != 0) goto L_0x092f
            com.appsflyer.internal.C1380ab.AFKeystoreWrapper(r11, r2)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0c73 }
            if (r4 == 0) goto L_0x0928
            java.lang.String r4 = "GAID_retry"
            r2.put(r4, r10)     // Catch:{ all -> 0x0c73 }
            goto L_0x092f
        L_0x0928:
            java.lang.String r4 = "GAID_retry"
            java.lang.String r5 = "false"
            r2.put(r4, r5)     // Catch:{ all -> 0x0c73 }
        L_0x092f:
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ all -> 0x0c73 }
            com.appsflyer.internal.d$a$d r4 = com.appsflyer.internal.C1380ab.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x0c73 }
            if (r4 == 0) goto L_0x094b
            java.lang.String r5 = "amazon_aid"
            java.lang.String r6 = r4.valueOf     // Catch:{ all -> 0x0c73 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = "amazon_aid_limit"
            java.lang.Boolean r4 = r4.AFInAppEventType     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0c73 }
            r2.put(r5, r4)     // Catch:{ all -> 0x0c73 }
        L_0x094b:
            boolean r4 = com.appsflyer.internal.C1433az.values((android.content.SharedPreferences) r14)     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = "registeredUninstall"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0c73 }
            r2.put(r5, r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "appsFlyerCount"
            r5 = r23
            int r4 = AFInAppEventParameterName((android.content.SharedPreferences) r14, (java.lang.String) r4, (boolean) r5)     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "counter"
            java.lang.String r8 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0c73 }
            r2.put(r6, r8)     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "iaecounter"
            if (r7 == 0) goto L_0x096f
            r7 = 1
            goto L_0x0970
        L_0x096f:
            r7 = 0
        L_0x0970:
            java.lang.String r8 = "appsFlyerInAppEventCount"
            int r7 = AFInAppEventParameterName((android.content.SharedPreferences) r14, (java.lang.String) r8, (boolean) r7)     // Catch:{ all -> 0x0c73 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0c73 }
            r2.put(r6, r7)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x09f8
            java.lang.String r6 = "first_launch"
            r7 = 1
            if (r4 == r7) goto L_0x09aa
            r7 = 2
            if (r4 == r7) goto L_0x0988
            goto L_0x09f8
        L_0x0988:
            java.util.Map r7 = AFInAppEventType((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0c73 }
            r8 = r24
            android.content.SharedPreferences r9 = r8.AFInAppEventType     // Catch:{ all -> 0x0c73 }
            r10 = 0
            java.lang.String r9 = r9.getString(r6, r10)     // Catch:{ all -> 0x0c73 }
            if (r9 == 0) goto L_0x09fa
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x0c73 }
            r10.<init>(r9)     // Catch:{ all -> 0x0c73 }
            java.util.Map r9 = com.appsflyer.internal.C1482k.AFInAppEventParameterName(r10)     // Catch:{ all -> 0x0c73 }
            boolean r10 = r9.isEmpty()     // Catch:{ all -> 0x0c73 }
            if (r10 != 0) goto L_0x09fa
            r7.put(r6, r9)     // Catch:{ all -> 0x0c73 }
            goto L_0x09fa
        L_0x09aa:
            r8 = r24
            r7 = r26
            r9 = 1
            r7.values = r9     // Catch:{ all -> 0x0c73 }
            java.lang.String r7 = "waitForCustomerId"
            r10 = 0
            boolean r7 = values((java.lang.String) r7, (boolean) r10)     // Catch:{ all -> 0x0c73 }
            if (r7 == 0) goto L_0x09c5
            java.lang.String r7 = "wait_cid"
            java.lang.String r10 = java.lang.Boolean.toString(r9)     // Catch:{ all -> 0x0c73 }
            r2.put(r7, r10)     // Catch:{ all -> 0x0c73 }
        L_0x09c5:
            java.util.Map r7 = AFInAppEventType((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0c73 }
            java.lang.String r10 = "ddl"
            android.content.SharedPreferences r12 = r8.AFInAppEventType     // Catch:{ all -> 0x0c73 }
            r13 = 0
            java.lang.String r10 = r12.getString(r10, r13)     // Catch:{ all -> 0x0c73 }
            if (r10 == 0) goto L_0x09e8
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x0c73 }
            r12.<init>(r10)     // Catch:{ all -> 0x0c73 }
            java.util.Map r10 = com.appsflyer.internal.C1482k.AFInAppEventParameterName(r12)     // Catch:{ all -> 0x0c73 }
            boolean r12 = r10.isEmpty()     // Catch:{ all -> 0x0c73 }
            if (r12 != 0) goto L_0x09e8
            java.lang.String r12 = "ddl"
            r7.put(r12, r10)     // Catch:{ all -> 0x0c73 }
        L_0x09e8:
            org.json.JSONObject r10 = r1.setAdditionalData     // Catch:{ all -> 0x0c73 }
            java.util.Map r10 = com.appsflyer.internal.C1482k.AFInAppEventParameterName(r10)     // Catch:{ all -> 0x0c73 }
            boolean r12 = r10.isEmpty()     // Catch:{ all -> 0x0c73 }
            if (r12 != 0) goto L_0x09fb
            r7.put(r6, r10)     // Catch:{ all -> 0x0c73 }
            goto L_0x09fb
        L_0x09f8:
            r8 = r24
        L_0x09fa:
            r9 = 1
        L_0x09fb:
            java.lang.String r6 = "isFirstCall"
            boolean r7 = AFKeystoreWrapper((android.content.SharedPreferences) r14)     // Catch:{ all -> 0x0c73 }
            if (r7 != 0) goto L_0x0a04
            goto L_0x0a05
        L_0x0a04:
            r9 = 0
        L_0x0a05:
            java.lang.String r7 = java.lang.Boolean.toString(r9)     // Catch:{ all -> 0x0c73 }
            r2.put(r6, r7)     // Catch:{ all -> 0x0c73 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0c73 }
            r6.<init>()     // Catch:{ all -> 0x0c73 }
            java.lang.String r7 = "cpu_abi"
            java.lang.String r9 = "ro.product.cpu.abi"
            java.lang.String r9 = AFInAppEventParameterName((java.lang.String) r9)     // Catch:{ all -> 0x0c73 }
            r6.put(r7, r9)     // Catch:{ all -> 0x0c73 }
            java.lang.String r7 = "cpu_abi2"
            java.lang.String r9 = "ro.product.cpu.abi2"
            java.lang.String r9 = AFInAppEventParameterName((java.lang.String) r9)     // Catch:{ all -> 0x0c73 }
            r6.put(r7, r9)     // Catch:{ all -> 0x0c73 }
            java.lang.String r7 = "arch"
            java.lang.String r9 = "os.arch"
            java.lang.String r9 = AFInAppEventParameterName((java.lang.String) r9)     // Catch:{ all -> 0x0c73 }
            r6.put(r7, r9)     // Catch:{ all -> 0x0c73 }
            java.lang.String r7 = "build_display_id"
            java.lang.String r9 = "ro.build.display.id"
            java.lang.String r9 = AFInAppEventParameterName((java.lang.String) r9)     // Catch:{ all -> 0x0c73 }
            r6.put(r7, r9)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0ac9
            boolean r5 = r1.getSdkVersion     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0a83
            com.appsflyer.internal.v r5 = com.appsflyer.internal.C1492v.C1493b.values     // Catch:{ all -> 0x0c73 }
            android.location.Location r5 = r5.AFInAppEventType(r11)     // Catch:{ all -> 0x0c73 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0c73 }
            r9 = 3
            r7.<init>(r9)     // Catch:{ all -> 0x0c73 }
            if (r5 == 0) goto L_0x0a78
            java.lang.String r9 = "lat"
            double r12 = r5.getLatitude()     // Catch:{ all -> 0x0c73 }
            java.lang.String r10 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0c73 }
            r7.put(r9, r10)     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = "lon"
            double r12 = r5.getLongitude()     // Catch:{ all -> 0x0c73 }
            java.lang.String r10 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0c73 }
            r7.put(r9, r10)     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = "ts"
            long r12 = r5.getTime()     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0c73 }
            r7.put(r9, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0a78:
            boolean r5 = r7.isEmpty()     // Catch:{ all -> 0x0c73 }
            if (r5 != 0) goto L_0x0a83
            java.lang.String r5 = "loc"
            r6.put(r5, r7)     // Catch:{ all -> 0x0c73 }
        L_0x0a83:
            com.appsflyer.internal.a r5 = com.appsflyer.internal.C1375a.C1376c.values     // Catch:{ all -> 0x0c73 }
            com.appsflyer.internal.a$d r5 = r5.AFInAppEventType(r11)     // Catch:{ all -> 0x0c73 }
            java.lang.String r7 = "btl"
            float r9 = r5.AFInAppEventParameterName     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = java.lang.Float.toString(r9)     // Catch:{ all -> 0x0c73 }
            r6.put(r7, r9)     // Catch:{ all -> 0x0c73 }
            java.lang.String r7 = r5.AFInAppEventType     // Catch:{ all -> 0x0c73 }
            if (r7 == 0) goto L_0x0a9f
            java.lang.String r7 = "btch"
            java.lang.String r5 = r5.AFInAppEventType     // Catch:{ all -> 0x0c73 }
            r6.put(r7, r5)     // Catch:{ all -> 0x0c73 }
        L_0x0a9f:
            r5 = 2
            if (r4 > r5) goto L_0x0ac9
            com.appsflyer.internal.z r4 = com.appsflyer.internal.C1500z.valueOf((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x0c73 }
            r5.<init>()     // Catch:{ all -> 0x0c73 }
            java.util.List r7 = r4.AFKeystoreWrapper()     // Catch:{ all -> 0x0c73 }
            boolean r9 = r7.isEmpty()     // Catch:{ all -> 0x0c73 }
            if (r9 != 0) goto L_0x0ab9
            r5.put(r3, r7)     // Catch:{ all -> 0x0c73 }
            goto L_0x0ac6
        L_0x0ab9:
            java.util.List r4 = r4.AFInAppEventParameterName()     // Catch:{ all -> 0x0c73 }
            boolean r7 = r4.isEmpty()     // Catch:{ all -> 0x0c73 }
            if (r7 != 0) goto L_0x0ac6
            r5.put(r3, r4)     // Catch:{ all -> 0x0c73 }
        L_0x0ac6:
            r6.putAll(r5)     // Catch:{ all -> 0x0c73 }
        L_0x0ac9:
            java.util.Map r3 = com.appsflyer.internal.C1494w.values(r11)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "dim"
            r6.put(r4, r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "deviceData"
            r2.put(r3, r6)     // Catch:{ all -> 0x0c73 }
            r3 = r18
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0c73 }
            r5 = r29
            java.lang.Object r6 = r2.get(r5)     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0c73 }
            r7 = r16
            java.lang.Object r9 = r2.get(r7)     // Catch:{ all -> 0x0c73 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0c73 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            r10.<init>()     // Catch:{ all -> 0x0c73 }
            r12 = 7
            r13 = 0
            java.lang.String r4 = r4.substring(r13, r12)     // Catch:{ all -> 0x0c73 }
            r10.append(r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r9.substring(r13, r12)     // Catch:{ all -> 0x0c73 }
            r10.append(r4)     // Catch:{ all -> 0x0c73 }
            int r4 = r6.length()     // Catch:{ all -> 0x0c73 }
            int r4 = r4 - r12
            java.lang.String r4 = r6.substring(r4)     // Catch:{ all -> 0x0c73 }
            r10.append(r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r10.toString()     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = com.appsflyer.internal.C1407ai.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "af_v"
            r2.put(r6, r4)     // Catch:{ all -> 0x0c73 }
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0c73 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            r4.<init>()     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c73 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            r4.<init>()     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.Object r3 = r2.get(r7)     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c73 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            r4.<init>()     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "installDate"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c73 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            r4.<init>()     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "counter"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c73 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            r4.<init>()     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "iaecounter"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c73 }
            r4.append(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = com.appsflyer.internal.C1407ai.AFInAppEventType(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = com.appsflyer.internal.C1407ai.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "af_v2"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c73 }
            boolean r3 = getLevel((android.content.Context) r11)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "ivc"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0c73 }
            r2.put(r4, r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "is_stop_tracking_used"
            boolean r3 = r14.contains(r3)     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x0bba
            java.lang.String r3 = "istu"
            java.lang.String r4 = "is_stop_tracking_used"
            r5 = 0
            boolean r4 = r14.getBoolean(r4, r5)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0c73 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c73 }
        L_0x0bba:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0c73 }
            r3.<init>()     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "mcc"
            android.content.res.Resources r5 = r11.getResources()     // Catch:{ all -> 0x0c73 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0c73 }
            int r5 = r5.mcc     // Catch:{ all -> 0x0c73 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0c73 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "mnc"
            android.content.res.Resources r5 = r11.getResources()     // Catch:{ all -> 0x0c73 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0c73 }
            int r5 = r5.mnc     // Catch:{ all -> 0x0c73 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0c73 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = "cell"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "sig"
            android.app.Application r4 = r8.values     // Catch:{ all -> 0x0c73 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ all -> 0x0c73 }
            android.app.Application r5 = r8.values     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = com.appsflyer.internal.C1381ac.valueOf(r4, r5)     // Catch:{ all -> 0x0c73 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "last_boot_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0c73 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0c73 }
            long r4 = r4 - r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0c73 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "disk"
            android.os.StatFs r4 = new android.os.StatFs     // Catch:{ all -> 0x0c73 }
            java.io.File r5 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x0c73 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0c73 }
            r4.<init>(r5)     // Catch:{ all -> 0x0c73 }
            long r5 = r4.getBlockSizeLong()     // Catch:{ all -> 0x0c73 }
            long r7 = r4.getAvailableBlocksLong()     // Catch:{ all -> 0x0c73 }
            long r7 = r7 * r5
            long r9 = r4.getBlockCountLong()     // Catch:{ all -> 0x0c73 }
            long r9 = r9 * r5
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            r11 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r4 = java.lang.Math.pow(r4, r11)     // Catch:{ all -> 0x0c73 }
            double r6 = (double) r7
            java.lang.Double.isNaN(r6)
            double r6 = r6 / r4
            long r6 = (long) r6
            double r8 = (double) r9
            java.lang.Double.isNaN(r8)
            double r8 = r8 / r4
            long r4 = (long) r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c73 }
            r8.<init>()     // Catch:{ all -> 0x0c73 }
            r8.append(r6)     // Catch:{ all -> 0x0c73 }
            java.lang.String r6 = "/"
            r8.append(r6)     // Catch:{ all -> 0x0c73 }
            r8.append(r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x0c73 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c73 }
            java.lang.String[] r3 = r1.init     // Catch:{ all -> 0x0c73 }
            if (r3 == 0) goto L_0x0c7c
            java.lang.String r3 = "sharing_filter"
            java.lang.String[] r4 = r1.init     // Catch:{ all -> 0x0c73 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c73 }
            goto L_0x0c7c
        L_0x0c67:
            java.lang.String r3 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.AFInAppEventParameterName(r3)     // Catch:{ all -> 0x0c73 }
            java.lang.String r3 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.AFInAppEventParameterName(r3)     // Catch:{ all -> 0x0c73 }
            r2 = 0
            return r2
        L_0x0c73:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = r3.getLocalizedMessage()
            com.appsflyer.AFLogger.AFInAppEventParameterName((java.lang.String) r4, (java.lang.Throwable) r3)
        L_0x0c7c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1387af.valueOf(com.appsflyer.internal.h):java.util.Map");
    }
}
