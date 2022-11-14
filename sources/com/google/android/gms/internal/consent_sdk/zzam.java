package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzam implements zzcp<zzaj> {
    public final zzct<Application> zza;
    public final zzct<zzal> zzb;
    public final zzct<Executor> zzc;

    public zzam(zzct<Application> zzct, zzct<zzal> zzct2, zzct<Executor> zzct3) {
        this.zza = zzct;
        this.zzb = zzct2;
        this.zzc = zzct3;
    }

    public final /* synthetic */ Object zza() {
        return new zzaj(this.zza.zza(), this.zzb.zza(), this.zzc.zza());
    }
}
