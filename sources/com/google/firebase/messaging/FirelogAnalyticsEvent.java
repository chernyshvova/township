package com.google.firebase.messaging;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final class FirelogAnalyticsEvent {
    public final String eventType;
    public final Intent intent;

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class FirelogAnalyticsEventEncoder implements ObjectEncoder<FirelogAnalyticsEvent> {
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a6, code lost:
            if ("normal".equals(r1) != false) goto L_0x00a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0161, code lost:
            if (r0.isEmpty() != false) goto L_0x0163;
         */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00da  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00e7  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ef  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0107  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0127  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0140  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0166  */
        /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void encode(java.lang.Object r8, java.lang.Object r9) throws java.io.IOException {
            /*
                r7 = this;
                com.google.firebase.messaging.FirelogAnalyticsEvent r8 = (com.google.firebase.messaging.FirelogAnalyticsEvent) r8
                com.google.firebase.encoders.ObjectEncoderContext r9 = (com.google.firebase.encoders.ObjectEncoderContext) r9
                android.content.Intent r0 = r8.intent
                java.lang.String r1 = "ttl"
                android.os.Bundle r2 = r0.getExtras()
                java.lang.String r3 = "google.ttl"
                java.lang.Object r2 = r2.get(r3)
                boolean r3 = r2 instanceof java.lang.Integer
                r4 = 0
                if (r3 == 0) goto L_0x001e
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r2 = r2.intValue()
                goto L_0x003c
            L_0x001e:
                boolean r3 = r2 instanceof java.lang.String
                if (r3 == 0) goto L_0x003b
                r3 = r2
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ NumberFormatException -> 0x002a }
                int r2 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x002a }
                goto L_0x003c
            L_0x002a:
                java.lang.String r2 = java.lang.String.valueOf(r2)
                int r3 = r2.length()
                int r3 = r3 + 13
                java.lang.String r5 = "Invalid TTL: "
                java.lang.String r6 = "FirebaseMessaging"
                com.android.tools.p006r8.GeneratedOutlineSupport.outline30(r3, r5, r2, r6)
            L_0x003b:
                r2 = 0
            L_0x003c:
                r9.add((java.lang.String) r1, (int) r2)
                java.lang.String r1 = "event"
                java.lang.String r8 = r8.eventType
                r9.add((java.lang.String) r1, (java.lang.Object) r8)
                java.lang.String r8 = "instanceId"
                com.google.firebase.FirebaseApp r1 = com.google.firebase.FirebaseApp.getInstance()
                com.google.firebase.iid.FirebaseInstanceId r1 = com.google.firebase.iid.FirebaseInstanceId.getInstance(r1)
                com.google.firebase.FirebaseApp r2 = r1.app
                com.google.firebase.iid.FirebaseInstanceId.checkRequiredFirebaseOptions(r2)
                com.google.firebase.iid.Store$Token r2 = r1.getTokenWithoutTriggeringSync()
                boolean r2 = r1.tokenNeedsRefresh(r2)
                if (r2 == 0) goto L_0x006e
                monitor-enter(r1)
                boolean r2 = r1.syncScheduledOrRunning     // Catch:{ all -> 0x006b }
                if (r2 != 0) goto L_0x0069
                r2 = 0
                r1.syncWithDelaySecondsInternal(r2)     // Catch:{ all -> 0x006b }
            L_0x0069:
                monitor-exit(r1)
                goto L_0x006e
            L_0x006b:
                r8 = move-exception
                monitor-exit(r1)
                throw r8
            L_0x006e:
                java.lang.String r1 = r1.getIdWithoutTriggeringSync()
                r9.add((java.lang.String) r8, (java.lang.Object) r1)
                java.lang.String r8 = "priority"
                java.lang.String r1 = "google.delivered_priority"
                java.lang.String r1 = r0.getStringExtra(r1)
                r2 = 1
                r3 = 2
                if (r1 != 0) goto L_0x0096
                java.lang.String r1 = "google.priority_reduced"
                java.lang.String r1 = r0.getStringExtra(r1)
                java.lang.String r5 = "1"
                boolean r1 = r5.equals(r1)
                if (r1 == 0) goto L_0x0090
                goto L_0x00a8
            L_0x0090:
                java.lang.String r1 = "google.priority"
                java.lang.String r1 = r0.getStringExtra(r1)
            L_0x0096:
                java.lang.String r5 = "high"
                boolean r5 = r5.equals(r1)
                if (r5 == 0) goto L_0x00a0
                r4 = 1
                goto L_0x00a9
            L_0x00a0:
                java.lang.String r5 = "normal"
                boolean r1 = r5.equals(r1)
                if (r1 == 0) goto L_0x00a9
            L_0x00a8:
                r4 = 2
            L_0x00a9:
                r9.add((java.lang.String) r8, (int) r4)
                java.lang.String r8 = "packageName"
                com.google.firebase.FirebaseApp r1 = com.google.firebase.FirebaseApp.getInstance()
                r1.checkNotDeleted()
                android.content.Context r1 = r1.applicationContext
                java.lang.String r1 = r1.getPackageName()
                r9.add((java.lang.String) r8, (java.lang.Object) r1)
                java.lang.String r8 = "sdkPlatform"
                java.lang.String r1 = "ANDROID"
                r9.add((java.lang.String) r8, (java.lang.Object) r1)
                java.lang.String r8 = "messageType"
                android.os.Bundle r1 = r0.getExtras()
                if (r1 == 0) goto L_0x00da
                android.os.Bundle r1 = r0.getExtras()
                boolean r1 = com.google.firebase.messaging.NotificationParams.isNotification(r1)
                if (r1 == 0) goto L_0x00da
                java.lang.String r1 = "DISPLAY_NOTIFICATION"
                goto L_0x00dc
            L_0x00da:
                java.lang.String r1 = "DATA_MESSAGE"
            L_0x00dc:
                r9.add((java.lang.String) r8, (java.lang.Object) r1)
                java.lang.String r8 = "google.message_id"
                java.lang.String r8 = r0.getStringExtra(r8)
                if (r8 != 0) goto L_0x00ed
                java.lang.String r8 = "message_id"
                java.lang.String r8 = r0.getStringExtra(r8)
            L_0x00ed:
                if (r8 == 0) goto L_0x00f4
                java.lang.String r1 = "messageId"
                r9.add((java.lang.String) r1, (java.lang.Object) r8)
            L_0x00f4:
                java.lang.String r8 = com.google.firebase.messaging.MessagingAnalytics.getTopic(r0)
                if (r8 == 0) goto L_0x00ff
                java.lang.String r1 = "topic"
                r9.add((java.lang.String) r1, (java.lang.Object) r8)
            L_0x00ff:
                java.lang.String r8 = "collapse_key"
                java.lang.String r8 = r0.getStringExtra(r8)
                if (r8 == 0) goto L_0x010c
                java.lang.String r1 = "collapseKey"
                r9.add((java.lang.String) r1, (java.lang.Object) r8)
            L_0x010c:
                java.lang.String r8 = "google.c.a.m_l"
                java.lang.String r8 = r0.getStringExtra(r8)
                if (r8 == 0) goto L_0x011f
                java.lang.String r8 = "analyticsLabel"
                java.lang.String r1 = "google.c.a.m_l"
                java.lang.String r1 = r0.getStringExtra(r1)
                r9.add((java.lang.String) r8, (java.lang.Object) r1)
            L_0x011f:
                java.lang.String r8 = "google.c.a.c_l"
                java.lang.String r8 = r0.getStringExtra(r8)
                if (r8 == 0) goto L_0x0132
                java.lang.String r8 = "composerLabel"
                java.lang.String r1 = "google.c.a.c_l"
                java.lang.String r0 = r0.getStringExtra(r1)
                r9.add((java.lang.String) r8, (java.lang.Object) r0)
            L_0x0132:
                com.google.firebase.FirebaseApp r8 = com.google.firebase.FirebaseApp.getInstance()
                r8.checkNotDeleted()
                com.google.firebase.FirebaseOptions r0 = r8.options
                java.lang.String r0 = r0.gcmSenderId
                if (r0 == 0) goto L_0x0140
                goto L_0x0164
            L_0x0140:
                r8.checkNotDeleted()
                com.google.firebase.FirebaseOptions r8 = r8.options
                java.lang.String r0 = r8.applicationId
                java.lang.String r8 = "1:"
                boolean r8 = r0.startsWith(r8)
                if (r8 != 0) goto L_0x0150
                goto L_0x0164
            L_0x0150:
                java.lang.String r8 = ":"
                java.lang.String[] r8 = r0.split(r8)
                int r0 = r8.length
                r1 = 0
                if (r0 >= r3) goto L_0x015b
                goto L_0x0163
            L_0x015b:
                r0 = r8[r2]
                boolean r8 = r0.isEmpty()
                if (r8 == 0) goto L_0x0164
            L_0x0163:
                r0 = r1
            L_0x0164:
                if (r0 == 0) goto L_0x016b
                java.lang.String r8 = "projectNumber"
                r9.add((java.lang.String) r8, (java.lang.Object) r0)
            L_0x016b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirelogAnalyticsEvent.FirelogAnalyticsEventEncoder.encode(java.lang.Object, java.lang.Object):void");
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class FirelogAnalyticsEventWrapper {
        public final FirelogAnalyticsEvent firelogAnalyticsEvent;

        public FirelogAnalyticsEventWrapper(@NonNull FirelogAnalyticsEvent firelogAnalyticsEvent2) {
            this.firelogAnalyticsEvent = (FirelogAnalyticsEvent) Preconditions.checkNotNull(firelogAnalyticsEvent2);
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class FirelogAnalyticsEventWrapperEncoder implements ObjectEncoder<FirelogAnalyticsEventWrapper> {
        public final void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add("messaging_client_event", (Object) ((FirelogAnalyticsEventWrapper) obj).firelogAnalyticsEvent);
        }
    }

    public FirelogAnalyticsEvent(@NonNull String str, @NonNull Intent intent2) {
        this.eventType = Preconditions.checkNotEmpty(str, "evenType must be non-null");
        this.intent = (Intent) Preconditions.checkNotNull(intent2, "intent must be non-null");
    }
}
