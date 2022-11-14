package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzhv extends zzmv {
    public final int zzc;
    public final zzafm zzd;

    public zzhv(boolean z, zzafm zzafm, byte[] bArr) {
        this.zzd = zzafm;
        this.zzc = zzafm.zza();
    }

    private final int zzq(int i, boolean z) {
        if (z) {
            return this.zzd.zzb(i);
        }
        if (i >= this.zzc - 1) {
            return -1;
        }
        return i + 1;
    }

    private final int zzx(int i, boolean z) {
        if (z) {
            return this.zzd.zzc(i);
        }
        if (i <= 0) {
            return -1;
        }
        return i - 1;
    }

    public final int zza(int i, int i2, boolean z) {
        int zzk = zzk(i);
        int zzo = zzo(zzk);
        int zza = zzm(zzk).zza(i - zzo, i2 == 2 ? 0 : i2, z);
        if (zza != -1) {
            return zzo + zza;
        }
        int zzq = zzq(zzk, z);
        while (zzq != -1 && zzm(zzq).zzt()) {
            zzq = zzq(zzq, z);
        }
        if (zzq != -1) {
            return zzm(zzq).zzd(z) + zzo(zzq);
        } else if (i2 == 2) {
            return zzd(z);
        } else {
            return -1;
        }
    }

    public final int zzb(int i, int i2, boolean z) {
        int zzk = zzk(i);
        int zzo = zzo(zzk);
        int zzb = zzm(zzk).zzb(i - zzo, 0, false);
        if (zzb != -1) {
            return zzo + zzb;
        }
        int zzx = zzx(zzk, false);
        while (zzx != -1 && zzm(zzx).zzt()) {
            zzx = zzx(zzx, false);
        }
        if (zzx == -1) {
            return -1;
        }
        return zzm(zzx).zzc(false) + zzo(zzx);
    }

    public final int zzc(boolean z) {
        int i = this.zzc;
        if (i == 0) {
            return -1;
        }
        int zzd2 = z ? this.zzd.zzd() : i - 1;
        while (zzm(zzd2).zzt()) {
            zzd2 = zzx(zzd2, z);
            if (zzd2 == -1) {
                return -1;
            }
        }
        return zzm(zzd2).zzc(z) + zzo(zzd2);
    }

    public final int zzd(boolean z) {
        if (this.zzc == 0) {
            return -1;
        }
        int zze = z ? this.zzd.zze() : 0;
        while (zzm(zze).zzt()) {
            zze = zzq(zze, z);
            if (zze == -1) {
                return -1;
            }
        }
        return zzm(zze).zzd(z) + zzo(zze);
    }

    public final zzmu zze(int i, zzmu zzmu, long j) {
        int zzk = zzk(i);
        int zzo = zzo(zzk);
        int zzn = zzn(zzk);
        zzm(zzk).zze(i - zzo, zzmu, j);
        Object zzp = zzp(zzk);
        if (!zzmu.zza.equals(zzmu.zzb)) {
            zzp = Pair.create(zzp, zzmu.zzb);
        }
        zzmu.zzb = zzp;
        zzmu.zzn += zzn;
        zzmu.zzo += zzn;
        return zzmu;
    }

    public final zzms zzf(Object obj, zzms zzms) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzl = zzl(obj2);
        int zzo = zzo(zzl);
        zzm(zzl).zzf(obj3, zzms);
        zzms.zzc += zzo;
        zzms.zzb = obj;
        return zzms;
    }

    public final zzms zzg(int i, zzms zzms, boolean z) {
        int zzj = zzj(i);
        int zzo = zzo(zzj);
        zzm(zzj).zzg(i - zzn(zzj), zzms, z);
        zzms.zzc += zzo;
        if (z) {
            Object zzp = zzp(zzj);
            Object obj = zzms.zzb;
            if (obj != null) {
                zzms.zzb = Pair.create(zzp, obj);
            } else {
                throw null;
            }
        }
        return zzms;
    }

    public final int zzh(Object obj) {
        int zzh;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzl = zzl(obj2);
        if (zzl == -1 || (zzh = zzm(zzl).zzh(obj3)) == -1) {
            return -1;
        }
        return zzn(zzl) + zzh;
    }

    public final Object zzi(int i) {
        int zzj = zzj(i);
        return Pair.create(zzp(zzj), zzm(zzj).zzi(i - zzn(zzj)));
    }

    public abstract int zzj(int i);

    public abstract int zzk(int i);

    public abstract int zzl(Object obj);

    public abstract zzmv zzm(int i);

    public abstract int zzn(int i);

    public abstract int zzo(int i);

    public abstract Object zzp(int i);
}
