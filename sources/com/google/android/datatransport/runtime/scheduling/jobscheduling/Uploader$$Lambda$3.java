package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class Uploader$$Lambda$3 implements SynchronizationGuard.CriticalSection {
    public final Uploader arg$1;
    public final BackendResponse arg$2;
    public final Iterable arg$3;
    public final TransportContext arg$4;
    public final int arg$5;

    public Uploader$$Lambda$3(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        this.arg$1 = uploader;
        this.arg$2 = backendResponse;
        this.arg$3 = iterable;
        this.arg$4 = transportContext;
        this.arg$5 = i;
    }

    public Object execute() {
        Uploader uploader = this.arg$1;
        BackendResponse backendResponse = this.arg$2;
        Iterable iterable = this.arg$3;
        TransportContext transportContext = this.arg$4;
        int i = this.arg$5;
        AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) backendResponse;
        if (autoValue_BackendResponse.status == BackendResponse.Status.TRANSIENT_ERROR) {
            uploader.eventStore.recordFailure(iterable);
            uploader.workScheduler.schedule(transportContext, i + 1);
            return null;
        }
        uploader.eventStore.recordSuccess(iterable);
        if (autoValue_BackendResponse.status == BackendResponse.Status.OK) {
            uploader.eventStore.recordNextCallTime(transportContext, uploader.clock.getTime() + autoValue_BackendResponse.nextRequestWaitMillis);
        }
        if (!uploader.eventStore.hasPendingEventsFor(transportContext)) {
            return null;
        }
        uploader.workScheduler.schedule(transportContext, 1);
        return null;
    }
}
