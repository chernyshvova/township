package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzaay implements MediaCodec.OnFrameRenderedListener {
    public final zzabb zza;
    public final zzaaf zzb;

    public zzaay(zzabb zzabb, zzaaf zzaaf) {
        this.zza = zzabb;
        this.zzb = zzaaf;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        this.zzb.zza(this.zza, j, j2);
    }
}
