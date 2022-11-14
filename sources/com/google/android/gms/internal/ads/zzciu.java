package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzciu implements Runnable {
    public zzciu(zzciw zzciw) {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
