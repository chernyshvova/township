package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzua {
    public final byte[] zza;
    public final int zzb;
    public int zzc;
    public int zzd;

    public zzua(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final boolean zza() {
        byte b = this.zza[this.zzc];
        int i = this.zzd;
        zzc(1);
        if (1 != (((b & Base64.EQUALS_SIGN_ENC) >> i) & 1)) {
            return false;
        }
        return true;
    }

    public final int zzb(int i) {
        int i2 = this.zzc;
        int min = Math.min(i, 8 - this.zzd);
        int i3 = i2 + 1;
        int i4 = ((this.zza[i2] & Base64.EQUALS_SIGN_ENC) >> this.zzd) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.zza[i3] & Base64.EQUALS_SIGN_ENC) << min;
            min += 8;
            i3++;
        }
        zzc(i);
        return (-1 >>> (32 - i)) & i4;
    }

    public final void zzc(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.zzc + i3;
        this.zzc = i4;
        int i5 = (i - (i3 * 8)) + this.zzd;
        this.zzd = i5;
        if (i5 > 7) {
            i4++;
            this.zzc = i4;
            i5 -= 8;
            this.zzd = i5;
        }
        boolean z = false;
        if (i4 >= 0 && (i4 < (i2 = this.zzb) || (i4 == i2 && i5 == 0))) {
            z = true;
        }
        zzajg.zzd(z);
    }

    public final int zzd() {
        return (this.zzc * 8) + this.zzd;
    }
}
