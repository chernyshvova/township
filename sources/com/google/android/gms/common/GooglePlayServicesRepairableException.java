package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    public final int zza;

    public GooglePlayServicesRepairableException(int i, @RecentlyNonNull String str, @RecentlyNonNull Intent intent) {
        super(str, intent);
        this.zza = i;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}
