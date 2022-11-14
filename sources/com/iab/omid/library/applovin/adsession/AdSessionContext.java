package com.iab.omid.library.applovin.adsession;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.p047d.C2860e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class AdSessionContext {
    public final AdSessionContextType adSessionContextType;
    @Nullable
    public final String contentUrl;
    public final String customReferenceData;
    public final Map<String, VerificationScriptResource> injectedResourcesMap = new HashMap();
    public final String omidJsScriptContent;
    public final Partner partner;
    public final List<VerificationScriptResource> verificationScriptResources = new ArrayList();
    public final WebView webView;

    public AdSessionContext(Partner partner2, WebView webView2, String str, List<VerificationScriptResource> list, @Nullable String str2, String str3, AdSessionContextType adSessionContextType2) {
        this.partner = partner2;
        this.webView = webView2;
        this.omidJsScriptContent = str;
        this.adSessionContextType = adSessionContextType2;
        if (list != null) {
            this.verificationScriptResources.addAll(list);
            for (VerificationScriptResource put : list) {
                String uuid = UUID.randomUUID().toString();
                this.injectedResourcesMap.put(uuid, put);
            }
        }
        this.contentUrl = str2;
        this.customReferenceData = str3;
    }

    public static AdSessionContext createHtmlAdSessionContext(Partner partner2, WebView webView2, @Nullable String str, String str2) {
        C2860e.m3379a((Object) partner2, "Partner is null");
        C2860e.m3379a((Object) webView2, "WebView is null");
        if (str2 != null) {
            C2860e.m3380a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner2, webView2, (String) null, (List<VerificationScriptResource>) null, str, str2, AdSessionContextType.HTML);
    }

    public static AdSessionContext createJavascriptAdSessionContext(Partner partner2, WebView webView2, @Nullable String str, String str2) {
        C2860e.m3379a((Object) partner2, "Partner is null");
        C2860e.m3379a((Object) webView2, "WebView is null");
        if (str2 != null) {
            C2860e.m3380a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner2, webView2, (String) null, (List<VerificationScriptResource>) null, str, str2, AdSessionContextType.JAVASCRIPT);
    }

    public static AdSessionContext createNativeAdSessionContext(Partner partner2, String str, List<VerificationScriptResource> list, @Nullable String str2, String str3) {
        C2860e.m3379a((Object) partner2, "Partner is null");
        C2860e.m3379a((Object) str, "OM SDK JS script content is null");
        C2860e.m3379a((Object) list, "VerificationScriptResources is null");
        if (str3 != null) {
            C2860e.m3380a(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner2, (WebView) null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public AdSessionContextType getAdSessionContextType() {
        return this.adSessionContextType;
    }

    @Nullable
    public String getContentUrl() {
        return this.contentUrl;
    }

    public String getCustomReferenceData() {
        return this.customReferenceData;
    }

    public Map<String, VerificationScriptResource> getInjectedResourcesMap() {
        return Collections.unmodifiableMap(this.injectedResourcesMap);
    }

    public String getOmidJsScriptContent() {
        return this.omidJsScriptContent;
    }

    public Partner getPartner() {
        return this.partner;
    }

    public List<VerificationScriptResource> getVerificationScriptResources() {
        return Collections.unmodifiableList(this.verificationScriptResources);
    }

    public WebView getWebView() {
        return this.webView;
    }
}
