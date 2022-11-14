package com.microsoft.appcenter.analytics.ingestion.models;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.LegacyTokenHelper;
import com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class EventLog extends LogWithNameAndProperties {

    /* renamed from: id */
    public UUID f3576id;
    public List<TypedProperty> typedProperties;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventLog.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        EventLog eventLog = (EventLog) obj;
        UUID uuid = this.f3576id;
        if (uuid == null ? eventLog.f3576id != null : !uuid.equals(eventLog.f3576id)) {
            return false;
        }
        List<TypedProperty> list = this.typedProperties;
        List<TypedProperty> list2 = eventLog.typedProperties;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public String getType() {
        return "event";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        UUID uuid = this.f3576id;
        int i = 0;
        int hashCode2 = (hashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        List<TypedProperty> list = this.typedProperties;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList;
        TypedProperty typedProperty;
        super.read(jSONObject);
        this.f3576id = UUID.fromString(jSONObject.getString("id"));
        JSONArray optJSONArray = jSONObject.optJSONArray("typedProperties");
        if (optJSONArray != null) {
            arrayList = new ArrayList(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                String string = jSONObject2.getString("type");
                if ("boolean".equals(string)) {
                    typedProperty = new BooleanTypedProperty();
                } else if ("dateTime".equals(string)) {
                    typedProperty = new DateTimeTypedProperty();
                } else if (LegacyTokenHelper.TYPE_DOUBLE.equals(string)) {
                    typedProperty = new DoubleTypedProperty();
                } else if (LegacyTokenHelper.TYPE_LONG.equals(string)) {
                    typedProperty = new LongTypedProperty();
                } else if (LegacyTokenHelper.TYPE_STRING.equals(string)) {
                    typedProperty = new StringTypedProperty();
                } else {
                    throw new JSONException(GeneratedOutlineSupport.outline16("Unsupported type: ", string));
                }
                typedProperty.read(jSONObject2);
                arrayList.add(typedProperty);
            }
        } else {
            arrayList = null;
        }
        this.typedProperties = arrayList;
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("id").value(this.f3576id);
        zzam.writeArray(jSONStringer, "typedProperties", this.typedProperties);
    }
}
