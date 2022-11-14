package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Handler;
import androidx.annotation.RequiresApi;

@RequiresApi(29)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqv {
    public final /* synthetic */ zzqw zza;
    public final Handler zzb = new Handler();
    public final AudioTrack.StreamEventCallback zzc;

    public zzqv(zzqw zzqw) {
        this.zza = zzqw;
        this.zzc = new zzqu(this, zzqw);
    }

    public final void zza(AudioTrack audioTrack) {
        audioTrack.registerStreamEventCallback(zzqt.zza(this.zzb), this.zzc);
    }

    public final void zzb(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.zzc);
        this.zzb.removeCallbacksAndMessages((Object) null);
    }
}
