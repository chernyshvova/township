package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ProtocolExtension implements Model {
    public String devMake;
    public String devModel;
    public List<String> ticketKeys;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ProtocolExtension.class != obj.getClass()) {
            return false;
        }
        ProtocolExtension protocolExtension = (ProtocolExtension) obj;
        List<String> list = this.ticketKeys;
        if (list == null ? protocolExtension.ticketKeys != null : !list.equals(protocolExtension.ticketKeys)) {
            return false;
        }
        String str = this.devMake;
        if (str == null ? protocolExtension.devMake != null : !str.equals(protocolExtension.devMake)) {
            return false;
        }
        String str2 = this.devModel;
        String str3 = protocolExtension.devModel;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        List<String> list = this.ticketKeys;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.devMake;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.devModel;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        this.ticketKeys = zzam.readStringArray(jSONObject, "ticketKeys");
        this.devMake = jSONObject.optString("devMake", (String) null);
        this.devModel = jSONObject.optString("devModel", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.writeStringArray(jSONStringer, "ticketKeys", this.ticketKeys);
        zzam.write(jSONStringer, "devMake", this.devMake);
        zzam.write(jSONStringer, "devModel", this.devModel);
    }
}
