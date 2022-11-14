package com.microsoft.appcenter.analytics.ingestion.models;

import com.microsoft.appcenter.ingestion.models.LogWithProperties;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class LogWithNameAndProperties extends LogWithProperties {
    public String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        String str = this.name;
        String str2 = ((LogWithNameAndProperties) obj).name;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.name;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.name = jSONObject.getString("name");
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("name").value(this.name);
    }
}
