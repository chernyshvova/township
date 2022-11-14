package com.swrve.sdk;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.QaCampaignInfo;
import com.swrve.sdk.messaging.SwrveBaseCampaign;
import com.swrve.sdk.messaging.SwrveConversationCampaign;
import com.swrve.sdk.messaging.SwrveInAppCampaign;
import com.swrve.sdk.messaging.model.Arg;
import com.swrve.sdk.messaging.model.Conditions;
import com.swrve.sdk.messaging.model.Trigger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class SwrveCampaignDisplayer {
    public long messagesLeftToShow;
    public int minDelayBetweenMessage;
    public Date showMessagesAfterDelay;
    public Date showMessagesAfterLaunch;
    public final SimpleDateFormat timestampFormat = new SimpleDateFormat("HH:mm:ss ZZZZ", Locale.US);

    private boolean hasShowTooManyMessagesAlready() {
        return this.messagesLeftToShow <= 0;
    }

    private boolean isTooSoonToShowMessageAfterDelay(SwrveBaseCampaign swrveBaseCampaign, Date date) {
        Date date2 = swrveBaseCampaign.getSaveableState().showMessagesAfterDelay;
        return date2 != null && date.before(date2);
    }

    private boolean isTooSoonToShowMessageAfterLaunch(SwrveBaseCampaign swrveBaseCampaign, Date date) {
        return date.before(swrveBaseCampaign.getShowMessagesAfterLaunch());
    }

    private void logAndAddReason(SwrveBaseCampaign swrveBaseCampaign, String str, boolean z, Map<Integer, QaCampaignInfo> map) {
        if (QaUser.isLoggingEnabled()) {
            if (swrveBaseCampaign instanceof SwrveConversationCampaign) {
                map.put(Integer.valueOf(swrveBaseCampaign.getId()), new QaCampaignInfo((long) swrveBaseCampaign.getId(), (long) ((SwrveConversationCampaign) swrveBaseCampaign).getConversation().getId(), QaCampaignInfo.CAMPAIGN_TYPE.CONVERSATION, z, str));
            } else if (swrveBaseCampaign instanceof SwrveInAppCampaign) {
                map.put(Integer.valueOf(swrveBaseCampaign.getId()), new QaCampaignInfo((long) swrveBaseCampaign.getId(), (long) ((SwrveInAppCampaign) swrveBaseCampaign).getVariantId(), QaCampaignInfo.CAMPAIGN_TYPE.IAM, z, str));
            }
        }
        SwrveLogger.m2755i(str, new Object[0]);
    }

    private void noMessagesWereShown(String str, Map<String, String> map, String str2) {
        SwrveLogger.m2755i("Not showing message for %s: %s", str, str2);
        QaUser.campaignsAppRuleTriggered(str, map, str2);
    }

    public boolean canTrigger(SwrveBaseCampaign swrveBaseCampaign, String str, Map<String, String> map, Map<Integer, QaCampaignInfo> map2) {
        Iterator<Trigger> it;
        SwrveBaseCampaign swrveBaseCampaign2 = swrveBaseCampaign;
        String str2 = str;
        Map<String, String> map3 = map;
        Map<Integer, QaCampaignInfo> map4 = map2;
        if (swrveBaseCampaign.getTriggers() == null || swrveBaseCampaign.getTriggers().size() == 0) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Campaign [");
            outline24.append(swrveBaseCampaign.getId());
            outline24.append("], no triggers (could be message centre). Skipping this campaign.");
            logAndAddReason(swrveBaseCampaign2, outline24.toString(), false, map4);
            return false;
        }
        Iterator<Trigger> it2 = swrveBaseCampaign.getTriggers().iterator();
        while (it2.hasNext()) {
            Trigger next = it2.next();
            if (str2 == null || !str2.equalsIgnoreCase(next.getEventName())) {
                it = it2;
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Campaign [");
                outline242.append(swrveBaseCampaign.getId());
                outline242.append("], Trigger [");
                outline242.append(next);
                outline242.append("], does not match eventName[");
                outline242.append(str2);
                outline242.append("] & payload[");
                outline242.append(map3);
                outline242.append("]. Skipping this trigger.");
                logAndAddReason(swrveBaseCampaign2, outline242.toString(), false, map4);
            } else {
                Conditions conditions = next.getConditions();
                it = it2;
                if (conditions.getOp() == null && conditions.getArgs() == null) {
                    StringBuilder outline243 = GeneratedOutlineSupport.outline24("Campaign [");
                    outline243.append(swrveBaseCampaign.getId());
                    outline243.append("], Trigger [");
                    outline243.append(next);
                    outline243.append("], matches eventName[");
                    outline243.append(str2);
                    outline243.append("] & payload[");
                    outline243.append(map3);
                    outline243.append("].");
                    logAndAddReason(swrveBaseCampaign2, outline243.toString(), true, map4);
                    return true;
                } else if (Conditions.C1708Op.AND.equals(conditions.getOp())) {
                    Iterator<Arg> it3 = conditions.getArgs().iterator();
                    boolean z = false;
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Arg next2 = it3.next();
                        if (map3 == null || !map3.containsKey(next2.getKey()) || !map3.get(next2.getKey()).equalsIgnoreCase(next2.getValue())) {
                            StringBuilder outline244 = GeneratedOutlineSupport.outline24("Campaign [");
                            outline244.append(swrveBaseCampaign.getId());
                            outline244.append("], Trigger [");
                            outline244.append(next);
                            outline244.append("], does not match eventName[");
                            outline244.append(str2);
                            outline244.append("] & payload[");
                            outline244.append(map3);
                            outline244.append("]. Skipping this trigger.");
                            logAndAddReason(swrveBaseCampaign2, outline244.toString(), false, map4);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (z) {
                        StringBuilder outline245 = GeneratedOutlineSupport.outline24("Campaign [");
                        outline245.append(swrveBaseCampaign.getId());
                        outline245.append("], Trigger [");
                        outline245.append(next);
                        outline245.append("], matches eventName[");
                        outline245.append(str2);
                        outline245.append("] & payload[");
                        outline245.append(map3);
                        outline245.append("].");
                        logAndAddReason(swrveBaseCampaign2, outline245.toString(), true, map4);
                        return true;
                    }
                } else if (!Conditions.C1708Op.EQ.equals(conditions.getOp())) {
                    continue;
                } else if (map3 == null || !map3.containsKey(conditions.getKey()) || !map3.get(conditions.getKey()).equalsIgnoreCase(conditions.getValue())) {
                    StringBuilder outline246 = GeneratedOutlineSupport.outline24("Campaign [");
                    outline246.append(swrveBaseCampaign.getId());
                    outline246.append("], Trigger [");
                    outline246.append(next);
                    outline246.append("], does not match eventName[");
                    outline246.append(str2);
                    outline246.append("] & payload[");
                    outline246.append(map3);
                    outline246.append("]. Skipping this trigger.");
                    logAndAddReason(swrveBaseCampaign2, outline246.toString(), false, map4);
                } else {
                    StringBuilder outline247 = GeneratedOutlineSupport.outline24("Campaign [");
                    outline247.append(swrveBaseCampaign.getId());
                    outline247.append("], Trigger [");
                    outline247.append(next);
                    outline247.append("], matches eventName[");
                    outline247.append(str2);
                    outline247.append("] & payload[");
                    outline247.append(map3);
                    outline247.append("].");
                    logAndAddReason(swrveBaseCampaign2, outline247.toString(), true, map4);
                    return true;
                }
            }
            it2 = it;
        }
        return false;
    }

    public boolean checkAppCampaignRules(int i, String str, String str2, Map<String, String> map, Date date) {
        if (i == 0) {
            noMessagesWereShown(str2, map, GeneratedOutlineSupport.outline17("No ", str, "s available"));
            return false;
        } else if (!str2.equalsIgnoreCase(SwrveImp.SWRVE_AUTOSHOW_AT_SESSION_START_TRIGGER) && isTooSoonToShowMessageAfterLaunch(date)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("{App throttle limit} Too soon after launch. Wait until ");
            outline24.append(this.timestampFormat.format(this.showMessagesAfterLaunch));
            noMessagesWereShown(str2, map, outline24.toString());
            return false;
        } else if (isTooSoonToShowMessageAfterDelay(date)) {
            StringBuilder outline27 = GeneratedOutlineSupport.outline27("{App throttle limit} Too soon after last ", str, ". Wait until ");
            outline27.append(this.timestampFormat.format(this.showMessagesAfterDelay));
            noMessagesWereShown(str2, map, outline27.toString());
            return false;
        } else if (!hasShowTooManyMessagesAlready()) {
            return true;
        } else {
            noMessagesWereShown(str2, map, GeneratedOutlineSupport.outline17("{App Throttle limit} Too many ", str, "s shown"));
            return false;
        }
    }

    public void decrementMessagesLeftToShow() {
        this.messagesLeftToShow--;
    }

    public boolean isCampaignActive(SwrveBaseCampaign swrveBaseCampaign, Date date, Map<Integer, QaCampaignInfo> map) {
        if (swrveBaseCampaign.getStartDate().after(date)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Campaign ");
            outline24.append(swrveBaseCampaign.getId());
            outline24.append(" has not started yet");
            logAndAddReason(swrveBaseCampaign, outline24.toString(), false, map);
            return false;
        } else if (!swrveBaseCampaign.getEndDate().before(date)) {
            return true;
        } else {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Campaign ");
            outline242.append(swrveBaseCampaign.getId());
            outline242.append(" has finished");
            logAndAddReason(swrveBaseCampaign, outline242.toString(), false, map);
            return false;
        }
    }

    public void setMessageMinDelayThrottle(Date date) {
        this.showMessagesAfterDelay = SwrveHelper.addTimeInterval(date, this.minDelayBetweenMessage, 13);
    }

    public void setMessagesLeftToShow(long j) {
        this.messagesLeftToShow = j;
    }

    public void setMinDelayBetweenMessage(int i) {
        this.minDelayBetweenMessage = i;
    }

    public void setShowMessagesAfterLaunch(Date date) {
        this.showMessagesAfterLaunch = date;
    }

    public boolean shouldShowCampaign(SwrveBaseCampaign swrveBaseCampaign, String str, Map<String, String> map, Date date, Map<Integer, QaCampaignInfo> map2, int i) {
        if (!canTrigger(swrveBaseCampaign, str, map, map2)) {
            return false;
        }
        if (i == 0) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("No campaign variants for campaign id:");
            outline24.append(swrveBaseCampaign.getId());
            logAndAddReason(swrveBaseCampaign, outline24.toString(), false, map2);
            return false;
        } else if (!isCampaignActive(swrveBaseCampaign, date, map2)) {
            return false;
        } else {
            if (swrveBaseCampaign.getSaveableState().getImpressions() >= swrveBaseCampaign.getMaxImpressions()) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("{Campaign throttle limit} Campaign ");
                outline242.append(swrveBaseCampaign.getId());
                outline242.append(" has been shown ");
                outline242.append(swrveBaseCampaign.getMaxImpressions());
                outline242.append(" times already");
                logAndAddReason(swrveBaseCampaign, outline242.toString(), false, map2);
                return false;
            } else if (!str.equalsIgnoreCase(SwrveImp.SWRVE_AUTOSHOW_AT_SESSION_START_TRIGGER) && isTooSoonToShowMessageAfterLaunch(swrveBaseCampaign, date)) {
                logAndAddReason(swrveBaseCampaign, GeneratedOutlineSupport.outline16("{Campaign throttle limit} Too soon after launch. Wait until ", this.timestampFormat.format(swrveBaseCampaign.getShowMessagesAfterLaunch())), false, map2);
                return false;
            } else if (!isTooSoonToShowMessageAfterDelay(swrveBaseCampaign, date)) {
                return true;
            } else {
                logAndAddReason(swrveBaseCampaign, GeneratedOutlineSupport.outline16("{Campaign throttle limit} Too soon after last campaign. Wait until ", this.timestampFormat.format(swrveBaseCampaign.getSaveableState().showMessagesAfterDelay)), false, map2);
                return false;
            }
        }
    }

    private boolean isTooSoonToShowMessageAfterLaunch(Date date) {
        return date.before(this.showMessagesAfterLaunch);
    }

    private boolean isTooSoonToShowMessageAfterDelay(Date date) {
        Date date2 = this.showMessagesAfterDelay;
        if (date2 == null) {
            return false;
        }
        return date.before(date2);
    }
}
