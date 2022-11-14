package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdyg implements Callable {
    public final zzfb zza;
    public final Context zzb;

    public zzdyg(zzfb zzfb, Context context) {
        this.zza = zzfb;
        this.zzb = context;
    }

    public final Object call() {
        zzfb zzfb = this.zza;
        return zzfb.zzb().zzj(this.zzb);
    }
}
