package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import android.os.Build;
import com.android.billingclient.api.zzam;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class SchedulingModule_WorkSchedulerFactory implements Object<WorkScheduler> {
    public final Provider<Clock> clockProvider;
    public final Provider<SchedulerConfig> configProvider;
    public final Provider<Context> contextProvider;
    public final Provider<EventStore> eventStoreProvider;

    public SchedulingModule_WorkSchedulerFactory(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        this.contextProvider = provider;
        this.eventStoreProvider = provider2;
        this.configProvider = provider3;
        this.clockProvider = provider4;
    }

    public Object get() {
        Object obj;
        Context context = this.contextProvider.get();
        EventStore eventStore = this.eventStoreProvider.get();
        SchedulerConfig schedulerConfig = this.configProvider.get();
        Clock clock = this.clockProvider.get();
        if (Build.VERSION.SDK_INT >= 21) {
            obj = new JobInfoScheduler(context, eventStore, schedulerConfig);
        } else {
            obj = new AlarmManagerScheduler(context, eventStore, clock, schedulerConfig);
        }
        zzam.checkNotNull1(obj, "Cannot return null from a non-@Nullable @Provides method");
        return obj;
    }
}
