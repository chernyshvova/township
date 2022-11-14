package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzctn {
    public final String zza;
    public final zzbuq zzb;
    public final Executor zzc;
    public zzcts zzd;
    public final zzbps<Object> zze = new zzctk(this);
    public final zzbps<Object> zzf = new zzctm(this);

    public zzctn(String str, zzbuq zzbuq, Executor executor) {
        this.zza = str;
        this.zzb = zzbuq;
        this.zzc = executor;
    }

    public static /* synthetic */ boolean zze(zzctn zzctn, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(zzctn.zza);
    }

    public final void zza(zzcts zzcts) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcts;
    }

    public final void zzb(zzcmr zzcmr) {
        zzcmr.zzab("/updateActiveView", this.zze);
        zzcmr.zzab("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzc(zzcmr zzcmr) {
        zzcmr.zzac("/updateActiveView", this.zze);
        zzcmr.zzac("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzd() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }
}
