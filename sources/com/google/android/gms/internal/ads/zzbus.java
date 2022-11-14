package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbus implements zzbqf {
    public final /* synthetic */ zzbut zza;
    public final zzchj zzb;

    public zzbus(zzbut zzbut, zzchj zzchj) {
        this.zza = zzbut;
        this.zzb = zzchj;
    }

    public final void zza(JSONObject jSONObject) {
        try {
            this.zzb.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzb.zzd(e);
        }
    }

    public final void zzb(@Nullable String str) {
        if (str == null) {
            try {
                this.zzb.zzd(new zzbtw());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzb.zzd(new zzbtw(str));
        }
    }
}
