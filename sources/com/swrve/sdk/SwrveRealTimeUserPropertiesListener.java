package com.swrve.sdk;

import java.util.Map;

public interface SwrveRealTimeUserPropertiesListener {
    void onRealTimeUserPropertiesError(Exception exc);

    void onRealTimeUserPropertiesSuccess(Map<String, String> map, String str);
}
