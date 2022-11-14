package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbkc {
    public final List<zzbjz> zza = new LinkedList();
    public final Map<String, String> zzb = new LinkedHashMap();
    public final Object zzc = new Object();

    public zzbkc(boolean z, String str, String str2) {
        this.zzb.put("action", "make_wv");
        this.zzb.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public static final zzbjz zzf() {
        return new zzbjz(zzs.zzj().elapsedRealtime(), (String) null, (zzbjz) null);
    }

    public final void zza(@Nullable zzbkc zzbkc) {
        synchronized (this.zzc) {
        }
    }

    public final boolean zzb(zzbjz zzbjz, long j, String... strArr) {
        synchronized (this.zzc) {
            for (String zzbjz2 : strArr) {
                this.zza.add(new zzbjz(j, zzbjz2, zzbjz));
            }
        }
        return true;
    }

    public final zzbkb zzc() {
        zzbkb zzbkb;
        boolean booleanValue = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.zzc) {
            for (zzbjz next : this.zza) {
                long zza2 = next.zza();
                String zzb2 = next.zzb();
                zzbjz zzc2 = next.zzc();
                if (zzc2 != null && zza2 > 0) {
                    sb.append(zzb2);
                    sb.append('.');
                    sb.append(zza2 - zzc2.zza());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzc2.zza()))) {
                            hashMap.put(Long.valueOf(zzc2.zza()), new StringBuilder(zzb2));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzc2.zza()));
                            sb2.append('+');
                            sb2.append(zzb2);
                        }
                    }
                }
            }
            this.zza.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    long longValue = ((Long) entry.getKey()).longValue();
                    sb3.append((longValue - zzs.zzj().elapsedRealtime()) + zzs.zzj().currentTimeMillis());
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzbkb = new zzbkb(sb.toString(), str);
        }
        return zzbkb;
    }

    public final void zzd(String str, String str2) {
        zzbjs zza2;
        if (!TextUtils.isEmpty(str2) && (zza2 = zzs.zzg().zza()) != null) {
            synchronized (this.zzc) {
                zzbjy zzd = zza2.zzd(str);
                Map<String, String> map = this.zzb;
                map.put(str, zzd.zza(map.get(str), str2));
            }
        }
    }

    @VisibleForTesting
    public final Map<String, String> zze() {
        Map<String, String> map;
        synchronized (this.zzc) {
            zzs.zzg().zza();
            map = this.zzb;
        }
        return map;
    }
}
