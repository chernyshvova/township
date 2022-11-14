package com.google.android.gms.internal.games_v2;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public abstract class zzak {
    public final AtomicReference<zzaj> zza = new AtomicReference<>();

    public abstract zzaj zza();

    public final void zzb() {
        zzaj zzaj = this.zza.get();
        if (zzaj != null) {
            zzaj.zzd();
        }
    }

    public final void zzc(String str, int i) {
        zzaj zzaj = this.zza.get();
        if (zzaj == null) {
            zzaj = zza();
            if (!this.zza.compareAndSet((Object) null, zzaj)) {
                zzaj = this.zza.get();
            }
        }
        zzaj.zzc(str, i);
    }
}
