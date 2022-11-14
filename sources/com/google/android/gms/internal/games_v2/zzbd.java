package com.google.android.gms.internal.games_v2;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzbd implements Runnable {
    public final /* synthetic */ zzfs zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzbd(zzfs zzfs, TaskCompletionSource taskCompletionSource) {
        this.zza = zzfs;
        this.zzb = taskCompletionSource;
    }

    public final void run() {
        zzfs zzfs = this.zza;
        TaskCompletionSource taskCompletionSource = this.zzb;
        ((Task) zzfs.zza()).addOnCompleteListener(new zzbb(taskCompletionSource));
    }
}
