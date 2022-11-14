package com.swrve.sdk.messaging;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.ISwrveCampaignManager;
import com.swrve.sdk.QaCampaignInfo;
import com.swrve.sdk.SwrveAssetsQueueItem;
import com.swrve.sdk.SwrveCampaignDisplayer;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.SwrveTextTemplating;
import com.swrve.sdk.exceptions.SwrveSDKTextTemplatingException;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveInAppCampaign extends SwrveBaseCampaign {
    public SwrveMessage message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwrveInAppCampaign(ISwrveCampaignManager iSwrveCampaignManager, SwrveCampaignDisplayer swrveCampaignDisplayer, JSONObject jSONObject, Set<SwrveAssetsQueueItem> set, Map<String, String> map) throws JSONException {
        super(iSwrveCampaignManager, swrveCampaignDisplayer, jSONObject);
        JSONObject jSONObject2 = jSONObject;
        Set<SwrveAssetsQueueItem> set2 = set;
        Map<String, String> map2 = map;
        if (jSONObject2.has("message")) {
            SwrveMessage createMessage = createMessage(this, jSONObject2.getJSONObject("message"), iSwrveCampaignManager.getCacheDir());
            this.message = createMessage;
            List<SwrveMessageFormat> formats = createMessage.getFormats();
            if (formats != null && formats.size() > 0 && set2 != null) {
                for (SwrveMessageFormat next : this.message.getFormats()) {
                    for (SwrveButton next2 : next.getButtons()) {
                        if (!SwrveHelper.isNullOrEmpty(next2.getImage())) {
                            set2.add(new SwrveAssetsQueueItem(getId(), next2.getImage(), next2.getImage(), true, false));
                        }
                        if (!SwrveHelper.isNullOrEmpty(next2.getDynamicImageUrl())) {
                            try {
                                String apply = SwrveTextTemplating.apply(next2.getDynamicImageUrl(), map2);
                                set2.add(new SwrveAssetsQueueItem(getId(), SwrveHelper.sha1(apply.getBytes()), apply, true, true));
                            } catch (SwrveSDKTextTemplatingException e) {
                                SwrveLogger.m2753e("Campaign id:%s text templating could not be resolved", e, Integer.valueOf(getId()));
                            }
                        }
                    }
                    for (SwrveImage next3 : next.getImages()) {
                        if (!SwrveHelper.isNullOrEmpty(next3.getFile())) {
                            set2.add(new SwrveAssetsQueueItem(getId(), next3.getFile(), next3.getFile(), true, false));
                        }
                        if (!SwrveHelper.isNullOrEmpty(next3.getDynamicImageUrl())) {
                            try {
                                String apply2 = SwrveTextTemplating.apply(next3.getDynamicImageUrl(), map2);
                                set2.add(new SwrveAssetsQueueItem(getId(), SwrveHelper.sha1(apply2.getBytes()), apply2, true, true));
                            } catch (SwrveSDKTextTemplatingException e2) {
                                SwrveLogger.m2753e("Campaign id:%s text templating could not be resolved", e2, Integer.valueOf(getId()));
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean areAssetsReady(Set<String> set) {
        return this.message.areAssetsReady(set, (Map<String, String>) null);
    }

    public SwrveMessage createMessage(SwrveInAppCampaign swrveInAppCampaign, JSONObject jSONObject, File file) throws JSONException {
        return new SwrveMessage(swrveInAppCampaign, jSONObject, file);
    }

    public QaCampaignInfo.CAMPAIGN_TYPE getCampaignType() {
        return QaCampaignInfo.CAMPAIGN_TYPE.IAM;
    }

    public SwrveMessage getMessage() {
        return this.message;
    }

    public SwrveMessage getMessageForEvent(String str, Map<String, String> map, Date date, Map<Integer, QaCampaignInfo> map2) {
        return getMessageForEvent(str, map, date, map2, (Map<String, String>) null);
    }

    public SwrveMessage getMessageForId(int i) {
        SwrveMessage swrveMessage = this.message;
        if (swrveMessage == null) {
            SwrveLogger.m2755i("No messages in campaign %s", Integer.valueOf(this.f2795id));
            return null;
        } else if (swrveMessage.getId() == i) {
            return this.message;
        } else {
            return null;
        }
    }

    public SwrveMessage getNextMessage(Map<Integer, QaCampaignInfo> map, Map<String, String> map2) {
        SwrveMessage swrveMessage = this.message;
        if (swrveMessage != null && swrveMessage.areAssetsReady(this.campaignManager.getAssetsOnDisk(), map2)) {
            return this.message;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Campaign ");
        outline24.append(getId());
        outline24.append(" hasn't finished downloading.");
        String sb = outline24.toString();
        if (map != null) {
            map.put(Integer.valueOf(this.f2795id), new QaCampaignInfo((long) this.f2795id, (long) getVariantId(), QaCampaignInfo.CAMPAIGN_TYPE.IAM, false, sb));
        }
        SwrveLogger.m2755i(sb, new Object[0]);
        return null;
    }

    public int getVariantId() {
        SwrveMessage swrveMessage = this.message;
        if (swrveMessage != null) {
            return swrveMessage.getId();
        }
        return -1;
    }

    public void messageDismissed() {
        setMessageMinDelayThrottle();
    }

    public void messageWasShownToUser() {
        super.messageWasShownToUser();
    }

    public void setMessage(SwrveMessage swrveMessage) {
        this.message = swrveMessage;
    }

    public boolean supportsOrientation(SwrveOrientation swrveOrientation) {
        return this.message.supportsOrientation(swrveOrientation);
    }

    public boolean areAssetsReady(Set<String> set, Map<String, String> map) {
        return this.message.areAssetsReady(set, map);
    }

    public SwrveMessage getMessageForEvent(String str, Map<String, String> map, Date date, Map<Integer, QaCampaignInfo> map2, Map<String, String> map3) {
        if (!this.campaignDisplayer.shouldShowCampaign(this, str, map, date, map2, this.message == null ? 0 : 1)) {
            return null;
        }
        SwrveLogger.m2755i("%s matches a trigger in %s", str, Integer.valueOf(this.f2795id));
        return getNextMessage(map2, map3);
    }
}
