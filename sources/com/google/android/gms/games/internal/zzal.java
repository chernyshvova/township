package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzal extends zza {
    public final TaskCompletionSource<VideoCapabilities> zza;

    public zzal(TaskCompletionSource<VideoCapabilities> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzv(int i, VideoCapabilities videoCapabilities) {
        if (i == 0) {
            this.zza.setResult(videoCapabilities);
        } else {
            GamesStatusUtils.zza(this.zza, i);
        }
    }
}
