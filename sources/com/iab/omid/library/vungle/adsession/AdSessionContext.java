package com.iab.omid.library.vungle.adsession;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        this.omidJsScriptContent = null;
        this.adSessionContextType = adSessionContextType2;
        this.contentUrl = str2;
        this.customReferenceData = str3;
    }
}
