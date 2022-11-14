package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfei {
    public final zzfep zza;
    public final zzfep zzb;
    public final zzfem zzc;
    public final zzfeo zzd;

    public zzfei(zzfem zzfem, zzfeo zzfeo, zzfep zzfep, zzfep zzfep2, boolean z) {
        this.zzc = zzfem;
        this.zzd = zzfeo;
        this.zza = zzfep;
        if (zzfep2 == null) {
            this.zzb = zzfep.NONE;
        } else {
            this.zzb = zzfep2;
        }
    }

    public static zzfei zza(zzfem zzfem, zzfeo zzfeo, zzfep zzfep, zzfep zzfep2, boolean z) {
        zzffp.zza(zzfeo, "ImpressionType is null");
        zzffp.zza(zzfep, "Impression owner is null");
        zzffp.zzc(zzfep, zzfem, zzfeo);
        return new zzfei(zzfem, zzfeo, zzfep, zzfep2, true);
    }

    @Deprecated
    public static zzfei zzb(zzfep zzfep, zzfep zzfep2, boolean z) {
        zzffp.zza(zzfep, "Impression owner is null");
        zzffp.zzc(zzfep, (zzfem) null, (zzfeo) null);
        return new zzfei((zzfem) null, (zzfeo) null, zzfep, zzfep2, true);
    }

    public final JSONObject zzc() {
        JSONObject jSONObject = new JSONObject();
        zzffn.zzc(jSONObject, "impressionOwner", this.zza);
        if (this.zzc == null || this.zzd == null) {
            zzffn.zzc(jSONObject, "videoEventsOwner", this.zzb);
        } else {
            zzffn.zzc(jSONObject, "mediaEventsOwner", this.zzb);
            zzffn.zzc(jSONObject, "creativeType", this.zzc);
            zzffn.zzc(jSONObject, "impressionType", this.zzd);
        }
        zzffn.zzc(jSONObject, "isolateVerificationScripts", Boolean.TRUE);
        return jSONObject;
    }
}
