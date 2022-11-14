package com.microsoft.appcenter.ingestion.models.properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class BooleanTypedProperty extends TypedProperty {
    public boolean value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BooleanTypedProperty.class != obj.getClass() || !super.equals(obj) || this.value != ((BooleanTypedProperty) obj).value) {
            return false;
        }
        return true;
    }

    public String getType() {
        return "boolean";
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.value ? 1 : 0);
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.value = jSONObject.getBoolean("value");
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("value").value(this.value);
    }
}
