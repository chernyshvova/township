package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzb {
    public final Application zza;

    public zzb(Application application) {
        this.zza = application;
    }

    @Nullable
    public final zza zza() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zza);
            return new zza(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            zzca.zza("Failed to get ad id.", e);
            return null;
        }
    }
}
