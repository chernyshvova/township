package com.swrve.sdk;

import com.swrve.sdk.localstorage.SwrveMultiLayerLocalStorage;
import java.util.UUID;

public class SwrveLocalStorageUtil {
    public static synchronized String getDeviceId(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage) {
        synchronized (SwrveLocalStorageUtil.class) {
            String cacheEntry = swrveMultiLayerLocalStorage.getCacheEntry("", "device_id");
            if (cacheEntry != null && cacheEntry.length() > 0) {
                return cacheEntry;
            }
            String uuid = UUID.randomUUID().toString();
            swrveMultiLayerLocalStorage.setCacheEntry("", "device_id", uuid);
            return uuid;
        }
    }
}
