package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzduz extends zzdvb {
    public final zzfdp zzf;

    public zzduz(Executor executor, zzcgx zzcgx, zzfdp zzfdp, zzfdr zzfdr) {
        super(executor, zzcgx, zzfdr);
        this.zzf = zzfdp;
        zzfdp.zza(this.zzb);
    }

    public final Map<String, String> zza() {
        return new HashMap(this.zzb);
    }
}
