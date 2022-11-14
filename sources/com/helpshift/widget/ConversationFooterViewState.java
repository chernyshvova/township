package com.helpshift.widget;

import com.helpshift.conversation.activeconversation.message.ConversationFooterState;

public class ConversationFooterViewState extends HSBaseObservable {
    public ConversationFooterState state = ConversationFooterState.NONE;

    public ConversationFooterState getState() {
        return this.state;
    }

    public void notifyInitialState() {
        notifyChange(this);
    }
}
