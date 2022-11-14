package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcfw {
    public final zzfqn<AdvertisingIdClient.Info> zza(Context context, int i) {
        zzchj zzchj = new zzchj();
        zzbev.zza();
        if (zzcgl.zzo(context)) {
            zzche.zza.execute(new zzcfv(this, context, zzchj));
        }
        return zzchj;
    }
}
