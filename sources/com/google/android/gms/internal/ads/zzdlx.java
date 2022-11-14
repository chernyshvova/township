package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdlx {
    @Nullable
    public zzbmf zza;

    public zzdlx(zzdlm zzdlm) {
        this.zza = zzdlm;
    }

    @Nullable
    public final synchronized zzbmf zza() {
        return this.zza;
    }

    public final synchronized void zzb(@Nullable zzbmf zzbmf) {
        this.zza = zzbmf;
    }
}
