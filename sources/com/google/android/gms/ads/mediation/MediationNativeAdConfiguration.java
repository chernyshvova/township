package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.internal.ads.zzblw;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class MediationNativeAdConfiguration extends MediationAdConfiguration {
    @Nullable
    public final zzblw zza;

    public MediationNativeAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i, int i2, @Nullable String str2, String str3, @Nullable zzblw zzblw) {
        super(context, str, bundle, bundle2, z, location, i, i2, str2, str3);
        this.zza = zzblw;
    }

    @RecentlyNonNull
    public NativeAdOptions getNativeAdOptions() {
        return zzblw.zza(this.zza);
    }
}
