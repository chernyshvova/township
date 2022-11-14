package com.google.android.gms.internal.ads;

import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbpc implements zzbps {
    public static final zzbps zza = new zzbpc();

    public final void zza(Object obj, Map map) {
        zzcmr zzcmr = (zzcmr) obj;
        zzbps<zzcmr> zzbps = zzbpr.zza;
        String str = (String) map.get(AnalyticsEventKey.URL);
        if (str == null) {
            zzcgs.zzi("URL missing from click GMSG.");
        } else {
            zzfqe.zzp(zzbpr.zza(zzcmr, str), new zzbpi(zzcmr), zzche.zza);
        }
    }
}
