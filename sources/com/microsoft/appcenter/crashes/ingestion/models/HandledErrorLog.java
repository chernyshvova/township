package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.ingestion.models.LogWithProperties;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class HandledErrorLog extends LogWithProperties {
    public Exception exception;

    /* renamed from: id */
    public UUID f3579id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HandledErrorLog.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        HandledErrorLog handledErrorLog = (HandledErrorLog) obj;
        UUID uuid = this.f3579id;
        if (uuid == null ? handledErrorLog.f3579id != null : !uuid.equals(handledErrorLog.f3579id)) {
            return false;
        }
        Exception exception2 = this.exception;
        Exception exception3 = handledErrorLog.exception;
        if (exception2 != null) {
            return exception2.equals(exception3);
        }
        if (exception3 == null) {
            return true;
        }
        return false;
    }

    public String getType() {
        return "handledError";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        UUID uuid = this.f3579id;
        int i = 0;
        int hashCode2 = (hashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        Exception exception2 = this.exception;
        if (exception2 != null) {
            i = exception2.hashCode();
        }
        return hashCode2 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.f3579id = UUID.fromString(jSONObject.getString("id"));
        if (jSONObject.has("exception")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("exception");
            Exception exception2 = new Exception();
            exception2.read(jSONObject2);
            this.exception = exception2;
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("id").value(this.f3579id);
        if (this.exception != null) {
            jSONStringer.key("exception").object();
            this.exception.write(jSONStringer);
            jSONStringer.endObject();
        }
    }
}
