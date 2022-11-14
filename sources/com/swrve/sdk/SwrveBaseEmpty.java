package com.swrve.sdk;

import android.app.Activity;
import android.app.NotificationChannel;
import android.content.Context;
import android.os.Bundle;
import com.swrve.sdk.config.SwrveConfigBase;
import com.swrve.sdk.messaging.SwrveBaseCampaign;
import com.swrve.sdk.messaging.SwrveButton;
import com.swrve.sdk.messaging.SwrveEmbeddedMessage;
import com.swrve.sdk.messaging.SwrveMessageFormat;
import com.swrve.sdk.messaging.SwrveMessageListener;
import com.swrve.sdk.messaging.SwrveOrientation;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveBaseEmpty<T, C extends SwrveConfigBase> implements ISwrveBase<T, C>, ISwrveCommon {
    public String apiKey;
    public File cacheDir;
    public C config = new SwrveConfigBaseImp();
    public WeakReference<Context> context;
    public String language;

    public class SwrveConfigBaseImp extends SwrveConfigBase {
        public SwrveConfigBaseImp() {
        }
    }

    public SwrveBaseEmpty(Context context2, String str) {
        this.context = new WeakReference<>(context2.getApplicationContext());
        this.apiKey = str;
        SwrveCommon.setSwrveCommon(this);
        this.language = this.config.getLanguage();
        File cacheDir2 = this.config.getCacheDir();
        this.cacheDir = cacheDir2;
        if (cacheDir2 == null) {
            this.cacheDir = context2.getCacheDir();
        }
    }

    public void buttonWasPressedByUser(SwrveButton swrveButton) {
    }

    public void currencyGiven(String str, double d) {
    }

    public void embeddedMessageButtonWasPressed(SwrveEmbeddedMessage swrveEmbeddedMessage, String str) {
    }

    public void embeddedMessageWasShownToUser(SwrveEmbeddedMessage swrveEmbeddedMessage) {
    }

    public void event(String str) {
    }

    public void event(String str, Map<String, String> map) {
    }

    public void fetchNotificationCampaigns(Set<Long> set) {
    }

    public void flushToDisk() {
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public int getAppId() {
        return 0;
    }

    public String getAppStoreURLForApp(int i) {
        return null;
    }

    public String getAppVersion() {
        return null;
    }

    public String getBatchURL() {
        return null;
    }

    public File getCacheDir() {
        return this.cacheDir;
    }

    public File getCacheDir(Context context2) {
        return null;
    }

    public String getCachedData(String str, String str2) {
        return null;
    }

    public C getConfig() {
        return this.config;
    }

    public String getContentURL() {
        return null;
    }

    public NotificationChannel getDefaultNotificationChannel() {
        return null;
    }

    public String getDeviceId() {
        return null;
    }

    public JSONObject getDeviceInfo() throws JSONException {
        return new JSONObject();
    }

    public String getEventsServer() {
        return null;
    }

    public String getExternalUserId() {
        return "";
    }

    public int getFlushRefreshDelay() {
        return 0;
    }

    public int getHttpTimeout() {
        return 0;
    }

    public Date getInitialisedTime() {
        return new Date();
    }

    public String getJoined() {
        return "";
    }

    public String getLanguage() {
        return this.language;
    }

    public List<SwrveBaseCampaign> getMessageCenterCampaigns() {
        return new ArrayList();
    }

    public int getNextSequenceNumber() {
        return 0;
    }

    public SwrveNotificationConfig getNotificationConfig() {
        return null;
    }

    public SwrvePushNotificationListener getNotificationListener() {
        return null;
    }

    public String getPersonalizedEmbeddedMessageData(SwrveEmbeddedMessage swrveEmbeddedMessage, Map<String, String> map) {
        return null;
    }

    public String getPersonalizedText(String str, Map<String, String> map) {
        return null;
    }

    public void getRealTimeUserProperties(SwrveRealTimeUserPropertiesListener swrveRealTimeUserPropertiesListener) {
        if (swrveRealTimeUserPropertiesListener != null) {
            swrveRealTimeUserPropertiesListener.onRealTimeUserPropertiesSuccess(new HashMap(), (String) null);
        }
    }

    public SwrveResourceManager getResourceManager() {
        return new SwrveResourceManager();
    }

    public String getSessionKey() {
        return null;
    }

    public SwrveSilentPushListener getSilentPushListener() {
        return null;
    }

    public String getSwrveSDKVersion() {
        return SwrveBase.getVersion();
    }

    public String getUniqueKey(String str) {
        return null;
    }

    public String getUserId() {
        return "unsupported_version";
    }

    public void getUserResources(SwrveUserResourcesListener swrveUserResourcesListener) {
        if (swrveUserResourcesListener != null) {
            swrveUserResourcesListener.onUserResourcesSuccess(new HashMap(), (String) null);
        }
    }

    public void getUserResourcesDiff(SwrveUserResourcesDiffListener swrveUserResourcesDiffListener) {
        if (swrveUserResourcesDiffListener != null) {
            swrveUserResourcesDiffListener.onUserResourcesDiffSuccess(new HashMap(), new HashMap(), (String) null);
        }
    }

    public void handleDeeplink(Bundle bundle) {
    }

    public void handleDeferredDeeplink(Bundle bundle) {
    }

    public void iap(int i, String str, double d, String str2) {
    }

    public void iap(int i, String str, double d, String str2, SwrveIAPRewards swrveIAPRewards) {
    }

    public void identify(String str, SwrveIdentityResponse swrveIdentityResponse) {
    }

    public boolean isStarted() {
        return false;
    }

    public boolean isTrackingStateStopped() {
        return true;
    }

    public void markMessageCenterCampaignAsSeen(SwrveBaseCampaign swrveBaseCampaign) {
    }

    public void messageWasShownToUser(SwrveMessageFormat swrveMessageFormat) {
    }

    public void purchase(String str, String str2, int i, int i2) {
    }

    public void refreshCampaignsAndResources() {
    }

    public void removeMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign) {
    }

    public void saveEvent(String str) {
    }

    public void saveNotificationAuthenticated(int i) {
    }

    public void sendEventsInBackground(Context context2, String str, ArrayList<String> arrayList) {
    }

    public void sendQueuedEvents() {
    }

    public void sessionEnd() {
    }

    public void sessionStart() {
    }

    public void setCustomPayloadForConversationInput(Map map) {
    }

    public void setLanguage(Locale locale) {
        this.language = SwrveHelper.toLanguageTag(locale);
    }

    public void setMessageListener(SwrveMessageListener swrveMessageListener) {
    }

    public void setNotificationSwrveCampaignId(String str) {
    }

    public void setResourcesListener(SwrveResourcesListener swrveResourcesListener) {
    }

    public void setSessionListener(SwrveSessionListener swrveSessionListener) {
    }

    public boolean showMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign) {
        return false;
    }

    public boolean showMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign, Map<String, String> map) {
        return false;
    }

    public void shutdown() {
    }

    public void start(Activity activity) {
    }

    public void start(Activity activity, String str) {
    }

    public void stopTracking() {
    }

    public void userUpdate(String str, Date date) {
    }

    public void userUpdate(Map<String, String> map) {
    }

    public List<SwrveBaseCampaign> getMessageCenterCampaigns(SwrveOrientation swrveOrientation) {
        return new ArrayList();
    }

    public List<SwrveBaseCampaign> getMessageCenterCampaigns(Map<String, String> map) {
        return new ArrayList();
    }

    public List<SwrveBaseCampaign> getMessageCenterCampaigns(SwrveOrientation swrveOrientation, Map<String, String> map) {
        return new ArrayList();
    }
}
