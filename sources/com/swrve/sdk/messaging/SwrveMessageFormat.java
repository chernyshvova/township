package com.swrve.sdk.messaging;

import android.graphics.Color;
import android.graphics.Point;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.conversations.engine.model.styles.ConversationColorStyle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveMessageFormat {
    public Integer backgroundColor;
    public List<SwrveButton> buttons = new ArrayList();
    public List<SwrveImage> images = new ArrayList();
    public String language;
    public SwrveMessage message;
    public String name;
    public SwrveOrientation orientation;
    public float scale = 1.0f;
    public Point size;

    public SwrveMessageFormat(SwrveMessage swrveMessage, JSONObject jSONObject) throws JSONException {
        this.message = swrveMessage;
        setName(jSONObject.getString("name"));
        setLanguage(jSONObject.getString("language"));
        if (jSONObject.has("orientation")) {
            setOrientation(SwrveOrientation.parse(jSONObject.getString("orientation")));
        }
        if (jSONObject.has("scale")) {
            setScale(Float.parseFloat(jSONObject.getString("scale")));
        }
        if (jSONObject.has(ConversationColorStyle.TYPE_COLOR)) {
            String string = jSONObject.getString(ConversationColorStyle.TYPE_COLOR);
            if (!SwrveHelper.isNullOrEmpty(string)) {
                setBackgroundColor(Integer.valueOf(Color.parseColor("#" + string)));
            }
        }
        setSize(getSizeFrom(jSONObject.getJSONObject("size")));
        SwrveLogger.m2755i("Format name:%s size.x:%s size.y:%s scale:%s", getName(), Integer.valueOf(this.size.x), Integer.valueOf(this.size.y), Float.valueOf(this.scale));
        JSONArray jSONArray = jSONObject.getJSONArray("buttons");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            getButtons().add(new SwrveButton(swrveMessage, jSONArray.getJSONObject(i)));
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("images");
        int length2 = jSONArray2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            getImages().add(new SwrveImage(jSONArray2.getJSONObject(i2)));
        }
    }

    public static Point getSizeFrom(JSONObject jSONObject) throws JSONException {
        return new Point(jSONObject.getJSONObject("w").getInt("value"), jSONObject.getJSONObject("h").getInt("value"));
    }

    public Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public List<SwrveButton> getButtons() {
        return this.buttons;
    }

    public List<SwrveImage> getImages() {
        return this.images;
    }

    public String getLanguage() {
        return this.language;
    }

    public SwrveMessage getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public SwrveOrientation getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }

    public Point getSize() {
        return this.size;
    }

    public void setBackgroundColor(Integer num) {
        this.backgroundColor = num;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOrientation(SwrveOrientation swrveOrientation) {
        this.orientation = swrveOrientation;
    }

    public void setScale(float f) {
        this.scale = f;
    }

    public void setSize(Point point) {
        this.size = point;
    }
}
