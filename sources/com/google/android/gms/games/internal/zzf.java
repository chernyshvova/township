package com.google.android.gms.games.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzf implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ zzg zza;

    public /* synthetic */ zzf(zzg zzg, zze zze) {
        this.zza = zzg;
    }

    public final void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
        zzg.zzd(this.zza, activity);
    }

    public final void onActivityDestroyed(Activity activity) {
        zzg.zze(this.zza, activity);
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        zzg.zzd(this.zza, activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
