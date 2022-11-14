package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqg {
    public final AudioTrack zza;
    public final AudioTimestamp zzb = new AudioTimestamp();
    public long zzc;
    public long zzd;
    public long zze;

    public zzqg(AudioTrack audioTrack) {
        this.zza = audioTrack;
    }

    public final boolean zza() {
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

    public final long zzb() {
        return this.zzb.nanoTime / 1000;
    }

    public final long zzc() {
        return this.zze;
    }
}
