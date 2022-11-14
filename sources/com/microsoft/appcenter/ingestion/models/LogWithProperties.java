package com.microsoft.appcenter.ingestion.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class LogWithProperties extends AbstractLog {
    public Map<String, String> properties;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Map<String, String> map = this.properties;
        Map<String, String> map2 = ((LogWithProperties) obj).properties;
        if (map != null) {
            return map.equals(map2);
        }
        if (map2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Map<String, String> map = this.properties;
        return hashCode + (map != null ? map.hashCode() : 0);
    }

    public void read(JSONObject jSONObject) throws JSONException {
        HashMap hashMap;
        super.read(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("properties");
        if (optJSONObject == null) {
            hashMap = null;
        } else {
            HashMap hashMap2 = new HashMap(optJSONObject.length());
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap2.put(next, optJSONObject.getString(next));
            }
            hashMap = hashMap2;
        }
        this.properties = hashMap;
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        Map<String, String> map = this.properties;
        if (map != null) {
            jSONStringer.key("properties").object();
            for (Map.Entry next : map.entrySet()) {
                jSONStringer.key((String) next.getKey()).value(next.getValue());
            }
            jSONStringer.endObject();
        }
    }
}
