package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcjw {
    public final zzaty zza = new zzaty(true, 65536);
    public long zzb = 15000000;
    public long zzc = 30000000;
    public long zzd = 2500000;
    public long zze = 5000000;
    public int zzf;
    public boolean zzg;

    public final void zza() {
        zzk(false);
    }

    public final void zzb(zzanp[] zzanpArr, zzatc zzatc, zzato zzato) {
        this.zzf = 0;
        for (int i = 0; i < 2; i++) {
            if (zzato.zza(i) != null) {
                this.zzf = zzava.zzq(zzanpArr[i].zza()) + this.zzf;
            }
        }
        this.zza.zzb(this.zzf);
    }

    public final void zzc() {
        zzk(true);
    }

    public final void zzd() {
        zzk(true);
    }

    public final synchronized boolean zze(long j, boolean z) {
        long j2;
        j2 = z ? this.zze : this.zzd;
        return j2 <= 0 || j >= j2;
    }

    public final synchronized boolean zzf(long j) {
        boolean z;
        z = true;
        char c = j > this.zzc ? 0 : j < this.zzb ? (char) 2 : 1;
        int zzg2 = this.zza.zzg();
        int i = this.zzf;
        if (c != 2) {
            if (c != 1 || !this.zzg || zzg2 >= i) {
                z = false;
            }
        }
        this.zzg = z;
        return z;
    }

    public final synchronized void zzg(int i) {
        this.zzb = ((long) i) * 1000;
    }

    public final synchronized void zzh(int i) {
        this.zzc = ((long) i) * 1000;
    }

    public final synchronized void zzi(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzj(int i) {
        this.zze = ((long) i) * 1000;
    }

    @VisibleForTesting
    public final void zzk(boolean z) {
        this.zzf = 0;
        this.zzg = false;
        if (z) {
            this.zza.zza();
        }
    }

    public final zzaty zzl() {
        return this.zza;
    }
}
