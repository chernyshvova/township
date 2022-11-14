package com.vungle.warren;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.vungle.warren.AdConfig;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.persistence.FutureResult;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.TimeoutProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class Banners {
    public static final String TAG = "Banners";

    public static boolean canPlayAd(@NonNull String str, @NonNull AdConfig.AdSize adSize) {
        return canPlayAd(str, (String) null, adSize);
    }

    @Deprecated
    @Nullable
    public static VungleBanner getBanner(@NonNull String str, @NonNull AdConfig.AdSize adSize, @Nullable PlayAdCallback playAdCallback) {
        return getBanner(str, new BannerAdConfig(adSize), playAdCallback);
    }

    public static void loadBanner(@NonNull String str, @NonNull BannerAdConfig bannerAdConfig, @Nullable LoadAdCallback loadAdCallback) {
        loadBanner(str, (String) null, bannerAdConfig, loadAdCallback);
    }

    public static void onLoadError(@NonNull String str, @Nullable LoadAdCallback loadAdCallback, @VungleException.ExceptionCode int i) {
        VungleException vungleException = new VungleException(i);
        if (loadAdCallback != null) {
            loadAdCallback.onError(str, vungleException);
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Banner load error: ");
        outline24.append(vungleException.getLocalizedMessage());
        VungleLogger.error("Banners#onLoadError", outline24.toString());
    }

    public static void onPlaybackError(@NonNull String str, @Nullable PlayAdCallback playAdCallback, @VungleException.ExceptionCode int i) {
        VungleException vungleException = new VungleException(i);
        if (playAdCallback != null) {
            playAdCallback.onError(str, vungleException);
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Banner play error: ");
        outline24.append(vungleException.getLocalizedMessage());
        VungleLogger.error("Banners#onPlaybackError", outline24.toString());
    }

    public static boolean canPlayAd(@NonNull final String str, @Nullable final String str2, @NonNull final AdConfig.AdSize adSize) {
        if (!AdConfig.AdSize.isBannerAdSize(adSize)) {
            Log.e(TAG, "Invalid Ad Size. Cannot check loaded status of non banner size placements.");
            return false;
        }
        final Context appContext = Vungle.appContext();
        if (appContext == null) {
            Log.e(TAG, "Context is null");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "PlacementId is null");
            return false;
        } else {
            ServiceLocator instance = ServiceLocator.getInstance(appContext);
            return Boolean.TRUE.equals(new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<Boolean>() {
                public Boolean call() {
                    AdConfig.AdSize adSize;
                    if (!Vungle.isInitialized()) {
                        Log.e(Banners.TAG, "Vungle is not initialized");
                        return Boolean.FALSE;
                    }
                    Repository repository = (Repository) ServiceLocator.getInstance(appContext).getService(Repository.class);
                    AdRequest adRequest = new AdRequest(str, AdMarkup.fromString(str2));
                    Placement placement = repository.load(str, Placement.class).get();
                    if (placement == null) {
                        return Boolean.FALSE;
                    }
                    if (placement.isMultipleHBPEnabled() && adRequest.getEventId() == null) {
                        return Boolean.FALSE;
                    }
                    Advertisement advertisement = repository.findValidAdvertisementForPlacement(str, adRequest.getEventId()).get();
                    if (advertisement == null) {
                        return Boolean.FALSE;
                    }
                    AdConfig.AdSize adSize2 = placement.getAdSize();
                    AdConfig.AdSize adSize3 = advertisement.getAdConfig().getAdSize();
                    boolean z = true;
                    boolean z2 = adSize == AdConfig.AdSize.VUNGLE_MREC && AdConfig.AdSize.isDefaultAdSize(adSize2) && AdConfig.AdSize.isDefaultAdSize(adSize3) && placement.getPlacementAdType() == 3;
                    if (!placement.isMultipleHBPEnabled() || !AdConfig.AdSize.isNonMrecBannerAdSize(adSize2) || !AdConfig.AdSize.isNonMrecBannerAdSize(adSize3)) {
                        z = z2;
                    }
                    if (z || ((adSize = adSize) == adSize2 && adSize == adSize3)) {
                        return Boolean.valueOf(Vungle.canPlayAd(advertisement));
                    }
                    return Boolean.FALSE;
                }
            })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS));
        }
    }

    @Nullable
    public static VungleBanner getBanner(@NonNull String str, @NonNull BannerAdConfig bannerAdConfig, @Nullable PlayAdCallback playAdCallback) {
        return getBanner(str, (String) null, bannerAdConfig, playAdCallback);
    }

    @Deprecated
    public static void loadBanner(@NonNull String str, @NonNull AdConfig.AdSize adSize, @Nullable LoadAdCallback loadAdCallback) {
        if (adSize == null) {
            onLoadError(str, loadAdCallback, 28);
        } else {
            loadBanner(str, new BannerAdConfig(adSize), loadAdCallback);
        }
    }

    @Nullable
    public static VungleBanner getBanner(@NonNull String str, @Nullable String str2, @NonNull BannerAdConfig bannerAdConfig, @Nullable PlayAdCallback playAdCallback) {
        String str3 = str;
        PlayAdCallback playAdCallback2 = playAdCallback;
        VungleLogger.debug("VungleBanner#getBanner", "getBanner call invoked");
        Context appContext = Vungle.appContext();
        if (appContext == null) {
            Log.e(TAG, "Vungle is not initialized, returned VungleNativeAd = null");
            onPlaybackError(str3, playAdCallback2, 9);
            return null;
        }
        AdConfig.AdSize adSize = bannerAdConfig.getAdSize();
        final ServiceLocator instance = ServiceLocator.getInstance(appContext);
        Executors executors = (Executors) instance.getService(Executors.class);
        VungleSettings vungleSettings = ((RuntimeValues) ServiceLocator.getInstance(appContext).getService(RuntimeValues.class)).settings.get();
        final PlayAdCallbackWrapper playAdCallbackWrapper = new PlayAdCallbackWrapper(executors.getUIExecutor(), playAdCallback2);
        final String str4 = str;
        final AdConfig.AdSize adSize2 = adSize;
        final String str5 = str2;
        Pair pair = (Pair) new FutureResult(executors.getBackgroundExecutor().submit(new Callable<Pair<Boolean, Placement>>() {
            public Pair<Boolean, Placement> call() throws Exception {
                if (!Vungle.isInitialized()) {
                    Log.e(Banners.TAG, "Vungle is not initialized.");
                    Banners.onPlaybackError(str4, playAdCallbackWrapper, 9);
                    return new Pair<>(Boolean.FALSE, (Object) null);
                } else if (TextUtils.isEmpty(str4)) {
                    Banners.onPlaybackError(str4, playAdCallbackWrapper, 13);
                    return new Pair<>(Boolean.FALSE, (Object) null);
                } else {
                    Placement placement = ((Repository) instance.getService(Repository.class)).load(str4, Placement.class).get();
                    if (placement == null) {
                        Banners.onPlaybackError(str4, playAdCallbackWrapper, 13);
                        return new Pair<>(Boolean.FALSE, (Object) null);
                    } else if (!AdConfig.AdSize.isBannerAdSize(adSize2)) {
                        Banners.onPlaybackError(str4, playAdCallbackWrapper, 30);
                        return new Pair<>(Boolean.FALSE, placement);
                    } else if (Banners.canPlayAd(str4, str5, adSize2)) {
                        return new Pair<>(Boolean.TRUE, placement);
                    } else {
                        Banners.onPlaybackError(str4, playAdCallbackWrapper, 10);
                        return new Pair<>(Boolean.FALSE, placement);
                    }
                }
            }
        })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        if (pair == null) {
            onPlaybackError(str3, playAdCallback2, 13);
            return null;
        } else if (!((Boolean) pair.first).booleanValue()) {
            return null;
        } else {
            return new VungleBanner(appContext, str, AdMarkup.fromString(str2), (vungleSettings == null || !vungleSettings.getBannerRefreshDisabled()) ? adSize != AdConfig.AdSize.VUNGLE_MREC ? ((Placement) pair.second).getAdRefreshDuration() : 0 : 0, bannerAdConfig, playAdCallback);
        }
    }

    public static void loadBanner(@NonNull String str, @Nullable String str2, @NonNull BannerAdConfig bannerAdConfig, @Nullable LoadAdCallback loadAdCallback) {
        VungleLogger.debug("Banners#loadBanner", "loadBanner API call invoked");
        if (Vungle.appContext() == null || !Vungle.isInitialized()) {
            onLoadError(str, loadAdCallback, 9);
            return;
        }
        AdConfig adConfig = new AdConfig((BaseAdConfig) bannerAdConfig);
        if (!AdConfig.AdSize.isBannerAdSize(adConfig.getAdSize())) {
            onLoadError(str, loadAdCallback, 30);
        } else {
            Vungle.loadAdInternal(str, AdMarkup.fromString(str2), adConfig, loadAdCallback);
        }
    }
}
