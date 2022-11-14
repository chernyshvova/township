package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class LocExtension implements Model {

    /* renamed from: tz */
    public String f3585tz;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LocExtension.class != obj.getClass()) {
            return false;
        }
        String str = this.f3585tz;
        String str2 = ((LocExtension) obj).f3585tz;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f3585tz;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void read(JSONObject jSONObject) {
        this.f3585tz = jSONObject.optString("tz", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "tz", this.f3585tz);
    }
}
