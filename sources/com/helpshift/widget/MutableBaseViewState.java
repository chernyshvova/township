package com.helpshift.widget;

public class MutableBaseViewState extends BaseViewState {
    public void setEnabled(boolean z) {
        if (z != this.isEnabled) {
            this.isEnabled = z;
            notifyChange(this);
        }
    }

    public void setVisible(boolean z) {
        if (z != this.isVisible) {
            this.isVisible = z;
            notifyChange(this);
        }
    }
}
