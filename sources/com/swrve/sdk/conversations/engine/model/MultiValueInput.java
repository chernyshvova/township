package com.swrve.sdk.conversations.engine.model;

import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import java.io.Serializable;
import java.util.ArrayList;

public class MultiValueInput extends ConversationAtom implements Serializable {
    public String description;
    public ArrayList<ChoiceInputItem> values;

    public MultiValueInput(String str, ConversationAtom.TYPE type, ConversationStyle conversationStyle, String str2, ArrayList<ChoiceInputItem> arrayList) {
        super(str, type, conversationStyle);
        this.description = str2;
        this.values = arrayList;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<ChoiceInputItem> getValues() {
        return this.values;
    }
}
