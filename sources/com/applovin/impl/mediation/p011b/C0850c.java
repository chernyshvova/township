package com.applovin.impl.mediation.p011b;

import android.content.Context;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.p012c.C0866b;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.C1046ac;
import com.applovin.impl.sdk.C1105e;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.p028d.C1104g;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1157u;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.c */
public class C0850c extends C1109a {

    /* renamed from: a */
    public final String f732a;

    /* renamed from: c */
    public final MaxAdFormat f733c;

    /* renamed from: d */
    public final Map<String, Object> f734d;

    /* renamed from: e */
    public final C1231i f735e;

    /* renamed from: f */
    public final JSONArray f736f;

    /* renamed from: g */
    public final Context f737g;

    /* renamed from: h */
    public final C0836a.C0837a f738h;

    public C0850c(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, C1231i iVar, JSONArray jSONArray, Context context, C1188m mVar, C0836a.C0837a aVar) {
        super(GeneratedOutlineSupport.outline16("TaskFetchMediatedAd ", str), mVar);
        this.f732a = str;
        this.f733c = maxAdFormat;
        this.f734d = map;
        this.f735e = iVar;
        this.f736f = jSONArray;
        this.f737g = context;
        this.f738h = aVar;
    }

    /* renamed from: a */
    private String m864a() {
        return C0866b.m929a(this.f1961b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m865a(int i, String str) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to fetch ");
        outline24.append(this.f732a);
        outline24.append(" ad: server returned ");
        outline24.append(i);
        mo10773d(outline24.toString());
        if (i == -800) {
            this.f1961b.mo10939T().mo10757a(C1103f.f1937o);
        }
        C1267j.m2552a((MaxAdListener) this.f738h, this.f732a, (MaxError) i == -1009 ? new MaxErrorImpl(-1009, str) : i == -1001 ? new MaxErrorImpl(-1001, str) : StringUtils.isValidString(str) ? new MaxErrorImpl(-1000, str) : new MaxErrorImpl(-1));
    }

    /* renamed from: a */
    private void m868a(C1104g gVar) {
        long b = gVar.mo10760b(C1103f.f1925c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f1961b.mo10946a(C1085b.f1738dm)).intValue())) {
            gVar.mo10762b(C1103f.f1925c, currentTimeMillis);
            gVar.mo10764c(C1103f.f1926d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m869a(JSONObject jSONObject) {
        try {
            C1264h.m2526d(jSONObject, this.f1961b);
            C1264h.m2525c(jSONObject, this.f1961b);
            C1264h.m2528e(jSONObject, this.f1961b);
            C1264h.m2530f(jSONObject, this.f1961b);
            C0866b.m930a(jSONObject, this.f1961b);
            C0866b.m932b(jSONObject, this.f1961b);
            C1105e.m1782a(this.f1961b);
            if (this.f733c != MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, (String) null))) {
                C1314v.m2663i(mo10774e(), "Ad format requested does not match ad unit id's format.");
            }
            this.f1961b.mo10938S().mo10828a((C1109a) m870b(jSONObject));
        } catch (Throwable th) {
            mo10769a("Unable to process mediated ad response", th);
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    /* renamed from: b */
    private C0854e m870b(JSONObject jSONObject) {
        return new C0854e(this.f732a, this.f733c, this.f734d, jSONObject, this.f737g, this.f1961b, this.f738h);
    }

    /* renamed from: b */
    private String m871b() {
        return C0866b.m931b(this.f1961b);
    }

    /* renamed from: c */
    private Map<String, String> m872c() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("AppLovin-Ad-Unit-Id", this.f732a);
        hashMap.put("AppLovin-Ad-Format", this.f733c.getLabel());
        return hashMap;
    }

    /* renamed from: c */
    private void m873c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray(this.f1961b.mo10923C().mo10239c()));
            jSONObject2.put("installed", C0867c.m937a(this.f1961b));
            jSONObject2.put("initialized", this.f1961b.mo10924D().mo10234d());
            jSONObject2.put("initialized_classnames", new JSONArray(this.f1961b.mo10924D().mo10233c()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.f1961b.mo10923C().mo10236a()));
            jSONObject2.put("failed_classnames", new JSONArray(this.f1961b.mo10923C().mo10238b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e) {
            mo10769a("Failed to populate adapter classNames", e);
            throw new RuntimeException("Failed to populate classNames: " + e);
        }
    }

    /* renamed from: d */
    private void m874d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f736f;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    /* renamed from: e */
    private void m875e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.f732a);
        jSONObject2.put(FirebaseAnalytics.Param.AD_FORMAT, this.f733c.getLabel());
        Map<String, String> stringMap = BundleUtils.toStringMap(this.f735e.mo11196a());
        String a = this.f1961b.mo10926F().mo11377a(this.f732a);
        if (StringUtils.isValidString(a)) {
            stringMap.put("previous_winning_network", a);
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(stringMap));
        jSONObject2.put("n", String.valueOf(this.f1961b.mo10968af().mo11385a(this.f732a)));
        if (StringUtils.isValidString(this.f735e.mo11197b())) {
            jSONObject2.put("custom_postback_data", this.f735e.mo11197b());
        }
        jSONObject.put("ad_info", jSONObject2);
    }

    /* renamed from: f */
    private void m876f(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.f1961b.mo10925E().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData != null && Utils.isDspDemoApp(this.f1961b.mo10932L())) {
            JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
        }
    }

    /* renamed from: g */
    private void m877g(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.f1961b.mo10999p().getExtraParameters()));
    }

    /* renamed from: h */
    private JSONObject m878h() throws JSONException {
        JSONObject jSONObject = new JSONObject(this.f1961b.mo10941V().mo11205a((Map<String, String>) null, false, true));
        m875e(jSONObject);
        m874d(jSONObject);
        m873c(jSONObject);
        m876f(jSONObject);
        m877g(jSONObject);
        return jSONObject;
    }

    public void run() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Fetching next ad for ad unit id: ");
        outline24.append(this.f732a);
        outline24.append(" and format: ");
        outline24.append(this.f733c);
        mo10768a(outline24.toString());
        if (((Boolean) this.f1961b.mo10946a(C1085b.f1706dG)).booleanValue() && Utils.isVPNConnected()) {
            mo10768a("User is connected to a VPN");
        }
        C1104g T = this.f1961b.mo10939T();
        T.mo10757a(C1103f.f1936n);
        if (T.mo10760b(C1103f.f1925c) == 0) {
            T.mo10762b(C1103f.f1925c, System.currentTimeMillis());
        }
        try {
            JSONObject h = m878h();
            HashMap hashMap = new HashMap();
            hashMap.put("rid", UUID.randomUUID().toString());
            if (!((Boolean) this.f1961b.mo10946a(C1085b.f1797et)).booleanValue()) {
                hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f1961b.mo11010z());
            }
            if (this.f1961b.mo10930J().mo10221a()) {
                hashMap.put("test_mode", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            String c = this.f1961b.mo10930J().mo10224c();
            if (StringUtils.isValidString(c)) {
                hashMap.put("filter_ad_network", c);
                if (!this.f1961b.mo10930J().mo10221a()) {
                    hashMap.put("fhkZsVqYC7", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
                if (this.f1961b.mo10930J().mo10223b()) {
                    hashMap.put("force_ad_network", c);
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(C1046ac.m1444b());
            hashMap2.putAll(m872c());
            m868a(T);
            C08511 r1 = new C1157u<JSONObject>(C1217c.m2223a(this.f1961b).mo11133b("POST").mo11134b((Map<String, String>) hashMap2).mo11127a(m864a()).mo11137c(m871b()).mo11128a((Map<String, String>) hashMap).mo11129a(h).mo11139d(((Boolean) this.f1961b.mo10946a(C1084a.f1517aa)).booleanValue()).mo11126a(new JSONObject()).mo11132b(((Long) this.f1961b.mo10946a(C1084a.f1523f)).intValue()).mo11125a(((Integer) this.f1961b.mo10946a(C1085b.f1669cV)).intValue()).mo11136c(((Long) this.f1961b.mo10946a(C1084a.f1522e)).intValue()).mo11140e(true).mo11131a(), this.f1961b) {
                /* renamed from: a */
                public void mo10008a(int i, String str, JSONObject jSONObject) {
                    C0850c.this.m865a(i, str);
                }

                /* renamed from: a */
                public void mo10010a(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.f2085d.mo11096a());
                        JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.f2085d.mo11097b());
                        C0850c.this.m869a(jSONObject);
                        return;
                    }
                    C0850c.this.m865a(i, (String) null);
                }
            };
            r1.mo10853a(C1084a.f1520c);
            r1.mo10855b(C1084a.f1521d);
            this.f1961b.mo10938S().mo10828a((C1109a) r1);
        } catch (Throwable th) {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Unable to fetch ad ");
            outline242.append(this.f732a);
            mo10769a(outline242.toString(), th);
            throw new RuntimeException("Unable to fetch ad: " + th);
        }
    }
}
