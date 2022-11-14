package com.swrve.sdk;

import com.applovin.sdk.AppLovinEventParameters;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveIAPRewards {
    public Map<String, Map<String, Object>> rewards = new HashMap();

    public SwrveIAPRewards() {
    }

    public void _addCurrency(String str, long j) {
        addObject(str, j, "currency");
    }

    public void _addItem(String str, long j) {
        addObject(str, j, "item");
    }

    public JSONObject _getRewardsJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.rewards.entrySet()) {
            jSONObject.put((String) next.getKey(), new JSONObject((Map) next.getValue()));
        }
        return jSONObject;
    }

    public void addCurrency(String str, long j) {
        try {
            _addCurrency(str, j);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void addItem(String str, long j) {
        try {
            _addItem(str, j);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void addObject(String str, long j, String str2) {
        if (checkParameters(str, j, str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(AppLovinEventParameters.REVENUE_AMOUNT, Long.valueOf(j));
            hashMap.put("type", str2);
            this.rewards.put(str, hashMap);
        }
    }

    public boolean checkParameters(String str, long j, String str2) throws IllegalArgumentException {
        if (SwrveHelper.isNullOrEmpty(str2)) {
            SwrveLogger.m2754e("SwrveIAPRewards illegal argument: type cannot be empty", new Object[0]);
            return false;
        } else if (SwrveHelper.isNullOrEmpty(str)) {
            SwrveLogger.m2754e("SwrveIAPRewards illegal argument: reward name cannot be empty", new Object[0]);
            return false;
        } else if (j > 0) {
            return true;
        } else {
            SwrveLogger.m2754e("SwrveIAPRewards illegal argument: reward amount must be greater than zero", new Object[0]);
            return false;
        }
    }

    public JSONObject getRewardsJSON() {
        try {
            return _getRewardsJSON();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public SwrveIAPRewards(String str, long j) {
        addCurrency(str, j);
    }
}
