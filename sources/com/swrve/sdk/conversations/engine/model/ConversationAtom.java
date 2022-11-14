package com.swrve.sdk.conversations.engine.model;

import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import java.io.Serializable;

public class ConversationAtom implements Serializable {
    public ConversationStyle style;
    public String tag;
    public TYPE type;

    public enum TYPE {
        CONTENT_HTML,
        CONTENT_IMAGE,
        CONTENT_SPACER,
        CONTENT_VIDEO,
        INPUT_MULTIVALUE,
        INPUT_STARRATING,
        UNKNOWN
    }

    public ConversationAtom(String str, TYPE type2, ConversationStyle conversationStyle) {
        this.tag = str;
        this.type = type2;
        this.style = conversationStyle;
    }

    public ConversationStyle getStyle() {
        return this.style;
    }

    public String getTag() {
        return this.tag;
    }

    public TYPE getType() {
        return this.type;
    }
}
