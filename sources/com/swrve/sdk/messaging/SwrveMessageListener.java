package com.swrve.sdk.messaging;

import java.util.Map;

public interface SwrveMessageListener {
    void onMessage(SwrveMessage swrveMessage);

    void onMessage(SwrveMessage swrveMessage, Map<String, String> map);
}
