package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzegg implements Callable {
    public final zzegh zza;
    public final zzfqn zzb;
    public final zzfqn zzc;
    public final zzeyq zzd;
    public final zzeye zze;
    public final JSONObject zzf;

    public zzegg(zzegh zzegh, zzfqn zzfqn, zzfqn zzfqn2, zzeyq zzeyq, zzeye zzeye, JSONObject jSONObject) {
        this.zza = zzegh;
        this.zzb = zzfqn;
        this.zzc = zzfqn2;
        this.zzd = zzeyq;
        this.zze = zzeye;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
