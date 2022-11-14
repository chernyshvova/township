package com.swrve.sdk.messaging;

import android.graphics.Point;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveImage extends SwrveWidget {
    public String file;

    public SwrveImage(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        setPosition(SwrveWidget.getCenterFrom(jSONObject));
        setSize(SwrveWidget.getSizeFrom(jSONObject));
        if (jSONObject.has("image")) {
            setFile(jSONObject.getJSONObject("image").getString("value"));
        }
    }

    public /* bridge */ /* synthetic */ String getDynamicImageUrl() {
        return super.getDynamicImageUrl();
    }

    public String getFile() {
        return this.file;
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

    public void setFile(String str) {
        this.file = str;
    }
}
