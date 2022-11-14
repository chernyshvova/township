package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.Store;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public class FirebaseInstanceId {
    public static final Pattern API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");
    public static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    public static Store store;
    @GuardedBy("FirebaseInstanceId.class")
    @VisibleForTesting
    public static ScheduledExecutorService syncExecutor;
    public final FirebaseApp app;
    @VisibleForTesting
    public final Executor fileIoExecutor;
    public final FirebaseInstallationsApi firebaseInstallations;
    public final Metadata metadata;
    public final RequestDeduplicator requestDeduplicator;
    public final GmsRpc rpc;
    @GuardedBy("this")
    public boolean syncScheduledOrRunning = false;

    public FirebaseInstanceId(FirebaseApp firebaseApp, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        firebaseApp.checkNotDeleted();
        Metadata metadata2 = new Metadata(firebaseApp.applicationContext);
        ExecutorService newCachedSingleThreadExecutor = FirebaseIidExecutors.newCachedSingleThreadExecutor();
        ExecutorService newCachedSingleThreadExecutor2 = FirebaseIidExecutors.newCachedSingleThreadExecutor();
        if (Metadata.getDefaultSenderId(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (store == null) {
                    firebaseApp.checkNotDeleted();
                    store = new Store(firebaseApp.applicationContext);
                }
            }
            this.app = firebaseApp;
            this.metadata = metadata2;
            this.rpc = new GmsRpc(firebaseApp, metadata2, provider, provider2, firebaseInstallationsApi);
            this.fileIoExecutor = newCachedSingleThreadExecutor2;
            this.requestDeduplicator = new RequestDeduplicator(newCachedSingleThreadExecutor);
            this.firebaseInstallations = firebaseInstallationsApi;
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    public static <T> T awaitTaskAllowOnMainThread(@NonNull Task<T> task) throws InterruptedException {
        Preconditions.checkNotNull(task, "Task must not be null");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.addOnCompleteListener(FirebaseInstanceId$$Lambda$1.$instance, (OnCompleteListener<T>) new FirebaseInstanceId$$Lambda$2(countDownLatch));
        countDownLatch.await(30000, TimeUnit.MILLISECONDS);
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        } else if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        } else {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    public static void checkRequiredFirebaseOptions(@NonNull FirebaseApp firebaseApp) {
        firebaseApp.checkNotDeleted();
        Preconditions.checkNotEmpty(firebaseApp.options.projectId, "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        firebaseApp.checkNotDeleted();
        Preconditions.checkNotEmpty(firebaseApp.options.applicationId, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        firebaseApp.checkNotDeleted();
        Preconditions.checkNotEmpty(firebaseApp.options.apiKey, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        firebaseApp.checkNotDeleted();
        Preconditions.checkArgument(firebaseApp.options.applicationId.contains(CertificateUtil.DELIMITER), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        firebaseApp.checkNotDeleted();
        Preconditions.checkArgument(API_KEY_FORMAT.matcher(firebaseApp.options.apiKey).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @NonNull
    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static boolean isDebugLogEnabled() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    public String blockingGetMasterToken() throws IOException {
        String defaultSenderId = Metadata.getDefaultSenderId(this.app);
        checkRequiredFirebaseOptions(this.app);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            try {
                return ((InstanceIdResult) Tasks.await(getInstanceId(defaultSenderId, "*"), 30000, TimeUnit.MILLISECONDS)).getToken();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause instanceof IOException) {
                    if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                        synchronized (this) {
                            store.deleteAll();
                        }
                    }
                    throw ((IOException) cause);
                } else if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else {
                    throw new IOException(e);
                }
            } catch (InterruptedException | TimeoutException unused) {
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("MAIN_THREAD");
        }
    }

    public void enqueueTaskWithDelaySeconds(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        throw new java.lang.IllegalStateException(r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getIdWithoutTriggeringSync() {
        /*
            r5 = this;
            com.google.firebase.iid.Store r0 = store     // Catch:{ InterruptedException -> 0x0027 }
            com.google.firebase.FirebaseApp r1 = r5.app     // Catch:{ InterruptedException -> 0x0027 }
            java.lang.String r1 = r1.getPersistenceKey()     // Catch:{ InterruptedException -> 0x0027 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0027 }
            long r2 = r0.writeCreationTimeToSharedPreferences(r1)     // Catch:{ all -> 0x0024 }
            java.util.Map<java.lang.String, java.lang.Long> r4 = r0.subtypeCreationTimes     // Catch:{ all -> 0x0024 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0024 }
            r4.put(r1, r2)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0027 }
            com.google.firebase.installations.FirebaseInstallationsApi r0 = r5.firebaseInstallations     // Catch:{ InterruptedException -> 0x0027 }
            com.google.android.gms.tasks.Task r0 = r0.getId()     // Catch:{ InterruptedException -> 0x0027 }
            java.lang.Object r0 = awaitTaskAllowOnMainThread(r0)     // Catch:{ InterruptedException -> 0x0027 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ InterruptedException -> 0x0027 }
            return r0
        L_0x0024:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0027 }
            throw r1     // Catch:{ InterruptedException -> 0x0027 }
        L_0x0027:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceId.getIdWithoutTriggeringSync():java.lang.String");
    }

    @NonNull
    @Deprecated
    public Task<InstanceIdResult> getInstanceId() {
        checkRequiredFirebaseOptions(this.app);
        return getInstanceId(Metadata.getDefaultSenderId(this.app), "*");
    }

    public final String getSubtype() {
        FirebaseApp firebaseApp = this.app;
        firebaseApp.checkNotDeleted();
        if ("[DEFAULT]".equals(firebaseApp.name)) {
            return "";
        }
        return this.app.getPersistenceKey();
    }

    @Deprecated
    @Nullable
    public String getToken() {
        checkRequiredFirebaseOptions(this.app);
        Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
        if (tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            synchronized (this) {
                if (!this.syncScheduledOrRunning) {
                    syncWithDelaySecondsInternal(0);
                }
            }
        }
        return Store.Token.getTokenOrNull(tokenWithoutTriggeringSync);
    }

    @Nullable
    public Store.Token getTokenWithoutTriggeringSync() {
        return getTokenWithoutTriggeringSync(Metadata.getDefaultSenderId(this.app), "*");
    }

    public final Task lambda$getInstanceId$2$FirebaseInstanceId(String str, String str2) throws Exception {
        Task<TContinuationResult> task;
        String idWithoutTriggeringSync = getIdWithoutTriggeringSync();
        Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync(str, str2);
        if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            return Tasks.forResult(new InstanceIdResultImpl(idWithoutTriggeringSync, tokenWithoutTriggeringSync.token));
        }
        RequestDeduplicator requestDeduplicator2 = this.requestDeduplicator;
        synchronized (requestDeduplicator2) {
            Pair pair = new Pair(str, str2);
            task = requestDeduplicator2.getTokenRequests.get(pair);
            if (task == null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(pair);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 24);
                    sb.append("Making new request for: ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                GmsRpc gmsRpc = this.rpc;
                if (gmsRpc != null) {
                    task = gmsRpc.extractResponseWhenComplete(gmsRpc.startRpc(idWithoutTriggeringSync, str, str2, new Bundle())).onSuccessTask(this.fileIoExecutor, new FirebaseInstanceId$$Lambda$4(this, str, str2, idWithoutTriggeringSync)).continueWithTask(requestDeduplicator2.executor, new RequestDeduplicator$$Lambda$0(requestDeduplicator2, pair));
                    requestDeduplicator2.getTokenRequests.put(pair, task);
                } else {
                    throw null;
                }
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf2 = String.valueOf(pair);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 29);
                sb2.append("Joining ongoing request for: ");
                sb2.append(valueOf2);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
        }
        return task;
    }

    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    public synchronized void syncWithDelaySecondsInternal(long j) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(30, j << 1), MAX_DELAY_SEC)), j);
        this.syncScheduledOrRunning = true;
    }

    public boolean tokenNeedsRefresh(@Nullable Store.Token token) {
        if (token != null) {
            if (System.currentTimeMillis() > token.timestamp + Store.Token.REFRESH_PERIOD_MILLIS || !this.metadata.getAppVersionCode().equals(token.appVersion)) {
                return true;
            }
            return false;
        }
        return true;
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        checkRequiredFirebaseOptions(firebaseApp);
        firebaseApp.checkNotDeleted();
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) firebaseApp.componentRuntime.get(FirebaseInstanceId.class);
        Preconditions.checkNotNull(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    @Nullable
    @VisibleForTesting
    public Store.Token getTokenWithoutTriggeringSync(String str, String str2) {
        Store.Token parse;
        Store store2 = store;
        String subtype = getSubtype();
        synchronized (store2) {
            parse = Store.Token.parse(store2.store.getString(store2.createTokenKey(subtype, str, str2), (String) null));
        }
        return parse;
    }

    public final Task<InstanceIdResult> getInstanceId(String str, String str2) {
        if (str2.isEmpty() || str2.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN) || str2.equalsIgnoreCase("gcm")) {
            str2 = "*";
        }
        return Tasks.forResult(null).continueWithTask(this.fileIoExecutor, new FirebaseInstanceId$$Lambda$0(this, str, str2));
    }
}
