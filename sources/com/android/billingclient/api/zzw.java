package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzw implements Runnable {
    public final /* synthetic */ int zza;
    public final /* synthetic */ ConsumeResponseListener zzb;
    public final /* synthetic */ BillingResult zzc;
    public final /* synthetic */ String zzd;

    public zzw(int i, ConsumeResponseListener consumeResponseListener, BillingResult billingResult, String str) {
        this.zza = i;
        this.zzb = consumeResponseListener;
        this.zzc = billingResult;
        this.zzd = str;
    }

    public final void run() {
        int i = this.zza;
        StringBuilder sb = new StringBuilder(63);
        sb.append("Error consuming purchase with token. Response code: ");
        sb.append(i);
        zzb.zzb("BillingClient", sb.toString());
        this.zzb.onConsumeResponse(this.zzc, this.zzd);
    }
}
