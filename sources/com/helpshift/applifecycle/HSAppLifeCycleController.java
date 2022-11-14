package com.helpshift.applifecycle;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.helpshift.util.concurrent.ApiExecutorFactory;
import java.util.ArrayList;
import java.util.List;

public class HSAppLifeCycleController implements HSAppLifeCycleListener {
    public static HSAppLifeCycleController instance = new HSAppLifeCycleController();
    public static final Object lock = new Object();
    public List<HSAppLifeCycleListener> appLifeCycleListeners = new ArrayList();
    public BaseAppLifeCycleTracker lifeCycleTracker;

    public static HSAppLifeCycleController getInstance() {
        return instance;
    }

    public synchronized void init(Application application, boolean z) {
        if (this.lifeCycleTracker == null) {
            if (z) {
                this.lifeCycleTracker = new ManualAppLifeCycleTracker(application);
            } else {
                this.lifeCycleTracker = new DefaultAppLifeCycleTracker(application);
            }
            this.lifeCycleTracker.registerAppLifeCycleListener(this);
        }
    }

    public boolean isAppInForeground() {
        BaseAppLifeCycleTracker baseAppLifeCycleTracker = this.lifeCycleTracker;
        if (baseAppLifeCycleTracker == null) {
            return false;
        }
        return baseAppLifeCycleTracker.isAppInForeground();
    }

    public void onAppBackground(final Context context) {
        ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
            public void run() {
                synchronized (HSAppLifeCycleController.lock) {
                    for (HSAppLifeCycleListener onAppBackground : HSAppLifeCycleController.this.appLifeCycleListeners) {
                        onAppBackground.onAppBackground(context);
                    }
                }
            }
        });
    }

    public void onAppForeground(final Context context) {
        ApiExecutorFactory.getHandlerExecutor().runAsync(new Runnable() {
            public void run() {
                synchronized (HSAppLifeCycleController.lock) {
                    for (HSAppLifeCycleListener onAppForeground : HSAppLifeCycleController.this.appLifeCycleListeners) {
                        onAppForeground.onAppForeground(context);
                    }
                }
            }
        });
    }

    public void onManualAppBackgroundAPI() {
        BaseAppLifeCycleTracker baseAppLifeCycleTracker = this.lifeCycleTracker;
        if (baseAppLifeCycleTracker != null) {
            baseAppLifeCycleTracker.onManualAppBackgroundAPI();
        }
    }

    public void onManualAppForegroundAPI() {
        BaseAppLifeCycleTracker baseAppLifeCycleTracker = this.lifeCycleTracker;
        if (baseAppLifeCycleTracker != null) {
            baseAppLifeCycleTracker.onManualAppForegroundAPI();
        }
    }

    public void registerAppLifeCycleListener(@NonNull HSAppLifeCycleListener hSAppLifeCycleListener) {
        synchronized (lock) {
            this.appLifeCycleListeners.add(hSAppLifeCycleListener);
        }
    }
}
