package com.swrve.sdk.conversations.engine.model.styles;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.io.Serializable;

public class ConversationColorStyle implements Serializable {
    public static final String TYPE_COLOR = "color";
    public static final String TYPE_TRANSPARENT = "transparent";
    public String type;
    public String value;

    public ConversationColorStyle() {
    }

    public Drawable getPrimaryDrawable() {
        if (isTypeColor()) {
            return new ColorDrawable(Color.parseColor(this.value));
        }
        if (!isTypeTransparent()) {
            return null;
        }
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#ffffff"));
        colorDrawable.setAlpha(0);
        return colorDrawable;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isTypeColor() {
        return TYPE_COLOR.equalsIgnoreCase(this.type);
    }

    public boolean isTypeTransparent() {
        return TYPE_TRANSPARENT.equalsIgnoreCase(this.type);
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public ConversationColorStyle(String str, String str2) {
        this.type = str;
        this.value = str2;
    }
}
