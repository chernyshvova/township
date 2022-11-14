package com.applovin.impl.sdk.p024a;

import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.a.a */
public interface C1009a {
    C1010b getAdEventTracker();

    @Nullable
    String getOpenMeasurementContentUrl();

    String getOpenMeasurementCustomReferenceData();

    List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources();

    boolean isOpenMeasurementEnabled();
}
