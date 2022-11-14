package com.swrve.sdk.messaging;

import com.swrve.sdk.SwrveLogger;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveCampaignState {
    public int impressions;
    public Date showMessagesAfterDelay;
    public Status status;

    public enum Status {
        Unseen,
        Seen,
        Deleted;

        public static Status parse(String str) {
            if (str.equalsIgnoreCase("seen")) {
                return Seen;
            }
            if (str.equalsIgnoreCase("deleted")) {
                return Deleted;
            }
            return Unseen;
        }
    }

    public SwrveCampaignState() {
        this.impressions = 0;
        this.status = Status.Unseen;
    }

    public int getImpressions() {
        return this.impressions;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("impressions", this.impressions);
        jSONObject.put("status", this.status.toString());
        return jSONObject;
    }

    public SwrveCampaignState(JSONObject jSONObject) {
        this();
        try {
            if (jSONObject.has("impressions")) {
                this.impressions = jSONObject.getInt("impressions");
            }
            if (jSONObject.has("status")) {
                this.status = Status.parse(jSONObject.getString("status"));
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Error while trying to load campaign settings", e, new Object[0]);
        }
    }
}
