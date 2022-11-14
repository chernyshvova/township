package com.helpshift;

import android.app.PendingIntent;
import android.content.Context;

public final class PluginEventBridge {
    public static PluginEventsAPI pluginEventsAPI;

    public interface PluginEventsAPI {
        PendingIntent getPendingIntentForNotification(Context context, PendingIntent pendingIntent);

        void sendMessage(String str, String str2);

        boolean shouldCallFirstForegroundEvent();
    }

    public static PendingIntent getPendingIntentForNotification(Context context, PendingIntent pendingIntent) {
        PluginEventsAPI pluginEventsAPI2 = pluginEventsAPI;
        return pluginEventsAPI2 != null ? pluginEventsAPI2.getPendingIntentForNotification(context, pendingIntent) : pendingIntent;
    }

    public static void sendMessage(String str, String str2) {
        PluginEventsAPI pluginEventsAPI2 = pluginEventsAPI;
        if (pluginEventsAPI2 != null) {
            pluginEventsAPI2.sendMessage(str, str2);
        }
    }

    public static void setPluginEventsAPI(PluginEventsAPI pluginEventsAPI2) {
        pluginEventsAPI = pluginEventsAPI2;
    }

    public static boolean shouldCallFirstForegroundEvent() {
        PluginEventsAPI pluginEventsAPI2 = pluginEventsAPI;
        if (pluginEventsAPI2 != null) {
            return pluginEventsAPI2.shouldCallFirstForegroundEvent();
        }
        return false;
    }
}
