package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DateTimeTypedProperty extends TypedProperty {
    public Date value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DateTimeTypedProperty.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Date date = this.value;
        Date date2 = ((DateTimeTypedProperty) obj).value;
        if (date != null) {
            return date.equals(date2);
        }
        if (date2 == null) {
            return true;
        }
        return false;
    }

    public String getType() {
        return "dateTime";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Date date = this.value;
        return hashCode + (date != null ? date.hashCode() : 0);
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.value = JSONDateUtils.toDate(jSONObject.getString("value"));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("value").value(JSONDateUtils.toString(this.value));
    }
}
