package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzfhc implements OnFailureListener {
    public final zzfhg zza;

    public zzfhc(zzfhg zzfhg) {
        this.zza = zzfhg;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzd(exc);
    }
}
