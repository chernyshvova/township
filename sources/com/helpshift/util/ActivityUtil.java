package com.helpshift.util;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;

public class ActivityUtil {
    public static Boolean isFullScreen(Activity activity) {
        return Boolean.valueOf((activity.getWindow().getAttributes().flags & 1024) == 1024);
    }

    public static void startLauncherActivityAndFinish(@NonNull Activity activity) {
        Intent launchIntent;
        if (activity != null && (launchIntent = ApplicationUtil.getLaunchIntent(activity, activity.getPackageName())) != null) {
            activity.finish();
            activity.startActivity(launchIntent);
        }
    }
}
