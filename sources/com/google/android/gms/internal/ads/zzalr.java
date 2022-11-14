package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalr {
    public zzalq zza = new zzalq();
    public zzalq zzb = new zzalq();
    public boolean zzc;
    public long zzd = -9223372036854775807L;
    public int zze;

    public final void zza() {
        this.zza.zza();
        this.zzb.zza();
        this.zzc = false;
        this.zzd = -9223372036854775807L;
        this.zze = 0;
    }

    public final void zzb(long j) {
        this.zza.zzf(j);
        int i = 0;
        if (this.zza.zzb()) {
            this.zzc = false;
        } else if (this.zzd != -9223372036854775807L) {
            if (!this.zzc || this.zzb.zzc()) {
                this.zzb.zza();
                this.zzb.zzf(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzf(j);
        }
        if (this.zzc && this.zzb.zzb()) {
            zzalq zzalq = this.zza;
            this.zza = this.zzb;
            this.zzb = zzalq;
            this.zzc = false;
        }
        this.zzd = j;
        if (!this.zza.zzb()) {
            i = this.zze + 1;
        }
        this.zze = i;
    }

    public final boolean zzc() {
        return this.zza.zzb();
    }

    public final int zzd() {
        return this.zze;
    }

    public final long zze() {
        if (this.zza.zzb()) {
            return this.zza.zzd();
        }
        return -9223372036854775807L;
    }

    public final long zzf() {
        if (this.zza.zzb()) {
            return this.zza.zze();
        }
        return -9223372036854775807L;
    }

    public final float zzg() {
        if (!this.zza.zzb()) {
            return -1.0f;
        }
        double zze2 = (double) this.zza.zze();
        Double.isNaN(zze2);
        return (float) (1.0E9d / zze2);
    }
}
