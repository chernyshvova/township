package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.Store;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public class SyncTask implements Runnable {
    public final FirebaseInstanceId iid;
    public final long nextDelaySeconds;
    @VisibleForTesting
    public ExecutorService processorExecutor = FirebaseIidExecutors.newCachedSingleThreadExecutor();
    public final PowerManager.WakeLock syncWakeLock;

    @VisibleForTesting
    /* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable
        public SyncTask task;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.task = syncTask;
        }

        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.task;
            if (syncTask != null && syncTask.isDeviceConnected()) {
                if (FirebaseInstanceId.isDebugLogEnabled()) {
                    Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
                }
                SyncTask syncTask2 = this.task;
                syncTask2.iid.enqueueTaskWithDelaySeconds(syncTask2, 0);
                this.task.getContext().unregisterReceiver(this);
                this.task = null;
            }
        }

        public void registerReceiver() {
            if (FirebaseInstanceId.isDebugLogEnabled()) {
                Log.d("FirebaseInstanceId", "Connectivity change received registered");
            }
            this.task.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @VisibleForTesting
    public SyncTask(FirebaseInstanceId firebaseInstanceId, long j) {
        this.iid = firebaseInstanceId;
        this.nextDelaySeconds = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.syncWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    public Context getContext() {
        FirebaseApp firebaseApp = this.iid.app;
        firebaseApp.checkNotDeleted();
        return firebaseApp.applicationContext;
    }

    public final void invokeOnTokenRefresh(String str) {
        FirebaseApp firebaseApp = this.iid.app;
        firebaseApp.checkNotDeleted();
        if ("[DEFAULT]".equals(firebaseApp.name)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                FirebaseApp firebaseApp2 = this.iid.app;
                firebaseApp2.checkNotDeleted();
                String valueOf = String.valueOf(firebaseApp2.name);
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new FcmBroadcastProcessor(getContext(), this.processorExecutor).process(intent);
        }
    }

    public boolean isDeviceConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @VisibleForTesting
    public boolean maybeRefreshToken() throws IOException {
        Store.Token tokenWithoutTriggeringSync = this.iid.getTokenWithoutTriggeringSync();
        boolean z = true;
        if (!this.iid.tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            return true;
        }
        try {
            String blockingGetMasterToken = this.iid.blockingGetMasterToken();
            if (blockingGetMasterToken == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (tokenWithoutTriggeringSync == null || !blockingGetMasterToken.equals(tokenWithoutTriggeringSync.token)) {
                invokeOnTokenRefresh(blockingGetMasterToken);
            }
            return true;
        } catch (IOException e) {
            String message = e.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                z = false;
            }
            if (z) {
                String message2 = e.getMessage();
                GeneratedOutlineSupport.outline31(GeneratedOutlineSupport.outline3(message2, 52), "Token retrieval failed: ", message2, ". Will retry token retrieval", "FirebaseInstanceId");
                return false;
            } else if (e.getMessage() == null) {
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else {
                throw e;
            }
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @SuppressLint({"Wakelock"})
    public void run() {
        if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
            this.syncWakeLock.acquire();
        }
        try {
            this.iid.setSyncScheduledOrRunning(true);
            if (!this.iid.metadata.isGmscorePresent()) {
                this.iid.setSyncScheduledOrRunning(false);
                if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    this.syncWakeLock.release();
                }
            } else if (!ServiceStarter.getInstance().hasAccessNetworkStatePermission(getContext()) || isDeviceConnected()) {
                if (maybeRefreshToken()) {
                    this.iid.setSyncScheduledOrRunning(false);
                } else {
                    this.iid.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                }
                if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    this.syncWakeLock.release();
                }
            } else {
                new ConnectivityChangeReceiver(this).registerReceiver();
                if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    this.syncWakeLock.release();
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb.toString());
            this.iid.setSyncScheduledOrRunning(false);
            if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                this.syncWakeLock.release();
            }
        } catch (Throwable th) {
            if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                this.syncWakeLock.release();
            }
            throw th;
        }
    }
}
