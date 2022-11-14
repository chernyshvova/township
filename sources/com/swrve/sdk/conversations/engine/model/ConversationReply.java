package com.swrve.sdk.conversations.engine.model;

import java.util.HashMap;

public class ConversationReply {
    public String control;
    public HashMap<String, Object> data = new HashMap<>();

    public String getControl() {
        return this.control;
    }

    public HashMap<String, Object> getData() {
        return this.data;
    }

    public void setControl(String str) {
        this.control = str;
    }

    public void setData(HashMap<String, Object> hashMap) {
        this.data = hashMap;
    }
}
