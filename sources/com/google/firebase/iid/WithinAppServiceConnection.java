package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public class WithinAppServiceConnection implements ServiceConnection {
    @Nullable
    public WithinAppServiceBinder binder;
    @GuardedBy("this")
    public boolean connectionInProgress = false;
    public final Intent connectionIntent;
    public final Context context;
    public final Queue<BindRequest> intentQueue = new ArrayDeque();
    public final ScheduledExecutorService scheduledExecutorService;

    /* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class BindRequest {
        public final Intent intent;
        public final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();

        public BindRequest(Intent intent2) {
            this.intent = intent2;
        }

        public void finish() {
            this.taskCompletionSource.trySetResult(null);
        }
    }

    public WithinAppServiceConnection(Context context2, String str) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        this.context = context2.getApplicationContext();
        this.connectionIntent = new Intent(str).setPackage(this.context.getPackageName());
        this.scheduledExecutorService = scheduledThreadPoolExecutor;
    }

    @GuardedBy("this")
    public final void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            this.intentQueue.poll().finish();
        }
    }

    public final synchronized void flushQueue() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "flush queue called");
        }
        while (!this.intentQueue.isEmpty()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "found intent to be delivered");
            }
            if (this.binder == null || !this.binder.isBinderAlive()) {
                startConnectionIfNeeded();
                return;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "binder is alive, sending the intent.");
            }
            this.binder.send(this.intentQueue.poll());
        }
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(valueOf.length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        this.connectionInProgress = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            Log.e("FirebaseInstanceId", sb2.toString());
            finishAllInQueue();
            return;
        }
        this.binder = (WithinAppServiceBinder) iBinder;
        flushQueue();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(valueOf.length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        flushQueue();
    }

    @GuardedBy("this")
    public final void startConnectionIfNeeded() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            StringBuilder sb = new StringBuilder(39);
            sb.append("binder is dead. start connection? ");
            sb.append(!this.connectionInProgress);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        if (!this.connectionInProgress) {
            this.connectionInProgress = true;
            try {
                if (!ConnectionTracker.getInstance().bindService(this.context, this.connectionIntent, this, 65)) {
                    Log.e("FirebaseInstanceId", "binding to the service failed");
                    this.connectionInProgress = false;
                    finishAllInQueue();
                }
            } catch (SecurityException e) {
                Log.e("FirebaseInstanceId", "Exception while binding the service", e);
            }
        }
    }
}
