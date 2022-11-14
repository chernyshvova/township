package com.google.ads;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public enum AdRequest$ErrorCode {
    INVALID_REQUEST("Invalid Ad request."),
    NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
    NETWORK_ERROR("A network error occurred."),
    INTERNAL_ERROR("There was an internal error.");
    
    public final String zza;

    /* access modifiers changed from: public */
    AdRequest$ErrorCode(String str) {
        this.zza = str;
    }

    @RecentlyNonNull
    public String toString() {
        return this.zza;
    }
}
