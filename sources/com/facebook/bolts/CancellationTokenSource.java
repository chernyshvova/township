package com.facebook.bolts;

import com.applovin.sdk.AppLovinEventTypes;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CancellationTokenSource.kt */
public final class CancellationTokenSource implements Closeable {
    public boolean cancellationRequested;
    public boolean closed;
    public final ScheduledExecutorService executor = BoltsExecutors.Companion.scheduled$facebook_bolts_release();
    public final Object lock = new Object();
    public final List<CancellationTokenRegistration> registrations = new ArrayList();
    public ScheduledFuture<?> scheduledCancellation;

    /* renamed from: cancelAfter$lambda-6$lambda-5  reason: not valid java name */
    public static final void m3597cancelAfter$lambda6$lambda5(CancellationTokenSource cancellationTokenSource) {
        Intrinsics.checkNotNullParameter(cancellationTokenSource, "this$0");
        synchronized (cancellationTokenSource.lock) {
            cancellationTokenSource.scheduledCancellation = null;
        }
        cancellationTokenSource.cancel();
    }

    private final void cancelScheduledCancellation() {
        ScheduledFuture<?> scheduledFuture = this.scheduledCancellation;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.scheduledCancellation = null;
        }
    }

    private final void notifyListeners(List<CancellationTokenRegistration> list) {
        for (CancellationTokenRegistration runAction$facebook_bolts_release : list) {
            runAction$facebook_bolts_release.runAction$facebook_bolts_release();
        }
    }

    private final void throwIfClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("Object already closed".toString());
        }
    }

    public final void cancel() {
        synchronized (this.lock) {
            throwIfClosed();
            if (!this.cancellationRequested) {
                cancelScheduledCancellation();
                this.cancellationRequested = true;
                ArrayList arrayList = new ArrayList(this.registrations);
                notifyListeners(arrayList);
            }
        }
    }

    public final void cancelAfter(long j) {
        cancelAfter(j, TimeUnit.MILLISECONDS);
    }

    public void close() {
        synchronized (this.lock) {
            if (!this.closed) {
                cancelScheduledCancellation();
                for (CancellationTokenRegistration close : this.registrations) {
                    close.close();
                }
                this.registrations.clear();
                this.closed = true;
            }
        }
    }

    public final CancellationToken getToken() {
        CancellationToken cancellationToken;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public final boolean isCancellationRequested() {
        boolean z;
        synchronized (this.lock) {
            throwIfClosed();
            z = this.cancellationRequested;
        }
        return z;
    }

    public final CancellationTokenRegistration register$facebook_bolts_release(Runnable runnable) {
        CancellationTokenRegistration cancellationTokenRegistration;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationTokenRegistration = new CancellationTokenRegistration(this, runnable);
            if (this.cancellationRequested) {
                cancellationTokenRegistration.runAction$facebook_bolts_release();
            } else {
                this.registrations.add(cancellationTokenRegistration);
            }
        }
        return cancellationTokenRegistration;
    }

    public final void throwIfCancellationRequested$facebook_bolts_release() throws CancellationException {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                throw new CancellationException();
            }
        }
    }

    public String toString() {
        String format = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{CancellationTokenSource.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested())}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public final void unregister$facebook_bolts_release(CancellationTokenRegistration cancellationTokenRegistration) {
        Intrinsics.checkNotNullParameter(cancellationTokenRegistration, AppLovinEventTypes.USER_CREATED_ACCOUNT);
        synchronized (this.lock) {
            throwIfClosed();
            this.registrations.remove(cancellationTokenRegistration);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void cancelAfter(long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r5 = this;
            r0 = -1
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0008
            r2 = 1
            goto L_0x0009
        L_0x0008:
            r2 = 0
        L_0x0009:
            if (r2 == 0) goto L_0x0037
            r2 = 0
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0015
            r5.cancel()
            return
        L_0x0015:
            java.lang.Object r2 = r5.lock
            monitor-enter(r2)
            boolean r3 = r5.cancellationRequested     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x001e
            monitor-exit(r2)
            return
        L_0x001e:
            r5.cancelScheduledCancellation()     // Catch:{ all -> 0x0034 }
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 == 0) goto L_0x0032
            java.util.concurrent.ScheduledExecutorService r0 = r5.executor     // Catch:{ all -> 0x0034 }
            com.facebook.bolts.-$$Lambda$B7ZdbOb9P5KpeZDB5Bc9P4dtpBM r1 = new com.facebook.bolts.-$$Lambda$B7ZdbOb9P5KpeZDB5Bc9P4dtpBM     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.util.concurrent.ScheduledFuture r6 = r0.schedule(r1, r6, r8)     // Catch:{ all -> 0x0034 }
            r5.scheduledCancellation = r6     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r2)
            return
        L_0x0034:
            r6 = move-exception
            monitor-exit(r2)
            throw r6
        L_0x0037:
            java.lang.String r6 = "Delay must be >= -1"
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bolts.CancellationTokenSource.cancelAfter(long, java.util.concurrent.TimeUnit):void");
    }
}
