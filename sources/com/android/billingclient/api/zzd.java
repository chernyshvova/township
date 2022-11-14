package com.android.billingclient.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzd {
    public final Context zza;
    public final zze zzb;

    public zzd(Context context, @NonNull PurchasesUpdatedListener purchasesUpdatedListener) {
        this.zza = context;
        this.zzb = new zze(this, purchasesUpdatedListener, (zzc) null);
    }

    public final void zzc() {
        zze zze = this.zzb;
        Context context = this.zza;
        if (zze.zzb) {
            context.unregisterReceiver(zze.zzc.zzb);
            zze.zzb = false;
            return;
        }
        zzb.zzb("BillingBroadcastManager", "Receiver is not registered.");
    }
}
