package com.helpshift.widget;

import com.helpshift.conversation.activeconversation.message.HistoryLoadingState;

public class MutableHistoryLoadingViewState extends HistoryLoadingViewState {
    public void setState(HistoryLoadingState historyLoadingState) {
        if (this.state != historyLoadingState) {
            this.state = historyLoadingState;
            notifyChange(this);
        }
    }
}
