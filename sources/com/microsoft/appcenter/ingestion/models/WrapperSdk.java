package com.microsoft.appcenter.ingestion.models;

import com.android.billingclient.api.zzam;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class WrapperSdk implements Model {
    public String liveUpdateDeploymentKey;
    public String liveUpdatePackageHash;
    public String liveUpdateReleaseLabel;
    public String wrapperRuntimeVersion;
    public String wrapperSdkName;
    public String wrapperSdkVersion;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WrapperSdk wrapperSdk = (WrapperSdk) obj;
        String str = this.wrapperSdkVersion;
        if (str == null ? wrapperSdk.wrapperSdkVersion != null : !str.equals(wrapperSdk.wrapperSdkVersion)) {
            return false;
        }
        String str2 = this.wrapperSdkName;
        if (str2 == null ? wrapperSdk.wrapperSdkName != null : !str2.equals(wrapperSdk.wrapperSdkName)) {
            return false;
        }
        String str3 = this.wrapperRuntimeVersion;
        if (str3 == null ? wrapperSdk.wrapperRuntimeVersion != null : !str3.equals(wrapperSdk.wrapperRuntimeVersion)) {
            return false;
        }
        String str4 = this.liveUpdateReleaseLabel;
        if (str4 == null ? wrapperSdk.liveUpdateReleaseLabel != null : !str4.equals(wrapperSdk.liveUpdateReleaseLabel)) {
            return false;
        }
        String str5 = this.liveUpdateDeploymentKey;
        if (str5 == null ? wrapperSdk.liveUpdateDeploymentKey != null : !str5.equals(wrapperSdk.liveUpdateDeploymentKey)) {
            return false;
        }
        String str6 = this.liveUpdatePackageHash;
        String str7 = wrapperSdk.liveUpdatePackageHash;
        if (str6 != null) {
            return str6.equals(str7);
        }
        if (str7 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.wrapperSdkVersion;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.wrapperSdkName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.wrapperRuntimeVersion;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.liveUpdateReleaseLabel;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.liveUpdateDeploymentKey;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.liveUpdatePackageHash;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        this.wrapperSdkVersion = jSONObject.optString("wrapperSdkVersion", (String) null);
        this.wrapperSdkName = jSONObject.optString("wrapperSdkName", (String) null);
        this.wrapperRuntimeVersion = jSONObject.optString("wrapperRuntimeVersion", (String) null);
        this.liveUpdateReleaseLabel = jSONObject.optString("liveUpdateReleaseLabel", (String) null);
        this.liveUpdateDeploymentKey = jSONObject.optString("liveUpdateDeploymentKey", (String) null);
        this.liveUpdatePackageHash = jSONObject.optString("liveUpdatePackageHash", (String) null);
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        zzam.write(jSONStringer, "wrapperSdkVersion", this.wrapperSdkVersion);
        zzam.write(jSONStringer, "wrapperSdkName", this.wrapperSdkName);
        zzam.write(jSONStringer, "wrapperRuntimeVersion", this.wrapperRuntimeVersion);
        zzam.write(jSONStringer, "liveUpdateReleaseLabel", this.liveUpdateReleaseLabel);
        zzam.write(jSONStringer, "liveUpdateDeploymentKey", this.liveUpdateDeploymentKey);
        zzam.write(jSONStringer, "liveUpdatePackageHash", this.liveUpdatePackageHash);
    }
}
