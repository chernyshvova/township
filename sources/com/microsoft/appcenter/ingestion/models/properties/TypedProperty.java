package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class TypedProperty implements Model {
    public String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.name;
        String str2 = ((TypedProperty) obj).name;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public abstract String getType();

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getString("type").equals(getType())) {
            this.name = jSONObject.getString("name");
            return;
        }
        throw new JSONException("Invalid type");
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        jSONStringer.key("type").value(getType());
        jSONStringer.key("name").value(this.name);
    }
}
