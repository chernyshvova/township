package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class Uploader$$Lambda$1 implements Runnable {
    public final Uploader arg$1;
    public final TransportContext arg$2;
    public final int arg$3;
    public final Runnable arg$4;

    public Uploader$$Lambda$1(Uploader uploader, TransportContext transportContext, int i, Runnable runnable) {
        this.arg$1 = uploader;
        this.arg$2 = transportContext;
        this.arg$3 = i;
        this.arg$4 = runnable;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.workScheduler.schedule(r1, r2 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r3.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader r0 = r8.arg$1
            com.google.android.datatransport.runtime.TransportContext r1 = r8.arg$2
            int r2 = r8.arg$3
            java.lang.Runnable r3 = r8.arg$4
            r4 = 1
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r5 = r0.guard     // Catch:{ SynchronizationException -> 0x0044 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r6 = r0.eventStore     // Catch:{ SynchronizationException -> 0x0044 }
            r6.getClass()     // Catch:{ SynchronizationException -> 0x0044 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$4 r7 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$4     // Catch:{ SynchronizationException -> 0x0044 }
            r7.<init>(r6)     // Catch:{ SynchronizationException -> 0x0044 }
            r5.runCriticalSection(r7)     // Catch:{ SynchronizationException -> 0x0044 }
            android.content.Context r5 = r0.context     // Catch:{ SynchronizationException -> 0x0044 }
            java.lang.String r6 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r6)     // Catch:{ SynchronizationException -> 0x0044 }
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ SynchronizationException -> 0x0044 }
            android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()     // Catch:{ SynchronizationException -> 0x0044 }
            if (r5 == 0) goto L_0x0030
            boolean r5 = r5.isConnected()     // Catch:{ SynchronizationException -> 0x0044 }
            if (r5 == 0) goto L_0x0030
            r5 = 1
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            if (r5 != 0) goto L_0x003e
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r5 = r0.guard     // Catch:{ SynchronizationException -> 0x0044 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$5 r6 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$5     // Catch:{ SynchronizationException -> 0x0044 }
            r6.<init>(r0, r1, r2)     // Catch:{ SynchronizationException -> 0x0044 }
            r5.runCriticalSection(r6)     // Catch:{ SynchronizationException -> 0x0044 }
            goto L_0x004a
        L_0x003e:
            r0.logAndUpdateState(r1, r2)     // Catch:{ SynchronizationException -> 0x0044 }
            goto L_0x004a
        L_0x0042:
            r0 = move-exception
            goto L_0x004e
        L_0x0044:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r0 = r0.workScheduler     // Catch:{ all -> 0x0042 }
            int r2 = r2 + r4
            r0.schedule(r1, r2)     // Catch:{ all -> 0x0042 }
        L_0x004a:
            r3.run()
            return
        L_0x004e:
            r3.run()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$1.run():void");
    }
}
