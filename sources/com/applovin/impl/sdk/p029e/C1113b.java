package com.applovin.impl.sdk.p029e;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1234o;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.network.C1221e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.helpshift.support.res.values.HSConsts;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.b */
public class C1113b extends C1109a {
    public C1113b(C1188m mVar) {
        super("TaskApiSubmitData", mVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1819a(JSONObject jSONObject) {
        try {
            JSONObject a = C1264h.m2516a(jSONObject);
            this.f1961b.mo10931K().mo10680a((C1085b<?>) C1085b.f1572ad, (Object) a.getString("device_id"));
            this.f1961b.mo10931K().mo10680a((C1085b<?>) C1085b.f1574af, (Object) a.getString("device_token"));
            this.f1961b.mo10931K().mo10680a((C1085b<?>) C1085b.f1575ag, (Object) Long.valueOf(a.getLong("publisher_id")));
            this.f1961b.mo10931K().mo10679a();
            C1264h.m2526d(a, this.f1961b);
            C1264h.m2528e(a, this.f1961b);
            String string = JsonUtils.getString(a, "latest_version", "");
            if (!TextUtils.isEmpty(string) && !AppLovinSdk.VERSION.equals(string)) {
                String str = "Current SDK version (" + AppLovinSdk.VERSION + ") is outdated. Please integrate the latest version of the AppLovin SDK (" + string + "). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.";
                if (JsonUtils.valueExists(a, FetchedAppSettingsManager.SDK_UPDATE_MESSAGE)) {
                    str = JsonUtils.getString(a, FetchedAppSettingsManager.SDK_UPDATE_MESSAGE, str);
                }
                C1314v.m2662h(AppLovinSdk.TAG, str);
            }
            this.f1961b.mo10939T().mo10761b();
        } catch (Throwable th) {
            mo10769a("Unable to parse API response", th);
        }
    }

    /* renamed from: b */
    private void m1820b(JSONObject jSONObject) throws JSONException {
        C1234o V = this.f1961b.mo10941V();
        Map<String, Object> d = V.mo11209d();
        Utils.renameKeyInObjectMap("platform", "type", d);
        Utils.renameKeyInObjectMap("api_level", FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, d);
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, new JSONObject(d));
        Map<String, Object> h = V.mo11213h();
        Utils.renameKeyInObjectMap(FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, "applovin_sdk_version", h);
        Utils.renameKeyInObjectMap(HSConsts.ISSUE_ARCHIVAL_KEY, "installed_at", h);
        jSONObject.put("app_info", new JSONObject(h));
    }

    /* renamed from: c */
    private void m1821c(JSONObject jSONObject) throws JSONException {
        if (((Boolean) this.f1961b.mo10946a(C1085b.f1780ec)).booleanValue()) {
            jSONObject.put("stats", this.f1961b.mo10939T().mo10763c());
        }
        if (((Boolean) this.f1961b.mo10946a(C1085b.f1582an)).booleanValue()) {
            JSONObject b = C1221e.m2268b(mo10775f());
            if (b.length() > 0) {
                jSONObject.put("network_response_codes", b);
            }
            if (((Boolean) this.f1961b.mo10946a(C1085b.f1583ao)).booleanValue()) {
                C1221e.m2266a(mo10775f());
            }
        }
    }

    /* renamed from: d */
    private void m1822d(JSONObject jSONObject) {
        C11141 r0 = new C1157u<JSONObject>(C1217c.m2223a(this.f1961b).mo11127a(C1264h.m2514a("2.0/device", this.f1961b)).mo11137c(C1264h.m2524b("2.0/device", this.f1961b)).mo11128a(C1264h.m2527e(this.f1961b)).mo11133b("POST").mo11129a(jSONObject).mo11139d(((Boolean) this.f1961b.mo10946a(C1085b.f1752eA)).booleanValue()).mo11126a(new JSONObject()).mo11125a(((Integer) this.f1961b.mo10946a(C1085b.f1672cY)).intValue()).mo11131a(), this.f1961b) {
            /* renamed from: a */
            public void mo10008a(int i, String str, JSONObject jSONObject) {
                C1264h.m2517a(i, this.f1961b);
            }

            /* renamed from: a */
            public void mo10010a(JSONObject jSONObject, int i) {
                C1113b.this.m1819a(jSONObject);
            }
        };
        r0.mo10853a(C1085b.f1570aZ);
        r0.mo10855b(C1085b.f1622ba);
        this.f1961b.mo10938S().mo10828a((C1109a) r0);
    }

    public void run() {
        try {
            mo10770b("Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            m1820b(jSONObject);
            m1821c(jSONObject);
            m1822d(jSONObject);
        } catch (JSONException e) {
            mo10769a("Unable to build JSON message with collected data", e);
        }
    }
}
