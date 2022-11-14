package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbio extends zzbgz {
    @Nullable
    public final OnPaidEventListener zza;

    public zzbio(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zza = onPaidEventListener;
    }

    public final void zze(zzbdr zzbdr) {
        if (this.zza != null) {
            this.zza.onPaidEvent(AdValue.zza(zzbdr.zzb, zzbdr.zzc, zzbdr.zzd));
        }
    }
}
