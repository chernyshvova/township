package com.swrve.sdk.messaging;

import android.graphics.Point;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SwrveWidget {
    public String dynamicImageUrl;
    public Point position;
    public Point size;
    public String text;

    public SwrveWidget() {
    }

    public static Point getCenterFrom(JSONObject jSONObject) throws JSONException {
        return new Point(jSONObject.getJSONObject("x").getInt("value"), jSONObject.getJSONObject("y").getInt("value"));
    }

    public static Point getSizeFrom(JSONObject jSONObject) throws JSONException {
        return new Point(jSONObject.getJSONObject("w").getInt("value"), jSONObject.getJSONObject("h").getInt("value"));
    }

    public String getDynamicImageUrl() {
        return this.dynamicImageUrl;
    }

    public Point getPosition() {
        return this.position;
    }

    public Point getSize() {
        return this.size;
    }

    public String getText() {
        return this.text;
    }

    public void setDynamicImageUrl(String str) {
        this.dynamicImageUrl = str;
    }

    public void setPosition(Point point) {
        this.position = point;
    }

    public void setSize(Point point) {
        this.size = point;
    }

    public void setText(String str) {
        this.text = str;
    }

    public SwrveWidget(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("dynamic_image_url")) {
            setDynamicImageUrl(jSONObject.getString("dynamic_image_url"));
        }
        if (jSONObject.has("text")) {
            setText(jSONObject.getJSONObject("text").getString("value"));
        }
    }
}
