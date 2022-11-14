package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbuk implements zzbqf {
    public final /* synthetic */ zzbul zza;
    public final zzbtn zzb;
    public final zzchj zzc;

    public zzbuk(zzbul zzbul, zzbtn zzbtn, zzchj zzchj) {
        this.zza = zzbul;
        this.zzb = zzbtn;
        this.zzc = zzchj;
    }

    public final void zza(JSONObject jSONObject) {
        zzbtn zzbtn;
        try {
            this.zzc.zzc(this.zza.zza.zza(jSONObject));
            zzbtn = this.zzb;
        } catch (IllegalStateException unused) {
            zzbtn = this.zzb;
        } catch (JSONException e) {
            this.zzc.zzd(e);
            zzbtn = this.zzb;
        } catch (Throwable th) {
            this.zzb.zza();
            throw th;
        }
        zzbtn.zza();
    }

    public final void zzb(@Nullable String str) {
        zzbtn zzbtn;
        if (str == null) {
            try {
                this.zzc.zzd(new zzbtw());
            } catch (IllegalStateException unused) {
                zzbtn = this.zzb;
            } catch (Throwable th) {
                this.zzb.zza();
                throw th;
            }
        } else {
            this.zzc.zzd(new zzbtw(str));
        }
        zzbtn = this.zzb;
        zzbtn.zza();
    }
}
