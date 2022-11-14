package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzezd implements zzbps {
    public final zzfdz zza;
    public final zzedb zzb;

    public zzezd(zzfdz zzfdz, zzedb zzedb) {
        this.zza = zzfdz;
        this.zzb = zzedb;
    }

    public final void zza(Object obj, Map map) {
        zzfdz zzfdz = this.zza;
        zzedb zzedb = this.zzb;
        zzcmi zzcmi = (zzcmi) obj;
        String str = (String) map.get(AnalyticsEventKey.URL);
        if (str == null) {
            zzcgs.zzi("URL missing from httpTrack GMSG.");
        } else if (!zzcmi.zzF().zzae) {
            zzfdz.zzb(str);
        } else {
            zzedb.zze(new zzedd(zzs.zzj().currentTimeMillis(), ((zzcno) zzcmi).zzaB().zzb, str, 2));
        }
    }
}
