package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdno implements zzbps {
    public final zzdns zza;
    public final View zzb;
    public final WindowManager zzc;

    public zzdno(zzdns zzdns, View view, WindowManager windowManager) {
        this.zza = zzdns;
        this.zzb = view;
        this.zzc = windowManager;
    }

    public final void zza(Object obj, Map map) {
        this.zza.zzb(this.zzb, this.zzc, (zzcmr) obj, map);
    }
}
