package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcet implements zzcfa {
    public final Context zza;
    public final String zzb;

    public zzcet(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    public final void zza(zzcoj zzcoj) {
        Context context = this.zza;
        zzcoj.zzq(ObjectWrapper.wrap(context), this.zzb, context.getPackageName());
    }
}
