package com.applovin.impl.sdk.p026b;

import android.content.Context;
import android.view.ViewGroup;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.AppLovinAdImpl;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p025ad.C1063f;
import com.applovin.impl.sdk.p025ad.C1064g;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1110aa;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1159v;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b.a */
public class C1068a {

    /* renamed from: a */
    public final C1188m f1451a;

    /* renamed from: b */
    public final AppLovinAdServiceImpl f1452b;

    /* renamed from: c */
    public AppLovinAd f1453c;

    /* renamed from: d */
    public String f1454d;

    /* renamed from: e */
    public SoftReference<AppLovinAdLoadListener> f1455e;

    /* renamed from: f */
    public final Object f1456f = new Object();

    /* renamed from: g */
    public volatile String f1457g;

    /* renamed from: h */
    public volatile boolean f1458h = false;

    /* renamed from: com.applovin.impl.sdk.b.a$a */
    public class C1070a implements AppLovinAdLoadListener {

        /* renamed from: b */
        public final AppLovinAdLoadListener f1461b;

        public C1070a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f1461b = appLovinAdLoadListener;
        }

        public void adReceived(final AppLovinAd appLovinAd) {
            AppLovinAd unused = C1068a.this.f1453c = appLovinAd;
            if (this.f1461b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1070a.this.f1461b.adReceived(appLovinAd);
                        } catch (Throwable th) {
                            C1314v.m2659c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                        }
                    }
                });
            }
        }

        public void failedToReceiveAd(final int i) {
            if (this.f1461b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1070a.this.f1461b.failedToReceiveAd(i);
                        } catch (Throwable th) {
                            C1314v.m2659c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.b.a$b */
    public class C1073b implements C1064g, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {

        /* renamed from: b */
        public final AppLovinAdDisplayListener f1467b;

        /* renamed from: c */
        public final AppLovinAdClickListener f1468c;

        /* renamed from: d */
        public final AppLovinAdVideoPlaybackListener f1469d;

        /* renamed from: e */
        public final AppLovinAdRewardListener f1470e;

        public C1073b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.f1467b = appLovinAdDisplayListener;
            this.f1468c = appLovinAdClickListener;
            this.f1469d = appLovinAdVideoPlaybackListener;
            this.f1470e = appLovinAdRewardListener;
        }

        /* renamed from: a */
        private void m1624a(C1057e eVar) {
            String str;
            int i;
            String a = C1068a.this.m1616d();
            if (!StringUtils.isValidString(a) || !C1068a.this.f1458h) {
                C1314v B = C1068a.this.f1451a.mo10922B();
                StringBuilder outline27 = GeneratedOutlineSupport.outline27("Invalid reward state - result: ", a, " and wasFullyEngaged: ");
                outline27.append(C1068a.this.f1458h);
                B.mo11376e("IncentivizedAdController", outline27.toString());
                C1068a.this.f1451a.mo10922B().mo11372b("IncentivizedAdController", "Cancelling any incoming reward requests for this ad");
                eVar.mo10587aB();
                if (C1068a.this.f1458h) {
                    C1068a.this.f1451a.mo10922B().mo11376e("IncentivizedAdController", "User close the ad after fully watching but reward validation task did not return on time");
                    i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                    str = "network_timeout";
                } else {
                    C1068a.this.f1451a.mo10922B().mo11376e("IncentivizedAdController", "User close the ad prematurely");
                    i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                    str = "user_closed_video";
                }
                eVar.mo10584a(C1082c.m1637a(str));
                C1068a.this.f1451a.mo10922B().mo11372b("IncentivizedAdController", "Notifying listener of reward validation failure");
                C1267j.m2562a(this.f1470e, (AppLovinAd) eVar, i);
            }
            C1068a.this.m1606a((AppLovinAd) eVar);
            C1068a.this.f1451a.mo10922B().mo11372b("IncentivizedAdController", "Notifying listener of rewarded ad dismissal");
            C1267j.m2572b(this.f1467b, (AppLovinAd) eVar);
            if (!eVar.mo10596ab().getAndSet(true)) {
                C1068a.this.f1451a.mo10922B().mo11372b("IncentivizedAdController", "Scheduling report rewarded ad...");
                C1068a.this.f1451a.mo10938S().mo10829a((C1109a) new C1159v(eVar, C1068a.this.f1451a), C1140o.C1142a.REWARD);
            }
        }

        public void adClicked(AppLovinAd appLovinAd) {
            C1267j.m2559a(this.f1468c, appLovinAd);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            C1267j.m2560a(this.f1467b, appLovinAd);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (appLovinAd instanceof C1063f) {
                appLovinAd = ((C1063f) appLovinAd).mo10637a();
            }
            if (appLovinAd instanceof C1057e) {
                m1624a((C1057e) appLovinAd);
                return;
            }
            C1314v B = C1068a.this.f1451a.mo10922B();
            B.mo11376e("IncentivizedAdController", "Something is terribly wrong. Received `adHidden` callback for invalid ad of type: " + appLovinAd);
        }

        public void onAdDisplayFailed(String str) {
            C1267j.m2561a(this.f1467b, str);
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            C1068a.this.m1609a("quota_exceeded");
            C1267j.m2573b(this.f1470e, appLovinAd, map);
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            C1068a.this.m1609a("rejected");
            C1267j.m2577c(this.f1470e, appLovinAd, map);
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            C1068a.this.m1609a("accepted");
            C1267j.m2563a(this.f1470e, appLovinAd, map);
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            C1068a.this.m1609a("network_timeout");
            C1267j.m2562a(this.f1470e, appLovinAd, i);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            C1267j.m2564a(this.f1469d, appLovinAd);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            C1267j.m2565a(this.f1469d, appLovinAd, d, z);
            boolean unused = C1068a.this.f1458h = z;
        }
    }

    public C1068a(String str, AppLovinSdk appLovinSdk) {
        this.f1451a = appLovinSdk.coreSdk;
        this.f1452b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f1454d = str;
    }

    /* renamed from: a */
    private void m1601a(AppLovinAdImpl appLovinAdImpl, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdImpl.getType() == AppLovinAdType.INCENTIVIZED || appLovinAdImpl.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAdImpl, this.f1451a);
            if (maybeRetrieveNonDummyAd == null) {
                m1608a(appLovinAdImpl, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
                return;
            }
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f1451a.mo10944Y(), context);
            C1073b bVar = new C1073b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            create.setAdDisplayListener(bVar);
            create.setAdVideoPlaybackListener(bVar);
            create.setAdClickListener(bVar);
            create.showAndRender(maybeRetrieveNonDummyAd);
            if (maybeRetrieveNonDummyAd instanceof C1057e) {
                m1603a((C1057e) maybeRetrieveNonDummyAd, (AppLovinAdRewardListener) bVar);
                return;
            }
            return;
        }
        C1314v B = this.f1451a.mo10922B();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to render an ad of type ");
        outline24.append(appLovinAdImpl.getType());
        outline24.append(" in an Incentivized Ad interstitial.");
        B.mo11376e("IncentivizedAdController", outline24.toString());
        m1608a(appLovinAdImpl, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
    }

    /* renamed from: a */
    private void m1602a(AppLovinAdImpl appLovinAdImpl, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl2 = appLovinAdImpl;
        AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener2 = appLovinAdVideoPlaybackListener;
        AppLovinAdDisplayListener appLovinAdDisplayListener2 = appLovinAdDisplayListener;
        if (appLovinAdImpl.getType() == AppLovinAdType.INCENTIVIZED || appLovinAdImpl.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAdImpl, this.f1451a);
            if (maybeRetrieveNonDummyAd == null) {
                m1608a(appLovinAdImpl, appLovinAdVideoPlaybackListener2, appLovinAdDisplayListener2);
                return;
            }
            Context context2 = context;
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f1451a.mo10944Y(), context);
            C1073b bVar = new C1073b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            create.setAdDisplayListener(bVar);
            create.setAdVideoPlaybackListener(bVar);
            create.setAdClickListener(bVar);
            ViewGroup viewGroup2 = viewGroup;
            Lifecycle lifecycle2 = lifecycle;
            create.showAndRender(maybeRetrieveNonDummyAd, viewGroup, lifecycle);
            if (maybeRetrieveNonDummyAd instanceof C1057e) {
                m1603a((C1057e) maybeRetrieveNonDummyAd, (AppLovinAdRewardListener) bVar);
                return;
            }
            return;
        }
        C1314v B = this.f1451a.mo10922B();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to render an ad of type ");
        outline24.append(appLovinAdImpl.getType());
        outline24.append(" in an Incentivized Ad interstitial.");
        B.mo11376e("IncentivizedAdController", outline24.toString());
        m1608a(appLovinAdImpl, appLovinAdVideoPlaybackListener2, appLovinAdDisplayListener2);
    }

    /* renamed from: a */
    private void m1603a(C1057e eVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f1451a.mo10938S().mo10829a((C1109a) new C1110aa(eVar, appLovinAdRewardListener, this.f1451a), C1140o.C1142a.REWARD);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1606a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.f1453c;
        if (appLovinAd2 != null) {
            if (appLovinAd2 instanceof C1063f) {
                if (appLovinAd != ((C1063f) appLovinAd2).mo10637a()) {
                    return;
                }
            } else if (appLovinAd != appLovinAd2) {
                return;
            }
            this.f1453c = null;
        }
    }

    /* renamed from: a */
    private void m1607a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAd == null) {
            appLovinAd = this.f1453c;
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        if (appLovinAdImpl != null) {
            m1601a(appLovinAdImpl, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        C1314v.m2663i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        m1615c();
    }

    /* renamed from: a */
    private void m1608a(AppLovinAd appLovinAd, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f1451a.mo10939T().mo10757a(C1103f.f1932j);
        C1267j.m2565a(appLovinAdVideoPlaybackListener, appLovinAd, (double) RoundRectDrawableWithShadow.COS_45, false);
        C1267j.m2572b(appLovinAdDisplayListener, appLovinAd);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1609a(String str) {
        synchronized (this.f1456f) {
            this.f1457g = str;
        }
    }

    /* renamed from: b */
    private void m1612b(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.f1453c;
        }
        if (appLovinAdImpl != null) {
            m1602a(appLovinAdImpl, viewGroup, lifecycle, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        C1314v.m2663i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        m1615c();
    }

    /* renamed from: b */
    private void m1613b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1452b.loadNextIncentivizedAd(this.f1454d, appLovinAdLoadListener);
    }

    /* renamed from: c */
    private void m1615c() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference<AppLovinAdLoadListener> softReference = this.f1455e;
        if (softReference != null && (appLovinAdLoadListener = softReference.get()) != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m1616d() {
        String str;
        synchronized (this.f1456f) {
            str = this.f1457g;
        }
        return str;
    }

    /* renamed from: e */
    private AppLovinAdRewardListener m1617e() {
        return new AppLovinAdRewardListener() {
            public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
                C1314v B = C1068a.this.f1451a.mo10922B();
                B.mo11376e("IncentivizedAdController", "User over quota: " + map);
            }

            public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
                C1314v B = C1068a.this.f1451a.mo10922B();
                B.mo11376e("IncentivizedAdController", "Reward rejected: " + map);
            }

            public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
                C1314v B = C1068a.this.f1451a.mo10922B();
                B.mo11372b("IncentivizedAdController", "Reward validated: " + map);
            }

            public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                C1314v B = C1068a.this.f1451a.mo10922B();
                B.mo11376e("IncentivizedAdController", "Reward validation failed: " + i);
            }
        };
    }

    /* renamed from: a */
    public void mo10644a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = m1617e();
        }
        m1607a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    /* renamed from: a */
    public void mo10645a(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        m1612b(appLovinAd, viewGroup, lifecycle, context, appLovinAdRewardListener == null ? m1617e() : appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    /* renamed from: a */
    public void mo10646a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1451a.mo10922B().mo11372b("IncentivizedAdController", "User requested preload of incentivized ad...");
        this.f1455e = new SoftReference<>(appLovinAdLoadListener);
        if (mo10647a()) {
            C1314v.m2663i("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f1453c);
                return;
            }
            return;
        }
        m1613b((AppLovinAdLoadListener) new C1070a(appLovinAdLoadListener));
    }

    /* renamed from: a */
    public boolean mo10647a() {
        return this.f1453c != null;
    }

    /* renamed from: b */
    public String mo10648b() {
        return this.f1454d;
    }
}
