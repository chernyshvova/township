package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzl implements Callable<Void> {
    public final /* synthetic */ ConsumeParams zza;
    public final /* synthetic */ ConsumeResponseListener zzb;
    public final /* synthetic */ BillingClientImpl zzc;

    public zzl(BillingClientImpl billingClientImpl, ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        this.zzc = billingClientImpl;
        this.zza = consumeParams;
        this.zzb = consumeResponseListener;
    }

    public final Object call() throws Exception {
        int i;
        String str;
        BillingClientImpl billingClientImpl = this.zzc;
        ConsumeParams consumeParams = this.zza;
        ConsumeResponseListener consumeResponseListener = this.zzb;
        if (billingClientImpl != null) {
            String str2 = consumeParams.zza;
            try {
                String valueOf = String.valueOf(str2);
                zzb.zza("BillingClient", valueOf.length() != 0 ? "Consuming purchase with token: ".concat(valueOf) : new String("Consuming purchase with token: "));
                if (billingClientImpl.zzm) {
                    Bundle zzc2 = billingClientImpl.zzg.zzc(9, billingClientImpl.zzf.getPackageName(), str2, zzb.zza(consumeParams, billingClientImpl.zzm, billingClientImpl.zzb));
                    i = zzc2.getInt(InAppPurchaseEventManager.RESPONSE_CODE);
                    str = zzb.zzb(zzc2, "BillingClient");
                } else {
                    i = billingClientImpl.zzg.zzb(3, billingClientImpl.zzf.getPackageName(), str2);
                    str = "";
                }
                BillingResult.Builder newBuilder = BillingResult.newBuilder();
                newBuilder.zza = i;
                newBuilder.zzb = str;
                BillingResult build = newBuilder.build();
                if (i == 0) {
                    billingClientImpl.zza((Runnable) new zzx(consumeResponseListener, build, str2));
                } else {
                    billingClientImpl.zza((Runnable) new zzw(i, consumeResponseListener, build, str2));
                }
            } catch (Exception e) {
                billingClientImpl.zza((Runnable) new zzz(e, consumeResponseListener, str2));
            }
            return null;
        }
        throw null;
    }
}
