package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffa {
    @SuppressLint({"StaticFieldLeak"})
    public static final zzffa zza = new zzffa();
    public Context zzb;

    public static zzffa zza() {
        return zza;
    }

    public final Context zzb() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zzb = context != null ? context.getApplicationContext() : null;
    }
}
