package com.google.android.gms.internal.games_v2;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzaz implements OnCompleteListener {
    public final /* synthetic */ zzbk zza;
    public final /* synthetic */ TaskCompletionSource zzb;
    public final /* synthetic */ zzy zzc;

    public /* synthetic */ zzaz(zzbk zzbk, TaskCompletionSource taskCompletionSource, zzy zzy) {
        this.zza = zzbk;
        this.zzb = taskCompletionSource;
        this.zzc = zzy;
    }

    public final void onComplete(Task task) {
        this.zza.zzg(this.zzb, this.zzc, task);
    }
}
