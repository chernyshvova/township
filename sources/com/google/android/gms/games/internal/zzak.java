package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzak extends zza {
    public final TaskCompletionSource<Boolean> zza;

    public zzak(TaskCompletionSource<Boolean> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzu(int i, boolean z) {
        if (i == 0) {
            this.zza.setResult(Boolean.valueOf(z));
        } else {
            GamesStatusUtils.zza(this.zza, i);
        }
    }
}
