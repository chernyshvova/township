package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final /* synthetic */ class zzw implements Runnable {
    public final ConsentInformation$OnConsentInfoUpdateFailureListener zza;
    public final zzk zzb;

    public zzw(ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener, zzk zzk) {
        this.zza = consentInformation$OnConsentInfoUpdateFailureListener;
        this.zzb = zzk;
    }

    public final void run() {
        this.zza.onConsentInfoUpdateFailure(this.zzb.zza());
    }
}
