package com.swrve.sdk.conversations.engine.model.styles;

import android.graphics.Color;
import android.graphics.Typeface;
import com.swrve.sdk.SwrveConversationConstants;
import com.swrve.sdk.SwrveHelper;
import java.io.Serializable;

public class ConversationStyle implements Serializable {
    public static final String DEFAULT_LB_COLOR = "#B3000000";
    public static final String TYPE_OUTLINE = "outline";
    public static final String TYPE_SOLID = "solid";
    public ALIGNMENT alignment;

    /* renamed from: bg */
    public ConversationColorStyle f2789bg;
    public int border_radius;

    /* renamed from: fg */
    public ConversationColorStyle f2790fg;
    public String font_digest;
    public String font_family;
    public String font_file;
    public FONT_NATIVE_STYLE font_native_style;
    public String font_postscript_name;

    /* renamed from: lb */
    public ConversationColorStyle f2791lb = new ConversationColorStyle(ConversationColorStyle.TYPE_COLOR, DEFAULT_LB_COLOR);
    public int text_size;
    public String type;
    public transient Typeface typeface;

    public enum ALIGNMENT {
        LEFT,
        RIGHT,
        CENTER,
        JUSTIFIED
    }

    public enum FONT_NATIVE_STYLE {
        NORMAL,
        BOLD,
        ITALIC,
        BOLDITALIC
    }

    public ConversationStyle() {
    }

    public ALIGNMENT getAlignment() {
        return this.alignment;
    }

    public ConversationColorStyle getBg() {
        return this.f2789bg;
    }

    public int getBgColorInt() {
        if (getBg().isTypeColor()) {
            return Color.parseColor(getBg().getValue());
        }
        return 0;
    }

    public int getBorderRadius() {
        return this.border_radius;
    }

    public ConversationColorStyle getFg() {
        return this.f2790fg;
    }

    public String getFontDigest() {
        return this.font_digest;
    }

    public String getFontFamily() {
        return this.font_family;
    }

    public String getFontFile() {
        return this.font_file;
    }

    public FONT_NATIVE_STYLE getFontNativeStyle() {
        return this.font_native_style;
    }

    public String getFontPostscriptName() {
        return this.font_postscript_name;
    }

    public ConversationColorStyle getLb() {
        return this.f2791lb;
    }

    public int getTextColorInt() {
        return Color.parseColor(getFg().getValue());
    }

    public int getTextSize() {
        return this.text_size;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isOutlineStyle() {
        return this.type.equalsIgnoreCase(TYPE_OUTLINE);
    }

    public boolean isSolidStyle() {
        return this.type.equalsIgnoreCase(TYPE_SOLID);
    }

    public boolean isSystemFont() {
        return SwrveHelper.isNotNullOrEmpty(this.font_file) && this.font_file.equals(SwrveConversationConstants.SYSTEM_FONT);
    }

    public void setFg(ConversationColorStyle conversationColorStyle) {
        this.f2790fg = conversationColorStyle;
    }

    public void setTextSize(int i) {
        this.text_size = i;
    }

    public void setTypeface(Typeface typeface2) {
        this.typeface = typeface2;
    }

    public ConversationStyle(int i, String str, ConversationColorStyle conversationColorStyle, ConversationColorStyle conversationColorStyle2, ConversationColorStyle conversationColorStyle3) {
        this.border_radius = i;
        this.type = str;
        this.f2789bg = conversationColorStyle;
        this.f2790fg = conversationColorStyle2;
        this.f2791lb = conversationColorStyle3;
    }

    public ConversationStyle(int i, String str, ConversationColorStyle conversationColorStyle, ConversationColorStyle conversationColorStyle2, ConversationColorStyle conversationColorStyle3, String str2, String str3, String str4, int i2, ALIGNMENT alignment2, FONT_NATIVE_STYLE font_native_style2) {
        this.border_radius = i;
        this.type = str;
        this.f2789bg = conversationColorStyle;
        this.f2790fg = conversationColorStyle2;
        this.f2791lb = conversationColorStyle3;
        this.font_file = str2;
        this.font_digest = str3;
        this.font_family = str4;
        this.text_size = i2;
        this.alignment = alignment2;
        this.font_native_style = font_native_style2;
    }
}
