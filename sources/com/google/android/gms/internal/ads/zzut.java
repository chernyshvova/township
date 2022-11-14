package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzut extends zzus {
    public final zzakr zzb = new zzakr(zzakj.zza);
    public final zzakr zzc = new zzakr(4);
    public int zzd;
    public boolean zze;
    public boolean zzf;
    public int zzg;

    public zzut(zztz zztz) {
        super(zztz);
    }

    public final boolean zza(zzakr zzakr) throws zzur {
        int zzn = zzakr.zzn();
        int i = zzn >> 4;
        int i2 = zzn & 15;
        if (i2 == 7) {
            this.zzg = i;
            return i != 5;
        }
        throw new zzur(GeneratedOutlineSupport.outline9(39, "Video format not supported: ", i2));
    }

    public final boolean zzb(zzakr zzakr, long j) throws zzlg {
        int zzn = zzakr.zzn();
        long zzs = (((long) zzakr.zzs()) * 1000) + j;
        if (zzn == 0) {
            if (!this.zze) {
                zzakr zzakr2 = new zzakr(new byte[zzakr.zzd()]);
                zzakr.zzm(zzakr2.zzi(), 0, zzakr.zzd());
                zzalj zza = zzalj.zza(zzakr2);
                this.zzd = zza.zzb;
                zzkb zzkb = new zzkb();
                zzkb.zzj("video/avc");
                zzkb.zzh(zza.zzf);
                zzkb.zzo(zza.zzc);
                zzkb.zzp(zza.zzd);
                zzkb.zzs(zza.zze);
                zzkb.zzl(zza.zza);
                this.zza.zza(zzkb.zzD());
                this.zze = true;
                return false;
            }
        } else if (zzn == 1 && this.zze) {
            int i = this.zzg == 1 ? 1 : 0;
            if (!this.zzf && i == 0) {
                return false;
            }
            byte[] zzi = this.zzc.zzi();
            zzi[0] = 0;
            zzi[1] = 0;
            zzi[2] = 0;
            int i2 = 4 - this.zzd;
            int i3 = 0;
            while (zzakr.zzd() > 0) {
                zzakr.zzm(this.zzc.zzi(), i2, this.zzd);
                this.zzc.zzh(0);
                int zzB = this.zzc.zzB();
                this.zzb.zzh(0);
                this.zza.zzf(this.zzb, 4);
                this.zza.zzf(zzakr, zzB);
                i3 = i3 + 4 + zzB;
            }
            this.zza.zzd(zzs, i, i3, 0, (zzty) null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
