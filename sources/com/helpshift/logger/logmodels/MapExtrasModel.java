package com.helpshift.logger.logmodels;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MapExtrasModel implements ILogExtrasModel {
    public String key;
    public Map value;

    public MapExtrasModel(String str, Map map) {
        this.key = str;
        this.value = map;
    }

    public String getConsoleLoggingMessage() {
        if (this.value == null) {
            return this.key + " : " + this.value;
        }
        JSONObject jSONObject = new JSONObject(this.value);
        return this.key + " : " + jSONObject.toString();
    }

    public Object toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(this.key, this.value == null ? "" : this.value.toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
