package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbva {
    public static zzbva zza;
    public final AtomicBoolean zzb = new AtomicBoolean(false);

    public static zzbva zza() {
        if (zza == null) {
            zza = new zzbva();
        }
        return zza;
    }

    @Nullable
    public final Thread zzb(Context context, @Nullable String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzbuy(this, context, str));
        thread.start();
        return thread;
    }
}
