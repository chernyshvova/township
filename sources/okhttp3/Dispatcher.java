package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import okhttp3.RealCall;

public final class Dispatcher {
    @Nullable
    public ExecutorService executorService;
    public int maxRequests = 64;
    public int maxRequestsPerHost = 5;
    public final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque();
    public final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque();
    public final Deque<RealCall> runningSyncCalls = new ArrayDeque();

    public final <T> void finished(Deque<T> deque, T t) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        boolean promoteAndExecute = promoteAndExecute();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final boolean promoteAndExecute() {
        /*
            r15 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            monitor-enter(r15)
            java.util.Deque<okhttp3.RealCall$AsyncCall> r1 = r15.readyAsyncCalls     // Catch:{ all -> 0x00c2 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00c2 }
        L_0x000c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00c2 }
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00c2 }
            okhttp3.RealCall$AsyncCall r2 = (okhttp3.RealCall.AsyncCall) r2     // Catch:{ all -> 0x00c2 }
            java.util.Deque<okhttp3.RealCall$AsyncCall> r3 = r15.runningAsyncCalls     // Catch:{ all -> 0x00c2 }
            int r3 = r3.size()     // Catch:{ all -> 0x00c2 }
            int r4 = r15.maxRequests     // Catch:{ all -> 0x00c2 }
            if (r3 < r4) goto L_0x0023
            goto L_0x0038
        L_0x0023:
            int r3 = r15.runningCallsForHost(r2)     // Catch:{ all -> 0x00c2 }
            int r4 = r15.maxRequestsPerHost     // Catch:{ all -> 0x00c2 }
            if (r3 < r4) goto L_0x002c
            goto L_0x000c
        L_0x002c:
            r1.remove()     // Catch:{ all -> 0x00c2 }
            r0.add(r2)     // Catch:{ all -> 0x00c2 }
            java.util.Deque<okhttp3.RealCall$AsyncCall> r3 = r15.runningAsyncCalls     // Catch:{ all -> 0x00c2 }
            r3.add(r2)     // Catch:{ all -> 0x00c2 }
            goto L_0x000c
        L_0x0038:
            monitor-enter(r15)     // Catch:{ all -> 0x00c2 }
            java.util.Deque<okhttp3.RealCall$AsyncCall> r1 = r15.runningAsyncCalls     // Catch:{ all -> 0x00bf }
            int r1 = r1.size()     // Catch:{ all -> 0x00bf }
            java.util.Deque<okhttp3.RealCall> r2 = r15.runningSyncCalls     // Catch:{ all -> 0x00bf }
            int r2 = r2.size()     // Catch:{ all -> 0x00bf }
            int r1 = r1 + r2
            monitor-exit(r15)     // Catch:{ all -> 0x00c2 }
            r2 = 0
            if (r1 <= 0) goto L_0x004c
            r1 = 1
            goto L_0x004d
        L_0x004c:
            r1 = 0
        L_0x004d:
            monitor-exit(r15)     // Catch:{ all -> 0x00c2 }
            int r3 = r0.size()
            r4 = 0
        L_0x0053:
            if (r4 >= r3) goto L_0x00be
            java.lang.Object r5 = r0.get(r4)
            okhttp3.RealCall$AsyncCall r5 = (okhttp3.RealCall.AsyncCall) r5
            monitor-enter(r15)
            java.util.concurrent.ExecutorService r6 = r15.executorService     // Catch:{ all -> 0x00bb }
            if (r6 != 0) goto L_0x007b
            java.util.concurrent.ThreadPoolExecutor r6 = new java.util.concurrent.ThreadPoolExecutor     // Catch:{ all -> 0x00bb }
            r8 = 0
            r9 = 2147483647(0x7fffffff, float:NaN)
            r10 = 60
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00bb }
            java.util.concurrent.SynchronousQueue r13 = new java.util.concurrent.SynchronousQueue     // Catch:{ all -> 0x00bb }
            r13.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = "OkHttp Dispatcher"
            java.util.concurrent.ThreadFactory r14 = okhttp3.internal.Util.threadFactory(r7, r2)     // Catch:{ all -> 0x00bb }
            r7 = r6
            r7.<init>(r8, r9, r10, r12, r13, r14)     // Catch:{ all -> 0x00bb }
            r15.executorService = r6     // Catch:{ all -> 0x00bb }
        L_0x007b:
            java.util.concurrent.ExecutorService r6 = r15.executorService     // Catch:{ all -> 0x00bb }
            monitor-exit(r15)
            r7 = 0
            if (r5 == 0) goto L_0x00ba
            r6.execute(r5)     // Catch:{ RejectedExecutionException -> 0x0087 }
            goto L_0x00aa
        L_0x0085:
            r0 = move-exception
            goto L_0x00ae
        L_0x0087:
            r6 = move-exception
            java.io.InterruptedIOException r8 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0085 }
            java.lang.String r9 = "executor rejected"
            r8.<init>(r9)     // Catch:{ all -> 0x0085 }
            r8.initCause(r6)     // Catch:{ all -> 0x0085 }
            okhttp3.RealCall r6 = okhttp3.RealCall.this     // Catch:{ all -> 0x0085 }
            okhttp3.EventListener r6 = r6.eventListener     // Catch:{ all -> 0x0085 }
            if (r6 == 0) goto L_0x00ad
            okhttp3.Callback r6 = r5.responseCallback     // Catch:{ all -> 0x0085 }
            okhttp3.RealCall r7 = okhttp3.RealCall.this     // Catch:{ all -> 0x0085 }
            r6.onFailure(r7, r8)     // Catch:{ all -> 0x0085 }
            okhttp3.RealCall r6 = okhttp3.RealCall.this
            okhttp3.OkHttpClient r6 = r6.client
            okhttp3.Dispatcher r6 = r6.dispatcher
            java.util.Deque<okhttp3.RealCall$AsyncCall> r7 = r6.runningAsyncCalls
            r6.finished(r7, r5)
        L_0x00aa:
            int r4 = r4 + 1
            goto L_0x0053
        L_0x00ad:
            throw r7     // Catch:{ all -> 0x0085 }
        L_0x00ae:
            okhttp3.RealCall r1 = okhttp3.RealCall.this
            okhttp3.OkHttpClient r1 = r1.client
            okhttp3.Dispatcher r1 = r1.dispatcher
            java.util.Deque<okhttp3.RealCall$AsyncCall> r2 = r1.runningAsyncCalls
            r1.finished(r2, r5)
            throw r0
        L_0x00ba:
            throw r7
        L_0x00bb:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        L_0x00be:
            return r1
        L_0x00bf:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x00c2 }
            throw r0     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x00c2 }
            goto L_0x00c6
        L_0x00c5:
            throw r0
        L_0x00c6:
            goto L_0x00c5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Dispatcher.promoteAndExecute():boolean");
    }

    public final int runningCallsForHost(RealCall.AsyncCall asyncCall) {
        int i = 0;
        for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
            RealCall realCall = RealCall.this;
            if (!realCall.forWebSocket && realCall.originalRequest.url.host.equals(RealCall.this.originalRequest.url.host)) {
                i++;
            }
        }
        return i;
    }
}
