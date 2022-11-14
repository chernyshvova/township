package com.helpshift.conversation.smartintent;

public class RootIntentUIModel extends BaseIntentUIModel {
    public RootIntentUIModel(long j, String str) {
        super(j, str);
    }

    public SmartIntentType getType() {
        return SmartIntentType.ROOT_INTENT;
    }
}
