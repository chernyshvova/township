package com.unity3d.services.store.gpbl.bridges;

import com.unity3d.services.core.log.DeviceLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PurchaseBridge extends CommonJsonResponseBridge {
    public static final String getSignatureMethodName = "getSignature";
    public Object _purchase;

    public PurchaseBridge(Object obj) {
        super(obj, new HashMap<String, Class[]>() {
            {
                put("getOriginalJson", new Class[0]);
                put(PurchaseBridge.getSignatureMethodName, new Class[0]);
            }
        });
        this._purchase = obj;
    }

    public String getClassName() {
        return "com.android.billingclient.api.Purchase";
    }

    public String getSignature() {
        return (String) callNonVoidMethod(getSignatureMethodName, this._purchase, new Object[0]);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("purchaseData", getOriginalJson());
            jSONObject.put("signature", getSignature());
        } catch (JSONException e) {
            DeviceLog.warning("Could not build Purchase result Json: ", e.getMessage());
        }
        return jSONObject;
    }
}
