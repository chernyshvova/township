package com.applovin.impl.mediation.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.p010a.C0804d;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class MaxNativeAdLoaderImpl extends C0836a {

    /* renamed from: a */
    public final C0834a f691a = new C0834a();

    /* renamed from: b */
    public String f692b;

    /* renamed from: c */
    public MaxNativeAdListener f693c;

    /* renamed from: d */
    public final Map<String, MaxNativeAdView> f694d = new HashMap();

    /* renamed from: e */
    public final Object f695e = new Object();

    /* renamed from: com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl$a */
    public class C0834a implements C0836a.C0837a {
        public C0834a() {
        }

        public void onAdClicked(MaxAd maxAd) {
            C1267j.m2556a(MaxNativeAdLoaderImpl.this.f693c, maxAd, true);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdHidden(MaxAd maxAd) {
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxNativeAdView unused = MaxNativeAdLoaderImpl.this.m829a(((MaxErrorImpl) maxError).getLoadTag());
            C1267j.m2558a(MaxNativeAdLoaderImpl.this.f693c, str, maxError, true);
        }

        public void onAdLoaded(final MaxAd maxAd) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    C0804d dVar = (C0804d) maxAd;
                    dVar.mo9928d(MaxNativeAdLoaderImpl.this.f692b);
                    dVar.mo9929e(MaxNativeAdLoaderImpl.this.customPostbackData);
                    MaxNativeAd v = dVar.mo9862v();
                    MaxNativeAdView a = MaxNativeAdLoaderImpl.this.m829a(dVar.mo9825a());
                    if (a == null) {
                        String x = dVar.mo9886x();
                        if (StringUtils.isValidString(x)) {
                            a = new MaxNativeAdView(x, MaxNativeAdLoaderImpl.this.sdk.mo10932L());
                        } else {
                            MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                            C1314v vVar = maxNativeAdLoaderImpl.logger;
                            String str = maxNativeAdLoaderImpl.tag;
                            vVar.mo11372b(str, "Native ad failed to load: " + "Both template and native ad view are null. Please select a template in the dashboard or provide a `MaxNativeAdView` when loading the ad to render the native ad.");
                            C1267j.m2558a(MaxNativeAdLoaderImpl.this.f693c, MaxNativeAdLoaderImpl.this.adUnitId, (MaxError) new MaxErrorImpl(-5001, "Both template and native ad view are null. Please select a template in the dashboard or provide a `MaxNativeAdView` when loading the ad to render the native ad."), true);
                            return;
                        }
                    }
                    dVar.mo9884a(a);
                    C0834a aVar = C0834a.this;
                    a.render(dVar, aVar, MaxNativeAdLoaderImpl.this.sdk);
                    v.prepareViewForInteraction(a);
                    C1267j.m2557a(MaxNativeAdLoaderImpl.this.f693c, a, maxAd, true);
                }
            });
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            C1267j.m2555a(MaxNativeAdLoaderImpl.this.revenueListener, maxAd, true);
        }
    }

    public MaxNativeAdLoaderImpl(String str, C1188m mVar, Context context) {
        super(str, MaxAdFormat.NATIVE, "MaxNativeAdLoader", mVar);
        C1314v vVar = this.logger;
        String str2 = this.tag;
        vVar.mo11372b(str2, "Created new MaxNativeAdLoader (" + this + ")");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public MaxNativeAdView m829a(String str) {
        MaxNativeAdView remove;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f695e) {
            remove = this.f694d.remove(str);
        }
        return remove;
    }

    /* renamed from: a */
    private void m831a(String str, MaxNativeAdView maxNativeAdView) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f695e) {
                this.f694d.put(str, maxNativeAdView);
            }
        }
    }

    public void destroy(MaxAd maxAd) {
        String str;
        StringBuilder sb;
        String str2;
        C1314v vVar;
        if (maxAd instanceof C0804d) {
            C0804d dVar = (C0804d) maxAd;
            if (dVar.mo9887y()) {
                C1314v vVar2 = this.logger;
                String str3 = this.tag;
                vVar2.mo11372b(str3, "Native ad(" + dVar + ") has already been destroyed");
                return;
            }
            MaxNativeAdView w = dVar.mo9885w();
            if (w != null) {
                w.recycle();
                return;
            }
            vVar = this.logger;
            str2 = this.tag;
            sb = new StringBuilder();
            sb.append("Destroy failed on native ad(");
            sb.append(dVar);
            str = "): native ad view not found";
        } else {
            vVar = this.logger;
            str2 = this.tag;
            sb = new StringBuilder();
            sb.append("Destroy failed on non-native ad(");
            sb.append(maxAd);
            str = ")";
        }
        sb.append(str);
        vVar.mo11372b(str2, sb.toString());
    }

    public String getPlacement() {
        return this.f692b;
    }

    public void loadAd(@Nullable MaxNativeAdView maxNativeAdView) {
        C1314v vVar = this.logger;
        String str = this.tag;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loading native ad for '");
        outline24.append(this.adUnitId);
        outline24.append("' and notifying ");
        outline24.append(this.f691a);
        outline24.append("...");
        vVar.mo11372b(str, outline24.toString());
        this.loadRequestBuilder.mo11200a("integration_type", maxNativeAdView != null ? "custom_ad_view" : "template");
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        m831a(lowerCase, maxNativeAdView);
        this.sdk.mo10925E().loadAd(this.adUnitId, lowerCase, MaxAdFormat.NATIVE, this.localExtraParameters, this.loadRequestBuilder.mo11201a(), this.sdk.mo10932L(), this.f691a);
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        C1314v vVar = this.logger;
        String str = this.tag;
        vVar.mo11372b(str, "Setting native ad listener: " + maxNativeAdListener);
        this.f693c = maxNativeAdListener;
    }

    public void setPlacement(String str) {
        this.f692b = str;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MaxNativeAdLoader{adUnitId='");
        GeneratedOutlineSupport.outline33(outline24, this.adUnitId, '\'', ", nativeAdListener=");
        outline24.append(this.f693c);
        outline24.append(", revenueListener=");
        outline24.append(this.revenueListener);
        outline24.append('}');
        return outline24.toString();
    }
}
