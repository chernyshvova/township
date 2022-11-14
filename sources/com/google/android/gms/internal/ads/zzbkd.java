package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbkd extends zzbke {
    public final zzf zza;
    @Nullable
    public final String zzb;
    public final String zzc;

    public zzbkd(zzf zzf, @Nullable String str, String str2) {
        this.zza = zzf;
        this.zzb = str;
        this.zzc = str2;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final void zzd(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zza.zza((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final void zze() {
        this.zza.zzb();
    }

    public final void zzf() {
        this.zza.zzc();
    }
}
