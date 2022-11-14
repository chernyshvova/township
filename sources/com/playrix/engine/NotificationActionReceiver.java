package com.playrix.engine;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationActionReceiver extends BroadcastReceiver {
    public static final String ACTION_KEY = "action";
    public static final String DATA_KEY = "data";
    public static final String LOG_TAG = "[NotificationActionReceiver] ";

    public static PendingIntent createActionIntent(Context context, int i, int i2, JSONObject jSONObject) {
        Intent intent = new Intent(context, NotificationActionReceiver.class);
        intent.putExtra("data", jSONObject.toString());
        intent.putExtra("action", i2);
        return PendingIntent.getBroadcast(context.getApplicationContext(), i, intent, 1207959552);
    }

    public static JSONObject getDataFromIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("data");
        intent.removeExtra("data");
        if (stringExtra != null) {
            try {
                return new JSONObject(stringExtra);
            } catch (JSONException unused) {
                Logger.logError("[NotificationActionReceiver] error parsing intent: invalid JSON string");
                return null;
            }
        } else {
            Logger.logError("[NotificationActionReceiver] error parsing intent: no data field in the intent!");
            return null;
        }
    }

    public void onReceive(Context context, Intent intent) {
        Logger.logDebug("[NotificationActionReceiver] onReceive()");
        JSONObject dataFromIntent = getDataFromIntent(intent);
        int intExtra = intent.getIntExtra("action", -1);
        intent.removeExtra("action");
        if (dataFromIntent != null && intExtra != -1) {
            Notifications.processNotificationAction(intExtra, dataFromIntent);
        }
    }
}
