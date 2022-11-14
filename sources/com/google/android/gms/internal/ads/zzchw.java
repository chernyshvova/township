package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzchw implements Runnable {
    public final /* synthetic */ MediaPlayer zza;
    public final /* synthetic */ zzcie zzb;

    public zzchw(zzcie zzcie, MediaPlayer mediaPlayer) {
        this.zzb = zzcie;
        this.zza = mediaPlayer;
    }

    public final void run() {
        zzcie.zzs(this.zzb, this.zza);
        if (this.zzb.zzs != null) {
            this.zzb.zzs.zzb();
        }
    }
}
