package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener;
import com.google.android.ump.ConsentRequestParameters;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzj {
    public final zzal zza;
    public final zzp zzb;
    public final zzaz zzc;

    public zzj(zzal zzal, zzp zzp, zzaz zzaz) {
        this.zza = zzal;
        this.zzb = zzp;
        this.zzc = zzaz;
    }

    public final int getConsentStatus() {
        return this.zza.zza();
    }

    public final int getConsentType() {
        return this.zza.zzb();
    }

    public final boolean isConsentFormAvailable() {
        return this.zzc.zza();
    }

    public final void requestConsentInfoUpdate(@Nullable Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener, ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener) {
        this.zzb.zza(activity, consentRequestParameters, consentInformation$OnConsentInfoUpdateSuccessListener, consentInformation$OnConsentInfoUpdateFailureListener);
    }

    public final void reset() {
        this.zzc.zza((zzbb) null);
        this.zza.zzf();
    }
}
