package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcxa implements zzdcr, zzavz {
    public final zzeye zza;
    public final zzdbv zzb;
    public final zzdda zzc;
    public final AtomicBoolean zzd = new AtomicBoolean();
    public final AtomicBoolean zze = new AtomicBoolean();

    public zzcxa(zzeye zzeye, zzdbv zzdbv, zzdda zzdda) {
        this.zza = zzeye;
        this.zzb = zzdbv;
        this.zzc = zzdda;
    }

    private final void zzb() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    public final synchronized void zzbU() {
        if (this.zza.zzf != 1) {
            zzb();
        }
    }

    public final void zzc(zzavy zzavy) {
        if (this.zza.zzf == 1 && zzavy.zzj) {
            zzb();
        }
        if (zzavy.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }
}
