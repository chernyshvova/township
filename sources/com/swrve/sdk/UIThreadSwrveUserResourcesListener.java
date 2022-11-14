package com.swrve.sdk;

import android.app.Activity;
import com.swrve.sdk.runnable.UIThreadSwrveResourcesRunnable;
import java.lang.ref.WeakReference;
import java.util.Map;

public class UIThreadSwrveUserResourcesListener implements SwrveUserResourcesListener {
    public final WeakReference<Activity> context;
    public final UIThreadSwrveResourcesRunnable uiWork;

    public UIThreadSwrveUserResourcesListener(Activity activity, UIThreadSwrveResourcesRunnable uIThreadSwrveResourcesRunnable) {
        this.context = new WeakReference<>(activity);
        this.uiWork = uIThreadSwrveResourcesRunnable;
    }

    public void onUserResourcesError(Exception exc) {
        Activity activity = (Activity) this.context.get();
        if (activity != null && !activity.isFinishing()) {
            this.uiWork.setException(exc);
            activity.runOnUiThread(this.uiWork);
        }
    }

    public void onUserResourcesSuccess(Map<String, Map<String, String>> map, String str) {
        Activity activity = (Activity) this.context.get();
        if (activity != null && !activity.isFinishing()) {
            this.uiWork.setData(map, str);
            activity.runOnUiThread(this.uiWork);
        }
    }
}
