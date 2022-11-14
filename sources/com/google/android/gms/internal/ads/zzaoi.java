package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaoi extends Thread {
    public final /* synthetic */ AudioTrack zza;
    public final /* synthetic */ zzaoq zzb;

    public zzaoi(zzaoq zzaoq, AudioTrack audioTrack) {
        this.zzb = zzaoq;
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
