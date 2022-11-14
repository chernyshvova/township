package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.RequiresApi;

@RequiresApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzrm {
    public final MediaCodec.CryptoInfo zza;
    public final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    public /* synthetic */ zzrm(MediaCodec.CryptoInfo cryptoInfo, zzrl zzrl) {
        this.zza = cryptoInfo;
    }

    public static /* synthetic */ void zza(zzrm zzrm, int i, int i2) {
        zzrm.zzb.set(i, i2);
        zzrm.zza.setPattern(zzrm.zzb);
    }
}
