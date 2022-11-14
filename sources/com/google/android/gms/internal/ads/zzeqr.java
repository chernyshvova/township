package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeqr implements Callable {
    public final List zza;
    public final Object zzb;

    public zzeqr(List list, Object obj) {
        this.zza = list;
        this.zzb = obj;
    }

    public final Object call() {
        List<zzfqn> list = this.zza;
        Object obj = this.zzb;
        for (zzfqn zzfqn : list) {
            zzeqo zzeqo = (zzeqo) zzfqn.get();
            if (zzeqo != null) {
                zzeqo.zzd(obj);
            }
        }
        return obj;
    }
}
