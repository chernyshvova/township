package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzun extends zzus {
    public static final int[] zzb = {5512, 11025, 22050, 44100};
    public boolean zzc;
    public boolean zzd;
    public int zze;

    public zzun(zztz zztz) {
        super(zztz);
    }

    public final boolean zza(zzakr zzakr) throws zzur {
        if (!this.zzc) {
            int zzn = zzakr.zzn();
            int i = zzn >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(zzn >> 2) & 3];
                zzkb zzkb = new zzkb();
                zzkb.zzj("audio/mpeg");
                zzkb.zzw(1);
                zzkb.zzx(i2);
                this.zza.zza(zzkb.zzD());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                String str = i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                zzkb zzkb2 = new zzkb();
                zzkb2.zzj(str);
                zzkb2.zzw(1);
                zzkb2.zzx(8000);
                this.zza.zza(zzkb2.zzD());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzur(GeneratedOutlineSupport.outline9(39, "Audio format not supported: ", i));
            }
            this.zzc = true;
        } else {
            zzakr.zzk(1);
        }
        return true;
    }

    public final boolean zzb(zzakr zzakr, long j) throws zzlg {
        if (this.zze == 2) {
            int zzd2 = zzakr.zzd();
            this.zza.zzf(zzakr, zzd2);
            this.zza.zzd(j, 1, zzd2, 0, (zzty) null);
            return true;
        }
        int zzn = zzakr.zzn();
        if (zzn == 0 && !this.zzd) {
            int zzd3 = zzakr.zzd();
            byte[] bArr = new byte[zzd3];
            zzakr.zzm(bArr, 0, zzd3);
            zzoy zza = zzoz.zza(bArr);
            zzkb zzkb = new zzkb();
            zzkb.zzj("audio/mp4a-latm");
            zzkb.zzh(zza.zzc);
            zzkb.zzw(zza.zzb);
            zzkb.zzx(zza.zza);
            zzkb.zzl(Collections.singletonList(bArr));
            this.zza.zza(zzkb.zzD());
            this.zzd = true;
            return false;
        } else if (this.zze == 10 && zzn != 1) {
            return false;
        } else {
            int zzd4 = zzakr.zzd();
            this.zza.zzf(zzakr, zzd4);
            this.zza.zzd(j, 1, zzd4, 0, (zzty) null);
            return true;
        }
    }
}
