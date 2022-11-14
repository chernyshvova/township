package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbka {
    public final Map<String, zzbjz> zza = new HashMap();
    @Nullable
    public final zzbkc zzb;

    public zzbka(@Nullable zzbkc zzbkc) {
        this.zzb = zzbkc;
    }

    public final void zza(String str, zzbjz zzbjz) {
        this.zza.put(str, zzbjz);
    }

    public final void zzb(String str, String str2, long j) {
        zzbkc zzbkc = this.zzb;
        zzbjz zzbjz = this.zza.get(str2);
        String[] strArr = {str};
        if (zzbjz != null) {
            zzbkc.zzb(zzbjz, j, strArr);
        }
        this.zza.put(str, new zzbjz(j, (String) null, (zzbjz) null));
    }

    @Nullable
    public final zzbkc zzc() {
        return this.zzb;
    }
}
