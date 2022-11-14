package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbqi implements zzbps<Object> {
    public final zzbqh zza;

    public zzbqi(zzbqh zzbqh) {
        this.zza = zzbqh;
    }

    public static void zzb(zzcmr zzcmr, zzbqh zzbqh) {
        zzcmr.zzab("/reward", new zzbqi(zzbqh));
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzccm zzccm = null;
            try {
                int parseInt = Integer.parseInt(map.get(AppLovinEventParameters.REVENUE_AMOUNT));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzccm = new zzccm(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzcgs.zzj("Unable to parse reward amount.", e);
            }
            this.zza.zzb(zzccm);
        } else if ("video_start".equals(str)) {
            this.zza.zza();
        } else if ("video_complete".equals(str)) {
            this.zza.zzc();
        }
    }
}
