package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzapa {
    public final MediaCodec.CryptoInfo zza;
    public final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    public /* synthetic */ zzapa(MediaCodec.CryptoInfo cryptoInfo, zzaoz zzaoz) {
        this.zza = cryptoInfo;
    }

    public static /* synthetic */ void zza(zzapa zzapa, int i, int i2) {
        zzapa.zzb.set(0, 0);
        zzapa.zza.setPattern(zzapa.zzb);
    }
}
