package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzad implements Callable<Bundle> {
    public final /* synthetic */ SkuDetails zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ BillingClientImpl zzc;

    public zzad(BillingClientImpl billingClientImpl, SkuDetails skuDetails, String str) {
        this.zzc = billingClientImpl;
        this.zza = skuDetails;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        BillingClientImpl billingClientImpl = this.zzc;
        return billingClientImpl.zzg.zza(3, billingClientImpl.zzf.getPackageName(), this.zza.getSku(), this.zzb, (String) null);
    }
}
