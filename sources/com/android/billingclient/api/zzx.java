package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzx implements Runnable {
    public final /* synthetic */ ConsumeResponseListener zza;
    public final /* synthetic */ BillingResult zzb;
    public final /* synthetic */ String zzc;

    public zzx(ConsumeResponseListener consumeResponseListener, BillingResult billingResult, String str) {
        this.zza = consumeResponseListener;
        this.zzb = billingResult;
        this.zzc = str;
    }

    public final void run() {
        zzb.zza("BillingClient", "Successfully consumed purchase.");
        this.zza.onConsumeResponse(this.zzb, this.zzc);
    }
}
