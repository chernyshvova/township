package com.applovin.impl.mediation.p011b;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0803c;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p026b.C1082c;
import com.applovin.impl.sdk.p029e.C1160w;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.f */
public class C0860f extends C1160w {

    /* renamed from: a */
    public final C0803c f768a;

    public C0860f(C0803c cVar, C1188m mVar) {
        super("TaskReportMaxReward", mVar);
        this.f768a = cVar;
    }

    /* renamed from: a */
    public String mo10020a() {
        return "2.0/mcr";
    }

    /* renamed from: a */
    public void mo10021a(int i) {
        super.mo10021a(i);
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to report reward for mediated ad: ");
        outline24.append(this.f768a);
        outline24.append(" - error code: ");
        outline24.append(i);
        mo10768a(outline24.toString());
    }

    /* renamed from: a */
    public void mo10022a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f768a.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f768a.getPlacement());
        String D = this.f768a.mo9870D();
        if (!StringUtils.isValidString(D)) {
            D = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", D);
        String C = this.f768a.mo9869C();
        if (!StringUtils.isValidString(C)) {
            C = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", C);
    }

    /* renamed from: b */
    public C1082c mo10023b() {
        return this.f768a.mo9873G();
    }

    /* renamed from: b */
    public void mo10024b(JSONObject jSONObject) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Reported reward successfully for mediated ad: ");
        outline24.append(this.f768a);
        mo10768a(outline24.toString());
    }

    /* renamed from: c */
    public void mo10025c() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("No reward result was found for mediated ad: ");
        outline24.append(this.f768a);
        mo10773d(outline24.toString());
    }
}
