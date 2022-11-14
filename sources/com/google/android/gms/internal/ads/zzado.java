package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzado extends zzadj {
    public static final Object zzd = new Object();
    @Nullable
    public final Object zze;
    @Nullable
    public final Object zzf;

    public zzado(zzmv zzmv, @Nullable Object obj, @Nullable Object obj2) {
        super(zzmv);
        this.zze = obj;
        this.zzf = obj2;
    }

    public static zzado zzj(zzkq zzkq) {
        return new zzado(new zzadp(zzkq), zzmu.zza, zzd);
    }

    public static zzado zzk(zzmv zzmv, @Nullable Object obj, @Nullable Object obj2) {
        return new zzado(zzmv, obj, obj2);
    }

    public final zzmu zze(int i, zzmu zzmu, long j) {
        this.zzc.zze(i, zzmu, j);
        if (zzalh.zzc(zzmu.zzb, this.zze)) {
            zzmu.zzb = zzmu.zza;
        }
        return zzmu;
    }

    public final zzms zzg(int i, zzms zzms, boolean z) {
        this.zzc.zzg(i, zzms, z);
        if (zzalh.zzc(zzms.zzb, this.zzf) && z) {
            zzms.zzb = zzd;
        }
        return zzms;
    }

    public final int zzh(Object obj) {
        Object obj2;
        zzmv zzmv = this.zzc;
        if (zzd.equals(obj) && (obj2 = this.zzf) != null) {
            obj = obj2;
        }
        return zzmv.zzh(obj);
    }

    public final Object zzi(int i) {
        Object zzi = this.zzc.zzi(i);
        return zzalh.zzc(zzi, this.zzf) ? zzd : zzi;
    }

    public final zzado zzl(zzmv zzmv) {
        return new zzado(zzmv, this.zze, this.zzf);
    }
}
