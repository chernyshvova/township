package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import java.util.concurrent.Future;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzs implements Runnable {
    public final /* synthetic */ Future zza;
    public final /* synthetic */ Runnable zzb;

    public zzs(Future future, Runnable runnable) {
        this.zza = future;
        this.zzb = runnable;
    }

    public final void run() {
        if (!this.zza.isDone() && !this.zza.isCancelled()) {
            this.zza.cancel(true);
            zzb.zzb("BillingClient", "Async task is taking too long, cancel it!");
            Runnable runnable = this.zzb;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
