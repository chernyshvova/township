package com.applovin.impl.sdk.utils;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdEventListener;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.p025ad.AppLovinAdImpl;
import com.applovin.impl.sdk.p025ad.C1064g;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.j */
public class C1267j {
    /* renamed from: a */
    public static void m2542a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adOpenedFullscreen(C1267j.m2568b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2543a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView, final AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adFailedToDisplay(C1267j.m2568b(appLovinAd), appLovinAdView, appLovinAdViewDisplayErrorCode);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about display failed event", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2544a(final AppLovinNativeAdEventListener appLovinNativeAdEventListener, final AppLovinNativeAd appLovinNativeAd) {
        if (appLovinNativeAdEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinNativeAdEventListener.onNativeAdClicked(appLovinNativeAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad click", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2545a(final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, final int i) {
        if (appLovinNativeAdLoadListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinNativeAdLoadListener.onNativeAdLoadFailed(i);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad failing to load", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2546a(MaxAdListener maxAdListener, MaxAd maxAd) {
        m2551a(maxAdListener, maxAd, false);
    }

    /* renamed from: a */
    public static void m2547a(MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        m2548a(maxAdListener, maxAd, maxError, false);
    }

    /* renamed from: a */
    public static void m2548a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxError maxError, boolean z) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdDisplayFailed(maxAd, maxError);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to display", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2549a(MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        m2550a(maxAdListener, maxAd, maxReward, false);
    }

    /* renamed from: a */
    public static void m2550a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxReward maxReward, boolean z) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about user being rewarded", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2551a(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdLoaded(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being loaded", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2552a(MaxAdListener maxAdListener, String str, MaxError maxError) {
        m2553a(maxAdListener, str, maxError, false);
    }

    /* renamed from: a */
    public static void m2553a(final MaxAdListener maxAdListener, final String str, final MaxError maxError, boolean z) {
        if (str != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdLoadFailed(str, maxError);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to load", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2554a(MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        m2555a(maxAdRevenueListener, maxAd, false);
    }

    /* renamed from: a */
    public static void m2555a(final MaxAdRevenueListener maxAdRevenueListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && maxAdRevenueListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxAdRevenueListener.onAdRevenuePaid(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad revenue being paid", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2556a(final MaxNativeAdListener maxNativeAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxNativeAdListener.onNativeAdClicked(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about native ad being clicked", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2557a(final MaxNativeAdListener maxNativeAdListener, final MaxNativeAdView maxNativeAdView, final MaxAd maxAd, boolean z) {
        if (maxNativeAdView != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxNativeAdListener.onNativeAdLoaded(maxNativeAdView, maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about native ad being loaded", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2558a(final MaxNativeAdListener maxNativeAdListener, final String str, final MaxError maxError, boolean z) {
        if (str != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxNativeAdListener.onNativeAdLoadFailed(str, maxError);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about native ad failing to load", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2559a(final AppLovinAdClickListener appLovinAdClickListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdClickListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdClickListener.adClicked(C1267j.m2568b(appLovinAd));
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2560a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdDisplayListener.adDisplayed(C1267j.m2568b(appLovinAd));
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2561a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final String str) {
        if (appLovinAdDisplayListener instanceof C1064g) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    ((C1064g) appLovinAdDisplayListener).onAdDisplayFailed(str);
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2562a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final int i) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.validationRequestFailed(C1267j.m2568b(appLovinAd), i);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2563a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.userRewardVerified(C1267j.m2568b(appLovinAd), map);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2564a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdVideoPlaybackListener.videoPlaybackBegan(C1267j.m2568b(appLovinAd));
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2565a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d, boolean z) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener2 = appLovinAdVideoPlaybackListener;
            final AppLovinAd appLovinAd2 = appLovinAd;
            final double d2 = d;
            final boolean z2 = z;
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdVideoPlaybackListener2.videoPlaybackEnded(C1267j.m2568b(appLovinAd2), d2, z2);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2566a(final AppLovinPostbackListener appLovinPostbackListener, final String str) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinPostbackListener.onPostbackSuccess(str);
                    } catch (Throwable th) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to notify AppLovinPostbackListener about postback URL (");
                        outline24.append(str);
                        outline24.append(") executed");
                        C1314v.m2659c("ListenerCallbackInvoker", outline24.toString(), th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m2567a(final AppLovinPostbackListener appLovinPostbackListener, final String str, final int i) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinPostbackListener.onPostbackFailure(str, i);
                    } catch (Throwable th) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to notify AppLovinPostbackListener about postback URL (");
                        outline24.append(str);
                        outline24.append(") failing to execute with error code (");
                        outline24.append(i);
                        outline24.append("):");
                        C1314v.m2659c("ListenerCallbackInvoker", outline24.toString(), th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static AppLovinAd m2568b(AppLovinAd appLovinAd) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        return appLovinAdImpl.getDummyAd() != null ? appLovinAdImpl.getDummyAd() : appLovinAd;
    }

    /* renamed from: b */
    public static void m2569b(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adClosedFullscreen(C1267j.m2568b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m2570b(MaxAdListener maxAdListener, MaxAd maxAd) {
        m2571b(maxAdListener, maxAd, false);
    }

    /* renamed from: b */
    public static void m2571b(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdDisplayed(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m2572b(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdDisplayListener.adHidden(C1267j.m2568b(appLovinAd));
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m2573b(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.userOverQuota(C1267j.m2568b(appLovinAd), map);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m2574c(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adLeftApplication(C1267j.m2568b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m2575c(MaxAdListener maxAdListener, MaxAd maxAd) {
        m2576c(maxAdListener, maxAd, false);
    }

    /* renamed from: c */
    public static void m2576c(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdHidden(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m2577c(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.userRewardRejected(C1267j.m2568b(appLovinAd), map);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
                    }
                }
            });
        }
    }

    /* renamed from: d */
    public static void m2578d(MaxAdListener maxAdListener, MaxAd maxAd) {
        m2579d(maxAdListener, maxAd, false);
    }

    /* renamed from: d */
    public static void m2579d(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdClicked(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                    }
                }
            });
        }
    }

    /* renamed from: e */
    public static void m2580e(MaxAdListener maxAdListener, MaxAd maxAd) {
        m2581e(maxAdListener, maxAd, false);
    }

    /* renamed from: e */
    public static void m2581e(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) maxAdListener).onRewardedVideoStarted(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video starting", th);
                    }
                }
            });
        }
    }

    /* renamed from: f */
    public static void m2582f(MaxAdListener maxAdListener, MaxAd maxAd) {
        m2583f(maxAdListener, maxAd, false);
    }

    /* renamed from: f */
    public static void m2583f(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) maxAdListener).onRewardedVideoCompleted(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video completing", th);
                    }
                }
            });
        }
    }

    /* renamed from: g */
    public static void m2584g(MaxAdListener maxAdListener, MaxAd maxAd) {
        m2585g(maxAdListener, maxAd, false);
    }

    /* renamed from: g */
    public static void m2585g(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being expanded", th);
                    }
                }
            });
        }
    }

    /* renamed from: h */
    public static void m2586h(MaxAdListener maxAdListener, MaxAd maxAd) {
        m2587h(maxAdListener, maxAd, false);
    }

    /* renamed from: h */
    public static void m2587h(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z, new Runnable() {
                public void run() {
                    try {
                        ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
                    } catch (Throwable th) {
                        C1314v.m2659c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being collapsed", th);
                    }
                }
            });
        }
    }
}
