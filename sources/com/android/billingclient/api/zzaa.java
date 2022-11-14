package com.android.billingclient.api;

import android.os.Bundle;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzaa implements Callable<Bundle> {
    public final /* synthetic */ BillingFlowParams zza;
    public final /* synthetic */ SkuDetails zzb;
    public final /* synthetic */ BillingClientImpl zzc;

    public zzaa(BillingClientImpl billingClientImpl, BillingFlowParams billingFlowParams, SkuDetails skuDetails) {
        this.zzc = billingClientImpl;
        this.zza = billingFlowParams;
        this.zzb = skuDetails;
    }

    public final Object call() throws Exception {
        BillingClientImpl billingClientImpl = this.zzc;
        return billingClientImpl.zzg.zza(5, billingClientImpl.zzf.getPackageName(), (List<String>) Arrays.asList(new String[]{this.zza.zzc}), this.zzb.getSku(), InAppPurchaseEventManager.SUBSCRIPTION, (String) null);
    }
}
