package com.applovin.impl.sdk.p024a;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

/* renamed from: com.applovin.impl.sdk.a.c */
public class C1018c extends C1010b {
    public C1018c(C1052a aVar) {
        super(aVar);
    }

    @Nullable
    /* renamed from: a */
    public AdSessionConfiguration mo10448a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.LOADED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            this.f1302c.mo11373b(this.f1303d, "Failed to create ad session configuration", th);
            return null;
        }
    }

    @Nullable
    /* renamed from: a */
    public AdSessionContext mo10449a(@Nullable WebView webView) {
        try {
            return AdSessionContext.createHtmlAdSessionContext(this.f1301b.mo10975am().mo10476d(), webView, this.f1300a.getOpenMeasurementContentUrl(), this.f1300a.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th) {
            this.f1302c.mo11373b(this.f1303d, "Failed to create ad session context", th);
            return null;
        }
    }
}
