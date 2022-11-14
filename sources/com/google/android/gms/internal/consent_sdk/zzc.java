package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import androidx.annotation.GuardedBy;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public abstract class zzc {
    @GuardedBy("AppComponent.class")
    public static zzc zza;

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    public interface zza {
        zza zza(Application application);

        zzc zza();
    }

    public static zzc zza(Context context) {
        zzc zzc;
        synchronized (zzc.class) {
            if (zza == null) {
                zza = new zzai((zzaf) null).zza((Application) context.getApplicationContext()).zza();
            }
            zzc = zza;
        }
        return zzc;
    }

    public abstract zzj zza();

    public abstract zzaz zzb();
}
