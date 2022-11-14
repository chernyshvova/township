package com.applovin.impl.sdk.p029e;

import androidx.annotation.Nullable;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.k */
public class C1132k extends C1125h {

    /* renamed from: c */
    public final AppLovinAdLoadListener f2000c;

    public C1132k(C1056d dVar, @Nullable C1231i iVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        this(dVar, iVar, appLovinAdLoadListener, "TaskFetchNextAd", mVar);
    }

    public C1132k(C1056d dVar, @Nullable C1231i iVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, C1188m mVar) {
        super(dVar, iVar, str, mVar);
        this.f2000c = appLovinAdLoadListener;
    }

    /* renamed from: a */
    public C1109a mo10805a(JSONObject jSONObject) {
        return new C1146p(jSONObject, this.f1990a, mo10811h(), this.f2000c, this.f1961b);
    }

    /* renamed from: a */
    public void mo10807a(int i) {
        super.mo10807a(i);
        this.f2000c.failedToReceiveAd(i);
    }

    /* renamed from: b */
    public String mo10808b() {
        return C1264h.m2531g(this.f1961b);
    }

    /* renamed from: c */
    public String mo10810c() {
        return C1264h.m2532h(this.f1961b);
    }
}
