package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzz implements Runnable {
    public final /* synthetic */ Exception zza;
    public final /* synthetic */ ConsumeResponseListener zzb;
    public final /* synthetic */ String zzc;

    public zzz(Exception exc, ConsumeResponseListener consumeResponseListener, String str) {
        this.zza = exc;
        this.zzb = consumeResponseListener;
        this.zzc = str;
    }

    public final void run() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(valueOf.length() + 30);
        sb.append("Error consuming purchase; ex: ");
        sb.append(valueOf);
        zzb.zzb("BillingClient", sb.toString());
        this.zzb.onConsumeResponse(zzak.zzo, this.zzc);
    }
}
