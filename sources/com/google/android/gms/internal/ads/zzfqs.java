package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfox;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqs extends zzfox.zzi<Void> implements Runnable {
    public final Runnable zza;

    public zzfqs(Runnable runnable) {
        if (runnable != null) {
            this.zza = runnable;
            return;
        }
        throw null;
    }

    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzi(th);
            zzfko.zza(th);
            throw new RuntimeException(th);
        }
    }
}
