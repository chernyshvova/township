package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.C1461bw;
import com.appsflyer.internal.C1471d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.ar */
public final class C1420ar extends C1443bh {
    public static long onAppOpenAttributionNative = TimeUnit.SECONDS.toMillis(3);
    public static String onAttributionFailure = "https://%sdlsdk.%s/v1.0/android/";
    public boolean AppsFlyerConversionListener;
    public int AppsFlyerInAppPurchaseValidatorListener;
    public final CountDownLatch onAppOpenAttribution = new CountDownLatch(1);
    public int onAttributionFailureNative;
    public final List<C1461bw> onConversionDataFail = new ArrayList();
    public final C1430aw onDeepLinking;
    public int onValidateInApp;
    public final JSONObject onValidateInAppFailure = new JSONObject();

    /* renamed from: com.appsflyer.internal.ar$2 */
    public static /* synthetic */ class C14222 {
        public static final /* synthetic */ int[] AFInAppEventParameterName;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.appsflyer.internal.bw$d[] r0 = com.appsflyer.internal.C1461bw.C1463d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                AFInAppEventParameterName = r0
                r1 = 1
                r2 = 2
                com.appsflyer.internal.bw$d r3 = com.appsflyer.internal.C1461bw.C1463d.FINISHED     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = AFInAppEventParameterName     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.appsflyer.internal.bw$d r3 = com.appsflyer.internal.C1461bw.C1463d.STARTED     // Catch:{ NoSuchFieldError -> 0x0015 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1420ar.C14222.<clinit>():void");
        }
    }

    public C1420ar(Context context, C1430aw awVar) {
        super((String) null, onAttributionFailure, Boolean.FALSE, Boolean.TRUE, (Boolean) null, context);
        this.onDeepLinking = awVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void valueOf(android.content.Context r9) {
        /*
            r8 = this;
            int r0 = r8.onAttributionFailureNative
            r1 = 1
            int r0 = r0 + r1
            r8.onAttributionFailureNative = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "[DDL] Preparing request "
            r0.<init>(r2)
            int r2 = r8.onAttributionFailureNative
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0)
            int r0 = r8.onAttributionFailureNative
            if (r0 != r1) goto L_0x00aa
            com.appsflyer.internal.af r0 = com.appsflyer.internal.C1387af.AFInAppEventParameterName()
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            boolean r3 = com.appsflyer.internal.C1387af.AFKeystoreWrapper((android.content.Context) r9)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.String r4 = "is_first"
            r2.put(r4, r3)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.getLanguage()
            r3.append(r4)
            java.lang.String r4 = "-"
            r3.append(r4)
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.getCountry()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "lang"
            r2.put(r4, r3)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            java.lang.String r4 = "os"
            r2.put(r4, r3)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r3 = android.os.Build.MODEL
            java.lang.String r4 = "type"
            r2.put(r4, r3)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r3 = r0.getAppsFlyerUID(r9)
            java.lang.String r4 = "request_id"
            r2.put(r4, r3)
            java.lang.String[] r0 = r0.init
            if (r0 == 0) goto L_0x0083
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r3 = "sharing_filter"
            r2.put(r3, r0)
        L_0x0083:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.appsflyer.internal.d$a$d r0 = com.appsflyer.internal.C1380ab.AFKeystoreWrapper(r9, r0)
            java.util.Map r0 = r8.AFKeystoreWrapper(r0)
            com.appsflyer.internal.d$a$d r2 = com.appsflyer.internal.C1380ab.AFInAppEventType(r9)
            java.util.Map r2 = r8.AFKeystoreWrapper(r2)
            if (r0 == 0) goto L_0x00a1
            java.util.Map<java.lang.String, java.lang.Object> r3 = r8.AFInAppEventType
            java.lang.String r4 = "gaid"
            r3.put(r4, r0)
        L_0x00a1:
            if (r2 == 0) goto L_0x00aa
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.AFInAppEventType
            java.lang.String r3 = "oaid"
            r0.put(r3, r2)
        L_0x00aa:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.AFInAppEventType
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r4 = "yyyy-MM-dd'T'HH:mm:ss.SSS"
            r2.<init>(r4, r3)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = "UTC"
            java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r5)
            r2.setTimeZone(r5)
            java.util.Date r5 = new java.util.Date
            r5.<init>(r3)
            java.lang.String r2 = r2.format(r5)
            java.lang.String r3 = "timestamp"
            r0.put(r3, r2)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.AFInAppEventType
            int r2 = r8.onAttributionFailureNative
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "request_count"
            r0.put(r4, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<com.appsflyer.internal.bw> r2 = r8.onConversionDataFail
            java.util.Iterator r2 = r2.iterator()
        L_0x00e9:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0126
            java.lang.Object r4 = r2.next()
            com.appsflyer.internal.bw r4 = (com.appsflyer.internal.C1461bw) r4
            com.appsflyer.internal.bw$d r5 = r4.AFInAppEventType
            com.appsflyer.internal.bw$d r6 = com.appsflyer.internal.C1461bw.C1463d.FINISHED
            if (r5 != r6) goto L_0x011f
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.Map<java.lang.String, java.lang.Object> r6 = r4.AFKeystoreWrapper
            java.lang.String r7 = "referrer"
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x011f
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFKeystoreWrapper
            java.lang.String r7 = "source"
            java.lang.Object r4 = r4.get(r7)
            java.lang.String r4 = (java.lang.String) r4
            r5.put(r7, r4)
            java.lang.String r4 = "value"
            r5.put(r4, r6)
            goto L_0x0120
        L_0x011f:
            r5 = 0
        L_0x0120:
            if (r5 == 0) goto L_0x00e9
            r0.add(r5)
            goto L_0x00e9
        L_0x0126:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0133
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r4 = "referrers"
            r2.put(r4, r0)
        L_0x0133:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "AppsFlyerKey"
            java.lang.String r0 = r0.getString(r2)
            java.lang.String r2 = r8.onInstallConversionFailureNative
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            com.appsflyer.AppsFlyerLib r6 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r6 = r6.getHostPrefix()
            r4[r5] = r6
            com.appsflyer.internal.af r5 = com.appsflyer.internal.C1387af.AFInAppEventParameterName()
            java.lang.String r5 = r5.getHostName()
            r4[r1] = r5
            java.lang.String r1 = java.lang.String.format(r2, r4)
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.lang.String r9 = r9.getPackageName()
            android.net.Uri$Builder r9 = r1.appendPath(r9)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.Object r2 = r2.get(r3)
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = com.appsflyer.internal.C1407ai.values(r1, r0)
            java.lang.String r1 = "af_sig"
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r1, r0)
            java.lang.String r0 = com.appsflyer.internal.C1387af.AFInAppEventParameterName
            java.lang.String r1 = "sdk_version"
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r1, r0)
            android.net.Uri r9 = r9.build()
            java.lang.String r9 = r9.toString()
            r8.values(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1420ar.valueOf(android.content.Context):void");
    }

    public final void AFInAppEventParameterName(DeepLinkResult deepLinkResult) {
        try {
            this.onValidateInAppFailure.put("status", deepLinkResult.getStatus().toString());
            this.onValidateInAppFailure.put("timeout_value", onAppOpenAttributionNative);
        } catch (JSONException unused) {
        }
        C1430aw awVar = this.onDeepLinking;
        awVar.AFInAppEventType.edit().putString("ddl", this.onValidateInAppFailure.toString()).apply();
        C1387af.AFInAppEventType((Context) this.valueOf).edit().putBoolean("ddl_sent", true).apply();
        C1425as.AFInAppEventType(deepLinkResult);
    }

    @Nullable
    private Map<String, Object> AFKeystoreWrapper(final C1471d.C1472a.C1473d dVar) {
        Boolean bool;
        boolean z = false;
        if (!(dVar == null || dVar.valueOf == null || ((bool = dVar.AFInAppEventType) != null && bool.booleanValue()))) {
            z = true;
        }
        if (z) {
            return new HashMap<String, Object>() {
                {
                    put("type", "unhashed");
                    put("value", C1471d.C1472a.C1473d.this.valueOf);
                }
            };
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void values(C1461bw bwVar) {
        if (AFInAppEventParameterName(bwVar)) {
            this.onConversionDataFail.add(bwVar);
            this.onAppOpenAttribution.countDown();
            StringBuilder sb = new StringBuilder("[DDL] Added non-organic ");
            sb.append(bwVar.getClass().getSimpleName());
            AFLogger.AFInAppEventType(sb.toString());
            return;
        }
        int i = this.AppsFlyerInAppPurchaseValidatorListener + 1;
        this.AppsFlyerInAppPurchaseValidatorListener = i;
        if (i == this.onValidateInApp) {
            this.onAppOpenAttribution.countDown();
        }
    }

    private boolean AFInAppEventParameterName() {
        List list = (List) this.AFInAppEventType.get("referrers");
        if ((list != null ? list.size() : 0) >= this.onValidateInApp || this.AFInAppEventType.containsKey("referrers")) {
            return false;
        }
        return true;
    }

    public static boolean AFInAppEventParameterName(C1461bw bwVar) {
        Long l = (Long) bwVar.AFKeystoreWrapper.get("click_ts");
        if (l != null && System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l.longValue()) < TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void valueOf(C1420ar arVar) {
        ArrayList arrayList = new ArrayList();
        for (C1461bw bwVar : C1387af.AFInAppEventParameterName().onAttributionFailureNative) {
            if (!(bwVar == null || bwVar.AFInAppEventType == C1461bw.C1463d.NOT_STARTED)) {
                arrayList.add(bwVar);
            }
        }
        arVar.onValidateInApp = arrayList.size();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final C1461bw bwVar2 = (C1461bw) it.next();
            int i = C14222.AFInAppEventParameterName[bwVar2.AFInAppEventType.ordinal()];
            if (i == 1) {
                StringBuilder sb = new StringBuilder("[DDL] ");
                sb.append(bwVar2.AFKeystoreWrapper.get("source"));
                sb.append(" referrer collected earlier");
                AFLogger.AFInAppEventType(sb.toString());
                arVar.values(bwVar2);
            } else if (i == 2) {
                bwVar2.addObserver(new Observer() {
                    public final void update(Observable observable, Object obj) {
                        StringBuilder sb = new StringBuilder("[DDL] ");
                        sb.append(bwVar2.AFKeystoreWrapper.get("source"));
                        sb.append(" referrer collected via observer");
                        AFLogger.AFInAppEventType(sb.toString());
                        C1420ar.this.values((C1461bw) observable);
                    }
                });
            }
        }
    }

    public static /* synthetic */ DeepLinkResult valueOf(C1420ar arVar, Context context) throws IOException, JSONException, InterruptedException {
        DeepLink deepLink;
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();
            if (arVar.onAttributionFailureNative == 1) {
                arVar.onValidateInAppFailure.put("from_fg", currentTimeMillis - arVar.onDeepLinking.AFInAppEventType.getLong("fg_ts", 0));
            }
            HttpURLConnection values = new C1482k(arVar).values();
            JSONArray optJSONArray = arVar.onValidateInAppFailure.optJSONArray("net");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            optJSONArray.put(arVar.onAttributionFailureNative - 1, currentTimeMillis2 - currentTimeMillis);
            arVar.onValidateInAppFailure.put("net", optJSONArray);
            if (values.getResponseCode() == 200) {
                C1387af.AFInAppEventParameterName();
                JSONObject jSONObject = new JSONObject(C1387af.AFInAppEventType(values));
                arVar.AppsFlyerConversionListener = jSONObject.optBoolean("is_second_ping", true);
                if (!jSONObject.optBoolean("found")) {
                    deepLink = null;
                } else {
                    deepLink = DeepLink.valueOf(jSONObject.optJSONObject("click_event"));
                    deepLink.AFInAppEventParameterName.put("is_deferred", true);
                }
                if (deepLink != null) {
                    return new DeepLinkResult(deepLink, (DeepLinkResult.Error) null);
                }
                if (arVar.onAttributionFailureNative <= 1 && arVar.AFInAppEventParameterName() && arVar.AppsFlyerConversionListener) {
                    AFLogger.AFInAppEventType("[DDL] Waiting for referrers...");
                    arVar.onAppOpenAttribution.await();
                    arVar.onValidateInAppFailure.put("rfr_wait", System.currentTimeMillis() - currentTimeMillis2);
                    if (arVar.AppsFlyerInAppPurchaseValidatorListener == arVar.onValidateInApp) {
                        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
                    }
                    arVar.valueOf(context);
                }
            } else {
                StringBuilder sb = new StringBuilder("[DDL] Error occurred. Server response code = ");
                sb.append(values.getResponseCode());
                AFLogger.AFInAppEventType(sb.toString());
                return new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.HTTP_STATUS_CODE);
            }
        }
        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
    }
}
