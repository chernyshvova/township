package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbpe implements zzbps {
    public static final zzbps zza = new zzbpe();

    public final void zza(Object obj, Map map) {
        zzcoa zzcoa = (zzcoa) obj;
        zzbps<zzcmr> zzbps = zzbpr.zza;
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzfb zzU = zzcoa.zzU();
            if (zzU != null) {
                zzU.zzb().zze(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzcgs.zzi("Could not parse touch parameters from gmsg.");
        }
    }
}
