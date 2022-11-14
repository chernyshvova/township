package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfpp extends zzfpq {
    public final /* synthetic */ zzfpr zza;
    public final Callable zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfpp(zzfpr zzfpr, Callable callable, Executor executor) {
        super(zzfpr, executor);
        this.zza = zzfpr;
        if (callable != null) {
            this.zzc = callable;
            return;
        }
        throw null;
    }

    public final Object zza() throws Exception {
        return this.zzc.call();
    }

    public final void zzb(Object obj) {
        this.zza.zzh(obj);
    }

    public final String zzc() {
        return this.zzc.toString();
    }
}
