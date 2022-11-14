package com.swrve.sdk.runnable;

import com.swrve.sdk.SwrveUserResourcesDiffListener;
import java.util.Map;

public abstract class UIThreadSwrveResourcesDiffRunnable extends UIThreadSwrveRunnable implements SwrveUserResourcesDiffListener {
    public Map<String, Map<String, String>> newResourcesValues;
    public Map<String, Map<String, String>> oldResourcesValues;
    public String resourcesAsJSON;

    public void run() {
        onUserResourcesDiffSuccess(this.oldResourcesValues, this.newResourcesValues, this.resourcesAsJSON);
    }

    public void setData(Map<String, Map<String, String>> map, Map<String, Map<String, String>> map2, String str) {
        this.oldResourcesValues = map;
        this.newResourcesValues = map2;
        this.resourcesAsJSON = str;
    }
}
