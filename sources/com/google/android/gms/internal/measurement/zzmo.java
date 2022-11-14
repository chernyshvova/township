package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmo implements zzmp {
    public static final zzdh<Boolean> zza;
    public static final zzdh<Boolean> zzb;
    public static final zzdh<Boolean> zzc;
    public static final zzdh<Long> zzd;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.sdk.dynamite.allow_remote_dynamite3", true);
        zzb = zzdm.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzdm.zza("measurement.sdk.dynamite.use_dynamite3", true);
        zzd = zzdm.zza("measurement.id.sdk.dynamite.use_dynamite", 0);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
