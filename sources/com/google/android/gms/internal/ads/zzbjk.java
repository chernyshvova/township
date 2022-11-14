package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbjk implements zzbln {
    public final /* synthetic */ zzbjl zza;

    public zzbjk(zzbjl zzbjl) {
        this.zza = zzbjl;
    }

    public final Boolean zza(String str, boolean z) {
        return Boolean.valueOf(this.zza.zze.getBoolean(str, z));
    }

    public final Long zzb(String str, long j) {
        try {
            return Long.valueOf(this.zza.zze.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf((long) this.zza.zze.getInt(str, (int) j));
        }
    }

    public final Double zzc(String str, double d) {
        return Double.valueOf((double) this.zza.zze.getFloat(str, (float) d));
    }

    public final String zzd(String str, String str2) {
        return this.zza.zze.getString(str, str2);
    }
}
