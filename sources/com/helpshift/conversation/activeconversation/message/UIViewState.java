package com.helpshift.conversation.activeconversation.message;

import com.helpshift.util.HSCloneable;

public class UIViewState implements HSCloneable {
    public boolean isFooterVisible;
    public boolean isRoundedBackground;

    public UIViewState() {
        this(false, false);
    }

    public boolean equals(Object obj) {
        UIViewState uIViewState = (UIViewState) obj;
        return uIViewState != null && uIViewState.isFooterVisible() == this.isFooterVisible && uIViewState.isRoundedBackground() == this.isRoundedBackground;
    }

    public boolean isFooterVisible() {
        return this.isFooterVisible;
    }

    public boolean isRoundedBackground() {
        return this.isRoundedBackground;
    }

    public void updateViewState(UIViewState uIViewState) {
        if (uIViewState != null) {
            this.isFooterVisible = uIViewState.isFooterVisible;
            this.isRoundedBackground = uIViewState.isRoundedBackground;
        }
    }

    public UIViewState(boolean z, boolean z2) {
        this.isFooterVisible = z;
        this.isRoundedBackground = z2;
    }

    public UIViewState deepClone() {
        return new UIViewState(this);
    }

    public UIViewState(UIViewState uIViewState) {
        this.isFooterVisible = uIViewState.isFooterVisible;
        this.isRoundedBackground = uIViewState.isRoundedBackground;
    }
}
