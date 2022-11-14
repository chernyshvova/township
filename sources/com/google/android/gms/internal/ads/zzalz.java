package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalz implements Choreographer.FrameCallback, Handler.Callback {
    public static final zzalz zzb = new zzalz();
    public volatile long zza = -9223372036854775807L;
    public final Handler zzc;
    public final HandlerThread zzd;
    public Choreographer zze;
    public int zzf;

    public zzalz() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        this.zzd = handlerThread;
        handlerThread.start();
        Handler zzi = zzalh.zzi(this.zzd.getLooper(), this);
        this.zzc = zzi;
        zzi.sendEmptyMessage(0);
    }

    public static zzalz zza() {
        return zzb;
    }

    public final void doFrame(long j) {
        this.zza = j;
        Choreographer choreographer = this.zze;
        if (choreographer != null) {
            choreographer.postFrameCallbackDelayed(this, 500);
            return;
        }
        throw null;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.zze = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            int i2 = this.zzf + 1;
            this.zzf = i2;
            if (i2 == 1) {
                Choreographer choreographer = this.zze;
                if (choreographer != null) {
                    choreographer.postFrameCallback(this);
                } else {
                    throw null;
                }
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i3 = this.zzf - 1;
            this.zzf = i3;
            if (i3 == 0) {
                Choreographer choreographer2 = this.zze;
                if (choreographer2 != null) {
                    choreographer2.removeFrameCallback(this);
                    this.zza = -9223372036854775807L;
                } else {
                    throw null;
                }
            }
            return true;
        }
    }

    public final void zzb() {
        this.zzc.sendEmptyMessage(1);
    }

    public final void zzc() {
        this.zzc.sendEmptyMessage(2);
    }
}
