package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzaz {
    public final zzct<zzau> zza;
    public final AtomicReference<zzbb> zzb = new AtomicReference<>();

    public zzaz(zzct<zzau> zzct) {
        this.zza = zzct;
    }

    public final void zza(zzbb zzbb) {
        this.zzb.set(zzbb);
    }

    public final void zza(UserMessagingPlatform$OnConsentFormLoadSuccessListener userMessagingPlatform$OnConsentFormLoadSuccessListener, UserMessagingPlatform$OnConsentFormLoadFailureListener userMessagingPlatform$OnConsentFormLoadFailureListener) {
        zzcd.zza();
        zzbb zzbb = this.zzb.get();
        if (zzbb == null) {
            userMessagingPlatform$OnConsentFormLoadFailureListener.onConsentFormLoadFailure(new zzk(3, "No available form can be built.").zza());
        } else {
            this.zza.zza().zza(zzbb).zza().zza().zza(userMessagingPlatform$OnConsentFormLoadSuccessListener, userMessagingPlatform$OnConsentFormLoadFailureListener);
        }
    }

    public final boolean zza() {
        return this.zzb.get() != null;
    }
}
