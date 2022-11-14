package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbz;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbpd implements zzbps {
    public static final zzbps zza = new zzbpd();

    public final void zza(Object obj, Map map) {
        zzcnt zzcnt = (zzcnt) obj;
        zzbps<zzcmr> zzbps = zzbpr.zza;
        String str = (String) map.get(AnalyticsEventKey.URL);
        if (str == null) {
            zzcgs.zzi("URL missing from httpTrack GMSG.");
        } else {
            new zzbz(zzcnt.getContext(), ((zzcob) zzcnt).zzt().zza, str).zzb();
        }
    }
}
