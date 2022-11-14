package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final /* synthetic */ class zzu implements Runnable {
    public final ConsentInformation$OnConsentInfoUpdateSuccessListener zza;

    public zzu(ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener) {
        this.zza = consentInformation$OnConsentInfoUpdateSuccessListener;
    }

    public static Runnable zza(ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener) {
        return new zzu(consentInformation$OnConsentInfoUpdateSuccessListener);
    }

    public final void run() {
        this.zza.onConsentInfoUpdateSuccess();
    }
}
