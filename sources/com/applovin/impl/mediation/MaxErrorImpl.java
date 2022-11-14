package com.applovin.impl.mediation;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxError;

public class MaxErrorImpl implements MaxError {
    @Nullable
    public String adLoadFailureInfo;
    public final int errorCode;
    public final String errorMessage;
    public String loadTag;
    public MaxAdWaterfallInfo waterfall;

    public MaxErrorImpl(int i) {
        this(i, "");
    }

    public MaxErrorImpl(int i, String str) {
        this.errorCode = i;
        this.errorMessage = StringUtils.emptyIfNull(str);
    }

    public MaxErrorImpl(String str) {
        this(-1, str);
    }

    @Nullable
    public String getAdLoadFailureInfo() {
        return this.adLoadFailureInfo;
    }

    public int getCode() {
        return this.errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public String getLoadTag() {
        return this.loadTag;
    }

    public String getMessage() {
        return this.errorMessage;
    }

    @Nullable
    public MaxAdWaterfallInfo getWaterfall() {
        return this.waterfall;
    }

    public void setAdLoadFailureInfo(@Nullable String str) {
        this.adLoadFailureInfo = str;
    }

    public void setLoadTag(@Nullable String str) {
        this.loadTag = str;
    }

    public void setWaterfall(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.waterfall = maxAdWaterfallInfo;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MaxError{code=");
        outline24.append(getCode());
        outline24.append(", message='");
        outline24.append(getMessage());
        outline24.append('\'');
        outline24.append('}');
        return outline24.toString();
    }
}
