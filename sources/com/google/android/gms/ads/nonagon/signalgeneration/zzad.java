package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcbk;
import com.google.android.gms.internal.ads.zzdyw;
import com.google.android.gms.internal.ads.zzfpl;
import com.google.android.gms.internal.ads.zzfqe;
import com.google.android.gms.internal.ads.zzfqn;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzad implements zzfpl<zzcbk, zzaf> {
    public final Executor zza;
    public final zzdyw zzb;

    public zzad(Executor executor, zzdyw zzdyw) {
        this.zza = executor;
        this.zzb = zzdyw;
    }

    public final /* bridge */ /* synthetic */ zzfqn zza(Object obj) throws Exception {
        zzcbk zzcbk = (zzcbk) obj;
        return zzfqe.zzi(this.zzb.zza(zzcbk), new zzac(zzcbk), this.zza);
    }
}
