package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class Uploader$$Lambda$2 implements SynchronizationGuard.CriticalSection {
    public final Uploader arg$1;
    public final TransportContext arg$2;

    public Uploader$$Lambda$2(Uploader uploader, TransportContext transportContext) {
        this.arg$1 = uploader;
        this.arg$2 = transportContext;
    }

    public Object execute() {
        Uploader uploader = this.arg$1;
        return uploader.eventStore.loadBatch(this.arg$2);
    }
}
