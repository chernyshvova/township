package com.helpshift.widget;

import com.helpshift.conversation.activeconversation.message.HistoryLoadingState;

public class HistoryLoadingViewState extends HSBaseObservable {
    public HistoryLoadingState state = HistoryLoadingState.NONE;

    public HistoryLoadingState getState() {
        return this.state;
    }

    public void notifyInitialState() {
        notifyChange(this);
    }
}
