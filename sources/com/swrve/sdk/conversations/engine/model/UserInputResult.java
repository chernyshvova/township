package com.swrve.sdk.conversations.engine.model;

import java.io.Serializable;

public class UserInputResult implements Serializable {
    public static final String TYPE_SINGLE_CHOICE = "choice";
    public static final String TYPE_STAR_RATING = "star-rating";
    public static final String TYPE_VIDEO_PLAY = "play";
    public int conversationId;
    public String fragmentTag;
    public String pageTag;
    public Object result;
    public String type;

    public int getConversationId() {
        return this.conversationId;
    }

    public String getFragmentTag() {
        return this.fragmentTag;
    }

    public String getPageTag() {
        return this.pageTag;
    }

    public Object getResult() {
        return this.result;
    }

    public String getType() {
        return this.type;
    }

    public boolean isSingleChoice() {
        return this.type.equalsIgnoreCase(TYPE_SINGLE_CHOICE);
    }

    public boolean isStarRating() {
        return this.type.equalsIgnoreCase(TYPE_STAR_RATING);
    }
}
