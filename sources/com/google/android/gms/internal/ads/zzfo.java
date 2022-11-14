package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfo implements Application.ActivityLifecycleCallbacks {
    public final Application zza;
    public final WeakReference<Application.ActivityLifecycleCallbacks> zzb;
    public boolean zzc = false;

    public zzfo(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference<>(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzfg(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzfm(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzfj(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzfi(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzfl(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzfh(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzfk(this, activity));
    }

    public final void zza(zzfn zzfn) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzfn.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception unused) {
        }
    }
}
