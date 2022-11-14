package com.applovin.impl.sdk.nativeAd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1256a;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.C1368R;
import com.swrve.sdk.rest.RESTClient;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
public class AppLovinMediaView extends FrameLayout {
    public static final String TAG = "AppLovinMediaView";

    /* renamed from: ad */
    public final AppLovinNativeAdImpl f2242ad;
    public final ImageView imageView;
    public final AtomicBoolean impressionTracked = new AtomicBoolean();
    public boolean isVideoMuted;
    public final C1256a lifecycleCallbacksAdapter = new C1256a() {
        public void onActivityPaused(Activity activity) {
            if (AppLovinMediaView.this.videoView != null) {
                AppLovinMediaView.this.videoView.pause();
            }
        }

        public void onActivityResumed(Activity activity) {
            if (AppLovinMediaView.this.videoView != null) {
                AppLovinMediaView.this.videoView.start();
            }
        }
    };
    public final C1314v logger;
    public MediaPlayer mediaPlayer;
    public final C1188m sdk;
    public final C1201a videoUiEventHandler = new C1201a();
    @Nullable
    public AppLovinVideoView videoView;

    /* renamed from: com.applovin.impl.sdk.nativeAd.AppLovinMediaView$a */
    public class C1201a implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener {
        public C1201a() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            AppLovinMediaView.this.logger.mo11372b(AppLovinMediaView.TAG, "Video completed");
            if (AppLovinMediaView.this.videoView != null) {
                AppLovinMediaView.this.videoView.setVisibility(8);
            }
            AppLovinMediaView.this.imageView.setVisibility(0);
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str = "Video view error (" + i + "," + i2 + ")";
            C1314v access$500 = AppLovinMediaView.this.logger;
            StringBuilder outline27 = GeneratedOutlineSupport.outline27("Encountered media error: ", str, " for ad: ");
            outline27.append(AppLovinMediaView.this.f2242ad);
            access$500.mo11376e(AppLovinMediaView.TAG, outline27.toString());
            return true;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            C1314v access$500 = AppLovinMediaView.this.logger;
            access$500.mo11372b(AppLovinMediaView.TAG, "MediaPlayer Info: (" + i + RESTClient.COMMA_SEPARATOR + i2 + ")");
            return false;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayer unused = AppLovinMediaView.this.mediaPlayer = mediaPlayer;
            mediaPlayer.setOnInfoListener(AppLovinMediaView.this.videoUiEventHandler);
            mediaPlayer.setOnErrorListener(AppLovinMediaView.this.videoUiEventHandler);
            float f = AppLovinMediaView.this.isVideoMuted ^ true ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f, f);
            C1314v access$500 = AppLovinMediaView.this.logger;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediaPlayer prepared: ");
            outline24.append(AppLovinMediaView.this.mediaPlayer);
            access$500.mo11372b(AppLovinMediaView.TAG, outline24.toString());
        }
    }

    public AppLovinMediaView(AppLovinNativeAdImpl appLovinNativeAdImpl, C1188m mVar, Context context) {
        super(context);
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2242ad = appLovinNativeAdImpl;
        this.sdk = mVar;
        this.logger = mVar.mo10922B();
        this.isVideoMuted = true;
        LayoutInflater.from(context).inflate(C1368R.layout.applovin_native_ad_media_view, this, true);
        Uri mainImageUri = appLovinNativeAdImpl.getMainImageUri();
        C0631a vastAd = appLovinNativeAdImpl.getVastAd();
        Uri g = vastAd != null ? vastAd.mo9317g() : null;
        if (mainImageUri == null && g == null) {
            throw new IllegalStateException("AppLovin native ad missing image AND video resources");
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        setOnTouchListener(new AppLovinTouchToClickListener(mVar, C1085b.f1563aS, context, appLovinNativeAdImpl.getClickHandler()));
        ImageView imageView2 = (ImageView) findViewById(C1368R.C1370id.image_view);
        this.imageView = imageView2;
        if (mainImageUri != null) {
            imageView2.setOnClickListener(appLovinNativeAdImpl.getClickHandler());
            this.imageView.setImageURI(mainImageUri);
        }
        if (g != null) {
            mVar.mo10967ae().mo10435a(this.lifecycleCallbacksAdapter);
            AppLovinVideoView appLovinVideoView = new AppLovinVideoView(context, mVar);
            this.videoView = appLovinVideoView;
            appLovinVideoView.setOnPreparedListener(this.videoUiEventHandler);
            this.videoView.setOnCompletionListener(this.videoUiEventHandler);
            this.videoView.setOnErrorListener(this.videoUiEventHandler);
            this.videoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
            addView(this.videoView);
            this.videoView.setVideoURI(g);
            this.imageView.setVisibility(8);
        } else {
            this.videoView = null;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    public void destroy() {
        try {
            setOnTouchListener((View.OnTouchListener) null);
            this.sdk.mo10967ae().mo10437b(this.lifecycleCallbacksAdapter);
            if (this.videoView != null) {
                this.videoView.pause();
                this.videoView.stopPlayback();
                this.videoView.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
                this.videoView.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
                this.videoView.setOnErrorListener((MediaPlayer.OnErrorListener) null);
                this.videoView = null;
            }
            if (this.mediaPlayer != null) {
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
            removeAllViews();
        } catch (Throwable th) {
            Log.d(TAG, "Encountered exception when destroying:" + th);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.impressionTracked.compareAndSet(false, true)) {
            for (String dispatchPostbackAsync : this.f2242ad.getImpressionUrls()) {
                this.sdk.mo10943X().dispatchPostbackAsync(dispatchPostbackAsync, (AppLovinPostbackListener) null);
            }
            this.f2242ad.getAdEventTracker().mo10450a((View) this);
            this.f2242ad.getAdEventTracker().mo10458d();
        }
        AppLovinVideoView appLovinVideoView = this.videoView;
        if (appLovinVideoView != null) {
            appLovinVideoView.start();
        }
    }

    public void onDetachedFromWindow() {
        AppLovinVideoView appLovinVideoView = this.videoView;
        if (appLovinVideoView != null) {
            appLovinVideoView.pause();
        }
        super.onDetachedFromWindow();
    }
}
