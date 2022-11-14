package com.unity3d.services.core.request;

import java.util.HashMap;

public interface ISDKMetricSender {
    void SendSDKMetricEvent(SDKMetricEvents sDKMetricEvents);

    void SendSDKMetricEventWithTag(SDKMetricEvents sDKMetricEvents, HashMap<String, String> hashMap);
}
