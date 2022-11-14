package com.swrve.sdk.messaging;

import android.content.Context;
import java.util.Map;

public interface SwrveEmbeddedMessageListener {
    void onMessage(Context context, SwrveEmbeddedMessage swrveEmbeddedMessage, Map<String, String> map);
}
