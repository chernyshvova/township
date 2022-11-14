package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffd {
    public static zzffd zza;
    public float zzb = 0.0f;
    public final zzfev zzc;
    public final zzfet zzd;
    public zzfeu zze;
    public zzfew zzf;

    public zzffd(zzfev zzfev, zzfet zzfet) {
        this.zzc = zzfev;
        this.zzd = zzfet;
    }

    public static zzffd zza() {
        if (zza == null) {
            zza = new zzffd(new zzfev(), new zzfet());
        }
        return zza;
    }

    public final void zzb(Context context) {
        this.zze = new zzfeu(new Handler(), context, new zzfes(), this, (byte[]) null);
    }

    public final void zzc() {
        zzfey.zza().zzg(this);
        zzfey.zza().zzc();
        if (zzfey.zza().zze()) {
            zzffz.zzb().zzc();
        }
        this.zze.zza();
    }

    public final void zzd() {
        zzffz.zzb().zzd();
        zzfey.zza().zzd();
        this.zze.zzb();
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzf == null) {
            this.zzf = zzfew.zza();
        }
        for (zzfel zzh : this.zzf.zzf()) {
            zzh.zzh().zzj(f);
        }
    }

    public final float zzf() {
        return this.zzb;
    }
}
