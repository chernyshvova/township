package com.swrve.sdk;

import com.swrve.sdk.localstorage.LocalStorage;
import com.swrve.sdk.localstorage.SwrveMultiLayerLocalStorage;
import java.util.List;

public interface SwrveEventsManager {
    int sendStoredEvents(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage);

    int storeAndSendEvents(List<String> list, LocalStorage localStorage) throws Exception;
}
