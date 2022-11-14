package com.playrix.engine;

import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.FetchedAppSettings;
import com.playrix.engine.Notifications;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class PushNotifications {
    public static final String TAG = "PushNotifications ";
    public static Map<Integer, Long> _lastShownMessages = new HashMap();
    public static List<IPushNotificationsDelegate> _pushNotificationsDelegates = new ArrayList();

    public interface IPushNotificationsDelegate {
        PushNotificationData processPushNotification(Bundle bundle);
    }

    static {
        registerPushNotificationsDelegate(new PushNotificationsDelegate());
    }

    public static void processPushNotification(Bundle bundle) {
        if (bundle == null) {
            Logger.logWarning("PushNotifications Received empty push bundle, ignored");
            return;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("PushNotifications Received push message: ");
        outline24.append(bundle.isEmpty() ? "empty" : bundle.toString());
        Logger.logDebug(outline24.toString());
        PushNotificationData processWithDelegate = processWithDelegate(bundle);
        if (processWithDelegate == null) {
            Logger.logDebug("PushNotifications Notification was consumed by a delegate or no suitable delegate was found, skip");
            return;
        }
        try {
            JSONObject jsonData = processWithDelegate.getJsonData();
            if (jsonData != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry next : _lastShownMessages.entrySet()) {
                    int intValue = ((Integer) next.getKey()).intValue();
                    Long l = (Long) next.getValue();
                    if (l.longValue() > System.currentTimeMillis()) {
                        hashMap.put(Integer.valueOf(intValue), l);
                    }
                }
                _lastShownMessages = hashMap;
                JSONObject optJSONObject = jsonData.optJSONObject(Notifications.PAYLOAD_KEY);
                StringBuilder sb = new StringBuilder();
                sb.append(jsonData.optString("message"));
                sb.append(FetchedAppSettings.DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
                sb.append(optJSONObject != null ? optJSONObject.toString() : "");
                int hashCode = sb.toString().hashCode();
                if (!_lastShownMessages.containsKey(Integer.valueOf(hashCode))) {
                    _lastShownMessages.put(Integer.valueOf(hashCode), Long.valueOf(System.currentTimeMillis() + ((long) (processWithDelegate.getDuplicatesCheckTime() * 1000))));
                    Notifications.processNotification(jsonData, Notifications.NotificationType.PUSH);
                }
            }
        } catch (Exception e) {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("PushNotifications Exception: ");
            outline242.append(e.getMessage());
            Logger.logError(outline242.toString());
        }
    }

    public static PushNotificationData processWithDelegate(Bundle bundle) {
        for (IPushNotificationsDelegate processPushNotification : _pushNotificationsDelegates) {
            PushNotificationData processPushNotification2 = processPushNotification.processPushNotification(bundle);
            if (processPushNotification2 != null) {
                return processPushNotification2;
            }
        }
        return null;
    }

    public static void registerPushNotificationsDelegate(IPushNotificationsDelegate iPushNotificationsDelegate) {
        _pushNotificationsDelegates.add(iPushNotificationsDelegate);
    }

    public static class PushNotificationData {
        public static final int DEFAULT_DUPLICATE_CHECK_TIME = 900;
        public int _duplicatesCheckTime = 900;
        public JSONObject _jsonData = null;

        public PushNotificationData(JSONObject jSONObject, int i) {
            this._jsonData = jSONObject;
            this._duplicatesCheckTime = i;
        }

        public int getDuplicatesCheckTime() {
            return this._duplicatesCheckTime;
        }

        public JSONObject getJsonData() {
            return this._jsonData;
        }

        public void setDuplicatesCheckTime(int i) {
            this._duplicatesCheckTime = i;
        }

        public void setJsonData(JSONObject jSONObject) {
            this._jsonData = jSONObject;
        }

        public PushNotificationData(JSONObject jSONObject) {
            this._jsonData = jSONObject;
        }
    }
}
