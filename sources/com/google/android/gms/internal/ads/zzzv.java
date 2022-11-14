package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzv implements zzzu {
    public final zztd zza;
    public final zztz zzb;
    public final zzzx zzc;
    public final zzkc zzd;
    public final int zze;
    public long zzf;
    public int zzg;
    public long zzh;

    public zzzv(zztd zztd, zztz zztz, zzzx zzzx, String str, int i) throws zzlg {
        this.zza = zztd;
        this.zzb = zztz;
        this.zzc = zzzx;
        int i2 = (zzzx.zzb * zzzx.zze) / 8;
        int i3 = zzzx.zzd;
        if (i3 == i2) {
            int i4 = zzzx.zzc * i2;
            int i5 = i4 * 8;
            this.zze = Math.max(i2, i4 / 10);
            zzkb zzkb = new zzkb();
            zzkb.zzj(str);
            zzkb.zzf(i5);
            zzkb.zzg(i5);
            zzkb.zzk(this.zze);
            zzkb.zzw(zzzx.zzb);
            zzkb.zzx(zzzx.zzc);
            zzkb.zzy(i);
            this.zzd = zzkb.zzD();
            return;
        }
        throw new zzlg(GeneratedOutlineSupport.outline11(50, "Expected block size: ", i2, "; got: ", i3), (Throwable) null);
    }

    public final void zza(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0;
    }

    public final void zzb(int i, long j) {
        this.zza.zzbm(new zzaaa(this.zzc, 1, (long) i, j));
        this.zzb.zza(this.zzd);
    }

    public final boolean zzc(zztb zztb, long j) throws IOException {
        long j2;
        int i;
        int i2;
        long j3 = j;
        while (j3 > 0 && (i = this.zzg) < (i2 = this.zze)) {
            int zza2 = zztx.zza(this.zzb, zztb, (int) Math.min((long) (i2 - i), j3), true);
            if (zza2 == -1) {
                j3 = 0;
            } else {
                this.zzg += zza2;
                j3 -= (long) zza2;
            }
        }
        zzzx zzzx = this.zzc;
        int i3 = zzzx.zzd;
        int i4 = this.zzg / i3;
        if (i4 > 0) {
            long j4 = this.zzf;
            long zzF = zzalh.zzF(this.zzh, 1000000, (long) zzzx.zzc);
            int i5 = i4 * i3;
            int i6 = this.zzg - i5;
            this.zzb.zzd(j4 + zzF, 1, i5, i6, (zzty) null);
            this.zzh += (long) i4;
            this.zzg = i6;
            j2 = 0;
        } else {
            j2 = 0;
        }
        return j3 <= j2;
    }
}
