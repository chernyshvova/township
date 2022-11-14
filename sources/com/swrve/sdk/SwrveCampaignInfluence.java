package com.swrve.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.helpshift.conversation.domainmodel.ConversationController;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveCampaignInfluence {
    public static final String INFLUENCED_PREFS = "swrve.influenced_data_v2";

    public Date getNow() {
        return new Date();
    }

    public List<InfluenceData> getSavedInfluencedData(SharedPreferences sharedPreferences) {
        Set<String> keySet = sharedPreferences.getAll().keySet();
        ArrayList arrayList = new ArrayList();
        for (String string : keySet) {
            String string2 = sharedPreferences.getString(string, (String) null);
            if (SwrveHelper.isNotNullOrEmpty(string2)) {
                InfluenceData influenceData = new InfluenceData(string2);
                if (influenceData.maxInfluencedMillis > 0) {
                    arrayList.add(influenceData);
                }
            }
        }
        return arrayList;
    }

    public void processInfluenceData(Context context, ISwrveCommon iSwrveCommon) {
        Context context2 = context;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(INFLUENCED_PREFS, 0);
        List<InfluenceData> savedInfluencedData = getSavedInfluencedData(sharedPreferences);
        if (!savedInfluencedData.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            long time = getNow().getTime();
            for (InfluenceData next : savedInfluencedData) {
                try {
                    long j = next.maxInfluencedMillis - time;
                    if (j >= 0 && next.maxInfluencedMillis > 0) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("id", Long.valueOf(next.getIntTrackingId()));
                        hashMap.put(ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_KEY, ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_PUSH);
                        hashMap.put(ISwrveCommon.GENERIC_EVENT_ACTION_TYPE_KEY, ISwrveCommon.GENERIC_EVENT_ACTION_TYPE_INFLUENCED);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("delta", String.valueOf(j / ConversationController.ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT));
                        hashMap2.put("silent", String.valueOf(next.silent));
                        arrayList.add(EventHelper.eventAsJSON(ISwrveCommon.EVENT_TYPE_GENERIC_CAMPAIGN, hashMap, hashMap2, iSwrveCommon.getNextSequenceNumber(), System.currentTimeMillis()));
                    }
                } catch (JSONException e) {
                    SwrveLogger.m2753e("Could not obtain push influenced data:", e, new Object[0]);
                }
            }
            if (!arrayList.isEmpty()) {
                iSwrveCommon.sendEventsInBackground(context2, iSwrveCommon.getUserId(), arrayList);
            }
            sharedPreferences.edit().clear().commit();
        }
    }

    public void removeInfluenceCampaign(Context context, String str) {
        context.getSharedPreferences(INFLUENCED_PREFS, 0).edit().remove(str).commit();
    }

    public void saveInfluencedCampaign(Context context, String str, Bundle bundle, Date date) {
        if (bundle == null || !bundle.containsKey(SwrveNotificationInternalPayloadConstants.SWRVE_INFLUENCED_WINDOW_MINS_KEY)) {
            SwrveLogger.m2752d("Cannot save influence data because there's no influenced window set.", new Object[0]);
        } else if (SwrveHelper.isNullOrEmpty(str)) {
            SwrveLogger.m2752d("Cannot save influence data because cannot no tracking id.", new Object[0]);
        } else {
            int parseInt = Integer.parseInt(bundle.getString(SwrveNotificationInternalPayloadConstants.SWRVE_INFLUENCED_WINDOW_MINS_KEY));
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.add(12, parseInt);
            Date time = instance.getTime();
            String str2 = str;
            InfluenceData influenceData = new InfluenceData(str2, time.getTime(), bundle.containsKey(SwrveNotificationConstants.SWRVE_SILENT_TRACKING_KEY));
            SharedPreferences sharedPreferences = context.getSharedPreferences(INFLUENCED_PREFS, 0);
            List<InfluenceData> savedInfluencedData = getSavedInfluencedData(sharedPreferences);
            savedInfluencedData.add(influenceData);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (InfluenceData next : savedInfluencedData) {
                edit.putString(next.trackingId, next.toJson().toString());
            }
            edit.commit();
        }
    }

    public class InfluenceData {
        public long maxInfluencedMillis;
        public boolean silent;
        public String trackingId;

        public InfluenceData(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.trackingId = jSONObject.getString("trackingId");
                this.maxInfluencedMillis = jSONObject.getLong("maxInfluencedMillis");
                this.silent = jSONObject.getBoolean("silent");
            } catch (JSONException e) {
                SwrveLogger.m2753e("Could not serialize influence data:", e, new Object[0]);
            }
        }

        public long getIntTrackingId() {
            return Long.parseLong(this.trackingId);
        }

        public JSONObject toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("trackingId", this.trackingId);
                jSONObject.put("maxInfluencedMillis", this.maxInfluencedMillis);
                jSONObject.put("silent", this.silent);
                return jSONObject;
            } catch (Exception e) {
                SwrveLogger.m2753e("Could not serialize influence data:", e, new Object[0]);
                return null;
            }
        }

        public InfluenceData(String str, long j, boolean z) {
            this.trackingId = str;
            this.maxInfluencedMillis = j;
            this.silent = z;
        }
    }
}
