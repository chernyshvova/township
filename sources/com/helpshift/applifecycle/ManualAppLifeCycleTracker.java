package com.helpshift.applifecycle;

import android.content.Context;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;

public class ManualAppLifeCycleTracker extends BaseAppLifeCycleTracker {
    public static String TAG = "MALCTracker";
    public boolean isAppInForeground = false;

    public ManualAppLifeCycleTracker(Context context) {
        super(context);
    }

    public boolean isAppInForeground() {
        return this.isAppInForeground;
    }

    public void onManualAppBackgroundAPI() {
        if (!this.isAppInForeground) {
            HSLogger.m3237d(TAG, "Application is already in background, so ignore this event");
        } else if (HelpshiftContext.installCallSuccessful.get()) {
            this.isAppInForeground = false;
            notifyAppBackground();
        } else {
            HSLogger.m3241e(TAG, "onManualAppBackgroundAPI is called without calling install API");
        }
    }

    public void onManualAppForegroundAPI() {
        if (this.isAppInForeground) {
            HSLogger.m3237d(TAG, "Application is already in foreground, so ignore this event");
        } else if (HelpshiftContext.installCallSuccessful.get()) {
            this.isAppInForeground = true;
            notifyAppForeground();
        } else {
            HSLogger.m3241e(TAG, "onManualAppForegroundAPI is called without calling install API");
        }
    }
}
