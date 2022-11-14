package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzst {
    public final zzsn zza;
    public final zzss zzb;
    @Nullable
    public zzsp zzc;
    public final int zzd;

    public zzst(zzsq zzsq, zzss zzss, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzss;
        this.zzd = i;
        this.zza = new zzsn(zzsq, j, 0, j3, j4, j5, j6);
    }

    public static final int zzf(zztb zztb, long j, zzts zzts) {
        if (j == zztb.zzn()) {
            return 0;
        }
        zzts.zza = j;
        return 1;
    }

    public static final boolean zzg(zztb zztb, long j) throws IOException {
        long zzn = j - zztb.zzn();
        if (zzn < 0 || zzn > 262144) {
            return false;
        }
        ((zzsx) zztb).zze((int) zzn, false);
        return true;
    }

    public final zztv zza() {
        return this.zza;
    }

    public final void zzb(long j) {
        long j2 = j;
        zzsp zzsp = this.zzc;
        if (zzsp == null || zzsp.zza != j2) {
            zzsp zzsp2 = r1;
            zzsp zzsp3 = new zzsp(j, this.zza.zzd(j2), 0, this.zza.zzc, this.zza.zzd, this.zza.zze, this.zza.zzf);
            this.zzc = zzsp2;
        }
    }

    public final boolean zzc() {
        return this.zzc != null;
    }

    public final int zzd(zztb zztb, zzts zzts) throws IOException {
        while (true) {
            zzsp zzsp = this.zzc;
            zzajg.zze(zzsp);
            long zzc2 = zzsp.zzf;
            long zzd2 = zzsp.zzg;
            long zze = zzsp.zzh;
            if (zzd2 - zzc2 <= ((long) this.zzd)) {
                zze(false, zzc2);
                return zzf(zztb, zzc2, zzts);
            } else if (!zzg(zztb, zze)) {
                return zzf(zztb, zze, zzts);
            } else {
                zztb.zzl();
                zzsr zza2 = this.zzb.zza(zztb, zzsp.zzb);
                int zzd3 = zza2.zzb;
                if (zzd3 == -3) {
                    zze(false, zze);
                    return zzf(zztb, zze, zzts);
                } else if (zzd3 == -2) {
                    zzsp.zzh(zzsp, zza2.zzc, zza2.zzd);
                } else if (zzd3 != -1) {
                    zzg(zztb, zza2.zzd);
                    zze(true, zza2.zzd);
                    return zzf(zztb, zza2.zzd, zzts);
                } else {
                    zzsp.zzg(zzsp, zza2.zzc, zza2.zzd);
                }
            }
        }
    }

    public final void zze(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }
}
