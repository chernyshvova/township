package com.helpshift.conversation.smartintent;

public abstract class BaseIntentUIModel {
    public final String label;
    public final long localId;

    public BaseIntentUIModel(long j, String str) {
        this.localId = j;
        this.label = str;
    }

    public abstract SmartIntentType getType();
}
