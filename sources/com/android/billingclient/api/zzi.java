package com.android.billingclient.api;

import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzi implements Runnable {
    public final /* synthetic */ SkuDetailsResponseListener zza;

    public zzi(SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zza = skuDetailsResponseListener;
    }

    public final void run() {
        this.zza.onSkuDetailsResponse(zzak.zzp, (List<SkuDetails>) null);
    }
}
