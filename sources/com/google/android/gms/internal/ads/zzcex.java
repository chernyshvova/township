package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcex implements Callable {
    public final zzcfb zza;
    public final Context zzb;

    public zzcex(zzcfb zzcfb, Context context) {
        this.zza = zzcfb;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzt(this.zzb);
    }
}
