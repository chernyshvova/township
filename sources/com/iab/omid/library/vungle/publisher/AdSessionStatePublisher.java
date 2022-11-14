package com.iab.omid.library.vungle.publisher;

import android.os.Build;
import android.webkit.WebView;
import com.helpshift.constants.CommonSharedPrefrences;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.C2889a;
import com.iab.omid.library.vungle.p051b.C2895d;
import com.iab.omid.library.vungle.p051b.C2896e;
import com.iab.omid.library.vungle.p053d.C2904b;
import com.iab.omid.library.vungle.p054e.C2906b;
import com.swrve.sdk.rest.RESTClient;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    public C2906b f3526a = new C2906b((WebView) null);

    /* renamed from: d */
    public C2907a f3527d = C2907a.AD_STATE_IDLE;

    /* renamed from: e */
    public long f3528e = System.nanoTime();

    /* renamed from: com.iab.omid.library.vungle.publisher.AdSessionStatePublisher$a */
    public enum C2907a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    /* renamed from: a */
    public void mo36853a() {
    }

    /* renamed from: a */
    public void mo36854a(float f) {
        C2896e.f3510a.mo36849a(getWebView(), "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo36855a(C2889a aVar, AdSessionContext adSessionContext) {
        mo36856a(aVar, adSessionContext, (JSONObject) null);
    }

    /* renamed from: b */
    public void mo36857b() {
        this.f3526a.clear();
    }

    public WebView getWebView() {
        return (WebView) this.f3526a.get();
    }

    /* renamed from: a */
    public void mo36856a(C2889a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String str = aVar.f3499i;
        JSONObject jSONObject2 = new JSONObject();
        C2904b.m3503a(jSONObject2, "environment", "app");
        C2904b.m3503a(jSONObject2, "adSessionType", adSessionContext.adSessionContextType);
        JSONObject jSONObject3 = new JSONObject();
        C2904b.m3503a(jSONObject3, "deviceType", Build.MANUFACTURER + RESTClient.SEMICOLON_SEPARATOR + Build.MODEL);
        C2904b.m3503a(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        C2904b.m3503a(jSONObject3, "os", "Android");
        C2904b.m3503a(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C2904b.m3503a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        C2904b.m3503a(jSONObject4, "partnerName", adSessionContext.partner.name);
        C2904b.m3503a(jSONObject4, "partnerVersion", adSessionContext.partner.version);
        C2904b.m3503a(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        C2904b.m3503a(jSONObject5, CommonSharedPrefrences.LIBRARY_VERSION, "1.3.16-Vungle");
        C2904b.m3503a(jSONObject5, "appId", C2895d.f3508a.f3509b.getApplicationContext().getPackageName());
        C2904b.m3503a(jSONObject2, "app", jSONObject5);
        String str2 = adSessionContext.contentUrl;
        if (str2 != null) {
            C2904b.m3503a(jSONObject2, "contentUrl", str2);
        }
        String str3 = adSessionContext.customReferenceData;
        if (str3 != null) {
            C2904b.m3503a(jSONObject2, "customReferenceData", str3);
        }
        JSONObject jSONObject6 = new JSONObject();
        for (T t : Collections.unmodifiableList(adSessionContext.verificationScriptResources)) {
            if (t != null) {
                C2904b.m3503a(jSONObject6, (String) null, (Object) null);
            } else {
                throw null;
            }
        }
        C2896e.f3510a.mo36849a(getWebView(), "startSession", str, jSONObject2, jSONObject6, jSONObject);
    }
}
