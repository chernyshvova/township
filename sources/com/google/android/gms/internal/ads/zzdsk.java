package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdsk implements zzdby {
    @Nullable
    public final zzcmr zza;

    public zzdsk(@Nullable zzcmr zzcmr) {
        this.zza = zzcmr;
    }

    public final void zzb(@Nullable Context context) {
        zzcmr zzcmr = this.zza;
        if (zzcmr != null) {
            zzcmr.onResume();
        }
    }

    public final void zzbD(@Nullable Context context) {
        zzcmr zzcmr = this.zza;
        if (zzcmr != null) {
            zzcmr.destroy();
        }
    }

    public final void zzbG(@Nullable Context context) {
        zzcmr zzcmr = this.zza;
        if (zzcmr != null) {
            zzcmr.onPause();
        }
    }
}
