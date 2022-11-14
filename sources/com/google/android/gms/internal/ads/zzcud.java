package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcud implements zzgjg<JSONObject> {
    public final zzgju<zzeye> zza;

    public zzcud(zzgju<zzeye> zzgju) {
        this.zza = zzgju;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcxy) this.zza).zza().zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
