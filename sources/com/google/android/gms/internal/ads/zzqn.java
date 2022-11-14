package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqn extends Thread {
    public final /* synthetic */ AudioTrack zza;
    public final /* synthetic */ zzqw zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzqn(zzqw zzqw, String str, AudioTrack audioTrack) {
        super("ExoPlayer:AudioTrackReleaseThread");
        this.zzb = zzqw;
        this.zza = audioTrack;
    }

    public final void run() {
        try {
            this.zza.flush();
            this.zza.release();
        } finally {
            this.zzb.zze.open();
        }
    }
}
