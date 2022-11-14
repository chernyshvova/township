package com.swrve.sdk.conversations.engine.model;

import com.facebook.appevents.AppEventsConstants;
import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Content extends ConversationAtom {
    public static final String YOUTUBE_VIDEO_ID_REGEX = "^https?://.*(?:youtu.be/|v/|u/\\w/|embed/|watch\\?v=)([^#&?]*).*$";
    public String height;
    public String value;

    public Content(String str, ConversationAtom.TYPE type, ConversationStyle conversationStyle, String str2, String str3) {
        super(str, type, conversationStyle);
        this.value = str2;
        this.height = str3;
    }

    public String getHeight() {
        String str = this.height;
        return (str == null || Integer.parseInt(str) <= 0) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : this.height;
    }

    public String getValue() {
        return this.value;
    }

    public String getYoutubeVideoId() {
        Matcher matcher = Pattern.compile(YOUTUBE_VIDEO_ID_REGEX, 2).matcher(getValue());
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
