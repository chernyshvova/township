package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.internal.WorkQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkQueue.kt */
public final class WorkQueue {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    public final Executor executor;
    public final int maxConcurrent;
    public WorkNode pendingJobs;
    public int runningCount;
    public WorkNode runningJobs;
    public final ReentrantLock workLock;

    /* compiled from: WorkQueue.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: assert  reason: not valid java name */
        public final void m3634assert(boolean z) {
            if (!z) {
                throw new FacebookException("Validation failed");
            }
        }
    }

    /* compiled from: WorkQueue.kt */
    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    /* compiled from: WorkQueue.kt */
    public final class WorkNode implements WorkItem {
        public final Runnable callback;
        public boolean isRunning;
        public WorkNode next;
        public WorkNode prev;
        public final /* synthetic */ WorkQueue this$0;

        public WorkNode(WorkQueue workQueue, Runnable runnable) {
            Intrinsics.checkNotNullParameter(workQueue, "this$0");
            Intrinsics.checkNotNullParameter(runnable, "callback");
            this.this$0 = workQueue;
            this.callback = runnable;
        }

        public final WorkNode addToList(WorkNode workNode, boolean z) {
            boolean z2 = true;
            WorkQueue.Companion.m3634assert(this.next == null);
            Companion companion = WorkQueue.Companion;
            if (this.prev != null) {
                z2 = false;
            }
            companion.m3634assert(z2);
            if (workNode == null) {
                this.prev = this;
                this.next = this;
                workNode = this;
            } else {
                this.next = workNode;
                WorkNode workNode2 = workNode.prev;
                this.prev = workNode2;
                if (workNode2 != null) {
                    workNode2.next = this;
                }
                WorkNode workNode3 = this.next;
                if (workNode3 != null) {
                    WorkNode workNode4 = this.prev;
                    workNode3.prev = workNode4 == null ? null : workNode4.next;
                }
            }
            if (workNode != null) {
                return z ? this : workNode;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public boolean cancel() {
            ReentrantLock access$getWorkLock$p = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            access$getWorkLock$p.lock();
            try {
                if (!isRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    return true;
                }
                access$getWorkLock$p.unlock();
                return false;
            } finally {
                access$getWorkLock$p.unlock();
            }
        }

        public final Runnable getCallback() {
            return this.callback;
        }

        public final WorkNode getNext() {
            return this.next;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        public void moveToFront() {
            ReentrantLock access$getWorkLock$p = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            access$getWorkLock$p.lock();
            try {
                if (!isRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    workQueue.pendingJobs = addToList(workQueue.pendingJobs, true);
                }
            } finally {
                access$getWorkLock$p.unlock();
            }
        }

        public final WorkNode removeFromList(WorkNode workNode) {
            boolean z = true;
            WorkQueue.Companion.m3634assert(this.next != null);
            Companion companion = WorkQueue.Companion;
            if (this.prev == null) {
                z = false;
            }
            companion.m3634assert(z);
            if (workNode == this && (workNode = this.next) == this) {
                workNode = null;
            }
            WorkNode workNode2 = this.next;
            if (workNode2 != null) {
                workNode2.prev = this.prev;
            }
            WorkNode workNode3 = this.prev;
            if (workNode3 != null) {
                workNode3.next = this.next;
            }
            this.prev = null;
            this.next = null;
            return workNode;
        }

        public void setRunning(boolean z) {
            this.isRunning = z;
        }

        public final void verify(boolean z) {
            WorkNode workNode;
            WorkNode workNode2;
            Companion companion = WorkQueue.Companion;
            WorkNode workNode3 = this.prev;
            if (workNode3 == null || (workNode = workNode3.next) == null) {
                workNode = this;
            }
            boolean z2 = true;
            companion.m3634assert(workNode == this);
            Companion companion2 = WorkQueue.Companion;
            WorkNode workNode4 = this.next;
            if (workNode4 == null || (workNode2 = workNode4.prev) == null) {
                workNode2 = this;
            }
            companion2.m3634assert(workNode2 == this);
            Companion companion3 = WorkQueue.Companion;
            if (isRunning() != z) {
                z2 = false;
            }
            companion3.m3634assert(z2);
        }
    }

    public WorkQueue() {
        this(0, (Executor) null, 3, (DefaultConstructorMarker) null);
    }

    public WorkQueue(int i) {
        this(i, (Executor) null, 2, (DefaultConstructorMarker) null);
    }

    public WorkQueue(int i, Executor executor2) {
        Intrinsics.checkNotNullParameter(executor2, "executor");
        this.maxConcurrent = i;
        this.executor = executor2;
        this.workLock = new ReentrantLock();
    }

    public static /* synthetic */ WorkItem addActiveWorkItem$default(WorkQueue workQueue, Runnable runnable, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return workQueue.addActiveWorkItem(runnable, z);
    }

    private final void execute(WorkNode workNode) {
        this.executor.execute(new Runnable(this) {
            public final /* synthetic */ WorkQueue f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                WorkQueue.m3633execute$lambda2(WorkQueue.WorkNode.this, this.f$1);
            }
        });
    }

    /* renamed from: execute$lambda-2  reason: not valid java name */
    public static final void m3633execute$lambda2(WorkNode workNode, WorkQueue workQueue) {
        Intrinsics.checkNotNullParameter(workNode, "$node");
        Intrinsics.checkNotNullParameter(workQueue, "this$0");
        try {
            workNode.getCallback().run();
        } finally {
            workQueue.finishItemAndStartNew(workNode);
        }
    }

    private final void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2;
        this.workLock.lock();
        if (workNode != null) {
            this.runningJobs = workNode.removeFromList(this.runningJobs);
            this.runningCount--;
        }
        if (this.runningCount < this.maxConcurrent) {
            workNode2 = this.pendingJobs;
            if (workNode2 != null) {
                this.pendingJobs = workNode2.removeFromList(workNode2);
                this.runningJobs = workNode2.addToList(this.runningJobs, false);
                this.runningCount++;
                workNode2.setRunning(true);
            }
        } else {
            workNode2 = null;
        }
        this.workLock.unlock();
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private final void startItem() {
        finishItemAndStartNew((WorkNode) null);
    }

    public final WorkItem addActiveWorkItem(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "callback");
        return addActiveWorkItem$default(this, runnable, false, 2, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    public final WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        Intrinsics.checkNotNullParameter(runnable, "callback");
        WorkNode workNode = new WorkNode(this, runnable);
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z);
            reentrantLock.unlock();
            startItem();
            return workNode;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void validate() {
        int i;
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            boolean z = false;
            if (this.runningJobs != null) {
                WorkNode workNode = this.runningJobs;
                i = 0;
                while (workNode != null) {
                    workNode.verify(true);
                    i++;
                    workNode = workNode.getNext();
                    if (workNode == this.runningJobs) {
                    }
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            i = 0;
            Companion companion = Companion;
            if (this.runningCount == i) {
                z = true;
            }
            companion.m3634assert(z);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkQueue(int r1, java.util.concurrent.Executor r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            r1 = 8
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0010
            com.facebook.FacebookSdk r2 = com.facebook.FacebookSdk.INSTANCE
            java.util.concurrent.Executor r2 = com.facebook.FacebookSdk.getExecutor()
        L_0x0010:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WorkQueue.<init>(int, java.util.concurrent.Executor, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
