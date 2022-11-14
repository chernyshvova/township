package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeam implements Callable {
    public final zzfqn zza;
    public final zzfqn zzb;

    public zzeam(zzfqn zzfqn, zzfqn zzfqn2) {
        this.zza = zzfqn;
        this.zzb = zzfqn2;
    }

    public final Object call() {
        return new zzebh((JSONObject) this.zza.get(), (zzcbn) this.zzb.get());
    }
}
