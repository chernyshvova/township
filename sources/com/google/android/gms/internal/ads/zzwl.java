package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.playrix.gplay.billing.Base64;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwl {
    public final zztz zza;
    public final zzwx zzb = new zzwx();
    public final zzakr zzc = new zzakr();
    public zzwy zzd;
    public zzwh zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    public final zzakr zzj = new zzakr(1);
    public final zzakr zzk = new zzakr();
    public boolean zzl;

    public zzwl(zztz zztz, zzwy zzwy, zzwh zzwh) {
        this.zza = zztz;
        this.zzd = zzwy;
        this.zze = zzwh;
        zza(zzwy, zzwh);
    }

    public final void zza(zzwy zzwy, zzwh zzwh) {
        this.zzd = zzwy;
        this.zze = zzwh;
        this.zza.zza(zzwy.zza.zzf);
        zzb();
    }

    public final void zzb() {
        zzwx zzwx = this.zzb;
        zzwx.zzd = 0;
        zzwx.zzq = 0;
        zzwx.zzr = false;
        zzwx.zzl = false;
        zzwx.zzp = false;
        zzwx.zzn = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final long zzc() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        return this.zzb.zzb(this.zzf);
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final int zze() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzf() {
        int i;
        if (!this.zzl) {
            i = this.zzd.zzg[this.zzf];
        } else {
            i = this.zzb.zzk[this.zzf] ? 1 : 0;
        }
        return zzi() != null ? i | 1073741824 : i;
    }

    public final boolean zzg() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }

    public final int zzh(int i, int i2) {
        zzakr zzakr;
        zzww zzi2 = zzi();
        if (zzi2 == null) {
            return 0;
        }
        int i3 = zzi2.zzd;
        if (i3 != 0) {
            zzakr = this.zzb.zzo;
        } else {
            byte[] bArr = (byte[]) zzalh.zzd(zzi2.zze);
            zzakr zzakr2 = this.zzk;
            int length = bArr.length;
            zzakr2.zzb(bArr, length);
            zzakr = this.zzk;
            i3 = length;
        }
        boolean zzc2 = this.zzb.zzc(this.zzf);
        boolean z = zzc2 || i2 != 0;
        this.zzj.zzi()[0] = (byte) ((true != z ? 0 : 128) | i3);
        this.zzj.zzh(0);
        this.zza.zzc(this.zzj, 1, 1);
        this.zza.zzc(zzakr, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zzc2) {
            this.zzc.zza(8);
            byte[] zzi3 = this.zzc.zzi();
            zzi3[0] = 0;
            zzi3[1] = 1;
            zzi3[2] = 0;
            zzi3[3] = (byte) i2;
            zzi3[4] = (byte) ((i >> 24) & 255);
            zzi3[5] = (byte) ((i >> 16) & 255);
            zzi3[6] = (byte) ((i >> 8) & 255);
            zzi3[7] = (byte) (i & 255);
            this.zza.zzc(this.zzc, 8, 1);
            return i3 + 9;
        }
        zzakr zzakr3 = this.zzb.zzo;
        int zzo = zzakr3.zzo();
        zzakr3.zzk(-2);
        int i4 = (zzo * 6) + 2;
        if (i2 != 0) {
            this.zzc.zza(i4);
            byte[] zzi4 = this.zzc.zzi();
            zzakr3.zzm(zzi4, 0, i4);
            int i5 = (((zzi4[2] & Base64.EQUALS_SIGN_ENC) << 8) | (zzi4[3] & Base64.EQUALS_SIGN_ENC)) + i2;
            zzi4[2] = (byte) ((i5 >> 8) & 255);
            zzi4[3] = (byte) (i5 & 255);
            zzakr3 = this.zzc;
        }
        this.zza.zzc(zzakr3, i4, 1);
        return i3 + 1 + i4;
    }

    @Nullable
    public final zzww zzi() {
        if (!this.zzl) {
            return null;
        }
        zzwx zzwx = this.zzb;
        zzwh zzwh = zzwx.zza;
        int i = zzalh.zza;
        int i2 = zzwh.zza;
        zzww zzww = zzwx.zzn;
        if (zzww == null) {
            zzww = this.zzd.zza.zza(i2);
        }
        if (zzww == null || !zzww.zza) {
            return null;
        }
        return zzww;
    }
}
