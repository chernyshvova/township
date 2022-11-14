package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.WithinAppServiceConnection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public class FcmBroadcastProcessor {
    @GuardedBy("lock")
    public static WithinAppServiceConnection fcmServiceConn;
    public static final Object lock = new Object();
    public final Context context;
    public final Executor executor;

    public FcmBroadcastProcessor(Context context2) {
        this.context = context2;
        this.executor = FcmBroadcastProcessor$$Lambda$0.$instance;
    }

    public static Task<Integer> bindToMessagingService(Context context2, Intent intent) {
        WithinAppServiceConnection withinAppServiceConnection;
        Task<Void> task;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context2, "com.google.firebase.MESSAGING_EVENT");
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        synchronized (withinAppServiceConnection) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
            }
            WithinAppServiceConnection.BindRequest bindRequest = new WithinAppServiceConnection.BindRequest(intent);
            ScheduledExecutorService scheduledExecutorService = withinAppServiceConnection.scheduledExecutorService;
            bindRequest.taskCompletionSource.getTask().addOnCompleteListener((Executor) scheduledExecutorService, new WithinAppServiceConnection$BindRequest$$Lambda$1(scheduledExecutorService.schedule(new WithinAppServiceConnection$BindRequest$$Lambda$0(bindRequest), 9000, TimeUnit.MILLISECONDS)));
            withinAppServiceConnection.intentQueue.add(bindRequest);
            withinAppServiceConnection.flushQueue();
            task = bindRequest.taskCompletionSource.getTask();
        }
        return task.continueWith(FirebaseIidExecutors.DIRECT_EXECUTOR, FcmBroadcastProcessor$$Lambda$3.$instance);
    }

    public static final /* synthetic */ Integer lambda$bindToMessagingService$3$FcmBroadcastProcessor() throws Exception {
        return -1;
    }

    public static final /* synthetic */ Integer lambda$startMessagingService$1$FcmBroadcastProcessor() throws Exception {
        return 403;
    }

    @KeepForSdk
    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context2 = this.context;
        boolean z2 = PlatformVersion.isAtLeastO() && context2.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & DriveFile.MODE_READ_ONLY) != 0) {
            z = true;
        }
        if (!z2 || z) {
            return Tasks.call(this.executor, new FcmBroadcastProcessor$$Lambda$1(context2, intent)).continueWithTask(this.executor, new FcmBroadcastProcessor$$Lambda$2(context2, intent));
        }
        return bindToMessagingService(context2, intent);
    }

    public FcmBroadcastProcessor(Context context2, ExecutorService executorService) {
        this.context = context2;
        this.executor = executorService;
    }
}
