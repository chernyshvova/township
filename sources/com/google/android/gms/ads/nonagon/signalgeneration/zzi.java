package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzi implements Callable {
    public final zzt zza;
    public final Uri zzb;
    public final IObjectWrapper zzc;

    public zzi(zzt zzt, Uri uri, IObjectWrapper iObjectWrapper) {
        this.zza = zzt;
        this.zzb = uri;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzm(this.zzb, this.zzc);
    }
}
