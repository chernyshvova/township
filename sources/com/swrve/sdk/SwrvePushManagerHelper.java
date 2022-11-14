package com.swrve.sdk;

import android.os.Bundle;
import java.util.Set;
import org.json.JSONObject;

public class SwrvePushManagerHelper {
    public static String getPayload(Bundle bundle) {
        JSONObject jSONObject;
        String string = bundle.getString(SwrveNotificationInternalPayloadConstants.SWRVE_NESTED_JSON_PAYLOAD_KEY);
        if (string != null) {
            try {
                jSONObject = new JSONObject(string);
            } catch (Exception e) {
                SwrveLogger.m2753e("Error getting json payload.", e, new Object[0]);
                return "";
            }
        } else {
            jSONObject = new JSONObject();
        }
        Set<String> keySet = ((Bundle) bundle.clone()).keySet();
        keySet.removeAll(SwrveNotificationInternalPayloadConstants.PUSH_INTERNAL_KEYS);
        for (String str : keySet) {
            if (!jSONObject.has(str)) {
                jSONObject.put(str, bundle.get(str));
            }
        }
        return jSONObject.toString();
    }
}
