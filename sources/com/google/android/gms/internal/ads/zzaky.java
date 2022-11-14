package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaky implements zzakc {
    public final zzajh zza;
    public boolean zzb;
    public long zzc;
    public long zzd;
    public zzll zze = zzll.zza;

    public zzaky(zzajh zzajh) {
        this.zza = zzajh;
    }

    public final void zza() {
        if (!this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
            this.zzb = true;
        }
    }

    public final void zzb() {
        if (this.zzb) {
            zzc(zzg());
            this.zzb = false;
        }
    }

    public final void zzc(long j) {
        this.zzc = j;
        if (this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
        }
    }

    public final long zzg() {
        long j;
        long j2 = this.zzc;
        if (!this.zzb) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzd;
        zzll zzll = this.zze;
        if (zzll.zzb == 1.0f) {
            j = zzig.zzb(elapsedRealtime);
        } else {
            j = zzll.zza(elapsedRealtime);
        }
        return j2 + j;
    }

    public final void zzh(zzll zzll) {
        if (this.zzb) {
            zzc(zzg());
        }
        this.zze = zzll;
    }

    public final zzll zzi() {
        return this.zze;
    }
}
