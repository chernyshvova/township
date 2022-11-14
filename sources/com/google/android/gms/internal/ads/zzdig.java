package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdig {
    public final List<String> zza;
    public final zzfdz zzb;
    public boolean zzc;

    public zzdig(zzeye zzeye, zzfdz zzfdz) {
        this.zza = zzeye.zzp;
        this.zzb = zzfdz;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zza(this.zza);
            this.zzc = true;
        }
    }
}
