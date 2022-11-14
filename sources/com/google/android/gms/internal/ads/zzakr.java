package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzakr {
    public byte[] zza;
    public int zzb;
    public int zzc;

    public zzakr() {
        this.zza = zzalh.zzf;
    }

    public zzakr(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzc = i;
    }

    public final int zzA() {
        return (zzn() << 21) | (zzn() << 14) | (zzn() << 7) | zzn();
    }

    public final int zzB() {
        int zzv = zzv();
        if (zzv >= 0) {
            return zzv;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline9(29, "Top bit not zero: ", zzv));
    }

    public final int zzC() {
        int zzw = zzw();
        if (zzw >= 0) {
            return zzw;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline9(29, "Top bit not zero: ", zzw));
    }

    public final long zzD() {
        long zzx = zzx();
        if (zzx >= 0) {
            return zzx;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(zzx);
        throw new IllegalStateException(sb.toString());
    }

    public final String zzE(int i, Charset charset) {
        String str = new String(this.zza, this.zzb, i, charset);
        this.zzb += i;
        return str;
    }

    public final String zzF(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.zzb;
        int i3 = (i2 + i) - 1;
        String zzr = zzalh.zzr(this.zza, i2, (i3 >= this.zzc || this.zza[i3] != 0) ? i : i - 1);
        this.zzb += i;
        return zzr;
    }

    @Nullable
    public final String zzG(char c) {
        int i = this.zzc;
        int i2 = this.zzb;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.zzc && this.zza[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.zza;
        int i3 = this.zzb;
        String zzr = zzalh.zzr(bArr, i3, i2 - i3);
        this.zzb = i2;
        if (i2 < this.zzc) {
            this.zzb = i2 + 1;
        }
        return zzr;
    }

    public final long zzH() {
        int i;
        int i2;
        long j = (long) this.zza[this.zzb];
        int i3 = 7;
        while (true) {
            i = 0;
            i2 = 1;
            if (i3 < 0) {
                break;
            }
            int i4 = 1 << i3;
            if ((((long) i4) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= (long) (i4 - 1);
                i = 7 - i3;
            } else if (i3 == 7) {
                i = 1;
            }
        }
        if (i != 0) {
            while (i2 < i) {
                byte b = this.zza[this.zzb + i2];
                if ((b & 192) == 128) {
                    j = (j << 6) | ((long) (b & 63));
                    i2++;
                } else {
                    StringBuilder sb = new StringBuilder(62);
                    sb.append("Invalid UTF-8 sequence continuation byte: ");
                    sb.append(j);
                    throw new NumberFormatException(sb.toString());
                }
            }
            this.zzb += i;
            return j;
        }
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Invalid UTF-8 sequence first byte: ");
        sb2.append(j);
        throw new NumberFormatException(sb2.toString());
    }

    public final void zza(int i) {
        byte[] bArr = this.zza;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        zzb(bArr, i);
    }

    public final void zzb(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzc = i;
        this.zzb = 0;
    }

    public final void zzc(int i) {
        byte[] bArr = this.zza;
        if (i > bArr.length) {
            this.zza = Arrays.copyOf(bArr, i);
        }
    }

    public final int zzd() {
        return this.zzc - this.zzb;
    }

    public final int zze() {
        return this.zzc;
    }

    public final void zzf(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zza.length) {
            z = true;
        }
        zzajg.zza(z);
        this.zzc = i;
    }

    public final int zzg() {
        return this.zzb;
    }

    public final void zzh(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzc) {
            z = true;
        }
        zzajg.zza(z);
        this.zzb = i;
    }

    public final byte[] zzi() {
        return this.zza;
    }

    public final int zzj() {
        return this.zza.length;
    }

    public final void zzk(int i) {
        zzh(this.zzb + i);
    }

    public final void zzl(zzakq zzakq, int i) {
        zzm(zzakq.zza, 0, i);
        zzakq.zzd(0);
    }

    public final void zzm(byte[] bArr, int i, int i2) {
        System.arraycopy(this.zza, this.zzb, bArr, i, i2);
        this.zzb += i2;
    }

    public final int zzn() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        return bArr[i] & Base64.EQUALS_SIGN_ENC;
    }

    public final int zzo() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        this.zzb = i2 + 1;
        return (bArr[i2] & Base64.EQUALS_SIGN_ENC) | ((b & Base64.EQUALS_SIGN_ENC) << 8);
    }

    public final int zzp() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        this.zzb = i2 + 1;
        return ((bArr[i2] & Base64.EQUALS_SIGN_ENC) << 8) | (b & Base64.EQUALS_SIGN_ENC);
    }

    public final short zzq() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        this.zzb = i2 + 1;
        return (short) ((bArr[i2] & Base64.EQUALS_SIGN_ENC) | ((b & Base64.EQUALS_SIGN_ENC) << 8));
    }

    public final int zzr() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        this.zzb = i3 + 1;
        return (bArr[i3] & Base64.EQUALS_SIGN_ENC) | ((b & Base64.EQUALS_SIGN_ENC) << 16) | ((b2 & Base64.EQUALS_SIGN_ENC) << 8);
    }

    public final int zzs() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        this.zzb = i3 + 1;
        return (bArr[i3] & Base64.EQUALS_SIGN_ENC) | (((b & Base64.EQUALS_SIGN_ENC) << 24) >> 8) | ((b2 & Base64.EQUALS_SIGN_ENC) << 8);
    }

    public final long zzt() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        this.zzb = i4 + 1;
        return ((((long) b2) & 255) << 16) | ((((long) b) & 255) << 24) | ((((long) b3) & 255) << 8) | (((long) bArr[i4]) & 255);
    }

    public final long zzu() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        this.zzb = i4 + 1;
        return ((((long) b2) & 255) << 8) | (((long) b) & 255) | ((((long) b3) & 255) << 16) | ((((long) bArr[i4]) & 255) << 24);
    }

    public final int zzv() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        this.zzb = i4 + 1;
        return (bArr[i4] & Base64.EQUALS_SIGN_ENC) | ((b & Base64.EQUALS_SIGN_ENC) << 24) | ((b2 & Base64.EQUALS_SIGN_ENC) << 16) | ((b3 & Base64.EQUALS_SIGN_ENC) << 8);
    }

    public final int zzw() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        this.zzb = i4 + 1;
        return ((bArr[i4] & Base64.EQUALS_SIGN_ENC) << 24) | (b & Base64.EQUALS_SIGN_ENC) | ((b2 & Base64.EQUALS_SIGN_ENC) << 8) | ((b3 & Base64.EQUALS_SIGN_ENC) << 16);
    }

    public final long zzx() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        int i5 = i4 + 1;
        this.zzb = i5;
        byte b4 = bArr[i4];
        int i6 = i5 + 1;
        this.zzb = i6;
        byte b5 = bArr[i5];
        int i7 = i6 + 1;
        this.zzb = i7;
        byte b6 = bArr[i6];
        int i8 = i7 + 1;
        this.zzb = i8;
        byte b7 = bArr[i7];
        this.zzb = i8 + 1;
        return ((((long) b2) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b6) & 255) << 16) | ((((long) b7) & 255) << 8) | (((long) bArr[i8]) & 255);
    }

    public final long zzy() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.zzb = i4;
        byte b3 = bArr[i3];
        int i5 = i4 + 1;
        this.zzb = i5;
        byte b4 = bArr[i4];
        int i6 = i5 + 1;
        this.zzb = i6;
        byte b5 = bArr[i5];
        int i7 = i6 + 1;
        this.zzb = i7;
        byte b6 = bArr[i6];
        int i8 = i7 + 1;
        this.zzb = i8;
        byte b7 = bArr[i7];
        this.zzb = i8 + 1;
        return ((((long) b2) & 255) << 8) | (((long) b) & 255) | ((((long) b3) & 255) << 16) | ((((long) b4) & 255) << 24) | ((((long) b5) & 255) << 32) | ((((long) b6) & 255) << 40) | ((((long) b7) & 255) << 48) | ((((long) bArr[i8]) & 255) << 56);
    }

    public final int zzz() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.zzb = i3;
        byte b2 = bArr[i2];
        this.zzb = i3 + 2;
        return (b2 & Base64.EQUALS_SIGN_ENC) | ((b & Base64.EQUALS_SIGN_ENC) << 8);
    }

    public zzakr(int i) {
        this.zza = new byte[i];
        this.zzc = i;
    }

    public zzakr(byte[] bArr) {
        this.zza = bArr;
        this.zzc = bArr.length;
    }
}
