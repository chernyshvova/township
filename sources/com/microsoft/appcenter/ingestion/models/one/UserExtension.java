package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class UserExtension implements Model {
    public String localId;
    public String locale;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UserExtension.class != obj.getClass()) {
            return false;
        }
        UserExtension userExtension = (UserExtension) obj;
        String str = this.localId;
        if (str == null ? userExtension.localId != null : !str.equals(userExtension.localId)) {
            return false;
        }
        String str2 = this.locale;
        String str3 = userExtension.locale;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.localId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.locale;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public void read(JSONObject jSONObject) {
        this.localId = jSONObject.optString("localId", (String) null);
        this.locale = jSONObject.optString("locale", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "localId", this.localId);
        zzam.write(jSONStringer, "locale", this.locale);
    }
}
