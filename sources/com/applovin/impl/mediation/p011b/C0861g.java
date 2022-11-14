package com.applovin.impl.mediation.p011b;

import com.applovin.impl.mediation.p010a.C0803c;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p026b.C1082c;
import com.applovin.impl.sdk.p029e.C1111ab;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.g */
public class C0861g extends C1111ab {

    /* renamed from: a */
    public final C0803c f769a;

    public C0861g(C0803c cVar, C1188m mVar) {
        super("TaskValidateMaxReward", mVar);
        this.f769a = cVar;
    }

    /* renamed from: a */
    public String mo10020a() {
        return "2.0/mvr";
    }

    /* renamed from: a */
    public void mo10021a(int i) {
        super.mo10021a(i);
        this.f769a.mo9879a(C1082c.m1637a((i < 400 || i >= 500) ? "network_timeout" : "rejected"));
    }

    /* renamed from: a */
    public void mo10026a(C1082c cVar) {
        this.f769a.mo9879a(cVar);
    }

    /* renamed from: a */
    public void mo10022a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f769a.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f769a.getPlacement());
        JsonUtils.putString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, this.f769a.getFormat().getLabel());
        String D = this.f769a.mo9870D();
        if (!StringUtils.isValidString(D)) {
            D = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", D);
        String C = this.f769a.mo9869C();
        if (!StringUtils.isValidString(C)) {
            C = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", C);
    }

    /* renamed from: b */
    public boolean mo10027b() {
        return this.f769a.mo9871E();
    }
}
