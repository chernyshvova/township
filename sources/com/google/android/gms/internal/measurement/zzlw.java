package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzlw implements zzlx {
    public static final zzdh<Boolean> zza;
    public static final zzdh<Boolean> zzb;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.androidId.delete_feature", true);
        zzb = zzdm.zza("measurement.log_androidId_enabled", false);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
