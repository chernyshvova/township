package com.google.android.gms.internal.games_v2;

import android.app.Application;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzar {
    public final zzav zza;

    public zzar(zzav zzav) {
        this.zza = zzav;
    }

    public static zzar zza(Application application) {
        return new zzar(zzax.zza(application));
    }

    public final <T> Task<T> zzb(zzaq<T> zzaq) {
        zzav zzav = this.zza;
        zzaq.getClass();
        return zzav.zzd(new zzap(zzaq));
    }
}
