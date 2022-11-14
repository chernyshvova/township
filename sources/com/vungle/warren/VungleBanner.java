package com.vungle.warren;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.vungle.warren.AdConfig;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p037ui.view.VungleNativeView;
import com.vungle.warren.utility.RefreshHandler;
import com.vungle.warren.utility.ViewUtility;
import com.vungle.warren.utility.WeakLoadAdCallback;
import com.vungle.warren.utility.WeakRunnable;

public class VungleBanner extends RelativeLayout {
    public static final String TAG = VungleBanner.class.getSimpleName();
    @Nullable
    public VungleNativeView bannerAd;
    public BannerAdConfig bannerAdConfig;
    public int calculatedPixelHeight;
    public int calculatedPixelWidth;
    public boolean destroyed;
    public boolean disableRenderManagement;
    public LoadAdCallback loadAdCallback = new LoadAdCallback() {
        public void onAdLoad(String str) {
            String access$000 = VungleBanner.TAG;
            Log.d(access$000, "Ad Loaded : " + str);
            if (VungleBanner.this.renderWhenAvailable && VungleBanner.this.canRender()) {
                boolean unused = VungleBanner.this.renderWhenAvailable = false;
                VungleBanner.this.finishAdInternal(false);
                VungleNativeView nativeAdInternal = Vungle.getNativeAdInternal(VungleBanner.this.placementId, (AdMarkup) null, new AdConfig((BaseAdConfig) VungleBanner.this.bannerAdConfig), VungleBanner.this.playAdCallback);
                if (nativeAdInternal != null) {
                    VungleNativeView unused2 = VungleBanner.this.bannerAd = nativeAdInternal;
                    VungleBanner.this.renderAd();
                    return;
                }
                onError(VungleBanner.this.placementId, new VungleException(10));
                VungleLogger.error(VungleBanner.class.getSimpleName() + "#loadAdCallback; onAdLoad", "VungleNativeView is null");
            }
        }

        public void onError(String str, VungleException vungleException) {
            String access$000 = VungleBanner.TAG;
            StringBuilder outline27 = GeneratedOutlineSupport.outline27("Ad Load Error : ", str, " Message : ");
            outline27.append(vungleException.getLocalizedMessage());
            Log.d(access$000, outline27.toString());
            if (VungleBanner.this.getVisibility() == 0 && VungleBanner.this.canRender()) {
                VungleBanner.this.refreshHandler.start();
            }
        }
    };
    public String placementId;
    public PlayAdCallback playAdCallback;
    public Runnable refreshAdRunnable = new Runnable() {
        public void run() {
            Log.d(VungleBanner.TAG, "Refresh Timeout Reached");
            boolean unused = VungleBanner.this.renderWhenAvailable = true;
            VungleBanner.this.loadAdInternal();
        }
    };
    public RefreshHandler refreshHandler;
    public boolean renderAdRequested;
    public boolean renderWhenAvailable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VungleBanner(@NonNull Context context, String str, @Nullable AdMarkup adMarkup, int i, BannerAdConfig bannerAdConfig2, PlayAdCallback playAdCallback2) {
        super(context);
        Context context2 = context;
        String str2 = str;
        BannerAdConfig bannerAdConfig3 = bannerAdConfig2;
        long currentTimeMillis = System.currentTimeMillis();
        VungleLogger.verbose(true, TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Creating banner ad, id = %1$s, at: %2$d", new Object[]{str2, Long.valueOf(currentTimeMillis)}));
        this.placementId = str2;
        this.bannerAdConfig = bannerAdConfig3;
        AdConfig.AdSize adSize = bannerAdConfig2.getAdSize();
        this.playAdCallback = playAdCallback2;
        this.calculatedPixelHeight = ViewUtility.dpToPixels(context2, adSize.getHeight());
        this.calculatedPixelWidth = ViewUtility.dpToPixels(context2, adSize.getWidth());
        this.bannerAd = Vungle.getNativeAdInternal(str2, adMarkup, new AdConfig((BaseAdConfig) bannerAdConfig3), this.playAdCallback);
        this.refreshHandler = new RefreshHandler(new WeakRunnable(this.refreshAdRunnable), ((long) i) * 1000);
        VungleLogger.verbose(true, TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Banner ad created, id = %1$s, elapsed time: %2$dms", new Object[]{str2, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
    }

    /* access modifiers changed from: private */
    public boolean canRender() {
        return !this.destroyed && (!this.disableRenderManagement || this.renderAdRequested);
    }

    /* access modifiers changed from: private */
    public void finishAdInternal(boolean z) {
        synchronized (this) {
            this.refreshHandler.clean();
            if (this.bannerAd != null) {
                this.bannerAd.finishDisplayingAdInternal(z);
                this.bannerAd = null;
                removeAllViews();
            }
        }
    }

    public void destroyAd() {
        finishAdInternal(true);
        this.destroyed = true;
        this.playAdCallback = null;
    }

    public void disableLifeCycleManagement(boolean z) {
        this.disableRenderManagement = z;
    }

    public void finishAd() {
        finishAdInternal(true);
    }

    public void loadAdInternal() {
        Log.d(TAG, "Loading Ad");
        Banners.loadBanner(this.placementId, this.bannerAdConfig, (LoadAdCallback) new WeakLoadAdCallback(this.loadAdCallback));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "Banner onAttachedToWindow");
        if (!this.disableRenderManagement) {
            renderAd();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.disableRenderManagement) {
            Log.d(TAG, "Banner onDetachedFromWindow: render management disabled, do nothing");
        } else {
            finishAdInternal(true);
        }
    }

    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        setAdVisibility(i == 0);
    }

    public void onWindowFocusChanged(boolean z) {
        setAdVisibility(z);
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        String str = TAG;
        Log.d(str, "Banner onWindowVisibilityChanged: " + i);
        setAdVisibility(i == 0);
    }

    public void renderAd() {
        this.renderAdRequested = true;
        if (getVisibility() == 0) {
            VungleNativeView vungleNativeView = this.bannerAd;
            if (vungleNativeView != null) {
                View renderNativeView = vungleNativeView.renderNativeView();
                if (renderNativeView.getParent() != this) {
                    addView(renderNativeView, this.calculatedPixelWidth, this.calculatedPixelHeight);
                    Log.d(TAG, "Add VungleNativeView to Parent");
                }
                String str = TAG;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rendering new ad for: ");
                outline24.append(this.placementId);
                Log.d(str, outline24.toString());
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.calculatedPixelHeight;
                    layoutParams.width = this.calculatedPixelWidth;
                    requestLayout();
                }
                this.refreshHandler.start();
            } else if (canRender()) {
                this.renderWhenAvailable = true;
                loadAdInternal();
            }
        }
    }

    public void setAdVisibility(boolean z) {
        if (!z || !canRender()) {
            this.refreshHandler.pause();
        } else {
            this.refreshHandler.start();
        }
        VungleNativeView vungleNativeView = this.bannerAd;
        if (vungleNativeView != null) {
            vungleNativeView.setAdVisibility(z);
        }
    }
}
