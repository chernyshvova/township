package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalc implements zzajt {
    @GuardedBy("messagePool")
    public static final List<zzalb> zza = new ArrayList(50);
    public final Handler zzb;

    public zzalc(Handler handler) {
        this.zzb = handler;
    }

    public static /* synthetic */ void zzl(zzalb zzalb) {
        synchronized (zza) {
            if (zza.size() < 50) {
                zza.add(zzalb);
            }
        }
    }

    public static zzalb zzm() {
        zzalb zzalb;
        synchronized (zza) {
            if (zza.isEmpty()) {
                zzalb = new zzalb((zzala) null);
            } else {
                zzalb = zza.remove(zza.size() - 1);
            }
        }
        return zzalb;
    }

    public final boolean zza(int i) {
        return this.zzb.hasMessages(0);
    }

    public final zzajs zzb(int i) {
        zzalb zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(i), this);
        return zzm;
    }

    public final zzajs zzc(int i, @Nullable Object obj) {
        zzalb zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(i, obj), this);
        return zzm;
    }

    public final zzajs zzd(int i, int i2, int i3) {
        zzalb zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(1, i2, i3), this);
        return zzm;
    }

    public final zzajs zze(int i, int i2, int i3, @Nullable Object obj) {
        zzalb zzm = zzm();
        zzm.zzb(this.zzb.obtainMessage(1, 1036, 0, obj), this);
        return zzm;
    }

    public final boolean zzf(zzajs zzajs) {
        return ((zzalb) zzajs).zzc(this.zzb);
    }

    public final boolean zzg(int i) {
        return this.zzb.sendEmptyMessage(i);
    }

    public final boolean zzh(int i, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    public final void zzi(int i) {
        this.zzb.removeMessages(2);
    }

    public final void zzj(@Nullable Object obj) {
        this.zzb.removeCallbacksAndMessages((Object) null);
    }

    public final boolean zzk(Runnable runnable) {
        return this.zzb.post(runnable);
    }
}
