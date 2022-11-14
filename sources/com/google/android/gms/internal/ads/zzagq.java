package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagq implements Comparable<zzagq> {
    public final boolean zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final boolean zzi;

    public zzagq(zzkc zzkc, zzagm zzagm, int i, @Nullable String str) {
        zzfml<String> zzfml;
        int i2;
        boolean z = false;
        this.zzb = zzags.zzd(i, false);
        int i3 = zzkc.zzd & (zzagm.zzJ ^ -1);
        this.zzc = 1 == (i3 & 1);
        this.zzd = (i3 & 2) != 0;
        if (zzagm.zzG.isEmpty()) {
            zzfml = zzfml.zzj("");
        } else {
            zzfml = zzagm.zzG;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= zzfml.size()) {
                i4 = Integer.MAX_VALUE;
                i2 = 0;
                break;
            }
            i2 = zzags.zzf(zzkc, zzfml.get(i4), zzagm.zzI);
            if (i2 > 0) {
                break;
            }
            i4++;
        }
        this.zze = i4;
        this.zzf = i2;
        this.zzg = Integer.bitCount(zzkc.zze & zzagm.zzH);
        this.zzi = (zzkc.zze & 1088) != 0;
        this.zzh = zzags.zzf(zzkc, str, zzags.zze(str) == null);
        if (this.zzf > 0 || ((zzagm.zzG.isEmpty() && this.zzg > 0) || this.zzc || (this.zzd && this.zzh > 0))) {
            z = true;
        }
        this.zza = z;
    }

    /* renamed from: zza */
    public final int compareTo(zzagq zzagq) {
        zzfnx zzfnx;
        zzfma zzd2 = zzfma.zzg().zzd(this.zzb, zzagq.zzb).zza(Integer.valueOf(this.zze), Integer.valueOf(zzagq.zze), zzfnx.zzb().zza()).zzb(this.zzf, zzagq.zzf).zzb(this.zzg, zzagq.zzg).zzd(this.zzc, zzagq.zzc);
        Boolean valueOf = Boolean.valueOf(this.zzd);
        Boolean valueOf2 = Boolean.valueOf(zzagq.zzd);
        if (this.zzf == 0) {
            zzfnx = zzfnx.zzb();
        } else {
            zzfnx = zzfnx.zzb().zza();
        }
        zzfma zzb2 = zzd2.zza(valueOf, valueOf2, zzfnx).zzb(this.zzh, zzagq.zzh);
        if (this.zzg == 0) {
            zzb2 = zzb2.zzc(this.zzi, zzagq.zzi);
        }
        return zzb2.zze();
    }
}
