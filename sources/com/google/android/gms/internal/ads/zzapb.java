package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzapb {
    public byte[] zza;
    public byte[] zzb;
    public int zzc;
    public int[] zzd;
    public int[] zze;
    public int zzf;
    public final MediaCodec.CryptoInfo zzg;
    public final zzapa zzh;

    public zzapb() {
        zzapa zzapa = null;
        MediaCodec.CryptoInfo cryptoInfo = zzava.zza >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzg = cryptoInfo;
        this.zzh = zzava.zza >= 24 ? new zzapa(cryptoInfo, (zzaoz) null) : zzapa;
    }

    public final void zza(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.zzf = i;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = 1;
        int i3 = zzava.zza;
        if (i3 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.zzg;
            cryptoInfo.numSubSamples = i;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = 1;
            if (i3 >= 24) {
                zzapa.zza(this.zzh, 0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzb() {
        return this.zzg;
    }
}
