package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Data implements Model {
    public final JSONObject mProperties = new JSONObject();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Data.class != obj.getClass()) {
            return false;
        }
        return this.mProperties.toString().equals(((Data) obj).mProperties.toString());
    }

    public int hashCode() {
        return this.mProperties.toString().hashCode();
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONArray names = jSONObject.names();
        if (names != null) {
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                this.mProperties.put(string, jSONObject.get(string));
            }
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "baseType", this.mProperties.optString("baseType", (String) null));
        zzam.write(jSONStringer, "baseData", this.mProperties.optJSONObject("baseData"));
        JSONArray names = this.mProperties.names();
        if (names != null) {
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                if (!string.equals("baseType") && !string.equals("baseData")) {
                    jSONStringer.key(string).value(this.mProperties.get(string));
                }
            }
        }
    }
}
