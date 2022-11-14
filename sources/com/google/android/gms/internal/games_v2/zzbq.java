package com.google.android.gms.internal.games_v2;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.zzg;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzbq {
    public static final AtomicReference<zzbq> zza = new AtomicReference<>();
    public final Application zzb;
    public final zzau zzc;
    public final zzg zzd;

    public zzbq(Application application, zzau zzau, zzg zzg) {
        this.zzb = application;
        this.zzc = zzau;
        this.zzd = zzg;
    }

    public static Application zza() {
        zzb();
        return zza.get().zzb;
    }

    public static void zzb() {
        Preconditions.checkState(zza.get() != null, "PlayGamesSdk has not been initialized. Ensure that PlayGamesSdk.initialize() has been called.");
    }

    public static void zzc(@NonNull Context context) {
        Application application;
        Preconditions.checkArgument(context != null);
        if (zza.get() == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                application = (Application) applicationContext;
            } else {
                application = (Application) context;
            }
            zzbq zzbq = new zzbq(application, zzau.zza(application), zzg.zzb(application));
            if (zza.compareAndSet((Object) null, zzbq)) {
                zzbq.zzc.zzc();
                zzbq.zzd.zzh();
            }
        }
    }
}
