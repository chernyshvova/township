package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzju {
    public zzlj zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    public boolean zzg;

    public zzju(zzlj zzlj) {
        this.zza = zzlj;
    }

    public final void zza(int i) {
        boolean z = true;
        if (true != (this.zzg | i)) {
            z = false;
        }
        this.zzg = z;
        this.zzb += i;
    }

    public final void zzb(zzlj zzlj) {
        this.zzg |= this.zza != zzlj;
        this.zza = zzlj;
    }

    public final void zzc(int i) {
        boolean z = true;
        if (!this.zzc || this.zzd == 5) {
            this.zzg = true;
            this.zzc = true;
            this.zzd = i;
            return;
        }
        if (i != 5) {
            z = false;
        }
        zzajg.zza(z);
    }

    public final void zzd(int i) {
        this.zzg = true;
        this.zze = true;
        this.zzf = i;
    }
}
