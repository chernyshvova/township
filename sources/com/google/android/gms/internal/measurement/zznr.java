package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zznr implements zzno {
    public static final zzdh<Boolean> zza;
    public static final zzdh<Boolean> zzb;
    public static final zzdh<Long> zzc;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzdm.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzdm.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }
}
