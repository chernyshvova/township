package com.helpshift.specifications;

import java.util.concurrent.TimeUnit;

public class GenericSyncSpecification implements SyncSpecification {
    public final int dataChangeThreshold;
    public final String dataType;
    public final long elapsedTimeThreshold;

    public GenericSyncSpecification(int i, long j, TimeUnit timeUnit, String str) {
        this.dataChangeThreshold = i;
        this.elapsedTimeThreshold = TimeUnit.MILLISECONDS.convert(j, timeUnit);
        this.dataType = str;
    }

    public String getDataType() {
        return this.dataType;
    }

    public boolean isSatisfied(int i, long j) {
        return i >= this.dataChangeThreshold || Math.abs(j) > this.elapsedTimeThreshold;
    }
}
