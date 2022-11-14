package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzax implements UserMessagingPlatform$OnConsentFormLoadFailureListener, UserMessagingPlatform$OnConsentFormLoadSuccessListener {
    public final UserMessagingPlatform$OnConsentFormLoadSuccessListener zza;
    public final UserMessagingPlatform$OnConsentFormLoadFailureListener zzb;

    public zzax(UserMessagingPlatform$OnConsentFormLoadSuccessListener userMessagingPlatform$OnConsentFormLoadSuccessListener, UserMessagingPlatform$OnConsentFormLoadFailureListener userMessagingPlatform$OnConsentFormLoadFailureListener) {
        this.zza = userMessagingPlatform$OnConsentFormLoadSuccessListener;
        this.zzb = userMessagingPlatform$OnConsentFormLoadFailureListener;
    }

    public final void onConsentFormLoadFailure(FormError formError) {
        this.zzb.onConsentFormLoadFailure(formError);
    }

    public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
        this.zza.onConsentFormLoadSuccess(consentForm);
    }
}
