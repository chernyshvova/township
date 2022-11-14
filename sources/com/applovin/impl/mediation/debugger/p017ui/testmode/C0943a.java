package com.applovin.impl.mediation.debugger.p017ui.testmode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.debugger.p013a.p015b.C0883b;
import com.applovin.impl.mediation.debugger.p017ui.C0890a;
import com.applovin.impl.mediation.debugger.p017ui.testmode.AdControlButton;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1368R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.a */
public class C0943a extends C0890a implements AdControlButton.C0941a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    public C0883b f1084a;

    /* renamed from: b */
    public C1188m f1085b;

    /* renamed from: c */
    public MaxAdView f1086c;

    /* renamed from: d */
    public MaxAdView f1087d;

    /* renamed from: e */
    public MaxInterstitialAd f1088e;

    /* renamed from: f */
    public MaxRewardedInterstitialAd f1089f;

    /* renamed from: g */
    public MaxRewardedAd f1090g;

    /* renamed from: h */
    public MaxAd f1091h;

    /* renamed from: i */
    public MaxNativeAdLoader f1092i;

    /* renamed from: j */
    public String f1093j;

    /* renamed from: k */
    public AdControlButton f1094k;

    /* renamed from: l */
    public AdControlButton f1095l;

    /* renamed from: m */
    public AdControlButton f1096m;

    /* renamed from: n */
    public AdControlButton f1097n;

    /* renamed from: o */
    public AdControlButton f1098o;

    /* renamed from: p */
    public AdControlButton f1099p;

    /* renamed from: q */
    public Button f1100q;

    /* renamed from: r */
    public Button f1101r;

    /* renamed from: s */
    public FrameLayout f1102s;

    /* renamed from: t */
    public FrameLayout f1103t;

    /* renamed from: a */
    private AdControlButton m1233a(String str) {
        if (str.equals("test_mode_banner") || str.equals("test_mode_leader")) {
            return this.f1094k;
        }
        if (str.equals("test_mode_mrec")) {
            return this.f1095l;
        }
        if (str.equals("test_mode_interstitial")) {
            return this.f1096m;
        }
        if (str.equals("test_mode_rewarded_interstitial")) {
            return this.f1097n;
        }
        if (str.equals(this.f1093j)) {
            return this.f1098o;
        }
        if (str.equals("test_mode_native")) {
            return this.f1099p;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("Invalid test mode ad unit identifier provided ", str));
    }

    /* renamed from: a */
    private void m1235a() {
        String str;
        MaxAdFormat maxAdFormat;
        boolean isTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(C1368R.C1370id.banner_ad_view_container);
        if (isTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(C1368R.C1370id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (this.f1084a.mo10083p().contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.f1085b.mo10944Y(), this);
            this.f1086c = maxAdView;
            maxAdView.setListener(this);
            frameLayout.addView(this.f1086c, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
            AdControlButton adControlButton = (AdControlButton) findViewById(C1368R.C1370id.banner_control_button);
            this.f1094k = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f1094k.setFormat(maxAdFormat);
            return;
        }
        findViewById(C1368R.C1370id.banner_control_view).setVisibility(8);
        frameLayout.setVisibility(8);
    }

    /* renamed from: a */
    private void m1236a(MaxAdFormat maxAdFormat) {
        MaxAdView maxAdView;
        this.f1085b.mo10930J().mo10218a(this.f1084a.mo10075h());
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            maxAdView = this.f1086c;
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            maxAdView = this.f1087d;
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f1088e.loadAd();
            return;
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f1089f.loadAd();
            return;
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f1090g.loadAd();
            return;
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f1092i.loadAd();
            return;
        } else {
            return;
        }
        maxAdView.loadAd();
    }

    /* renamed from: b */
    private void m1238b() {
        this.f1102s = (FrameLayout) findViewById(C1368R.C1370id.mrec_ad_view_container);
        if (this.f1084a.mo10083p().contains(MaxAdFormat.MREC)) {
            MaxAdView maxAdView = new MaxAdView("test_mode_mrec", MaxAdFormat.MREC, this.f1085b.mo10944Y(), this);
            this.f1087d = maxAdView;
            maxAdView.setListener(this);
            this.f1102s.addView(this.f1087d, new FrameLayout.LayoutParams(-1, -1));
            AdControlButton adControlButton = (AdControlButton) findViewById(C1368R.C1370id.mrec_control_button);
            this.f1095l = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f1095l.setFormat(MaxAdFormat.MREC);
            return;
        }
        findViewById(C1368R.C1370id.mrec_control_view).setVisibility(8);
        this.f1102s.setVisibility(8);
    }

    /* renamed from: b */
    private void m1239b(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f1088e.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f1089f.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f1090g.showAd();
        }
    }

    /* renamed from: c */
    private void m1241c() {
        if (this.f1084a.mo10083p().contains(MaxAdFormat.INTERSTITIAL)) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.f1085b.mo10944Y(), this);
            this.f1088e = maxInterstitialAd;
            maxInterstitialAd.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(C1368R.C1370id.interstitial_control_button);
            this.f1096m = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f1096m.setFormat(MaxAdFormat.INTERSTITIAL);
            return;
        }
        findViewById(C1368R.C1370id.interstitial_control_view).setVisibility(8);
    }

    /* renamed from: d */
    private void m1243d() {
        if (this.f1084a.mo10083p().contains(MaxAdFormat.REWARDED)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("test_mode_rewarded_");
            outline24.append(this.f1084a.mo10075h());
            String sb = outline24.toString();
            this.f1093j = sb;
            MaxRewardedAd instance = MaxRewardedAd.getInstance(sb, this.f1085b.mo10944Y(), this);
            this.f1090g = instance;
            instance.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(C1368R.C1370id.rewarded_control_button);
            this.f1098o = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f1098o.setFormat(MaxAdFormat.REWARDED);
            return;
        }
        findViewById(C1368R.C1370id.rewarded_control_view).setVisibility(8);
    }

    /* renamed from: e */
    private void m1245e() {
        this.f1103t = (FrameLayout) findViewById(C1368R.C1370id.native_ad_view_container);
        if (this.f1084a.mo10084q()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader("test_mode_native", this.f1085b.mo10944Y(), this);
            this.f1092i = maxNativeAdLoader;
            maxNativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                public void onNativeAdClicked(MaxAd maxAd) {
                    C0943a.this.onAdClicked(maxAd);
                }

                public void onNativeAdLoadFailed(String str, MaxError maxError) {
                    C0943a.this.onAdLoadFailed(str, maxError);
                }

                public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                    if (C0943a.this.f1091h != null) {
                        C0943a.this.f1092i.destroy(C0943a.this.f1091h);
                    }
                    MaxAd unused = C0943a.this.f1091h = maxAd;
                    C0943a.this.f1103t.removeAllViews();
                    C0943a.this.f1103t.addView(maxNativeAdView);
                    C0943a.this.onAdLoaded(maxAd);
                }
            });
            this.f1092i.setRevenueListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(C1368R.C1370id.native_control_button);
            this.f1099p = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f1099p.setFormat(MaxAdFormat.NATIVE);
            return;
        }
        findViewById(C1368R.C1370id.native_control_view).setVisibility(8);
        this.f1103t.setVisibility(8);
    }

    public void initialize(C0883b bVar) {
        this.f1084a = bVar;
        this.f1085b = bVar.mo10090v();
    }

    public void onAdClicked(MaxAd maxAd) {
        Utils.showToast("onAdClicked", maxAd, this);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        Utils.showToast("onAdCollapsed", maxAd, this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        AdControlButton a = m1233a(maxAd.getAdUnitId());
        a.setControlState(AdControlButton.C0942b.LOAD);
        Utils.showAlert("", "Failed to display " + a.getFormat().getDisplayName() + " with error code: " + maxError.getCode(), this);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        Utils.showToast("onAdDisplayed", maxAd, this);
    }

    public void onAdExpanded(MaxAd maxAd) {
        Utils.showToast("onAdExpanded", maxAd, this);
    }

    public void onAdHidden(MaxAd maxAd) {
        Utils.showToast("onAdHidden", maxAd, this);
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        AdControlButton a = m1233a(str);
        a.setControlState(AdControlButton.C0942b.LOAD);
        Utils.showAlert("", "Failed to load " + a.getFormat().getLabel() + " with error code: " + maxError.getCode(), this);
    }

    public void onAdLoaded(MaxAd maxAd) {
        m1233a(maxAd.getAdUnitId()).setControlState((maxAd.getFormat().isAdViewAd() || maxAd.getFormat().equals(MaxAdFormat.NATIVE)) ? AdControlButton.C0942b.LOAD : AdControlButton.C0942b.SHOW);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        Utils.showToast("onAdRevenuePaid", maxAd, this);
    }

    public void onClick(AdControlButton adControlButton) {
        if (AdControlButton.C0942b.LOAD == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.C0942b.LOADING);
            m1236a(adControlButton.getFormat());
        } else if (AdControlButton.C0942b.SHOW == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.C0942b.LOAD);
            m1239b(adControlButton.getFormat());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f1084a == null) {
            C1314v.m2663i("MaxDebuggerMultiAdActivity", "Failed to initialize activity with a network model.");
            return;
        }
        setContentView(C1368R.layout.mediation_debugger_multi_ad_activity);
        setTitle(this.f1084a.mo10076i() + " Test Ads");
        m1235a();
        m1238b();
        m1241c();
        m1243d();
        m1245e();
        findViewById(C1368R.C1370id.rewarded_interstitial_control_view).setVisibility(8);
        this.f1100q = (Button) findViewById(C1368R.C1370id.show_mrec_button);
        this.f1101r = (Button) findViewById(C1368R.C1370id.show_native_button);
        if (!this.f1084a.mo10084q() || !this.f1084a.mo10083p().contains(MaxAdFormat.MREC)) {
            this.f1100q.setVisibility(8);
            this.f1101r.setVisibility(8);
        } else {
            this.f1103t.setVisibility(8);
            this.f1100q.setBackgroundColor(-1);
            this.f1101r.setBackgroundColor(-3355444);
            this.f1100q.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C0943a.this.f1102s.setVisibility(0);
                    C0943a.this.f1103t.setVisibility(8);
                    C0943a.this.f1100q.setBackgroundColor(-1);
                    C0943a.this.f1101r.setBackgroundColor(-3355444);
                }
            });
            this.f1101r.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C0943a.this.f1103t.setVisibility(0);
                    C0943a.this.f1102s.setVisibility(8);
                    C0943a.this.f1101r.setBackgroundColor(-1);
                    C0943a.this.f1100q.setBackgroundColor(-3355444);
                }
            });
        }
        try {
            setRequestedOrientation(7);
        } catch (Throwable th) {
            C1314v.m2659c(AppLovinSdk.TAG, "Failed to set portrait orientation", th);
        }
    }

    public void onDestroy() {
        MaxAd maxAd;
        super.onDestroy();
        this.f1085b.mo10930J().mo10218a((String) null);
        MaxAdView maxAdView = this.f1086c;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.f1087d;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f1088e;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f1090g;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.f1092i;
        if (maxNativeAdLoader != null && (maxAd = this.f1091h) != null) {
            maxNativeAdLoader.destroy(maxAd);
        }
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoCompleted", maxAd, this);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoStarted", maxAd, this);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        Utils.showToast("onUserRewarded", maxAd, this);
    }
}
