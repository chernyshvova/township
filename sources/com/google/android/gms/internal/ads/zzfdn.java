package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdn implements zzfdh {
    public final zzfdr zza;
    public final zzfdp zzb;
    public final zzfde zzc;

    public zzfdn(zzfde zzfde, zzfdr zzfdr, zzfdp zzfdp, byte[] bArr) {
        this.zzc = zzfde;
        this.zza = zzfdr;
        this.zzb = zzfdp;
    }

    public final void zza(zzfdg zzfdg) {
        this.zzc.zza(zzb(zzfdg));
    }

    public final String zzb(zzfdg zzfdg) {
        zzfdr zzfdr = this.zza;
        Map<String, String> zzj = zzfdg.zzj();
        this.zzb.zza(zzj);
        return zzfdr.zza(zzj);
    }
}
