package com.swrve.sdk.messaging;

import com.swrve.sdk.ISwrveCampaignManager;
import com.swrve.sdk.QaCampaignInfo;
import com.swrve.sdk.SwrveCampaignDisplayer;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.SwrveNotificationConstants;
import com.swrve.sdk.messaging.SwrveCampaignState;
import com.swrve.sdk.messaging.model.Trigger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SwrveBaseCampaign {
    public static int DEFAULT_DELAY_FIRST_MESSAGE = 180;
    public static int DEFAULT_MAX_IMPRESSIONS = 99999;
    public static int DEFAULT_MIN_DELAY_BETWEEN_MSGS = 60;
    public SwrveCampaignDisplayer campaignDisplayer;
    public ISwrveCampaignManager campaignManager;
    public Date endDate;

    /* renamed from: id */
    public int f2795id;
    public int maxImpressions;
    public boolean messageCenter;
    public int minDelayBetweenMessage;
    public SwrveCampaignState saveableState;
    public Date showMessagesAfterLaunch;
    public Date startDate;
    public String subject;
    public List<Trigger> triggers;

    public SwrveBaseCampaign(ISwrveCampaignManager iSwrveCampaignManager, SwrveCampaignDisplayer swrveCampaignDisplayer, JSONObject jSONObject) throws JSONException {
        this.campaignManager = iSwrveCampaignManager;
        this.campaignDisplayer = swrveCampaignDisplayer;
        int i = jSONObject.getInt("id");
        this.f2795id = i;
        SwrveLogger.m2755i("Parsing campaign %s", Integer.valueOf(i));
        this.messageCenter = jSONObject.optBoolean("message_center", false);
        this.subject = jSONObject.isNull("subject") ? "" : jSONObject.getString("subject");
        this.saveableState = new SwrveCampaignState();
        this.maxImpressions = DEFAULT_MAX_IMPRESSIONS;
        this.minDelayBetweenMessage = DEFAULT_MIN_DELAY_BETWEEN_MSGS;
        this.showMessagesAfterLaunch = SwrveHelper.addTimeInterval(iSwrveCampaignManager.getInitialisedTime(), DEFAULT_DELAY_FIRST_MESSAGE, 13);
        if (jSONObject.has("triggers")) {
            this.triggers = Trigger.fromJson(jSONObject.getString("triggers"), this.f2795id);
        } else {
            this.triggers = new ArrayList();
        }
        if (jSONObject.has(SwrveNotificationConstants.RULES_KEY)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(SwrveNotificationConstants.RULES_KEY);
            if (jSONObject2.has("dismiss_after_views")) {
                this.maxImpressions = jSONObject2.getInt("dismiss_after_views");
            }
            if (jSONObject2.has("delay_first_message")) {
                this.showMessagesAfterLaunch = SwrveHelper.addTimeInterval(iSwrveCampaignManager.getInitialisedTime(), jSONObject2.getInt("delay_first_message"), 13);
            }
            if (jSONObject2.has("min_delay_between_messages")) {
                this.minDelayBetweenMessage = jSONObject2.getInt("min_delay_between_messages");
            }
        }
        if (jSONObject.has("start_date")) {
            this.startDate = new Date(jSONObject.getLong("start_date"));
        }
        if (jSONObject.has("end_date")) {
            this.endDate = new Date(jSONObject.getLong("end_date"));
        }
    }

    @Deprecated
    public abstract boolean areAssetsReady(Set<String> set);

    public abstract boolean areAssetsReady(Set<String> set, Map<String, String> map);

    public abstract QaCampaignInfo.CAMPAIGN_TYPE getCampaignType();

    public Date getEndDate() {
        return this.endDate;
    }

    public int getId() {
        return this.f2795id;
    }

    public int getImpressions() {
        return this.saveableState.impressions;
    }

    public int getMaxImpressions() {
        return this.maxImpressions;
    }

    public SwrveCampaignState getSaveableState() {
        return this.saveableState;
    }

    public Date getShowMessagesAfterLaunch() {
        return this.showMessagesAfterLaunch;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public SwrveCampaignState.Status getStatus() {
        return this.saveableState.status;
    }

    public String getSubject() {
        return this.subject;
    }

    public List<Trigger> getTriggers() {
        return this.triggers;
    }

    public void incrementImpressions() {
        this.saveableState.impressions++;
    }

    public boolean isActive(Date date) {
        return this.campaignDisplayer.isCampaignActive(this, date, (Map<Integer, QaCampaignInfo>) null);
    }

    public boolean isMessageCenter() {
        return this.messageCenter;
    }

    public void messageWasShownToUser() {
        setStatus(SwrveCampaignState.Status.Seen);
        incrementImpressions();
        setMessageMinDelayThrottle();
    }

    public void setImpressions(int i) {
        this.saveableState.impressions = i;
    }

    public void setMessageMinDelayThrottle() {
        this.saveableState.showMessagesAfterDelay = SwrveHelper.addTimeInterval(this.campaignManager.getNow(), this.minDelayBetweenMessage, 13);
        this.campaignDisplayer.setMessageMinDelayThrottle(this.campaignManager.getNow());
    }

    public void setSaveableState(SwrveCampaignState swrveCampaignState) {
        this.saveableState = swrveCampaignState;
    }

    public void setStatus(SwrveCampaignState.Status status) {
        this.saveableState.status = status;
    }

    public abstract boolean supportsOrientation(SwrveOrientation swrveOrientation);
}
