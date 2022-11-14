package com.applovin.impl.sdk.p024a;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

/* renamed from: com.applovin.impl.sdk.a.e */
public class C1020e extends C1010b {
    public C1020e(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        super(appLovinNativeAdImpl);
    }

    @Nullable
    /* renamed from: a */
    public AdSessionConfiguration mo10448a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            this.f1302c.mo11373b(this.f1303d, "Failed to create ad session configuration", th);
            return null;
        }
    }

    @Nullable
    /* renamed from: a */
    public AdSessionContext mo10449a(@Nullable WebView webView) {
        try {
            return AdSessionContext.createNativeAdSessionContext(this.f1301b.mo10975am().mo10476d(), this.f1301b.mo10975am().mo10477e(), this.f1300a.getOpenMeasurementVerificationScriptResources(), this.f1300a.getOpenMeasurementContentUrl(), this.f1300a.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th) {
            this.f1302c.mo11373b(this.f1303d, "Failed to create ad session context", th);
            return null;
        }
    }
}
