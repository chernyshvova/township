package com.android.billingclient.api;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzj implements Runnable {
    public final /* synthetic */ SkuDetails.zza zza;
    public final /* synthetic */ zzg zzb;

    public zzj(zzg zzg, SkuDetails.zza zza2) {
        this.zzb = zzg;
        this.zza = zza2;
    }

    public final void run() {
        SkuDetailsResponseListener skuDetailsResponseListener = this.zzb.zza;
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        SkuDetails.zza zza2 = this.zza;
        newBuilder.zza = zza2.zzb;
        newBuilder.zzb = zza2.zzc;
        skuDetailsResponseListener.onSkuDetailsResponse(newBuilder.build(), this.zza.zza);
    }
}
