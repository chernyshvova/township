package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzai extends zza {
    public final TaskCompletionSource<CaptureState> zza;

    public zzai(TaskCompletionSource<CaptureState> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zze(int i, Bundle bundle) {
        if (i == 0) {
            this.zza.setResult(CaptureState.zza(bundle));
        } else {
            GamesStatusUtils.zza(this.zza, i);
        }
    }
}
