package com.swrve.sdk;

import java.util.Map;

public class EventQueueItem {
    public final String eventType;
    public final Map<String, Object> parameters;
    public final Map<String, String> payload;
    public final boolean triggerEventListener;
    public final String userId;

    public EventQueueItem(String str, String str2, Map<String, Object> map, Map<String, String> map2, boolean z) {
        this.userId = str;
        this.eventType = str2;
        this.parameters = map;
        this.payload = map2;
        this.triggerEventListener = z;
    }
}
