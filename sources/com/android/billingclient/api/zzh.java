package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzh extends ResultReceiver {
    public final /* synthetic */ BillingClientImpl zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzh(BillingClientImpl billingClientImpl, Handler handler) {
        super(handler);
        this.zza = billingClientImpl;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        PurchasesUpdatedListener purchasesUpdatedListener = this.zza.zzd.zzb.zza;
        if (purchasesUpdatedListener == null) {
            zzb.zzb("BillingClient", "PurchasesUpdatedListener is null - no way to return the response.");
            return;
        }
        List<Purchase> zza2 = zzb.zza(bundle);
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.zza = i;
        newBuilder.zzb = zzb.zzb(bundle, "BillingClient");
        purchasesUpdatedListener.onPurchasesUpdated(newBuilder.build(), zza2);
    }
}
