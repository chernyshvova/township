package com.swrve.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.drive.DriveFile;
import com.swrve.sdk.config.SwrveConfig;
import com.swrve.sdk.conversations.SwrveConversation;
import com.swrve.sdk.conversations.SwrveConversationListener;
import com.swrve.sdk.conversations.p035ui.ConversationActivity;
import com.swrve.sdk.messaging.SwrveBaseCampaign;
import com.swrve.sdk.messaging.SwrveConversationCampaign;
import com.swrve.sdk.messaging.SwrveEmbeddedCampaign;
import com.swrve.sdk.messaging.SwrveEmbeddedMessage;
import com.swrve.sdk.messaging.SwrveEmbeddedMessageListener;
import com.swrve.sdk.messaging.SwrveInAppCampaign;
import com.swrve.sdk.messaging.SwrveMessage;
import com.swrve.sdk.messaging.SwrveMessageListener;
import com.swrve.sdk.messaging.p036ui.SwrveInAppMessageActivity;
import com.swrve.sdk.rest.IRESTClient;
import com.swrve.sdk.rest.IRESTResponseListener;
import com.swrve.sdk.rest.RESTResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveDeeplinkManager {
    public static final String SWRVE_AD_CAMPAIGN = "ad_campaign";
    public static final String SWRVE_AD_CAMPAIGN_URL = "/api/1/ad_journey_campaign";
    public static final String SWRVE_AD_CONTENT = "ad_content";
    public static final String SWRVE_AD_INSTALL = "install";
    public static final String SWRVE_AD_MESSAGE = "ad_message_key";
    public static final String SWRVE_AD_REENGAGE = "reengage";
    public static final String SWRVE_AD_SOURCE = "ad_source";
    public static final String SWRVE_FB_TARGET_URL = "target_url";
    public static final String SWRVE_NOTIFICATION_TO_CAMPAIGN = "notification_to_campaign";
    public String alreadySeenCampaignId;
    public SwrveBaseCampaign campaign;
    public SwrveConfig config;
    public Context context;
    public IRESTClient restClient;
    public Map<String, String> standardParams;
    public SwrveAssetsManager swrveAssetsManager;
    public SwrveCampaignDisplayer swrveCampaignDisplayer = new SwrveCampaignDisplayer();
    public SwrveConversationListener swrveConversationListener;
    public SwrveMessage swrveMessage;
    public SwrveMessageListener swrveMessageListener;

    public SwrveDeeplinkManager(Map<String, String> map, SwrveConfig swrveConfig, Context context2, SwrveAssetsManager swrveAssetsManager2, IRESTClient iRESTClient) {
        this.standardParams = map;
        this.config = swrveConfig;
        this.context = context2;
        this.swrveAssetsManager = swrveAssetsManager2;
        setRestClient(iRESTClient);
    }

    public static boolean isSwrveDeeplink(Bundle bundle) {
        Uri parse;
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("target_url");
        if (!SwrveHelper.isNotNullOrEmpty(string) || (parse = Uri.parse(string)) == null) {
            return false;
        }
        return SwrveHelper.isNotNullOrEmpty(parse.getQueryParameter(SWRVE_AD_CONTENT));
    }

    private void loadCampaignFromCache(String str) {
        SwrveLogger.m2756v("SwrveSDK attempting to load campaign from cache", new Object[0]);
        try {
            Swrve swrve = (Swrve) SwrveSDKBase.getInstance();
            String offlineCampaign = swrve.multiLayerLocalStorage.getOfflineCampaign(swrve.getUserId(), str);
            if (SwrveHelper.isNotNullOrEmpty(offlineCampaign)) {
                getCampaignAssets(new JSONObject(offlineCampaign), new SwrveAssetsCompleteCallback() {
                    public void complete() {
                        SwrveDeeplinkManager swrveDeeplinkManager = SwrveDeeplinkManager.this;
                        swrveDeeplinkManager.showCampaign(swrveDeeplinkManager.campaign, SwrveDeeplinkManager.this.context, SwrveDeeplinkManager.this.config);
                    }
                });
                return;
            }
            SwrveLogger.m2758w("SwrveDeeplinkManager: unable to load campaignId:%s from cache", str);
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveDeeplinkManager: exception loading campaignId:%s from cache", e, str);
        }
    }

    private void updateCdnPaths(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("additional_info")) {
            return;
        }
        if (jSONObject.has("cdn_root")) {
            String string = jSONObject.getString("cdn_root");
            this.swrveAssetsManager.setCdnImages(string);
            SwrveLogger.m2755i("CDN URL %s", string);
        } else if (jSONObject.has("cdn_paths")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("cdn_paths");
            String string2 = jSONObject2.getString("message_images");
            String string3 = jSONObject2.getString("message_fonts");
            this.swrveAssetsManager.setCdnImages(string2);
            this.swrveAssetsManager.setCdnFonts(string3);
            SwrveLogger.m2755i("CDN URL images:%s fonts:%s", string2, string3);
        }
    }

    public void displayCampaign(String str, String str2, RESTResponse rESTResponse) throws Exception {
        if (rESTResponse.responseCode == 200) {
            JSONObject jSONObject = new JSONObject(rESTResponse.responseBody);
            updateCdnPaths(jSONObject);
            getCampaignAssets(jSONObject, new SwrveAssetsCompleteCallback() {
                public final void complete() {
                    SwrveDeeplinkManager.this.lambda$displayCampaign$1$SwrveDeeplinkManager();
                }
            });
            writeCampaignDataToCache(jSONObject, str2);
            return;
        }
        SwrveLogger.m2754e("SwrveSDK unable to get ad_journey_campaign JSON : \"%s\".", rESTResponse.responseBody);
        loadCampaignFromCache(str);
    }

    public void downloadAssets(Set<SwrveAssetsQueueItem> set, SwrveAssetsCompleteCallback swrveAssetsCompleteCallback) {
        this.swrveAssetsManager.downloadAssets(set, swrveAssetsCompleteCallback);
    }

    public void fetchOfflineCampaigns(Set<Long> set) throws Exception {
        for (Long longValue : set) {
            long longValue2 = longValue.longValue();
            IRESTResponseListener offlineRestResponseListener = getOfflineRestResponseListener(longValue2);
            this.standardParams.put("in_app_campaign_id", String.valueOf(longValue2));
            getRestClient().get(this.config.getContentUrl() + SWRVE_AD_CAMPAIGN_URL, this.standardParams, offlineRestResponseListener);
        }
    }

    public void getCampaignAssets(JSONObject jSONObject, SwrveAssetsCompleteCallback swrveAssetsCompleteCallback) throws JSONException {
        if (isValidCampaignJson(jSONObject)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("campaign");
            HashSet hashSet = new HashSet();
            if (jSONObject2.has(ConversationActivity.EXTRA_CONVERSATION_KEY)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(ConversationActivity.EXTRA_CONVERSATION_KEY);
                if (!hasValidFilters(jSONObject3)) {
                    SwrveLogger.m2758w("SwrveDeeplinkManager: has invalid filter. No campaigns loaded", new Object[0]);
                    return;
                }
                int optInt = jSONObject3.optInt("conversation_version", 1);
                if (optInt <= 4) {
                    this.campaign = new SwrveConversationCampaign((Swrve) SwrveSDKBase.getInstance(), this.swrveCampaignDisplayer, jSONObject2, hashSet);
                } else {
                    SwrveLogger.m2755i("SwrveDeeplinkManager: Conversation version %s cannot be loaded with this SDK version", Integer.valueOf(optInt));
                }
            } else if (jSONObject2.has("message")) {
                Swrve swrve = (Swrve) SwrveSDKBase.getInstance();
                this.campaign = new SwrveInAppCampaign(swrve, this.swrveCampaignDisplayer, jSONObject2, hashSet, swrve.retrievePersonalizationProperties((Map<String, String>) null, (Map<String, String>) null));
            } else if (jSONObject2.has("embedded_message")) {
                this.campaign = new SwrveEmbeddedCampaign((Swrve) SwrveSDKBase.getInstance(), this.swrveCampaignDisplayer, jSONObject2);
            }
            downloadAssets(hashSet, swrveAssetsCompleteCallback);
        }
    }

    public IRESTResponseListener getOfflineRestResponseListener(final long j) {
        return new IRESTResponseListener() {
            public void onException(Exception exc) {
                SwrveLogger.m2753e("SwrveDeeplinkManager: Exception getting offline campaign.", exc, new Object[0]);
            }

            public void onResponse(RESTResponse rESTResponse) {
                int i = rESTResponse.responseCode;
                if (i == 200) {
                    try {
                        SwrveDeeplinkManager.this.processOfflineCampaignResponse(j, rESTResponse.responseBody);
                    } catch (Exception e) {
                        SwrveLogger.m2753e("SwrveDeeplinkManager: exception getting offline campaign:%s", e, Long.valueOf(j));
                    }
                } else {
                    SwrveLogger.m2758w("SwrveDeeplinkManager: checking for offline campaign did not return OK. ResponseCode:%s", Integer.valueOf(i));
                }
            }
        };
    }

    public IRESTClient getRestClient() {
        return this.restClient;
    }

    public SwrveMessage getSwrveMessage() {
        return this.swrveMessage;
    }

    public void handleDeeplink(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("target_url");
            if (SwrveHelper.isNotNullOrEmpty(string)) {
                handleDeeplink(Uri.parse(string), SWRVE_AD_REENGAGE);
                return;
            }
            String string2 = bundle.getString("campaign");
            if (SwrveHelper.isNotNullOrEmpty(string2)) {
                loadCampaign(string2, SWRVE_NOTIFICATION_TO_CAMPAIGN);
            }
        }
    }

    public void handleDeferredDeeplink(Bundle bundle) {
        if (bundle != null) {
            handleDeeplink(Uri.parse(bundle.getString("target_url")), SWRVE_AD_INSTALL);
        }
    }

    public boolean hasValidFilters(JSONObject jSONObject) throws JSONException {
        boolean z = true;
        if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_FILTERS)) {
            JSONArray jSONArray = jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
            for (int i = 0; i < jSONArray.length() && z; i++) {
                z = supportsDeviceFilter(jSONArray.getString(i));
            }
        }
        return z;
    }

    public boolean isValidCampaignJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            SwrveLogger.m2758w("SwrveDeeplinkManager: NULL JSON for campaigns, aborting load.", new Object[0]);
            return false;
        }
        SwrveLogger.m2756v("SwrveDeeplinkManager: Campaign JSON data: %s", jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("additional_info");
        if (!jSONObject2.has("version")) {
            SwrveLogger.m2758w("SwrveDeeplinkManager: no version. No campaigns loaded.", new Object[0]);
            return false;
        }
        String string = jSONObject2.getString("version");
        if (string.equals(SwrveImp.CAMPAIGN_RESPONSE_VERSION)) {
            return true;
        }
        SwrveLogger.m2758w("SwrveDeeplinkManager: Campaign JSON (%s) has the wrong version for this sdk (%s). No campaigns loaded.", string, SwrveImp.CAMPAIGN_RESPONSE_VERSION);
        return false;
    }

    public /* synthetic */ void lambda$displayCampaign$1$SwrveDeeplinkManager() {
        showCampaign(this.campaign, this.context, this.config);
    }

    public /* synthetic */ void lambda$loadCampaign$0$SwrveDeeplinkManager(final String str, final String str2) {
        try {
            IRESTClient iRESTClient = this.restClient;
            iRESTClient.get(this.config.getContentUrl() + SWRVE_AD_CAMPAIGN_URL, this.standardParams, new IRESTResponseListener() {
                public void onException(Exception exc) {
                    SwrveLogger.m2753e("Error downloading ad campaign", exc, new Object[0]);
                }

                public void onResponse(RESTResponse rESTResponse) {
                    try {
                        SwrveDeeplinkManager.this.displayCampaign(str, str2, rESTResponse);
                    } catch (Exception e) {
                        SwrveLogger.m2753e("SwrveSDK: Error displaying ad campaign", e, new Object[0]);
                    }
                }
            });
        } catch (Exception e) {
            SwrveLogger.m2753e("Could not update ad campaign, invalid parameters", e, new Object[0]);
        }
    }

    public void loadCampaign(String str, String str2) {
        this.standardParams.put("in_app_campaign_id", str);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            newSingleThreadExecutor.execute(SwrveRunnables.withoutExceptions(new Runnable(str, str2) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SwrveDeeplinkManager.this.lambda$loadCampaign$0$SwrveDeeplinkManager(this.f$1, this.f$2);
                }
            }));
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }

    public void processOfflineCampaignResponse(long j, String str) throws Exception {
        Swrve swrve = (Swrve) SwrveSDKBase.getInstance();
        swrve.multiLayerLocalStorage.saveOfflineCampaign(swrve.getUserId(), String.valueOf(j), str);
        JSONObject jSONObject = new JSONObject(str);
        updateCdnPaths(jSONObject);
        getCampaignAssets(jSONObject, (SwrveAssetsCompleteCallback) null);
    }

    public void queueDeeplinkGenericEvent(String str, String str2, String str3, String str4) throws JSONException {
        ISwrveCommon instance = SwrveCommon.getInstance();
        if (instance == null || !SwrveHelper.isNotNullOrEmpty(str) || !SwrveHelper.isNotNullOrEmpty(str3)) {
            SwrveLogger.m2754e("Cannot queueDeeplinkGenericEvent: no SwrveSDK instance present or parameters were null", new Object[0]);
            return;
        }
        HashMap hashMap = new HashMap();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("external_source_");
        outline24.append(str.toLowerCase(Locale.ENGLISH));
        instance.sendEventsInBackground(this.context, instance.getUserId(), EventHelper.createGenericEvent("-1", outline24.toString(), str4, str3, str2, hashMap, instance.getNextSequenceNumber()));
    }

    public void setRestClient(IRESTClient iRESTClient) {
        this.restClient = iRESTClient;
    }

    public void setSwrveMessage(SwrveMessage swrveMessage2) {
        this.swrveMessage = swrveMessage2;
    }

    public void showCampaign(SwrveBaseCampaign swrveBaseCampaign, Context context2, SwrveConfig swrveConfig) {
        this.alreadySeenCampaignId = String.valueOf(swrveBaseCampaign.getId());
        if (swrveBaseCampaign instanceof SwrveConversationCampaign) {
            SwrveConversation conversation = ((SwrveConversationCampaign) swrveBaseCampaign).getConversation();
            SwrveConversationListener swrveConversationListener2 = this.swrveConversationListener;
            if (swrveConversationListener2 == null) {
                ConversationActivity.showConversation(context2, conversation, swrveConfig.getOrientation());
            } else {
                swrveConversationListener2.onMessage(conversation);
            }
        } else if (swrveBaseCampaign instanceof SwrveInAppCampaign) {
            SwrveMessage message = ((SwrveInAppCampaign) swrveBaseCampaign).getMessage();
            if (SwrveMessageTextTemplatingChecks.checkTextTemplating(message, ((Swrve) SwrveSDKBase.getInstance()).retrievePersonalizationProperties((Map<String, String>) null, (Map<String, String>) null))) {
                setSwrveMessage(message);
                SwrveMessageListener swrveMessageListener2 = this.swrveMessageListener;
                if (swrveMessageListener2 == null) {
                    Intent intent = new Intent(context2, SwrveInAppMessageActivity.class);
                    intent.addFlags(DriveFile.MODE_READ_ONLY);
                    intent.putExtra("ad_message_key", true);
                    context2.startActivity(intent);
                    return;
                }
                swrveMessageListener2.onMessage(message);
            }
        } else if (swrveBaseCampaign instanceof SwrveEmbeddedCampaign) {
            SwrveEmbeddedMessage message2 = ((SwrveEmbeddedCampaign) swrveBaseCampaign).getMessage();
            SwrveEmbeddedMessageListener embeddedMessageListener = (swrveConfig == null || swrveConfig.getEmbeddedMessageConfig() == null) ? null : swrveConfig.getEmbeddedMessageConfig().getEmbeddedMessageListener();
            if (embeddedMessageListener != null) {
                embeddedMessageListener.onMessage(context2, message2, ((Swrve) SwrveSDKBase.getInstance()).retrievePersonalizationProperties((Map<String, String>) null, (Map<String, String>) null));
            }
        }
    }

    public boolean supportsDeviceFilter(String str) {
        return SwrveImp.SUPPORTED_REQUIREMENTS.contains(str.toLowerCase(Locale.ENGLISH));
    }

    public void writeCampaignDataToCache(JSONObject jSONObject, String str) {
        String userId = SwrveCommon.getInstance().getUserId();
        Swrve swrve = (Swrve) SwrveSDKBase.getInstance();
        swrve.multiLayerLocalStorage.setAndFlushSecureSharedEntryForUser(userId, str.equals(SWRVE_NOTIFICATION_TO_CAMPAIGN) ? ISwrveCommon.CACHE_NOTIFICATION_CAMPAIGNS_DEBUG : ISwrveCommon.CACHE_AD_CAMPAIGNS_DEBUG, jSONObject.toString(), swrve.getUniqueKey(userId));
    }

    private void handleDeeplink(Uri uri, String str) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter(SWRVE_AD_CONTENT);
            if (SwrveHelper.isNullOrEmpty(queryParameter)) {
                SwrveLogger.m2755i("SwrveDeeplinkManager: Could not queue deeplink generic event, missing campaignId", new Object[0]);
            } else if (queryParameter.equals(this.alreadySeenCampaignId)) {
                SwrveLogger.m2755i("SwrveDeeplinkManager: Not queuing deeplink generic event, alreadySeenCampaignID flag is true.", new Object[0]);
            } else {
                loadCampaign(queryParameter, str);
                String queryParameter2 = uri.getQueryParameter("ad_source");
                String queryParameter3 = uri.getQueryParameter(SWRVE_AD_CAMPAIGN);
                if (SwrveHelper.isNullOrEmpty(queryParameter2) || SwrveHelper.isNullOrEmpty(queryParameter3)) {
                    SwrveLogger.m2755i("SwrveDeeplinkManager: Not queuing deeplink generic event, adSource:%s contextId:%s", queryParameter2, queryParameter3);
                    return;
                }
                try {
                    queueDeeplinkGenericEvent(queryParameter2, queryParameter, queryParameter3, str);
                } catch (Exception e) {
                    SwrveLogger.m2753e("SwrveDeeplinkManager: Could not queue deeplink generic event", e, new Object[0]);
                }
            }
        }
    }
}
