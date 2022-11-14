package com.playrix.engine;

import java.util.LinkedList;
import java.util.Queue;

public class DeferredExecuteQueue {
    public Queue<Runnable> deferredTasks = new LinkedList();

    public void execute(Runnable runnable) {
        if (runnable != null) {
            synchronized (this) {
                if (this.deferredTasks != null) {
                    this.deferredTasks.add(runnable);
                } else {
                    runnable.run();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        if (r0.hasNext() == false) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        ((java.lang.Runnable) r0.next()).run();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void process() {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            java.util.Queue<java.lang.Runnable> r0 = r2.deferredTasks     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
            return
        L_0x0007:
            java.util.Queue<java.lang.Runnable> r0 = r2.deferredTasks     // Catch:{ all -> 0x0032 }
            int r0 = r0.size()     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0014
            r0 = 0
            r2.deferredTasks = r0     // Catch:{ all -> 0x0032 }
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
            return
        L_0x0014:
            java.util.Queue<java.lang.Runnable> r0 = r2.deferredTasks     // Catch:{ all -> 0x0032 }
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            r2.deferredTasks = r1     // Catch:{ all -> 0x0032 }
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0000
            java.lang.Object r1 = r0.next()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r1.run()
            goto L_0x0022
        L_0x0032:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
            goto L_0x0036
        L_0x0035:
            throw r0
        L_0x0036:
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.DeferredExecuteQueue.process():void");
    }
}
