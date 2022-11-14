package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzern implements zzeqp<zzero> {
    public final Context zza;
    public final String zzb;
    public final zzfqo zzc;

    public zzern(@Nullable zzcbm zzcbm, Context context, String str, zzfqo zzfqo) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzfqo;
    }

    public final zzfqn<zzero> zza() {
        return this.zzc.zzb(new zzerm(this));
    }
}
