package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.games.VideosClient;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzfm implements VideosClient {
    public final zzar zza;

    public zzfm(zzar zzar) {
        this.zza = zzar;
    }

    public final Task<VideoCapabilities> getCaptureCapabilities() {
        return this.zza.zzb(zzez.zza);
    }

    public final Task<Intent> getCaptureOverlayIntent() {
        return this.zza.zzb(zzfa.zza);
    }

    public final Task<CaptureState> getCaptureState() {
        return this.zza.zzb(zzfb.zza);
    }

    public final Task<Boolean> isCaptureAvailable(int i) {
        return this.zza.zzb(new zzfj(i));
    }

    public final Task<Boolean> isCaptureSupported() {
        return this.zza.zzb(zzfc.zza);
    }

    public final Task<Void> registerOnCaptureOverlayStateChangedListener(@NonNull VideosClient.OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        return this.zza.zzb(new zzfk(onCaptureOverlayStateListener));
    }

    public final Task<Boolean> unregisterOnCaptureOverlayStateChangedListener(@NonNull VideosClient.OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        return this.zza.zzb(new zzfl(onCaptureOverlayStateListener));
    }
}
