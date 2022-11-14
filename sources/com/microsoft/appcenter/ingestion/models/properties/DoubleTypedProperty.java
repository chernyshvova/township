package com.microsoft.appcenter.ingestion.models.properties;

import com.facebook.LegacyTokenHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DoubleTypedProperty extends TypedProperty {
    public double value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DoubleTypedProperty.class != obj.getClass() || !super.equals(obj) || Double.compare(((DoubleTypedProperty) obj).value, this.value) != 0) {
            return false;
        }
        return true;
    }

    public String getType() {
        return LegacyTokenHelper.TYPE_DOUBLE;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.value);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.value = jSONObject.getDouble("value");
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("value").value(this.value);
    }
}
