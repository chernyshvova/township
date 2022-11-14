package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcxp {
    public final List<? extends zzfqn<? extends zzcxi>> zza;

    public zzcxp(zzcxi zzcxi) {
        this.zza = Collections.singletonList(zzfqe.zza(zzcxi));
    }

    public zzcxp(List<? extends zzfqn<? extends zzcxi>> list) {
        this.zza = list;
    }

    public static zzedn<zzcxp> zza(@NonNull zzegb<? extends zzcxi> zzegb) {
        return new zzedo(zzegb, zzcxn.zza);
    }

    public static zzedn<zzcxp> zzb(@NonNull zzedn<? extends zzcxi> zzedn) {
        return new zzedo(zzedn, zzcxo.zza);
    }
}
