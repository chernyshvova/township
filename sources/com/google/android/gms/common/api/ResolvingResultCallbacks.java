package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    public final Activity zza;
    public final int zzb;

    public ResolvingResultCallbacks(@RecentlyNonNull Activity activity, int i) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zza = activity;
        this.zzb = i;
    }

    @KeepForSdk
    public final void onFailure(@RecentlyNonNull Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(this.zza, this.zzb);
            } catch (IntentSender.SendIntentException e) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                onUnresolvableFailure(new Status(8));
            }
        } else {
            onUnresolvableFailure(status);
        }
    }

    public abstract void onSuccess(@RecentlyNonNull R r);

    public abstract void onUnresolvableFailure(@RecentlyNonNull Status status);
}
