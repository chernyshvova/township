package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzna implements zznb {
    public static final zzdh<Boolean> zza;
    public static final zzdh<Long> zzb;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.sdk.referrer.delayed_install_referrer_api", false);
        zzb = zzdm.zza("measurement.id.sdk.referrer.delayed_install_referrer_api", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
