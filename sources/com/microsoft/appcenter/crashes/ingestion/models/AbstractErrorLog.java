package com.microsoft.appcenter.crashes.ingestion.models;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import java.util.Date;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class AbstractErrorLog extends AbstractLog {
    public Date appLaunchTimestamp;
    public String architecture;
    public Long errorThreadId;
    public String errorThreadName;
    public Boolean fatal;

    /* renamed from: id */
    public UUID f3577id;
    public Integer parentProcessId;
    public String parentProcessName;
    public Integer processId;
    public String processName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        AbstractErrorLog abstractErrorLog = (AbstractErrorLog) obj;
        UUID uuid = this.f3577id;
        if (uuid == null ? abstractErrorLog.f3577id != null : !uuid.equals(abstractErrorLog.f3577id)) {
            return false;
        }
        Integer num = this.processId;
        if (num == null ? abstractErrorLog.processId != null : !num.equals(abstractErrorLog.processId)) {
            return false;
        }
        String str = this.processName;
        if (str == null ? abstractErrorLog.processName != null : !str.equals(abstractErrorLog.processName)) {
            return false;
        }
        Integer num2 = this.parentProcessId;
        if (num2 == null ? abstractErrorLog.parentProcessId != null : !num2.equals(abstractErrorLog.parentProcessId)) {
            return false;
        }
        String str2 = this.parentProcessName;
        if (str2 == null ? abstractErrorLog.parentProcessName != null : !str2.equals(abstractErrorLog.parentProcessName)) {
            return false;
        }
        Long l = this.errorThreadId;
        if (l == null ? abstractErrorLog.errorThreadId != null : !l.equals(abstractErrorLog.errorThreadId)) {
            return false;
        }
        String str3 = this.errorThreadName;
        if (str3 == null ? abstractErrorLog.errorThreadName != null : !str3.equals(abstractErrorLog.errorThreadName)) {
            return false;
        }
        Boolean bool = this.fatal;
        if (bool == null ? abstractErrorLog.fatal != null : !bool.equals(abstractErrorLog.fatal)) {
            return false;
        }
        Date date = this.appLaunchTimestamp;
        if (date == null ? abstractErrorLog.appLaunchTimestamp != null : !date.equals(abstractErrorLog.appLaunchTimestamp)) {
            return false;
        }
        String str4 = this.architecture;
        String str5 = abstractErrorLog.architecture;
        if (str4 != null) {
            return str4.equals(str5);
        }
        if (str5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        UUID uuid = this.f3577id;
        int i = 0;
        int hashCode2 = (hashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        Integer num = this.processId;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.processName;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.parentProcessId;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.parentProcessName;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.errorThreadId;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.errorThreadName;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.fatal;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        Date date = this.appLaunchTimestamp;
        int hashCode10 = (hashCode9 + (date != null ? date.hashCode() : 0)) * 31;
        String str4 = this.architecture;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode10 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.f3577id = UUID.fromString(jSONObject.getString("id"));
        this.processId = zzam.readInteger(jSONObject, "processId");
        this.processName = jSONObject.optString("processName", (String) null);
        this.parentProcessId = zzam.readInteger(jSONObject, "parentProcessId");
        this.parentProcessName = jSONObject.optString("parentProcessName", (String) null);
        this.errorThreadId = zzam.readLong(jSONObject, "errorThreadId");
        this.errorThreadName = jSONObject.optString("errorThreadName", (String) null);
        this.fatal = jSONObject.has("fatal") ? Boolean.valueOf(jSONObject.getBoolean("fatal")) : null;
        this.appLaunchTimestamp = JSONDateUtils.toDate(jSONObject.getString("appLaunchTimestamp"));
        this.architecture = jSONObject.optString("architecture", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        zzam.write(jSONStringer, "id", this.f3577id);
        zzam.write(jSONStringer, "processId", this.processId);
        zzam.write(jSONStringer, "processName", this.processName);
        zzam.write(jSONStringer, "parentProcessId", this.parentProcessId);
        zzam.write(jSONStringer, "parentProcessName", this.parentProcessName);
        zzam.write(jSONStringer, "errorThreadId", this.errorThreadId);
        zzam.write(jSONStringer, "errorThreadName", this.errorThreadName);
        zzam.write(jSONStringer, "fatal", this.fatal);
        zzam.write(jSONStringer, "appLaunchTimestamp", JSONDateUtils.toString(this.appLaunchTimestamp));
        zzam.write(jSONStringer, "architecture", this.architecture);
    }
}
