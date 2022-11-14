package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import com.google.android.ump.FormError;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzk extends Exception {
    public final int zza;

    public zzk(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final String getMessage() {
        return super.getMessage();
    }

    public final FormError zza() {
        if (getCause() == null) {
            Log.w("UserMessagingPlatform", getMessage());
        } else {
            Log.w("UserMessagingPlatform", getMessage(), getCause());
        }
        return new FormError(this.zza, getMessage());
    }

    public zzk(int i, String str, Throwable th) {
        super(str, th);
        this.zza = i;
    }
}
