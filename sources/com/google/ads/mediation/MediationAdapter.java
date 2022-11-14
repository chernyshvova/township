package com.google.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.ads.mediation.MediationServerParameters;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS extends MediationServerParameters> {
    void destroy();

    @RecentlyNonNull
    Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();

    @RecentlyNonNull
    Class<SERVER_PARAMETERS> getServerParametersType();
}
