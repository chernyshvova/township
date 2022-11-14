package com.applovin.impl.sdk.p029e;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p026b.C1082c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.v */
public class C1159v extends C1160w {

    /* renamed from: a */
    public final C1057e f2091a;

    public C1159v(C1057e eVar, C1188m mVar) {
        super("TaskReportAppLovinReward", mVar);
        this.f2091a = eVar;
    }

    /* renamed from: a */
    public String mo10020a() {
        return "2.0/cr";
    }

    /* renamed from: a */
    public void mo10021a(int i) {
        super.mo10021a(i);
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to report reward for ad: ");
        outline24.append(this.f2091a);
        outline24.append(" - error code: ");
        outline24.append(i);
        mo10773d(outline24.toString());
    }

    /* renamed from: a */
    public void mo10022a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.f2091a.getAdZone().mo10548a());
        JsonUtils.putInt(jSONObject, "fire_percent", this.f2091a.mo10580Z());
        String clCode = this.f2091a.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    /* renamed from: b */
    public C1082c mo10023b() {
        return this.f2091a.mo10588aC();
    }

    /* renamed from: b */
    public void mo10024b(JSONObject jSONObject) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Reported reward successfully for ad: ");
        outline24.append(this.f2091a);
        mo10768a(outline24.toString());
    }

    /* renamed from: c */
    public void mo10025c() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("No reward result was found for ad: ");
        outline24.append(this.f2091a);
        mo10773d(outline24.toString());
    }
}
