package com.google.android.gms.internal.games_v2;

import android.app.Application;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.zzat;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzau {
    public static final AtomicReference<zzau> zza = new AtomicReference<>();
    public final zzat zzb;
    public final zzav zzc;

    public zzau(Application application, zzav zzav) {
        this.zzb = new zzat(this, application, (zzas) null);
        this.zzc = zzav;
    }

    public static zzau zza(Application application) {
        zzau zzau = zza.get();
        if (zzau != null) {
            return zzau;
        }
        zza.compareAndSet((Object) null, new zzau(application, zzax.zza(application)));
        return (zzau) Preconditions.checkNotNull(zza.get());
    }

    public final void zzc() {
        zzat.zza("AutomaticGamesAuthenticator", "startWatching()");
        zzat.zza(this.zzb);
    }
}
