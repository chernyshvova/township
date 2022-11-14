package com.google.firebase.iid;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final class WakeLockHolder {
    public static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    public static final Object syncObject = new Object();
    @GuardedBy("WakeLockHolder.syncObject")
    public static WakeLock wakeLock;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.ComponentName startWakefulService(@androidx.annotation.NonNull android.content.Context r4, @androidx.annotation.NonNull android.content.Intent r5) {
        /*
            java.lang.Object r0 = syncObject
            monitor-enter(r0)
            com.google.android.gms.stats.WakeLock r1 = wakeLock     // Catch:{ all -> 0x0034 }
            r2 = 1
            if (r1 != 0) goto L_0x0014
            com.google.android.gms.stats.WakeLock r1 = new com.google.android.gms.stats.WakeLock     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "wake:com.google.firebase.iid.WakeLockHolder"
            r1.<init>(r4, r2, r3)     // Catch:{ all -> 0x0034 }
            wakeLock = r1     // Catch:{ all -> 0x0034 }
            r1.setReferenceCounted(r2)     // Catch:{ all -> 0x0034 }
        L_0x0014:
            java.lang.String r1 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r3 = 0
            boolean r1 = r5.getBooleanExtra(r1, r3)     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r5.putExtra(r3, r2)     // Catch:{ all -> 0x0034 }
            android.content.ComponentName r4 = r4.startService(r5)     // Catch:{ all -> 0x0034 }
            if (r4 != 0) goto L_0x0029
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return r4
        L_0x0029:
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.stats.WakeLock r5 = wakeLock     // Catch:{ all -> 0x0034 }
            long r1 = WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS     // Catch:{ all -> 0x0034 }
            r5.acquire(r1)     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return r4
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.WakeLockHolder.startWakefulService(android.content.Context, android.content.Intent):android.content.ComponentName");
    }
}
