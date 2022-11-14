package com.google.android.gms.internal.games_v2;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final /* synthetic */ class zzbm implements Continuation {
    public final /* synthetic */ zzbo zza;
    public final /* synthetic */ zzy zzb;
    public final /* synthetic */ boolean zzc;

    public /* synthetic */ zzbm(zzbo zzbo, zzy zzy, boolean z) {
        this.zza = zzbo;
        this.zzb = zzy;
        this.zzc = z;
    }

    public final Object then(Task task) {
        return this.zza.zzb(this.zzb, this.zzc, task);
    }
}
