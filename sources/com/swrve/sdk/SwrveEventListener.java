package com.swrve.sdk;

import android.content.Context;
import com.swrve.sdk.conversations.SwrveConversation;
import com.swrve.sdk.conversations.SwrveConversationListener;
import com.swrve.sdk.messaging.SwrveBaseMessage;
import com.swrve.sdk.messaging.SwrveEmbeddedMessage;
import com.swrve.sdk.messaging.SwrveEmbeddedMessageListener;
import com.swrve.sdk.messaging.SwrveMessage;
import com.swrve.sdk.messaging.SwrveMessageListener;
import com.swrve.sdk.messaging.SwrveOrientation;
import java.lang.ref.WeakReference;
import java.util.Map;

public class SwrveEventListener implements ISwrveEventListener {
    public final SwrveConversationListener conversationListener;
    public final SwrveEmbeddedMessageListener embeddedMessageListener;
    public final SwrveMessageListener messageListener;
    public final WeakReference<SwrveBase<?, ?>> sdk;

    public SwrveEventListener(SwrveBase<?, ?> swrveBase, SwrveMessageListener swrveMessageListener, SwrveConversationListener swrveConversationListener, SwrveEmbeddedMessageListener swrveEmbeddedMessageListener) {
        this.sdk = new WeakReference<>(swrveBase);
        this.messageListener = swrveMessageListener;
        this.conversationListener = swrveConversationListener;
        this.embeddedMessageListener = swrveEmbeddedMessageListener;
    }

    public void onEvent(String str, Map<String, String> map) {
        boolean z;
        SwrveBase swrveBase;
        SwrveBase swrveBase2;
        SwrveConversation conversationForEvent;
        if (this.conversationListener == null || SwrveHelper.isNullOrEmpty(str) || (swrveBase2 = (SwrveBase) this.sdk.get()) == null || (conversationForEvent = swrveBase2.getConversationForEvent(str, map)) == null) {
            z = false;
        } else {
            this.conversationListener.onMessage(conversationForEvent);
            z = true;
        }
        if (z) {
            QaUser.campaignTriggeredMessageNoDisplay(str, map);
        } else if ((this.messageListener != null || this.embeddedMessageListener != null) && !SwrveHelper.isNullOrEmpty(str) && (swrveBase = (SwrveBase) this.sdk.get()) != null) {
            SwrveOrientation swrveOrientation = SwrveOrientation.Both;
            Context context = swrveBase.getContext();
            if (context != null) {
                swrveOrientation = SwrveOrientation.parse(context.getResources().getConfiguration().orientation);
            }
            SwrveBaseMessage baseMessageForEvent = swrveBase.getBaseMessageForEvent(str, map, swrveOrientation);
            if (baseMessageForEvent != null) {
                swrveBase.lastEventPayloadUsed = map;
                if (baseMessageForEvent instanceof SwrveMessage) {
                    SwrveMessageListener swrveMessageListener = this.messageListener;
                    if (swrveMessageListener != null) {
                        swrveMessageListener.onMessage((SwrveMessage) baseMessageForEvent);
                    }
                } else if ((baseMessageForEvent instanceof SwrveEmbeddedMessage) && this.embeddedMessageListener != null) {
                    this.embeddedMessageListener.onMessage(context, (SwrveEmbeddedMessage) baseMessageForEvent, swrveBase.retrievePersonalizationProperties(map, (Map<String, String>) null));
                }
                swrveBase.lastEventPayloadUsed = null;
            }
        }
    }
}
