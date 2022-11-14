package com.swrve.sdk.conversations.engine.model;

import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import java.io.Serializable;

public class ChoiceInputItem implements Serializable {
    public String answer_id;
    public String answer_text;
    public ConversationStyle style;

    public ChoiceInputItem(String str, String str2, ConversationStyle conversationStyle) {
        this.answer_id = str;
        this.answer_text = str2;
        this.style = conversationStyle;
    }

    public String getAnswerID() {
        return this.answer_id;
    }

    public String getAnswerText() {
        return this.answer_text;
    }

    public ConversationStyle getStyle() {
        return this.style;
    }

    public void setStyle(ConversationStyle conversationStyle) {
        this.style = conversationStyle;
    }

    public String toString() {
        return getAnswerText();
    }
}
