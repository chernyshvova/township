package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzfgk implements Callable {
    public final Context zza;
    public final boolean zzb;

    public zzfgk(Context context, boolean z) {
        this.zza = context;
        this.zzb = z;
    }

    public final Object call() {
        return new zzfit(this.zza, true != this.zzb ? "" : "GLAS", (String) null);
    }
}
