package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1125h;
import com.applovin.impl.sdk.utils.C1264h;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.nativeAd.c */
public class C1207c extends C1125h {

    /* renamed from: c */
    public final AppLovinNativeAdLoadListener f2251c;

    public C1207c(C1056d dVar, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, C1188m mVar) {
        super(dVar, (C1231i) null, str, mVar);
        this.f2251c = appLovinNativeAdLoadListener;
    }

    /* renamed from: a */
    public C1109a mo10805a(JSONObject jSONObject) {
        return new C1208d(jSONObject, this.f2251c, this.f1961b);
    }

    /* renamed from: a */
    public void mo10807a(int i) {
        super.mo10807a(i);
        this.f2251c.onNativeAdLoadFailed(i);
    }

    /* renamed from: b */
    public String mo10808b() {
        return C1264h.m2533i(this.f1961b);
    }

    /* renamed from: c */
    public String mo10810c() {
        return C1264h.m2534j(this.f1961b);
    }
}
