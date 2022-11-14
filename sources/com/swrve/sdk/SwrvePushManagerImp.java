package com.swrve.sdk;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;

public class SwrvePushManagerImp implements SwrvePushManager {
    public String authenticatedUserId;
    public final Context context;
    public SwrveNotificationBuilder notificationBuilder;
    public ISwrveCommon swrveCommon = SwrveCommon.getInstance();

    public SwrvePushManagerImp(Context context2) {
        this.context = context2;
    }

    private Notification applyCustomFilter(NotificationCompat.Builder builder, int i, Bundle bundle, SwrveNotificationDetails swrveNotificationDetails) {
        SwrveNotificationConfig notificationConfig = this.swrveCommon.getNotificationConfig();
        if (notificationConfig == null || notificationConfig.getNotificationFilter() == null) {
            SwrveLogger.m2752d("SwrveNotificationFilter not configured.", new Object[0]);
            return builder.build();
        }
        SwrveLogger.m2752d("SwrveNotificationFilter configured. Passing builder to custom filter.", new Object[0]);
        try {
            String payload = SwrvePushManagerHelper.getPayload(bundle);
            if (notificationConfig.getNotificationFilter() != null) {
                return notificationConfig.getNotificationFilter().filterNotification(builder, i, swrveNotificationDetails, payload);
            }
            return builder.build();
        } catch (Exception e) {
            SwrveLogger.m2753e("Error calling the custom notification filter.", e, new Object[0]);
            return builder.build();
        }
    }

    private JSONObject getSilentPayload(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            String string = bundle.getString(SwrveNotificationConstants.SILENT_PAYLOAD_KEY);
            if (string != null) {
                return new JSONObject(string);
            }
            return jSONObject;
        } catch (Exception e) {
            SwrveLogger.m2753e("Swrve silent push listener launched an exception: ", e, new Object[0]);
            return jSONObject;
        }
    }

    private boolean isAuthenticatedPush(String str) {
        return SwrveHelper.isNotNullOrEmpty(str);
    }

    private boolean isDifferentUser(String str) {
        if (this.swrveCommon.getUserId().equals(str)) {
            return false;
        }
        SwrveLogger.m2758w("Swrve cannot display push notification because its intended for different user.", new Object[0]);
        return true;
    }

    private boolean isTrackingStateStopped() {
        if (!this.swrveCommon.isTrackingStateStopped()) {
            return false;
        }
        SwrveLogger.m2758w("Swrve cannot display push notification because sdk is stopped.", new Object[0]);
        return true;
    }

    private void processSilent(Bundle bundle, String str) {
        saveInfluencedCampaign(bundle, str);
        SwrveSilentPushListener silentPushListener = this.swrveCommon.getSilentPushListener();
        if (silentPushListener != null) {
            silentPushListener.onSilentPush(this.context, getSilentPayload(bundle));
            return;
        }
        SwrveLogger.m2755i("Swrve silent push received but there was no listener assigned or wasn't currently authenticated user", new Object[0]);
    }

    private void saveInfluencedCampaign(Bundle bundle, String str) {
        new SwrveCampaignInfluence().saveInfluencedCampaign(this.context, str, bundle, getNow());
    }

    public CampaignDeliveryManager getCampaignDeliveryManager() {
        return new CampaignDeliveryManager(this.context);
    }

    public Date getNow() {
        return new Date();
    }

    public SwrveNotificationBuilder getSwrveNotificationBuilder() {
        if (this.notificationBuilder == null) {
            this.notificationBuilder = new SwrveNotificationBuilder(this.context, this.swrveCommon.getNotificationConfig());
        }
        return this.notificationBuilder;
    }

    public long getTime() {
        return getNow().getTime();
    }

    public void processMessage(Bundle bundle) {
        boolean z = false;
        if (this.swrveCommon == null) {
            SwrveLogger.m2754e("SwrveSDK cannot process push because SwrveCommon is null. Please check integration.", new Object[0]);
            return;
        }
        String silentPushId = SwrveHelper.getSilentPushId(bundle);
        String str = "";
        if (!SwrveHelper.isNullOrEmpty(silentPushId)) {
            sendPushDeliveredEvent(bundle, false, str);
            processSilent(bundle, silentPushId);
            return;
        }
        String string = bundle.getString(SwrveNotificationInternalPayloadConstants.SWRVE_AUTH_USER_KEY);
        this.authenticatedUserId = string;
        boolean isAuthenticatedPush = isAuthenticatedPush(string);
        if (isAuthenticatedPush && isDifferentUser(this.authenticatedUserId)) {
            str = "different_user";
        } else if (!isAuthenticatedPush || !isTrackingStateStopped()) {
            z = true;
        } else {
            str = "stopped";
        }
        sendPushDeliveredEvent(bundle, z, str);
        if (z) {
            processNotification(bundle, SwrveHelper.getRemotePushId(bundle));
        }
    }

    public void processNotification(Bundle bundle, String str) {
        try {
            String string = bundle.getString("text");
            SwrveNotificationBuilder swrveNotificationBuilder = getSwrveNotificationBuilder();
            NotificationCompat.Builder build = swrveNotificationBuilder.build(string, bundle, ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_PUSH, (Bundle) null);
            build.setContentIntent(swrveNotificationBuilder.createPendingIntent(bundle, ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_PUSH, (Bundle) null));
            int notificationId = swrveNotificationBuilder.getNotificationId();
            Notification applyCustomFilter = applyCustomFilter(build, notificationId, bundle, swrveNotificationBuilder.getNotificationDetails());
            if (applyCustomFilter == null) {
                SwrveLogger.m2752d("SwrvePushManager: notification suppressed via custom filter. notificationId: %s", Integer.valueOf(notificationId));
                return;
            }
            saveInfluencedCampaign(bundle, str);
            ((NotificationManager) this.context.getSystemService(SwrveNotificationConstants.PUSH_BUNDLE)).notify(notificationId, applyCustomFilter);
            SwrveLogger.m2752d("SwrvePushManager: displayed notificationId: %s", Integer.valueOf(notificationId));
            if (this.authenticatedUserId != null) {
                this.swrveCommon.saveNotificationAuthenticated(notificationId);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Error processing push.", e, new Object[0]);
        }
    }

    public void sendPushDeliveredEvent(Bundle bundle, boolean z, String str) {
        try {
            ArrayList<String> pushDeliveredEvent = EventHelper.getPushDeliveredEvent(bundle, getTime(), z, str);
            if (pushDeliveredEvent != null && pushDeliveredEvent.size() > 0) {
                String pushDeliveredBatchEvent = EventHelper.getPushDeliveredBatchEvent(pushDeliveredEvent);
                getCampaignDeliveryManager().sendCampaignDelivery(this.swrveCommon.getEventsServer() + SwrveImp.BATCH_EVENTS_ACTION, pushDeliveredBatchEvent);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception in sendPushDeliveredEvent.", e, new Object[0]);
        }
    }
}
