package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p026b.C1082c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.aa */
public class C1110aa extends C1111ab {

    /* renamed from: a */
    public final C1057e f1965a;

    /* renamed from: c */
    public final AppLovinAdRewardListener f1966c;

    public C1110aa(C1057e eVar, AppLovinAdRewardListener appLovinAdRewardListener, C1188m mVar) {
        super("TaskValidateAppLovinReward", mVar);
        this.f1965a = eVar;
        this.f1966c = appLovinAdRewardListener;
    }

    /* renamed from: a */
    public String mo10020a() {
        return "2.0/vr";
    }

    /* renamed from: a */
    public void mo10021a(int i) {
        String str;
        super.mo10021a(i);
        if (i < 400 || i >= 500) {
            this.f1966c.validationRequestFailed(this.f1965a, i);
            str = "network_timeout";
        } else {
            this.f1966c.userRewardRejected(this.f1965a, Collections.emptyMap());
            str = "rejected";
        }
        this.f1965a.mo10584a(C1082c.m1637a(str));
    }

    /* renamed from: a */
    public void mo10026a(C1082c cVar) {
        this.f1965a.mo10584a(cVar);
        String b = cVar.mo10667b();
        Map<String, String> a = cVar.mo10666a();
        if (b.equals("accepted")) {
            this.f1966c.userRewardVerified(this.f1965a, a);
        } else if (b.equals("quota_exceeded")) {
            this.f1966c.userOverQuota(this.f1965a, a);
        } else if (b.equals("rejected")) {
            this.f1966c.userRewardRejected(this.f1965a, a);
        } else {
            this.f1966c.validationRequestFailed(this.f1965a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    /* renamed from: a */
    public void mo10022a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.f1965a.getAdZone().mo10548a());
        String clCode = this.f1965a.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    /* renamed from: b */
    public boolean mo10027b() {
        return this.f1965a.mo10586aA();
    }
}
