package com.applovin.impl.sdk.nativeAd;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1054c;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppLovinNativeAdService {
    public static final String TAG = "AppLovinNativeAdService";
    public final C1314v logger;
    public final C1188m sdk;

    public AppLovinNativeAdService(C1188m mVar) {
        this.sdk = mVar;
        this.logger = mVar.mo10922B();
    }

    public void loadNextAdForAdToken(String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        StringBuilder sb;
        String str2;
        String trim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(trim)) {
            C1314v.m2663i(TAG, "Invalid ad token specified");
            C1267j.m2545a(appLovinNativeAdLoadListener, -8);
            return;
        }
        C1054c cVar = new C1054c(trim, this.sdk);
        if (cVar.mo10541b() == C1054c.C1055a.REGULAR) {
            C1314v vVar = this.logger;
            vVar.mo11372b(TAG, "Loading next ad for token: " + cVar);
            this.sdk.mo10938S().mo10829a((C1109a) new C1206b(cVar, appLovinNativeAdLoadListener, this.sdk), C1140o.C1142a.MAIN);
            return;
        }
        if (cVar.mo10541b() == C1054c.C1055a.AD_RESPONSE_JSON) {
            JSONObject d = cVar.mo10543d();
            if (d != null) {
                C1264h.m2530f(d, this.sdk);
                C1264h.m2526d(d, this.sdk);
                C1264h.m2525c(d, this.sdk);
                C1264h.m2528e(d, this.sdk);
                if (JsonUtils.getJSONArray(d, "ads", new JSONArray()).length() > 0) {
                    C1314v vVar2 = this.logger;
                    vVar2.mo11372b(TAG, "Rendering ad for token: " + cVar);
                    this.sdk.mo10938S().mo10829a((C1109a) new C1208d(d, appLovinNativeAdLoadListener, this.sdk), C1140o.C1142a.MAIN);
                    return;
                }
                C1314v vVar3 = this.logger;
                vVar3.mo11376e(TAG, "No ad returned from the server for token: " + cVar);
                C1267j.m2545a(appLovinNativeAdLoadListener, 204);
                return;
            }
            sb = new StringBuilder();
            str2 = "Unable to retrieve ad response JSON from token: ";
        } else {
            sb = new StringBuilder();
            str2 = "Invalid ad token specified: ";
        }
        sb.append(str2);
        sb.append(cVar);
        C1314v.m2663i(TAG, sb.toString());
        C1267j.m2545a(appLovinNativeAdLoadListener, -8);
    }
}
