package com.applovin.impl.mediation.debugger.p017ui.p018a;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.debugger.p013a.p014a.C0878a;
import com.applovin.impl.mediation.debugger.p013a.p014a.C0879b;
import com.applovin.impl.mediation.debugger.p017ui.C0890a;
import com.applovin.impl.mediation.debugger.p017ui.p018a.C0899b;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0927a;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0929c;
import com.applovin.impl.mediation.debugger.p017ui.p022d.C0933d;
import com.applovin.impl.mediation.debugger.p017ui.testmode.AdControlButton;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
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
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1368R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.a */
public class C0893a extends C0890a implements AdControlButton.C0941a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    public C1188m f892a;

    /* renamed from: b */
    public C0878a f893b;

    /* renamed from: c */
    public C0899b f894c;
    @Nullable

    /* renamed from: d */
    public C0879b f895d;

    /* renamed from: e */
    public MaxAdView f896e;

    /* renamed from: f */
    public MaxInterstitialAd f897f;

    /* renamed from: g */
    public MaxRewardedInterstitialAd f898g;

    /* renamed from: h */
    public MaxRewardedAd f899h;

    /* renamed from: i */
    public MaxNativeAdView f900i;

    /* renamed from: j */
    public MaxNativeAdLoader f901j;

    /* renamed from: k */
    public C0906d f902k;

    /* renamed from: l */
    public ListView f903l;

    /* renamed from: m */
    public View f904m;

    /* renamed from: n */
    public AdControlButton f905n;

    /* renamed from: o */
    public TextView f906o;

    /* renamed from: a */
    private void m1060a() {
        String a = this.f893b.mo10045a();
        if (this.f893b.mo10049d().isAdViewAd()) {
            MaxAdView maxAdView = new MaxAdView(a, this.f893b.mo10049d(), this.f892a.mo10944Y(), this);
            this.f896e = maxAdView;
            maxAdView.setListener(this);
        } else if (MaxAdFormat.INTERSTITIAL == this.f893b.mo10049d()) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(a, this.f892a.mo10944Y(), this);
            this.f897f = maxInterstitialAd;
            maxInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f893b.mo10049d()) {
            MaxRewardedInterstitialAd maxRewardedInterstitialAd = new MaxRewardedInterstitialAd(a, this.f892a.mo10944Y(), this);
            this.f898g = maxRewardedInterstitialAd;
            maxRewardedInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED == this.f893b.mo10049d()) {
            MaxRewardedAd instance = MaxRewardedAd.getInstance(a, this.f892a.mo10944Y(), this);
            this.f899h = instance;
            instance.setListener(this);
        } else if (MaxAdFormat.NATIVE == this.f893b.mo10049d()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(a, this.f892a.mo10944Y(), this);
            this.f901j = maxNativeAdLoader;
            maxNativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                public void onNativeAdClicked(MaxAd maxAd) {
                    C0893a.this.onAdClicked(maxAd);
                }

                public void onNativeAdLoadFailed(String str, MaxError maxError) {
                    C0893a.this.onAdLoadFailed(str, maxError);
                }

                public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                    MaxNativeAdView unused = C0893a.this.f900i = maxNativeAdView;
                    C0893a.this.onAdLoaded(maxAd);
                }
            });
            this.f901j.setRevenueListener(this);
        }
    }

    /* renamed from: a */
    private void m1061a(final ViewGroup viewGroup, AppLovinSdkUtils.Size size, DialogInterface.OnShowListener onShowListener) {
        if (this.f902k == null) {
            C0906d dVar = new C0906d(viewGroup, size, this);
            this.f902k = dVar;
            dVar.setOnShowListener(onShowListener);
            this.f902k.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    ViewGroup viewGroup = viewGroup;
                    if (viewGroup instanceof MaxAdView) {
                        ((MaxAdView) viewGroup).stopAutoRefresh();
                    }
                    C0906d unused = C0893a.this.f902k = null;
                }
            });
            this.f902k.show();
        }
    }

    /* renamed from: a */
    private void m1063a(MaxAdFormat maxAdFormat) {
        if (this.f895d != null) {
            this.f892a.mo10930J().mo10218a(this.f895d.mo10053b());
            this.f892a.mo10930J().mo10220a(true);
        }
        if (maxAdFormat.isAdViewAd()) {
            this.f896e.loadAd();
        } else if (MaxAdFormat.INTERSTITIAL == this.f893b.mo10049d()) {
            this.f897f.loadAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f893b.mo10049d()) {
            this.f898g.loadAd();
        } else if (MaxAdFormat.REWARDED == this.f893b.mo10049d()) {
            this.f899h.loadAd();
        } else if (MaxAdFormat.NATIVE == this.f893b.mo10049d()) {
            this.f901j.loadAd();
        } else {
            Utils.showToast("Live ads currently unavailable for ad format", this);
        }
    }

    /* renamed from: b */
    private void m1064b(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            m1061a(this.f896e, maxAdFormat.getSize(), new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    C0893a.this.f896e.startAutoRefresh();
                }
            });
        } else if (MaxAdFormat.INTERSTITIAL == this.f893b.mo10049d()) {
            this.f897f.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f893b.mo10049d()) {
            this.f898g.showAd();
        } else if (MaxAdFormat.REWARDED == this.f893b.mo10049d()) {
            this.f899h.showAd();
        } else if (MaxAdFormat.NATIVE == this.f893b.mo10049d()) {
            m1061a(this.f900i, MaxAdFormat.MREC.getSize(), (DialogInterface.OnShowListener) null);
        }
    }

    public void initialize(final C0878a aVar, @Nullable C0879b bVar, final C1188m mVar) {
        this.f892a = mVar;
        this.f893b = aVar;
        this.f895d = bVar;
        C0899b bVar2 = new C0899b(aVar, bVar, this);
        this.f894c = bVar2;
        bVar2.mo10193a((C0933d.C0935a) new C0933d.C0935a() {
            /* renamed from: a */
            public void mo10111a(C0927a aVar, final C0929c cVar) {
                if (cVar instanceof C0899b.C0900a) {
                    C0893a.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, mVar.mo10967ae(), new C0890a.C0892a<MaxDebuggerAdUnitDetailActivity>() {
                        /* renamed from: a */
                        public void mo10108a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                            C0879b a = ((C0899b.C0900a) cVar).mo10123a();
                            C08941 r1 = C08941.this;
                            maxDebuggerAdUnitDetailActivity.initialize(aVar, a, mVar);
                        }
                    });
                }
            }
        });
        m1060a();
    }

    public void onAdClicked(MaxAd maxAd) {
        Utils.showToast("onAdClicked", maxAd, this);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        Utils.showToast("onAdCollapsed", maxAd, this);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        this.f905n.setControlState(AdControlButton.C0942b.LOAD);
        this.f906o.setText("");
        Utils.showAlert("", "Failed to display with error code: " + maxError.getCode(), this);
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
        this.f905n.setControlState(AdControlButton.C0942b.LOAD);
        this.f906o.setText("");
        if (204 == maxError.getCode()) {
            Utils.showAlert("No Fill", "No fills often happen in live environments. Please make sure to use the Mediation Debugger test mode before you go live.", this);
            return;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to load with error code: ");
        outline24.append(maxError.getCode());
        Utils.showAlert("", outline24.toString(), this);
    }

    public void onAdLoaded(MaxAd maxAd) {
        TextView textView = this.f906o;
        textView.setText(maxAd.getNetworkName() + " ad loaded");
        this.f905n.setControlState(AdControlButton.C0942b.SHOW);
        if (maxAd.getFormat().isAdViewAd()) {
            m1061a(this.f896e, maxAd.getFormat().getSize(), (DialogInterface.OnShowListener) null);
        } else if (MaxAdFormat.NATIVE == this.f893b.mo10049d()) {
            m1061a(this.f900i, MaxAdFormat.MREC.getSize(), (DialogInterface.OnShowListener) null);
        }
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        Utils.showToast("onAdRevenuePaid", maxAd, this);
    }

    public void onClick(AdControlButton adControlButton) {
        if (this.f892a.mo10930J().mo10221a()) {
            Utils.showAlert("Not Supported", "Ad loads are not supported while Test Mode is enabled. Please restart the app.", this);
        } else if (AdControlButton.C0942b.LOAD == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.C0942b.LOADING);
            m1063a(this.f893b.mo10049d());
        } else if (AdControlButton.C0942b.SHOW == adControlButton.getControlState()) {
            if (!this.f893b.mo10049d().isAdViewAd() && this.f893b.mo10049d() != MaxAdFormat.NATIVE) {
                adControlButton.setControlState(AdControlButton.C0942b.LOAD);
            }
            m1064b(this.f893b.mo10049d());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1368R.layout.mediation_debugger_ad_unit_detail_activity);
        setTitle(this.f894c.mo10119a());
        this.f903l = (ListView) findViewById(C1368R.C1370id.listView);
        this.f904m = findViewById(C1368R.C1370id.ad_presenter_view);
        this.f905n = (AdControlButton) findViewById(C1368R.C1370id.ad_control_button);
        this.f906o = (TextView) findViewById(C1368R.C1370id.status_textview);
        this.f903l.setAdapter(this.f894c);
        this.f906o.setText(this.f892a.mo10930J().mo10221a() ? "Not Supported while Test Mode is enabled" : "Tap to load an ad");
        this.f906o.setTypeface(Typeface.DEFAULT_BOLD);
        this.f905n.setOnClickListener(this);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 10, 0, 0);
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setShadowLayer((float) 10, 0.0f, (float) -10, 855638016);
        shapeDrawable.setShape(new RectShape());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        layerDrawable.setLayerInset(0, 0, 10, 0, 0);
        this.f904m.setBackground(layerDrawable);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f895d != null) {
            this.f892a.mo10930J().mo10218a((String) null);
            this.f892a.mo10930J().mo10220a(false);
        }
        MaxAdView maxAdView = this.f896e;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f897f;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f899h;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
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
