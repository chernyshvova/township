package com.google.android.gms.internal.games_v2;

import android.app.Application;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.p034v2.resolution.zzb;
import com.google.android.gms.games.internal.zzg;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzax {
    public static final AtomicReference<zzav> zza = new AtomicReference<>();

    public static zzav zza(Application application) {
        zzav zzav = zza.get();
        if (zzav != null) {
            return zzav;
        }
        zzo zza2 = zzq.zza();
        zza2.zza(9);
        zza2.zzb(application.getPackageName());
        zzq zzc = zza2.zzc();
        zzg zzb = zzg.zzb(application);
        zza.compareAndSet((Object) null, new zzbk(application, zzb, zzb.zza(), new zzbo(application, zzb, new zzaw(application, zzc), (byte[]) null), (byte[]) null));
        return (zzav) Preconditions.checkNotNull(zza.get());
    }
}
