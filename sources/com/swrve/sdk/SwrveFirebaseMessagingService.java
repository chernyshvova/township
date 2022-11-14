package com.swrve.sdk;

import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class SwrveFirebaseMessagingService extends FirebaseMessagingService {
    public SwrvePushManager getSwrvePushManager() {
        return new SwrvePushManagerImp(this);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        try {
            if (remoteMessage.getData() != null) {
                SwrveLogger.m2755i("Received Firebase notification: %s" + remoteMessage.getData().toString(), new Object[0]);
                Bundle bundle = new Bundle();
                for (String next : remoteMessage.getData().keySet()) {
                    bundle.putString(next, remoteMessage.getData().get(next));
                }
                if (!SwrveHelper.isSwrvePush(bundle)) {
                    SwrveLogger.m2755i("Received Push: but not processing as it doesn't contain: %s or %s", SwrveNotificationInternalPayloadConstants.SWRVE_TRACKING_KEY, SwrveNotificationConstants.SWRVE_SILENT_TRACKING_KEY);
                    return;
                }
                getSwrvePushManager().processMessage(bundle);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Swrve exception: ", e, new Object[0]);
        }
    }

    public void onNewToken(String str) {
        super.onNewToken(str);
        ISwrveBase instance = SwrveSDKBase.getInstance();
        if (instance instanceof Swrve) {
            ((Swrve) instance).setRegistrationId(str);
        } else {
            SwrveLogger.m2754e("Could not notify the SDK of a new token.", new Object[0]);
        }
    }
}
