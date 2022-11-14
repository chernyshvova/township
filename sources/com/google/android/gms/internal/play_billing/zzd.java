package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import com.facebook.appevents.iap.InAppPurchaseEventManager;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public abstract class zzd extends zze implements zza {
    public static zza zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(InAppPurchaseEventManager.IN_APP_BILLING_SERVICE);
        if (queryLocalInterface instanceof zza) {
            return (zza) queryLocalInterface;
        }
        return new zzc(iBinder);
    }
}
