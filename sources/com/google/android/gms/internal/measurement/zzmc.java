package com.google.android.gms.internal.measurement;

import com.facebook.UserSettingsManager;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmc implements zzmd {
    public static final zzdh<Boolean> zza;
    public static final zzdh<Long> zzb;

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.sdk.attribution.cache", true);
        zzb = zzdm.zza("measurement.sdk.attribution.cache.ttl", (long) UserSettingsManager.TIMEOUT_7D);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final long zzb() {
        return zzb.zzc().longValue();
    }
}
