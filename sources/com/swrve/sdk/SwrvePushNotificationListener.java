package com.swrve.sdk;

import org.json.JSONObject;

public interface SwrvePushNotificationListener {
    void onPushNotification(JSONObject jSONObject);
}
