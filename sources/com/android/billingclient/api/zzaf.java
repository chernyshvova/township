package com.android.billingclient.api;

import com.android.billingclient.api.BillingClientImpl;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzaf implements Runnable {
    public final /* synthetic */ BillingClientImpl.zza zza;

    public zzaf(BillingClientImpl.zza zza2) {
        this.zza = zza2;
    }

    public final void run() {
        BillingClientImpl.zza zza2 = this.zza;
        BillingClientImpl billingClientImpl = BillingClientImpl.this;
        billingClientImpl.zza = 0;
        billingClientImpl.zzg = null;
        BillingClientImpl.zza.zza(zza2, zzak.zzp);
    }
}
