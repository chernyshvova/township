package com.microsoft.appcenter.crashes.ingestion.models;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.crashes.ingestion.models.json.ThreadFactory;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ManagedErrorLog extends AbstractErrorLog {
    public Exception exception;
    public List<Thread> threads;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ManagedErrorLog.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        ManagedErrorLog managedErrorLog = (ManagedErrorLog) obj;
        Exception exception2 = this.exception;
        if (exception2 == null ? managedErrorLog.exception != null : !exception2.equals(managedErrorLog.exception)) {
            return false;
        }
        List<Thread> list = this.threads;
        List<Thread> list2 = managedErrorLog.threads;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public String getType() {
        return "managedError";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Exception exception2 = this.exception;
        int i = 0;
        int hashCode2 = (hashCode + (exception2 != null ? exception2.hashCode() : 0)) * 31;
        List<Thread> list = this.threads;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        if (jSONObject.has("exception")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("exception");
            Exception exception2 = new Exception();
            exception2.read(jSONObject2);
            this.exception = exception2;
        }
        this.threads = zzam.readArray(jSONObject, "threads", ThreadFactory.sInstance);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        if (this.exception != null) {
            jSONStringer.key("exception").object();
            this.exception.write(jSONStringer);
            jSONStringer.endObject();
        }
        zzam.writeArray(jSONStringer, "threads", this.threads);
    }
}
