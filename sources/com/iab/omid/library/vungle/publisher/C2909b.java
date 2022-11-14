package com.iab.omid.library.vungle.publisher;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.C2889a;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.iab.omid.library.vungle.p051b.C2895d;
import com.iab.omid.library.vungle.p053d.C2904b;
import com.iab.omid.library.vungle.p054e.C2906b;
import com.playrix.engine.VideoPlayer;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.vungle.publisher.b */
public class C2909b extends AdSessionStatePublisher {

    /* renamed from: a */
    public WebView f3533a;

    /* renamed from: b */
    public Long f3534b = null;

    /* renamed from: c */
    public final Map<String, VerificationScriptResource> f3535c;

    /* renamed from: d */
    public final String f3536d;

    public C2909b(Map<String, VerificationScriptResource> map, String str) {
        this.f3535c = map;
        this.f3536d = str;
    }

    /* renamed from: a */
    public void mo36853a() {
        WebView webView = new WebView(C2895d.f3508a.f3509b);
        this.f3533a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f3526a = new C2906b(this.f3533a);
        WebView webView2 = this.f3533a;
        String str = this.f3536d;
        if (webView2 != null && !TextUtils.isEmpty(str)) {
            webView2.loadUrl("javascript: " + str);
        }
        Iterator<String> it = this.f3535c.keySet().iterator();
        if (it.hasNext()) {
            if (this.f3535c.get(it.next()) != null) {
                throw null;
            }
            throw null;
        }
        this.f3534b = Long.valueOf(System.nanoTime());
    }

    /* renamed from: b */
    public void mo36857b() {
        long j;
        this.f3526a.clear();
        if (this.f3534b == null) {
            j = 4000;
        } else {
            j = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.f3534b.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            public final WebView f3538b = C2909b.this.f3533a;

            public void run() {
                this.f3538b.destroy();
            }
        }, Math.max(VideoPlayer.FRAME_TIMEOUT - j, 2000));
        this.f3533a = null;
    }

    /* renamed from: a */
    public void mo36855a(C2889a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> unmodifiableMap = Collections.unmodifiableMap(adSessionContext.injectedResourcesMap);
        for (String next : unmodifiableMap.keySet()) {
            C2904b.m3503a(jSONObject, next, unmodifiableMap.get(next));
        }
        mo36856a(aVar, adSessionContext, jSONObject);
    }
}
