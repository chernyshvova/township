package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaql implements zzaqi {
    public final zzaut zza;
    public final int zzb = this.zza.zzu();
    public final int zzc = (this.zza.zzu() & 255);
    public int zzd;
    public int zze;

    public zzaql(zzaqf zzaqf) {
        zzaut zzaut = zzaqf.zza;
        this.zza = zzaut;
        zzaut.zzi(12);
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzl();
        }
        if (i == 16) {
            return this.zza.zzm();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int zzl = this.zza.zzl();
        this.zze = zzl;
        return (zzl & 240) >> 4;
    }

    public final boolean zzc() {
        return false;
    }
}
