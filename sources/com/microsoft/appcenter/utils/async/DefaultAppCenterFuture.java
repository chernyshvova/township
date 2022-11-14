package com.microsoft.appcenter.utils.async;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;

public class DefaultAppCenterFuture<T> {
    public Collection<AppCenterConsumer<T>> mConsumers;
    public final CountDownLatch mLatch = new CountDownLatch(1);
    public T mResult;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:1|2|(3:4|5|(1:7))|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[SYNTHETIC, Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void complete(final T r5) {
        /*
            r4 = this;
            monitor-enter(r4)
        L_0x0001:
            java.util.concurrent.CountDownLatch r0 = r4.mLatch     // Catch:{ InterruptedException -> 0x0001 }
            r1 = 0
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0001 }
            boolean r0 = r0.await(r1, r3)     // Catch:{ InterruptedException -> 0x0001 }
            if (r0 != 0) goto L_0x0020
            r4.mResult = r5     // Catch:{ all -> 0x0022 }
            java.util.concurrent.CountDownLatch r0 = r4.mLatch     // Catch:{ all -> 0x0022 }
            r0.countDown()     // Catch:{ all -> 0x0022 }
            java.util.Collection<com.microsoft.appcenter.utils.async.AppCenterConsumer<T>> r0 = r4.mConsumers     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            com.microsoft.appcenter.utils.async.DefaultAppCenterFuture$2 r0 = new com.microsoft.appcenter.utils.async.DefaultAppCenterFuture$2     // Catch:{ all -> 0x0022 }
            r0.<init>(r5)     // Catch:{ all -> 0x0022 }
            com.microsoft.appcenter.utils.HandlerUtils.runOnUiThread(r0)     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r4)
            return
        L_0x0022:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.utils.async.DefaultAppCenterFuture.complete(java.lang.Object):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:1|2|(2:4|5)(3:6|(1:8)|9)|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[SYNTHETIC, Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void thenAccept(final com.microsoft.appcenter.utils.async.AppCenterConsumer<T> r5) {
        /*
            r4 = this;
            monitor-enter(r4)
        L_0x0001:
            java.util.concurrent.CountDownLatch r0 = r4.mLatch     // Catch:{ InterruptedException -> 0x0001 }
            r1 = 0
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0001 }
            boolean r0 = r0.await(r1, r3)     // Catch:{ InterruptedException -> 0x0001 }
            if (r0 == 0) goto L_0x0016
            com.microsoft.appcenter.utils.async.DefaultAppCenterFuture$1 r0 = new com.microsoft.appcenter.utils.async.DefaultAppCenterFuture$1     // Catch:{ all -> 0x0028 }
            r0.<init>(r5)     // Catch:{ all -> 0x0028 }
            com.microsoft.appcenter.utils.HandlerUtils.runOnUiThread(r0)     // Catch:{ all -> 0x0028 }
            goto L_0x0026
        L_0x0016:
            java.util.Collection<com.microsoft.appcenter.utils.async.AppCenterConsumer<T>> r0 = r4.mConsumers     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0021
            java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x0028 }
            r0.<init>()     // Catch:{ all -> 0x0028 }
            r4.mConsumers = r0     // Catch:{ all -> 0x0028 }
        L_0x0021:
            java.util.Collection<com.microsoft.appcenter.utils.async.AppCenterConsumer<T>> r0 = r4.mConsumers     // Catch:{ all -> 0x0028 }
            r0.add(r5)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r4)
            return
        L_0x0028:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.utils.async.DefaultAppCenterFuture.thenAccept(com.microsoft.appcenter.utils.async.AppCenterConsumer):void");
    }
}
