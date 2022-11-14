package com.playrix.township.lib;

import androidx.core.content.ContextCompat;
import com.playrix.engine.Engine;
import com.playrix.engine.EngineApplication;
import com.playrix.engine.Notifications;
import com.playrix.engine.PushTokenRegistration;

public class GameApplication extends EngineApplication {
    public static final String TAG = "GameApplication";

    private boolean isInternetPermissionGranted() {
        return ContextCompat.checkSelfPermission(this, "android.permission.INTERNET") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    public void onCreate() {
        super.onCreate();
        if (isInternetPermissionGranted()) {
            Engine.getPreferences();
            PushTokenRegistration.initialize();
            Notifications.setDelegate(new NotificationsCustomization());
        }
    }
}
