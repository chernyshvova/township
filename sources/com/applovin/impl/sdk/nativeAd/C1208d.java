package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.nativeAd.d */
public class C1208d extends C1109a {

    /* renamed from: a */
    public final JSONObject f2252a;

    /* renamed from: c */
    public final AppLovinNativeAdLoadListener f2253c;

    public C1208d(JSONObject jSONObject, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, C1188m mVar) {
        super("TaskProcessNativeAdResponse", mVar);
        this.f2252a = jSONObject;
        this.f2253c = appLovinNativeAdLoadListener;
    }

    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f2252a, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            mo10768a("Processing ad...");
            this.f1961b.mo10938S().mo10828a((C1109a) new C1209e(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()), this.f2252a, this.f2253c, this.f1961b));
            return;
        }
        mo10771c("No ads were returned from the server");
        Utils.maybeHandleNoFillResponseForPublisher("native_native", MaxAdFormat.NATIVE, this.f2252a, this.f1961b);
        this.f2253c.onNativeAdLoadFailed(204);
    }
}
