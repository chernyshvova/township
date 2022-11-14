package com.swrve.sdk.messaging;

import android.graphics.Point;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveButton extends SwrveWidget {
    public String action;
    public SwrveActionType actionType;
    public int appId;
    public String image;
    public SwrveMessage message;
    public String name;

    public SwrveButton() {
    }

    public String getAction() {
        return this.action;
    }

    public SwrveActionType getActionType() {
        return this.actionType;
    }

    public int getAppId() {
        return this.appId;
    }

    public /* bridge */ /* synthetic */ String getDynamicImageUrl() {
        return super.getDynamicImageUrl();
    }

    public String getImage() {
        return this.image;
    }

    public SwrveMessage getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public /* bridge */ /* synthetic */ Point getPosition() {
        return super.getPosition();
    }

    public /* bridge */ /* synthetic */ Point getSize() {
        return super.getSize();
    }

    public /* bridge */ /* synthetic */ String getText() {
        return super.getText();
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setActionType(SwrveActionType swrveActionType) {
        this.actionType = swrveActionType;
    }

    public void setAppId(int i) {
        this.appId = i;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setMessage(SwrveMessage swrveMessage) {
        this.message = swrveMessage;
    }

    public void setName(String str) {
        this.name = str;
    }

    public SwrveButton(SwrveMessage swrveMessage, JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        String string;
        if (jSONObject.has("name")) {
            setName(jSONObject.getString("name"));
        }
        setPosition(SwrveWidget.getCenterFrom(jSONObject));
        setSize(SwrveWidget.getSizeFrom(jSONObject));
        if (jSONObject.has("image_up")) {
            setImage(jSONObject.getJSONObject("image_up").getString("value"));
        }
        setMessage(swrveMessage);
        if (jSONObject.has("game_id") && (string = jSONObject.getJSONObject("game_id").getString("value")) != null && !string.equals("")) {
            setAppId(Integer.parseInt(string));
        }
        setAction(jSONObject.getJSONObject("action").getString("value"));
        setActionType(SwrveActionType.parse(jSONObject.getJSONObject("type").getString("value")));
    }
}
