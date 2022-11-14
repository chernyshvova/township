package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfav {
    public final HashMap<zzfal, zzfau<?, ?>> zza = new HashMap<>();

    public final <R extends zzdam<AdT>, AdT extends zzcxi> zzfau<R, AdT> zza(zzfal zzfal, Context context, zzfad zzfad, zzfbb<R, AdT> zzfbb) {
        zzfau<R, AdT> zzfau = this.zza.get(zzfal);
        if (zzfau != null) {
            return zzfau;
        }
        zzfai zzfai = new zzfai(zzfao.zza(zzfal, context));
        zzfau<R, AdT> zzfau2 = new zzfau<>(zzfai, new zzfbd(zzfai, zzfad, zzfbb));
        this.zza.put(zzfal, zzfau2);
        return zzfau2;
    }
}
