package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1054c;
import com.applovin.impl.sdk.p025ad.C1056d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.nativeAd.b */
public class C1206b extends C1207c {

    /* renamed from: c */
    public final C1054c f2250c;

    public C1206b(C1054c cVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, C1188m mVar) {
        super(C1056d.m1473a("adtoken_zone"), "TaskFetchNativeTokenAd", appLovinNativeAdLoadListener, mVar);
        this.f2250c = cVar;
    }

    /* renamed from: a */
    public Map<String, String> mo10806a() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", this.f2250c.mo10540a());
        hashMap.put("adtoken_prefix", this.f2250c.mo10542c());
        return hashMap;
    }
}
