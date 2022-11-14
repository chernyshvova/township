package com.playrix.township.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.playrix.engine.Engine;
import com.playrix.engine.Notifications;
import com.swrve.sdk.SwrveNotificationConstants;
import com.swrve.sdk.conversations.engine.model.styles.ConversationColorStyle;

public class NotificationsCustomization implements Notifications.Delegate {
    public static int getResourcesColor(Resources resources, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            return resources.getColor(i);
        }
        return getResourcesColorNew(resources, i);
    }

    @TargetApi(23)
    public static int getResourcesColorNew(Resources resources, int i) {
        return resources.getColor(i, (Resources.Theme) null);
    }

    public static void setupCustomImage(Context context, RemoteViews remoteViews, String str, int i) {
        int identifier;
        Resources resources = context.getResources();
        if (i != 0 && (identifier = resources.getIdentifier(str, "id", context.getPackageName())) != 0) {
            remoteViews.setImageViewResource(identifier, i);
        }
    }

    public static void setupCustomText(Context context, RemoteViews remoteViews, String str, String str2, String str3) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "id", context.getPackageName());
        if (identifier != 0) {
            remoteViews.setTextViewText(identifier, str3);
            int identifier2 = resources.getIdentifier(str2, ConversationColorStyle.TYPE_COLOR, context.getPackageName());
            if (identifier2 != 0) {
                remoteViews.setTextColor(identifier, getResourcesColor(resources, identifier2));
            }
        }
    }

    public void onNotification(NotificationCompat.Builder builder, Notifications.Content content) {
        Context context = Engine.getContext();
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(SwrveNotificationConstants.PUSH_BUNDLE, "layout", context.getPackageName());
        if (identifier != 0) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), identifier);
            setupCustomImage(context, remoteViews, "notif_background", resources.getIdentifier("notif_background", "drawable", context.getPackageName()));
            setupCustomImage(context, remoteViews, "notif_image", content.iconLargeId);
            setupCustomText(context, remoteViews, "notif_title", "color_notif_title", content.title);
            setupCustomText(context, remoteViews, "notif_message", "color_notif_text", content.message);
            builder.setContent(remoteViews);
            builder.setStyle((NotificationCompat.Style) null);
        }
    }

    public void onSummary(NotificationCompat.Builder builder, Notifications.Content content, Notifications.Summary summary) {
    }
}
