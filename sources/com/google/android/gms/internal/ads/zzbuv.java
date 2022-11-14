package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbuv extends zzcgx {
    public final zzbuu zza;

    public zzbuv(zzbuu zzbuu, @Nullable String str) {
        super(str);
        this.zza = zzbuu;
    }

    @WorkerThread
    public final void zza(String str) {
        if (!"oda".equals(Uri.parse(str).getScheme())) {
            super.zza(str);
        }
    }
}
