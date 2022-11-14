package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcor {
    public zzcgy zza;
    public Context zzb;
    public WeakReference<Context> zzc;

    public final zzcor zza(zzcgy zzcgy) {
        this.zza = zzcgy;
        return this;
    }

    public final zzcor zzb(Context context) {
        this.zzc = new WeakReference<>(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzb = context;
        return this;
    }
}
