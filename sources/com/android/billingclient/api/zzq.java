package com.android.billingclient.api;

import com.android.billingclient.api.BillingResult;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzq implements Runnable {
    public final /* synthetic */ int zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzo zzc;

    public zzq(zzo zzo, int i, String str) {
        this.zzc = zzo;
        this.zza = i;
        this.zzb = str;
    }

    public final void run() {
        AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener = this.zzc.zza;
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.zza = this.zza;
        newBuilder.zzb = this.zzb;
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(newBuilder.build());
    }
}
