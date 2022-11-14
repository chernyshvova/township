package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgcx extends OutputStream {
    public static final byte[] zza = new byte[0];
    public final int zzb = 128;
    public final ArrayList<zzgcz> zzc = new ArrayList<>();
    public int zzd;
    public byte[] zze = new byte[128];
    public int zzf;

    public zzgcx(int i) {
    }

    private final void zzc(int i) {
        this.zzc.add(new zzgcw(this.zze));
        int length = this.zzd + this.zze.length;
        this.zzd = length;
        this.zze = new byte[Math.max(this.zzb, Math.max(i, length >>> 1))];
        this.zzf = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzb())});
    }

    public final synchronized void write(int i) {
        if (this.zzf == this.zze.length) {
            zzc(1);
        }
        byte[] bArr = this.zze;
        int i2 = this.zzf;
        this.zzf = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final synchronized zzgcz zza() {
        int i = this.zzf;
        byte[] bArr = this.zze;
        int length = bArr.length;
        if (i >= length) {
            this.zzc.add(new zzgcw(bArr));
            this.zze = zza;
        } else if (i > 0) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(length, i));
            this.zzc.add(new zzgcw(bArr2));
        }
        this.zzd += this.zzf;
        this.zzf = 0;
        return zzgcz.zzx(this.zzc);
    }

    public final synchronized int zzb() {
        return this.zzd + this.zzf;
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        int i3 = this.zzf;
        int i4 = length - i3;
        if (i2 <= i4) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.zzf += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i3, i4);
        int i5 = i2 - i4;
        zzc(i5);
        System.arraycopy(bArr, i + i4, this.zze, 0, i5);
        this.zzf = i5;
    }
}
