package com.google.android.gms.ads.mediation;

import android.location.Location;
import androidx.annotation.RecentlyNonNull;
import java.util.Date;
import java.util.Set;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface MediationAdRequest {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;

    @RecentlyNonNull
    @Deprecated
    Date getBirthday();

    @Deprecated
    int getGender();

    @RecentlyNonNull
    Set<String> getKeywords();

    @RecentlyNonNull
    Location getLocation();

    @Deprecated
    boolean isDesignedForFamilies();

    boolean isTesting();

    int taggedForChildDirectedTreatment();
}
