package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfft {
    public JSONObject zza;
    public final zzfgc zzb;

    public zzfft(zzfgc zzfgc) {
        this.zzb = zzfgc;
    }

    public final void zza(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.zzb.zza(new zzfgf(this, hashSet, jSONObject, j, (long) null));
    }

    public final void zzb(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.zzb.zza(new zzfge(this, hashSet, jSONObject, j, (long) null));
    }

    public final void zzc() {
        this.zzb.zza(new zzfgd(this, (byte[]) null));
    }

    @VisibleForTesting
    public final JSONObject zzd() {
        return this.zza;
    }

    @VisibleForTesting
    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
