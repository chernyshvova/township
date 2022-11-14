package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzakz implements zzajh {
    public final zzajt zza(Looper looper, @Nullable Handler.Callback callback) {
        return new zzalc(new Handler(looper, callback));
    }
}
