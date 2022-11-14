package com.iab.omid.library.vungle.adsession;

import android.view.View;
import android.webkit.WebView;
import com.iab.omid.library.vungle.p051b.C2891a;
import com.iab.omid.library.vungle.p051b.C2894c;
import com.iab.omid.library.vungle.p051b.C2896e;
import com.iab.omid.library.vungle.p053d.C2904b;
import com.iab.omid.library.vungle.p054e.C2905a;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.publisher.C2908a;
import com.iab.omid.library.vungle.publisher.C2909b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.adsession.a */
public class C2889a extends AdSession {

    /* renamed from: b */
    public final AdSessionContext f3493b;

    /* renamed from: d */
    public final List<C2894c> f3494d = new ArrayList();

    /* renamed from: e */
    public C2905a f3495e;

    /* renamed from: f */
    public AdSessionStatePublisher f3496f;

    /* renamed from: g */
    public boolean f3497g = false;

    /* renamed from: h */
    public boolean f3498h = false;

    /* renamed from: i */
    public final String f3499i;

    static {
        Pattern.compile("^[a-zA-Z0-9 ]+$");
    }

    public C2889a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        AdSessionStatePublisher adSessionStatePublisher;
        this.f3493b = adSessionContext;
        this.f3499i = UUID.randomUUID().toString();
        this.f3495e = new C2905a((View) null);
        AdSessionContextType adSessionContextType = adSessionContext.adSessionContextType;
        if (adSessionContextType == AdSessionContextType.HTML || adSessionContextType == AdSessionContextType.JAVASCRIPT) {
            adSessionStatePublisher = new C2908a(adSessionContext.webView);
        } else {
            adSessionStatePublisher = new C2909b(Collections.unmodifiableMap(adSessionContext.injectedResourcesMap), adSessionContext.omidJsScriptContent);
        }
        this.f3496f = adSessionStatePublisher;
        adSessionStatePublisher.mo36853a();
        C2891a.f3501a.f3502b.add(this);
        AdSessionStatePublisher adSessionStatePublisher2 = this.f3496f;
        C2896e eVar = C2896e.f3510a;
        WebView webView = adSessionStatePublisher2.getWebView();
        JSONObject jSONObject = new JSONObject();
        C2904b.m3503a(jSONObject, "impressionOwner", adSessionConfiguration.impressionOwner);
        C2904b.m3503a(jSONObject, "mediaEventsOwner", adSessionConfiguration.mediaEventsOwner);
        C2904b.m3503a(jSONObject, "creativeType", adSessionConfiguration.creativeType);
        C2904b.m3503a(jSONObject, "impressionType", adSessionConfiguration.impressionType);
        C2904b.m3503a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(adSessionConfiguration.isolateVerificationScripts));
        eVar.mo36849a(webView, "init", jSONObject);
    }

    /* renamed from: d */
    public View mo36836d() {
        return (View) this.f3495e.get();
    }
}
