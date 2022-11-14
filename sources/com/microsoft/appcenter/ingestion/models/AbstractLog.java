package com.microsoft.appcenter.ingestion.models;

import com.android.billingclient.api.zzam;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class AbstractLog implements Log {
    public Device device;
    public String distributionGroupId;
    public UUID sid;
    public Object tag;
    public Date timestamp;
    public final Set<String> transmissionTargetTokens = new LinkedHashSet();
    public String userId;

    public synchronized void addTransmissionTarget(String str) {
        this.transmissionTargetTokens.add(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractLog abstractLog = (AbstractLog) obj;
        if (!this.transmissionTargetTokens.equals(abstractLog.transmissionTargetTokens)) {
            return false;
        }
        Date date = this.timestamp;
        if (date == null ? abstractLog.timestamp != null : !date.equals(abstractLog.timestamp)) {
            return false;
        }
        UUID uuid = this.sid;
        if (uuid == null ? abstractLog.sid != null : !uuid.equals(abstractLog.sid)) {
            return false;
        }
        String str = this.distributionGroupId;
        if (str == null ? abstractLog.distributionGroupId != null : !str.equals(abstractLog.distributionGroupId)) {
            return false;
        }
        String str2 = this.userId;
        if (str2 == null ? abstractLog.userId != null : !str2.equals(abstractLog.userId)) {
            return false;
        }
        Device device2 = this.device;
        if (device2 == null ? abstractLog.device != null : !device2.equals(abstractLog.device)) {
            return false;
        }
        Object obj2 = this.tag;
        Object obj3 = abstractLog.tag;
        if (obj2 != null) {
            return obj2.equals(obj3);
        }
        if (obj3 == null) {
            return true;
        }
        return false;
    }

    public Device getDevice() {
        return this.device;
    }

    public UUID getSid() {
        return this.sid;
    }

    public Object getTag() {
        return this.tag;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public synchronized Set<String> getTransmissionTargetTokens() {
        return Collections.unmodifiableSet(this.transmissionTargetTokens);
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = this.transmissionTargetTokens.hashCode() * 31;
        Date date = this.timestamp;
        int i = 0;
        int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
        UUID uuid = this.sid;
        int hashCode3 = (hashCode2 + (uuid != null ? uuid.hashCode() : 0)) * 31;
        String str = this.distributionGroupId;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.userId;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Device device2 = this.device;
        int hashCode6 = (hashCode5 + (device2 != null ? device2.hashCode() : 0)) * 31;
        Object obj = this.tag;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode6 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getString("type").equals(getType())) {
            this.timestamp = JSONDateUtils.toDate(jSONObject.getString("timestamp"));
            if (jSONObject.has("sid")) {
                this.sid = UUID.fromString(jSONObject.getString("sid"));
            }
            this.distributionGroupId = jSONObject.optString("distributionGroupId", (String) null);
            this.userId = jSONObject.optString("userId", (String) null);
            if (jSONObject.has(DeviceRequestsHelper.DEVICE_INFO_DEVICE)) {
                Device device2 = new Device();
                device2.read(jSONObject.getJSONObject(DeviceRequestsHelper.DEVICE_INFO_DEVICE));
                this.device = device2;
                return;
            }
            return;
        }
        throw new JSONException("Invalid type");
    }

    public void setDevice(Device device2) {
        this.device = device2;
    }

    public void setSid(UUID uuid) {
        this.sid = uuid;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "type", getType());
        jSONStringer.key("timestamp").value(JSONDateUtils.toString(this.timestamp));
        zzam.write(jSONStringer, "sid", this.sid);
        zzam.write(jSONStringer, "distributionGroupId", this.distributionGroupId);
        zzam.write(jSONStringer, "userId", this.userId);
        if (this.device != null) {
            jSONStringer.key(DeviceRequestsHelper.DEVICE_INFO_DEVICE).object();
            this.device.write(jSONStringer);
            jSONStringer.endObject();
        }
    }
}
