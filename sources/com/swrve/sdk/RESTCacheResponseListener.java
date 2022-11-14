package com.swrve.sdk;

import com.swrve.sdk.localstorage.SwrveMultiLayerLocalStorage;
import com.swrve.sdk.rest.IRESTResponseListener;
import com.swrve.sdk.rest.RESTResponse;
import java.util.HashMap;
import java.util.Map;

public abstract class RESTCacheResponseListener implements IRESTResponseListener {
    public String cacheCategory;
    public String defaultValue;
    public SwrveMultiLayerLocalStorage multiLayerLocalStorage;
    public SwrveBase<?, ?> swrve;
    public String userId;

    public RESTCacheResponseListener(SwrveBase<?, ?> swrveBase, SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str, String str2, String str3) {
        this.multiLayerLocalStorage = swrveMultiLayerLocalStorage;
        this.userId = str;
        this.cacheCategory = str2;
        this.defaultValue = str3;
        this.swrve = swrveBase;
    }

    public void onResponse(RESTResponse rESTResponse) {
        String str;
        if (SwrveHelper.successResponseCode(rESTResponse.responseCode)) {
            str = rESTResponse.responseBody;
            try {
                this.multiLayerLocalStorage.setAndFlushSecureSharedEntryForUser(this.userId, this.cacheCategory, str, this.swrve.getUniqueKey(this.userId));
            } catch (Exception unused) {
            }
        } else {
            try {
                str = this.multiLayerLocalStorage.getSecureCacheEntryForUser(this.userId, this.cacheCategory, this.swrve.getUniqueKey(this.userId));
            } catch (SecurityException unused2) {
                SwrveLogger.m2755i("Signature for %s invalid; could not retrieve data from cache", this.cacheCategory);
                HashMap hashMap = new HashMap();
                hashMap.put("name", "Swrve.signature_invalid");
                this.swrve.queueEvent(this.userId, "event", hashMap, (Map<String, String>) null, false);
                str = null;
            }
        }
        if (str == null || str.equals("")) {
            str = this.defaultValue;
        }
        onResponseCached(rESTResponse.responseCode, str);
    }

    public abstract void onResponseCached(int i, String str);
}
