package com.swrve.sdk;

import java.util.Map;

public interface SwrveUserResourcesListener {
    void onUserResourcesError(Exception exc);

    void onUserResourcesSuccess(Map<String, Map<String, String>> map, String str);
}
