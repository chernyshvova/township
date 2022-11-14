package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeif implements zzgjg<zzeie> {
    public final zzgju<Context> zza;
    public final zzgju<Executor> zzb;
    public final zzgju<zzdro> zzc;

    public zzeif(zzgju<Context> zzgju, zzgju<Executor> zzgju2, zzgju<zzdro> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeie(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
