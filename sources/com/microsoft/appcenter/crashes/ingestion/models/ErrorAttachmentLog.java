package com.microsoft.appcenter.crashes.ingestion.models;

import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.android.billingclient.api.zzam;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ErrorAttachmentLog extends AbstractLog {
    @VisibleForTesting
    public static final Charset CHARSET = Charset.forName("UTF-8");
    public String contentType;
    public byte[] data;
    public UUID errorId;
    public String fileName;

    /* renamed from: id */
    public UUID f3578id;

    public static ErrorAttachmentLog attachmentWithBinary(byte[] bArr, String str, String str2) {
        ErrorAttachmentLog errorAttachmentLog = new ErrorAttachmentLog();
        errorAttachmentLog.data = bArr;
        errorAttachmentLog.fileName = str;
        errorAttachmentLog.contentType = str2;
        return errorAttachmentLog;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ErrorAttachmentLog.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        ErrorAttachmentLog errorAttachmentLog = (ErrorAttachmentLog) obj;
        UUID uuid = this.f3578id;
        if (uuid == null ? errorAttachmentLog.f3578id != null : !uuid.equals(errorAttachmentLog.f3578id)) {
            return false;
        }
        UUID uuid2 = this.errorId;
        if (uuid2 == null ? errorAttachmentLog.errorId != null : !uuid2.equals(errorAttachmentLog.errorId)) {
            return false;
        }
        String str = this.contentType;
        if (str == null ? errorAttachmentLog.contentType != null : !str.equals(errorAttachmentLog.contentType)) {
            return false;
        }
        String str2 = this.fileName;
        if (str2 == null ? errorAttachmentLog.fileName == null : str2.equals(errorAttachmentLog.fileName)) {
            return Arrays.equals(this.data, errorAttachmentLog.data);
        }
        return false;
    }

    public String getType() {
        return "errorAttachment";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        UUID uuid = this.f3578id;
        int i = 0;
        int hashCode2 = (hashCode + (uuid != null ? uuid.hashCode() : 0)) * 31;
        UUID uuid2 = this.errorId;
        int hashCode3 = (hashCode2 + (uuid2 != null ? uuid2.hashCode() : 0)) * 31;
        String str = this.contentType;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.fileName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return Arrays.hashCode(this.data) + ((hashCode4 + i) * 31);
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.f3578id = UUID.fromString(jSONObject.getString("id"));
        this.errorId = UUID.fromString(jSONObject.getString("errorId"));
        this.contentType = jSONObject.getString("contentType");
        this.fileName = jSONObject.optString("fileName", (String) null);
        try {
            this.data = Base64.decode(jSONObject.getString("data"), 0);
        } catch (IllegalArgumentException e) {
            throw new JSONException(e.getMessage());
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        zzam.write(jSONStringer, "id", this.f3578id);
        zzam.write(jSONStringer, "errorId", this.errorId);
        zzam.write(jSONStringer, "contentType", this.contentType);
        zzam.write(jSONStringer, "fileName", this.fileName);
        zzam.write(jSONStringer, "data", Base64.encodeToString(this.data, 2));
    }
}
