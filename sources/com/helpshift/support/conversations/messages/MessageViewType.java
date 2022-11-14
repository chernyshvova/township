package com.helpshift.support.conversations.messages;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.internal.FacebookRequestErrorClassification;

public enum MessageViewType {
    USER_TEXT_MESSAGE(10),
    ADMIN_TEXT_MESSAGE(20),
    USER_SCREENSHOT_ATTACHMENT(30),
    ADMIN_ATTACHMENT_IMAGE(40),
    ADMIN_ATTACHMENT_GENERIC(50),
    ADMIN_REQUEST_ATTACHMENT(60),
    REQUESTED_APP_REVIEW(70),
    REQUEST_FOR_REOPEN(80),
    CONFIRMATION_REJECTED(90),
    CONVERSATION_FOOTER(100),
    AGENT_TYPING_FOOTER(110),
    SYSTEM_DATE(120),
    SYSTEM_DIVIDER(130),
    USER_SELECTABLE_OPTION(140),
    ADMIN_SUGGESTIONS_LIST(SwipeRefreshLayout.SCALE_DOWN_DURATION),
    SYSTEM_PUBLISH_ID(DrawerLayout.PEEK_DELAY),
    SYSTEM_CONVERSATION_REDACTED_MESSAGE(170),
    HISTORY_LOADING_VIEW(180),
    ADMIN_REDACTED_MESSAGE(FacebookRequestErrorClassification.EC_INVALID_TOKEN),
    USER_REDACTED_MESSAGE(200),
    USER_ATTACHMENT_GENERIC(210),
    ACTION_CARD_MESSAGE(220),
    USER_SMART_INTENT_MESSAGE(230),
    ADMIN_CSAT_MESSAGE(240),
    USER_RSP_CSAT_BOT(250);
    
    public final int key;

    /* access modifiers changed from: public */
    MessageViewType(int i) {
        this.key = i;
    }

    public static MessageViewType getEnum(int i) {
        for (MessageViewType messageViewType : values()) {
            if (messageViewType.key == i) {
                return messageViewType;
            }
        }
        return null;
    }
}
