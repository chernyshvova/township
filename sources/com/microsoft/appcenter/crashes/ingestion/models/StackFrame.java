package com.microsoft.appcenter.crashes.ingestion.models;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class StackFrame implements Model {
    public String className;
    public String fileName;
    public Integer lineNumber;
    public String methodName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StackFrame.class != obj.getClass()) {
            return false;
        }
        StackFrame stackFrame = (StackFrame) obj;
        String str = this.className;
        if (str == null ? stackFrame.className != null : !str.equals(stackFrame.className)) {
            return false;
        }
        String str2 = this.methodName;
        if (str2 == null ? stackFrame.methodName != null : !str2.equals(stackFrame.methodName)) {
            return false;
        }
        Integer num = this.lineNumber;
        if (num == null ? stackFrame.lineNumber != null : !num.equals(stackFrame.lineNumber)) {
            return false;
        }
        String str3 = this.fileName;
        String str4 = stackFrame.fileName;
        if (str3 != null) {
            return str3.equals(str4);
        }
        if (str4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.className;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.methodName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.lineNumber;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.fileName;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        this.className = jSONObject.optString("className", (String) null);
        this.methodName = jSONObject.optString("methodName", (String) null);
        this.lineNumber = zzam.readInteger(jSONObject, "lineNumber");
        this.fileName = jSONObject.optString("fileName", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "className", this.className);
        zzam.write(jSONStringer, "methodName", this.methodName);
        zzam.write(jSONStringer, "lineNumber", this.lineNumber);
        zzam.write(jSONStringer, "fileName", this.fileName);
    }
}
