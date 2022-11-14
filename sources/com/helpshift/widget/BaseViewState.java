package com.helpshift.widget;

public class BaseViewState extends HSBaseObservable {
    public boolean isEnabled = true;
    public boolean isVisible = true;

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void notifyInitialState() {
        notifyChange(this);
    }
}
