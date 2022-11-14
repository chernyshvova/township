package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzoq implements zzor {
    public static final zzdh<Boolean> zza;
    public static final zzdh<Double> zzb;
    public static final zzdh<Long> zzc;
    public static final zzdh<Long> zzd;
    public static final zzdh<String> zze;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.test.boolean_flag", false);
        zzb = zzdm.zza("measurement.test.double_flag", -3.0d);
        zzc = zzdm.zza("measurement.test.int_flag", -2);
        zzd = zzdm.zza("measurement.test.long_flag", -1);
        zze = zzdm.zza("measurement.test.string_flag", "---");
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    public final long zzc() {
        return zzc.zzc().longValue();
    }

    public final long zzd() {
        return zzd.zzc().longValue();
    }

    public final String zze() {
        return zze.zzc();
    }
}
