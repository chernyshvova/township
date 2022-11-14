package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzamm {
    @Nullable
    public final Handler zza;
    @Nullable
    public final zzamn zzb;

    public zzamm(@Nullable Handler handler, @Nullable zzamn zzamn) {
        if (zzamn == null) {
            handler = null;
        } else if (handler == null) {
            throw null;
        }
        this.zza = handler;
        this.zzb = zzamn;
    }

    public final void zza(zzro zzro) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzamc(this, zzro));
        }
    }

    public final void zzb(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzamd(this, str, j, j2));
        }
    }

    public final void zzc(zzkc zzkc, @Nullable zzrs zzrs) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzame(this, zzkc, zzrs));
        }
    }

    public final void zzd(int i, long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzamf(this, i, j));
        }
    }

    public final void zze(long j, int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzamg(this, j, i));
        }
    }

    public final void zzf(zzamp zzamp) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzamh(this, zzamp));
        }
    }

    public final void zzg(Object obj) {
        if (this.zza != null) {
            this.zza.post(new zzami(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public final void zzh(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzamj(this, str));
        }
    }

    public final void zzi(zzro zzro) {
        zzro.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzamk(this, zzro));
        }
    }

    public final void zzj(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaml(this, exc));
        }
    }

    public final /* synthetic */ void zzk(Exception exc) {
        zzamn zzamn = this.zzb;
        int i = zzalh.zza;
        zzamn.zzA(exc);
    }

    public final /* synthetic */ void zzl(zzro zzro) {
        zzro.zza();
        zzamn zzamn = this.zzb;
        int i = zzalh.zza;
        zzamn.zzy(zzro);
    }

    public final /* synthetic */ void zzm(String str) {
        zzamn zzamn = this.zzb;
        int i = zzalh.zza;
        zzamn.zzx(str);
    }

    public final /* synthetic */ void zzn(Object obj, long j) {
        zzamn zzamn = this.zzb;
        int i = zzalh.zza;
        zzamn.zzw(obj, j);
    }

    public final /* synthetic */ void zzo(zzamp zzamp) {
        zzamn zzamn = this.zzb;
        int i = zzalh.zza;
        zzamn.zzv(zzamp);
    }

    public final /* synthetic */ void zzp(long j, int i) {
        zzamn zzamn = this.zzb;
        int i2 = zzalh.zza;
        zzamn.zzz(j, i);
    }

    public final /* synthetic */ void zzq(int i, long j) {
        zzamn zzamn = this.zzb;
        int i2 = zzalh.zza;
        zzamn.zzu(i, j);
    }

    public final /* synthetic */ void zzr(zzkc zzkc, zzrs zzrs) {
        zzamn zzamn = this.zzb;
        int i = zzalh.zza;
        zzamn.zzM(zzkc);
        this.zzb.zzbu(zzkc, zzrs);
    }

    public final /* synthetic */ void zzs(String str, long j, long j2) {
        zzamn zzamn = this.zzb;
        int i = zzalh.zza;
        zzamn.zzbt(str, j, j2);
    }

    public final /* synthetic */ void zzt(zzro zzro) {
        zzamn zzamn = this.zzb;
        int i = zzalh.zza;
        zzamn.zzc(zzro);
    }
}
