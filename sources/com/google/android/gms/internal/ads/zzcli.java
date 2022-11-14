package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcli implements zzkf {
    public final zzahy zza = new zzahy(true, 65536);
    public long zzb = 15000000;
    public long zzc = 30000000;
    public long zzd = 2500000;
    public long zze = 5000000;
    public int zzf;
    public boolean zzg;

    public final void zza() {
        zzn(false);
    }

    public final void zzb() {
        zzn(true);
    }

    public final void zzc() {
        zzn(true);
    }

    public final long zzd() {
        return 0;
    }

    public final boolean zze() {
        return false;
    }

    public final boolean zzf(long j, long j2, float f) {
        boolean z = true;
        char c = j2 > this.zzc ? 0 : j2 < this.zzb ? (char) 2 : 1;
        int zzg2 = this.zza.zzg();
        int i = this.zzf;
        if (c != 2 && (c != 1 || !this.zzg || zzg2 >= i)) {
            z = false;
        }
        this.zzg = z;
        return z;
    }

    public final boolean zzg(long j, float f, boolean z, long j2) {
        long j3 = z ? this.zze : this.zzd;
        return j3 <= 0 || j >= j3;
    }

    public final zzahy zzh() {
        return this.zza;
    }

    public final void zzi(zzma[] zzmaArr, zzaft zzaft, zzagf[] zzagfArr) {
        this.zzf = 0;
        for (int i = 0; i < 2; i++) {
            if (zzagfArr[i] != null) {
                this.zzf += zzmaArr[i].zza() != 1 ? 131072000 : 13107200;
            }
        }
        this.zza.zzb(this.zzf);
    }

    public final synchronized void zzj(int i) {
        this.zzb = ((long) i) * 1000;
    }

    public final synchronized void zzk(int i) {
        this.zzc = ((long) i) * 1000;
    }

    public final synchronized void zzl(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzm(int i) {
        this.zze = ((long) i) * 1000;
    }

    @VisibleForTesting
    public final void zzn(boolean z) {
        this.zzf = 0;
        this.zzg = false;
        if (z) {
            this.zza.zza();
        }
    }
}
