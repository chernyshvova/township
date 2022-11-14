package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzab implements Callable<Bundle> {
    public final /* synthetic */ int zza;
    public final /* synthetic */ SkuDetails zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ BillingFlowParams zzd;
    public final /* synthetic */ Bundle zze;
    public final /* synthetic */ BillingClientImpl zzf;

    public zzab(BillingClientImpl billingClientImpl, int i, SkuDetails skuDetails, String str, BillingFlowParams billingFlowParams, Bundle bundle) {
        this.zzf = billingClientImpl;
        this.zza = i;
        this.zzb = skuDetails;
        this.zzc = str;
        this.zzd = billingFlowParams;
        this.zze = bundle;
    }

    public final Object call() throws Exception {
        BillingClientImpl billingClientImpl = this.zzf;
        return billingClientImpl.zzg.zza(this.zza, billingClientImpl.zzf.getPackageName(), this.zzb.getSku(), this.zzc, this.zzd.zza, this.zze);
    }
}
