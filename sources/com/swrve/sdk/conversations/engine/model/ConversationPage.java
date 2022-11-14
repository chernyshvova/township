package com.swrve.sdk.conversations.engine.model;

import android.graphics.drawable.Drawable;
import com.swrve.sdk.conversations.engine.GsonHelper;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

public class ConversationPage implements Serializable {
    public ArrayList<ConversationAtom> content;
    public ArrayList<ButtonControl> controls;
    public ConversationStyle style;
    public String tag;
    public String title;

    public static ConversationPage fromJSON(String str) {
        return (ConversationPage) GsonHelper.getConfiguredGson().fromJson(str, ConversationPage.class);
    }

    public static ConversationPage fromJson(JSONObject jSONObject) {
        return fromJSON(jSONObject.toString());
    }

    public Drawable getBackground() {
        return getStyle().getBg().getPrimaryDrawable();
    }

    public ArrayList<ConversationAtom> getContent() {
        return this.content;
    }

    public ArrayList<ButtonControl> getControls() {
        if (this.controls == null) {
            this.controls = new ArrayList<>();
        }
        return this.controls;
    }

    public ConversationStyle getStyle() {
        return this.style;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean hasTag(String str) {
        return getTag().equalsIgnoreCase(str);
    }

    public void setContent(ArrayList<ConversationAtom> arrayList) {
        this.content = arrayList;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
