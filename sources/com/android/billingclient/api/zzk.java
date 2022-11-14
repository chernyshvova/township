package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzk implements Runnable {
    public final /* synthetic */ ConsumeResponseListener zza;
    public final /* synthetic */ ConsumeParams zzb;

    public zzk(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        this.zza = consumeResponseListener;
        this.zzb = consumeParams;
    }

    public final void run() {
        this.zza.onConsumeResponse(zzak.zzp, this.zzb.zza);
    }
}
