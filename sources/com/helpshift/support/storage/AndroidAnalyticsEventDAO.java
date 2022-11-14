package com.helpshift.support.storage;

import com.helpshift.analytics.AnalyticsEventDAO;
import com.helpshift.analytics.dto.AnalyticsEventDTO;
import com.helpshift.common.platform.KVStore;
import com.helpshift.util.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidAnalyticsEventDAO implements AnalyticsEventDAO {
    public static final String KEY_UNSENT_ANALYTICS_EVENTS = "unsent_analytics_events";
    public static final String KEY_UNSENT_APP_LAUNCH_ANALYTICS_EVENTS = "unsent_app_launch_analytics_events";
    public static final int MAX_APP_LAUNCH_EVENTS_COUNT = 1000;
    public KVStore kvStore;

    public AndroidAnalyticsEventDAO(KVStore kVStore) {
        this.kvStore = kVStore;
    }

    private HashMap<String, HashMap<String, String>> getUnSentAnalyticFromDB() {
        Object serializable = this.kvStore.getSerializable(KEY_UNSENT_ANALYTICS_EVENTS);
        if (serializable == null) {
            return new HashMap<>();
        }
        return (HashMap) serializable;
    }

    public Map<String, HashMap<String, String>> getUnsentAnalytics() {
        return getUnSentAnalyticFromDB();
    }

    public List<AnalyticsEventDTO> getUnsentAnalyticsAppLaunchData() {
        Object serializable = this.kvStore.getSerializable(KEY_UNSENT_APP_LAUNCH_ANALYTICS_EVENTS);
        if (serializable == null) {
            return new ArrayList();
        }
        return (ArrayList) serializable;
    }

    public void removeAnalyticsAppLaunchData() {
        this.kvStore.setSerializable(KEY_UNSENT_APP_LAUNCH_ANALYTICS_EVENTS, (Serializable) null);
    }

    public void removeAnalyticsData(String str) {
        if (!StringUtils.isEmpty(str)) {
            HashMap<String, HashMap<String, String>> unSentAnalyticFromDB = getUnSentAnalyticFromDB();
            unSentAnalyticFromDB.remove(str);
            if (unSentAnalyticFromDB.size() == 0) {
                this.kvStore.setSerializable(KEY_UNSENT_ANALYTICS_EVENTS, (Serializable) null);
            } else {
                this.kvStore.setSerializable(KEY_UNSENT_ANALYTICS_EVENTS, unSentAnalyticFromDB);
            }
        }
    }

    public void saveUnsentAnalyticsAppLaunchData(AnalyticsEventDTO analyticsEventDTO) {
        List<AnalyticsEventDTO> unsentAnalyticsAppLaunchData = getUnsentAnalyticsAppLaunchData();
        if (unsentAnalyticsAppLaunchData.size() < 1000) {
            ArrayList arrayList = new ArrayList(unsentAnalyticsAppLaunchData);
            arrayList.add(analyticsEventDTO);
            this.kvStore.setSerializable(KEY_UNSENT_APP_LAUNCH_ANALYTICS_EVENTS, arrayList);
        }
    }

    public void saveUnsentAnalyticsData(String str, HashMap<String, String> hashMap) {
        HashMap<String, HashMap<String, String>> unSentAnalyticFromDB = getUnSentAnalyticFromDB();
        unSentAnalyticFromDB.put(str, hashMap);
        this.kvStore.setSerializable(KEY_UNSENT_ANALYTICS_EVENTS, unSentAnalyticFromDB);
    }
}
