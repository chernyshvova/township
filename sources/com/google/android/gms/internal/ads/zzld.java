package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzld implements zzkz {
    public final zzadq zza;
    public final Object zzb = new Object();
    public final List<zzadv> zzc = new ArrayList();
    public int zzd;
    public boolean zze;

    public zzld(zzadx zzadx, boolean z) {
        this.zza = new zzadq(zzadx, z);
    }

    public final Object zza() {
        return this.zzb;
    }

    public final zzmv zzb() {
        return this.zza.zzy();
    }

    public final void zzc(int i) {
        this.zzd = i;
        this.zze = false;
        this.zzc.clear();
    }
}
