package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p010a.C0803c;
import com.applovin.impl.mediation.p010a.C0806f;
import com.applovin.impl.mediation.p010a.C0809h;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdViewAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.unity3d.services.ads.gmascar.bridges.MobileAdsBridge;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.g */
public class C0951g {

    /* renamed from: a */
    public final Handler f1130a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    public final C1188m f1131b;

    /* renamed from: c */
    public final C1314v f1132c;

    /* renamed from: d */
    public final String f1133d;

    /* renamed from: e */
    public final C0806f f1134e;

    /* renamed from: f */
    public final String f1135f;

    /* renamed from: g */
    public MaxAdapter f1136g;

    /* renamed from: h */
    public String f1137h;

    /* renamed from: i */
    public C0801a f1138i;

    /* renamed from: j */
    public View f1139j;

    /* renamed from: k */
    public MaxNativeAd f1140k;

    /* renamed from: l */
    public MaxNativeAdView f1141l;

    /* renamed from: m */
    public final C0971a f1142m = new C0971a();

    /* renamed from: n */
    public MaxAdapterResponseParameters f1143n;

    /* renamed from: o */
    public final AtomicBoolean f1144o = new AtomicBoolean(true);

    /* renamed from: p */
    public final AtomicBoolean f1145p = new AtomicBoolean(false);

    /* renamed from: q */
    public final AtomicBoolean f1146q = new AtomicBoolean(false);

    /* renamed from: com.applovin.impl.mediation.g$a */
    public class C0971a implements MaxAdViewAdapterListener, MaxInterstitialAdapterListener, MaxNativeAdAdapterListener, MaxRewardedAdapterListener, MaxRewardedInterstitialAdapterListener {

        /* renamed from: b */
        public MediationServiceImpl.C0797a f1204b;

        public C0971a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1317a(MediationServiceImpl.C0797a aVar) {
            if (aVar != null) {
                this.f1204b = aVar;
                return;
            }
            throw new IllegalArgumentException("No listener specified");
        }

        /* renamed from: a */
        private void m1320a(String str, @Nullable final Bundle bundle) {
            C0951g.this.f1146q.set(true);
            m1321a(str, (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    if (C0951g.this.f1145p.compareAndSet(false, true)) {
                        C0971a.this.f1204b.mo9806a(C0951g.this.f1138i, bundle);
                    }
                }
            });
        }

        /* renamed from: a */
        private void m1321a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            C0951g.this.f1130a.post(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        MaxAdListener maxAdListener = maxAdListener;
                        C1314v.m2659c("MediationAdapterWrapper", GeneratedOutlineSupport.outline19(GeneratedOutlineSupport.outline24("Failed to forward call ("), str, ") to ", maxAdListener != null ? maxAdListener.getClass().getName() : null), e);
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1322a(String str, final MaxError maxError) {
            m1321a(str, (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    if (C0951g.this.f1145p.compareAndSet(false, true)) {
                        C0971a.this.f1204b.onAdLoadFailed(C0951g.this.f1137h, maxError);
                    }
                }
            });
        }

        /* renamed from: b */
        private void m1324b(String str, @Nullable final Bundle bundle) {
            if (C0951g.this.f1138i.mo9856t().compareAndSet(false, true)) {
                m1321a(str, (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                    public void run() {
                        C0971a.this.f1204b.mo9807b(C0951g.this.f1138i, bundle);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m1325b(String str, final MaxError maxError) {
            m1321a(str, (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdDisplayFailed(C0951g.this.f1138i, maxError);
                }
            });
        }

        public void onAdViewAdClicked() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": adview ad clicked");
            m1321a("onAdViewAdClicked", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdClicked(C0951g.this.f1138i);
                }
            });
        }

        public void onAdViewAdCollapsed() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": adview ad collapsed");
            m1321a("onAdViewAdCollapsed", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdCollapsed(C0951g.this.f1138i);
                }
            });
        }

        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1314v c = C0951g.this.f1132c;
            c.mo11375d("MediationAdapterWrapper", C0951g.this.f1135f + ": adview ad failed to display with error: " + maxAdapterError);
            m1325b("onAdViewAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed((Bundle) null);
        }

        public void onAdViewAdDisplayed(@Nullable Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": adview ad displayed with extra info: " + bundle);
            m1324b("onAdViewAdDisplayed", bundle);
        }

        public void onAdViewAdExpanded() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": adview ad expanded");
            m1321a("onAdViewAdExpanded", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdExpanded(C0951g.this.f1138i);
                }
            });
        }

        public void onAdViewAdHidden() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": adview ad hidden");
            m1321a("onAdViewAdHidden", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdHidden(C0951g.this.f1138i);
                }
            });
        }

        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1314v c = C0951g.this.f1132c;
            c.mo11375d("MediationAdapterWrapper", C0951g.this.f1135f + ": adview ad ad failed to load with error: " + maxAdapterError);
            m1322a("onAdViewAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, (Bundle) null);
        }

        public void onAdViewAdLoaded(View view, @Nullable Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": adview ad loaded with extra info: " + bundle);
            View unused = C0951g.this.f1139j = view;
            m1320a("onAdViewAdLoaded", bundle);
        }

        public void onInterstitialAdClicked() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": interstitial ad clicked");
            m1321a("onInterstitialAdClicked", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdClicked(C0951g.this.f1138i);
                }
            });
        }

        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1314v c = C0951g.this.f1132c;
            c.mo11375d("MediationAdapterWrapper", C0951g.this.f1135f + ": interstitial ad failed to display with error " + maxAdapterError);
            m1325b("onInterstitialAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed((Bundle) null);
        }

        public void onInterstitialAdDisplayed(@Nullable Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": interstitial ad displayed with extra info: " + bundle);
            m1324b("onInterstitialAdDisplayed", bundle);
        }

        public void onInterstitialAdHidden() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": interstitial ad hidden");
            m1321a("onInterstitialAdHidden", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdHidden(C0951g.this.f1138i);
                }
            });
        }

        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1314v c = C0951g.this.f1132c;
            c.mo11375d("MediationAdapterWrapper", C0951g.this.f1135f + ": interstitial ad failed to load with error " + maxAdapterError);
            m1322a("onInterstitialAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded((Bundle) null);
        }

        public void onInterstitialAdLoaded(@Nullable Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": interstitial ad loaded with extra info: " + bundle);
            m1320a("onInterstitialAdLoaded", bundle);
        }

        public void onNativeAdClicked() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": native ad clicked");
            m1321a("onNativeAdClicked", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdClicked(C0951g.this.f1138i);
                }
            });
        }

        public void onNativeAdDisplayed(Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": native ad displayed with extra info: " + bundle);
            m1324b("onNativeAdDisplayed", bundle);
        }

        public void onNativeAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1314v c = C0951g.this.f1132c;
            c.mo11375d("MediationAdapterWrapper", C0951g.this.f1135f + ": native ad ad failed to load with error: " + maxAdapterError);
            m1322a("onNativeAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onNativeAdLoaded(MaxNativeAd maxNativeAd, Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": native ad loaded with extra info: " + bundle);
            MaxNativeAd unused = C0951g.this.f1140k = maxNativeAd;
            m1320a("onNativeAdLoaded", bundle);
        }

        public void onRewardedAdClicked() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded ad clicked");
            m1321a("onRewardedAdClicked", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdClicked(C0951g.this.f1138i);
                }
            });
        }

        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1314v c = C0951g.this.f1132c;
            c.mo11375d("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded ad display failed with error: " + maxAdapterError);
            m1325b("onRewardedAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed((Bundle) null);
        }

        public void onRewardedAdDisplayed(@Nullable Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded ad displayed with extra info: " + bundle);
            m1324b("onRewardedAdDisplayed", bundle);
        }

        public void onRewardedAdHidden() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded ad hidden");
            m1321a("onRewardedAdHidden", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdHidden(C0951g.this.f1138i);
                }
            });
        }

        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1314v c = C0951g.this.f1132c;
            c.mo11375d("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded ad failed to load with error: " + maxAdapterError);
            m1322a("onRewardedAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedAdLoaded() {
            onRewardedAdLoaded((Bundle) null);
        }

        public void onRewardedAdLoaded(@Nullable Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded ad loaded with extra info: " + bundle);
            m1320a("onRewardedAdLoaded", bundle);
        }

        public void onRewardedAdVideoCompleted() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded video completed");
            m1321a("onRewardedAdVideoCompleted", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onRewardedVideoCompleted(C0951g.this.f1138i);
                }
            });
        }

        public void onRewardedAdVideoStarted() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded video started");
            m1321a("onRewardedAdVideoStarted", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onRewardedVideoStarted(C0951g.this.f1138i);
                }
            });
        }

        public void onRewardedInterstitialAdClicked() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded interstitial ad clicked");
            m1321a("onRewardedInterstitialAdClicked", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdClicked(C0951g.this.f1138i);
                }
            });
        }

        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1314v c = C0951g.this.f1132c;
            c.mo11375d("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded interstitial ad display failed with error: " + maxAdapterError);
            m1325b("onRewardedInterstitialAdDisplayFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedInterstitialAdDisplayed() {
            onRewardedInterstitialAdDisplayed((Bundle) null);
        }

        public void onRewardedInterstitialAdDisplayed(@Nullable Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded interstitial ad displayed with extra info: " + bundle);
            m1324b("onRewardedInterstitialAdDisplayed", bundle);
        }

        public void onRewardedInterstitialAdHidden() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded interstitial ad hidden");
            m1321a("onRewardedInterstitialAdHidden", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onAdHidden(C0951g.this.f1138i);
                }
            });
        }

        public void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1314v c = C0951g.this.f1132c;
            c.mo11375d("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded ad failed to load with error: " + maxAdapterError);
            m1322a("onRewardedInterstitialAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedInterstitialAdLoaded() {
            onRewardedInterstitialAdLoaded((Bundle) null);
        }

        public void onRewardedInterstitialAdLoaded(@Nullable Bundle bundle) {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded interstitial ad loaded with extra info: " + bundle);
            m1320a("onRewardedInterstitialAdLoaded", bundle);
        }

        public void onRewardedInterstitialAdVideoCompleted() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded interstitial completed");
            m1321a("onRewardedInterstitialAdVideoCompleted", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onRewardedVideoCompleted(C0951g.this.f1138i);
                }
            });
        }

        public void onRewardedInterstitialAdVideoStarted() {
            C1314v c = C0951g.this.f1132c;
            c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": rewarded interstitial started");
            m1321a("onRewardedInterstitialAdVideoStarted", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                public void run() {
                    C0971a.this.f1204b.onRewardedVideoStarted(C0951g.this.f1138i);
                }
            });
        }

        public void onUserRewarded(final MaxReward maxReward) {
            if (C0951g.this.f1138i instanceof C0803c) {
                final C0803c cVar = (C0803c) C0951g.this.f1138i;
                if (cVar.mo9878L().compareAndSet(false, true)) {
                    C1314v c = C0951g.this.f1132c;
                    c.mo11374c("MediationAdapterWrapper", C0951g.this.f1135f + ": user was rewarded: " + maxReward);
                    m1321a("onUserRewarded", (MaxAdListener) this.f1204b, (Runnable) new Runnable() {
                        public void run() {
                            C0971a.this.f1204b.onUserRewarded(cVar, maxReward);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.g$b */
    public static class C0993b {

        /* renamed from: a */
        public final C0809h f1235a;

        /* renamed from: b */
        public final MaxSignalCollectionListener f1236b;

        /* renamed from: c */
        public final AtomicBoolean f1237c = new AtomicBoolean();

        public C0993b(C0809h hVar, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.f1235a = hVar;
            this.f1236b = maxSignalCollectionListener;
        }
    }

    /* renamed from: com.applovin.impl.mediation.g$c */
    public class C0994c extends C1109a {
        public C0994c() {
            super("TaskTimeoutMediatedAd", C0951g.this.f1131b);
        }

        /* renamed from: a */
        private void m1329a(C0801a aVar) {
            if (aVar != null) {
                this.f1961b.mo10928H().mo10346a(aVar);
            }
        }

        public void run() {
            if (C0951g.this.f1145p.get()) {
                return;
            }
            if (C0951g.this.f1138i.mo9848l()) {
                mo10768a(C0951g.this.f1135f + " is timing out, considering JS Tag ad loaded: " + C0951g.this.f1138i);
                m1329a(C0951g.this.f1138i);
                return;
            }
            mo10773d(C0951g.this.f1135f + " is timing out " + C0951g.this.f1138i + "...");
            m1329a(C0951g.this.f1138i);
            C0951g.this.f1142m.m1322a(mo10774e(), (MaxError) new MaxErrorImpl(-5101, "Adapter timed out"));
        }
    }

    /* renamed from: com.applovin.impl.mediation.g$d */
    public class C0995d extends C1109a {

        /* renamed from: c */
        public final C0993b f1240c;

        public C0995d(C0993b bVar) {
            super("TaskTimeoutSignalCollection", C0951g.this.f1131b);
            this.f1240c = bVar;
        }

        public void run() {
            if (!this.f1240c.f1237c.get()) {
                mo10773d(C0951g.this.f1135f + " is timing out " + this.f1240c.f1235a + "...");
                C0951g gVar = C0951g.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("The adapter (");
                outline24.append(C0951g.this.f1135f);
                outline24.append(") timed out");
                gVar.m1286b(outline24.toString(), this.f1240c);
            }
        }
    }

    public C0951g(C0806f fVar, MaxAdapter maxAdapter, C1188m mVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        } else if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        } else if (mVar != null) {
            this.f1133d = fVar.mo9898P();
            this.f1136g = maxAdapter;
            this.f1131b = mVar;
            this.f1132c = mVar.mo10922B();
            this.f1134e = fVar;
            this.f1135f = maxAdapter.getClass().getSimpleName();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    private void m1280a(final Runnable runnable, final C0801a aVar) {
        m1283a("show_ad", (Runnable) new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to start displaying ad");
                    outline24.append(aVar);
                    outline24.append(" : ");
                    outline24.append(th);
                    String sb = outline24.toString();
                    C1314v.m2663i("MediationAdapterWrapper", sb);
                    C0951g.this.f1142m.m1325b("show_ad", (MaxError) new MaxErrorImpl(MaxAdapterError.ERROR_CODE_UNSPECIFIED, sb));
                    C0951g.this.m1281a("show_ad");
                    C0951g.this.f1131b.mo10923C().mo10237a(C0951g.this.f1134e.mo9897O(), "show_ad", C0951g.this.f1138i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1281a(String str) {
        this.f1132c.mo11374c("MediationAdapterWrapper", GeneratedOutlineSupport.outline19(GeneratedOutlineSupport.outline24("Marking "), this.f1135f, " as disabled due to: ", str));
        this.f1144o.set(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1282a(String str, C0993b bVar) {
        if (bVar.f1237c.compareAndSet(false, true) && bVar.f1236b != null) {
            bVar.f1236b.onSignalCollected(str);
        }
    }

    /* renamed from: a */
    private void m1283a(final String str, final Runnable runnable) {
        C09698 r0 = new Runnable() {
            public void run() {
                try {
                    C1314v c = C0951g.this.f1132c;
                    c.mo11372b("MediationAdapterWrapper", C0951g.this.f1135f + ": running " + str + "...");
                    runnable.run();
                    C1314v c2 = C0951g.this.f1132c;
                    c2.mo11372b("MediationAdapterWrapper", C0951g.this.f1135f + ": finished " + str + "");
                } catch (Throwable th) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to run adapter operation ");
                    outline24.append(str);
                    outline24.append(", marking ");
                    outline24.append(C0951g.this.f1135f);
                    outline24.append(" as disabled");
                    C1314v.m2659c("MediationAdapterWrapper", outline24.toString(), th);
                    C0951g gVar = C0951g.this;
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("fail_");
                    outline242.append(str);
                    gVar.m1281a(outline242.toString());
                    if (!str.equals("destroy")) {
                        C0951g.this.f1131b.mo10923C().mo10237a(C0951g.this.f1134e.mo9897O(), str, C0951g.this.f1138i);
                    }
                }
            }
        };
        if (this.f1134e.mo9904V()) {
            this.f1130a.post(r0);
        } else {
            r0.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1286b(String str, C0993b bVar) {
        if (bVar.f1237c.compareAndSet(false, true) && bVar.f1236b != null) {
            bVar.f1236b.onSignalCollectionFailed(str);
        }
    }

    /* renamed from: b */
    private boolean m1287b(C0801a aVar, Activity activity) {
        MaxErrorImpl maxErrorImpl;
        if (aVar != null) {
            if (aVar.mo9834g() == null) {
                C1314v.m2663i("MediationAdapterWrapper", "Adapter has been garbage collected");
                maxErrorImpl = new MaxErrorImpl(-1, "Adapter has been garbage collected");
            } else if (aVar.mo9834g() != this) {
                throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
            } else if (activity == null) {
                throw new IllegalArgumentException("No activity specified");
            } else if (!this.f1144o.get()) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Mediation adapter '");
                outline24.append(this.f1135f);
                outline24.append("' is disabled. Showing ads with this adapter is disabled.");
                String sb = outline24.toString();
                C1314v.m2663i("MediationAdapterWrapper", sb);
                maxErrorImpl = new MaxErrorImpl(-1, sb);
            } else if (mo10257g()) {
                return true;
            } else {
                throw new IllegalStateException(GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24("Mediation adapter '"), this.f1135f, "' does not have an ad loaded. Please load an ad first"));
            }
            this.f1142m.m1325b("ad_show", (MaxError) maxErrorImpl);
            return false;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    /* renamed from: a */
    public View mo10244a() {
        return this.f1139j;
    }

    /* renamed from: a */
    public void mo10245a(C0801a aVar, final Activity activity) {
        Runnable runnable;
        if (m1287b(aVar, activity)) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdapter) C0951g.this.f1136g).showInterstitialAd(C0951g.this.f1143n, activity, C0951g.this.f1142m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdapter) C0951g.this.f1136g).showRewardedAd(C0951g.this.f1143n, activity, C0951g.this.f1142m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedInterstitialAdapter) C0951g.this.f1136g).showRewardedInterstitialAd(C0951g.this.f1143n, activity, C0951g.this.f1142m);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            m1280a(runnable, aVar);
        }
    }

    /* renamed from: a */
    public void mo10246a(C0801a aVar, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity) {
        Runnable runnable;
        if (m1287b(aVar, activity)) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdViewAdapter) C0951g.this.f1136g).showInterstitialAd(C0951g.this.f1143n, viewGroup, lifecycle, activity, C0951g.this.f1142m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdViewAdapter) C0951g.this.f1136g).showRewardedAd(C0951g.this.f1143n, viewGroup, lifecycle, activity, C0951g.this.f1142m);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            m1280a(runnable, aVar);
        }
    }

    /* renamed from: a */
    public void mo10247a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity, @Nullable final Runnable runnable) {
        m1283a(MobileAdsBridge.initializeMethodName, (Runnable) new Runnable() {
            public void run() {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                C1314v c = C0951g.this.f1132c;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Initializing ");
                outline24.append(C0951g.this.f1135f);
                outline24.append(" on thread: ");
                outline24.append(Thread.currentThread());
                outline24.append(" with 'run_on_ui_thread' value: ");
                outline24.append(C0951g.this.f1134e.mo9904V());
                c.mo11372b("MediationAdapterWrapper", outline24.toString());
                C0951g.this.f1136g.initialize(maxAdapterInitializationParameters, activity, new MaxAdapter.OnCompletionListener() {
                    public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                            public void run() {
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                C09531 r2 = C09531.this;
                                C0951g.this.f1131b.mo10924D().mo10227a(C0951g.this.f1134e, elapsedRealtime - elapsedRealtime, initializationStatus, str);
                                Runnable runnable = runnable;
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        }, C0951g.this.f1134e.mo9908Z());
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public void mo10248a(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, C0809h hVar, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (!this.f1144o.get()) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Mediation adapter '");
            outline24.append(this.f1135f);
            outline24.append("' is disabled. Signal collection ads with this adapter is disabled.");
            C1314v.m2663i("MediationAdapterWrapper", outline24.toString());
            maxSignalCollectionListener.onSignalCollectionFailed("The adapter (" + this.f1135f + ") is disabled");
        } else {
            final C0993b bVar = new C0993b(hVar, maxSignalCollectionListener);
            MaxAdapter maxAdapter = this.f1136g;
            if (maxAdapter instanceof MaxSignalProvider) {
                final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
                final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters2 = maxAdapterSignalCollectionParameters;
                final Activity activity2 = activity;
                final C0809h hVar2 = hVar;
                m1283a("collect_signal", (Runnable) new Runnable() {
                    public void run() {
                        try {
                            maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters2, activity2, new MaxSignalCollectionListener() {
                                public void onSignalCollected(String str) {
                                    C09666 r0 = C09666.this;
                                    C0951g.this.m1282a(str, bVar);
                                }

                                public void onSignalCollectionFailed(String str) {
                                    C09666 r0 = C09666.this;
                                    C0951g.this.m1286b(str, bVar);
                                }
                            });
                        } catch (Throwable th) {
                            C0951g gVar = C0951g.this;
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed signal collection for ");
                            outline24.append(C0951g.this.f1133d);
                            outline24.append(" due to exception: ");
                            outline24.append(th);
                            gVar.m1286b(outline24.toString(), bVar);
                            C0951g.this.m1281a("collect_signal");
                            C0951g.this.f1131b.mo10923C().mo10237a(C0951g.this.f1134e.mo9897O(), "collect_signal", C0951g.this.f1138i);
                        }
                        if (bVar.f1237c.get()) {
                            return;
                        }
                        if (hVar2.mo9907Y() == 0) {
                            C1314v c = C0951g.this.f1132c;
                            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Failing signal collection ");
                            outline242.append(hVar2);
                            outline242.append(" since it has 0 timeout");
                            c.mo11372b("MediationAdapterWrapper", outline242.toString());
                            C0951g gVar2 = C0951g.this;
                            StringBuilder outline243 = GeneratedOutlineSupport.outline24("The adapter (");
                            outline243.append(C0951g.this.f1135f);
                            outline243.append(") has 0 timeout");
                            gVar2.m1286b(outline243.toString(), bVar);
                            return;
                        }
                        int i = (hVar2.mo9907Y() > 0 ? 1 : (hVar2.mo9907Y() == 0 ? 0 : -1));
                        C1314v c2 = C0951g.this.f1132c;
                        StringBuilder sb = new StringBuilder();
                        if (i > 0) {
                            sb.append("Setting timeout ");
                            sb.append(hVar2.mo9907Y());
                            sb.append("ms. for ");
                            sb.append(hVar2);
                            c2.mo11372b("MediationAdapterWrapper", sb.toString());
                            C0951g.this.f1131b.mo10938S().mo10830a(new C0995d(bVar), C1140o.C1142a.MEDIATION_TIMEOUT, hVar2.mo9907Y());
                            return;
                        }
                        sb.append("Negative timeout set for ");
                        sb.append(hVar2);
                        sb.append(", not scheduling a timeout");
                        c2.mo11372b("MediationAdapterWrapper", sb.toString());
                    }
                });
                return;
            }
            m1286b(GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24("The adapter ("), this.f1135f, ") does not support signal collection"), bVar);
        }
    }

    /* renamed from: a */
    public void mo10249a(MaxNativeAdView maxNativeAdView) {
        this.f1141l = maxNativeAdView;
    }

    /* renamed from: a */
    public void mo10250a(String str, C0801a aVar) {
        this.f1137h = str;
        this.f1138i = aVar;
    }

    /* renamed from: a */
    public void mo10251a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final C0801a aVar, final Activity activity, MediationServiceImpl.C0797a aVar2) {
        final Runnable runnable;
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!this.f1144o.get()) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Mediation adapter '");
            outline24.append(this.f1135f);
            outline24.append("' was disabled due to earlier failures. Loading ads with this adapter is disabled.");
            String sb = outline24.toString();
            C1314v.m2663i("MediationAdapterWrapper", sb);
            aVar2.onAdLoadFailed(str, new MaxErrorImpl(-1, sb));
        } else {
            this.f1143n = maxAdapterResponseParameters;
            this.f1142m.m1317a(aVar2);
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxInterstitialAdapter) C0951g.this.f1136g).loadInterstitialAd(maxAdapterResponseParameters, activity, C0951g.this.f1142m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdapter) C0951g.this.f1136g).loadRewardedAd(maxAdapterResponseParameters, activity, C0951g.this.f1142m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedInterstitialAdapter) C0951g.this.f1136g).loadRewardedInterstitialAd(maxAdapterResponseParameters, activity, C0951g.this.f1142m);
                    }
                };
            } else if (aVar.getFormat() == MaxAdFormat.NATIVE) {
                runnable = new Runnable() {
                    public void run() {
                        ((MediationAdapterBase) C0951g.this.f1136g).loadNativeAd(maxAdapterResponseParameters, activity, C0951g.this.f1142m);
                    }
                };
            } else if (aVar.getFormat().isAdViewAd()) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxAdViewAdapter) C0951g.this.f1136g).loadAdViewAd(maxAdapterResponseParameters, aVar.getFormat(), activity, C0951g.this.f1142m);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to load " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            m1283a("load_ad", (Runnable) new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed start loading ");
                        outline24.append(aVar);
                        outline24.append(" : ");
                        outline24.append(th);
                        String sb = outline24.toString();
                        C1314v.m2663i("MediationAdapterWrapper", sb);
                        C0951g.this.f1142m.m1322a("load_ad", (MaxError) new MaxErrorImpl(-1, sb));
                        C0951g.this.m1281a("load_ad");
                        C0951g.this.f1131b.mo10923C().mo10237a(C0951g.this.f1134e.mo9897O(), "load_ad", C0951g.this.f1138i);
                    }
                    if (!C0951g.this.f1145p.get()) {
                        long Y = C0951g.this.f1134e.mo9907Y();
                        if (Y > 0) {
                            C1314v c = C0951g.this.f1132c;
                            c.mo11372b("MediationAdapterWrapper", "Setting timeout " + Y + "ms. for " + aVar);
                            C0951g.this.f1131b.mo10938S().mo10830a(new C0994c(), C1140o.C1142a.MEDIATION_TIMEOUT, Y);
                            return;
                        }
                        C1314v c2 = C0951g.this.f1132c;
                        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Negative timeout set for ");
                        outline242.append(aVar);
                        outline242.append(", not scheduling a timeout");
                        c2.mo11372b("MediationAdapterWrapper", outline242.toString());
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public MaxNativeAd mo10252b() {
        return this.f1140k;
    }

    @Nullable
    /* renamed from: c */
    public MaxNativeAdView mo10253c() {
        return this.f1141l;
    }

    /* renamed from: d */
    public String mo10254d() {
        return this.f1133d;
    }

    /* renamed from: e */
    public MediationServiceImpl.C0797a mo10255e() {
        return this.f1142m.f1204b;
    }

    /* renamed from: f */
    public boolean mo10256f() {
        return this.f1144o.get();
    }

    /* renamed from: g */
    public boolean mo10257g() {
        return this.f1145p.get() && this.f1146q.get();
    }

    /* renamed from: h */
    public String mo10258h() {
        MaxAdapter maxAdapter = this.f1136g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th) {
            C1314v.m2659c("MediationAdapterWrapper", "Unable to get adapter's SDK version, marking " + this + " as disabled", th);
            m1281a(FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION);
            this.f1131b.mo10923C().mo10237a(this.f1134e.mo9897O(), FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, this.f1138i);
            return null;
        }
    }

    /* renamed from: i */
    public String mo10259i() {
        MaxAdapter maxAdapter = this.f1136g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th) {
            C1314v.m2659c("MediationAdapterWrapper", "Unable to get adapter version, marking " + this + " as disabled", th);
            m1281a("adapter_version");
            this.f1131b.mo10923C().mo10237a(this.f1134e.mo9897O(), "adapter_version", this.f1138i);
            return null;
        }
    }

    /* renamed from: j */
    public void mo10260j() {
        m1283a("destroy", (Runnable) new Runnable() {
            public void run() {
                C0951g.this.m1281a("destroy");
                C0951g.this.f1136g.onDestroy();
                MaxAdapter unused = C0951g.this.f1136g = null;
                View unused2 = C0951g.this.f1139j = null;
                MaxNativeAd unused3 = C0951g.this.f1140k = null;
                MaxNativeAdView unused4 = C0951g.this.f1141l = null;
            }
        });
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediationAdapterWrapper{adapterTag='");
        outline24.append(this.f1135f);
        outline24.append("'");
        outline24.append('}');
        return outline24.toString();
    }
}
