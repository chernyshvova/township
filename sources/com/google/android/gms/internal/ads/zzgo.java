package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgo implements Callable {
    public final zzfy zza;
    public final zzcn zzb;

    public zzgo(zzfy zzfy, zzcn zzcn) {
        this.zza = zzfy;
        this.zzb = zzcn;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzn() != null) {
            this.zza.zzn().get();
        }
        zzdc zzm = this.zza.zzm();
        if (zzm == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                zzcn zzcn = this.zzb;
                byte[] zzao = zzm.zzao();
                zzcn.zzaj(zzao, 0, zzao.length, zzgdo.zza());
            }
            return null;
        } catch (zzgeo | NullPointerException unused) {
            return null;
        }
    }
}
