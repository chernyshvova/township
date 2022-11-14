package com.helpshift.widget;

public class ScrollJumperViewState extends BaseViewState {
    public boolean shouldShowUnreadMessagesIndicator;

    public ScrollJumperViewState(boolean z, boolean z2) {
        this.isVisible = z;
        this.shouldShowUnreadMessagesIndicator = z2;
    }

    public boolean shouldShowUnreadMessagesIndicator() {
        return this.shouldShowUnreadMessagesIndicator;
    }
}
