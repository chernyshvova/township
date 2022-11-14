package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpv {
    public boolean zza = false;
    public boolean zzb = false;
    public float zzc = 0.0f;
    public final AtomicBoolean zzd = new AtomicBoolean(false);

    public final synchronized void zza(boolean z) {
        this.zza = z;
        this.zzd.set(true);
    }

    public final synchronized void zzb(boolean z, float f) {
        this.zzb = z;
        this.zzc = f;
    }

    public final synchronized boolean zzc(boolean z) {
        if (!this.zzd.get()) {
            return z;
        }
        return this.zza;
    }

    public final synchronized boolean zzd() {
        return this.zzb;
    }

    public final synchronized float zze() {
        return this.zzc;
    }
}
