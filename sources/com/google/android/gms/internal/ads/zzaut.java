package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaut {
    public byte[] zza;
    public int zzb;
    public int zzc;

    public zzaut() {
    }

    public zzaut(int i) {
        this.zza = new byte[i];
        this.zzc = i;
    }

    public final void zza(int i) {
        zzb(zzh() < i ? new byte[i] : this.zza, i);
    }

    public final void zzb(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzc = i;
        this.zzb = 0;
    }

    public final void zzc() {
        this.zzb = 0;
        this.zzc = 0;
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
        zzaul.zza(z);
        this.zzc = i;
    }

    public final int zzg() {
        return this.zzb;
    }

    public final int zzh() {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final void zzi(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzc) {
            z = true;
        }
        zzaul.zza(z);
        this.zzb = i;
    }

    public final void zzj(int i) {
        zzi(this.zzb + i);
    }

    public final void zzk(byte[] bArr, int i, int i2) {
        System.arraycopy(this.zza, this.zzb, bArr, i, i2);
        this.zzb += i2;
    }

    public final int zzl() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        return bArr[i] & Base64.EQUALS_SIGN_ENC;
    }

    public final int zzm() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        this.zzb = i2 + 1;
        return (bArr[i2] & Base64.EQUALS_SIGN_ENC) | ((b & Base64.EQUALS_SIGN_ENC) << 8);
    }

    public final int zzn() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        this.zzb = i2 + 1;
        return ((bArr[i2] & Base64.EQUALS_SIGN_ENC) << 8) | (b & Base64.EQUALS_SIGN_ENC);
    }

    public final short zzo() {
        byte[] bArr = this.zza;
        int i = this.zzb;
        int i2 = i + 1;
        this.zzb = i2;
        byte b = bArr[i];
        this.zzb = i2 + 1;
        return (short) ((bArr[i2] & Base64.EQUALS_SIGN_ENC) | ((b & Base64.EQUALS_SIGN_ENC) << 8));
    }

    public final long zzp() {
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

    public final long zzq() {
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

    public final int zzr() {
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

    public final long zzs() {
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

    public final int zzt() {
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

    public final int zzu() {
        int zzr = zzr();
        if (zzr >= 0) {
            return zzr;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline9(29, "Top bit not zero: ", zzr));
    }

    public final long zzv() {
        long zzs = zzs();
        if (zzs >= 0) {
            return zzs;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(zzs);
        throw new IllegalStateException(sb.toString());
    }

    public final String zzw(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.zzb;
        int i3 = (i2 + i) - 1;
        String str = new String(this.zza, i2, (i3 >= this.zzc || this.zza[i3] != 0) ? i : i - 1);
        this.zzb += i;
        return str;
    }

    public zzaut(byte[] bArr) {
        this.zza = bArr;
        this.zzc = bArr.length;
    }
}
