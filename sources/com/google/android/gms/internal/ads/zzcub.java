package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcub implements Runnable {
    public final zzcuc zza;
    public final JSONObject zzb;

    public zzcub(zzcuc zzcuc, JSONObject jSONObject) {
        this.zza = zzcuc;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
