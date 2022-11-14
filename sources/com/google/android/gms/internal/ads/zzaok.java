package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaok extends zzaoj {
    public final AudioTimestamp zzb = new AudioTimestamp();
    public long zzc;
    public long zzd;
    public long zze;

    public zzaok() {
        super((zzaoi) null);
    }

    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzf() {
        boolean timestamp = this.zza.getTimestamp(this.zzb);
        if (timestamp) {
            long j = this.zzb.framePosition;
            if (this.zzd > j) {
                this.zzc++;
            }
            this.zzd = j;
            this.zze = j + (this.zzc << 32);
        }
        return timestamp;
    }

    public final long zzg() {
        return this.zzb.nanoTime;
    }

    public final long zzh() {
        return this.zze;
    }
}
