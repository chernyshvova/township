package com.vungle.warren.p037ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcessClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.vungle.warren.p037ui.JavascriptBridge;
import com.vungle.warren.utility.HandlerScheduler;
import com.vungle.warren.utility.ViewUtility;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.vungle.warren.ui.view.FullAdWidget */
public class FullAdWidget extends RelativeLayout {
    public static final String TAG = FullAdWidget.class.getSimpleName();
    public final ImageView closeButton;
    public final ImageView ctaOverlay;
    public GestureDetector gestureDetector;
    public Runnable hideSystemUiRunnable;
    public ViewTreeObserver.OnGlobalLayoutListener immersiveModeListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            FullAdWidget.this.removeImmersiveModeListener();
            FullAdWidget.this.hideSystemUi();
        }
    };
    public final RelativeLayout.LayoutParams matchParentLayoutParams;
    public final ImageView muteButton;
    public OnItemClickListener onClickProxy;
    public MediaPlayer.OnCompletionListener onCompletionListener;
    public MediaPlayer.OnErrorListener onErrorListener;
    public MediaPlayer.OnPreparedListener onPreparedListener;
    public final ImageView privacyOverlay;
    public final ProgressBar progressBar;
    public View.OnClickListener proxyClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (FullAdWidget.this.onClickProxy != null) {
                FullAdWidget.this.onClickProxy.onItemClicked(FullAdWidget.this.matchView(view));
            }
        }
    };
    public GestureDetector.SimpleOnGestureListener singleTapOnVideoListener = new GestureDetector.SimpleOnGestureListener() {
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            FullAdWidget.this.proxyClickListener.onClick(FullAdWidget.this.videoViewContainer);
            return true;
        }
    };
    public int startPosition;
    public final VideoView videoView;
    public final RelativeLayout videoViewContainer;
    public Map<View, Integer> viewToId = new HashMap();
    @Nullable
    public WebView webView;
    public final Window window;

    /* renamed from: com.vungle.warren.ui.view.FullAdWidget$AudioContextWrapper */
    public static class AudioContextWrapper extends ContextWrapper {
        public AudioContextWrapper(Context context) {
            super(context);
        }

        public Object getSystemService(String str) {
            if ("audio".equals(str)) {
                return getApplicationContext().getSystemService(str);
            }
            return super.getSystemService(str);
        }
    }

    /* renamed from: com.vungle.warren.ui.view.FullAdWidget$DestroyRunnable */
    public static class DestroyRunnable implements Runnable {
        public WebView webView;

        public DestroyRunnable(WebView webView2) {
            this.webView = webView2;
        }

        public void run() {
            this.webView.stopLoading();
            this.webView.setWebViewClient((WebViewClient) null);
            if (Build.VERSION.SDK_INT >= 29) {
                this.webView.setWebViewRenderProcessClient((WebViewRenderProcessClient) null);
            }
            this.webView.loadData("", (String) null, (String) null);
            this.webView.destroy();
        }
    }

    /* renamed from: com.vungle.warren.ui.view.FullAdWidget$OnItemClickListener */
    public interface OnItemClickListener {
        void onItemClicked(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.vungle.warren.ui.view.FullAdWidget$ViewEvent */
    public @interface ViewEvent {
        public static final int CLOSE_CLICK = 1;
        public static final int CTA_CLICK = 2;
        public static final int MUTE_CLICK = 3;
        public static final int PRIVACY_CLICK = 4;
        public static final int VIDEO_CLICK = 5;
    }

    public FullAdWidget(Context context, Window window2) throws InstantiationException {
        super(context);
        this.window = window2;
        Resources resources = getResources();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.matchParentLayoutParams = layoutParams;
        setLayoutParams(layoutParams);
        this.hideSystemUiRunnable = new Runnable() {
            public void run() {
                FullAdWidget.this.hideSystemUi();
            }
        };
        this.videoView = new VideoView(new AudioContextWrapper(context));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        this.videoView.setLayoutParams(layoutParams2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.videoViewContainer = relativeLayout;
        relativeLayout.setTag("videoViewContainer");
        this.videoViewContainer.setLayoutParams(this.matchParentLayoutParams);
        this.videoViewContainer.addView(this.videoView, layoutParams2);
        addView(this.videoViewContainer, this.matchParentLayoutParams);
        this.gestureDetector = new GestureDetector(context, this.singleTapOnVideoListener);
        WebView webView2 = ViewUtility.getWebView(context);
        this.webView = webView2;
        webView2.setLayoutParams(this.matchParentLayoutParams);
        this.webView.setTag("webView");
        addView(this.webView, this.matchParentLayoutParams);
        this.progressBar = new ProgressBar(context, (AttributeSet) null, 16842872);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 4.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(12);
        this.progressBar.setLayoutParams(layoutParams3);
        this.progressBar.setMax(100);
        this.progressBar.setIndeterminate(false);
        this.progressBar.setVisibility(4);
        addView(this.progressBar);
        int applyDimension = (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 12.0f, resources.getDisplayMetrics());
        layoutParams4.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        ImageView imageView = new ImageView(context);
        this.muteButton = imageView;
        imageView.setImageBitmap(ViewUtility.getBitmap(ViewUtility.Asset.unMute, context));
        this.muteButton.setLayoutParams(layoutParams4);
        this.muteButton.setVisibility(8);
        addView(this.muteButton);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams5.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        ImageView imageView2 = new ImageView(context);
        this.closeButton = imageView2;
        imageView2.setTag("closeButton");
        this.closeButton.setImageBitmap(ViewUtility.getBitmap(ViewUtility.Asset.close, context));
        layoutParams5.addRule(11);
        this.closeButton.setLayoutParams(layoutParams5);
        this.closeButton.setVisibility(8);
        addView(this.closeButton);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams6.addRule(12);
        layoutParams6.addRule(11);
        layoutParams6.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        ImageView imageView3 = new ImageView(context);
        this.ctaOverlay = imageView3;
        imageView3.setTag("ctaOverlay");
        this.ctaOverlay.setLayoutParams(layoutParams6);
        this.ctaOverlay.setImageBitmap(ViewUtility.getBitmap(ViewUtility.Asset.cta, getContext()));
        this.ctaOverlay.setVisibility(8);
        addView(this.ctaOverlay);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams7.addRule(12);
        layoutParams7.addRule(9);
        layoutParams7.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        ImageView imageView4 = new ImageView(context);
        this.privacyOverlay = imageView4;
        imageView4.setLayoutParams(layoutParams7);
        this.privacyOverlay.setVisibility(8);
        addView(this.privacyOverlay);
        bindListeners();
        prepare();
    }

    private void bindListener(View view, int i) {
        this.viewToId.put(view, Integer.valueOf(i));
        view.setOnClickListener(this.proxyClickListener);
    }

    private void bindListeners() {
        bindListener(this.closeButton, 1);
        bindListener(this.ctaOverlay, 2);
        bindListener(this.muteButton, 3);
        bindListener(this.privacyOverlay, 4);
        this.viewToId.put(this.videoViewContainer, 5);
        this.videoViewContainer.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FullAdWidget.this.gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (Build.VERSION.SDK_INT >= 26) {
                    mediaPlayer.seekTo((long) FullAdWidget.this.startPosition, 3);
                }
                if (FullAdWidget.this.onPreparedListener != null) {
                    FullAdWidget.this.onPreparedListener.onPrepared(mediaPlayer);
                }
                FullAdWidget.this.muteButton.setVisibility(0);
            }
        });
        this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (FullAdWidget.this.onErrorListener != null) {
                    return FullAdWidget.this.onErrorListener.onError(mediaPlayer, i, i2);
                }
                return false;
            }
        });
        this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (FullAdWidget.this.onCompletionListener != null) {
                    FullAdWidget.this.onCompletionListener.onCompletion(mediaPlayer);
                }
                FullAdWidget.this.muteButton.setEnabled(false);
            }
        });
    }

    /* access modifiers changed from: private */
    public void hideSystemUi() {
        if (Build.VERSION.SDK_INT >= 30) {
            this.window.setDecorFitsSystemWindows(false);
            WindowInsetsController insetsController = this.window.getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
                return;
            }
            return;
        }
        this.window.getDecorView().setSystemUiVisibility(5894);
    }

    /* access modifiers changed from: private */
    public int matchView(View view) {
        Integer num = this.viewToId.get(view);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @SuppressLint({"NewApi"})
    private void prepare() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.getSettings().setMediaPlaybackRequiresUserGesture(false);
            this.webView.setVisibility(8);
        }
        this.videoViewContainer.setVisibility(8);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void removeImmersiveModeListener() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.immersiveModeListener);
    }

    public void destroyWebView(long j) {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.removeJavascriptInterface("Android");
            this.webView.setWebChromeClient((WebChromeClient) null);
            removeView(this.webView);
            this.webView.removeAllViews();
            if (j <= 0) {
                new DestroyRunnable(this.webView).run();
            } else {
                new HandlerScheduler().schedule(new DestroyRunnable(this.webView), j);
            }
            this.webView = null;
        }
    }

    public int getCurrentVideoPosition() {
        return this.videoView.getCurrentPosition();
    }

    public String getUrl() {
        WebView webView2 = this.webView;
        if (webView2 == null) {
            return null;
        }
        return webView2.getUrl();
    }

    public int getVideoDuration() {
        return this.videoView.getDuration();
    }

    @VisibleForTesting
    @Nullable
    public WebView getWebView() {
        return this.webView;
    }

    public boolean hasWebView() {
        return this.webView != null;
    }

    public boolean isVideoPlaying() {
        return this.videoView.isPlaying();
    }

    public void linkWebView(WebViewClient webViewClient, JavascriptBridge javascriptBridge) {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            WebSettingsUtils.applyDefault(webView2);
            this.webView.setWebViewClient(webViewClient);
            this.webView.addJavascriptInterface(javascriptBridge, "Android");
        }
    }

    public void pausePlayback() {
        this.videoView.pause();
    }

    public void pauseWeb() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.onPause();
        }
        removeImmersiveModeListener();
        removeCallbacks(this.hideSystemUiRunnable);
    }

    public void playVideo(Uri uri, int i) {
        this.videoViewContainer.setVisibility(0);
        this.videoView.setVideoURI(uri);
        this.privacyOverlay.setImageBitmap(ViewUtility.getBitmap(ViewUtility.Asset.privacy, getContext()));
        this.privacyOverlay.setVisibility(0);
        this.progressBar.setVisibility(0);
        this.progressBar.setMax(this.videoView.getDuration());
        startPlayback(i);
    }

    public void release(long j) {
        this.videoView.stopPlayback();
        this.videoView.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
        this.videoView.setOnErrorListener((MediaPlayer.OnErrorListener) null);
        this.videoView.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
        this.videoView.suspend();
        destroyWebView(j);
    }

    public void resumeWeb() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.onResume();
        }
        post(this.hideSystemUiRunnable);
    }

    public void setCtaEnabled(boolean z) {
        this.ctaOverlay.setVisibility(z ? 0 : 8);
    }

    public void setImmersiveMode() {
        getViewTreeObserver().addOnGlobalLayoutListener(this.immersiveModeListener);
    }

    public void setMuted(boolean z) {
        Bitmap bitmap = ViewUtility.getBitmap(ViewUtility.Asset.mute, getContext());
        Bitmap bitmap2 = ViewUtility.getBitmap(ViewUtility.Asset.unMute, getContext());
        ImageView imageView = this.muteButton;
        if (!z) {
            bitmap = bitmap2;
        }
        imageView.setImageBitmap(bitmap);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener2) {
        this.onCompletionListener = onCompletionListener2;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onClickProxy = onItemClickListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener2) {
        this.onPreparedListener = onPreparedListener2;
    }

    public void setProgress(int i, float f) {
        this.progressBar.setMax((int) f);
        this.progressBar.setProgress(i);
    }

    public void showCloseButton(boolean z) {
        this.closeButton.setVisibility(z ? 0 : 8);
    }

    public void showWebsite(String str) {
        if (this.webView != null) {
            String str2 = TAG;
            Log.d(str2, "loadJs: " + str);
            this.webView.loadUrl(str);
            this.webView.setVisibility(0);
            this.videoViewContainer.setVisibility(8);
            this.videoViewContainer.setOnClickListener((View.OnClickListener) null);
            this.progressBar.setVisibility(8);
            this.closeButton.setVisibility(8);
            this.muteButton.setVisibility(8);
            this.ctaOverlay.setVisibility(8);
            this.privacyOverlay.setVisibility(8);
        }
    }

    public boolean startPlayback(int i) {
        if (!this.videoView.isPlaying()) {
            this.videoView.requestFocus();
            this.startPosition = i;
            if (Build.VERSION.SDK_INT < 26) {
                this.videoView.seekTo(i);
            }
            this.videoView.start();
        }
        return this.videoView.isPlaying();
    }

    public void stopPlayback() {
        this.videoView.stopPlayback();
    }

    public void updateWindow() {
        this.window.setFlags(1024, 1024);
        this.window.getDecorView().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }
}
