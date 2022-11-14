package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzpy {
    @Nullable
    public final Handler zza;
    @Nullable
    public final zzpz zzb;

    public zzpy(@Nullable Handler handler, @Nullable zzpz zzpz) {
        if (zzpz == null) {
            handler = null;
        } else if (handler == null) {
            throw null;
        }
        this.zza = handler;
        this.zzb = zzpz;
    }

    public final void zza(zzro zzro) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpo(this, zzro));
        }
    }

    public final void zzb(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpp(this, str, j, j2));
        }
    }

    public final void zzc(zzkc zzkc, @Nullable zzrs zzrs) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpq(this, zzkc, zzrs));
        }
    }

    public final void zzd(long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpr(this, j));
        }
    }

    public final void zze(int i, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzps(this, i, j, j2));
        }
    }

    public final void zzf(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpt(this, str));
        }
    }

    public final void zzg(zzro zzro) {
        zzro.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpu(this, zzro));
        }
    }

    public final void zzh(boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpv(this, z));
        }
    }

    public final void zzi(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpw(this, exc));
        }
    }

    public final void zzj(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpx(this, exc));
        }
    }

    public final /* synthetic */ void zzk(Exception exc) {
        zzpz zzpz = this.zzb;
        int i = zzalh.zza;
        zzpz.zzK(exc);
    }

    public final /* synthetic */ void zzl(Exception exc) {
        zzpz zzpz = this.zzb;
        int i = zzalh.zza;
        zzpz.zzJ(exc);
    }

    public final /* synthetic */ void zzm(boolean z) {
        zzpz zzpz = this.zzb;
        int i = zzalh.zza;
        zzpz.zzI(z);
    }

    public final /* synthetic */ void zzn(zzro zzro) {
        zzro.zza();
        zzpz zzpz = this.zzb;
        int i = zzalh.zza;
        zzpz.zzH(zzro);
    }

    public final /* synthetic */ void zzo(String str) {
        zzpz zzpz = this.zzb;
        int i = zzalh.zza;
        zzpz.zzG(str);
    }

    public final /* synthetic */ void zzp(int i, long j, long j2) {
        zzpz zzpz = this.zzb;
        int i2 = zzalh.zza;
        zzpz.zzF(i, j, j2);
    }

    public final /* synthetic */ void zzq(long j) {
        zzpz zzpz = this.zzb;
        int i = zzalh.zza;
        zzpz.zzE(j);
    }

    public final /* synthetic */ void zzr(zzkc zzkc, zzrs zzrs) {
        zzpz zzpz = this.zzb;
        int i = zzalh.zza;
        zzpz.zzL(zzkc);
        this.zzb.zzD(zzkc, zzrs);
    }

    public final /* synthetic */ void zzs(String str, long j, long j2) {
        zzpz zzpz = this.zzb;
        int i = zzalh.zza;
        zzpz.zzC(str, j, j2);
    }

    public final /* synthetic */ void zzt(zzro zzro) {
        zzpz zzpz = this.zzb;
        int i = zzalh.zza;
        zzpz.zzB(zzro);
    }
}
