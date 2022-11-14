package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbuh {
    @VisibleForTesting
    public static final zzbd<zzbso> zza = new zzbuf();
    @VisibleForTesting
    public static final zzbd<zzbso> zzb = new zzbug();
    public final zzbtt zzc;

    public zzbuh(Context context, zzcgy zzcgy, String str) {
        this.zzc = new zzbtt(context, zzcgy, str, zza, zzb);
    }

    public final <I, O> zzbtx<I, O> zza(String str, zzbua<I> zzbua, zzbtz<O> zzbtz) {
        return new zzbul(this.zzc, str, zzbua, zzbtz);
    }

    public final zzbuq zzb() {
        return new zzbuq(this.zzc);
    }
}
