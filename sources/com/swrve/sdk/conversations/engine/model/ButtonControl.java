package com.swrve.sdk.conversations.engine.model;

import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;

public class ButtonControl extends ControlBase {
    public String description;

    public ButtonControl(String str, ConversationAtom.TYPE type, ConversationStyle conversationStyle, ControlActions controlActions, String str2, String str3) {
        super(str, type, conversationStyle, controlActions, str2);
        this.description = str3;
    }

    public String getDescription() {
        return this.description;
    }
}
