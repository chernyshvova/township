package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagj implements Comparable<zzagj> {
    public final boolean zza;
    @Nullable
    public final String zzb;
    public final zzagm zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;
    public final int zzl;
    public final int zzm;
    public final int zzn;

    public zzagj(zzkc zzkc, zzagm zzagm, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        this.zzc = zzagm;
        this.zzb = zzags.zze(zzkc.zzc);
        int i6 = 0;
        this.zzd = zzags.zzd(i, false);
        int i7 = 0;
        while (true) {
            i2 = Integer.MAX_VALUE;
            if (i7 >= zzagm.zzE.size()) {
                i7 = Integer.MAX_VALUE;
                i3 = 0;
                break;
            }
            i3 = zzags.zzf(zzkc, zzagm.zzE.get(i7), false);
            if (i3 > 0) {
                break;
            }
            i7++;
        }
        this.zzf = i7;
        this.zze = i3;
        this.zzg = Integer.bitCount(zzkc.zze & zzagm.zzF);
        boolean z = true;
        this.zzj = 1 == (zzkc.zzd & 1);
        this.zzk = zzkc.zzy;
        this.zzl = zzkc.zzz;
        int i8 = zzkc.zzh;
        this.zzm = i8;
        if ((i8 != -1 && i8 > zzagm.zzr) || ((i5 = zzkc.zzy) != -1 && i5 > zzagm.zzq)) {
            z = false;
        }
        this.zza = z;
        String[] zzU = zzalh.zzU();
        int i9 = 0;
        while (true) {
            if (i9 >= zzU.length) {
                i9 = Integer.MAX_VALUE;
                i4 = 0;
                break;
            }
            i4 = zzags.zzf(zzkc, zzU[i9], false);
            if (i4 > 0) {
                break;
            }
            i9++;
        }
        this.zzh = i9;
        this.zzi = i4;
        while (true) {
            if (i6 < zzagm.zzw.size()) {
                String str = zzkc.zzl;
                if (str != null && str.equals(zzagm.zzw.get(i6))) {
                    i2 = i6;
                    break;
                }
                i6++;
            } else {
                break;
            }
        }
        this.zzn = i2;
    }

    /* renamed from: zza */
    public final int compareTo(zzagj zzagj) {
        zzfnx zzfnx;
        zzfnx zzfnx2;
        if (!this.zza || !this.zzd) {
            zzfnx = zzags.zzc.zza();
        } else {
            zzfnx = zzags.zzc;
        }
        zzfma zza2 = zzfma.zzg().zzd(this.zzd, zzagj.zzd).zza(Integer.valueOf(this.zzf), Integer.valueOf(zzagj.zzf), zzfnx.zzb().zza()).zzb(this.zze, zzagj.zze).zzb(this.zzg, zzagj.zzg).zzd(this.zza, zzagj.zza).zza(Integer.valueOf(this.zzn), Integer.valueOf(zzagj.zzn), zzfnx.zzb().zza());
        Integer valueOf = Integer.valueOf(this.zzm);
        Integer valueOf2 = Integer.valueOf(zzagj.zzm);
        if (this.zzc.zzx) {
            zzfnx2 = zzags.zzc.zza();
        } else {
            zzfnx2 = zzags.zzd;
        }
        zzfma zza3 = zza2.zza(valueOf, valueOf2, zzfnx2).zzd(this.zzj, zzagj.zzj).zza(Integer.valueOf(this.zzh), Integer.valueOf(zzagj.zzh), zzfnx.zzb().zza()).zzb(this.zzi, zzagj.zzi).zza(Integer.valueOf(this.zzk), Integer.valueOf(zzagj.zzk), zzfnx).zza(Integer.valueOf(this.zzl), Integer.valueOf(zzagj.zzl), zzfnx);
        Integer valueOf3 = Integer.valueOf(this.zzm);
        Integer valueOf4 = Integer.valueOf(zzagj.zzm);
        if (!zzalh.zzc(this.zzb, zzagj.zzb)) {
            zzfnx = zzags.zzd;
        }
        return zza3.zza(valueOf3, valueOf4, zzfnx).zze();
    }
}
