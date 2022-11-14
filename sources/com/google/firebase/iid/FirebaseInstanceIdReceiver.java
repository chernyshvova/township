package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    @WorkerThread
    public final int onMessageReceive(@NonNull Context context, @NonNull CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.await(new FcmBroadcastProcessor(context).process(cloudMessage.getIntent()))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to send message to service.", e);
            return 500;
        }
    }

    @WorkerThread
    public final void onNotificationDismissed(@NonNull Context context, @NonNull Bundle bundle) {
        try {
            Tasks.await(new FcmBroadcastProcessor(context).process(new Intent(CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS).putExtras(bundle)));
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to send notification dismissed event to service.", e);
        }
    }

    @WorkerThread
    public final void onNotificationOpen(@NonNull Context context, @NonNull Bundle bundle) {
        try {
            Tasks.await(new FcmBroadcastProcessor(context).process(new Intent(CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_OPEN).putExtras(bundle)));
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to send notification open event to service.", e);
        }
    }
}
