package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzg implements Callable {
    public final zzt zza;
    public final List zzb;
    public final IObjectWrapper zzc;

    public zzg(zzt zzt, List list, IObjectWrapper iObjectWrapper) {
        this.zza = zzt;
        this.zzb = list;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzo(this.zzb, this.zzc);
    }
}
