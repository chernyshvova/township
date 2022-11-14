package com.swrve.sdk;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.helpshift.p042db.conversation.tables.ActionCardTable;
import com.playrix.engine.VideoPlayer;
import com.swrve.sdk.localstorage.SwrveSQLiteOpenHelper;
import com.swrve.sdk.rest.IRESTClient;
import com.swrve.sdk.rest.IRESTResponseListener;
import com.swrve.sdk.rest.RESTClient;
import com.swrve.sdk.rest.RESTResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class QaUser {
    public static final Object LOCK = new Object();
    public static final int LOG_QUEUE_FLUSH_INTERVAL_MILLIS = 4000;
    public static final String LOG_SOURCE_GEO = "geo-sdk";
    public static final String LOG_SOURCE_SDK = "sdk";
    public static final int REST_CLIENT_TIMEOUT_MILLIS = 15000;
    public static QaUser instance;
    public static IRESTClient restClient = new RESTClient(REST_CLIENT_TIMEOUT_MILLIS);
    public String apiKey;
    public int appId;
    public String appVersion;
    public String deviceId;
    public String endpoint;
    public ScheduledExecutorService flushLogQueueExecutorService;
    public Runnable flushLogQueueRunnable = new Runnable() {
        public void run() {
            try {
                QaUser.this.flushQaLogQueue();
            } catch (Exception e) {
                SwrveLogger.m2753e("QaUser error in runnable trying to flush log queue.", e, new Object[0]);
            }
        }
    };
    public boolean loggingEnabled;
    public List<String> qaLogQueue = Collections.synchronizedList(new ArrayList());
    public boolean resetDevice;
    public ExecutorService restClientExecutor;
    public String sessionToken;
    public boolean startFlushLogQueueService = false;
    public String userId;

    public class RESTResponseListener implements IRESTResponseListener {
        public String endpoint;

        public RESTResponseListener(String str) {
            this.endpoint = str;
        }

        public void onException(Exception exc) {
            SwrveLogger.m2753e("QaUser request to %s failed", exc, this.endpoint);
        }

        public void onResponse(RESTResponse rESTResponse) {
            if (SwrveHelper.successResponseCode(rESTResponse.responseCode)) {
                SwrveLogger.m2756v("QaUser request to %s sent with response code %s: %s", this.endpoint, Integer.valueOf(rESTResponse.responseCode), rESTResponse.responseBody);
                return;
            }
            SwrveLogger.m2754e("QaUser request to %s failed with error code %s: %s", this.endpoint, Integer.valueOf(rESTResponse.responseCode), rESTResponse.responseBody);
        }
    }

    private void _assetFailedToDisplay(int i, int i2, String str, String str2, String str3, boolean z, String str4) throws Exception {
        if (this.loggingEnabled) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SwrveSQLiteOpenHelper.OFFLINE_CAMPAIGNS_COLUMN_CAMPAIGN_ID, i);
            jSONObject.put("variant_id", i2);
            jSONObject.put("unresolved_url", str2);
            jSONObject.put("has_fallback", z);
            jSONObject.put("reason", str4);
            if (SwrveHelper.isNotNullOrEmpty(str3)) {
                jSONObject.put(ActionCardTable.Columns.IMAGE_URL, str3);
            }
            if (SwrveHelper.isNotNullOrEmpty(str)) {
                jSONObject.put("asset_name", str);
            }
            queueQaLogEvent("sdk", "asset-failed-to-display", jSONObject.toString());
        }
    }

    private void _assetFailedToDownload(String str, String str2, String str3) throws Exception {
        if (this.loggingEnabled) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_name", str);
            jSONObject.put(ActionCardTable.Columns.IMAGE_URL, str2);
            jSONObject.put("reason", str3);
            queueQaLogEvent("sdk", "asset-failed-to-download", jSONObject.toString());
        }
    }

    private void _campaignButtonClicked(int i, int i2, String str, String str2, String str3) throws Exception {
        if (this.loggingEnabled) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SwrveSQLiteOpenHelper.OFFLINE_CAMPAIGNS_COLUMN_CAMPAIGN_ID, i);
            jSONObject.put("variant_id", i2);
            jSONObject.put("button_name", str);
            jSONObject.put("action_type", str2);
            jSONObject.put("action_value", str3);
            queueQaLogEvent("sdk", "campaign-button-clicked", jSONObject.toString());
        }
    }

    private void _campaignTriggered(String str, Map<String, String> map, boolean z, String str2, Map<Integer, QaCampaignInfo> map2) throws Exception {
        JSONObject jSONObject;
        if (this.loggingEnabled) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BoltsMeasurementEventListener.MEASUREMENT_EVENT_NAME_KEY, str);
            if (map != null) {
                jSONObject = new JSONObject(map);
            }
            jSONObject2.put(SwrveNotificationConstants.EVENT_PAYLOAD, jSONObject);
            jSONObject2.put(ISwrveCommon.GENERIC_EVENT_PAYLOAD_DISPLAYED, z);
            jSONObject2.put("reason", str2);
            JSONArray jSONArray = new JSONArray();
            if (map2 != null) {
                for (Map.Entry<Integer, QaCampaignInfo> value : map2.entrySet()) {
                    QaCampaignInfo qaCampaignInfo = (QaCampaignInfo) value.getValue();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", qaCampaignInfo.f2775id);
                    jSONObject3.put("variant_id", qaCampaignInfo.variantId);
                    jSONObject3.put("type", qaCampaignInfo.type);
                    jSONObject3.put(ISwrveCommon.GENERIC_EVENT_PAYLOAD_DISPLAYED, qaCampaignInfo.displayed);
                    jSONObject3.put("reason", qaCampaignInfo.reason);
                    jSONArray.put(jSONObject3);
                }
            }
            jSONObject2.put("campaigns", jSONArray);
            queueQaLogEvent("sdk", "campaign-triggered", jSONObject2.toString());
        }
    }

    private void _campaignsAppRuleTriggered(String str, Map<String, String> map, String str2) throws Exception {
        JSONObject jSONObject;
        if (this.loggingEnabled) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BoltsMeasurementEventListener.MEASUREMENT_EVENT_NAME_KEY, str);
            if (map != null) {
                jSONObject = new JSONObject(map);
            }
            jSONObject2.put(SwrveNotificationConstants.EVENT_PAYLOAD, jSONObject);
            jSONObject2.put(ISwrveCommon.GENERIC_EVENT_PAYLOAD_DISPLAYED, false);
            jSONObject2.put("reason", str2);
            jSONObject2.put("campaigns", new JSONArray());
            queueQaLogEvent("sdk", "campaign-triggered", jSONObject2.toString());
        }
    }

    private void _campaignsDownloaded(List<QaCampaignInfo> list) throws Exception {
        if (this.loggingEnabled) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            for (QaCampaignInfo next : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", next.f2775id);
                jSONObject2.put("variant_id", next.variantId);
                jSONObject2.put("type", next.type);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("campaigns", jSONArray);
            queueQaLogEvent("sdk", "campaigns-downloaded", jSONObject.toString());
        }
    }

    private void _embeddedPersonalizationFailed(int i, int i2, String str, String str2) throws Exception {
        if (this.loggingEnabled) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SwrveSQLiteOpenHelper.OFFLINE_CAMPAIGNS_COLUMN_CAMPAIGN_ID, i);
            jSONObject.put("variant_id", i2);
            jSONObject.put("unresolved_data", str);
            jSONObject.put("reason", str2);
            queueQaLogEvent("sdk", "embedded-personalization-failed", jSONObject.toString());
        }
    }

    public static void assetFailedToDisplay(int i, int i2, String str, String str2, String str3, boolean z, String str4) {
        try {
            getInstance()._assetFailedToDisplay(i, i2, str, str2, str3, z, str4);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue asset-failed-to-display qalogevent.", e, new Object[0]);
        }
    }

    public static void assetFailedToDownload(String str, String str2, String str3) {
        try {
            getInstance()._assetFailedToDownload(str, str2, str3);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue asset-failed-to-download qalogevent.", e, new Object[0]);
        }
    }

    public static void campaignButtonClicked(int i, int i2, String str, String str2, String str3) {
        try {
            getInstance()._campaignButtonClicked(i, i2, str, str2, str3);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue campaign-button-clicked qalogevent.", e, new Object[0]);
        }
    }

    public static void campaignTriggeredConversation(String str, Map<String, String> map, boolean z, Map<Integer, QaCampaignInfo> map2) {
        try {
            getInstance()._campaignTriggered(str, map, z, z ? "" : "The loaded campaigns returned no conversation", map2);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue campaign-triggered qalogevent.", e, new Object[0]);
        }
    }

    public static void campaignTriggeredMessage(String str, Map<String, String> map, boolean z, Map<Integer, QaCampaignInfo> map2) {
        try {
            getInstance()._campaignTriggered(str, map, z, z ? "" : "The loaded campaigns returned no message", map2);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue campaign-triggered qalogevent.", e, new Object[0]);
        }
    }

    public static void campaignTriggeredMessageNoDisplay(String str, Map<String, String> map) {
        try {
            getInstance()._campaignTriggered(str, map, false, "No In App Message triggered because Conversation displayed", new HashMap());
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue campaign-triggered qalogevent.", e, new Object[0]);
        }
    }

    public static void campaignsAppRuleTriggered(String str, Map<String, String> map, String str2) {
        try {
            getInstance()._campaignsAppRuleTriggered(str, map, str2);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue campaign-triggered qalogevent.", e, new Object[0]);
        }
    }

    public static void campaignsDownloaded(List<QaCampaignInfo> list) {
        try {
            getInstance()._campaignsDownloaded(list);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue campaigns-downloaded qalogevent.", e, new Object[0]);
        }
    }

    public static void embeddedPersonalizationFailed(int i, int i2, String str, String str2) {
        try {
            getInstance()._embeddedPersonalizationFailed(i, i2, str, str2);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue embedded-personalization-failed qalogevent.", e, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void flushQaLogQueue() throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.qaLogQueue) {
            if (this.qaLogQueue.size() > 0) {
                long j = 0;
                for (String put : this.qaLogQueue) {
                    long j2 = 1 + j;
                    linkedHashMap.put(Long.valueOf(j), put);
                    j = j2;
                }
                this.qaLogQueue.clear();
            } else {
                this.startFlushLogQueueService = true;
                if (this.flushLogQueueExecutorService != null) {
                    this.flushLogQueueExecutorService.shutdown();
                }
            }
        }
        if (linkedHashMap.size() > 0) {
            executeRestClient(this.endpoint, EventHelper.eventsAsBatch(linkedHashMap, this.userId, this.appVersion, this.sessionToken, this.deviceId));
        }
    }

    public static QaUser getInstance() {
        synchronized (LOCK) {
            if (instance == null) {
                QaUser qaUser = new QaUser();
                instance = qaUser;
                qaUser.init();
            }
        }
        return instance;
    }

    private void init() {
        try {
            ISwrveCommon instance2 = SwrveCommon.getInstance();
            String userId2 = instance2.getUserId();
            this.userId = userId2;
            String cachedData = instance2.getCachedData(userId2, ISwrveCommon.CACHE_QA);
            if (SwrveHelper.isNullOrEmpty(cachedData)) {
                this.loggingEnabled = false;
                this.resetDevice = false;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(cachedData);
                    if (jSONObject.has("logging")) {
                        this.loggingEnabled = jSONObject.optBoolean("logging", false);
                    }
                    if (jSONObject.has("reset_device_state")) {
                        this.resetDevice = jSONObject.optBoolean("reset_device_state", false);
                    }
                } catch (Exception e) {
                    SwrveLogger.m2753e("SwrveSDK problem with decoding qauser json: %s", e, cachedData);
                }
            }
            if (this.loggingEnabled) {
                this.appId = instance2.getAppId();
                this.apiKey = instance2.getApiKey();
                this.endpoint = instance2.getBatchURL();
                this.appVersion = instance2.getAppVersion();
                this.restClientExecutor = Executors.newSingleThreadExecutor();
                this.sessionToken = SwrveHelper.generateSessionToken(this.apiKey, this.appId, this.userId);
                this.deviceId = instance2.getDeviceId();
                scheduleRepeatingQueueFlush(VideoPlayer.FRAME_TIMEOUT);
            } else if (this.flushLogQueueExecutorService != null) {
                this.flushLogQueueExecutorService.shutdown();
            }
        } catch (Exception e2) {
            SwrveLogger.m2753e("Error trying to init QaUser.", e2, new Object[0]);
        }
    }

    public static boolean isLoggingEnabled() {
        try {
            return getInstance().loggingEnabled;
        } catch (Exception e) {
            SwrveLogger.m2753e("Error calling QaUser.isLoggingEnabled", e, new Object[0]);
            return false;
        }
    }

    public static boolean isResetDevice() {
        try {
            return getInstance().resetDevice;
        } catch (Exception e) {
            SwrveLogger.m2753e("Error calling QaUser.isResetDevice", e, new Object[0]);
            return false;
        }
    }

    private void queueQaLogEvent(String str, String str2, String str3) {
        try {
            this.qaLogQueue.add(EventHelper.qaLogEventAsJSON(getTime(), str, str2, str3));
            synchronized (this.qaLogQueue) {
                if (this.startFlushLogQueueService) {
                    scheduleRepeatingQueueFlush(VideoPlayer.FRAME_TIMEOUT);
                    this.startFlushLogQueueService = false;
                }
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue qalogevent.", e, new Object[0]);
        }
    }

    public static void update() {
        try {
            synchronized (LOCK) {
                if (!(instance == null || instance.restClientExecutor == null)) {
                    instance.flushQaLogQueue();
                    instance.restClientExecutor.shutdown();
                    instance.flushLogQueueExecutorService.shutdown();
                }
                QaUser qaUser = new QaUser();
                instance = qaUser;
                qaUser.init();
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Error updating qauser singleton", e, new Object[0]);
        }
    }

    public static void wrappedEvents(List<String> list) {
        try {
            getInstance()._wrappedEvents(list);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to queue wrapped event qalogevent.", e, new Object[0]);
        }
    }

    public void _wrappedEvents(List<String> list) throws Exception {
        String str;
        if (this.loggingEnabled) {
            for (String jSONObject : list) {
                JSONObject jSONObject2 = new JSONObject(jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                if (jSONObject2.has("type")) {
                    jSONObject3.put("type", jSONObject2.getString("type"));
                    jSONObject2.remove("type");
                }
                if (jSONObject2.has(ISwrveCommon.CACHE_SEQNUM)) {
                    jSONObject3.put(ISwrveCommon.CACHE_SEQNUM, jSONObject2.getLong(ISwrveCommon.CACHE_SEQNUM));
                    jSONObject2.remove(ISwrveCommon.CACHE_SEQNUM);
                }
                if (jSONObject2.has("time")) {
                    jSONObject3.put("client_time", jSONObject2.getLong("time"));
                    jSONObject2.remove("time");
                }
                if (jSONObject2.has("payload")) {
                    str = jSONObject2.getJSONObject("payload").toString();
                    jSONObject2.remove("payload");
                } else {
                    str = JsonUtils.EMPTY_JSON;
                }
                jSONObject3.put("payload", str);
                jSONObject3.put("parameters", jSONObject2);
                queueQaLogEvent("sdk", "event", jSONObject3.toString());
            }
        }
    }

    public synchronized void executeRestClient(final String str, final String str2) {
        this.restClientExecutor.execute(new Runnable() {
            public void run() {
                SwrveLogger.m2756v("QaUser request with body:\n %s", str2);
                IRESTClient iRESTClient = QaUser.restClient;
                String str = str;
                iRESTClient.post(str, str2, new RESTResponseListener(str));
            }
        });
    }

    public long getTime() {
        return System.currentTimeMillis();
    }

    public void scheduleRepeatingQueueFlush(long j) {
        try {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
            this.flushLogQueueExecutorService = newScheduledThreadPool;
            newScheduledThreadPool.scheduleAtFixedRate(this.flushLogQueueRunnable, 0, j, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            SwrveLogger.m2753e("Error trying to schedule repeating qalogqueue flush.", e, new Object[0]);
        }
    }
}
