package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzt implements Runnable {
    public final /* synthetic */ AcknowledgePurchaseResponseListener zza;

    public zzt(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zza = acknowledgePurchaseResponseListener;
    }

    public final void run() {
        this.zza.onAcknowledgePurchaseResponse(zzak.zzp);
    }
}
