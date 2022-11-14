package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzecf {
    public int zza = 0;
    public long zzb = 0;
    public long zzc = 0;
    public long zzd = 0;
    public final Object zze = new Object();
    public final Object zzf = new Object();
    public final Object zzg = new Object();
    public final Object zzh = new Object();

    public final void zza(int i) {
        synchronized (this.zze) {
            this.zza = i;
        }
    }

    public final int zzb() {
        int i;
        synchronized (this.zze) {
            i = this.zza;
        }
        return i;
    }

    public final void zzc(long j) {
        synchronized (this.zzf) {
            this.zzb = j;
        }
    }

    public final long zzd() {
        long j;
        synchronized (this.zzf) {
            j = this.zzb;
        }
        return j;
    }

    public final synchronized void zze(long j) {
        synchronized (this.zzg) {
            this.zzc = j;
        }
    }

    public final synchronized long zzf() {
        long j;
        synchronized (this.zzg) {
            j = this.zzc;
        }
        return j;
    }

    public final synchronized void zzg(long j) {
        synchronized (this.zzh) {
            this.zzd = j;
        }
    }

    public final synchronized long zzh() {
        long j;
        synchronized (this.zzh) {
            j = this.zzd;
        }
        return j;
    }
}
