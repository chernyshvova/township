package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfde {
    public final Executor zza;
    public final zzcgx zzb;

    public zzfde(Executor executor, zzcgx zzcgx) {
        this.zza = executor;
        this.zzb = zzcgx;
    }

    public final void zza(String str) {
        this.zza.execute(new zzfdd(this, str));
    }

    public final /* synthetic */ void zzb(String str) {
        this.zzb.zza(str);
    }
}
