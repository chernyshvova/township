package com.playrix.township.lib;

import android.content.Context;
import androidx.annotation.Keep;
import com.playrix.engine.Logger;

public class DebugSettings {
    public static final String TAG = "[DebugSettings] ";

    public static void SwitchToDeveloperMode() {
    }

    public static String getDebugSettings() {
        Logger.logError("[DebugSettings] mustn't be used");
        return "";
    }

    @Keep
    public static String getEnabledDebugSettings() {
        Logger.logError("[DebugSettings] mustn't be used");
        return "";
    }

    public static boolean getOption(String str, boolean z) {
        Logger.logError("[DebugSettings] mustn't be used");
        return false;
    }

    public static boolean isSettingsAppApplication(Context context) {
        return false;
    }

    public static void loadDebugSettings(Context context) {
        Logger.logError("[DebugSettings] mustn't be used");
    }
}
