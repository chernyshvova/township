package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class OsExtension implements Model {
    public String name;
    public String ver;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || OsExtension.class != obj.getClass()) {
            return false;
        }
        OsExtension osExtension = (OsExtension) obj;
        String str = this.name;
        if (str == null ? osExtension.name != null : !str.equals(osExtension.name)) {
            return false;
        }
        String str2 = this.ver;
        String str3 = osExtension.ver;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ver;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public void read(JSONObject jSONObject) {
        this.name = jSONObject.optString("name", (String) null);
        this.ver = jSONObject.optString("ver", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "name", this.name);
        zzam.write(jSONStringer, "ver", this.ver);
    }
}
