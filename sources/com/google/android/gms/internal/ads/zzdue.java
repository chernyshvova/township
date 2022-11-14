package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdue implements zzfcy {
    public final Map<zzfcr, zzdud> zza;
    public final zzayx zzb;

    public zzdue(zzayx zzayx, Map<zzfcr, zzdud> map) {
        this.zza = map;
        this.zzb = zzayx;
    }

    public final void zzbV(zzfcr zzfcr, String str) {
    }

    public final void zzbW(zzfcr zzfcr, String str) {
        if (this.zza.containsKey(zzfcr)) {
            this.zzb.zzb(this.zza.get(zzfcr).zza);
        }
    }

    public final void zzbX(zzfcr zzfcr, String str, Throwable th) {
        if (this.zza.containsKey(zzfcr)) {
            this.zzb.zzb(this.zza.get(zzfcr).zzc);
        }
    }

    public final void zzbY(zzfcr zzfcr, String str) {
        if (this.zza.containsKey(zzfcr)) {
            this.zzb.zzb(this.zza.get(zzfcr).zzb);
        }
    }
}
