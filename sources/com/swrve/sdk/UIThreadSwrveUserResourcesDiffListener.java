package com.swrve.sdk;

import android.app.Activity;
import com.swrve.sdk.runnable.UIThreadSwrveResourcesDiffRunnable;
import java.lang.ref.WeakReference;
import java.util.Map;

public class UIThreadSwrveUserResourcesDiffListener implements SwrveUserResourcesDiffListener {
    public final WeakReference<Activity> context;
    public final UIThreadSwrveResourcesDiffRunnable uiWork;

    public UIThreadSwrveUserResourcesDiffListener(Activity activity, UIThreadSwrveResourcesDiffRunnable uIThreadSwrveResourcesDiffRunnable) {
        this.context = new WeakReference<>(activity);
        this.uiWork = uIThreadSwrveResourcesDiffRunnable;
    }

    public void onUserResourcesDiffError(Exception exc) {
        Activity activity = (Activity) this.context.get();
        if (activity != null && !activity.isFinishing()) {
            this.uiWork.setException(exc);
            activity.runOnUiThread(this.uiWork);
        }
    }

    public void onUserResourcesDiffSuccess(Map<String, Map<String, String>> map, Map<String, Map<String, String>> map2, String str) {
        Activity activity = (Activity) this.context.get();
        if (activity != null && !activity.isFinishing()) {
            this.uiWork.setData(map, map2, str);
            activity.runOnUiThread(this.uiWork);
        }
    }
}
