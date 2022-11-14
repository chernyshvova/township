package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class AutoValue_SchedulerConfig extends SchedulerConfig {
    public final Clock clock;
    public final Map<Priority, SchedulerConfig.ConfigValue> values;

    public AutoValue_SchedulerConfig(Clock clock2, Map<Priority, SchedulerConfig.ConfigValue> map) {
        if (clock2 != null) {
            this.clock = clock2;
            if (map != null) {
                this.values = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) ((SchedulerConfig) obj);
        if (!this.clock.equals(autoValue_SchedulerConfig.clock) || !this.values.equals(autoValue_SchedulerConfig.values)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.clock.hashCode() ^ 1000003) * 1000003) ^ this.values.hashCode();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("SchedulerConfig{clock=");
        outline24.append(this.clock);
        outline24.append(", values=");
        outline24.append(this.values);
        outline24.append("}");
        return outline24.toString();
    }
}
