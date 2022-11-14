package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzo implements Callable<Void> {
    public final /* synthetic */ AcknowledgePurchaseResponseListener zza;
    public final /* synthetic */ AcknowledgePurchaseParams zzb;
    public final /* synthetic */ BillingClientImpl zzc;

    public zzo(BillingClientImpl billingClientImpl, AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zzc = billingClientImpl;
        this.zzb = acknowledgePurchaseParams;
        this.zza = acknowledgePurchaseResponseListener;
    }

    public final Object call() throws Exception {
        try {
            Bundle zzd = this.zzc.zzg.zzd(9, this.zzc.zzf.getPackageName(), this.zzb.zza, zzb.zza(this.zzb, this.zzc.zzb));
            this.zzc.zza((Runnable) new zzq(this, zzb.zza(zzd, "BillingClient"), zzb.zzb(zzd, "BillingClient")));
            return null;
        } catch (Exception e) {
            this.zzc.zza((Runnable) new zzr(this, e));
            return null;
        }
    }
}
