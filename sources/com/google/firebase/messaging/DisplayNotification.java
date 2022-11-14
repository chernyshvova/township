package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public class DisplayNotification {
    public final Context context;
    public final Executor networkIoExecutor;
    public final NotificationParams params;

    public DisplayNotification(Context context2, NotificationParams notificationParams, Executor executor) {
        this.networkIoExecutor = executor;
        this.context = context2;
        this.params = notificationParams;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1 A[SYNTHETIC, Splitter:B:36:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleNotification() {
        /*
            r10 = this;
            com.google.firebase.messaging.NotificationParams r0 = r10.params
            java.lang.String r1 = "gcm.n.noui"
            boolean r0 = r0.getBoolean(r1)
            r1 = 1
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            android.content.Context r0 = r10.context
            java.lang.String r2 = "keyguard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.app.KeyguardManager r0 = (android.app.KeyguardManager) r0
            boolean r0 = r0.inKeyguardRestrictedInputMode()
            r2 = 0
            if (r0 == 0) goto L_0x001e
            goto L_0x0059
        L_0x001e:
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastLollipop()
            if (r0 != 0) goto L_0x0029
            r3 = 10
            android.os.SystemClock.sleep(r3)
        L_0x0029:
            int r0 = android.os.Process.myPid()
            android.content.Context r3 = r10.context
            java.lang.String r4 = "activity"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3
            java.util.List r3 = r3.getRunningAppProcesses()
            if (r3 == 0) goto L_0x0059
            java.util.Iterator r3 = r3.iterator()
        L_0x0041:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0059
            java.lang.Object r4 = r3.next()
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4
            int r5 = r4.pid
            if (r5 != r0) goto L_0x0041
            int r0 = r4.importance
            r3 = 100
            if (r0 != r3) goto L_0x0059
            r0 = 1
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            if (r0 == 0) goto L_0x005d
            return r2
        L_0x005d:
            com.google.firebase.messaging.NotificationParams r0 = r10.params
            java.lang.String r2 = "gcm.n.image"
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r3 = 0
            java.lang.String r4 = "FirebaseMessaging"
            if (r2 == 0) goto L_0x006f
            goto L_0x0094
        L_0x006f:
            com.google.firebase.messaging.ImageDownload r2 = new com.google.firebase.messaging.ImageDownload     // Catch:{ MalformedURLException -> 0x007a }
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x007a }
            r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x007a }
            r2.<init>(r5)     // Catch:{ MalformedURLException -> 0x007a }
            goto L_0x0095
        L_0x007a:
            java.lang.String r2 = "Not downloading image, bad URL: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r0.length()
            if (r5 == 0) goto L_0x008c
            java.lang.String r0 = r2.concat(r0)
            goto L_0x0091
        L_0x008c:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x0091:
            android.util.Log.w(r4, r0)
        L_0x0094:
            r2 = r3
        L_0x0095:
            if (r2 == 0) goto L_0x00a4
            java.util.concurrent.Executor r0 = r10.networkIoExecutor
            com.google.firebase.messaging.ImageDownload$$Lambda$0 r5 = new com.google.firebase.messaging.ImageDownload$$Lambda$0
            r5.<init>(r2)
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.call(r0, r5)
            r2.task = r0
        L_0x00a4:
            android.content.Context r0 = r10.context
            com.google.firebase.messaging.NotificationParams r5 = r10.params
            com.google.firebase.messaging.CommonNotificationBuilder$DisplayNotificationInfo r0 = com.google.firebase.messaging.CommonNotificationBuilder.createNotificationInfo(r0, r5)
            androidx.core.app.NotificationCompat$Builder r5 = r0.notificationBuilder
            if (r2 != 0) goto L_0x00b1
            goto L_0x0104
        L_0x00b1:
            com.google.android.gms.tasks.Task<android.graphics.Bitmap> r6 = r2.task     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            com.google.android.gms.tasks.Task r6 = (com.google.android.gms.tasks.Task) r6     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            r7 = 5
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            java.lang.Object r6 = com.google.android.gms.tasks.Tasks.await(r6, r7, r9)     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            r5.setLargeIcon(r6)     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            androidx.core.app.NotificationCompat$BigPictureStyle r7 = new androidx.core.app.NotificationCompat$BigPictureStyle     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            r7.<init>()     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            androidx.core.app.NotificationCompat$BigPictureStyle r6 = r7.bigPicture(r6)     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            androidx.core.app.NotificationCompat$BigPictureStyle r3 = r6.bigLargeIcon(r3)     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            r5.setStyle(r3)     // Catch:{ ExecutionException -> 0x00f0, InterruptedException -> 0x00e0, TimeoutException -> 0x00d7 }
            goto L_0x0104
        L_0x00d7:
            java.lang.String r3 = "Failed to download image in time, showing notification without it"
            android.util.Log.w(r4, r3)
            r2.close()
            goto L_0x0104
        L_0x00e0:
            java.lang.String r3 = "Interrupted while downloading image, showing notification without it"
            android.util.Log.w(r4, r3)
            r2.close()
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x0104
        L_0x00f0:
            r2 = move-exception
            java.lang.Throwable r2 = r2.getCause()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            int r3 = r3 + 26
            java.lang.String r5 = "Failed to download image: "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline30(r3, r5, r2, r4)
        L_0x0104:
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r4, r2)
            if (r2 == 0) goto L_0x0110
            java.lang.String r2 = "Showing notification"
            android.util.Log.d(r4, r2)
        L_0x0110:
            android.content.Context r2 = r10.context
            java.lang.String r3 = "notification"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.app.NotificationManager r2 = (android.app.NotificationManager) r2
            java.lang.String r3 = r0.tag
            int r4 = r0.f3313id
            androidx.core.app.NotificationCompat$Builder r0 = r0.notificationBuilder
            android.app.Notification r0 = r0.build()
            r2.notify(r3, r4, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.DisplayNotification.handleNotification():boolean");
    }
}
