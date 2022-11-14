package com.swrve.sdk;

import java.util.Map;

public interface ISwrveConversationSDK {
    public static final int CONVERSATION_VERSION = 4;

    void queueConversationEvent(String str, String str2, String str3, int i, Map<String, String> map);

    void sendQueuedEvents();
}
