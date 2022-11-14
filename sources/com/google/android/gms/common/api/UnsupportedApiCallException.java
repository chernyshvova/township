package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    public final Feature zza;

    @KeepForSdk
    public UnsupportedApiCallException(@RecentlyNonNull Feature feature) {
        this.zza = feature;
    }

    @RecentlyNonNull
    public String getMessage() {
        String valueOf = String.valueOf(this.zza);
        return GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 8), "Missing ", valueOf);
    }
}
