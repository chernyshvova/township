package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfeh {
    public static zzfeh zzf(zzfei zzfei, zzfej zzfej) {
        if (zzfef.zzb()) {
            return new zzfel(zzfei, zzfej);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }

    public abstract void zza();

    public abstract void zzb(View view);

    public abstract void zzc();

    public abstract void zzd(View view, zzfen zzfen, @Nullable String str);

    @Deprecated
    public abstract void zze(View view);
}
