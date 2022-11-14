package com.microsoft.appcenter.ingestion.models.properties;

import com.facebook.LegacyTokenHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class LongTypedProperty extends TypedProperty {
    public long value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LongTypedProperty.class != obj.getClass() || !super.equals(obj) || this.value != ((LongTypedProperty) obj).value) {
            return false;
        }
        return true;
    }

    public String getType() {
        return LegacyTokenHelper.TYPE_LONG;
    }

    public int hashCode() {
        long j = this.value;
        return (super.hashCode() * 31) + ((int) (j ^ (j >>> 32)));
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.value = jSONObject.getLong("value");
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("value").value(this.value);
    }
}
