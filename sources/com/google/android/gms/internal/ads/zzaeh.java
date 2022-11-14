package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaeh implements zzadt, zzads {
    public final zzadt zza;
    public final long zzb;
    public zzads zzc;

    public zzaeh(zzadt zzadt, long j) {
        this.zza = zzadt;
        this.zzb = j;
    }

    public final void zzb(zzads zzads, long j) {
        this.zzc = zzads;
        this.zza.zzb(this, j - this.zzb);
    }

    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    public final zzaft zzd() {
        return this.zza.zzd();
    }

    public final void zze(long j, boolean z) {
        this.zza.zze(j - this.zzb, false);
    }

    public final void zzf(long j) {
        this.zza.zzf(j - this.zzb);
    }

    public final long zzg() {
        long zzg = this.zza.zzg();
        if (zzg == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzg + this.zzb;
    }

    public final long zzh() {
        long zzh = this.zza.zzh();
        if (zzh == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzh + this.zzb;
    }

    public final long zzi(long j) {
        return this.zza.zzi(j - this.zzb) + this.zzb;
    }

    public final void zzj(zzadt zzadt) {
        zzads zzads = this.zzc;
        if (zzads != null) {
            zzads.zzj(this);
            return;
        }
        throw null;
    }

    public final long zzk(long j, zzme zzme) {
        return this.zza.zzk(j - this.zzb, zzme) + this.zzb;
    }

    public final long zzl() {
        long zzl = this.zza.zzl();
        if (zzl == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzl + this.zzb;
    }

    public final /* bridge */ /* synthetic */ void zzm(zzafl zzafl) {
        zzadt zzadt = (zzadt) zzafl;
        zzads zzads = this.zzc;
        if (zzads != null) {
            zzads.zzm(this);
            return;
        }
        throw null;
    }

    public final boolean zzn(long j) {
        return this.zza.zzn(j - this.zzb);
    }

    public final boolean zzo() {
        return this.zza.zzo();
    }

    public final long zzq(zzagf[] zzagfArr, boolean[] zArr, zzafj[] zzafjArr, boolean[] zArr2, long j) {
        zzafj[] zzafjArr2 = zzafjArr;
        zzafj[] zzafjArr3 = new zzafj[zzafjArr2.length];
        int i = 0;
        while (true) {
            zzafj zzafj = null;
            if (i >= zzafjArr2.length) {
                break;
            }
            zzaei zzaei = (zzaei) zzafjArr2[i];
            if (zzaei != null) {
                zzafj = zzaei.zza();
            }
            zzafjArr3[i] = zzafj;
            i++;
        }
        long zzq = this.zza.zzq(zzagfArr, zArr, zzafjArr3, zArr2, j - this.zzb);
        for (int i2 = 0; i2 < zzafjArr2.length; i2++) {
            zzafj zzafj2 = zzafjArr3[i2];
            if (zzafj2 == null) {
                zzafjArr2[i2] = null;
            } else {
                zzafj zzafj3 = zzafjArr2[i2];
                if (zzafj3 == null || ((zzaei) zzafj3).zza() != zzafj2) {
                    zzafjArr2[i2] = new zzaei(zzafj2, this.zzb);
                }
            }
        }
        return zzq + this.zzb;
    }
}
