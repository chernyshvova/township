package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final /* synthetic */ class zzr implements Runnable {
    public final zzp zza;
    public final ConsentInformation$OnConsentInfoUpdateSuccessListener zzb;

    public zzr(zzp zzp, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener) {
        this.zza = zzp;
        this.zzb = consentInformation$OnConsentInfoUpdateSuccessListener;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
