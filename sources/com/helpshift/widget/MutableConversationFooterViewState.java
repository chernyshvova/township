package com.helpshift.widget;

import com.helpshift.conversation.activeconversation.message.ConversationFooterState;

public class MutableConversationFooterViewState extends ConversationFooterViewState {
    public void setState(ConversationFooterState conversationFooterState) {
        if (this.state != conversationFooterState) {
            this.state = conversationFooterState;
            notifyChange(this);
        }
    }
}
