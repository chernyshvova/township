package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeni implements zzeqp<zzeqo<Bundle>> {
    @Nullable
    public final zzevd zza;

    public zzeni(@Nullable zzevd zzevd) {
        this.zza = zzevd;
    }

    public final zzfqn<zzeqo<Bundle>> zza() {
        zzevd zzevd = this.zza;
        zzenh zzenh = null;
        if (!(zzevd == null || zzevd.zza() == null || this.zza.zza().isEmpty())) {
            zzenh = new zzenh(this);
        }
        return zzfqe.zza(zzenh);
    }

    public final /* synthetic */ void zzb(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
