package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzmx {
    @Nullable
    public final WifiManager zza;

    public zzmx(Context context) {
        this.zza = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }
}
