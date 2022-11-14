package com.helpshift.app;

public class AppLifeCycleStateHolder {
    public static boolean isAppInForeground;

    public static boolean isAppInForeground() {
        return isAppInForeground;
    }

    public static void setAppInForeground(boolean z) {
        isAppInForeground = z;
    }
}
