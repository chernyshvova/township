package com.unity3d.services.core.request;

import java.util.Map;

public interface ISDKMetrics {
    void sendEvent(String str);

    void sendEventWithTags(String str, Map<String, String> map);
}
