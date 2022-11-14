package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdz {
    public final Executor zza;
    public final zzcgx zzb;

    public zzfdz(Executor executor, zzcgx zzcgx) {
        this.zza = executor;
        this.zzb = zzcgx;
    }

    public final void zza(List<String> list) {
        for (String zzb2 : list) {
            zzb(zzb2);
        }
    }

    public final void zzb(String str) {
        this.zza.execute(new zzfdy(this, str));
    }

    public final /* synthetic */ void zzc(String str) {
        this.zzb.zza(str);
    }
}
