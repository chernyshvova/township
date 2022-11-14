package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzau;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzczz implements zzfju {
    public final Context zza;
    public final zzcgy zzb;
    public final zzeyw zzc;

    public zzczz(Context context, zzcgy zzcgy, zzeyw zzeyw) {
        this.zza = context;
        this.zzb = zzcgy;
        this.zzc = zzeyw;
    }

    public final Object apply(Object obj) {
        Context context = this.zza;
        zzcgy zzcgy = this.zzb;
        zzeyw zzeyw = this.zzc;
        zzeye zzeye = (zzeye) obj;
        zzau zzau = new zzau(context);
        zzau.zze(zzeye.zzB);
        zzau.zzf(zzeye.zzC.toString());
        zzau.zzd(zzcgy.zza);
        zzau.zzc(zzeyw.zzf);
        return zzau;
    }
}
