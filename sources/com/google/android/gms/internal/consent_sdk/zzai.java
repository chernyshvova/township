package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import com.google.android.gms.internal.consent_sdk.zzc;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzai implements zzc.zza {
    public Application zza;

    public zzai() {
    }

    public final zzc zza() {
        zzcu.zza(this.zza, Application.class);
        return new zzag(this.zza, (zzaf) null);
    }

    public /* synthetic */ zzai(zzaf zzaf) {
        this();
    }

    public final /* synthetic */ zzc.zza zza(Application application) {
        this.zza = (Application) zzcu.zza(application);
        return this;
    }
}
