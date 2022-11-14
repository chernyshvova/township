package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.iid.Metadata;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public class TopicsSubscriber {
    public static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    public final Context context;
    public final FirebaseInstanceId iid;
    public final Metadata metadata;
    @GuardedBy("pendingOperations")
    public final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new ArrayMap();
    public final GmsRpc rpc;
    public final TopicsStore store;
    public final ScheduledExecutorService syncExecutor;
    @GuardedBy("this")
    public boolean syncScheduledOrRunning = false;

    public TopicsSubscriber(FirebaseInstanceId firebaseInstanceId, Metadata metadata2, TopicsStore topicsStore, GmsRpc gmsRpc, Context context2, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.iid = firebaseInstanceId;
        this.metadata = metadata2;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context2;
        this.syncExecutor = scheduledExecutorService;
    }

    @WorkerThread
    public static <T> T awaitTask(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e2);
        }
    }

    public static Task<TopicsSubscriber> createInstance(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, Metadata metadata2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, Context context2, @NonNull ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new TopicsSubscriber$$Lambda$0(context2, scheduledExecutorService, firebaseInstanceId, metadata2, new GmsRpc(firebaseApp, metadata2, provider, provider2, firebaseInstallationsApi)));
    }

    public static boolean isDebugLogEnabled() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
        }
        return true;
    }

    @WorkerThread
    public final void blockingSubscribeToTopic(String str) throws IOException {
        InstanceIdResult instanceIdResult = (InstanceIdResult) awaitTask(this.iid.getInstanceId());
        GmsRpc gmsRpc = this.rpc;
        String id = instanceIdResult.getId();
        String token = instanceIdResult.getToken();
        if (gmsRpc != null) {
            Bundle bundle = new Bundle();
            String valueOf = String.valueOf(str);
            bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
            String valueOf2 = String.valueOf(str);
            awaitTask(gmsRpc.extractResponseWhenComplete(gmsRpc.startRpc(id, token, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
            return;
        }
        throw null;
    }

    @WorkerThread
    public final void blockingUnsubscribeFromTopic(String str) throws IOException {
        InstanceIdResult instanceIdResult = (InstanceIdResult) awaitTask(this.iid.getInstanceId());
        GmsRpc gmsRpc = this.rpc;
        String id = instanceIdResult.getId();
        String token = instanceIdResult.getToken();
        if (gmsRpc != null) {
            Bundle bundle = new Bundle();
            String valueOf = String.valueOf(str);
            bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
            bundle.putString("delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            String valueOf2 = String.valueOf(str);
            awaitTask(gmsRpc.extractResponseWhenComplete(gmsRpc.startRpc(id, token, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
            return;
        }
        throw null;
    }

    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4 = r0.operation;
        r5 = 65535;
        r6 = r4.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r6 == 83) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        if (r6 == 85) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (r4.equals("U") == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        if (r4.equals("S") == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r5 == 0) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        if (r5 == 1) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (isDebugLogEnabled() == false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        r4 = java.lang.String.valueOf(r0);
        r6 = new java.lang.StringBuilder(r4.length() + 24);
        r6.append("Unknown topic operation");
        r6.append(r4);
        r6.append(com.facebook.appevents.codeless.CodelessMatcher.CURRENT_CLASS_NAME);
        android.util.Log.d("FirebaseMessaging", r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0071, code lost:
        blockingUnsubscribeFromTopic(r0.topic);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007a, code lost:
        if (isDebugLogEnabled() == false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
        r5 = r0.topic;
        r7 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 35);
        r7.append("Unsubscribe from topic: ");
        r7.append(r5);
        r7.append(" succeeded.");
        android.util.Log.d("FirebaseMessaging", r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        blockingSubscribeToTopic(r0.topic);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00aa, code lost:
        if (isDebugLogEnabled() == false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        r5 = r0.topic;
        r7 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 31);
        r7.append("Subscribe to topic: ");
        r7.append(r5);
        r7.append(" succeeded.");
        android.util.Log.d("FirebaseMessaging", r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d0, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00db, code lost:
        if ("SERVICE_NOT_AVAILABLE".equals(r1.getMessage()) != false) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ee, code lost:
        if (r1.getMessage() == null) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f0, code lost:
        android.util.Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f6, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f7, code lost:
        r1 = r1.getMessage();
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r1).length() + 53);
        r5.append("Topic operation failed: ");
        r5.append(r1);
        r5.append(". Will retry Topic operation.");
        android.util.Log.e("FirebaseMessaging", r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011e, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        return true;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean syncTopics() throws java.io.IOException {
        /*
            r8 = this;
        L_0x0000:
            monitor-enter(r8)
            com.google.firebase.messaging.TopicsStore r0 = r8.store     // Catch:{ all -> 0x017f }
            com.google.firebase.messaging.TopicOperation r0 = r0.getNextTopicOperation()     // Catch:{ all -> 0x017f }
            r1 = 1
            if (r0 != 0) goto L_0x0019
            boolean r0 = isDebugLogEnabled()     // Catch:{ all -> 0x017f }
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r2 = "topic sync succeeded"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x017f }
        L_0x0017:
            monitor-exit(r8)     // Catch:{ all -> 0x017f }
            return r1
        L_0x0019:
            monitor-exit(r8)     // Catch:{ all -> 0x017f }
            java.lang.String r2 = "FirebaseMessaging"
            r3 = 0
            java.lang.String r4 = r0.operation     // Catch:{ IOException -> 0x00d0 }
            r5 = -1
            int r6 = r4.hashCode()     // Catch:{ IOException -> 0x00d0 }
            r7 = 83
            if (r6 == r7) goto L_0x0037
            r7 = 85
            if (r6 == r7) goto L_0x002d
            goto L_0x0040
        L_0x002d:
            java.lang.String r6 = "U"
            boolean r4 = r4.equals(r6)     // Catch:{ IOException -> 0x00d0 }
            if (r4 == 0) goto L_0x0040
            r5 = 1
            goto L_0x0040
        L_0x0037:
            java.lang.String r6 = "S"
            boolean r4 = r4.equals(r6)     // Catch:{ IOException -> 0x00d0 }
            if (r4 == 0) goto L_0x0040
            r5 = 0
        L_0x0040:
            java.lang.String r4 = " succeeded."
            if (r5 == 0) goto L_0x00a1
            if (r5 == r1) goto L_0x0071
            boolean r4 = isDebugLogEnabled()     // Catch:{ IOException -> 0x00d0 }
            if (r4 == 0) goto L_0x011f
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x00d0 }
            int r5 = r4.length()     // Catch:{ IOException -> 0x00d0 }
            int r5 = r5 + 24
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d0 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x00d0 }
            java.lang.String r5 = "Unknown topic operation"
            r6.append(r5)     // Catch:{ IOException -> 0x00d0 }
            r6.append(r4)     // Catch:{ IOException -> 0x00d0 }
            java.lang.String r4 = "."
            r6.append(r4)     // Catch:{ IOException -> 0x00d0 }
            java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x00d0 }
            android.util.Log.d(r2, r4)     // Catch:{ IOException -> 0x00d0 }
            goto L_0x011f
        L_0x0071:
            java.lang.String r5 = r0.topic     // Catch:{ IOException -> 0x00d0 }
            r8.blockingUnsubscribeFromTopic(r5)     // Catch:{ IOException -> 0x00d0 }
            boolean r5 = isDebugLogEnabled()     // Catch:{ IOException -> 0x00d0 }
            if (r5 == 0) goto L_0x011f
            java.lang.String r5 = r0.topic     // Catch:{ IOException -> 0x00d0 }
            java.lang.String r6 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x00d0 }
            int r6 = r6.length()     // Catch:{ IOException -> 0x00d0 }
            int r6 = r6 + 35
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d0 }
            r7.<init>(r6)     // Catch:{ IOException -> 0x00d0 }
            java.lang.String r6 = "Unsubscribe from topic: "
            r7.append(r6)     // Catch:{ IOException -> 0x00d0 }
            r7.append(r5)     // Catch:{ IOException -> 0x00d0 }
            r7.append(r4)     // Catch:{ IOException -> 0x00d0 }
            java.lang.String r4 = r7.toString()     // Catch:{ IOException -> 0x00d0 }
            android.util.Log.d(r2, r4)     // Catch:{ IOException -> 0x00d0 }
            goto L_0x011f
        L_0x00a1:
            java.lang.String r5 = r0.topic     // Catch:{ IOException -> 0x00d0 }
            r8.blockingSubscribeToTopic(r5)     // Catch:{ IOException -> 0x00d0 }
            boolean r5 = isDebugLogEnabled()     // Catch:{ IOException -> 0x00d0 }
            if (r5 == 0) goto L_0x011f
            java.lang.String r5 = r0.topic     // Catch:{ IOException -> 0x00d0 }
            java.lang.String r6 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x00d0 }
            int r6 = r6.length()     // Catch:{ IOException -> 0x00d0 }
            int r6 = r6 + 31
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d0 }
            r7.<init>(r6)     // Catch:{ IOException -> 0x00d0 }
            java.lang.String r6 = "Subscribe to topic: "
            r7.append(r6)     // Catch:{ IOException -> 0x00d0 }
            r7.append(r5)     // Catch:{ IOException -> 0x00d0 }
            r7.append(r4)     // Catch:{ IOException -> 0x00d0 }
            java.lang.String r4 = r7.toString()     // Catch:{ IOException -> 0x00d0 }
            android.util.Log.d(r2, r4)     // Catch:{ IOException -> 0x00d0 }
            goto L_0x011f
        L_0x00d0:
            r1 = move-exception
            java.lang.String r4 = r1.getMessage()
            java.lang.String r5 = "SERVICE_NOT_AVAILABLE"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x00f7
            java.lang.String r4 = r1.getMessage()
            java.lang.String r5 = "INTERNAL_SERVER_ERROR"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00ea
            goto L_0x00f7
        L_0x00ea:
            java.lang.String r4 = r1.getMessage()
            if (r4 != 0) goto L_0x00f6
            java.lang.String r1 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r2, r1)
            goto L_0x011e
        L_0x00f6:
            throw r1
        L_0x00f7:
            java.lang.String r1 = r1.getMessage()
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            int r4 = r4 + 53
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Topic operation failed: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = ". Will retry Topic operation."
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            android.util.Log.e(r2, r1)
        L_0x011e:
            r1 = 0
        L_0x011f:
            if (r1 != 0) goto L_0x0122
            return r3
        L_0x0122:
            com.google.firebase.messaging.TopicsStore r1 = r8.store
            monitor-enter(r1)
            com.google.firebase.messaging.SharedPreferencesQueue r2 = r1.topicOperationsQueue     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r0.serializedString     // Catch:{ all -> 0x017c }
            java.util.ArrayDeque<java.lang.String> r4 = r2.internalQueue     // Catch:{ all -> 0x017c }
            monitor-enter(r4)     // Catch:{ all -> 0x017c }
            java.util.ArrayDeque<java.lang.String> r5 = r2.internalQueue     // Catch:{ all -> 0x0179 }
            boolean r3 = r5.remove(r3)     // Catch:{ all -> 0x0179 }
            if (r3 == 0) goto L_0x0142
            boolean r3 = r2.bulkOperation     // Catch:{ all -> 0x0179 }
            if (r3 != 0) goto L_0x0142
            java.util.concurrent.Executor r3 = r2.syncExecutor     // Catch:{ all -> 0x0179 }
            com.google.firebase.messaging.SharedPreferencesQueue$$Lambda$0 r5 = new com.google.firebase.messaging.SharedPreferencesQueue$$Lambda$0     // Catch:{ all -> 0x0179 }
            r5.<init>(r2)     // Catch:{ all -> 0x0179 }
            r3.execute(r5)     // Catch:{ all -> 0x0179 }
        L_0x0142:
            monitor-exit(r4)     // Catch:{ all -> 0x0179 }
            monitor-exit(r1)
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r8.pendingOperations
            monitor-enter(r2)
            java.lang.String r0 = r0.serializedString     // Catch:{ all -> 0x0176 }
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r8.pendingOperations     // Catch:{ all -> 0x0176 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0176 }
            if (r1 != 0) goto L_0x0154
            monitor-exit(r2)     // Catch:{ all -> 0x0176 }
            goto L_0x0000
        L_0x0154:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r8.pendingOperations     // Catch:{ all -> 0x0176 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0176 }
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch:{ all -> 0x0176 }
            java.lang.Object r3 = r1.poll()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.tasks.TaskCompletionSource r3 = (com.google.android.gms.tasks.TaskCompletionSource) r3     // Catch:{ all -> 0x0176 }
            if (r3 == 0) goto L_0x0168
            r4 = 0
            r3.setResult(r4)     // Catch:{ all -> 0x0176 }
        L_0x0168:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r1 == 0) goto L_0x0173
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r8.pendingOperations     // Catch:{ all -> 0x0176 }
            r1.remove(r0)     // Catch:{ all -> 0x0176 }
        L_0x0173:
            monitor-exit(r2)     // Catch:{ all -> 0x0176 }
            goto L_0x0000
        L_0x0176:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0176 }
            throw r0
        L_0x0179:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0179 }
            throw r0     // Catch:{ all -> 0x017c }
        L_0x017c:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x017f:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x017f }
            goto L_0x0183
        L_0x0182:
            throw r0
        L_0x0183:
            goto L_0x0182
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    public void syncWithDelaySecondsInternal(long j) {
        this.syncExecutor.schedule(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30, j << 1), MAX_DELAY_SEC)), j, TimeUnit.SECONDS);
        setSyncScheduledOrRunning(true);
    }
}
