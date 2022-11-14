package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzarm implements zzark {
    public final int zza;
    public MediaCodecInfo[] zzb;

    public zzarm(boolean z) {
        this.zza = z ? 1 : 0;
    }

    private final void zze() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    public final int zza() {
        zze();
        return this.zzb.length;
    }

    public final MediaCodecInfo zzb(int i) {
        zze();
        return this.zzb[i];
    }

    public final boolean zzc() {
        return true;
    }

    public final boolean zzd(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }
}
