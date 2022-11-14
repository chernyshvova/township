package com.facebook.ads;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Keep
public class AdSDKNotificationManager {
    public static final List<AdSDKNotificationListener> sNotificationListeners = Collections.synchronizedList(new ArrayList());

    public static void addSDKNotificationListener(AdSDKNotificationListener adSDKNotificationListener) {
        synchronized (sNotificationListeners) {
            sNotificationListeners.add(adSDKNotificationListener);
        }
    }

    public static List<AdSDKNotificationListener> getNotificationListeners() {
        return sNotificationListeners;
    }

    public static void removeSDKNotificationListener(AdSDKNotificationListener adSDKNotificationListener) {
        synchronized (sNotificationListeners) {
            sNotificationListeners.remove(adSDKNotificationListener);
        }
    }
}
