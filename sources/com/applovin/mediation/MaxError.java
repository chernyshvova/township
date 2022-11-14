package com.applovin.mediation;

import androidx.annotation.Nullable;

public interface MaxError {
    @Deprecated
    String getAdLoadFailureInfo();

    int getCode();

    String getMessage();

    @Nullable
    MaxAdWaterfallInfo getWaterfall();
}
