package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqo {
    public final zzkc zza;
    public final int zzb;
    public final int zzc = 0;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzpn[] zzi;

    public zzqo(zzkc zzkc, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, zzpn[] zzpnArr) {
        this.zza = zzkc;
        this.zzb = i;
        boolean z2 = false;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzi = zzpnArr;
        int minBufferSize = AudioTrack.getMinBufferSize(i4, i5, i6);
        zzajg.zzd(minBufferSize != -2 ? true : z2);
        this.zzh = zzalh.zzx(minBufferSize * 4, ((int) zzb(250000)) * this.zzd, Math.max(minBufferSize, ((int) zzb(750000)) * this.zzd));
    }

    @RequiresApi(21)
    public static AudioAttributes zzd(zzpi zzpi, boolean z) {
        if (z) {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }
        return zzpi.zza();
    }

    public final long zza(long j) {
        return (j * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j) {
        return (j * ((long) this.zze)) / 1000000;
    }

    public final AudioTrack zzc(boolean z, zzpi zzpi, int i) throws zzqb {
        AudioTrack audioTrack;
        try {
            if (zzalh.zza >= 29) {
                audioTrack = new AudioTrack.Builder().setAudioAttributes(zzd(zzpi, z)).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.zze).setChannelMask(this.zzf).setEncoding(this.zzg).build()).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i).setOffloadedPlayback(false).build();
            } else if (zzalh.zza >= 21) {
                audioTrack = new AudioTrack(zzd(zzpi, z), new AudioFormat.Builder().setSampleRate(this.zze).setChannelMask(this.zzf).setEncoding(this.zzg).build(), this.zzh, 1, i);
            } else {
                int i2 = zzpi.zzb;
                if (i == 0) {
                    audioTrack = new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1);
                } else {
                    audioTrack = new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1, i);
                }
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzqb(state, this.zze, this.zzf, this.zzh, this.zza, false, (Exception) null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new zzqb(0, this.zze, this.zzf, this.zzh, this.zza, false, e);
        }
    }
}
