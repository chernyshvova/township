package com.swrve.sdk;

import android.app.Activity;
import android.os.Bundle;
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

public abstract class SwrveSDKBase {
    public static ISwrveBase instance;

    public static void buttonWasPressedByUser(SwrveButton swrveButton) {
        checkInstanceCreated();
        instance.buttonWasPressedByUser(swrveButton);
    }

    public static void checkInstanceCreated() throws RuntimeException {
        if (instance == null) {
            SwrveLogger.m2754e("Please call SwrveSDK.createInstance first in your Application class.", new Object[0]);
            throw new RuntimeException("Please call SwrveSDK.createInstance first in your Application class.");
        }
    }

    public static void currencyGiven(String str, double d) {
        checkInstanceCreated();
        instance.currencyGiven(str, d);
    }

    public static void embeddedMessageButtonWasPressed(SwrveEmbeddedMessage swrveEmbeddedMessage, String str) {
        checkInstanceCreated();
        instance.embeddedMessageButtonWasPressed(swrveEmbeddedMessage, str);
    }

    public static void embeddedMessageWasShownToUser(SwrveEmbeddedMessage swrveEmbeddedMessage) {
        checkInstanceCreated();
        instance.embeddedMessageWasShownToUser(swrveEmbeddedMessage);
    }

    public static void event(String str) {
        checkInstanceCreated();
        instance.event(str);
    }

    public static void flushToDisk() {
        checkInstanceCreated();
        instance.flushToDisk();
    }

    public static String getApiKey() {
        checkInstanceCreated();
        return instance.getApiKey();
    }

    public static String getAppStoreURLForApp(int i) {
        checkInstanceCreated();
        return instance.getAppStoreURLForApp(i);
    }

    public static File getCacheDir() {
        checkInstanceCreated();
        return instance.getCacheDir();
    }

    public static JSONObject getDeviceInfo() throws JSONException {
        checkInstanceCreated();
        return instance.getDeviceInfo();
    }

    public static String getExternalUserId() {
        checkInstanceCreated();
        return instance.getExternalUserId();
    }

    public static Date getInitialisedTime() {
        checkInstanceCreated();
        return instance.getInitialisedTime();
    }

    public static ISwrveBase getInstance() {
        return instance;
    }

    public static String getLanguage() {
        checkInstanceCreated();
        return instance.getLanguage();
    }

    public static List<SwrveBaseCampaign> getMessageCenterCampaigns() {
        checkInstanceCreated();
        return instance.getMessageCenterCampaigns();
    }

    public static String getPersonalizedEmbeddedMessageData(SwrveEmbeddedMessage swrveEmbeddedMessage, Map<String, String> map) {
        checkInstanceCreated();
        return instance.getPersonalizedEmbeddedMessageData(swrveEmbeddedMessage, map);
    }

    public static String getPersonalizedText(String str, Map<String, String> map) {
        checkInstanceCreated();
        return instance.getPersonalizedText(str, map);
    }

    public static void getRealTimeUserProperties(SwrveRealTimeUserPropertiesListener swrveRealTimeUserPropertiesListener) {
        checkInstanceCreated();
        instance.getRealTimeUserProperties(swrveRealTimeUserPropertiesListener);
    }

    public static SwrveResourceManager getResourceManager() {
        checkInstanceCreated();
        return instance.getResourceManager();
    }

    public static String getUserId() {
        checkInstanceCreated();
        return instance.getUserId();
    }

    public static void getUserResources(SwrveUserResourcesListener swrveUserResourcesListener) {
        checkInstanceCreated();
        instance.getUserResources(swrveUserResourcesListener);
    }

    public static void getUserResourcesDiff(SwrveUserResourcesDiffListener swrveUserResourcesDiffListener) {
        checkInstanceCreated();
        instance.getUserResourcesDiff(swrveUserResourcesDiffListener);
    }

    public static void handleDeeplink(Bundle bundle) {
        checkInstanceCreated();
        instance.handleDeeplink(bundle);
    }

    public static void handleDeferredDeeplink(Bundle bundle) {
        checkInstanceCreated();
        instance.handleDeferredDeeplink(bundle);
    }

    public static void iap(int i, String str, double d, String str2) {
        checkInstanceCreated();
        instance.iap(i, str, d, str2);
    }

    public static void identify(String str, SwrveIdentityResponse swrveIdentityResponse) {
        checkInstanceCreated();
        instance.identify(str, swrveIdentityResponse);
    }

    public static boolean isStarted() {
        checkInstanceCreated();
        return instance.isStarted();
    }

    public static void markMessageCenterCampaignAsSeen(SwrveBaseCampaign swrveBaseCampaign) {
        checkInstanceCreated();
        instance.markMessageCenterCampaignAsSeen(swrveBaseCampaign);
    }

    public static void messageWasShownToUser(SwrveMessageFormat swrveMessageFormat) {
        checkInstanceCreated();
        instance.messageWasShownToUser(swrveMessageFormat);
    }

    public static void purchase(String str, String str2, int i, int i2) {
        checkInstanceCreated();
        instance.purchase(str, str2, i, i2);
    }

    public static void refreshCampaignsAndResources() {
        checkInstanceCreated();
        instance.refreshCampaignsAndResources();
    }

    public static void removeMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign) {
        checkInstanceCreated();
        instance.removeMessageCenterCampaign(swrveBaseCampaign);
    }

    public static void sendQueuedEvents() {
        checkInstanceCreated();
        instance.sendQueuedEvents();
    }

    public static void sessionEnd() {
        checkInstanceCreated();
        instance.sessionEnd();
    }

    public static void sessionStart() {
        checkInstanceCreated();
        instance.sessionStart();
    }

    public static void setCustomPayloadForConversationInput(Map map) {
        checkInstanceCreated();
        instance.setCustomPayloadForConversationInput(map);
    }

    public static void setLanguage(Locale locale) {
        checkInstanceCreated();
        instance.setLanguage(locale);
    }

    public static void setMessageListener(SwrveMessageListener swrveMessageListener) {
        checkInstanceCreated();
        instance.setMessageListener(swrveMessageListener);
    }

    public static void setResourcesListener(SwrveResourcesListener swrveResourcesListener) {
        checkInstanceCreated();
        instance.setResourcesListener(swrveResourcesListener);
    }

    public static boolean showMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign) {
        checkInstanceCreated();
        return instance.showMessageCenterCampaign(swrveBaseCampaign);
    }

    public static void shutdown() {
        checkInstanceCreated();
        instance.shutdown();
    }

    public static void start(Activity activity) {
        checkInstanceCreated();
        instance.start(activity);
    }

    public static void stopTracking() {
        checkInstanceCreated();
        instance.stopTracking();
    }

    public static void userUpdate(Map<String, String> map) {
        checkInstanceCreated();
        instance.userUpdate(map);
    }

    public static void event(String str, Map<String, String> map) {
        checkInstanceCreated();
        instance.event(str, map);
    }

    public static List<SwrveBaseCampaign> getMessageCenterCampaigns(SwrveOrientation swrveOrientation) {
        checkInstanceCreated();
        return instance.getMessageCenterCampaigns(swrveOrientation);
    }

    public static void iap(int i, String str, double d, String str2, SwrveIAPRewards swrveIAPRewards) {
        checkInstanceCreated();
        instance.iap(i, str, d, str2, swrveIAPRewards);
    }

    public static boolean showMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign, Map<String, String> map) {
        checkInstanceCreated();
        return instance.showMessageCenterCampaign(swrveBaseCampaign, map);
    }

    public static void start(Activity activity, String str) {
        checkInstanceCreated();
        instance.start(activity, str);
    }

    public static void userUpdate(String str, Date date) {
        checkInstanceCreated();
        instance.userUpdate(str, date);
    }

    public static List<SwrveBaseCampaign> getMessageCenterCampaigns(Map<String, String> map) {
        checkInstanceCreated();
        return instance.getMessageCenterCampaigns(map);
    }

    public static List<SwrveBaseCampaign> getMessageCenterCampaigns(SwrveOrientation swrveOrientation, Map<String, String> map) {
        checkInstanceCreated();
        return instance.getMessageCenterCampaigns(swrveOrientation, map);
    }
}
