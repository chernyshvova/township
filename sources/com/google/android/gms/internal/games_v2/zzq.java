package com.google.android.gms.internal.games_v2;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzq implements Api.ApiOptions.Optional {
    public final int zza;
    @Nullable
    public final String zzb;

    public /* synthetic */ zzq(int i, String str, zzp zzp) {
        this.zza = i;
        this.zzb = str;
    }

    public static zzo zza() {
        return new zzo((zzn) null);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzq = (zzq) obj;
        return this.zza == zzq.zza && Objects.equal(this.zzb, zzq.zzb);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb);
    }
}
