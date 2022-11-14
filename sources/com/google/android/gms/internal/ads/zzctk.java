package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzctk implements zzbps<Object> {
    public final /* synthetic */ zzctn zza;

    public zzctk(zzctn zzctn) {
        this.zza = zzctn;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzctn.zze(this.zza, map)) {
            this.zza.zzc.execute(new zzctj(this));
        }
    }
}
