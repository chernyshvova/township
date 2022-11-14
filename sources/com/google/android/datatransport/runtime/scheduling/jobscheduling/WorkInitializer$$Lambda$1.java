package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class WorkInitializer$$Lambda$1 implements Runnable {
    public final WorkInitializer arg$1;

    public WorkInitializer$$Lambda$1(WorkInitializer workInitializer) {
        this.arg$1 = workInitializer;
    }

    public void run() {
        WorkInitializer workInitializer = this.arg$1;
        workInitializer.guard.runCriticalSection(new WorkInitializer$$Lambda$2(workInitializer));
    }
}
