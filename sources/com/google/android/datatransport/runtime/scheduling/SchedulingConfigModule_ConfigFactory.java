package com.google.android.datatransport.runtime.scheduling;

import com.android.billingclient.api.zzam;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import com.helpshift.util.ErrorReportProvider;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class SchedulingConfigModule_ConfigFactory implements Object<SchedulerConfig> {
    public final Provider<Clock> clockProvider;

    public SchedulingConfigModule_ConfigFactory(Provider<Clock> provider) {
        this.clockProvider = provider;
    }

    public Object get() {
        Clock clock = this.clockProvider.get();
        HashMap hashMap = new HashMap();
        Priority priority = Priority.DEFAULT;
        SchedulerConfig.ConfigValue.Builder builder = SchedulerConfig.ConfigValue.builder();
        builder.setDelta(30000);
        builder.setMaxAllowedDelay(ErrorReportProvider.BATCH_TIME);
        hashMap.put(priority, builder.build());
        Priority priority2 = Priority.HIGHEST;
        SchedulerConfig.ConfigValue.Builder builder2 = SchedulerConfig.ConfigValue.builder();
        builder2.setDelta(1000);
        builder2.setMaxAllowedDelay(ErrorReportProvider.BATCH_TIME);
        hashMap.put(priority2, builder2.build());
        Priority priority3 = Priority.VERY_LOW;
        SchedulerConfig.ConfigValue.Builder builder3 = SchedulerConfig.ConfigValue.builder();
        builder3.setDelta(ErrorReportProvider.BATCH_TIME);
        builder3.setMaxAllowedDelay(ErrorReportProvider.BATCH_TIME);
        Set<SchedulerConfig.Flag> unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new SchedulerConfig.Flag[]{SchedulerConfig.Flag.NETWORK_UNMETERED, SchedulerConfig.Flag.DEVICE_IDLE})));
        AutoValue_SchedulerConfig_ConfigValue.Builder builder4 = (AutoValue_SchedulerConfig_ConfigValue.Builder) builder3;
        if (unmodifiableSet != null) {
            builder4.flags = unmodifiableSet;
            hashMap.put(priority3, builder4.build());
            if (clock == null) {
                throw new NullPointerException("missing required property: clock");
            } else if (hashMap.keySet().size() >= Priority.values().length) {
                new HashMap();
                AutoValue_SchedulerConfig autoValue_SchedulerConfig = new AutoValue_SchedulerConfig(clock, hashMap);
                zzam.checkNotNull1(autoValue_SchedulerConfig, "Cannot return null from a non-@Nullable @Provides method");
                return autoValue_SchedulerConfig;
            } else {
                throw new IllegalStateException("Not all priorities have been configured");
            }
        } else {
            throw new NullPointerException("Null flags");
        }
    }
}
