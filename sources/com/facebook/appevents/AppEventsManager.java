package com.facebook.appevents;

import androidx.annotation.RestrictTo;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: AppEventsManager.kt */
public final class AppEventsManager {
    public static final AppEventsManager INSTANCE = new AppEventsManager();

    public static final void start() {
        Class<AppEventsManager> cls = AppEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FetchedAppSettingsManager.getAppSettingsAsync(new AppEventsManager$start$1());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
