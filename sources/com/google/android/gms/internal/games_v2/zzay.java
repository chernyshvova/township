package com.google.android.gms.internal.games_v2;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzay implements OnCompleteListener {
    public final /* synthetic */ zzbk zza;
    public final /* synthetic */ TaskCompletionSource zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzay(zzbk zzbk, TaskCompletionSource taskCompletionSource, int i) {
        this.zza = zzbk;
        this.zzb = taskCompletionSource;
        this.zzc = i;
    }

    public final void onComplete(Task task) {
        this.zza.zzh(this.zzb, this.zzc, task);
    }
}
