package com.swrve.sdk;

import java.util.Map;

public interface SwrveUserResourcesDiffListener {
    void onUserResourcesDiffError(Exception exc);

    void onUserResourcesDiffSuccess(Map<String, Map<String, String>> map, Map<String, Map<String, String>> map2, String str);
}
