package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class Uploader$$Lambda$5 implements SynchronizationGuard.CriticalSection {
    public final Uploader arg$1;
    public final TransportContext arg$2;
    public final int arg$3;

    public Uploader$$Lambda$5(Uploader uploader, TransportContext transportContext, int i) {
        this.arg$1 = uploader;
        this.arg$2 = transportContext;
        this.arg$3 = i;
    }

    public Object execute() {
        Uploader uploader = this.arg$1;
        uploader.workScheduler.schedule(this.arg$2, this.arg$3 + 1);
        return null;
    }
}
