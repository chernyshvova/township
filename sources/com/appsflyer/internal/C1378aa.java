package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.applovin.sdk.AppLovinEventParameters;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.helpshift.p042db.legacy_profile.tables.ProfileTable;
import com.swrve.sdk.SwrveImp;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.aa */
public final class C1378aa implements Runnable {
    public static String AFInAppEventParameterName = null;
    public static String AFInAppEventType = "https://%ssdk-services.%s/validate-android-signature";
    public String AFKeystoreWrapper;
    public String AFLogger$LogLevel;
    public String AFVersionDeclaration;
    public Map<String, String> AppsFlyer2dXConversionCallback;
    public String getLevel;
    public String init;
    public WeakReference<Context> valueOf;
    public String values;

    static {
        StringBuilder sb = new StringBuilder("https://%svalidate.%s/api/v");
        sb.append(C1387af.AFInAppEventParameterName);
        sb.append("/androidevent?buildnumber=6.3.0&app_id=");
        AFInAppEventParameterName = sb.toString();
    }

    public C1378aa(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.valueOf = new WeakReference<>(context);
        this.AFKeystoreWrapper = str;
        this.values = str2;
        this.AFVersionDeclaration = str4;
        this.getLevel = str5;
        this.init = str6;
        this.AppsFlyer2dXConversionCallback = map;
        this.AFLogger$LogLevel = str3;
    }

    public static HttpURLConnection AFInAppEventParameterName(@NonNull C1445bj bjVar) {
        StringBuilder sb = new StringBuilder("Calling ");
        sb.append(bjVar.onInstallConversionFailureNative);
        AFLogger.AFInAppEventType(sb.toString());
        bjVar.onConversionDataSuccess = AppsFlyerLib.getInstance().isStopped();
        return new C1482k(bjVar).values();
    }

    public static /* synthetic */ void values(C1378aa aaVar, Map map, Map map2, WeakReference weakReference) {
        if (weakReference.get() != null) {
            C1500z.valueOf((Context) weakReference.get()).valueOf();
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), C1387af.AFInAppEventParameterName().getHostName()}));
            sb.append(((Context) weakReference.get()).getPackageName());
            String obj = sb.toString();
            String string = C1387af.AFInAppEventType((Context) weakReference.get()).getString(SwrveImp.REFERRER, "");
            C1451bp bpVar = new C1451bp((Context) weakReference.get());
            bpVar.AFLogger$LogLevel = aaVar.AFKeystoreWrapper;
            bpVar.AppsFlyer2dXConversionCallback = string;
            C1387af AFInAppEventParameterName2 = C1387af.AFInAppEventParameterName();
            Map<String, Object> valueOf2 = AFInAppEventParameterName2.valueOf((C1480h) bpVar);
            valueOf2.put("price", aaVar.getLevel);
            valueOf2.put("currency", aaVar.init);
            valueOf2.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, map);
            if (map2 != null) {
                valueOf2.put("extra_prms", map2);
            }
            valueOf2.putAll(AFInAppEventParameterName2.valueOf());
            String jSONObject = new JSONObject(valueOf2).toString();
            C1414am.AFKeystoreWrapper().valueOf("server_request", obj, jSONObject);
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection AFInAppEventParameterName3 = AFInAppEventParameterName((C1445bj) bpVar.AFKeystoreWrapper(valueOf2).values(obj));
                int i = -1;
                if (AFInAppEventParameterName3 != null) {
                    i = AFInAppEventParameterName3.getResponseCode();
                }
                String AFInAppEventType2 = C1387af.AFInAppEventType(AFInAppEventParameterName3);
                C1414am.AFKeystoreWrapper().valueOf("server_response", obj, String.valueOf(i), AFInAppEventType2);
                StringBuilder sb2 = new StringBuilder("Validate-WH response - ");
                sb2.append(i);
                sb2.append(": ");
                sb2.append(new JSONObject(AFInAppEventType2).toString());
                AFLogger.AFInAppEventParameterName(sb2.toString());
                if (AFInAppEventParameterName3 != null) {
                    AFInAppEventParameterName3.disconnect();
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    public final void run() {
        String str = this.AFKeystoreWrapper;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isStopped()) {
            HttpURLConnection httpURLConnection = null;
            try {
                Context context = this.valueOf.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.values);
                    hashMap.put("sig-data", this.AFVersionDeclaration);
                    hashMap.put("signature", this.AFLogger$LogLevel);
                    final HashMap hashMap2 = new HashMap(hashMap);
                    new Thread(new Runnable() {
                        public final void run() {
                            C1378aa aaVar = C1378aa.this;
                            C1378aa.values(aaVar, hashMap2, aaVar.AppsFlyer2dXConversionCallback, C1378aa.this.valueOf);
                        }
                    }).start();
                    hashMap.put("dev_key", this.AFKeystoreWrapper);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put(ProfileTable.Columns.COLUMN_UID, AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    hashMap.put("advertiserId", AppsFlyerProperties.getInstance().getString("advertiserId"));
                    String jSONObject = new JSONObject(hashMap).toString();
                    String format = String.format(AFInAppEventType, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), C1387af.AFInAppEventParameterName().getHostName()});
                    C1414am.AFKeystoreWrapper().valueOf("server_request", format, jSONObject);
                    HttpURLConnection AFInAppEventParameterName2 = AFInAppEventParameterName((C1445bj) new C1448bm().AFKeystoreWrapper(hashMap).values(format));
                    int i = -1;
                    if (AFInAppEventParameterName2 != null) {
                        i = AFInAppEventParameterName2.getResponseCode();
                    }
                    C1387af.AFInAppEventParameterName();
                    String AFInAppEventType2 = C1387af.AFInAppEventType(AFInAppEventParameterName2);
                    C1414am.AFKeystoreWrapper().valueOf("server_response", format, String.valueOf(i), AFInAppEventType2);
                    JSONObject jSONObject2 = new JSONObject(AFInAppEventType2);
                    jSONObject2.put("code", i);
                    if (i == 200) {
                        StringBuilder sb = new StringBuilder("Validate response 200 ok: ");
                        sb.append(jSONObject2.toString());
                        AFLogger.AFInAppEventParameterName(sb.toString());
                        AFInAppEventParameterName(jSONObject2.optBoolean("result"), this.AFVersionDeclaration, this.getLevel, this.init, jSONObject2.toString());
                    } else {
                        AFLogger.AFInAppEventParameterName("Failed Validate request");
                        AFInAppEventParameterName(false, this.AFVersionDeclaration, this.getLevel, this.init, jSONObject2.toString());
                    }
                    if (AFInAppEventParameterName2 != null) {
                        AFInAppEventParameterName2.disconnect();
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    public static void AFInAppEventParameterName(boolean z, String str, String str2, String str3, String str4) {
        if (C1387af.valueOf != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(" ");
            sb.append(str3);
            AFLogger.AFInAppEventType(sb.toString());
            if (z) {
                AFLogger.AFInAppEventType("Validate in app purchase success: ".concat(String.valueOf(str4)));
                C1387af.valueOf.onValidateInApp();
                return;
            }
            AFLogger.AFInAppEventType("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = C1387af.valueOf;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }
}
