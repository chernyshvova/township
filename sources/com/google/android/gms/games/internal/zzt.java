package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzt extends zza {
    public final TaskCompletionSource<Boolean> zza;

    public zzt(TaskCompletionSource<Boolean> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(int i, String str) {
        if (i == 0 || i == 3003) {
            this.zza.setResult(Boolean.valueOf(i == 3003));
        } else {
            GamesStatusUtils.zza(this.zza, i);
        }
    }
}
