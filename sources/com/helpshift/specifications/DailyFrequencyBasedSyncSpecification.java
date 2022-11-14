package com.helpshift.specifications;

import android.annotation.TargetApi;
import com.helpshift.model.InfoModelFactory;
import java.util.concurrent.TimeUnit;

public class DailyFrequencyBasedSyncSpecification implements SyncSpecification {
    public final String dataType;
    public final long elapsedTimeThreshold;

    @TargetApi(9)
    public DailyFrequencyBasedSyncSpecification(int i, String str) {
        this.elapsedTimeThreshold = TimeUnit.MILLISECONDS.convert((long) (24 / i), TimeUnit.HOURS);
        this.dataType = str;
    }

    public String getDataType() {
        return this.dataType;
    }

    public boolean isSatisfied(int i, long j) {
        return InfoModelFactory.getInstance().sdkInfoModel.getDevicePropertiesSyncImmediately().booleanValue() || (i > 0 && Math.abs(j) > this.elapsedTimeThreshold);
    }
}
