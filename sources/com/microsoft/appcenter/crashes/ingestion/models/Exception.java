package com.microsoft.appcenter.crashes.ingestion.models;

import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.crashes.ingestion.models.json.ExceptionFactory;
import com.microsoft.appcenter.crashes.ingestion.models.json.StackFrameFactory;
import com.microsoft.appcenter.ingestion.models.Model;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Exception implements Model {
    public List<StackFrame> frames;
    public List<Exception> innerExceptions;
    public String message;
    public String minidumpFilePath;
    public String stackTrace;
    public String type;
    public String wrapperSdkName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Exception.class != obj.getClass()) {
            return false;
        }
        Exception exception = (Exception) obj;
        String str = this.type;
        if (str == null ? exception.type != null : !str.equals(exception.type)) {
            return false;
        }
        String str2 = this.message;
        if (str2 == null ? exception.message != null : !str2.equals(exception.message)) {
            return false;
        }
        String str3 = this.stackTrace;
        if (str3 == null ? exception.stackTrace != null : !str3.equals(exception.stackTrace)) {
            return false;
        }
        List<StackFrame> list = this.frames;
        if (list == null ? exception.frames != null : !list.equals(exception.frames)) {
            return false;
        }
        List<Exception> list2 = this.innerExceptions;
        if (list2 == null ? exception.innerExceptions != null : !list2.equals(exception.innerExceptions)) {
            return false;
        }
        String str4 = this.wrapperSdkName;
        if (str4 == null ? exception.wrapperSdkName != null : !str4.equals(exception.wrapperSdkName)) {
            return false;
        }
        String str5 = this.minidumpFilePath;
        String str6 = exception.minidumpFilePath;
        if (str5 != null) {
            return str5.equals(str6);
        }
        if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.stackTrace;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<StackFrame> list = this.frames;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<Exception> list2 = this.innerExceptions;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str4 = this.wrapperSdkName;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.minidumpFilePath;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode6 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        this.type = jSONObject.optString("type", (String) null);
        this.message = jSONObject.optString("message", (String) null);
        this.stackTrace = jSONObject.optString("stackTrace", (String) null);
        this.frames = zzam.readArray(jSONObject, "frames", StackFrameFactory.sInstance);
        this.innerExceptions = zzam.readArray(jSONObject, "innerExceptions", ExceptionFactory.sInstance);
        this.wrapperSdkName = jSONObject.optString("wrapperSdkName", (String) null);
        this.minidumpFilePath = jSONObject.optString("minidumpFilePath", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "type", this.type);
        zzam.write(jSONStringer, "message", this.message);
        zzam.write(jSONStringer, "stackTrace", this.stackTrace);
        zzam.writeArray(jSONStringer, "frames", this.frames);
        zzam.writeArray(jSONStringer, "innerExceptions", this.innerExceptions);
        zzam.write(jSONStringer, "wrapperSdkName", this.wrapperSdkName);
        zzam.write(jSONStringer, "minidumpFilePath", this.minidumpFilePath);
    }
}
