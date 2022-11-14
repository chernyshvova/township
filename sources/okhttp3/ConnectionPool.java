package okhttp3;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool {
    public static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    public final Runnable cleanupRunnable = new Runnable() {
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x007f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r14 = this;
            L_0x0000:
                okhttp3.ConnectionPool r0 = okhttp3.ConnectionPool.this
                long r1 = java.lang.System.nanoTime()
                monitor-enter(r0)
                java.util.Deque<okhttp3.internal.connection.RealConnection> r3 = r0.connections     // Catch:{ all -> 0x0084 }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0084 }
                r4 = 0
                r5 = -9223372036854775808
                r7 = 0
                r8 = 0
                r9 = 0
            L_0x0013:
                boolean r10 = r3.hasNext()     // Catch:{ all -> 0x0084 }
                if (r10 == 0) goto L_0x0035
                java.lang.Object r10 = r3.next()     // Catch:{ all -> 0x0084 }
                okhttp3.internal.connection.RealConnection r10 = (okhttp3.internal.connection.RealConnection) r10     // Catch:{ all -> 0x0084 }
                int r11 = r0.pruneAndGetAllocationCount(r10, r1)     // Catch:{ all -> 0x0084 }
                if (r11 <= 0) goto L_0x0028
                int r9 = r9 + 1
                goto L_0x0013
            L_0x0028:
                int r8 = r8 + 1
                long r11 = r10.idleAtNanos     // Catch:{ all -> 0x0084 }
                long r11 = r1 - r11
                int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r13 <= 0) goto L_0x0013
                r4 = r10
                r5 = r11
                goto L_0x0013
            L_0x0035:
                long r1 = r0.keepAliveDurationNs     // Catch:{ all -> 0x0084 }
                r10 = -1
                r12 = 0
                int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r3 >= 0) goto L_0x0056
                int r1 = r0.maxIdleConnections     // Catch:{ all -> 0x0084 }
                if (r8 <= r1) goto L_0x0044
                goto L_0x0056
            L_0x0044:
                if (r8 <= 0) goto L_0x004b
                long r1 = r0.keepAliveDurationNs     // Catch:{ all -> 0x0084 }
                long r1 = r1 - r5
                monitor-exit(r0)     // Catch:{ all -> 0x0084 }
                goto L_0x0062
            L_0x004b:
                if (r9 <= 0) goto L_0x0051
                long r1 = r0.keepAliveDurationNs     // Catch:{ all -> 0x0084 }
                monitor-exit(r0)     // Catch:{ all -> 0x0084 }
                goto L_0x0062
            L_0x0051:
                r0.cleanupRunning = r7     // Catch:{ all -> 0x0084 }
                monitor-exit(r0)     // Catch:{ all -> 0x0084 }
                r1 = r10
                goto L_0x0062
            L_0x0056:
                java.util.Deque<okhttp3.internal.connection.RealConnection> r1 = r0.connections     // Catch:{ all -> 0x0084 }
                r1.remove(r4)     // Catch:{ all -> 0x0084 }
                monitor-exit(r0)     // Catch:{ all -> 0x0084 }
                java.net.Socket r0 = r4.socket
                okhttp3.internal.Util.closeQuietly((java.net.Socket) r0)
                r1 = r12
            L_0x0062:
                int r0 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
                if (r0 != 0) goto L_0x0067
                return
            L_0x0067:
                int r0 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
                if (r0 <= 0) goto L_0x0000
                r3 = 1000000(0xf4240, double:4.940656E-318)
                long r5 = r1 / r3
                long r3 = r3 * r5
                long r1 = r1 - r3
                okhttp3.ConnectionPool r0 = okhttp3.ConnectionPool.this
                monitor-enter(r0)
                okhttp3.ConnectionPool r3 = okhttp3.ConnectionPool.this     // Catch:{ InterruptedException -> 0x007f }
                int r2 = (int) r1     // Catch:{ InterruptedException -> 0x007f }
                r3.wait(r5, r2)     // Catch:{ InterruptedException -> 0x007f }
                goto L_0x007f
            L_0x007d:
                r1 = move-exception
                goto L_0x0082
            L_0x007f:
                monitor-exit(r0)     // Catch:{ all -> 0x007d }
                goto L_0x0000
            L_0x0082:
                monitor-exit(r0)     // Catch:{ all -> 0x007d }
                throw r1
            L_0x0084:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0084 }
                goto L_0x0088
            L_0x0087:
                throw r1
            L_0x0088:
                goto L_0x0087
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.ConnectionPool.C20561.run():void");
        }
    };
    public boolean cleanupRunning;
    public final Deque<RealConnection> connections = new ArrayDeque();
    public final long keepAliveDurationNs;
    public final int maxIdleConnections = 5;
    public final RouteDatabase routeDatabase = new RouteDatabase();

    public ConnectionPool() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        this.keepAliveDurationNs = timeUnit.toNanos(5);
    }

    public final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i = 0;
        while (i < list.size()) {
            Reference reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("A connection to ");
                outline24.append(realConnection.route.address.url);
                outline24.append(" was leaked. Did you forget to close a response body?");
                Platform.PLATFORM.logCloseableLeak(outline24.toString(), ((StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
