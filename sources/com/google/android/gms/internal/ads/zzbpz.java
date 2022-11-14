package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpz implements zzbps<zzcmr> {
    public static final Map<String, Integer> zza = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    public final zzb zzb;
    public final zzbyk zzc;
    public final zzbyr zzd;

    public zzbpz(zzb zzb2, zzbyk zzbyk, zzbyr zzbyr) {
        this.zzb = zzb2;
        this.zzc = zzbyk;
        this.zzd = zzbyr;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmr zzcmr = (zzcmr) obj;
        int intValue = zza.get((String) map.get("a")).intValue();
        int i = 6;
        boolean z = true;
        if (intValue != 5) {
            if (intValue != 7) {
                if (!this.zzb.zzb()) {
                    this.zzb.zzc((String) null);
                    return;
                } else if (intValue == 1) {
                    this.zzc.zza(map);
                    return;
                } else if (intValue == 3) {
                    new zzbyn(zzcmr, map).zza();
                    return;
                } else if (intValue == 4) {
                    new zzbyi(zzcmr, map).zza();
                    return;
                } else if (intValue != 5) {
                    if (intValue == 6) {
                        this.zzc.zzb(true);
                        return;
                    } else if (intValue != 7) {
                        zzcgs.zzh("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            z = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        }
        if (zzcmr == null) {
            zzcgs.zzi("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            i = 7;
        } else if (!"landscape".equalsIgnoreCase(str)) {
            if (z) {
                i = -1;
            } else {
                i = zzs.zze().zzh();
            }
        }
        zzcmr.zzal(i);
    }
}
