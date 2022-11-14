package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzekt implements zzddo {
    public final AtomicReference<zzbha> zza = new AtomicReference<>();

    public final void zza(zzbha zzbha) {
        this.zza.set(zzbha);
    }

    public final void zzk(zzbdr zzbdr) {
        zzevk.zza(this.zza, new zzeks(zzbdr));
    }
}
