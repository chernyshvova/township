package com.google.ads.mediation;

import android.location.Location;
import androidx.annotation.RecentlyNonNull;
import com.google.ads.AdRequest$Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class MediationAdRequest {
    public final Location zze;

    public MediationAdRequest(@RecentlyNonNull Date date, @RecentlyNonNull AdRequest$Gender adRequest$Gender, @RecentlyNonNull Set<String> set, boolean z, @RecentlyNonNull Location location) {
        this.zze = location;
    }
}
