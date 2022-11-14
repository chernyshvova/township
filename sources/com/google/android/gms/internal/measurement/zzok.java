package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzok implements zzol {
    public static final zzdh<Long> zza;
    public static final zzdh<Long> zzb;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.id.max_bundles_per_iteration", 0);
        zzb = zzdm.zza("measurement.max_bundles_per_iteration", 2);
    }

    public final long zza() {
        return zzb.zzc().longValue();
    }
}
