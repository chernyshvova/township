package com.google.android.datatransport.runtime.scheduling.persistence;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class AutoValue_EventStoreConfig extends EventStoreConfig {
    public final int criticalSectionEnterTimeoutMs;
    public final long eventCleanUpAge;
    public final int loadBatchSize;
    public final long maxStorageSizeInBytes;

    public AutoValue_EventStoreConfig(long j, int i, int i2, long j2, C16171 r7) {
        this.maxStorageSizeInBytes = j;
        this.loadBatchSize = i;
        this.criticalSectionEnterTimeoutMs = i2;
        this.eventCleanUpAge = j2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        AutoValue_EventStoreConfig autoValue_EventStoreConfig = (AutoValue_EventStoreConfig) ((EventStoreConfig) obj);
        if (this.maxStorageSizeInBytes == autoValue_EventStoreConfig.maxStorageSizeInBytes && this.loadBatchSize == autoValue_EventStoreConfig.loadBatchSize && this.criticalSectionEnterTimeoutMs == autoValue_EventStoreConfig.criticalSectionEnterTimeoutMs && this.eventCleanUpAge == autoValue_EventStoreConfig.eventCleanUpAge) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.maxStorageSizeInBytes;
        long j2 = this.eventCleanUpAge;
        return ((int) (j2 ^ (j2 >>> 32))) ^ ((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.loadBatchSize) * 1000003) ^ this.criticalSectionEnterTimeoutMs) * 1000003);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("EventStoreConfig{maxStorageSizeInBytes=");
        outline24.append(this.maxStorageSizeInBytes);
        outline24.append(", loadBatchSize=");
        outline24.append(this.loadBatchSize);
        outline24.append(", criticalSectionEnterTimeoutMs=");
        outline24.append(this.criticalSectionEnterTimeoutMs);
        outline24.append(", eventCleanUpAge=");
        outline24.append(this.eventCleanUpAge);
        outline24.append("}");
        return outline24.toString();
    }
}
