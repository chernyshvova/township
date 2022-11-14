package com.helpshift.conversation.smartintent;

public abstract class BaseSmartIntentViewState {
    public final boolean enforceIntentSelection;
    public final String promptTitle;

    public BaseSmartIntentViewState(String str, boolean z) {
        this.promptTitle = str;
        this.enforceIntentSelection = z;
    }
}
