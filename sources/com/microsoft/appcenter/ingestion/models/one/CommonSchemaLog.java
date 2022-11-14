package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class CommonSchemaLog extends AbstractLog {

    /* renamed from: cV */
    public String f3583cV;
    public Data data;
    public Extensions ext;
    public Long flags;
    public String iKey;
    public String name;
    public Double popSample;
    public String ver;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        CommonSchemaLog commonSchemaLog = (CommonSchemaLog) obj;
        String str = this.ver;
        if (str == null ? commonSchemaLog.ver != null : !str.equals(commonSchemaLog.ver)) {
            return false;
        }
        String str2 = this.name;
        if (str2 == null ? commonSchemaLog.name != null : !str2.equals(commonSchemaLog.name)) {
            return false;
        }
        Double d = this.popSample;
        if (d == null ? commonSchemaLog.popSample != null : !d.equals(commonSchemaLog.popSample)) {
            return false;
        }
        String str3 = this.iKey;
        if (str3 == null ? commonSchemaLog.iKey != null : !str3.equals(commonSchemaLog.iKey)) {
            return false;
        }
        Long l = this.flags;
        if (l == null ? commonSchemaLog.flags != null : !l.equals(commonSchemaLog.flags)) {
            return false;
        }
        String str4 = this.f3583cV;
        if (str4 == null ? commonSchemaLog.f3583cV != null : !str4.equals(commonSchemaLog.f3583cV)) {
            return false;
        }
        Extensions extensions = this.ext;
        if (extensions == null ? commonSchemaLog.ext != null : !extensions.equals(commonSchemaLog.ext)) {
            return false;
        }
        Data data2 = this.data;
        Data data3 = commonSchemaLog.data;
        if (data2 != null) {
            return data2.equals(data3);
        }
        if (data3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.ver;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d = this.popSample;
        int hashCode4 = (hashCode3 + (d != null ? d.hashCode() : 0)) * 31;
        String str3 = this.iKey;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l = this.flags;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        String str4 = this.f3583cV;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Extensions extensions = this.ext;
        int hashCode8 = (hashCode7 + (extensions != null ? extensions.hashCode() : 0)) * 31;
        Data data2 = this.data;
        if (data2 != null) {
            i = data2.hashCode();
        }
        return hashCode8 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        this.ver = jSONObject.getString("ver");
        this.name = jSONObject.getString("name");
        this.timestamp = JSONDateUtils.toDate(jSONObject.getString("time"));
        if (jSONObject.has("popSample")) {
            this.popSample = Double.valueOf(jSONObject.getDouble("popSample"));
        }
        this.iKey = jSONObject.optString("iKey", (String) null);
        this.flags = zzam.readLong(jSONObject, "flags");
        this.f3583cV = jSONObject.optString("cV", (String) null);
        if (jSONObject.has("ext")) {
            Extensions extensions = new Extensions();
            extensions.read(jSONObject.getJSONObject("ext"));
            this.ext = extensions;
        }
        if (jSONObject.has("data")) {
            Data data2 = new Data();
            data2.read(jSONObject.getJSONObject("data"));
            this.data = data2;
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        jSONStringer.key("ver").value(this.ver);
        jSONStringer.key("name").value(this.name);
        jSONStringer.key("time").value(JSONDateUtils.toString(this.timestamp));
        zzam.write(jSONStringer, "popSample", this.popSample);
        zzam.write(jSONStringer, "iKey", this.iKey);
        zzam.write(jSONStringer, "flags", this.flags);
        zzam.write(jSONStringer, "cV", this.f3583cV);
        if (this.ext != null) {
            jSONStringer.key("ext").object();
            this.ext.write(jSONStringer);
            jSONStringer.endObject();
        }
        if (this.data != null) {
            jSONStringer.key("data").object();
            this.data.write(jSONStringer);
            jSONStringer.endObject();
        }
    }
}
