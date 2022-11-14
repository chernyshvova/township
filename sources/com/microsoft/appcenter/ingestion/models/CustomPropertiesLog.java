package com.microsoft.appcenter.ingestion.models;

import com.android.billingclient.api.zzam;
import com.facebook.LegacyTokenHelper;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class CustomPropertiesLog extends AbstractLog {
    public Map<String, Object> properties;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CustomPropertiesLog.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Map<String, Object> map = this.properties;
        Map<String, Object> map2 = ((CustomPropertiesLog) obj).properties;
        if (map != null) {
            return map.equals(map2);
        }
        if (map2 == null) {
            return true;
        }
        return false;
    }

    public String getType() {
        return "customProperties";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Map<String, Object> map = this.properties;
        return hashCode + (map != null ? map.hashCode() : 0);
    }

    public void read(JSONObject jSONObject) throws JSONException {
        Object obj;
        super.read(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("properties");
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("name");
            String string2 = jSONObject2.getString("type");
            if (string2.equals("clear")) {
                obj = null;
            } else if (string2.equals("boolean")) {
                obj = Boolean.valueOf(jSONObject2.getBoolean("value"));
            } else if (string2.equals("number")) {
                obj = jSONObject2.get("value");
                if (!(obj instanceof Number)) {
                    throw new JSONException("Invalid value type");
                }
            } else if (string2.equals("dateTime")) {
                obj = JSONDateUtils.toDate(jSONObject2.getString("value"));
            } else if (string2.equals(LegacyTokenHelper.TYPE_STRING)) {
                obj = jSONObject2.getString("value");
            } else {
                throw new JSONException("Invalid value type");
            }
            hashMap.put(string, obj);
        }
        this.properties = hashMap;
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        Map<String, Object> map = this.properties;
        if (map != null) {
            jSONStringer.key("properties").array();
            for (Map.Entry next : map.entrySet()) {
                jSONStringer.object();
                zzam.write(jSONStringer, "name", next.getKey());
                Object value = next.getValue();
                if (value == null) {
                    zzam.write(jSONStringer, "type", "clear");
                } else if (value instanceof Boolean) {
                    zzam.write(jSONStringer, "type", "boolean");
                    zzam.write(jSONStringer, "value", value);
                } else if (value instanceof Number) {
                    zzam.write(jSONStringer, "type", "number");
                    zzam.write(jSONStringer, "value", value);
                } else if (value instanceof Date) {
                    zzam.write(jSONStringer, "type", "dateTime");
                    zzam.write(jSONStringer, "value", JSONDateUtils.toString((Date) value));
                } else if (value instanceof String) {
                    zzam.write(jSONStringer, "type", LegacyTokenHelper.TYPE_STRING);
                    zzam.write(jSONStringer, "value", value);
                } else {
                    throw new JSONException("Invalid value type");
                }
                jSONStringer.endObject();
            }
            jSONStringer.endArray();
            return;
        }
        throw new JSONException("Properties cannot be null");
    }
}
