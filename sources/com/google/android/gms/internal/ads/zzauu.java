package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzauu {
    public final byte[] zza;
    public final int zzb;
    public int zzc;
    public int zzd = 0;

    public zzauu(byte[] bArr, int i, int i2) {
        this.zza = bArr;
        this.zzc = i;
        this.zzb = i2;
        zzh();
    }

    private final int zzf() {
        int i = 0;
        int i2 = 0;
        while (!zzb()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzc(i2);
        }
        return i3 + i;
    }

    private final boolean zzg(int i) {
        if (i < 2 || i >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i + -1] == 0;
    }

    private final void zzh() {
        int i;
        int i2;
        int i3 = this.zzc;
        boolean z = true;
        if (i3 < 0 || (i = this.zzd) < 0 || i >= 8 || (i3 >= (i2 = this.zzb) && !(i3 == i2 && i == 0))) {
            z = false;
        }
        zzaul.zzd(z);
    }

    public final void zza(int i) {
        int i2 = this.zzc;
        int i3 = (i >> 3) + i2;
        this.zzc = i3;
        int i4 = this.zzd + (i & 7);
        this.zzd = i4;
        if (i4 > 7) {
            this.zzc = i3 + 1;
            this.zzd = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzc) {
                zzh();
                return;
            } else if (zzg(i2)) {
                this.zzc++;
                i2 += 2;
            }
        }
    }

    public final boolean zzb() {
        return zzc(1) == 1;
    }

    public final int zzc(int i) {
        int i2;
        byte b;
        int i3;
        byte b2;
        int i4 = i >> 3;
        byte b3 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            if (zzg(this.zzc + 1)) {
                i3 = this.zzc + 2;
            } else {
                i3 = this.zzc + 1;
            }
            int i6 = this.zzd;
            if (i6 != 0) {
                byte[] bArr = this.zza;
                b2 = ((bArr[i3] & Base64.EQUALS_SIGN_ENC) >>> (8 - i6)) | ((bArr[this.zzc] & Base64.EQUALS_SIGN_ENC) << i6);
            } else {
                b2 = this.zza[this.zzc];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzc = i3;
        }
        if (i > 0) {
            int i7 = this.zzd + i;
            byte b4 = (byte) (255 >> (8 - i));
            if (zzg(this.zzc + 1)) {
                i2 = this.zzc + 2;
            } else {
                i2 = this.zzc + 1;
            }
            if (i7 > 8) {
                byte[] bArr2 = this.zza;
                b = (b4 & (((255 & bArr2[i2]) >> (16 - i7)) | ((bArr2[this.zzc] & Base64.EQUALS_SIGN_ENC) << (i7 - 8)))) | b3;
                this.zzc = i2;
            } else {
                b = (b4 & ((255 & this.zza[this.zzc]) >> (8 - i7))) | b3;
                if (i7 == 8) {
                    this.zzc = i2;
                }
            }
            b3 = b;
            this.zzd = i7 % 8;
        }
        zzh();
        return b3;
    }

    public final int zzd() {
        return zzf();
    }

    public final int zze() {
        int zzf = zzf();
        return ((zzf + 1) / 2) * (zzf % 2 == 0 ? -1 : 1);
    }
}
