package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmb implements zzly {
    public static final zzdh<Boolean> zza;
    public static final zzdh<Long> zzb;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.service.directly_maybe_log_error_events", false);
        zzb = zzdm.zza("measurement.id.service.directly_maybe_log_error_events", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
