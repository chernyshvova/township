package com.vungle.warren.p037ui.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.vungle.warren.AdConfig;
import com.vungle.warren.AdRequest;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.VungleNativeAd;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p037ui.CloseDelegate;
import com.vungle.warren.p037ui.JavascriptBridge;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.contract.WebAdContract;
import com.vungle.warren.p037ui.state.OptionsState;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.ExternalRouter;
import com.vungle.warren.utility.HandlerScheduler;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.vungle.warren.ui.view.VungleNativeView */
public class VungleNativeView extends WebView implements WebAdContract.WebAdView, VungleNativeAd {
    public static final String TAG = VungleNativeView.class.getName();
    public BroadcastReceiver broadcastReceiver;
    public final AdConfig config;
    public boolean destroyed;
    public AtomicReference<Boolean> isAdVisible = new AtomicReference<>();
    public final AdContract.AdvertisementPresenter.EventListener listener;
    public WebAdContract.WebAdPresenter presenter;
    public PresentationFactory presenterFactory;
    public final AdRequest request;

    public VungleNativeView(@NonNull Context context, @NonNull AdRequest adRequest, @Nullable AdConfig adConfig, @NonNull PresentationFactory presentationFactory, @NonNull AdContract.AdvertisementPresenter.EventListener eventListener) {
        super(context);
        this.listener = eventListener;
        this.request = adRequest;
        this.config = adConfig;
        this.presenterFactory = presentationFactory;
        setLayerType(2, (Paint) null);
        setBackgroundColor(0);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"AddJavascriptInterface", "NewApi"})
    public void prepare() {
        WebSettingsUtils.applyDefault(this);
        addJavascriptInterface(new JavascriptBridge(this.presenter), "Android");
        getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    public void close() {
        WebAdContract.WebAdPresenter webAdPresenter = this.presenter;
        if (webAdPresenter == null) {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                this.listener.onError(new VungleException(25), this.request.getPlacementId());
            }
        } else if (webAdPresenter.handleExit()) {
            finishDisplayingAdInternal(false);
        }
    }

    public void destroyAdView(long j) {
        if (!this.destroyed) {
            this.destroyed = true;
            this.presenter = null;
            this.presenterFactory = null;
            removeJavascriptInterface("Android");
            setWebChromeClient((WebChromeClient) null);
            C20391 r0 = new Runnable() {
                public void run() {
                    VungleNativeView.this.stopLoading();
                    VungleNativeView.this.setWebViewClient((WebViewClient) null);
                    if (Build.VERSION.SDK_INT >= 29) {
                        VungleNativeView.this.setWebViewRenderProcessClient((WebViewRenderProcessClient) null);
                    }
                    VungleNativeView.this.loadUrl("about:blank");
                }
            };
            if (j <= 0) {
                r0.run();
            } else {
                new HandlerScheduler().schedule(r0, j);
            }
        }
    }

    public void finishDisplayingAd() {
        finishDisplayingAdInternal(true);
    }

    public void finishDisplayingAdInternal(boolean z) {
        if (this.presenter != null) {
            this.presenter.detach((z ? 4 : 0) | 2);
        } else {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                this.listener.onError(new VungleException(25), this.request.getPlacementId());
            }
        }
        destroyAdView(0);
    }

    public String getWebsiteUrl() {
        return getUrl();
    }

    public boolean hasWebView() {
        return true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null && this.presenter == null) {
            presentationFactory.getNativeViewPresentation(this.request, this.config, new CloseDelegate() {
                public void close() {
                    VungleNativeView.this.finishDisplayingAdInternal(false);
                }
            }, new PresentationFactory.ViewCallback() {
                public void onResult(@NonNull Pair<WebAdContract.WebAdPresenter, VungleWebClient> pair, @Nullable VungleException vungleException) {
                    VungleNativeView vungleNativeView = VungleNativeView.this;
                    vungleNativeView.presenterFactory = null;
                    if (vungleException == null) {
                        WebAdContract.WebAdPresenter unused = vungleNativeView.presenter = (WebAdContract.WebAdPresenter) pair.first;
                        VungleNativeView.this.setWebViewClient((VungleWebClient) pair.second);
                        VungleNativeView.this.presenter.setEventListener(VungleNativeView.this.listener);
                        VungleNativeView.this.presenter.attach(VungleNativeView.this, (OptionsState) null);
                        VungleNativeView.this.prepare();
                        if (VungleNativeView.this.isAdVisible.get() != null) {
                            VungleNativeView vungleNativeView2 = VungleNativeView.this;
                            vungleNativeView2.setAdVisibility(((Boolean) vungleNativeView2.isAdVisible.get()).booleanValue());
                        }
                        ViewGroup.LayoutParams layoutParams = VungleNativeView.this.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = -1;
                            layoutParams.width = -1;
                        }
                    } else if (vungleNativeView.listener != null) {
                        VungleNativeView.this.listener.onError(vungleException, VungleNativeView.this.request.getPlacementId());
                    }
                }
            });
        }
        this.broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra(AdContract.AdvertisementBus.COMMAND);
                if (AdContract.AdvertisementBus.STOP_ALL.equalsIgnoreCase(stringExtra)) {
                    VungleNativeView.this.finishDisplayingAdInternal(false);
                    return;
                }
                VungleLogger.warn(VungleNativeView.class.getSimpleName() + "#onAttachedToWindow", String.format("Receiving Invalid Broadcast: %1$s", new Object[]{stringExtra}));
            }
        };
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.broadcastReceiver, new IntentFilter(AdContract.AdvertisementBus.ACTION));
        resumeWeb();
    }

    public void onDetachedFromWindow() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.broadcastReceiver);
        super.onDetachedFromWindow();
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null) {
            presentationFactory.destroy();
        }
        pauseWeb();
    }

    public void onPause() {
        super.onPause();
        setAdVisibility(false);
    }

    public void onResume() {
        super.onResume();
        Log.d(TAG, "Resuming Flex");
        setAdVisibility(true);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        setAdVisibility(z);
    }

    public void open(@NonNull String str, ActivityManager.LeftApplicationCallback leftApplicationCallback) {
        String str2 = TAG;
        Log.d(str2, "Opening " + str);
        if (!ExternalRouter.launch(str, getContext(), leftApplicationCallback)) {
            String str3 = TAG;
            Log.e(str3, "Cannot open url " + str);
        }
    }

    public void pauseWeb() {
        onPause();
    }

    public void refreshDialogIfVisible() {
    }

    public void removeWebView() {
        ViewParent parent = getParent();
        if (parent instanceof ViewManager) {
            ((ViewManager) parent).removeView(this);
        }
    }

    public View renderNativeView() {
        return this;
    }

    public void resumeWeb() {
        onResume();
    }

    public void setAdVisibility(boolean z) {
        WebAdContract.WebAdPresenter webAdPresenter = this.presenter;
        if (webAdPresenter != null) {
            webAdPresenter.setAdVisibility(z);
        } else {
            this.isAdVisible.set(Boolean.valueOf(z));
        }
    }

    public void setImmersiveMode() {
    }

    public void setOrientation(int i) {
    }

    public void setPresenter(@NonNull WebAdContract.WebAdPresenter webAdPresenter) {
    }

    public void setVisibility(boolean z) {
        setVisibility(z ? 0 : 4);
    }

    public void showCloseButton() {
        throw new UnsupportedOperationException("VungleNativeView does not implement a close button");
    }

    public void showDialog(@Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable DialogInterface.OnClickListener onClickListener) {
        throw new UnsupportedOperationException("VungleNativeView does not implement a dialog.");
    }

    public void showWebsite(@NonNull String str) {
        loadUrl(str);
    }

    public void updateWindow() {
    }
}
