package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class NetExtension implements Model {
    public String provider;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NetExtension.class != obj.getClass()) {
            return false;
        }
        String str = this.provider;
        String str2 = ((NetExtension) obj).provider;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.provider;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void read(JSONObject jSONObject) {
        this.provider = jSONObject.optString("provider", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "provider", this.provider);
    }
}
