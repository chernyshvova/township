package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzefe implements Callable {
    public final zzefh zza;
    public final zzeyq zzb;
    public final zzeye zzc;

    public zzefe(zzefh zzefh, zzeyq zzeyq, zzeye zzeye) {
        this.zza = zzefh;
        this.zzb = zzeyq;
        this.zzc = zzeye;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc);
    }
}
