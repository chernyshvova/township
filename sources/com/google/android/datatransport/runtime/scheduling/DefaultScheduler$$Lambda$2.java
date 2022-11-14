package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class DefaultScheduler$$Lambda$2 implements SynchronizationGuard.CriticalSection {
    public final DefaultScheduler arg$1;
    public final TransportContext arg$2;
    public final EventInternal arg$3;

    public DefaultScheduler$$Lambda$2(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.arg$1 = defaultScheduler;
        this.arg$2 = transportContext;
        this.arg$3 = eventInternal;
    }

    public Object execute() {
        DefaultScheduler defaultScheduler = this.arg$1;
        TransportContext transportContext = this.arg$2;
        defaultScheduler.eventStore.persist(transportContext, this.arg$3);
        defaultScheduler.workScheduler.schedule(transportContext, 1);
        return null;
    }
}
