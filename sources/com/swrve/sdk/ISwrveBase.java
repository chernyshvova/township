package com.swrve.sdk;

import android.app.Activity;
import android.os.Bundle;
import com.swrve.sdk.config.SwrveConfigBase;
import com.swrve.sdk.messaging.SwrveBaseCampaign;
import com.swrve.sdk.messaging.SwrveButton;
import com.swrve.sdk.messaging.SwrveEmbeddedMessage;
import com.swrve.sdk.messaging.SwrveMessageFormat;
import com.swrve.sdk.messaging.SwrveMessageListener;
import com.swrve.sdk.messaging.SwrveOrientation;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public interface ISwrveBase<T, C extends SwrveConfigBase> {
    void buttonWasPressedByUser(SwrveButton swrveButton);

    void currencyGiven(String str, double d);

    void embeddedMessageButtonWasPressed(SwrveEmbeddedMessage swrveEmbeddedMessage, String str);

    void embeddedMessageWasShownToUser(SwrveEmbeddedMessage swrveEmbeddedMessage);

    void event(String str);

    void event(String str, Map<String, String> map);

    void flushToDisk();

    String getApiKey();

    String getAppStoreURLForApp(int i);

    File getCacheDir();

    C getConfig();

    JSONObject getDeviceInfo() throws JSONException;

    String getExternalUserId();

    Date getInitialisedTime();

    String getLanguage();

    List<SwrveBaseCampaign> getMessageCenterCampaigns();

    List<SwrveBaseCampaign> getMessageCenterCampaigns(SwrveOrientation swrveOrientation);

    List<SwrveBaseCampaign> getMessageCenterCampaigns(SwrveOrientation swrveOrientation, Map<String, String> map);

    List<SwrveBaseCampaign> getMessageCenterCampaigns(Map<String, String> map);

    String getPersonalizedEmbeddedMessageData(SwrveEmbeddedMessage swrveEmbeddedMessage, Map<String, String> map);

    String getPersonalizedText(String str, Map<String, String> map);

    void getRealTimeUserProperties(SwrveRealTimeUserPropertiesListener swrveRealTimeUserPropertiesListener);

    SwrveResourceManager getResourceManager();

    String getUserId();

    void getUserResources(SwrveUserResourcesListener swrveUserResourcesListener);

    void getUserResourcesDiff(SwrveUserResourcesDiffListener swrveUserResourcesDiffListener);

    void handleDeeplink(Bundle bundle);

    void handleDeferredDeeplink(Bundle bundle);

    void iap(int i, String str, double d, String str2);

    void iap(int i, String str, double d, String str2, SwrveIAPRewards swrveIAPRewards);

    void identify(String str, SwrveIdentityResponse swrveIdentityResponse);

    boolean isStarted();

    void markMessageCenterCampaignAsSeen(SwrveBaseCampaign swrveBaseCampaign);

    void messageWasShownToUser(SwrveMessageFormat swrveMessageFormat);

    void purchase(String str, String str2, int i, int i2);

    void refreshCampaignsAndResources();

    void removeMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign);

    void sendQueuedEvents();

    void sessionEnd();

    void sessionStart();

    void setCustomPayloadForConversationInput(Map map);

    void setLanguage(Locale locale);

    void setMessageListener(SwrveMessageListener swrveMessageListener);

    void setResourcesListener(SwrveResourcesListener swrveResourcesListener);

    boolean showMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign);

    boolean showMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign, Map<String, String> map);

    void shutdown();

    void start(Activity activity);

    void start(Activity activity, String str);

    void stopTracking();

    void userUpdate(String str, Date date);

    void userUpdate(Map<String, String> map);
}
