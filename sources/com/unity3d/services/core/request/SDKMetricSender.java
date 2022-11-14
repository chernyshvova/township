package com.unity3d.services.core.request;

import java.util.HashMap;

public class SDKMetricSender implements ISDKMetricSender {
    public void SendSDKMetricEvent(SDKMetricEvents sDKMetricEvents) {
        ISDKMetrics instance;
        if (sDKMetricEvents != null && (instance = SDKMetrics.getInstance()) != null) {
            instance.sendEvent(sDKMetricEvents.toString());
        }
    }

    public void SendSDKMetricEventWithTag(SDKMetricEvents sDKMetricEvents, HashMap hashMap) {
        ISDKMetrics instance;
        if (sDKMetricEvents != null && (instance = SDKMetrics.getInstance()) != null) {
            instance.sendEventWithTags(sDKMetricEvents.toString(), hashMap);
        }
    }
}
