package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbjo {
    public static List<String> zza() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbkp.zzd("gad:dynamite_module:experiment_id", ""));
        zzc(arrayList, zzbky.zza);
        zzc(arrayList, zzbky.zzb);
        zzc(arrayList, zzbky.zzc);
        zzc(arrayList, zzbky.zzd);
        zzc(arrayList, zzbky.zze);
        zzc(arrayList, zzbky.zzk);
        zzc(arrayList, zzbky.zzf);
        zzc(arrayList, zzbky.zzg);
        zzc(arrayList, zzbky.zzh);
        zzc(arrayList, zzbky.zzi);
        zzc(arrayList, zzbky.zzj);
        return arrayList;
    }

    public static List<String> zzb() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzblj.zza);
        return arrayList;
    }

    public static void zzc(List<String> list, zzbkp<String> zzbkp) {
        String zze = zzbkp.zze();
        if (!TextUtils.isEmpty(zze)) {
            list.add(zze);
        }
    }
}
