package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.tasks.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface VideosClient {
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STARTED = 2;
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STOPPED = 3;
    public static final int CAPTURE_OVERLAY_STATE_DISMISSED = 4;
    public static final int CAPTURE_OVERLAY_STATE_SHOWN = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public @interface CaptureOverlayState {
    }

    /* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
    public interface OnCaptureOverlayStateListener {
        void onCaptureOverlayStateChanged(int i);
    }

    @RecentlyNonNull
    Task<VideoCapabilities> getCaptureCapabilities();

    @RecentlyNonNull
    Task<Intent> getCaptureOverlayIntent();

    @RecentlyNonNull
    Task<CaptureState> getCaptureState();

    @RecentlyNonNull
    Task<Boolean> isCaptureAvailable(int i);

    @RecentlyNonNull
    Task<Boolean> isCaptureSupported();

    @RecentlyNonNull
    Task<Void> registerOnCaptureOverlayStateChangedListener(@RecentlyNonNull OnCaptureOverlayStateListener onCaptureOverlayStateListener);

    @RecentlyNonNull
    Task<Boolean> unregisterOnCaptureOverlayStateChangedListener(@RecentlyNonNull OnCaptureOverlayStateListener onCaptureOverlayStateListener);
}
