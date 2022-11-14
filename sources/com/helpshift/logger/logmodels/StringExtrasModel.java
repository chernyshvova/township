package com.helpshift.logger.logmodels;

import org.json.JSONException;
import org.json.JSONObject;

public class StringExtrasModel implements ILogExtrasModel {
    public String key;
    public String value;

    public StringExtrasModel(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String getConsoleLoggingMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.key);
        sb.append(" : ");
        String str = this.value;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public Object toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(this.key, this.value == null ? "" : this.value);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
