package com.google.android.gms.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zza {
    public static AdSize zza(int i, int i2, String str) {
        return new AdSize(i, i2, str);
    }

    public static AdSize zzb(int i, int i2) {
        AdSize adSize = new AdSize(i, i2);
        adSize.zzc(true);
        adSize.zzd(i2);
        return adSize;
    }

    public static AdSize zzc(int i, int i2) {
        AdSize adSize = new AdSize(i, i2);
        adSize.zzg(true);
        adSize.zzi(i2);
        return adSize;
    }

    public static boolean zzd(AdSize adSize) {
        return adSize.zzf();
    }

    public static int zze(AdSize adSize) {
        return adSize.zzh();
    }

    public static boolean zzf(AdSize adSize) {
        return adSize.zza();
    }

    public static boolean zzg(AdSize adSize) {
        return adSize.zzb();
    }

    public static int zzh(AdSize adSize) {
        return adSize.zze();
    }
}
