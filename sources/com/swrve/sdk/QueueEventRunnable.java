package com.swrve.sdk;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.localstorage.SwrveMultiLayerLocalStorage;
import java.util.ArrayList;
import java.util.Map;

public class QueueEventRunnable implements Runnable {
    public String eventType;
    public SwrveMultiLayerLocalStorage multiLayerLocalStorage;
    public Map<String, Object> parameters;
    public Map<String, String> payload;
    public String userId;

    public QueueEventRunnable(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str, String str2, Map<String, Object> map, Map<String, String> map2) {
        this.multiLayerLocalStorage = swrveMultiLayerLocalStorage;
        this.userId = str;
        this.eventType = str2;
        this.parameters = map;
        this.payload = map2;
    }

    public void run() {
        String str = "";
        try {
            int nextSequenceNumber = SwrveCommon.getInstance().getNextSequenceNumber();
            str = EventHelper.eventAsJSON(this.eventType, this.parameters, this.payload, nextSequenceNumber, System.currentTimeMillis());
            this.multiLayerLocalStorage.addEvent(this.userId, str);
            SwrveLogger.m2755i("Event queued of type: %s and seqNum:%s for userId:%s", this.eventType, Integer.valueOf(nextSequenceNumber), this.userId);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            QaUser.wrappedEvents(arrayList);
        } catch (Exception e) {
            SwrveLogger.m2753e(GeneratedOutlineSupport.outline16("Unable to insert QueueEvent into local storage. EventString:", str), e, new Object[0]);
        }
    }
}
