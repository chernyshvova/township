package com.playrix.gplay;

import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.playrix.engine.Engine;
import com.playrix.engine.Logger;
import com.playrix.engine.PushNotifications;
import java.util.Map;

public class EngineFcmService extends FirebaseMessagingService {
    public static final String TAG = "EngineFcmService ";

    private Bundle getDataBundle(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();
        Bundle bundle = new Bundle();
        for (Map.Entry next : data.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
        return bundle;
    }

    public void onDeletedMessages() {
        Logger.logDebug("EngineFcmService FCM server said, that pending messages were deleted");
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        PushNotifications.processPushNotification(getDataBundle(remoteMessage));
    }

    public void onNewToken(String str) {
        Logger.logDebug("EngineFcmService Refreshed token: " + str);
        Engine.onPushTokenReceived(str);
    }
}
