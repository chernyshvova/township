package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzt {
    public final Executor zza;

    public zzt(Handler handler) {
        this.zza = new zzr(this, handler);
    }

    public final void zza(zzac<?> zzac, zzai<?> zzai, Runnable runnable) {
        zzac.zzp();
        zzac.zzc("post-response");
        Executor executor = this.zza;
        ((zzr) executor).zza.post(new zzs(zzac, zzai, runnable));
    }

    public final void zzb(zzac<?> zzac, zzal zzal) {
        zzac.zzc("post-error");
        zzai zzb = zzai.zzb(zzal);
        Executor executor = this.zza;
        ((zzr) executor).zza.post(new zzs(zzac, zzb, (Runnable) null));
    }
}
