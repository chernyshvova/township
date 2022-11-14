package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfas implements zzfar {
    public final Object[] zza;

    public zzfas(zzbdk zzbdk, String str, int i, String str2, zzbdv zzbdv) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzbdk.zzb));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zza(zzbdk.zzc));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzbdk.zzc.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzbdk.zzd));
        }
        if (hashSet.contains("keywords")) {
            List<String> list = zzbdk.zze;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzbdk.zzf));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzbdk.zzg));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzbdk.zzh));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzbdk.zzi);
        }
        if (hashSet.contains(FirebaseAnalytics.Param.LOCATION)) {
            Location location = zzbdk.zzk;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzbdk.zzl);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zza(zzbdk.zzm));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zza(zzbdk.zzn));
        }
        if (hashSet.contains("categoryExclusions")) {
            List<String> list2 = zzbdk.zzo;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzbdk.zzp);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzbdk.zzq);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzbdk.zzr));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzbdk.zzt));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzbdk.zzu);
        }
        if (hashSet.contains("orientation")) {
            if (zzbdv != null) {
                arrayList.add(Integer.valueOf(zzbdv.zza));
            } else {
                arrayList.add((Object) null);
            }
        }
        this.zza = arrayList.toArray();
    }

    public static String zza(@Nullable Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            if (obj == null) {
                str = "null";
            } else if (obj instanceof Bundle) {
                str = zza((Bundle) obj);
            } else {
                str = obj.toString();
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfas)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzfas) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        int hashCode = Arrays.hashCode(this.zza);
        String arrays = Arrays.toString(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
