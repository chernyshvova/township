package com.playrix.engine;

public abstract class ControlledRunnable implements Runnable {
    public volatile boolean finished = false;

    public abstract void controlledRun();

    public boolean isFinished() {
        return this.finished;
    }

    public final synchronized void run() {
        controlledRun();
        this.finished = true;
        notifyAll();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0001, code lost:
        continue;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void waitFinish() {
        /*
            r1 = this;
            monitor-enter(r1)
        L_0x0001:
            boolean r0 = r1.isFinished()     // Catch:{ all -> 0x0015 }
            if (r0 != 0) goto L_0x0013
            r1.wait()     // Catch:{ InterruptedException -> 0x000b }
            goto L_0x0001
        L_0x000b:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0015 }
            r0.interrupt()     // Catch:{ all -> 0x0015 }
            goto L_0x0001
        L_0x0013:
            monitor-exit(r1)
            return
        L_0x0015:
            r0 = move-exception
            monitor-exit(r1)
            goto L_0x0019
        L_0x0018:
            throw r0
        L_0x0019:
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.ControlledRunnable.waitFinish():void");
    }
}
