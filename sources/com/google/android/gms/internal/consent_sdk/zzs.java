package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener;
import com.google.android.ump.ConsentRequestParameters;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final /* synthetic */ class zzs implements Runnable {
    public final zzp zza;
    public final Activity zzb;
    public final ConsentRequestParameters zzc;
    public final ConsentInformation$OnConsentInfoUpdateSuccessListener zzd;
    public final ConsentInformation$OnConsentInfoUpdateFailureListener zze;

    public zzs(zzp zzp, Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener, ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener) {
        this.zza = zzp;
        this.zzb = activity;
        this.zzc = consentRequestParameters;
        this.zzd = consentInformation$OnConsentInfoUpdateSuccessListener;
        this.zze = consentInformation$OnConsentInfoUpdateFailureListener;
    }

    public final void run() {
        this.zza.zzb(this.zzb, (ConsentRequestParameters) null, this.zzd, this.zze);
    }
}
