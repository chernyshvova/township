package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzlq implements zzlr {
    public static final zzdh<Boolean> zza;
    public static final zzdh<Boolean> zzb;
    public static final zzdh<Boolean> zzc;
    public static final zzdh<Long> zzd;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.client.ad_impression", true);
        zzb = zzdm.zza("measurement.service.separate_public_internal_event_blacklisting", true);
        zzc = zzdm.zza("measurement.service.ad_impression", true);
        zzd = zzdm.zza("measurement.id.service.ad_impression", 0);
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
