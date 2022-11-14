package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final class CommonNotificationBuilder {
    public static final AtomicInteger requestCodeProvider = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class DisplayNotificationInfo {

        /* renamed from: id */
        public final int f3313id;
        public final NotificationCompat.Builder notificationBuilder;
        public final String tag;

        public DisplayNotificationInfo(NotificationCompat.Builder builder, String str, int i) {
            this.notificationBuilder = builder;
            this.tag = str;
            this.f3313id = i;
        }
    }

    public static PendingIntent createMessagingPendingIntent(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, requestCodeProvider.incrementAndGet(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra(CloudMessagingReceiver.IntentKeys.WRAPPED_INTENT, intent), 1073741824);
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040 A[SYNTHETIC, Splitter:B:12:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03a5 A[SYNTHETIC, Splitter:B:166:0x03a5] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03d3  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03e6 A[SYNTHETIC, Splitter:B:175:0x03e6] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04a8  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x04c6  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x020f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.messaging.CommonNotificationBuilder.DisplayNotificationInfo createNotificationInfo(android.content.Context r14, com.google.firebase.messaging.NotificationParams r15) {
        /*
            java.lang.String r0 = "Couldn't get own application info: "
            java.lang.String r1 = "FirebaseMessaging"
            android.content.pm.PackageManager r2 = r14.getPackageManager()
            java.lang.String r3 = r14.getPackageName()
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x001b }
            if (r2 == 0) goto L_0x0029
            android.os.Bundle r3 = r2.metaData     // Catch:{ NameNotFoundException -> 0x001b }
            if (r3 == 0) goto L_0x0029
            android.os.Bundle r2 = r2.metaData     // Catch:{ NameNotFoundException -> 0x001b }
            goto L_0x002b
        L_0x001b:
            r2 = move-exception
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            int r3 = r3 + 35
            com.android.tools.p006r8.GeneratedOutlineSupport.outline30(r3, r0, r2, r1)
        L_0x0029:
            android.os.Bundle r2 = android.os.Bundle.EMPTY
        L_0x002b:
            java.lang.String r3 = r14.getPackageName()
            java.lang.String r4 = "gcm.n.android_channel_id"
            java.lang.String r4 = r15.getString(r4)
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 26
            r7 = 3
            r8 = 0
            r9 = 0
            if (r5 >= r6) goto L_0x0040
            goto L_0x00b6
        L_0x0040:
            android.content.pm.PackageManager r5 = r14.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00b6 }
            java.lang.String r10 = r14.getPackageName()     // Catch:{ NameNotFoundException -> 0x00b6 }
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r10, r9)     // Catch:{ NameNotFoundException -> 0x00b6 }
            int r5 = r5.targetSdkVersion     // Catch:{ NameNotFoundException -> 0x00b6 }
            if (r5 >= r6) goto L_0x0051
            goto L_0x00b6
        L_0x0051:
            java.lang.Class<android.app.NotificationManager> r5 = android.app.NotificationManager.class
            java.lang.Object r5 = r14.getSystemService(r5)
            android.app.NotificationManager r5 = (android.app.NotificationManager) r5
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x0073
            android.app.NotificationChannel r6 = r5.getNotificationChannel(r4)
            if (r6 == 0) goto L_0x0066
            goto L_0x00b7
        L_0x0066:
            r6 = 122(0x7a, float:1.71E-43)
            int r6 = com.android.tools.p006r8.GeneratedOutlineSupport.outline3(r4, r6)
            java.lang.String r10 = "Notification Channel requested ("
            java.lang.String r11 = ") has not been created by the app. Manifest configuration, or default, value will be used."
            com.android.tools.p006r8.GeneratedOutlineSupport.outline31(r6, r10, r4, r11, r1)
        L_0x0073:
            java.lang.String r4 = "com.google.firebase.messaging.default_notification_channel_id"
            java.lang.String r4 = r2.getString(r4)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x008c
            android.app.NotificationChannel r6 = r5.getNotificationChannel(r4)
            if (r6 == 0) goto L_0x0086
            goto L_0x00b7
        L_0x0086:
            java.lang.String r4 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used."
            android.util.Log.w(r1, r4)
            goto L_0x0091
        L_0x008c:
            java.lang.String r4 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used."
            android.util.Log.w(r1, r4)
        L_0x0091:
            java.lang.String r4 = "fcm_fallback_notification_channel"
            android.app.NotificationChannel r6 = r5.getNotificationChannel(r4)
            if (r6 != 0) goto L_0x00b7
            android.content.res.Resources r6 = r14.getResources()
            java.lang.String r10 = r14.getPackageName()
            java.lang.String r11 = "fcm_fallback_notification_channel_label"
            java.lang.String r12 = "string"
            int r6 = r6.getIdentifier(r11, r12, r10)
            android.app.NotificationChannel r10 = new android.app.NotificationChannel
            java.lang.String r6 = r14.getString(r6)
            r10.<init>(r4, r6, r7)
            r5.createNotificationChannel(r10)
            goto L_0x00b7
        L_0x00b6:
            r4 = r8
        L_0x00b7:
            android.content.res.Resources r5 = r14.getResources()
            android.content.pm.PackageManager r6 = r14.getPackageManager()
            androidx.core.app.NotificationCompat$Builder r10 = new androidx.core.app.NotificationCompat$Builder
            r10.<init>(r14, r4)
            java.lang.String r4 = "gcm.n.title"
            java.lang.String r4 = r15.getPossiblyLocalizedString(r5, r3, r4)
            boolean r11 = android.text.TextUtils.isEmpty(r4)
            if (r11 != 0) goto L_0x00d3
            r10.setContentTitle(r4)
        L_0x00d3:
            java.lang.String r4 = "gcm.n.body"
            java.lang.String r4 = r15.getPossiblyLocalizedString(r5, r3, r4)
            boolean r11 = android.text.TextUtils.isEmpty(r4)
            if (r11 != 0) goto L_0x00ee
            r10.setContentText(r4)
            androidx.core.app.NotificationCompat$BigTextStyle r11 = new androidx.core.app.NotificationCompat$BigTextStyle
            r11.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r4 = r11.bigText(r4)
            r10.setStyle(r4)
        L_0x00ee:
            java.lang.String r4 = "gcm.n.icon"
            java.lang.String r4 = r15.getString(r4)
            boolean r11 = android.text.TextUtils.isEmpty(r4)
            if (r11 != 0) goto L_0x0125
            java.lang.String r11 = "drawable"
            int r11 = r5.getIdentifier(r4, r11, r3)
            if (r11 == 0) goto L_0x0109
            boolean r12 = isValidIcon(r5, r11)
            if (r12 == 0) goto L_0x0109
            goto L_0x0155
        L_0x0109:
            java.lang.String r11 = "mipmap"
            int r11 = r5.getIdentifier(r4, r11, r3)
            if (r11 == 0) goto L_0x0118
            boolean r12 = isValidIcon(r5, r11)
            if (r12 == 0) goto L_0x0118
            goto L_0x0155
        L_0x0118:
            r11 = 61
            int r11 = com.android.tools.p006r8.GeneratedOutlineSupport.outline3(r4, r11)
            java.lang.String r12 = "Icon resource "
            java.lang.String r13 = " not found. Notification will use default icon."
            com.android.tools.p006r8.GeneratedOutlineSupport.outline31(r11, r12, r4, r13, r1)
        L_0x0125:
            java.lang.String r4 = "com.google.firebase.messaging.default_notification_icon"
            int r4 = r2.getInt(r4, r9)
            if (r4 == 0) goto L_0x0133
            boolean r11 = isValidIcon(r5, r4)
            if (r11 != 0) goto L_0x0149
        L_0x0133:
            android.content.pm.ApplicationInfo r11 = r6.getApplicationInfo(r3, r9)     // Catch:{ NameNotFoundException -> 0x013b }
            int r0 = r11.icon     // Catch:{ NameNotFoundException -> 0x013b }
            r11 = r0
            goto L_0x014a
        L_0x013b:
            r11 = move-exception
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r12 = r11.length()
            int r12 = r12 + 35
            com.android.tools.p006r8.GeneratedOutlineSupport.outline30(r12, r0, r11, r1)
        L_0x0149:
            r11 = r4
        L_0x014a:
            if (r11 == 0) goto L_0x0152
            boolean r0 = isValidIcon(r5, r11)
            if (r0 != 0) goto L_0x0155
        L_0x0152:
            r11 = 17301651(0x1080093, float:2.4979667E-38)
        L_0x0155:
            r10.setSmallIcon(r11)
            java.lang.String r0 = "gcm.n.sound2"
            java.lang.String r0 = r15.getString(r0)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L_0x016a
            java.lang.String r0 = "gcm.n.sound"
            java.lang.String r0 = r15.getString(r0)
        L_0x016a:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            r11 = 2
            if (r4 == 0) goto L_0x0173
            r0 = r8
            goto L_0x01af
        L_0x0173:
            java.lang.String r4 = "default"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x01ab
            java.lang.String r4 = "raw"
            int r4 = r5.getIdentifier(r0, r4, r3)
            if (r4 == 0) goto L_0x01ab
            r4 = 24
            int r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline3(r3, r4)
            int r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline3(r0, r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "android.resource://"
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = "/raw/"
            r5.append(r4)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            goto L_0x01af
        L_0x01ab:
            android.net.Uri r0 = android.media.RingtoneManager.getDefaultUri(r11)
        L_0x01af:
            if (r0 == 0) goto L_0x01b4
            r10.setSound(r0)
        L_0x01b4:
            java.lang.String r0 = "gcm.n.click_action"
            java.lang.String r0 = r15.getString(r0)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x01ce
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r0)
            r4.setPackage(r3)
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r4.setFlags(r0)
            goto L_0x0207
        L_0x01ce:
            java.lang.String r0 = "gcm.n.link_android"
            java.lang.String r0 = r15.getString(r0)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L_0x01e0
            java.lang.String r0 = "gcm.n.link"
            java.lang.String r0 = r15.getString(r0)
        L_0x01e0:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x01eb
            android.net.Uri r0 = android.net.Uri.parse(r0)
            goto L_0x01ec
        L_0x01eb:
            r0 = r8
        L_0x01ec:
            if (r0 == 0) goto L_0x01fc
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.VIEW"
            r4.<init>(r5)
            r4.setPackage(r3)
            r4.setData(r0)
            goto L_0x0207
        L_0x01fc:
            android.content.Intent r4 = r6.getLaunchIntentForPackage(r3)
            if (r4 != 0) goto L_0x0207
            java.lang.String r0 = "No activity found to launch app"
            android.util.Log.w(r1, r0)
        L_0x0207:
            java.lang.String r0 = "google.c.a.e"
            r3 = 1
            if (r4 != 0) goto L_0x020f
            r4 = r8
            goto L_0x0281
        L_0x020f:
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            r4.addFlags(r5)
            android.os.Bundle r5 = new android.os.Bundle
            android.os.Bundle r6 = r15.data
            r5.<init>(r6)
            android.os.Bundle r6 = r15.data
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0225:
            boolean r12 = r6.hasNext()
            if (r12 == 0) goto L_0x0253
            java.lang.Object r12 = r6.next()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r13 = "google.c."
            boolean r13 = r12.startsWith(r13)
            if (r13 != 0) goto L_0x024c
            java.lang.String r13 = "gcm.n."
            boolean r13 = r12.startsWith(r13)
            if (r13 != 0) goto L_0x024c
            java.lang.String r13 = "gcm.notification."
            boolean r13 = r12.startsWith(r13)
            if (r13 == 0) goto L_0x024a
            goto L_0x024c
        L_0x024a:
            r13 = 0
            goto L_0x024d
        L_0x024c:
            r13 = 1
        L_0x024d:
            if (r13 == 0) goto L_0x0225
            r5.remove(r12)
            goto L_0x0225
        L_0x0253:
            r4.putExtras(r5)
            java.util.concurrent.atomic.AtomicInteger r5 = requestCodeProvider
            int r5 = r5.incrementAndGet()
            r6 = 1073741824(0x40000000, float:2.0)
            android.app.PendingIntent r4 = android.app.PendingIntent.getActivity(r14, r5, r4, r6)
            boolean r5 = r15.getBoolean(r0)
            if (r5 == 0) goto L_0x0281
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "com.google.firebase.messaging.NOTIFICATION_OPEN"
            r5.<init>(r6)
            android.os.Bundle r6 = r15.paramsForAnalyticsIntent()
            android.content.Intent r5 = r5.putExtras(r6)
            java.lang.String r6 = "pending_intent"
            android.content.Intent r4 = r5.putExtra(r6, r4)
            android.app.PendingIntent r4 = createMessagingPendingIntent(r14, r4)
        L_0x0281:
            r10.setContentIntent(r4)
            boolean r0 = r15.getBoolean(r0)
            if (r0 != 0) goto L_0x028c
            r0 = r8
            goto L_0x029f
        L_0x028c:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r4 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            r0.<init>(r4)
            android.os.Bundle r4 = r15.paramsForAnalyticsIntent()
            android.content.Intent r0 = r0.putExtras(r4)
            android.app.PendingIntent r0 = createMessagingPendingIntent(r14, r0)
        L_0x029f:
            if (r0 == 0) goto L_0x02a4
            r10.setDeleteIntent(r0)
        L_0x02a4:
            java.lang.String r0 = "gcm.n.color"
            java.lang.String r0 = r15.getString(r0)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            if (r4 >= r5) goto L_0x02b1
            goto L_0x02e3
        L_0x02b1:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x02cd
            int r4 = android.graphics.Color.parseColor(r0)     // Catch:{ IllegalArgumentException -> 0x02c0 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r4)     // Catch:{ IllegalArgumentException -> 0x02c0 }
            goto L_0x02e4
        L_0x02c0:
            r4 = 56
            int r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline3(r0, r4)
            java.lang.String r5 = "Color is invalid: "
            java.lang.String r6 = ". Notification will use default color."
            com.android.tools.p006r8.GeneratedOutlineSupport.outline31(r4, r5, r0, r6, r1)
        L_0x02cd:
            java.lang.String r0 = "com.google.firebase.messaging.default_notification_color"
            int r0 = r2.getInt(r0, r9)
            if (r0 == 0) goto L_0x02e3
            int r14 = androidx.core.content.ContextCompat.getColor(r14, r0)     // Catch:{ NotFoundException -> 0x02de }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ NotFoundException -> 0x02de }
            goto L_0x02e4
        L_0x02de:
            java.lang.String r14 = "Cannot find the color resource referenced in AndroidManifest."
            android.util.Log.w(r1, r14)
        L_0x02e3:
            r14 = r8
        L_0x02e4:
            if (r14 == 0) goto L_0x02ed
            int r14 = r14.intValue()
            r10.setColor(r14)
        L_0x02ed:
            java.lang.String r14 = "gcm.n.sticky"
            boolean r14 = r15.getBoolean(r14)
            r14 = r14 ^ r3
            r10.setAutoCancel(r14)
            java.lang.String r14 = "gcm.n.local_only"
            boolean r14 = r15.getBoolean(r14)
            r10.setLocalOnly(r14)
            java.lang.String r14 = "gcm.n.ticker"
            java.lang.String r14 = r15.getString(r14)
            if (r14 == 0) goto L_0x030b
            r10.setTicker(r14)
        L_0x030b:
            java.lang.String r14 = "gcm.n.notification_priority"
            java.lang.Integer r14 = r15.getInteger(r14)
            if (r14 != 0) goto L_0x0314
            goto L_0x0332
        L_0x0314:
            int r0 = r14.intValue()
            r2 = -2
            if (r0 < r2) goto L_0x0321
            int r0 = r14.intValue()
            if (r0 <= r11) goto L_0x0333
        L_0x0321:
            java.lang.String r14 = java.lang.String.valueOf(r14)
            int r0 = r14.length()
            int r0 = r0 + 72
            java.lang.String r2 = "notificationPriority is invalid "
            java.lang.String r4 = ". Skipping setting notificationPriority."
            com.android.tools.p006r8.GeneratedOutlineSupport.outline31(r0, r2, r14, r4, r1)
        L_0x0332:
            r14 = r8
        L_0x0333:
            if (r14 == 0) goto L_0x033c
            int r14 = r14.intValue()
            r10.setPriority(r14)
        L_0x033c:
            java.lang.String r14 = "gcm.n.visibility"
            java.lang.Integer r14 = r15.getInteger(r14)
            java.lang.String r0 = "NotificationParams"
            if (r14 != 0) goto L_0x0347
            goto L_0x0365
        L_0x0347:
            int r2 = r14.intValue()
            r4 = -1
            if (r2 < r4) goto L_0x0354
            int r2 = r14.intValue()
            if (r2 <= r3) goto L_0x0366
        L_0x0354:
            java.lang.String r14 = java.lang.String.valueOf(r14)
            int r2 = r14.length()
            int r2 = r2 + 53
            java.lang.String r4 = "visibility is invalid: "
            java.lang.String r5 = ". Skipping setting visibility."
            com.android.tools.p006r8.GeneratedOutlineSupport.outline31(r2, r4, r14, r5, r0)
        L_0x0365:
            r14 = r8
        L_0x0366:
            if (r14 == 0) goto L_0x036f
            int r14 = r14.intValue()
            r10.setVisibility(r14)
        L_0x036f:
            java.lang.String r14 = "gcm.n.notification_count"
            java.lang.Integer r14 = r15.getInteger(r14)
            if (r14 != 0) goto L_0x0378
            goto L_0x038f
        L_0x0378:
            int r2 = r14.intValue()
            if (r2 >= 0) goto L_0x0390
            java.lang.String r14 = java.lang.String.valueOf(r14)
            int r2 = r14.length()
            int r2 = r2 + 67
            java.lang.String r4 = "notificationCount is invalid: "
            java.lang.String r5 = ". Skipping setting notificationCount."
            com.android.tools.p006r8.GeneratedOutlineSupport.outline31(r2, r4, r14, r5, r1)
        L_0x038f:
            r14 = r8
        L_0x0390:
            if (r14 == 0) goto L_0x0399
            int r14 = r14.intValue()
            r10.setNumber(r14)
        L_0x0399:
            java.lang.String r14 = "gcm.n.event_time"
            java.lang.String r1 = r15.getString(r14)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x03d0
            long r4 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x03ae }
            java.lang.Long r14 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x03ae }
            goto L_0x03d1
        L_0x03ae:
            java.lang.String r14 = com.google.firebase.messaging.NotificationParams.userFriendlyKey(r14)
            r2 = 38
            int r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline3(r14, r2)
            int r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline3(r1, r2)
            java.lang.String r4 = "Couldn't parse value of "
            java.lang.String r5 = "("
            java.lang.StringBuilder r14 = com.android.tools.p006r8.GeneratedOutlineSupport.outline23(r2, r4, r14, r5, r1)
            java.lang.String r1 = ") into a long"
            r14.append(r1)
            java.lang.String r14 = r14.toString()
            android.util.Log.w(r0, r14)
        L_0x03d0:
            r14 = r8
        L_0x03d1:
            if (r14 == 0) goto L_0x03dd
            r10.setShowWhen(r3)
            long r1 = r14.longValue()
            r10.setWhen(r1)
        L_0x03dd:
            java.lang.String r14 = "gcm.n.vibrate_timings"
            org.json.JSONArray r14 = r15.getJSONArray(r14)
            if (r14 != 0) goto L_0x03e6
            goto L_0x0417
        L_0x03e6:
            int r1 = r14.length()     // Catch:{ NumberFormatException | JSONException -> 0x0406 }
            if (r1 <= r3) goto L_0x03fe
            int r1 = r14.length()     // Catch:{ NumberFormatException | JSONException -> 0x0406 }
            long[] r2 = new long[r1]     // Catch:{ NumberFormatException | JSONException -> 0x0406 }
            r4 = 0
        L_0x03f3:
            if (r4 >= r1) goto L_0x0418
            long r5 = r14.optLong(r4)     // Catch:{ NumberFormatException | JSONException -> 0x0406 }
            r2[r4] = r5     // Catch:{ NumberFormatException | JSONException -> 0x0406 }
            int r4 = r4 + 1
            goto L_0x03f3
        L_0x03fe:
            org.json.JSONException r1 = new org.json.JSONException     // Catch:{ NumberFormatException | JSONException -> 0x0406 }
            java.lang.String r2 = "vibrateTimings have invalid length"
            r1.<init>(r2)     // Catch:{ NumberFormatException | JSONException -> 0x0406 }
            throw r1     // Catch:{ NumberFormatException | JSONException -> 0x0406 }
        L_0x0406:
            java.lang.String r14 = java.lang.String.valueOf(r14)
            int r1 = r14.length()
            int r1 = r1 + 74
            java.lang.String r2 = "User defined vibrateTimings is invalid: "
            java.lang.String r4 = ". Skipping setting vibrateTimings."
            com.android.tools.p006r8.GeneratedOutlineSupport.outline31(r1, r2, r14, r4, r0)
        L_0x0417:
            r2 = r8
        L_0x0418:
            if (r2 == 0) goto L_0x041d
            r10.setVibrate(r2)
        L_0x041d:
            java.lang.String r14 = ". Skipping setting LightSettings"
            java.lang.String r1 = "LightSettings is invalid: "
            java.lang.String r2 = "gcm.n.light_settings"
            org.json.JSONArray r2 = r15.getJSONArray(r2)
            if (r2 != 0) goto L_0x042a
            goto L_0x048f
        L_0x042a:
            int[] r4 = new int[r7]
            int r5 = r2.length()     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            if (r5 != r7) goto L_0x0456
            java.lang.String r5 = r2.optString(r9)     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            int r5 = android.graphics.Color.parseColor(r5)     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r5 == r6) goto L_0x044e
            r4[r9] = r5     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            int r5 = r2.optInt(r3)     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            r4[r3] = r5     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            int r5 = r2.optInt(r11)     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            r4[r11] = r5     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            r8 = r4
            goto L_0x048f
        L_0x044e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            java.lang.String r5 = "Transparent color is invalid"
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            throw r4     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
        L_0x0456:
            org.json.JSONException r4 = new org.json.JSONException     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            java.lang.String r5 = "lightSettings don't have all three fields"
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
            throw r4     // Catch:{ JSONException -> 0x0482, IllegalArgumentException -> 0x045e }
        L_0x045e:
            r4 = move-exception
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = r4.getMessage()
            int r5 = r2.length()
            int r5 = r5 + 60
            int r5 = com.android.tools.p006r8.GeneratedOutlineSupport.outline3(r4, r5)
            java.lang.String r6 = ". "
            java.lang.StringBuilder r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline23(r5, r1, r2, r6, r4)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            android.util.Log.w(r0, r14)
            goto L_0x048f
        L_0x0482:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            int r4 = r4 + 58
            com.android.tools.p006r8.GeneratedOutlineSupport.outline31(r4, r1, r2, r14, r0)
        L_0x048f:
            if (r8 == 0) goto L_0x049a
            r14 = r8[r9]
            r0 = r8[r3]
            r1 = r8[r11]
            r10.setLights(r14, r0, r1)
        L_0x049a:
            java.lang.String r14 = "gcm.n.default_sound"
            boolean r14 = r15.getBoolean(r14)
            java.lang.String r0 = "gcm.n.default_vibrate_timings"
            boolean r0 = r15.getBoolean(r0)
            if (r0 == 0) goto L_0x04aa
            r14 = r14 | 2
        L_0x04aa:
            java.lang.String r0 = "gcm.n.default_light_settings"
            boolean r0 = r15.getBoolean(r0)
            if (r0 == 0) goto L_0x04b4
            r14 = r14 | 4
        L_0x04b4:
            r10.setDefaults(r14)
            com.google.firebase.messaging.CommonNotificationBuilder$DisplayNotificationInfo r14 = new com.google.firebase.messaging.CommonNotificationBuilder$DisplayNotificationInfo
            java.lang.String r0 = "gcm.n.tag"
            java.lang.String r15 = r15.getString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 != 0) goto L_0x04c6
            goto L_0x04dd
        L_0x04c6:
            long r0 = android.os.SystemClock.uptimeMillis()
            r15 = 37
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r15)
            java.lang.String r15 = "FCM-Notification:"
            r2.append(r15)
            r2.append(r0)
            java.lang.String r15 = r2.toString()
        L_0x04dd:
            r14.<init>(r10, r15, r9)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.CommonNotificationBuilder.createNotificationInfo(android.content.Context, com.google.firebase.messaging.NotificationParams):com.google.firebase.messaging.CommonNotificationBuilder$DisplayNotificationInfo");
    }

    @TargetApi(26)
    public static boolean isValidIcon(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i, (Resources.Theme) null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }
}
