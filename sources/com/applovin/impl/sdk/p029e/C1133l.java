package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p025ad.C1054c;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.e.l */
public class C1133l extends C1132k {

    /* renamed from: c */
    public final C1054c f2001c;

    public C1133l(C1054c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        super(C1056d.m1473a("adtoken_zone"), (C1231i) null, appLovinAdLoadListener, "TaskFetchTokenAd", mVar);
        this.f2001c = cVar;
    }

    /* renamed from: a */
    public Map<String, String> mo10806a() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", this.f2001c.mo10540a());
        hashMap.put("adtoken_prefix", this.f2001c.mo10542c());
        return hashMap;
    }

    /* renamed from: h */
    public C1053b mo10811h() {
        return C1053b.REGULAR_AD_TOKEN;
    }
}
