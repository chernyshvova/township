package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class zzbkp<T> {
    public final String zza;
    public final T zzb;
    public final int zzc;

    public zzbkp(String str, T t, int i) {
        this.zza = str;
        this.zzb = t;
        this.zzc = i;
    }

    public static zzbkp<Boolean> zza(String str, boolean z) {
        return new zzbkp<>(str, Boolean.valueOf(z), 1);
    }

    public static zzbkp<Long> zzb(String str, long j) {
        return new zzbkp<>(str, Long.valueOf(j), 2);
    }

    public static zzbkp<Double> zzc(String str, double d) {
        return new zzbkp<>(str, Double.valueOf(d), 3);
    }

    public static zzbkp<String> zzd(String str, String str2) {
        return new zzbkp<>(str, str2, 4);
    }

    public final T zze() {
        zzbln zza2 = zzblo.zza();
        if (zza2 != null) {
            int i = this.zzc - 1;
            if (i == 0) {
                return zza2.zza(this.zza, ((Boolean) this.zzb).booleanValue());
            }
            if (i == 1) {
                return zza2.zzb(this.zza, ((Long) this.zzb).longValue());
            }
            if (i != 2) {
                return zza2.zzd(this.zza, (String) this.zzb);
            }
            return zza2.zzc(this.zza, ((Double) this.zzb).doubleValue());
        }
        throw new IllegalStateException("Flag is not initialized.");
    }
}
