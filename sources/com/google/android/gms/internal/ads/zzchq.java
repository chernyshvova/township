package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzchq<T> {
    public final zzchj<T> zza = new zzchj<>();
    public final AtomicInteger zzb = new AtomicInteger(0);

    public zzchq() {
        zzfqe.zzp(this.zza, new zzcho(this), zzche.zzf);
    }

    @Deprecated
    public final void zze(zzchn<T> zzchn, zzchl zzchl) {
        zzfqe.zzp(this.zza, new zzchp(this, zzchn, zzchl), zzche.zzf);
    }

    @Deprecated
    public final void zzf(T t) {
        this.zza.zzc(t);
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final int zzh() {
        return this.zzb.get();
    }
}
