package com.swrve.sdk.conversations.engine.model;

import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;

public abstract class ControlBase extends ConversationAtom {
    public ControlActions action;
    public String target;

    public ControlBase(String str, ConversationAtom.TYPE type, ConversationStyle conversationStyle, ControlActions controlActions, String str2) {
        super(str, type, conversationStyle);
        this.action = controlActions;
        this.target = str2;
    }

    public ControlActions getActions() {
        return this.action;
    }

    public String getTarget() {
        return this.target;
    }

    public boolean hasActions() {
        return this.action != null;
    }
}
