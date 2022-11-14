package com.applovin.impl.sdk.p029e;

import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.C1173j;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1234o;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.GraphRequest;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.google.android.gms.security.ProviderInstaller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.i */
public class C1127i extends C1109a {

    /* renamed from: a */
    public static final AtomicBoolean f1993a = new AtomicBoolean();

    /* renamed from: c */
    public final int f1994c;

    /* renamed from: d */
    public final Object f1995d = new Object();

    /* renamed from: e */
    public C1129a f1996e;

    /* renamed from: com.applovin.impl.sdk.e.i$a */
    public interface C1129a {
        /* renamed from: a */
        void mo10820a(JSONObject jSONObject);
    }

    /* renamed from: com.applovin.impl.sdk.e.i$b */
    public class C1130b extends C1109a {
        public C1130b(C1188m mVar) {
            super("TaskTimeoutFetchBasicSettings", mVar, true);
        }

        public void run() {
            synchronized (C1127i.this.f1995d) {
                if (C1127i.this.f1996e != null) {
                    mo10773d("Timing out fetch basic settings...");
                    C1127i.this.m1881a(new JSONObject());
                }
            }
        }
    }

    public C1127i(int i, C1188m mVar, C1129a aVar) {
        super("TaskFetchBasicSettings", mVar, true);
        this.f1994c = i;
        this.f1996e = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1881a(JSONObject jSONObject) {
        synchronized (this.f1995d) {
            if (this.f1996e != null) {
                this.f1996e.mo10820a(jSONObject);
                this.f1996e = null;
            }
        }
    }

    /* renamed from: c */
    private String m1883c() {
        return C1264h.m2515a((String) this.f1961b.mo10946a(C1085b.f1566aV), "5.0/i", mo10772d());
    }

    /* renamed from: h */
    private String m1884h() {
        return C1264h.m2515a((String) this.f1961b.mo10946a(C1085b.f1567aW), "5.0/i", mo10772d());
    }

    /* renamed from: a */
    public Map<String, String> mo10815a() {
        HashMap hashMap = new HashMap();
        hashMap.put("rid", UUID.randomUUID().toString());
        if (!((Boolean) this.f1961b.mo10946a(C1085b.f1797et)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f1961b.mo11010z());
        }
        Boolean a = C1173j.m2018b().mo10902a(mo10775f());
        if (a != null) {
            hashMap.put("huc", a.toString());
        }
        Boolean a2 = C1173j.m2013a().mo10902a(mo10775f());
        if (a2 != null) {
            hashMap.put("aru", a2.toString());
        }
        Boolean a3 = C1173j.m2020c().mo10902a(mo10775f());
        if (a3 != null) {
            hashMap.put("dns", a3.toString());
        }
        return hashMap;
    }

    /* renamed from: b */
    public JSONObject mo10816b() {
        String str = "gms_mb";
        String str2 = DeviceRequestsHelper.DEVICE_INFO_MODEL;
        JSONObject jSONObject = new JSONObject();
        String str3 = "revision";
        String str4 = "hardware";
        try {
            jSONObject.put(FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, AppLovinSdk.VERSION);
            jSONObject.put("is_cross_promo", this.f1961b.mo10988e());
            jSONObject.put("init_count", this.f1994c);
            String str5 = "brand_name";
            jSONObject.put("server_installed_at", this.f1961b.mo10946a(C1085b.f1580al));
            String userEngagementSdkVersion = Utils.getUserEngagementSdkVersion();
            if (StringUtils.isValidString(userEngagementSdkVersion)) {
                jSONObject.put("ue_sdk_version", userEngagementSdkVersion);
            }
            if (this.f1961b.mo10935P()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f1961b.mo10936Q()) {
                jSONObject.put("first_install_v2", true);
            }
            String str6 = (String) this.f1961b.mo10946a(C1085b.f1700dA);
            if (StringUtils.isValidString(str6)) {
                jSONObject.put("plugin_version", str6);
            }
            String t = this.f1961b.mo11003t();
            if (StringUtils.isValidString(t)) {
                jSONObject.put("mediation_provider", t);
            }
            jSONObject.put("installed_mediation_adapters", C0867c.m937a(this.f1961b));
            Map<String, Object> h = this.f1961b.mo10941V().mo11213h();
            jSONObject.put("package_name", h.get("package_name"));
            jSONObject.put("app_version", h.get("app_version"));
            jSONObject.put("test_ads", h.get("test_ads"));
            jSONObject.put(GraphRequest.DEBUG_PARAM, h.get(GraphRequest.DEBUG_PARAM));
            jSONObject.put("tg", h.get("tg"));
            jSONObject.put("target_sdk", h.get("target_sdk"));
            if (this.f1961b.mo10999p().getInitializationAdUnitIds().size() > 0) {
                List<String> removeTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(this.f1961b.mo10999p().getInitializationAdUnitIds());
                jSONObject.put("ad_unit_ids", CollectionUtils.implode(removeTrimmedEmptyStrings, removeTrimmedEmptyStrings.size()));
            }
            jSONObject.put("IABTCF_TCString", h.get("IABTCF_TCString"));
            jSONObject.put("IABTCF_TCString", h.get("IABTCF_gdprApplies"));
            Map<String, Object> b = this.f1961b.mo10941V().mo11207b();
            jSONObject.put("platform", b.get("platform"));
            jSONObject.put("os", b.get("os"));
            jSONObject.put("locale", b.get("locale"));
            jSONObject.put("brand", b.get("brand"));
            String str7 = str5;
            jSONObject.put(str7, b.get(str7));
            String str8 = str4;
            jSONObject.put(str8, b.get(str8));
            String str9 = str2;
            jSONObject.put(str9, b.get(str9));
            String str10 = str3;
            jSONObject.put(str10, b.get(str10));
            String str11 = str;
            if (b.containsKey(str11)) {
                jSONObject.put(str11, b.get(str11));
            }
            if (((Boolean) this.f1961b.mo10946a(C1085b.f1709dJ)).booleanValue()) {
                jSONObject.put("mtl", this.f1961b.mo10965ac().mo11387b());
            }
            C1234o.C1240a l = this.f1961b.mo10941V().mo11217l();
            jSONObject.put("dnt", l.f2382a);
            if (StringUtils.isValidString(l.f2383b)) {
                jSONObject.put("idfa", l.f2383b);
            }
            C1234o.C1241b m = this.f1961b.mo10941V().mo11218m();
            if (((Boolean) this.f1961b.mo10946a(C1085b.f1744ds)).booleanValue() && m != null) {
                jSONObject.put("idfv", m.f2384a);
                jSONObject.put("idfv_scope", m.f2385b);
            }
            String name = this.f1961b.mo11000q().getName();
            if (StringUtils.isValidString(name)) {
                jSONObject.put("user_segment_name", StringUtils.encodeUrlString(name));
            }
            if (((Boolean) this.f1961b.mo10946a(C1085b.f1747dv)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f1961b.mo10997n());
            }
            if (((Boolean) this.f1961b.mo10946a(C1085b.f1749dx)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f1961b.mo10998o());
            }
            if (this.f1961b.mo10930J().mo10221a()) {
                jSONObject.put("test_mode", true);
            }
            String c = this.f1961b.mo10930J().mo10224c();
            if (StringUtils.isValidString(c)) {
                jSONObject.put("test_mode_network", c);
            }
            jSONObject.put("sdk_extra_parameters", new JSONObject(this.f1961b.mo10999p().getExtraParameters()));
        } catch (JSONException e) {
            mo10769a("Failed to construct JSON body", e);
        }
        return jSONObject;
    }

    public void run() {
        if (f1993a.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(this.f1961b.mo10932L());
            } catch (Throwable th) {
                mo10769a("Cannot update security provider", th);
            }
        }
        Map<String, String> a = mo10815a();
        C1217c<T> a2 = C1217c.m2223a(this.f1961b).mo11127a(m1883c()).mo11137c(m1884h()).mo11128a(a).mo11129a(mo10816b()).mo11139d(((Boolean) this.f1961b.mo10946a(C1085b.f1803ez)).booleanValue()).mo11133b("POST").mo11126a(new JSONObject()).mo11125a(((Integer) this.f1961b.mo10946a(C1085b.f1727db)).intValue()).mo11136c(((Integer) this.f1961b.mo10946a(C1085b.f1730de)).intValue()).mo11132b(((Integer) this.f1961b.mo10946a(C1085b.f1726da)).intValue()).mo11140e(true).mo11131a();
        this.f1961b.mo10938S().mo10830a(new C1130b(this.f1961b), C1140o.C1142a.TIMEOUT, ((long) ((Integer) this.f1961b.mo10946a(C1085b.f1726da)).intValue()) + 250);
        C11281 r1 = new C1157u<JSONObject>(a2, this.f1961b, mo10776g()) {
            /* renamed from: a */
            public void mo10008a(int i, String str, JSONObject jSONObject) {
                mo10773d("Unable to fetch basic SDK settings: server returned " + i);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                C1127i.this.m1881a(jSONObject);
            }

            /* renamed from: a */
            public void mo10010a(JSONObject jSONObject, int i) {
                C1127i.this.m1881a(jSONObject);
            }
        };
        r1.mo10853a(C1085b.f1566aV);
        r1.mo10855b(C1085b.f1567aW);
        this.f1961b.mo10938S().mo10828a((C1109a) r1);
    }
}
