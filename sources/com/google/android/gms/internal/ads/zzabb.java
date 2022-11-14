package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabb {
    public final MediaCodec zza;
    @Nullable
    public ByteBuffer[] zzb;
    @Nullable
    public ByteBuffer[] zzc;

    public /* synthetic */ zzabb(MediaCodec mediaCodec, zzaaz zzaaz) {
        this.zza = mediaCodec;
        if (zzalh.zza < 21) {
            this.zzb = mediaCodec.getInputBuffers();
            this.zzc = this.zza.getOutputBuffers();
        }
    }

    public final int zza() {
        return this.zza.dequeueInputBuffer(0);
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3) {
                if (zzalh.zza < 21) {
                    this.zzc = this.zza.getOutputBuffers();
                }
                dequeueOutputBuffer = -3;
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
    }

    @Nullable
    public final ByteBuffer zzd(int i) {
        if (zzalh.zza >= 21) {
            return this.zza.getInputBuffer(i);
        }
        return ((ByteBuffer[]) zzalh.zzd(this.zzb))[i];
    }

    @Nullable
    public final ByteBuffer zze(int i) {
        if (zzalh.zza >= 21) {
            return this.zza.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) zzalh.zzd(this.zzc))[i];
    }

    public final void zzf(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    public final void zzg(int i, int i2, zzrn zzrn, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzrn.zzb(), j, 0);
    }

    public final void zzh(int i, boolean z) {
        this.zza.releaseOutputBuffer(i, z);
    }

    @RequiresApi(21)
    public final void zzi(int i, long j) {
        this.zza.releaseOutputBuffer(i, j);
    }

    public final void zzj() {
        this.zza.flush();
    }

    public final void zzk() {
        this.zzb = null;
        this.zzc = null;
        this.zza.release();
    }

    @RequiresApi(23)
    public final void zzl(zzaaf zzaaf, Handler handler) {
        this.zza.setOnFrameRenderedListener(new zzaay(this, zzaaf), handler);
    }

    @RequiresApi(23)
    public final void zzm(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @RequiresApi(19)
    public final void zzn(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    public final void zzo(int i) {
        this.zza.setVideoScalingMode(i);
    }
}
