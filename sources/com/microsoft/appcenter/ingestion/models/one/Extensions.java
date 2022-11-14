package com.microsoft.appcenter.ingestion.models.one;

import com.android.billingclient.api.zzam;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.microsoft.appcenter.ingestion.models.Model;
import com.swrve.sdk.ISwrveCommon;
import com.vungle.warren.log.LogEntry;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Extensions implements Model {
    public AppExtension app;
    public DeviceExtension device;
    public LocExtension loc;
    public MetadataExtension metadata;
    public NetExtension net;

    /* renamed from: os */
    public OsExtension f3584os;
    public ProtocolExtension protocol;
    public SdkExtension sdk;
    public UserExtension user;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Extensions.class != obj.getClass()) {
            return false;
        }
        Extensions extensions = (Extensions) obj;
        MetadataExtension metadataExtension = this.metadata;
        if (metadataExtension == null ? extensions.metadata != null : !metadataExtension.equals(extensions.metadata)) {
            return false;
        }
        ProtocolExtension protocolExtension = this.protocol;
        if (protocolExtension == null ? extensions.protocol != null : !protocolExtension.equals(extensions.protocol)) {
            return false;
        }
        UserExtension userExtension = this.user;
        if (userExtension == null ? extensions.user != null : !userExtension.equals(extensions.user)) {
            return false;
        }
        DeviceExtension deviceExtension = this.device;
        if (deviceExtension == null ? extensions.device != null : !deviceExtension.equals(extensions.device)) {
            return false;
        }
        OsExtension osExtension = this.f3584os;
        if (osExtension == null ? extensions.f3584os != null : !osExtension.equals(extensions.f3584os)) {
            return false;
        }
        AppExtension appExtension = this.app;
        if (appExtension == null ? extensions.app != null : !appExtension.equals(extensions.app)) {
            return false;
        }
        NetExtension netExtension = this.net;
        if (netExtension == null ? extensions.net != null : !netExtension.equals(extensions.net)) {
            return false;
        }
        SdkExtension sdkExtension = this.sdk;
        if (sdkExtension == null ? extensions.sdk != null : !sdkExtension.equals(extensions.sdk)) {
            return false;
        }
        LocExtension locExtension = this.loc;
        LocExtension locExtension2 = extensions.loc;
        if (locExtension != null) {
            return locExtension.equals(locExtension2);
        }
        if (locExtension2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        MetadataExtension metadataExtension = this.metadata;
        int i = 0;
        int hashCode = (metadataExtension != null ? metadataExtension.hashCode() : 0) * 31;
        ProtocolExtension protocolExtension = this.protocol;
        int hashCode2 = (hashCode + (protocolExtension != null ? protocolExtension.hashCode() : 0)) * 31;
        UserExtension userExtension = this.user;
        int hashCode3 = (hashCode2 + (userExtension != null ? userExtension.hashCode() : 0)) * 31;
        DeviceExtension deviceExtension = this.device;
        int hashCode4 = (hashCode3 + (deviceExtension != null ? deviceExtension.hashCode() : 0)) * 31;
        OsExtension osExtension = this.f3584os;
        int hashCode5 = (hashCode4 + (osExtension != null ? osExtension.hashCode() : 0)) * 31;
        AppExtension appExtension = this.app;
        int hashCode6 = (hashCode5 + (appExtension != null ? appExtension.hashCode() : 0)) * 31;
        NetExtension netExtension = this.net;
        int hashCode7 = (hashCode6 + (netExtension != null ? netExtension.hashCode() : 0)) * 31;
        SdkExtension sdkExtension = this.sdk;
        int hashCode8 = (hashCode7 + (sdkExtension != null ? sdkExtension.hashCode() : 0)) * 31;
        LocExtension locExtension = this.loc;
        if (locExtension != null) {
            i = locExtension.hashCode();
        }
        return hashCode8 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(LogEntry.LOG_METADATA)) {
            MetadataExtension metadataExtension = new MetadataExtension();
            metadataExtension.mMetadata = jSONObject.getJSONObject(LogEntry.LOG_METADATA);
            this.metadata = metadataExtension;
        }
        if (jSONObject.has("protocol")) {
            ProtocolExtension protocolExtension = new ProtocolExtension();
            protocolExtension.read(jSONObject.getJSONObject("protocol"));
            this.protocol = protocolExtension;
        }
        if (jSONObject.has(ISwrveCommon.BATCH_EVENT_KEY_USER)) {
            UserExtension userExtension = new UserExtension();
            userExtension.read(jSONObject.getJSONObject(ISwrveCommon.BATCH_EVENT_KEY_USER));
            this.user = userExtension;
        }
        if (jSONObject.has(DeviceRequestsHelper.DEVICE_INFO_DEVICE)) {
            DeviceExtension deviceExtension = new DeviceExtension();
            deviceExtension.read(jSONObject.getJSONObject(DeviceRequestsHelper.DEVICE_INFO_DEVICE));
            this.device = deviceExtension;
        }
        if (jSONObject.has("os")) {
            OsExtension osExtension = new OsExtension();
            osExtension.read(jSONObject.getJSONObject("os"));
            this.f3584os = osExtension;
        }
        if (jSONObject.has("app")) {
            AppExtension appExtension = new AppExtension();
            appExtension.read(jSONObject.getJSONObject("app"));
            this.app = appExtension;
        }
        if (jSONObject.has("net")) {
            NetExtension netExtension = new NetExtension();
            netExtension.read(jSONObject.getJSONObject("net"));
            this.net = netExtension;
        }
        if (jSONObject.has("sdk")) {
            SdkExtension sdkExtension = new SdkExtension();
            sdkExtension.read(jSONObject.getJSONObject("sdk"));
            this.sdk = sdkExtension;
        }
        if (jSONObject.has("loc")) {
            LocExtension locExtension = new LocExtension();
            locExtension.read(jSONObject.getJSONObject("loc"));
            this.loc = locExtension;
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        if (this.metadata != null) {
            jSONStringer.key(LogEntry.LOG_METADATA).object();
            this.metadata.write(jSONStringer);
            jSONStringer.endObject();
        }
        if (this.protocol != null) {
            jSONStringer.key("protocol").object();
            this.protocol.write(jSONStringer);
            jSONStringer.endObject();
        }
        if (this.user != null) {
            jSONStringer.key(ISwrveCommon.BATCH_EVENT_KEY_USER).object();
            UserExtension userExtension = this.user;
            zzam.write(jSONStringer, "localId", userExtension.localId);
            zzam.write(jSONStringer, "locale", userExtension.locale);
            jSONStringer.endObject();
        }
        if (this.device != null) {
            jSONStringer.key(DeviceRequestsHelper.DEVICE_INFO_DEVICE).object();
            zzam.write(jSONStringer, "localId", this.device.localId);
            jSONStringer.endObject();
        }
        if (this.f3584os != null) {
            jSONStringer.key("os").object();
            OsExtension osExtension = this.f3584os;
            zzam.write(jSONStringer, "name", osExtension.name);
            zzam.write(jSONStringer, "ver", osExtension.ver);
            jSONStringer.endObject();
        }
        if (this.app != null) {
            jSONStringer.key("app").object();
            this.app.write(jSONStringer);
            jSONStringer.endObject();
        }
        if (this.net != null) {
            jSONStringer.key("net").object();
            zzam.write(jSONStringer, "provider", this.net.provider);
            jSONStringer.endObject();
        }
        if (this.sdk != null) {
            jSONStringer.key("sdk").object();
            this.sdk.write(jSONStringer);
            jSONStringer.endObject();
        }
        if (this.loc != null) {
            jSONStringer.key("loc").object();
            zzam.write(jSONStringer, "tz", this.loc.f3585tz);
            jSONStringer.endObject();
        }
    }
}
