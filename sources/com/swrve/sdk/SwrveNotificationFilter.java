package com.swrve.sdk;

import android.app.Notification;
import androidx.core.app.NotificationCompat;

public interface SwrveNotificationFilter {
    Notification filterNotification(NotificationCompat.Builder builder, int i, SwrveNotificationDetails swrveNotificationDetails, String str);
}
