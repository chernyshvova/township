package com.unity3d.services.core.log;

public class DeviceLogLevel {
    public static final String LOG_TAG = "UnityAds";
    public String _receivingMethodName = null;

    public DeviceLogLevel(String str) {
        this._receivingMethodName = str;
    }

    public String getLogTag() {
        return LOG_TAG;
    }

    public String getReceivingMethodName() {
        return this._receivingMethodName;
    }
}
