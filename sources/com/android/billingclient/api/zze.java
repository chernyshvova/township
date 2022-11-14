package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zze extends BroadcastReceiver {
    public final PurchasesUpdatedListener zza;
    public boolean zzb;
    public final /* synthetic */ zzd zzc;

    public zze(zzd zzd, PurchasesUpdatedListener purchasesUpdatedListener, zzc zzc2) {
        this.zzc = zzd;
        this.zza = purchasesUpdatedListener;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.onPurchasesUpdated(zzb.zzb(intent, "BillingBroadcastManager"), zzb.zza(intent.getExtras()));
    }
}
