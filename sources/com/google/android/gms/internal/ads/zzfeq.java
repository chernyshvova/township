package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfeq {
    public final String zza;
    public final String zzb;

    public zzfeq(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzfeq zza(String str, String str2) {
        zzffp.zzb(str, "Name is null or empty");
        zzffp.zzb(str2, "Version is null or empty");
        return new zzfeq(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
