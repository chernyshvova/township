package com.helpshift.conversation.smartintent;

public class LeafIntentUIModel extends BaseIntentUIModel {
    public LeafIntentUIModel(long j, String str) {
        super(j, str);
    }

    public SmartIntentType getType() {
        return SmartIntentType.LEAF_INTENT;
    }
}
