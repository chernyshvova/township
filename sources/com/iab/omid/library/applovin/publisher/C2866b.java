package com.iab.omid.library.applovin.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.p045b.C2845d;
import com.iab.omid.library.applovin.p045b.C2846e;
import com.iab.omid.library.applovin.p047d.C2856b;
import com.iab.omid.library.applovin.p047d.C2859d;
import com.playrix.engine.VideoPlayer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.publisher.b */
public class C2866b extends AdSessionStatePublisher {

    /* renamed from: a */
    public WebView f3441a;

    /* renamed from: b */
    public Long f3442b = null;

    /* renamed from: c */
    public final Map<String, VerificationScriptResource> f3443c;

    /* renamed from: d */
    public final String f3444d;

    public C2866b(Map<String, VerificationScriptResource> map, String str) {
        this.f3443c = map;
        this.f3444d = str;
    }

    /* renamed from: a */
    public void mo36761a() {
        super.mo36761a();
        mo36785j();
    }

    /* renamed from: a */
    public void mo36767a(C2839a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            C2856b.m3362a(jSONObject, next, injectedResourcesMap.get(next));
        }
        mo36768a(aVar, adSessionContext, jSONObject);
    }

    /* renamed from: b */
    public void mo36775b() {
        super.mo36775b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            public final WebView f3446b = C2866b.this.f3441a;

            public void run() {
                this.f3446b.destroy();
            }
        }, Math.max(VideoPlayer.FRAME_TIMEOUT - (this.f3442b == null ? 4000 : TimeUnit.MILLISECONDS.convert(C2859d.m3375a() - this.f3442b.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f3441a = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: j */
    public void mo36785j() {
        WebView webView = new WebView(C2845d.m3305a().mo36733b());
        this.f3441a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        mo36763a(this.f3441a);
        C2846e.m3308a().mo36744a(this.f3441a, this.f3444d);
        for (String next : this.f3443c.keySet()) {
            C2846e.m3308a().mo36737a(this.f3441a, this.f3443c.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.f3442b = Long.valueOf(C2859d.m3375a());
    }
}
