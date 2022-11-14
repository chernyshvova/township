package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzmv {
    public static final zzmv zza = new zzmq();
    public static final zzif<zzmv> zzb = zzmp.zza;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmv)) {
            return false;
        }
        zzmv zzmv = (zzmv) obj;
        if (zzmv.zzr() != zzr() || zzmv.zzs() != zzs()) {
            return false;
        }
        zzmu zzmu = new zzmu();
        zzms zzms = new zzms();
        zzmu zzmu2 = new zzmu();
        zzms zzms2 = new zzms();
        for (int i = 0; i < zzr(); i++) {
            if (!zze(i, zzmu, 0).equals(zzmv.zze(i, zzmu2, 0))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < zzs(); i2++) {
            if (!zzg(i2, zzms, true).equals(zzmv.zzg(i2, zzms2, true))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        zzmu zzmu = new zzmu();
        zzms zzms = new zzms();
        int zzr = zzr() + 217;
        for (int i = 0; i < zzr(); i++) {
            zzr = (zzr * 31) + zze(i, zzmu, 0).hashCode();
        }
        int zzs = zzs() + (zzr * 31);
        for (int i2 = 0; i2 < zzs(); i2++) {
            zzs = (zzs * 31) + zzg(i2, zzms, true).hashCode();
        }
        return zzs;
    }

    public int zza(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 == 2) {
                return i == zzc(z) ? zzd(z) : i + 1;
            }
            throw new IllegalStateException();
        } else if (i == zzc(z)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public int zzb(int i, int i2, boolean z) {
        if (i == zzd(false)) {
            return -1;
        }
        return i - 1;
    }

    public int zzc(boolean z) {
        if (zzt()) {
            return -1;
        }
        return zzr() - 1;
    }

    public int zzd(boolean z) {
        return zzt() ? -1 : 0;
    }

    public abstract zzmu zze(int i, zzmu zzmu, long j);

    public zzms zzf(Object obj, zzms zzms) {
        return zzg(zzh(obj), zzms, true);
    }

    public abstract zzms zzg(int i, zzms zzms, boolean z);

    public abstract int zzh(Object obj);

    public abstract Object zzi(int i);

    public abstract int zzr();

    public abstract int zzs();

    public final boolean zzt() {
        return zzr() == 0;
    }

    public final int zzu(int i, zzms zzms, zzmu zzmu, int i2, boolean z) {
        int i3 = zzg(i, zzms, false).zzc;
        if (zze(i3, zzmu, 0).zzo != i) {
            return i + 1;
        }
        int zza2 = zza(i3, i2, z);
        if (zza2 == -1) {
            return -1;
        }
        return zze(zza2, zzmu, 0).zzn;
    }

    public final Pair<Object, Long> zzv(zzmu zzmu, zzms zzms, int i, long j) {
        Pair<Object, Long> zzw = zzw(zzmu, zzms, i, j, 0);
        if (zzw != null) {
            return zzw;
        }
        throw null;
    }

    @Nullable
    public final Pair<Object, Long> zzw(zzmu zzmu, zzms zzms, int i, long j, long j2) {
        zzajg.zzc(i, 0, zzr());
        zze(i, zzmu, j2);
        if (j == -9223372036854775807L) {
            long j3 = zzmu.zzl;
            j = 0;
        }
        int i2 = zzmu.zzn;
        zzg(i2, zzms, false);
        while (i2 < zzmu.zzo) {
            long j4 = zzms.zze;
            if (j == 0) {
                break;
            }
            int i3 = i2 + 1;
            long j5 = zzg(i3, zzms, false).zze;
            if (j < 0) {
                break;
            }
            i2 = i3;
        }
        zzg(i2, zzms, true);
        long j6 = zzms.zze;
        Object obj = zzms.zzb;
        if (obj != null) {
            return Pair.create(obj, Long.valueOf(j));
        }
        throw null;
    }
}
