package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzay implements Application.ActivityLifecycleCallbacks {
    public final Activity zza;
    public final /* synthetic */ zzat zzb;

    public zzay(zzat zzat, Activity activity) {
        this.zzb = zzat;
        this.zza = activity;
    }

    /* access modifiers changed from: private */
    public final void zza() {
        this.zzb.zza.unregisterActivityLifecycleCallbacks(this);
    }

    public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    public final void onActivityDestroyed(@NonNull Activity activity) {
        if (activity == this.zza) {
            this.zzb.zzb(new zzk(3, "Activity is destroyed."));
        }
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
