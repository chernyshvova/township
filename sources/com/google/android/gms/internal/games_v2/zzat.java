package com.google.android.gms.internal.games_v2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzat implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ zzau zza;
    public final Application zzb;
    public boolean zzc = false;

    public /* synthetic */ zzat(zzau zzau, Application application, zzas zzas) {
        this.zza = zzau;
        this.zzb = application;
    }

    public static /* bridge */ /* synthetic */ void zza(zzat zzat) {
        if (!zzat.zzc) {
            zzat.zzb.registerActivityLifecycleCallbacks(zzat);
            zzat.zzc = true;
        }
    }

    public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        this.zzb.unregisterActivityLifecycleCallbacks(this);
        if (this.zzc) {
            this.zzc = false;
            com.google.android.gms.games.internal.zzat.zza("AutomaticGamesAuthenticator", "Automatic connection attempt triggered");
            this.zza.zzc.zza();
        }
    }

    public final void onActivityDestroyed(@NonNull Activity activity) {
    }

    public final void onActivityPaused(@NonNull Activity activity) {
    }

    public final void onActivityResumed(@NonNull Activity activity) {
    }

    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public final void onActivityStarted(@NonNull Activity activity) {
    }

    public final void onActivityStopped(@NonNull Activity activity) {
    }
}
