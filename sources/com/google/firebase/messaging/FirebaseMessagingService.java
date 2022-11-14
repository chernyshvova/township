package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.ServiceStarter;
import com.swrve.sdk.SwrveNotificationConstants;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public class FirebaseMessagingService extends EnhancedIntentService {
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    public static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!recentlyReceivedMessageIds.contains(str)) {
            if (recentlyReceivedMessageIds.size() >= 10) {
                recentlyReceivedMessageIds.remove();
            }
            recentlyReceivedMessageIds.add(str);
            return false;
        } else if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        } else {
            String valueOf = String.valueOf(str);
            Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Received duplicate message: ".concat(valueOf) : new String("Received duplicate message: "));
            return true;
        }
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (NotificationParams.isNotification(extras)) {
            NotificationParams notificationParams = new NotificationParams(extras);
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Network-Io"));
            try {
                if (!new DisplayNotification(this, notificationParams, newSingleThreadExecutor).handleNotification()) {
                    newSingleThreadExecutor.shutdown();
                    if (MessagingAnalytics.shouldUploadScionMetrics(intent)) {
                        MessagingAnalytics.logToScion("_nf", intent);
                    }
                } else {
                    return;
                }
            } finally {
                newSingleThreadExecutor.shutdown();
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    private void handleMessageIntent(Intent intent) {
        if (!alreadyReceivedMessage(intent.getStringExtra("google.message_id"))) {
            passMessageIntentToSdk(intent);
        }
    }

    private void handleNotificationOpen(Intent intent) {
        if (MessagingAnalytics.shouldUploadScionMetrics(intent)) {
            if (intent != null) {
                if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(intent.getStringExtra("google.c.a.tc"))) {
                    FirebaseApp instance = FirebaseApp.getInstance();
                    instance.checkNotDeleted();
                    AnalyticsConnector analyticsConnector = (AnalyticsConnector) instance.componentRuntime.get(AnalyticsConnector.class);
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                    }
                    if (analyticsConnector != null) {
                        String stringExtra = intent.getStringExtra("google.c.a.c_id");
                        analyticsConnector.setUserProperty(AppMeasurement.FCM_ORIGIN, "_ln", stringExtra);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "Firebase");
                        bundle.putString(FirebaseAnalytics.Param.MEDIUM, SwrveNotificationConstants.PUSH_BUNDLE);
                        bundle.putString("campaign", stringExtra);
                        analyticsConnector.logEvent(AppMeasurement.FCM_ORIGIN, "_cmp", bundle);
                    } else {
                        Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                    }
                } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                }
            }
            MessagingAnalytics.logToScion("_no", intent);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:65|66|67|68|69) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x0129 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void passMessageIntentToSdk(android.content.Intent r9) {
        /*
            r8 = this;
            java.lang.String r0 = "message_type"
            java.lang.String r0 = r9.getStringExtra(r0)
            java.lang.String r1 = "gcm"
            if (r0 != 0) goto L_0x000b
            r0 = r1
        L_0x000b:
            r2 = -1
            int r3 = r0.hashCode()
            r4 = 0
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r3) {
                case -2062414158: goto L_0x0034;
                case 102161: goto L_0x002c;
                case 814694033: goto L_0x0022;
                case 814800675: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x003d
        L_0x0018:
            java.lang.String r1 = "send_event"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x003d
            r2 = 2
            goto L_0x003d
        L_0x0022:
            java.lang.String r1 = "send_error"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x003d
            r2 = 3
            goto L_0x003d
        L_0x002c:
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x003d
            r2 = 0
            goto L_0x003d
        L_0x0034:
            java.lang.String r1 = "deleted_messages"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x003d
            r2 = 1
        L_0x003d:
            java.lang.String r1 = "FirebaseMessaging"
            if (r2 == 0) goto L_0x007f
            if (r2 == r7) goto L_0x007b
            if (r2 == r6) goto L_0x0071
            if (r2 == r5) goto L_0x005e
            java.lang.String r9 = "Received message with unknown type: "
            int r2 = r0.length()
            if (r2 == 0) goto L_0x0054
            java.lang.String r9 = r9.concat(r0)
            goto L_0x005a
        L_0x0054:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r9)
            r9 = r0
        L_0x005a:
            android.util.Log.w(r1, r9)
            return
        L_0x005e:
            java.lang.String r0 = r8.getMessageId(r9)
            com.google.firebase.messaging.SendException r1 = new com.google.firebase.messaging.SendException
            java.lang.String r2 = "error"
            java.lang.String r9 = r9.getStringExtra(r2)
            r1.<init>(r9)
            r8.onSendError(r0, r1)
            return
        L_0x0071:
            java.lang.String r0 = "google.message_id"
            java.lang.String r9 = r9.getStringExtra(r0)
            r8.onMessageSent(r9)
            return
        L_0x007b:
            r8.onDeletedMessages()
            return
        L_0x007f:
            boolean r0 = com.google.firebase.messaging.MessagingAnalytics.shouldUploadScionMetrics(r9)
            if (r0 == 0) goto L_0x008a
            java.lang.String r0 = "_nr"
            com.google.firebase.messaging.MessagingAnalytics.logToScion(r0, r9)
        L_0x008a:
            java.lang.String r0 = r9.getAction()
            java.lang.String r2 = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0097
            goto L_0x00e4
        L_0x0097:
            java.lang.String r0 = "delivery_metrics_exported_to_big_query_enabled"
            com.google.firebase.FirebaseApp.getInstance()     // Catch:{ IllegalStateException -> 0x00df }
            com.google.firebase.FirebaseApp r2 = com.google.firebase.FirebaseApp.getInstance()
            r2.checkNotDeleted()
            android.content.Context r2 = r2.applicationContext
            java.lang.String r3 = "com.google.firebase.messaging"
            android.content.SharedPreferences r3 = r2.getSharedPreferences(r3, r4)
            java.lang.String r5 = "export_to_big_query"
            boolean r6 = r3.contains(r5)
            if (r6 == 0) goto L_0x00b8
            boolean r4 = r3.getBoolean(r5, r4)
            goto L_0x00e4
        L_0x00b8:
            android.content.pm.PackageManager r3 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00dd }
            if (r3 == 0) goto L_0x00e4
            java.lang.String r2 = r2.getPackageName()     // Catch:{ NameNotFoundException -> 0x00dd }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r3.getApplicationInfo(r2, r5)     // Catch:{ NameNotFoundException -> 0x00dd }
            if (r2 == 0) goto L_0x00e4
            android.os.Bundle r3 = r2.metaData     // Catch:{ NameNotFoundException -> 0x00dd }
            if (r3 == 0) goto L_0x00e4
            android.os.Bundle r3 = r2.metaData     // Catch:{ NameNotFoundException -> 0x00dd }
            boolean r3 = r3.containsKey(r0)     // Catch:{ NameNotFoundException -> 0x00dd }
            if (r3 == 0) goto L_0x00e4
            android.os.Bundle r2 = r2.metaData     // Catch:{ NameNotFoundException -> 0x00dd }
            boolean r4 = r2.getBoolean(r0, r4)     // Catch:{ NameNotFoundException -> 0x00dd }
            goto L_0x00e4
        L_0x00dd:
            goto L_0x00e4
        L_0x00df:
            java.lang.String r0 = "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query"
            android.util.Log.i(r1, r0)
        L_0x00e4:
            if (r4 == 0) goto L_0x0144
            com.google.android.datatransport.TransportFactory r0 = com.google.firebase.messaging.FirebaseMessaging.transportFactory
            if (r0 == 0) goto L_0x013f
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            com.google.android.datatransport.Encoding r3 = new com.google.android.datatransport.Encoding
            java.lang.String r4 = "json"
            r3.<init>(r4)
            com.google.android.datatransport.Transformer r4 = com.google.firebase.messaging.MessagingAnalytics$$Lambda$0.$instance
            java.lang.String r5 = "FCM_CLIENT_EVENT_LOGGING"
            com.google.android.datatransport.Transport r0 = r0.getTransport(r5, r2, r3, r4)
            com.google.firebase.messaging.FirelogAnalyticsEvent r2 = new com.google.firebase.messaging.FirelogAnalyticsEvent
            java.lang.String r3 = "MESSAGE_DELIVERED"
            r2.<init>(r3, r9)
            com.google.firebase.messaging.FirelogAnalyticsEvent$FirelogAnalyticsEventWrapper r3 = new com.google.firebase.messaging.FirelogAnalyticsEvent$FirelogAnalyticsEventWrapper
            r3.<init>(r2)
            com.google.firebase.encoders.DataEncoder r2 = com.google.firebase.messaging.MessagingAnalytics.dataEncoder     // Catch:{ EncodingException -> 0x0139 }
            com.google.firebase.encoders.json.JsonDataEncoderBuilder$1 r2 = (com.google.firebase.encoders.json.JsonDataEncoderBuilder.C23571) r2     // Catch:{ EncodingException -> 0x0139 }
            r4 = 0
            if (r2 == 0) goto L_0x0138
            java.io.StringWriter r5 = new java.io.StringWriter     // Catch:{ EncodingException -> 0x0139 }
            r5.<init>()     // Catch:{ EncodingException -> 0x0139 }
            com.google.firebase.encoders.json.JsonValueObjectEncoderContext r6 = new com.google.firebase.encoders.json.JsonValueObjectEncoderContext     // Catch:{ IOException -> 0x0129 }
            com.google.firebase.encoders.json.JsonDataEncoderBuilder r2 = com.google.firebase.encoders.json.JsonDataEncoderBuilder.this     // Catch:{ IOException -> 0x0129 }
            java.util.Map<java.lang.Class<?>, com.google.firebase.encoders.ObjectEncoder<?>> r7 = r2.objectEncoders     // Catch:{ IOException -> 0x0129 }
            java.util.Map<java.lang.Class<?>, com.google.firebase.encoders.ValueEncoder<?>> r2 = r2.valueEncoders     // Catch:{ IOException -> 0x0129 }
            r6.<init>(r5, r7, r2)     // Catch:{ IOException -> 0x0129 }
            r6.add((java.lang.Object) r3)     // Catch:{ IOException -> 0x0129 }
            r6.maybeUnNest()     // Catch:{ IOException -> 0x0129 }
            android.util.JsonWriter r2 = r6.jsonWriter     // Catch:{ IOException -> 0x0129 }
            r2.flush()     // Catch:{ IOException -> 0x0129 }
        L_0x0129:
            java.lang.String r2 = r5.toString()     // Catch:{ EncodingException -> 0x0139 }
            com.google.android.datatransport.AutoValue_Event r3 = new com.google.android.datatransport.AutoValue_Event     // Catch:{ EncodingException -> 0x0139 }
            com.google.android.datatransport.Priority r5 = com.google.android.datatransport.Priority.VERY_LOW     // Catch:{ EncodingException -> 0x0139 }
            r3.<init>(r4, r2, r5)     // Catch:{ EncodingException -> 0x0139 }
            r0.send(r3)     // Catch:{ EncodingException -> 0x0139 }
            goto L_0x0144
        L_0x0138:
            throw r4     // Catch:{ EncodingException -> 0x0139 }
        L_0x0139:
            java.lang.String r0 = "Failed to encode big query analytics payload. Skip sending"
            android.util.Log.d(r1, r0)
            goto L_0x0144
        L_0x013f:
            java.lang.String r0 = "TransportFactory is null. Skip exporting message delivery metrics to Big Query"
            android.util.Log.e(r1, r0)
        L_0x0144:
            r8.dispatchMessage(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.passMessageIntentToSdk(android.content.Intent):void");
    }

    public Intent getStartCommandIntent(Intent intent) {
        return ServiceStarter.getInstance().messagingEvents.poll();
    }

    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            handleMessageIntent(intent);
        } else if (CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS.equals(action)) {
            if (MessagingAnalytics.shouldUploadScionMetrics(intent)) {
                MessagingAnalytics.logToScion("_nd", intent);
            }
        } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            onNewToken(intent.getStringExtra("token"));
        } else {
            String valueOf = String.valueOf(intent.getAction());
            Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Unknown intent action: ".concat(valueOf) : new String("Unknown intent action: "));
        }
    }

    public boolean handleIntentOnMainThread(Intent intent) {
        if (!CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_OPEN.equals(intent.getAction())) {
            return false;
        }
        handleNotificationOpen(intent);
        return true;
    }

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(@NonNull String str) {
    }

    @WorkerThread
    public void onNewToken(@NonNull String str) {
    }

    @WorkerThread
    public void onSendError(@NonNull String str, @NonNull Exception exc) {
    }
}
