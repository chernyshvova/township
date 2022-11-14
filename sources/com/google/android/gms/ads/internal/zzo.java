package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfa;
import com.google.android.gms.internal.ads.zzfb;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzo implements Callable<zzfb> {
    public final /* synthetic */ zzr zza;

    public zzo(zzr zzr) {
        this.zza = zzr;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return new zzfb(zzfa.zzs(this.zza.zza.zza, this.zza.zzd, false, 1));
    }
}
