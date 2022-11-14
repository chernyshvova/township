package com.helpshift.applifecycle;

import android.content.Context;
import androidx.annotation.NonNull;

public abstract class BaseAppLifeCycleTracker {
    public Context context;
    public HSAppLifeCycleListener lifeCycleListener;

    public BaseAppLifeCycleTracker(Context context2) {
        this.context = context2;
    }

    public abstract boolean isAppInForeground();

    public void notifyAppBackground() {
        HSAppLifeCycleListener hSAppLifeCycleListener = this.lifeCycleListener;
        if (hSAppLifeCycleListener != null) {
            hSAppLifeCycleListener.onAppBackground(this.context);
        }
    }

    public void notifyAppForeground() {
        HSAppLifeCycleListener hSAppLifeCycleListener = this.lifeCycleListener;
        if (hSAppLifeCycleListener != null) {
            hSAppLifeCycleListener.onAppForeground(this.context);
        }
    }

    public abstract void onManualAppBackgroundAPI();

    public abstract void onManualAppForegroundAPI();

    public void registerAppLifeCycleListener(@NonNull HSAppLifeCycleListener hSAppLifeCycleListener) {
        this.lifeCycleListener = hSAppLifeCycleListener;
    }

    public void unregisterAppLifeCycleListener() {
        this.lifeCycleListener = null;
    }
}
