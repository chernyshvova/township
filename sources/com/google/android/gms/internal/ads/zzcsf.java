package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcsf implements zzgjg<zzcse> {
    public final zzgju<Map<String, zzcsh>> zza;
    public final zzgju<Map<String, zzcsg>> zzb;

    public zzcsf(zzgju<Map<String, zzcsh>> zzgju, zzgju<Map<String, zzcsg>> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    /* renamed from: zza */
    public final zzcse zzb() {
        return new zzcse(((zzgjk) this.zza).zzb(), ((zzgjk) this.zzb).zzb());
    }
}
