package com.helpshift.specifications;

import com.helpshift.util.ErrorReportProvider;
import java.util.concurrent.TimeUnit;

public class DecayingIntervalSyncSpecification implements SyncSpecification {
    public final String dataType;
    public long elapsedTimeThreshold;
    public long maxTimeThresholdLimit = ErrorReportProvider.BATCH_TIME;

    public DecayingIntervalSyncSpecification(int i, TimeUnit timeUnit, String str) {
        this.elapsedTimeThreshold = TimeUnit.MILLISECONDS.convert((long) i, timeUnit);
        this.dataType = str;
    }

    public void decayElapsedTimeThreshold() {
        double d = (double) this.elapsedTimeThreshold;
        Double.isNaN(d);
        long j = (long) (d * 1.618d);
        this.elapsedTimeThreshold = j;
        long j2 = this.maxTimeThresholdLimit;
        if (j > j2) {
            this.elapsedTimeThreshold = j2;
        }
    }

    public String getDataType() {
        return this.dataType;
    }

    public boolean isSatisfied(int i, long j) {
        return i > 0 && Math.abs(j) > this.elapsedTimeThreshold;
    }
}
