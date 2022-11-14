package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class WorkInitializer$$Lambda$2 implements SynchronizationGuard.CriticalSection {
    public final WorkInitializer arg$1;

    public WorkInitializer$$Lambda$2(WorkInitializer workInitializer) {
        this.arg$1 = workInitializer;
    }

    public Object execute() {
        WorkInitializer workInitializer = this.arg$1;
        for (TransportContext schedule : workInitializer.store.loadActiveContexts()) {
            workInitializer.scheduler.schedule(schedule, 1);
        }
        return null;
    }
}
