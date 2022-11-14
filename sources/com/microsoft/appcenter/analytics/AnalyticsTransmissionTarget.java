package com.microsoft.appcenter.analytics;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.HashMap;

public class AnalyticsTransmissionTarget {
    public Context mContext;
    public final AnalyticsTransmissionTarget mParentTarget = null;
    public final PropertyConfigurator mPropertyConfigurator = new PropertyConfigurator(this);
    public final String mTransmissionTargetToken;

    public AnalyticsTransmissionTarget(@NonNull String str, AnalyticsTransmissionTarget analyticsTransmissionTarget) {
        new HashMap();
        this.mTransmissionTargetToken = str;
    }

    @WorkerThread
    public final boolean isEnabledInStorage() {
        StringBuilder sb = new StringBuilder();
        Analytics instance = Analytics.getInstance();
        sb.append(instance.getEnabledPreferenceKey() + "/");
        sb.append(PartAUtils.getTargetKey(this.mTransmissionTargetToken));
        return SharedPreferencesManager.getBoolean(sb.toString(), true);
    }
}
