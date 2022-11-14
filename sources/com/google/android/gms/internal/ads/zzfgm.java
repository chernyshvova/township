package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzfgm implements Continuation {
    public final zzbv zza;
    public final int zzb;

    public zzfgm(zzbv zzbv, int i) {
        this.zza = zzbv;
        this.zzb = i;
    }

    public final Object then(Task task) {
        zzbv zzbv = this.zza;
        int i = this.zzb;
        int i2 = zzfgn.zza;
        if (!task.isSuccessful()) {
            return Boolean.FALSE;
        }
        zzfis zza2 = ((zzfit) task.getResult()).zza(((zzcb) zzbv.zzah()).zzao());
        zza2.zzc(i);
        zza2.zza();
        return Boolean.TRUE;
    }
}
