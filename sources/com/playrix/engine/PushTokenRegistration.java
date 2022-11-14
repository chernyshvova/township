package com.playrix.engine;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class PushTokenRegistration {
    public static final String TAG = "FcmPushTokenRegistration ";

    public static void initialize() {
        try {
            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                public void onComplete(Task<InstanceIdResult> task) {
                    if (!task.isSuccessful()) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("FcmPushTokenRegistration getInstanceId failed: ");
                        outline24.append(task.getException());
                        Logger.logWarning(outline24.toString());
                        return;
                    }
                    String token = task.getResult().getToken();
                    if (token != null && !token.isEmpty()) {
                        Logger.logDebug("FcmPushTokenRegistration FCM Registration Token: " + token);
                        Engine.onPushTokenReceived(token);
                    }
                }
            });
        } catch (IllegalStateException e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("FcmPushTokenRegistration Error! Firebase was not initialized: ");
            outline24.append(e.toString());
            Logger.logError(outline24.toString());
        }
    }
}
