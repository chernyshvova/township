package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1122g;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;

public class PostbackServiceImpl implements AppLovinPostbackService {

    /* renamed from: a */
    public final C1188m f2274a;

    public PostbackServiceImpl(C1188m mVar) {
        this.f2274a = mVar;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(C1229h.m2326b(this.f2274a).mo11127a(str).mo11138c(false).mo11131a(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(C1229h hVar, C1140o.C1142a aVar, AppLovinPostbackListener appLovinPostbackListener) {
        this.f2274a.mo10938S().mo10829a((C1109a) new C1122g(hVar, aVar, this.f2274a, appLovinPostbackListener), aVar);
    }

    public void dispatchPostbackRequest(C1229h hVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(hVar, C1140o.C1142a.POSTBACKS, appLovinPostbackListener);
    }

    public String toString() {
        return "PostbackService{}";
    }
}
