package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzx extends zza {
    public final TaskCompletionSource<String> zza;

    public zzx(TaskCompletionSource<String> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzr(int i, String str) {
        if (i == 0) {
            this.zza.setResult(str);
        } else {
            GamesStatusUtils.zza(this.zza, i);
        }
    }
}
