package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final /* synthetic */ class zzcgn implements zzcgq {
    public final int zza;
    public final Map zzb;

    public zzcgn(int i, Map map) {
        this.zza = i;
        this.zzb = map;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzcgr.zzl(this.zza, this.zzb, jsonWriter);
    }
}
