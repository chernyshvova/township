package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzaoj {
    public AudioTrack zza;
    public boolean zzb;
    public int zzc;
    public long zzd;
    public long zze;
    public long zzf;
    public long zzg;
    public long zzh;
    public long zzi;

    public zzaoj() {
    }

    public /* synthetic */ zzaoj(zzaoi zzaoi) {
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zza = audioTrack;
        this.zzb = z;
        this.zzg = -9223372036854775807L;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        if (audioTrack != null) {
            this.zzc = audioTrack.getSampleRate();
        }
    }

    public final void zzb(long j) {
        this.zzh = zzd();
        this.zzg = SystemClock.elapsedRealtime() * 1000;
        this.zzi = j;
        this.zza.stop();
    }

    public final void zzc() {
        if (this.zzg == -9223372036854775807L) {
            this.zza.pause();
        }
    }

    public final long zzd() {
        if (this.zzg != -9223372036854775807L) {
            return Math.min(this.zzi, ((((SystemClock.elapsedRealtime() * 1000) - this.zzg) * ((long) this.zzc)) / 1000000) + this.zzh);
        }
        int playState = this.zza.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = ((long) this.zza.getPlaybackHeadPosition()) & 4294967295L;
        if (this.zzb) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzf = this.zzd;
            }
            playbackHeadPosition += this.zzf;
        }
        if (this.zzd > playbackHeadPosition) {
            this.zze++;
        }
        this.zzd = playbackHeadPosition;
        return playbackHeadPosition + (this.zze << 32);
    }

    public final long zze() {
        return (zzd() * 1000000) / ((long) this.zzc);
    }

    public boolean zzf() {
        return false;
    }

    public long zzg() {
        throw new UnsupportedOperationException();
    }

    public long zzh() {
        throw new UnsupportedOperationException();
    }
}
