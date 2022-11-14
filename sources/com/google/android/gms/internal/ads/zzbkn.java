package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbkn implements zzgjg<zzbkm> {
    public final zzgju<Context> zza;
    public final zzgju<ScheduledExecutorService> zzb;
    public final zzgju<zzbko> zzc;

    public zzbkn(zzgju<Context> zzgju, zzgju<ScheduledExecutorService> zzgju2, zzgju<zzbko> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbkm(((zzfaa) this.zza).zza(), this.zzb.zzb(), new zzbko(), (byte[]) null);
    }
}
