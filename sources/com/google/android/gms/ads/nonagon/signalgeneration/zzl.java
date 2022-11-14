package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzfju;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzl implements zzfju {
    public final zzt zza;
    public final Uri zzb;

    public zzl(zzt zzt, Uri uri) {
        this.zza = zzt;
        this.zzb = uri;
    }

    public final Object apply(Object obj) {
        return zzt.zzr(this.zzb, (String) obj);
    }
}
