package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzhy {
    public final Context zza;
    public final zzhw zzb;

    public zzhy(Context context, Handler handler, zzhx zzhx) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzhw(this, handler, zzhx);
    }
}
