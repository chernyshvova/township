package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class AsyncTimeout extends Timeout {
    public static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    public static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    @Nullable
    public static AsyncTimeout head;
    public boolean inQueue;
    @Nullable
    public AsyncTimeout next;
    public long timeoutAt;

    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                okio.AsyncTimeout r1 = okio.AsyncTimeout.awaitTimeout()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                okio.AsyncTimeout r2 = okio.AsyncTimeout.head     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                okio.AsyncTimeout.head = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x001d
            L_0x001c:
                throw r1
            L_0x001d:
                goto L_0x001c
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    @Nullable
    public static AsyncTimeout awaitTimeout() throws InterruptedException {
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        AsyncTimeout asyncTimeout = head.next;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            cls.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long nanoTime2 = asyncTimeout.timeoutAt - System.nanoTime();
        if (nanoTime2 > 0) {
            long j = nanoTime2 / 1000000;
            cls.wait(j, (int) (nanoTime2 - (1000000 * j)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    public final void enter() {
        if (!this.inQueue) {
            long j = this.timeoutNanos;
            boolean z = this.hasDeadline;
            if (j != 0 || z) {
                this.inQueue = true;
                Class<AsyncTimeout> cls = AsyncTimeout.class;
                synchronized (cls) {
                    if (head == null) {
                        head = new AsyncTimeout();
                        new Watchdog().start();
                    }
                    long nanoTime = System.nanoTime();
                    if (j != 0 && z) {
                        this.timeoutAt = Math.min(j, deadlineNanoTime() - nanoTime) + nanoTime;
                    } else if (j != 0) {
                        this.timeoutAt = j + nanoTime;
                    } else if (z) {
                        this.timeoutAt = deadlineNanoTime();
                    } else {
                        throw new AssertionError();
                    }
                    long j2 = this.timeoutAt - nanoTime;
                    AsyncTimeout asyncTimeout = head;
                    while (true) {
                        if (asyncTimeout.next == null) {
                            break;
                        } else if (j2 < asyncTimeout.next.timeoutAt - nanoTime) {
                            break;
                        } else {
                            asyncTimeout = asyncTimeout.next;
                        }
                    }
                    this.next = asyncTimeout.next;
                    asyncTimeout.next = this;
                    if (asyncTimeout == head) {
                        cls.notify();
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        boolean z = false;
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout = head;
            while (true) {
                if (asyncTimeout == null) {
                    z = true;
                    break;
                } else if (asyncTimeout.next == this) {
                    asyncTimeout.next = this.next;
                    this.next = null;
                    break;
                } else {
                    asyncTimeout = asyncTimeout.next;
                }
            }
        }
        return z;
    }

    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void timedOut() {
    }

    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException((IOException) null);
        }
    }
}
