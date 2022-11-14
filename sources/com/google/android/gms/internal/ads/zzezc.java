package com.google.android.gms.internal.ads;

import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzezc implements zzbps {
    public final zzfdz zza;
    public final zzedb zzb;

    public zzezc(zzfdz zzfdz, zzedb zzedb) {
        this.zza = zzfdz;
        this.zzb = zzedb;
    }

    public final void zza(Object obj, Map map) {
        zzfdz zzfdz = this.zza;
        zzedb zzedb = this.zzb;
        zzcmr zzcmr = (zzcmr) obj;
        String str = (String) map.get(AnalyticsEventKey.URL);
        if (str == null) {
            zzcgs.zzi("URL missing from click GMSG.");
        } else {
            zzfqe.zzp(zzbpr.zza(zzcmr, str), new zzeze(zzcmr, zzfdz, zzedb), zzche.zza);
        }
    }
}
