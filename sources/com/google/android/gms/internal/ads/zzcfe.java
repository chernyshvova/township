package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcfe implements zzcfg {
    public final zzcfh zza;
    public final Map zzb;

    public zzcfe(zzcfh zzcfh, Map map) {
        this.zza = zzcfh;
        this.zzb = map;
    }

    public final void zza(SharedPreferences sharedPreferences, String str, String str2) {
        this.zza.zzc(this.zzb, sharedPreferences, str, str2);
    }
}
