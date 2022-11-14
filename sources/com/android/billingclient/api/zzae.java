package com.android.billingclient.api;

import com.android.billingclient.api.BillingClientImpl;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzae implements Runnable {
    public final /* synthetic */ BillingResult zza;
    public final /* synthetic */ BillingClientImpl.zza zzb;

    public zzae(BillingClientImpl.zza zza2, BillingResult billingResult) {
        this.zzb = zza2;
        this.zza = billingResult;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzd != null) {
                this.zzb.zzd.onBillingSetupFinished(this.zza);
            }
        }
    }
}
