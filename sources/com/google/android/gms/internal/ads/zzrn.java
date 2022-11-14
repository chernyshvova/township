package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzrn {
    @Nullable
    public byte[] zza;
    @Nullable
    public byte[] zzb;
    @Nullable
    public int[] zzc;
    @Nullable
    public int[] zzd;
    public final MediaCodec.CryptoInfo zze;
    @Nullable
    public final zzrm zzf;

    public zzrn() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.zze = cryptoInfo;
        this.zzf = zzalh.zza >= 24 ? new zzrm(cryptoInfo, (zzrl) null) : null;
    }

    public final void zza(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        MediaCodec.CryptoInfo cryptoInfo = this.zze;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (zzalh.zza >= 24) {
            zzrm zzrm = this.zzf;
            if (zzrm != null) {
                zzrm.zza(zzrm, i3, i4);
                return;
            }
            throw null;
        }
    }

    public final MediaCodec.CryptoInfo zzb() {
        return this.zze;
    }

    public final void zzc(int i) {
        if (i != 0) {
            if (this.zzc == null) {
                int[] iArr = new int[1];
                this.zzc = iArr;
                this.zze.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.zzc;
            iArr2[0] = iArr2[0] + i;
        }
    }
}
