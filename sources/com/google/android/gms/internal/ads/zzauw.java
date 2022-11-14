package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzauw implements zzaup {
    public boolean zza;
    public long zzb;
    public long zzc;
    public zzano zzd = zzano.zza;

    public final long zzN() {
        long j;
        long j2 = this.zzb;
        if (!this.zza) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzc;
        zzano zzano = this.zzd;
        if (zzano.zzb == 1.0f) {
            j = zzamv.zzb(elapsedRealtime);
        } else {
            j = zzano.zza(elapsedRealtime);
        }
        return j2 + j;
    }

    public final zzano zzO(zzano zzano) {
        if (this.zza) {
            zzc(zzN());
        }
        this.zzd = zzano;
        return zzano;
    }

    public final zzano zzP() {
        throw null;
    }

    public final void zza() {
        if (!this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
            this.zza = true;
        }
    }

    public final void zzb() {
        if (this.zza) {
            zzc(zzN());
            this.zza = false;
        }
    }

    public final void zzc(long j) {
        this.zzb = j;
        if (this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
        }
    }

    public final void zzd(zzaup zzaup) {
        zzc(zzaup.zzN());
        this.zzd = zzaup.zzP();
    }
}
