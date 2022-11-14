package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgct extends zzgcw {
    public final int zzc;
    public final int zzd;

    public zzgct(byte[] bArr, int i, int i2) {
        super(bArr);
        zzgcz.zzE(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    public final byte zza(int i) {
        zzgcz.zzD(i, this.zzd);
        return this.zza[this.zzc + i];
    }

    public final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    public final int zzc() {
        return this.zzd;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, this.zzc + i, bArr, i2, i3);
    }
}
