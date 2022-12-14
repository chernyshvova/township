package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzq;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzai {
    public static volatile Handler zzb;
    public final zzgt zza;
    public final Runnable zzc;
    public volatile long zzd;

    public zzai(zzgt zzgt) {
        Preconditions.checkNotNull(zzgt);
        this.zza = zzgt;
        this.zzc = new zzal(this, zzgt);
    }

    private final Handler zzd() {
        Handler handler;
        if (zzb != null) {
            return zzb;
        }
        synchronized (zzai.class) {
            if (zzb == null) {
                zzb = new zzq(this.zza.zzm().getMainLooper());
            }
            handler = zzb;
        }
        return handler;
    }

    public abstract void zza();

    public final void zza(long j) {
        zzc();
        if (j >= 0) {
            this.zzd = this.zza.zzl().currentTimeMillis();
            if (!zzd().postDelayed(this.zzc, j)) {
                this.zza.zzq().zze().zza("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zzb() {
        return this.zzd != 0;
    }

    public final void zzc() {
        this.zzd = 0;
        zzd().removeCallbacks(this.zzc);
    }
}
