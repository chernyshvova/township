package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzctu implements zzgjg<zzctn> {
    public final zzgju<zzavv> zza;
    public final zzgju<zzbuq> zzb;
    public final zzgju<Executor> zzc;

    public zzctu(zzgju<zzavv> zzgju, zzgju<zzbuq> zzgju2, zzgju<Executor> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zza2 = zzfbl.zza();
        zzgjp.zzb(zza2);
        return new zzctn(this.zza.zzb().zzd(), this.zzb.zzb(), zza2);
    }
}
