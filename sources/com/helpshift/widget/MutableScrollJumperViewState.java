package com.helpshift.widget;

public class MutableScrollJumperViewState extends ScrollJumperViewState {
    public MutableScrollJumperViewState(boolean z, boolean z2) {
        super(z, z2);
    }

    public void setShouldShowUnreadMessagesIndicator(boolean z) {
        if (this.shouldShowUnreadMessagesIndicator != z) {
            this.shouldShowUnreadMessagesIndicator = z;
            notifyChange(this);
        }
    }

    public void setVisible(boolean z) {
        if (this.isVisible != z) {
            this.isVisible = z;
            notifyChange(this);
        }
    }
}
