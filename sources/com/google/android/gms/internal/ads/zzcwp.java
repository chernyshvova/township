package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcwp implements Runnable {
    public final AtomicReference zza;

    public zzcwp(AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.zza.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
