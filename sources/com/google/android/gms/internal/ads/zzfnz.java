package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfnz extends zzfml<Map.Entry> {
    public final /* synthetic */ zzfoa zza;

    public zzfnz(zzfoa zzfoa) {
        this.zza = zzfoa;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzfke.zze(i, this.zza.zzc, "index");
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(this.zza.zzb[i2], this.zza.zzb[i2 + 1]);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
