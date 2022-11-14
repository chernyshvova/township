package com.playrix.township.lib;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.playrix.engine.Engine;
import com.playrix.engine.Logger;

public class Settings {
    public static final String TAG = "[Settings] ";

    public static boolean disableCustomNotifLayout(boolean z) {
        return nativeGetBool("DisableCustomNotifLayout", false) || (z && nativeGetBool("DisableCustomNotifLayoutNight", false));
    }

    public static boolean disableCustomNotifLayoutButtons() {
        return nativeGetBool("DisableCustomNotifLayoutButtons", false);
    }

    public static void dropSharedWithPrefix(String str) {
        SharedPreferences preferences = Engine.getPreferences();
        if (preferences == null || TextUtils.isEmpty(str)) {
            Logger.logError("[Settings] Invalid prefix or prefs instance");
            return;
        }
        SharedPreferences.Editor edit = preferences.edit();
        for (String next : preferences.getAll().keySet()) {
            if (next.startsWith(str)) {
                edit.remove(next);
            }
        }
        edit.apply();
    }

    public static boolean isCityDeleted() {
        return nativeGetBool("DeletedCity", false);
    }

    public static boolean isImmersiveModeDisabled() {
        return nativeGetBool("DisableImmersiveMode", false);
    }

    public static native boolean nativeGetBool(String str, boolean z);

    public static boolean useNotifSummaryInbox() {
        return nativeGetBool("UseNotifSummaryInbox", false);
    }
}
