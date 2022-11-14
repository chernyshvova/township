package com.google.android.gms.ads.internal.util;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzfjj;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzk implements Callable {
    public final Uri zza;

    public zzk(Uri uri) {
        this.zza = uri;
    }

    public final Object call() {
        Uri uri = this.zza;
        zzfjj zzfjj = zzr.zza;
        zzs.zzc();
        return zzr.zzR(uri);
    }
}
