package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdnn implements zzbps {
    public final zzdns zza;
    public final WindowManager zzb;
    public final View zzc;

    public zzdnn(zzdns zzdns, WindowManager windowManager, View view) {
        this.zza = zzdns;
        this.zzb = windowManager;
        this.zzc = view;
    }

    public final void zza(Object obj, Map map) {
        this.zza.zzd(this.zzb, this.zzc, (zzcmr) obj, map);
    }
}
