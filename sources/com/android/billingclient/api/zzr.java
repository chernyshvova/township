package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzr implements Runnable {
    public final /* synthetic */ Exception zza;
    public final /* synthetic */ zzo zzb;

    public zzr(zzo zzo, Exception exc) {
        this.zzb = zzo;
        this.zza = exc;
    }

    public final void run() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(valueOf.length() + 32);
        sb.append("Error acknowledge purchase; ex: ");
        sb.append(valueOf);
        zzb.zzb("BillingClient", sb.toString());
        this.zzb.zza.onAcknowledgePurchaseResponse(zzak.zzo);
    }
}
