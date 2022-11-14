package com.helpshift.app;

import android.content.Context;
import com.helpshift.applifecycle.HSAppLifeCycleController;
import com.helpshift.applifecycle.HSAppLifeCycleListener;
import com.helpshift.common.domain.HSThreadFactory;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class CampaignAppLifeCycleListener implements HSAppLifeCycleListener {
    public ExecutorService cachedExecutorService = Executors.newCachedThreadPool(new HSThreadFactory("m-lcycle"));
    public LinkedBlockingDeque<LifecycleListener> lifecycleListeners = new LinkedBlockingDeque<>();

    public void addLifecycleListener(final LifecycleListener lifecycleListener) {
        this.lifecycleListeners.addFirst(lifecycleListener);
        this.cachedExecutorService.execute(new Runnable() {
            public void run() {
                if (HSAppLifeCycleController.getInstance().isAppInForeground()) {
                    lifecycleListener.onForeground();
                }
            }
        });
    }

    public void onAppBackground(Context context) {
        if (this.lifecycleListeners.size() != 0) {
            this.cachedExecutorService.execute(new Runnable() {
                public void run() {
                    Iterator it = CampaignAppLifeCycleListener.this.lifecycleListeners.iterator();
                    while (it.hasNext()) {
                        ((LifecycleListener) it.next()).onBackground();
                    }
                }
            });
        }
    }

    public void onAppForeground(Context context) {
        if (this.lifecycleListeners.size() != 0) {
            this.cachedExecutorService.execute(new Runnable() {
                public void run() {
                    Iterator it = CampaignAppLifeCycleListener.this.lifecycleListeners.iterator();
                    while (it.hasNext()) {
                        ((LifecycleListener) it.next()).onForeground();
                    }
                }
            });
        }
    }
}
