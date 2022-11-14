package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.ConfigValue {
    public final long delta;
    public final Set<SchedulerConfig.Flag> flags;
    public final long maxAllowedDelay;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static final class Builder extends SchedulerConfig.ConfigValue.Builder {
        public Long delta;
        public Set<SchedulerConfig.Flag> flags;
        public Long maxAllowedDelay;

        public SchedulerConfig.ConfigValue build() {
            String str = this.delta == null ? " delta" : "";
            if (this.maxAllowedDelay == null) {
                str = GeneratedOutlineSupport.outline16(str, " maxAllowedDelay");
            }
            if (this.flags == null) {
                str = GeneratedOutlineSupport.outline16(str, " flags");
            }
            if (str.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.delta.longValue(), this.maxAllowedDelay.longValue(), this.flags, (C16161) null);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str));
        }

        public SchedulerConfig.ConfigValue.Builder setDelta(long j) {
            this.delta = Long.valueOf(j);
            return this;
        }

        public SchedulerConfig.ConfigValue.Builder setMaxAllowedDelay(long j) {
            this.maxAllowedDelay = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_SchedulerConfig_ConfigValue(long j, long j2, Set set, C16161 r6) {
        this.delta = j;
        this.maxAllowedDelay = j2;
        this.flags = set;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = (AutoValue_SchedulerConfig_ConfigValue) ((SchedulerConfig.ConfigValue) obj);
        if (this.delta == autoValue_SchedulerConfig_ConfigValue.delta && this.maxAllowedDelay == autoValue_SchedulerConfig_ConfigValue.maxAllowedDelay && this.flags.equals(autoValue_SchedulerConfig_ConfigValue.flags)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.delta;
        long j2 = this.maxAllowedDelay;
        return this.flags.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("ConfigValue{delta=");
        outline24.append(this.delta);
        outline24.append(", maxAllowedDelay=");
        outline24.append(this.maxAllowedDelay);
        outline24.append(", flags=");
        outline24.append(this.flags);
        outline24.append("}");
        return outline24.toString();
    }
}
