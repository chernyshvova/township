package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzv implements zzcp<zzp> {
    public final zzct<Application> zza;
    public final zzct<zzab> zzb;
    public final zzct<Handler> zzc;
    public final zzct<Executor> zzd;
    public final zzct<zzal> zze;
    public final zzct<zzaz> zzf;
    public final zzct<zzn> zzg;
    public final zzct<zzz> zzh;
    public final zzct<zze> zzi;

    public zzv(zzct<Application> zzct, zzct<zzab> zzct2, zzct<Handler> zzct3, zzct<Executor> zzct4, zzct<zzal> zzct5, zzct<zzaz> zzct6, zzct<zzn> zzct7, zzct<zzz> zzct8, zzct<zze> zzct9) {
        this.zza = zzct;
        this.zzb = zzct2;
        this.zzc = zzct3;
        this.zzd = zzct4;
        this.zze = zzct5;
        this.zzf = zzct6;
        this.zzg = zzct7;
        this.zzh = zzct8;
        this.zzi = zzct9;
    }

    public final /* synthetic */ Object zza() {
        zzn zza2 = this.zzg.zza();
        return new zzp(this.zza.zza(), this.zzb.zza(), this.zzc.zza(), this.zzd.zza(), this.zze.zza(), this.zzf.zza(), zza2, this.zzh.zza(), this.zzi.zza());
    }
}
