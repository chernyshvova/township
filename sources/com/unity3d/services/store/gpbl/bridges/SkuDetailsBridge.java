package com.unity3d.services.store.gpbl.bridges;

import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import java.util.HashMap;

public class SkuDetailsBridge extends CommonJsonResponseBridge {
    public SkuDetailsBridge(Object obj) {
        super(obj, new HashMap<String, Class[]>() {
            {
                put("getOriginalJson", new Class[0]);
            }
        });
    }

    public String getClassName() {
        return InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS;
    }
}
