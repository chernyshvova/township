package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcxk<AdT> implements zzcxl<AdT> {
    public final Map<String, zzedn<AdT>> zza;

    public zzcxk(Map<String, zzedn<AdT>> map) {
        this.zza = map;
    }

    @Nullable
    public final zzedn<AdT> zza(int i, String str) {
        return this.zza.get(str);
    }
}
