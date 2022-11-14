package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzean implements Callable {
    public final zzfqn zza;
    public final zzfqn zzb;
    public final zzfqn zzc;

    public zzean(zzfqn zzfqn, zzfqn zzfqn2, zzfqn zzfqn3) {
        this.zza = zzfqn;
        this.zzb = zzfqn2;
        this.zzc = zzfqn3;
    }

    public final Object call() {
        return new zzeba((zzebe) this.zza.get(), (JSONObject) this.zzb.get(), (zzcbn) this.zzc.get());
    }
}
