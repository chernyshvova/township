package com.swrve.sdk.messaging;

import com.swrve.sdk.ISwrveCampaignManager;
import com.swrve.sdk.QaCampaignInfo;
import com.swrve.sdk.SwrveCampaignDisplayer;
import com.swrve.sdk.SwrveLogger;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveEmbeddedCampaign extends SwrveBaseCampaign {
    public SwrveEmbeddedMessage message;

    public SwrveEmbeddedCampaign(ISwrveCampaignManager iSwrveCampaignManager, SwrveCampaignDisplayer swrveCampaignDisplayer, JSONObject jSONObject) throws JSONException {
        super(iSwrveCampaignManager, swrveCampaignDisplayer, jSONObject);
        if (jSONObject.has("embedded_message")) {
            this.message = createMessage(this, jSONObject.getJSONObject("embedded_message"));
        }
    }

    public boolean areAssetsReady(Set<String> set) {
        return areAssetsReady(set, (Map<String, String>) null);
    }

    public SwrveEmbeddedMessage createMessage(SwrveEmbeddedCampaign swrveEmbeddedCampaign, JSONObject jSONObject) throws JSONException {
        return new SwrveEmbeddedMessage(swrveEmbeddedCampaign, jSONObject);
    }

    public QaCampaignInfo.CAMPAIGN_TYPE getCampaignType() {
        return QaCampaignInfo.CAMPAIGN_TYPE.EMBEDDED;
    }

    public SwrveEmbeddedMessage getMessage() {
        return this.message;
    }

    public SwrveEmbeddedMessage getMessageForEvent(String str, Map<String, String> map, Date date, Map<Integer, QaCampaignInfo> map2) {
        if (!this.campaignDisplayer.shouldShowCampaign(this, str, map, date, map2, 1)) {
            return null;
        }
        SwrveLogger.m2755i("%s matches a trigger in %s", str, Integer.valueOf(this.f2795id));
        return getMessage();
    }

    public boolean supportsOrientation(SwrveOrientation swrveOrientation) {
        return true;
    }

    public boolean areAssetsReady(Set<String> set, Map<String, String> map) {
        return this.message.data != null;
    }
}
