package com.iab.omid.library.applovin.publisher;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.helpshift.constants.CommonSharedPrefrences;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.adsession.ErrorType;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.p045b.C2845d;
import com.iab.omid.library.applovin.p045b.C2846e;
import com.iab.omid.library.applovin.p047d.C2855a;
import com.iab.omid.library.applovin.p047d.C2856b;
import com.iab.omid.library.applovin.p047d.C2859d;
import com.iab.omid.library.applovin.p048e.C2863b;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    public C2863b f3432a = new C2863b((WebView) null);

    /* renamed from: b */
    public AdEvents f3433b;

    /* renamed from: c */
    public MediaEvents f3434c;

    /* renamed from: d */
    public C2864a f3435d;

    /* renamed from: e */
    public long f3436e;

    /* renamed from: com.iab.omid.library.applovin.publisher.AdSessionStatePublisher$a */
    public enum C2864a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        mo36784i();
    }

    /* renamed from: a */
    public void mo36761a() {
    }

    /* renamed from: a */
    public void mo36762a(float f) {
        C2846e.m3308a().mo36735a(getWebView(), f);
    }

    /* renamed from: a */
    public void mo36763a(WebView webView) {
        this.f3432a = new C2863b(webView);
    }

    /* renamed from: a */
    public void mo36764a(AdEvents adEvents) {
        this.f3433b = adEvents;
    }

    /* renamed from: a */
    public void mo36765a(AdSessionConfiguration adSessionConfiguration) {
        C2846e.m3308a().mo36742a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    /* renamed from: a */
    public void mo36766a(ErrorType errorType, String str) {
        C2846e.m3308a().mo36736a(getWebView(), errorType, str);
    }

    /* renamed from: a */
    public void mo36767a(C2839a aVar, AdSessionContext adSessionContext) {
        mo36768a(aVar, adSessionContext, (JSONObject) null);
    }

    /* renamed from: a */
    public void mo36768a(C2839a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        C2856b.m3362a(jSONObject2, "environment", "app");
        C2856b.m3362a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        C2856b.m3362a(jSONObject2, "deviceInfo", C2855a.m3354d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C2856b.m3362a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C2856b.m3362a(jSONObject3, "partnerName", adSessionContext.getPartner().getName());
        C2856b.m3362a(jSONObject3, "partnerVersion", adSessionContext.getPartner().getVersion());
        C2856b.m3362a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C2856b.m3362a(jSONObject4, CommonSharedPrefrences.LIBRARY_VERSION, "1.3.24-Applovin");
        C2856b.m3362a(jSONObject4, "appId", C2845d.m3305a().mo36733b().getApplicationContext().getPackageName());
        C2856b.m3362a(jSONObject2, "app", jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            C2856b.m3362a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            C2856b.m3362a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.getVerificationScriptResources()) {
            C2856b.m3362a(jSONObject5, next.getVendorKey(), next.getVerificationParameters());
        }
        C2846e.m3308a().mo36739a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    /* renamed from: a */
    public void mo36769a(MediaEvents mediaEvents) {
        this.f3434c = mediaEvents;
    }

    /* renamed from: a */
    public void mo36770a(String str) {
        C2846e.m3308a().mo36738a(getWebView(), str, (JSONObject) null);
    }

    /* renamed from: a */
    public void mo36771a(String str, long j) {
        if (j >= this.f3436e) {
            this.f3435d = C2864a.AD_STATE_VISIBLE;
            C2846e.m3308a().mo36746b(getWebView(), str);
        }
    }

    /* renamed from: a */
    public void mo36772a(String str, JSONObject jSONObject) {
        C2846e.m3308a().mo36738a(getWebView(), str, jSONObject);
    }

    /* renamed from: a */
    public void mo36773a(@NonNull JSONObject jSONObject) {
        C2846e.m3308a().mo36747b(getWebView(), jSONObject);
    }

    /* renamed from: a */
    public void mo36774a(boolean z) {
        if (mo36779e()) {
            C2846e.m3308a().mo36749c(getWebView(), z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: b */
    public void mo36775b() {
        this.f3432a.clear();
    }

    /* renamed from: b */
    public void mo36776b(String str, long j) {
        C2864a aVar;
        if (j >= this.f3436e && this.f3435d != (aVar = C2864a.AD_STATE_NOTVISIBLE)) {
            this.f3435d = aVar;
            C2846e.m3308a().mo36746b(getWebView(), str);
        }
    }

    /* renamed from: c */
    public AdEvents mo36777c() {
        return this.f3433b;
    }

    /* renamed from: d */
    public MediaEvents mo36778d() {
        return this.f3434c;
    }

    /* renamed from: e */
    public boolean mo36779e() {
        return this.f3432a.get() != null;
    }

    /* renamed from: f */
    public void mo36780f() {
        C2846e.m3308a().mo36734a(getWebView());
    }

    /* renamed from: g */
    public void mo36781g() {
        C2846e.m3308a().mo36745b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f3432a.get();
    }

    /* renamed from: h */
    public void mo36783h() {
        C2846e.m3308a().mo36748c(getWebView());
    }

    /* renamed from: i */
    public void mo36784i() {
        this.f3436e = C2859d.m3375a();
        this.f3435d = C2864a.AD_STATE_IDLE;
    }
}
