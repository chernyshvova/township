package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcrr implements zzgjg<zzcgx> {
    public final zzgju<zzbuu> zza;
    public final zzgju<String> zzb;

    public zzcrr(zzgju<zzbuu> zzgju, zzgju<String> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbuw zzbuw = new zzbuw();
        String zzb2 = this.zzb.zzb();
        if (zzblb.zza.zze().booleanValue()) {
            return new zzbuv(zzbuw, zzb2);
        }
        return new zzcgx(zzb2);
    }
}
