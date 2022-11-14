package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpj implements zzbps<zzcmr> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmr zzcmr = (zzcmr) obj;
        if (zzcmr.zzay() != null) {
            zzcmr.zzay().zza();
        }
        zzl zzN = zzcmr.zzN();
        if (zzN != null) {
            zzN.zzb();
            return;
        }
        zzl zzO = zzcmr.zzO();
        if (zzO != null) {
            zzO.zzb();
        } else {
            zzcgs.zzi("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
