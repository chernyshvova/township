package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.s */
public class C1155s extends C1109a {

    /* renamed from: a */
    public final JSONObject f2077a;

    /* renamed from: c */
    public final JSONObject f2078c;

    /* renamed from: d */
    public final AppLovinAdLoadListener f2079d;

    /* renamed from: e */
    public final C1053b f2080e;

    public C1155s(JSONObject jSONObject, JSONObject jSONObject2, C1053b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        super("TaskRenderAppLovinAd", mVar);
        this.f2077a = jSONObject;
        this.f2078c = jSONObject2;
        this.f2080e = bVar;
        this.f2079d = appLovinAdLoadListener;
    }

    public void run() {
        mo10768a("Rendering ad...");
        C1052a aVar = new C1052a(this.f2077a, this.f2078c, this.f2080e, this.f1961b);
        boolean booleanValue = JsonUtils.getBoolean(this.f2077a, "gs_load_immediately", Boolean.FALSE).booleanValue();
        boolean booleanValue2 = JsonUtils.getBoolean(this.f2077a, "vs_load_immediately", Boolean.TRUE).booleanValue();
        C1118d dVar = new C1118d(aVar, this.f1961b, this.f2079d);
        dVar.mo10800a(booleanValue2);
        dVar.mo10801b(booleanValue);
        C1140o.C1142a aVar2 = C1140o.C1142a.CACHING_OTHER;
        if (((Boolean) this.f1961b.mo10946a(C1085b.f1636bo)).booleanValue()) {
            if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.REGULAR) {
                aVar2 = C1140o.C1142a.CACHING_INTERSTITIAL;
            } else if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.INCENTIVIZED) {
                aVar2 = C1140o.C1142a.CACHING_INCENTIVIZED;
            }
        }
        this.f1961b.mo10938S().mo10829a((C1109a) dVar, aVar2);
    }
}
