package com.unity3d.services.banners;

import android.app.Activity;
import android.view.ViewManager;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.unity3d.services.ads.webplayer.WebPlayerSettingsCache;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.banners.view.BannerWebPlayerContainer;
import com.unity3d.services.core.configuration.IInitializationListener;
import com.unity3d.services.core.configuration.InitializationNotificationCenter;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.UUID;
import org.json.JSONObject;

public class BannerView extends RelativeLayout {
    public BannerWebPlayerContainer bannerWebPlayerContainer;
    public IInitializationListener initializationListener;
    public IListener listener;
    public String placementId;
    public UnityBannerSize size;
    public String viewId = UUID.randomUUID().toString();

    public interface IListener {
        void onBannerClick(BannerView bannerView);

        void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo);

        void onBannerLeftApplication(BannerView bannerView);

        void onBannerLoaded(BannerView bannerView);
    }

    public static abstract class Listener implements IListener {
        public void onBannerClick(BannerView bannerView) {
        }

        public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        }

        public void onBannerLeftApplication(BannerView bannerView) {
        }

        public void onBannerLoaded(BannerView bannerView) {
        }
    }

    public BannerView(Activity activity, String str, UnityBannerSize unityBannerSize) {
        super(activity);
        this.placementId = str;
        this.size = unityBannerSize;
        setupLayoutParams();
        setBackgroundColor(0);
        ClientProperties.setActivity(activity);
        BannerViewCache.getInstance().addBannerView(this);
    }

    /* access modifiers changed from: private */
    public void bridgeLoad() {
        BannerBridge.load(this.placementId, this.viewId, this.size);
    }

    private void registerInitializeListener() {
        unregisterInitializeListener();
        this.initializationListener = new IInitializationListener() {
            public void onSdkInitializationFailed(String str, int i) {
                this.unregisterInitializeListener();
                if (this.getListener() != null) {
                    this.getListener().onBannerFailedToLoad(this, new BannerErrorInfo("UnityAds sdk initialization failed", BannerErrorCode.NATIVE_ERROR));
                }
            }

            public void onSdkInitialized() {
                this.unregisterInitializeListener();
                this.bridgeLoad();
            }
        };
        InitializationNotificationCenter.getInstance().addListener(this.initializationListener);
    }

    private void setupLayoutParams() {
        setLayoutParams(new RelativeLayout.LayoutParams(Math.round(ViewUtilities.pxFromDp(getContext(), (float) this.size.getWidth())), Math.round(ViewUtilities.pxFromDp(getContext(), (float) this.size.getHeight()))));
        setGravity(17);
        requestLayout();
    }

    /* access modifiers changed from: private */
    public void unregisterInitializeListener() {
        if (this.initializationListener != null) {
            InitializationNotificationCenter.getInstance().removeListener(this.initializationListener);
        }
        this.initializationListener = null;
    }

    public void destroy() {
        BannerViewCache.getInstance().removeBannerView(this.viewId);
        unregisterInitializeListener();
        BannerBridge.destroy(this.placementId);
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                ViewParent parent = this.getParent();
                if (parent != null && (parent instanceof ViewManager)) {
                    ((ViewManager) parent).removeView(this);
                }
            }
        });
        BannerWebPlayerContainer bannerWebPlayerContainer2 = this.bannerWebPlayerContainer;
        if (bannerWebPlayerContainer2 != null) {
            bannerWebPlayerContainer2.destroy();
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Banner [");
        outline24.append(this.placementId);
        outline24.append("] was destroyed");
        DeviceLog.info(outline24.toString());
        this.viewId = null;
        this.listener = null;
        this.bannerWebPlayerContainer = null;
    }

    public IListener getListener() {
        return this.listener;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public UnityBannerSize getSize() {
        return this.size;
    }

    public String getViewId() {
        return this.viewId;
    }

    public void load() {
        if (SdkProperties.isInitialized()) {
            bridgeLoad();
        } else {
            registerInitializeListener();
        }
    }

    public void loadWebPlayer(final UnityBannerSize unityBannerSize) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                JSONObject webSettings = WebPlayerSettingsCache.getInstance().getWebSettings(this.viewId);
                JSONObject webPlayerSettings = WebPlayerSettingsCache.getInstance().getWebPlayerSettings(this.viewId);
                JSONObject webPlayerEventSettings = WebPlayerSettingsCache.getInstance().getWebPlayerEventSettings(this.viewId);
                if (this.bannerWebPlayerContainer == null) {
                    BannerWebPlayerContainer unused = this.bannerWebPlayerContainer = new BannerWebPlayerContainer(this.getContext(), this.viewId, webSettings, webPlayerSettings, webPlayerEventSettings, unityBannerSize);
                    BannerView bannerView = this;
                    bannerView.addView(bannerView.bannerWebPlayerContainer);
                    return;
                }
                this.bannerWebPlayerContainer.setWebPlayerSettings(webSettings, webPlayerSettings);
                this.bannerWebPlayerContainer.setWebPlayerEventSettings(webPlayerEventSettings);
            }
        });
    }

    public void setListener(IListener iListener) {
        this.listener = iListener;
    }
}
