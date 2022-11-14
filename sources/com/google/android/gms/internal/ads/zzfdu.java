package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdu implements zzfdh {
    public final zzfdr zza;
    public final zzfdp zzb;

    public zzfdu(zzfdr zzfdr, zzfdp zzfdp) {
        this.zza = zzfdr;
        this.zzb = zzfdp;
    }

    public final void zza(zzfdg zzfdg) {
    }

    public final String zzb(zzfdg zzfdg) {
        zzfdr zzfdr = this.zza;
        Map<String, String> zzj = zzfdg.zzj();
        this.zzb.zza(zzj);
        return zzfdr.zza(zzj);
    }
}
