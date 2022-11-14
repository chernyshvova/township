package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DeviceExtension implements Model {
    public String localId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DeviceExtension.class != obj.getClass()) {
            return false;
        }
        String str = this.localId;
        String str2 = ((DeviceExtension) obj).localId;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.localId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void read(JSONObject jSONObject) {
        this.localId = jSONObject.optString("localId", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "localId", this.localId);
    }
}
