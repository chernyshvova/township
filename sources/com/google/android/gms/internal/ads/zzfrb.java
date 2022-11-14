package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfrb extends zzfqm {
    public final /* synthetic */ zzfrc zza;
    public final Callable zzb;

    public zzfrb(zzfrc zzfrc, Callable callable) {
        this.zza = zzfrc;
        if (callable != null) {
            this.zzb = callable;
            return;
        }
        throw null;
    }

    public final Object zza() throws Exception {
        return this.zzb.call();
    }

    public final String zzc() {
        return this.zzb.toString();
    }

    public final boolean zzd() {
        return this.zza.isDone();
    }

    public final void zzf(Object obj) {
        this.zza.zzh(obj);
    }

    public final void zzg(Throwable th) {
        this.zza.zzi(th);
    }
}
