package com.microsoft.appcenter.ingestion.models;

import com.android.billingclient.api.zzam;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Device extends WrapperSdk {
    public String appBuild;
    public String appNamespace;
    public String appVersion;
    public String carrierCountry;
    public String carrierName;
    public String locale;
    public String model;
    public String oemName;
    public Integer osApiLevel;
    public String osBuild;
    public String osName;
    public String osVersion;
    public String screenSize;
    public String sdkName;
    public String sdkVersion;
    public Integer timeZoneOffset;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Device.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Device device = (Device) obj;
        String str = this.sdkName;
        if (str == null ? device.sdkName != null : !str.equals(device.sdkName)) {
            return false;
        }
        String str2 = this.sdkVersion;
        if (str2 == null ? device.sdkVersion != null : !str2.equals(device.sdkVersion)) {
            return false;
        }
        String str3 = this.model;
        if (str3 == null ? device.model != null : !str3.equals(device.model)) {
            return false;
        }
        String str4 = this.oemName;
        if (str4 == null ? device.oemName != null : !str4.equals(device.oemName)) {
            return false;
        }
        String str5 = this.osName;
        if (str5 == null ? device.osName != null : !str5.equals(device.osName)) {
            return false;
        }
        String str6 = this.osVersion;
        if (str6 == null ? device.osVersion != null : !str6.equals(device.osVersion)) {
            return false;
        }
        String str7 = this.osBuild;
        if (str7 == null ? device.osBuild != null : !str7.equals(device.osBuild)) {
            return false;
        }
        Integer num = this.osApiLevel;
        if (num == null ? device.osApiLevel != null : !num.equals(device.osApiLevel)) {
            return false;
        }
        String str8 = this.locale;
        if (str8 == null ? device.locale != null : !str8.equals(device.locale)) {
            return false;
        }
        Integer num2 = this.timeZoneOffset;
        if (num2 == null ? device.timeZoneOffset != null : !num2.equals(device.timeZoneOffset)) {
            return false;
        }
        String str9 = this.screenSize;
        if (str9 == null ? device.screenSize != null : !str9.equals(device.screenSize)) {
            return false;
        }
        String str10 = this.appVersion;
        if (str10 == null ? device.appVersion != null : !str10.equals(device.appVersion)) {
            return false;
        }
        String str11 = this.carrierName;
        if (str11 == null ? device.carrierName != null : !str11.equals(device.carrierName)) {
            return false;
        }
        String str12 = this.carrierCountry;
        if (str12 == null ? device.carrierCountry != null : !str12.equals(device.carrierCountry)) {
            return false;
        }
        String str13 = this.appBuild;
        if (str13 == null ? device.appBuild != null : !str13.equals(device.appBuild)) {
            return false;
        }
        String str14 = this.appNamespace;
        String str15 = device.appNamespace;
        if (str14 != null) {
            return str14.equals(str15);
        }
        if (str15 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.sdkName;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.sdkVersion;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.model;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.oemName;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.osName;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.osVersion;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.osBuild;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Integer num = this.osApiLevel;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 31;
        String str8 = this.locale;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num2 = this.timeZoneOffset;
        int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str9 = this.screenSize;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.appVersion;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.carrierName;
        int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.carrierCountry;
        int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.appBuild;
        int hashCode16 = (hashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.appNamespace;
        if (str14 != null) {
            i = str14.hashCode();
        }
        return hashCode16 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        this.sdkName = jSONObject.getString("sdkName");
        this.sdkVersion = jSONObject.getString("sdkVersion");
        this.model = jSONObject.getString(DeviceRequestsHelper.DEVICE_INFO_MODEL);
        this.oemName = jSONObject.getString("oemName");
        this.osName = jSONObject.getString("osName");
        this.osVersion = jSONObject.getString("osVersion");
        this.osBuild = jSONObject.optString("osBuild", (String) null);
        this.osApiLevel = zzam.readInteger(jSONObject, "osApiLevel");
        this.locale = jSONObject.getString("locale");
        this.timeZoneOffset = Integer.valueOf(jSONObject.getInt("timeZoneOffset"));
        this.screenSize = jSONObject.getString("screenSize");
        this.appVersion = jSONObject.getString("appVersion");
        this.carrierName = jSONObject.optString("carrierName", (String) null);
        this.carrierCountry = jSONObject.optString("carrierCountry", (String) null);
        this.appBuild = jSONObject.getString("appBuild");
        this.appNamespace = jSONObject.optString("appNamespace", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("sdkName").value(this.sdkName);
        jSONStringer.key("sdkVersion").value(this.sdkVersion);
        jSONStringer.key(DeviceRequestsHelper.DEVICE_INFO_MODEL).value(this.model);
        jSONStringer.key("oemName").value(this.oemName);
        jSONStringer.key("osName").value(this.osName);
        jSONStringer.key("osVersion").value(this.osVersion);
        zzam.write(jSONStringer, "osBuild", this.osBuild);
        zzam.write(jSONStringer, "osApiLevel", this.osApiLevel);
        jSONStringer.key("locale").value(this.locale);
        jSONStringer.key("timeZoneOffset").value(this.timeZoneOffset);
        jSONStringer.key("screenSize").value(this.screenSize);
        jSONStringer.key("appVersion").value(this.appVersion);
        zzam.write(jSONStringer, "carrierName", this.carrierName);
        zzam.write(jSONStringer, "carrierCountry", this.carrierCountry);
        jSONStringer.key("appBuild").value(this.appBuild);
        zzam.write(jSONStringer, "appNamespace", this.appNamespace);
    }
}
