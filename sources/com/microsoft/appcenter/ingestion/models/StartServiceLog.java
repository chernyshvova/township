package com.microsoft.appcenter.ingestion.models;

import com.android.billingclient.api.zzam;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class StartServiceLog extends AbstractLog {
    public List<String> services;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StartServiceLog.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        List<String> list = this.services;
        List<String> list2 = ((StartServiceLog) obj).services;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public String getType() {
        return "startService";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        List<String> list = this.services;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.services = zzam.readStringArray(jSONObject, "services");
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        zzam.writeStringArray(jSONStringer, "services", this.services);
    }
}
