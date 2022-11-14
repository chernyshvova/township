package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdFormat;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class MediationConfiguration {
    public final AdFormat zza;
    public final Bundle zzb;

    public MediationConfiguration(@RecentlyNonNull AdFormat adFormat, @RecentlyNonNull Bundle bundle) {
        this.zza = adFormat;
        this.zzb = bundle;
    }

    @RecentlyNonNull
    public AdFormat getFormat() {
        return this.zza;
    }

    @RecentlyNonNull
    public Bundle getServerParameters() {
        return this.zzb;
    }
}
