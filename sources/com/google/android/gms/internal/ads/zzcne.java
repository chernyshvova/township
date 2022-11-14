package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcne implements Runnable {
    public final IObjectWrapper zza;

    public zzcne(IObjectWrapper iObjectWrapper) {
        this.zza = iObjectWrapper;
    }

    public final void run() {
        zzs.zzr().zzi(this.zza);
    }
}
