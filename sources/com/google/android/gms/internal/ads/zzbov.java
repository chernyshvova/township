package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbov implements zzbps<zzcmr> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmr zzcmr = (zzcmr) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzcgs.zzi("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzcgs.zzi("No timestamp given for CSI tick.");
            } else {
                try {
                    long parseLong = (Long.parseLong(str4) - zzs.zzj().currentTimeMillis()) + zzs.zzj().elapsedRealtime();
                    if (true == TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzcmr.zzq().zzb(str2, str3, parseLong);
                } catch (NumberFormatException e) {
                    zzcgs.zzj("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzcgs.zzi("No value given for CSI experiment.");
            } else {
                zzcmr.zzq().zzc().zzd("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzcgs.zzi("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzcgs.zzi("No name given for CSI extra.");
            } else {
                zzcmr.zzq().zzc().zzd(str6, str7);
            }
        }
    }
}
