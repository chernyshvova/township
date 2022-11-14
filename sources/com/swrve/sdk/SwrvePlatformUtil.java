package com.swrve.sdk;

import com.swrve.sdk.localstorage.SwrveMultiLayerLocalStorage;
import org.json.JSONException;
import org.json.JSONObject;

public interface SwrvePlatformUtil {
    void appendDeviceUpdate(JSONObject jSONObject) throws JSONException;

    void init(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str, boolean z, boolean z2);

    void saveAndSendRegistrationId(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str, String str2);
}
