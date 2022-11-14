package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxi;
import com.google.android.gms.internal.ads.zzdam;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeva<R extends zzdam<AdT>, AdT extends zzcxi> implements zzfbb<R, AdT> {
    public final zzevv<R, zzfaq<R, AdT>> zza;

    public zzeva(zzevv<R, zzfaq<R, AdT>> zzevv) {
        this.zza = zzevv;
    }

    public final zzfqn<zzfaq<R, AdT>> zza(zzfbc<R, AdT> zzfbc) {
        zzevb zzevb = (zzevb) zzfbc;
        return ((zzeux) this.zza).zzb(zzevb.zzb, zzevb.zza, null);
    }

    public final void zzb(zzfaq<R, AdT> zzfaq) {
        zzfaq.zza = ((zzeux) this.zza).zza();
    }
}
