package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class AdMobExtras implements NetworkExtras {
    @Nullable
    public final Bundle zza;

    public AdMobExtras(@RecentlyNonNull Bundle bundle) {
        this.zza = bundle != null ? new Bundle(bundle) : null;
    }

    @RecentlyNullable
    public Bundle getExtras() {
        return this.zza;
    }
}
