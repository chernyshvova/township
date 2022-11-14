package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbkm {
    public MotionEvent zza = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    public MotionEvent zzb = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);
    public final Context zzc;
    public final ScheduledExecutorService zzd;
    public final zzbko zze;

    public zzbkm(Context context, ScheduledExecutorService scheduledExecutorService, zzbko zzbko, byte[] bArr) {
        this.zzc = context;
        this.zzd = scheduledExecutorService;
        this.zze = zzbko;
    }

    public final void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zza.getEventTime()) {
            this.zza = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.zzb.getEventTime()) {
            this.zzb = MotionEvent.obtain(motionEvent);
        }
    }

    public final zzfqn<String> zzb() {
        return (zzfpv) zzfqe.zzh(zzfpv.zzw(zzfqe.zza(null)), zzbkz.zzc.zze().longValue(), TimeUnit.MILLISECONDS, this.zzd);
    }
}
