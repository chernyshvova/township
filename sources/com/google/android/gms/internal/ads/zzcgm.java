package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final /* synthetic */ class zzcgm implements zzcgq {
    public final String zza;
    public final String zzb;
    public final Map zzc;
    public final byte[] zzd;

    public zzcgm(String str, String str2, Map map, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = map;
        this.zzd = bArr;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzcgr.zzm(this.zza, this.zzb, this.zzc, this.zzd, jsonWriter);
    }
}
