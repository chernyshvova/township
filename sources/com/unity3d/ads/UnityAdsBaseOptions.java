package com.unity3d.ads;

import com.unity3d.services.core.log.DeviceLog;
import org.json.JSONException;
import org.json.JSONObject;

public class UnityAdsBaseOptions {
    public String OBJECT_ID = "objectId";
    public JSONObject _data = new JSONObject();

    public JSONObject getData() {
        return this._data;
    }

    public void set(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                this._data.put(str, str2);
            } catch (JSONException e) {
                DeviceLog.exception("Failed to set Unity Ads options", e);
            }
        }
    }

    public void setObjectId(String str) {
        set(this.OBJECT_ID, str);
    }
}
