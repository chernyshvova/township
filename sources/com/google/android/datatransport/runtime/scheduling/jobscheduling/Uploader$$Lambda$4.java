package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class Uploader$$Lambda$4 implements SynchronizationGuard.CriticalSection {
    public final EventStore arg$1;

    public Uploader$$Lambda$4(EventStore eventStore) {
        this.arg$1 = eventStore;
    }

    public Object execute() {
        return Integer.valueOf(this.arg$1.cleanUp());
    }
}
