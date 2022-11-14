package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzmw {
    @Nullable
    public final PowerManager zza;

    public zzmw(Context context) {
        this.zza = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
