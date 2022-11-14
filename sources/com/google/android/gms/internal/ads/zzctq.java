package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzctq implements Runnable {
    public final zzcmr zza;
    public final JSONObject zzb;

    public zzctq(zzcmr zzcmr, JSONObject jSONObject) {
        this.zza = zzcmr;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzr("AFMA_updateActiveView", this.zzb);
    }
}
