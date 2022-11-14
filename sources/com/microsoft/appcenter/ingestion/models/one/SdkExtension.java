package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class SdkExtension implements Model {
    public String epoch;
    public UUID installId;
    public String libVer;
    public Long seq;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SdkExtension.class != obj.getClass()) {
            return false;
        }
        SdkExtension sdkExtension = (SdkExtension) obj;
        String str = this.libVer;
        if (str == null ? sdkExtension.libVer != null : !str.equals(sdkExtension.libVer)) {
            return false;
        }
        String str2 = this.epoch;
        if (str2 == null ? sdkExtension.epoch != null : !str2.equals(sdkExtension.epoch)) {
            return false;
        }
        Long l = this.seq;
        if (l == null ? sdkExtension.seq != null : !l.equals(sdkExtension.seq)) {
            return false;
        }
        UUID uuid = this.installId;
        UUID uuid2 = sdkExtension.installId;
        if (uuid != null) {
            return uuid.equals(uuid2);
        }
        if (uuid2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.libVer;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.epoch;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.seq;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        UUID uuid = this.installId;
        if (uuid != null) {
            i = uuid.hashCode();
        }
        return hashCode3 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        this.libVer = jSONObject.optString("libVer", (String) null);
        this.epoch = jSONObject.optString("epoch", (String) null);
        this.seq = zzam.readLong(jSONObject, "seq");
        if (jSONObject.has("installId")) {
            this.installId = UUID.fromString(jSONObject.getString("installId"));
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "libVer", this.libVer);
        zzam.write(jSONStringer, "epoch", this.epoch);
        zzam.write(jSONStringer, "seq", this.seq);
        zzam.write(jSONStringer, "installId", this.installId);
    }
}
