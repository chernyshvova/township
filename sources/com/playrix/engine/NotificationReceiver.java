package com.playrix.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.playrix.engine.Notifications;
import org.json.JSONObject;

public class NotificationReceiver extends BroadcastReceiver {
    public static final String LOG_TAG = "[NotificationReceiver] ";

    public void onReceive(Context context, Intent intent) {
        Logger.logDebug("[NotificationReceiver] onReceive()");
        JSONObject dataFromIntent = Scheduler.getDataFromIntent(intent);
        if (dataFromIntent != null) {
            Notifications.processNotification(dataFromIntent, Notifications.NotificationType.LOCAL);
        }
    }
}
