package com.helpshift.support.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.drive.DriveFile;
import com.helpshift.C2466R;
import com.helpshift.PluginEventBridge;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.support.activities.ParentActivity;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.AssetsUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;

public final class SupportNotification {
    public static final String APP_NAME = "app_name";
    public static final String BUNGLE_ARG_NOTIFICATION_CONVERSATION_ID = "conversationIdInPush";

    public static NotificationCompat.Builder createNotification(Context context, Long l, String str, int i, String str2) {
        HSLogger.m3237d("Helpshift_SupportNotif", "Creating Support notification : \n Id : " + str + "\n Title : " + str2 + "\n Message count : " + i);
        HelpshiftContext.getCoreApi().getDelegate().didReceiveNotification(i);
        String quantityString = context.getResources().getQuantityString(C2466R.plurals.hs__notification_content_title, i, new Object[]{Integer.valueOf(i)});
        int logoResourceValue = ApplicationUtil.getLogoResourceValue(context);
        Integer num = HelpshiftContext.getCoreApi().getSDKConfigurationDM().getInt(SDKConfigurationDM.NOTIFICATION_ICON_ID);
        if (AssetsUtil.resourceExists(context, num)) {
            logoResourceValue = num.intValue();
        }
        Integer num2 = HelpshiftContext.getCoreApi().getSDKConfigurationDM().getInt(SDKConfigurationDM.NOTIFICATION_LARGE_ICON_ID);
        Bitmap decodeResource = AssetsUtil.resourceExists(context, num2) ? BitmapFactory.decodeResource(context.getResources(), num2.intValue()) : null;
        int abs = str != null ? Math.abs(str.hashCode()) : 0;
        Intent intent = new Intent(context, ParentActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.putExtra(SupportFragment.SUPPORT_MODE, 1);
        intent.putExtra(BUNGLE_ARG_NOTIFICATION_CONVERSATION_ID, l);
        intent.putExtra("isRoot", true);
        PendingIntent pendingIntentForNotification = PluginEventBridge.getPendingIntentForNotification(context, PendingIntent.getActivity(context, abs, intent, 0));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(logoResourceValue);
        builder.setContentTitle(str2);
        builder.setContentText(quantityString);
        builder.setContentIntent(pendingIntentForNotification);
        builder.setAutoCancel(true);
        if (decodeResource != null) {
            builder.setLargeIcon(decodeResource);
        }
        Uri notificationSoundUri = AssetsUtil.getNotificationSoundUri(HelpshiftContext.getApplicationContext(), HelpshiftContext.getCoreApi().getSDKConfigurationDM().getInt(SDKConfigurationDM.NOTIFICATION_SOUND_ID));
        if (notificationSoundUri != null) {
            builder.setSound(notificationSoundUri);
            if (ApplicationUtil.isPermissionGranted(context, "android.permission.VIBRATE")) {
                builder.setDefaults(6);
            } else {
                builder.setDefaults(4);
            }
        } else if (ApplicationUtil.isPermissionGranted(context, "android.permission.VIBRATE")) {
            builder.setDefaults(-1);
        } else {
            builder.setDefaults(5);
        }
        return builder;
    }
}
