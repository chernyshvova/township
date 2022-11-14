package com.swrve.sdk.runnable;

import com.swrve.sdk.SwrveUserResourcesListener;
import java.util.Map;

public abstract class UIThreadSwrveResourcesRunnable extends UIThreadSwrveRunnable implements SwrveUserResourcesListener {
    public Map<String, Map<String, String>> resources;
    public String resourcesAsJSON;

    public void run() {
        Exception exc = this.exception;
        if (exc != null) {
            onUserResourcesError(exc);
        } else {
            onUserResourcesSuccess(this.resources, this.resourcesAsJSON);
        }
    }

    public void setData(Map<String, Map<String, String>> map, String str) {
        this.resources = map;
        this.resourcesAsJSON = str;
    }
}
