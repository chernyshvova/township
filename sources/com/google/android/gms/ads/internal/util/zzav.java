package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbgt;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzav extends zzbgt {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzay zzb;

    public zzav(zzay zzay, Context context) {
        this.zzb = zzay;
        this.zza = context;
    }

    public final void zze(@Nullable zzbdd zzbdd) {
        if (zzbdd != null) {
            this.zzb.zzn(this.zza, zzbdd.zzb, true, true);
        }
    }
}
