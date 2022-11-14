package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.p */
public class C1146p extends C1109a implements AppLovinAdLoadListener {

    /* renamed from: a */
    public final JSONObject f2063a;

    /* renamed from: c */
    public final C1056d f2064c;

    /* renamed from: d */
    public final C1053b f2065d;

    /* renamed from: e */
    public final AppLovinAdLoadListener f2066e;

    public C1146p(JSONObject jSONObject, C1056d dVar, C1053b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        super("TaskProcessAdResponse", mVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (dVar != null) {
            this.f2063a = jSONObject;
            this.f2064c = dVar;
            this.f2065d = bVar;
            this.f2066e = appLovinAdLoadListener;
        } else {
            throw new IllegalArgumentException("No zone specified");
        }
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [com.applovin.impl.sdk.e.a] */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.applovin.impl.sdk.e.q] */
    /* JADX WARNING: type inference failed for: r1v12, types: [com.applovin.impl.sdk.e.s] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1930a(org.json.JSONObject r8) {
        /*
            r7 = this;
            java.lang.String r0 = "type"
            java.lang.String r1 = "undefined"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r8, r0, r1)
            java.lang.String r1 = "applovin"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x002d
            java.lang.String r0 = "Starting task for AppLovin ad..."
            r7.mo10768a(r0)
            com.applovin.impl.sdk.e.s r0 = new com.applovin.impl.sdk.e.s
            org.json.JSONObject r3 = r7.f2063a
            com.applovin.impl.sdk.ad.b r4 = r7.f2065d
            com.applovin.impl.sdk.m r6 = r7.f1961b
            r1 = r0
            r2 = r8
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x0023:
            com.applovin.impl.sdk.m r8 = r7.f1961b
            com.applovin.impl.sdk.e.o r8 = r8.mo10938S()
            r8.mo10828a((com.applovin.impl.sdk.p029e.C1109a) r0)
            goto L_0x0083
        L_0x002d:
            java.lang.String r1 = "vast"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x004e
            java.lang.String r0 = "Starting task for VAST ad..."
            r7.mo10768a(r0)
            org.json.JSONObject r0 = r7.f2063a
            com.applovin.impl.sdk.ad.b r1 = r7.f2065d
            com.applovin.impl.sdk.m r2 = r7.f1961b
            com.applovin.impl.sdk.e.r r8 = com.applovin.impl.sdk.p029e.C1150r.m1941a(r8, r0, r1, r7, r2)
            com.applovin.impl.sdk.m r0 = r7.f1961b
            com.applovin.impl.sdk.e.o r0 = r0.mo10938S()
            r0.mo10828a((com.applovin.impl.sdk.p029e.C1109a) r8)
            goto L_0x0083
        L_0x004e:
            java.lang.String r1 = "js_tag"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x006a
            java.lang.String r0 = "Starting task for JS tag ad..."
            r7.mo10768a(r0)
            com.applovin.impl.sdk.e.q r0 = new com.applovin.impl.sdk.e.q
            org.json.JSONObject r3 = r7.f2063a
            com.applovin.impl.sdk.ad.b r4 = r7.f2065d
            com.applovin.impl.sdk.m r6 = r7.f1961b
            r1 = r0
            r2 = r8
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0023
        L_0x006a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Unable to process ad of unknown type: "
            r8.append(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.mo10771c(r8)
            r8 = -800(0xfffffffffffffce0, float:NaN)
            r7.failedToReceiveAd(r8)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p029e.C1146p.m1930a(org.json.JSONObject):void");
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f2066e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
    }

    public void failedToReceiveAd(int i) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f2066e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
    }

    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f2063a, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            mo10768a("Processing ad...");
            m1930a(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
            return;
        }
        mo10771c("No ads were returned from the server");
        Utils.maybeHandleNoFillResponseForPublisher(this.f2064c.mo10548a(), this.f2064c.mo10549b(), this.f2063a, this.f1961b);
        failedToReceiveAd(204);
    }
}
