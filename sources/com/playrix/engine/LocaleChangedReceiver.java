package com.playrix.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LocaleChangedReceiver extends BroadcastReceiver {
    public static final String LOG_TAG = "[LocaleChangedReceiver] ";

    public void onReceive(Context context, Intent intent) {
        Logger.logDebug("[LocaleChangedReceiver] onReceive()");
        if (intent.getAction().compareTo("android.intent.action.LOCALE_CHANGED") == 0) {
            Logger.logDebug("[LocaleChangedReceiver] locale changed");
            Notifications.onLocaleChanged();
            Shortcuts.onLocaleChanged();
        }
    }
}
