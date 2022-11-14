package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.AdRequest$Gender;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwy {
    public static int zza(AdRequest$ErrorCode adRequest$ErrorCode) {
        int ordinal = adRequest$ErrorCode.ordinal();
        if (ordinal == 0) {
            return 1;
        }
        if (ordinal != 1) {
            return ordinal != 2 ? 0 : 2;
        }
        return 3;
    }

    public static MediationAdRequest zzb(zzbdk zzbdk, boolean z) {
        AdRequest$Gender adRequest$Gender;
        List<String> list = zzbdk.zze;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        Date date = new Date(zzbdk.zzb);
        int i = zzbdk.zzd;
        if (i == 1) {
            adRequest$Gender = AdRequest$Gender.MALE;
        } else if (i != 2) {
            adRequest$Gender = AdRequest$Gender.UNKNOWN;
        } else {
            adRequest$Gender = AdRequest$Gender.FEMALE;
        }
        return new MediationAdRequest(date, adRequest$Gender, hashSet, z, zzbdk.zzk);
    }
}
