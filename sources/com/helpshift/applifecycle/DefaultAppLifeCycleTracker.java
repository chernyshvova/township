package com.helpshift.applifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.helpshift.PluginEventBridge;
import com.helpshift.util.HSLogger;

public class DefaultAppLifeCycleTracker extends BaseAppLifeCycleTracker implements Application.ActivityLifecycleCallbacks {
    public static String TAG = "DALCTracker";
    public boolean isAppForeground;
    public boolean isConfigurationChanged = false;
    public int started;
    public int stopped;

    public DefaultAppLifeCycleTracker(Application application) {
        super(application);
        application.unregisterActivityLifecycleCallbacks(this);
        application.registerActivityLifecycleCallbacks(this);
        if (PluginEventBridge.shouldCallFirstForegroundEvent()) {
            this.started++;
            this.isAppForeground = true;
        }
    }

    public boolean isAppInForeground() {
        return this.started > this.stopped;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.started++;
        if (!this.isConfigurationChanged) {
            if (!this.isAppForeground) {
                notifyAppForeground();
            }
            this.isAppForeground = true;
        }
        this.isConfigurationChanged = false;
    }

    public void onActivityStopped(Activity activity) {
        boolean z = true;
        this.stopped++;
        if (activity == null || !activity.isChangingConfigurations()) {
            z = false;
        }
        this.isConfigurationChanged = z;
        if (!z && this.started == this.stopped) {
            this.isAppForeground = false;
            notifyAppBackground();
        }
    }

    public void onManualAppBackgroundAPI() {
        HSLogger.m3241e(TAG, "Install API is called with manualLifeCycleTracking config as false, Ignore this event");
    }

    public void onManualAppForegroundAPI() {
        HSLogger.m3241e(TAG, "Install API is called with manualLifeCycleTracking config as false, Ignore this event");
    }
}
