package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawm implements Application.ActivityLifecycleCallbacks {
    public final Application zza;
    public final WeakReference<Application.ActivityLifecycleCallbacks> zzb;
    public boolean zzc = false;

    public zzawm(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference<>(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzawe(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzawk(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzawh(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzawg(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzawj(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzawf(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzawi(this, activity));
    }

    public final void zza(zzawl zzawl) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzawl.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception e) {
            zzcgs.zzg("Error while dispatching lifecycle callback.", e);
        }
    }
}
