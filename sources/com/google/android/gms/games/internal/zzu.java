package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzu extends zza {
    public final TaskCompletionSource<Void> zza;

    public zzu(TaskCompletionSource<Void> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(int i, String str) {
        if (i == 0 || i == 3003) {
            this.zza.setResult(null);
        } else {
            GamesStatusUtils.zza(this.zza, i);
        }
    }
}
