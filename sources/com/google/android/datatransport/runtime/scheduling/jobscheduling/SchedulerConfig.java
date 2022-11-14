package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class SchedulerConfig {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class ConfigValue {

        /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
        public static abstract class Builder {
            public abstract ConfigValue build();

            public abstract Builder setDelta(long j);

            public abstract Builder setMaxAllowedDelay(long j);
        }

        public static Builder builder() {
            AutoValue_SchedulerConfig_ConfigValue.Builder builder = new AutoValue_SchedulerConfig_ConfigValue.Builder();
            Set<Flag> emptySet = Collections.emptySet();
            if (emptySet != null) {
                builder.flags = emptySet;
                return builder;
            }
            throw new NullPointerException("Null flags");
        }
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public long getScheduleDelay(Priority priority, long j, int i) {
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) this;
        AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = (AutoValue_SchedulerConfig_ConfigValue) autoValue_SchedulerConfig.values.get(priority);
        return Math.min(Math.max(((long) Math.pow(2.0d, (double) (i - 1))) * autoValue_SchedulerConfig_ConfigValue.delta, j - autoValue_SchedulerConfig.clock.getTime()), autoValue_SchedulerConfig_ConfigValue.maxAllowedDelay);
    }
}
