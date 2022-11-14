package com.unity3d.services.store.gpbl.bridges;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.reflection.GenericBridge;
import com.unity3d.services.store.gpbl.IBillingResponse;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CommonJsonResponseBridge extends GenericBridge implements IBillingResponse {
    public static final String getOriginalJsonMethodName = "getOriginalJson";
    public final Object _internalBridgeRef;

    public CommonJsonResponseBridge(Object obj, Map<String, Class[]> map) {
        super(map);
        this._internalBridgeRef = obj;
    }

    public JSONObject getOriginalJson() {
        try {
            return new JSONObject((String) callNonVoidMethod("getOriginalJson", this._internalBridgeRef, new Object[0]));
        } catch (JSONException e) {
            DeviceLog.error("Couldn't parse BillingResponse JSON : %s", e.getMessage());
            return null;
        }
    }
}
