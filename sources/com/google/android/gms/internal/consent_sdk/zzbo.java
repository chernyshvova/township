package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzbo implements zzcp<zzbj> {
    public final zzct<Application> zza;
    public final zzct<zzbh> zzb;
    public final zzct<Handler> zzc;
    public final zzct<Executor> zzd;
    public final zzct<zze> zze;
    public final zzct<zzaj> zzf;
    public final zzct<zzat> zzg;

    public zzbo(zzct<Application> zzct, zzct<zzbh> zzct2, zzct<Handler> zzct3, zzct<Executor> zzct4, zzct<zze> zzct5, zzct<zzaj> zzct6, zzct<zzat> zzct7) {
        this.zza = zzct;
        this.zzb = zzct2;
        this.zzc = zzct3;
        this.zzd = zzct4;
        this.zze = zzct5;
        this.zzf = zzct6;
        this.zzg = zzct7;
    }

    public final /* synthetic */ Object zza() {
        return new zzbj(this.zza.zza(), this.zzb.zza(), this.zzc.zza(), this.zzd.zza(), this.zze.zza(), this.zzf.zza(), this.zzg.zza());
    }
}
