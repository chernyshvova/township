package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzny implements zznz {
    public static final zzdh<Boolean> zza;
    public static final zzdh<Boolean> zzb;
    public static final zzdh<Boolean> zzc;
    public static final zzdh<Long> zzd;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.client.global_params", true);
        zzb = zzdm.zza("measurement.service.global_params_in_payload", true);
        zzc = zzdm.zza("measurement.service.global_params", true);
        zzd = zzdm.zza("measurement.id.service.global_params", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }
}
