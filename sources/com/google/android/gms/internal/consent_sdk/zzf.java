package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final /* synthetic */ class zzf implements Callable {
    public final zzi zza;
    public final String zzb;
    public final JSONObject zzc;

    public zzf(zzi zzi, String str, JSONObject jSONObject) {
        this.zza = zzi;
        this.zzb = str;
        this.zzc = jSONObject;
    }

    public final Object call() {
        return Boolean.valueOf(this.zza.zza(this.zzb, this.zzc));
    }
}
