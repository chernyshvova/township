package com.swrve.sdk.conversations.engine.model;

import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;

public class StarRating extends ConversationAtom {
    public String star_color;
    public String value;

    public StarRating(String str, ConversationAtom.TYPE type, ConversationStyle conversationStyle, String str2, String str3) {
        super(str, type, conversationStyle);
        this.value = str2;
        this.star_color = str3;
    }

    public String getStarColor() {
        return this.star_color;
    }

    public String getValue() {
        return this.value;
    }
}
