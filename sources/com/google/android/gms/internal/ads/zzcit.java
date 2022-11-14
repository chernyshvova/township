package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.util.zzr;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcit {
    public final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) zzbex.zzc().zzb(zzbjn.zzy)).longValue());
    public long zzb;
    public boolean zzc = true;

    public final void zza() {
        this.zzc = true;
    }

    public final void zzb(SurfaceTexture surfaceTexture, zzcif zzcif) {
        if (zzcif != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzc || Math.abs(timestamp - this.zzb) >= this.zza) {
                this.zzc = false;
                this.zzb = timestamp;
                zzr.zza.post(new zzcis(this, zzcif));
            }
        }
    }
}
