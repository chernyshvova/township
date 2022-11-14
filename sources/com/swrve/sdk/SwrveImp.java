package com.swrve.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.p042db.legacy_profile.tables.ProfileTable;
import com.swrve.sdk.config.SwrveConfigBase;
import com.swrve.sdk.conversations.SwrveConversation;
import com.swrve.sdk.conversations.SwrveConversationListener;
import com.swrve.sdk.device.AndroidTelephonyManagerWrapper;
import com.swrve.sdk.device.ITelephonyManager;
import com.swrve.sdk.localstorage.InMemoryLocalStorage;
import com.swrve.sdk.localstorage.SwrveMultiLayerLocalStorage;
import com.swrve.sdk.messaging.SwrveActionType;
import com.swrve.sdk.messaging.SwrveBaseCampaign;
import com.swrve.sdk.messaging.SwrveBaseMessage;
import com.swrve.sdk.messaging.SwrveButton;
import com.swrve.sdk.messaging.SwrveCampaignState;
import com.swrve.sdk.messaging.SwrveConversationCampaign;
import com.swrve.sdk.messaging.SwrveEmbeddedCampaign;
import com.swrve.sdk.messaging.SwrveEmbeddedMessage;
import com.swrve.sdk.messaging.SwrveEmbeddedMessageListener;
import com.swrve.sdk.messaging.SwrveInAppCampaign;
import com.swrve.sdk.messaging.SwrveMessage;
import com.swrve.sdk.messaging.SwrveMessageFormat;
import com.swrve.sdk.messaging.SwrveMessageListener;
import com.swrve.sdk.messaging.SwrveMessagePersonalizationProvider;
import com.swrve.sdk.messaging.SwrveOrientation;
import com.swrve.sdk.rest.IRESTClient;
import com.swrve.sdk.rest.RESTClient;
import com.vungle.warren.VisionController;
import com.vungle.warren.VungleApiClient;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SwrveImp<T, C extends SwrveConfigBase> implements ISwrveCampaignManager, Application.ActivityLifecycleCallbacks {
    public static final String BATCH_EVENTS_ACTION = "/1/batch";
    public static final int CAMPAIGN_ENDPOINT_VERSION = 9;
    public static final String CAMPAIGN_RESPONSE_VERSION = "2";
    public static int DEFAULT_DELAY_FIRST_MESSAGE = SwipeRefreshLayout.SCALE_DOWN_DURATION;
    public static long DEFAULT_MAX_SHOWS = 99999;
    public static int DEFAULT_MIN_DELAY = 55;
    public static final int EMBEDDED_CAMPAIGN_VERSION = 1;
    public static final String EMPTY_JSON_ARRAY = "[]";
    public static final String IDENTITY_ACTION = "/identify";
    public static final int IN_APP_CAMPAIGN_VERSION = 4;
    public static final String PLATFORM = "Android ";
    public static final String REFERRER = "referrer";
    public static final int SHUTDOWN_TIMEOUT_SECONDS = 5;
    public static final List<String> SUPPORTED_REQUIREMENTS = Arrays.asList(new String[]{"android"});
    public static final String SWRVE_AUTOSHOW_AT_SESSION_START_TRIGGER = "Swrve.Messages.showAtSessionStart";
    public static final int SWRVE_DEFAULT_CAMPAIGN_RESOURCES_FLUSH_FREQUENCY = 60000;
    public static final int SWRVE_DEFAULT_CAMPAIGN_RESOURCES_FLUSH_REFRESH_DELAY = 5000;
    public static final String USER_CONTENT_ACTION = "/api/1/user_content";
    public static final String USER_RESOURCES_DIFF_ACTION = "/api/1/user_resources_diff";
    public static String version = "8.0.0";
    public WeakReference<Activity> activityContext;
    public float androidDeviceXdpi;
    public float androidDeviceYdpi;
    public String androidId;
    public String apiKey;
    public int appId;
    public SparseArray<String> appStoreURLs;
    public String appVersion;
    public WeakReference<Application> application;
    public ExecutorService autoShowExecutor;
    public boolean autoShowMessagesEnabled;
    public SwrveCampaignDisplayer campaignDisplayer;
    public SwrveCampaignInfluence campaignInfluence = new SwrveCampaignInfluence();
    public List<SwrveBaseCampaign> campaigns;
    public ScheduledThreadPoolExecutor campaignsAndResourcesExecutor;
    public Integer campaignsAndResourcesFlushFrequency;
    public Integer campaignsAndResourcesFlushRefreshDelay;
    public boolean campaignsAndResourcesInitialized = false;
    public String campaignsAndResourcesLastETag;
    public Date campaignsAndResourcesLastRefreshed;
    public Map<Integer, SwrveCampaignState> campaignsState;
    public C config;
    public WeakReference<Context> context;
    public SwrveConversationListener conversationListener;
    public float deviceDpi;
    public int deviceHeight;
    public int deviceWidth;
    public SwrveEmbeddedMessageListener embeddedMessageListener;
    public ISwrveEventListener eventListener;
    public boolean eventsWereSent = false;
    public String foregroundActivity = "";
    public boolean identifiedOnAnotherDevice;
    public boolean initialised = false;
    public Date initialisedTime;
    public String language;
    public Map<String, String> lastEventPayloadUsed;
    public long lastSessionTick;
    public ExecutorService lifecycleExecutor;
    public SwrveMessageListener messageListener;
    public SwrveMultiLayerLocalStorage multiLayerLocalStorage;
    public long newSessionInterval;
    public String notificationSwrveCampaignId;
    public List<EventQueueItem> pausedEvents = Collections.synchronizedList(new ArrayList());
    public SwrveMessagePersonalizationProvider personalizationProvider;
    public SwrveProfileManager profileManager;
    public Map<String, String> realTimeUserProperties;
    public SwrveResourceManager resourceManager;
    public SwrveResourcesListener resourcesListener;
    public IRESTClient restClient;
    public ExecutorService restClientExecutor;
    public SwrveSessionListener sessionListener;
    public String simOperatorCode;
    public String simOperatorIsoCountryCode;
    public String simOperatorName;
    public boolean started = false;
    public ExecutorService storageExecutor;
    public SwrveAssetsManager swrveAssetsManager;
    public SwrveDeeplinkManager swrveDeeplinkManager;

    public SwrveImp(Application application2, int i, String str, C c) {
        SwrveLogger.setLoggingEnabled(c.isLoggingEnabled());
        if (i <= 0 || SwrveHelper.isNullOrEmpty(str)) {
            SwrveHelper.logAndThrowException("Please setup a correct appId and apiKey");
        }
        this.appId = i;
        this.apiKey = str;
        this.config = c;
        Context applicationContext = application2.getApplicationContext();
        this.context = new WeakReference<>(applicationContext);
        this.application = new WeakReference<>(application2);
        this.restClient = new RESTClient(c.getHttpTimeout());
        this.swrveAssetsManager = new SwrveAssetsManagerImp(applicationContext);
        this.newSessionInterval = c.getNewSessionInterval();
        this.multiLayerLocalStorage = new SwrveMultiLayerLocalStorage(new InMemoryLocalStorage());
        this.autoShowExecutor = Executors.newSingleThreadExecutor();
        this.storageExecutor = Executors.newSingleThreadExecutor();
        this.restClientExecutor = Executors.newSingleThreadExecutor();
        this.lifecycleExecutor = Executors.newSingleThreadExecutor();
        initProfileManager(applicationContext);
        initAppVersion(applicationContext, c);
        initDefaultUrls(c);
        initLanguage(c);
        registerActivityLifecycleCallbacks();
    }

    private void initAppVersion(Context context2, C c) {
        String appVersion2 = c.getAppVersion();
        this.appVersion = appVersion2;
        if (SwrveHelper.isNullOrEmpty(appVersion2)) {
            try {
                this.appVersion = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
            } catch (Exception e) {
                SwrveLogger.m2753e("Couldn't get app version from PackageManager. Please provide the app version manually through the config object.", e, new Object[0]);
            }
        }
    }

    private void initDefaultUrls(C c) {
        try {
            c.generateUrls(this.appId);
        } catch (MalformedURLException e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Couldn't generate urls for appId:");
            outline24.append(this.appId);
            SwrveLogger.m2753e(outline24.toString(), e, new Object[0]);
        }
    }

    private void initLanguage(C c) {
        if (SwrveHelper.isNullOrEmpty(c.getLanguage())) {
            this.language = SwrveHelper.toLanguageTag(Locale.getDefault());
        } else {
            this.language = c.getLanguage();
        }
    }

    private void initProfileManager(Context context2) {
        this.profileManager = new SwrveProfileManager(context2, this.appId, this.apiKey, this.config, this.restClient);
        lifecycleExecutorExecute(new Runnable() {
            public final void run() {
                SwrveImp.this.lambda$initProfileManager$0$SwrveImp();
            }
        });
    }

    public static /* synthetic */ void lambda$checkForCampaignAndResourcesUpdates$13(SwrveBase swrveBase, ScheduledExecutorService scheduledExecutorService) {
        try {
            swrveBase.refreshCampaignsAndResources();
        } finally {
            scheduledExecutorService.shutdownNow();
        }
    }

    public static /* synthetic */ void lambda$null$10(String str, SwrveBase swrveBase, String str2) {
        SwrveLogger.m2755i("Sending device info for userId:%s", str);
        swrveBase._sendQueuedEvents(str, str2, true);
    }

    private void loadCampaignsStateFromCache() {
        try {
            String cacheEntry = this.multiLayerLocalStorage.getCacheEntry(this.profileManager.getUserId(), ISwrveCommon.CACHE_CAMPAIGNS_STATE);
            if (!SwrveHelper.isNullOrEmpty(cacheEntry)) {
                JSONObject jSONObject = new JSONObject(cacheEntry);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        int parseInt = Integer.parseInt(next);
                        this.campaignsState.put(Integer.valueOf(parseInt), new SwrveCampaignState(jSONObject.getJSONObject(next)));
                    } catch (Exception e) {
                        SwrveLogger.m2753e("Could not load state for campaign " + next, e, new Object[0]);
                    }
                }
            }
        } catch (JSONException e2) {
            SwrveLogger.m2753e("Could not load state of campaigns, bad JSON", e2, new Object[0]);
        }
    }

    public static Map<String, String> processRealTimeUserProperties(Map<String, String> map) {
        if (SwrveHelper.isNullOrEmpty(map)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : map.keySet()) {
            hashMap.put(GeneratedOutlineSupport.outline16("user.", next), map.get(next));
        }
        return hashMap;
    }

    private boolean shouldAutostart() {
        if (this.config.getInitMode() == SwrveInitMode.AUTO && this.config.isAutoStartLastUser()) {
            return true;
        }
        if (this.config.getInitMode() != SwrveInitMode.MANAGED || !this.config.isAutoStartLastUser() || this.profileManager.getSavedUserIdFromPrefs() == null) {
            return false;
        }
        return true;
    }

    private boolean supportsDeviceFilter(String str) {
        return SUPPORTED_REQUIREMENTS.contains(str.toLowerCase(Locale.ENGLISH));
    }

    private void updateCdnPaths(JSONObject jSONObject) throws JSONException {
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

    public void _iap(int i, String str, double d, String str2, SwrveIAPRewards swrveIAPRewards, String str3, String str4, String str5) {
        if (_iap_check_parameters(i, str, d, str2, str5)) {
            String str6 = str2;
            HashMap outline28 = GeneratedOutlineSupport.outline28("local_currency", str2);
            outline28.put("cost", Double.valueOf(d));
            String str7 = str;
            outline28.put("product_id", str);
            outline28.put(FirebaseAnalytics.Param.QUANTITY, Integer.valueOf(i));
            outline28.put("app_store", str5);
            outline28.put("rewards", swrveIAPRewards.getRewardsJSON());
            if (!SwrveHelper.isNullOrEmpty(str3)) {
                String str8 = str3;
                outline28.put("receipt", str3);
            }
            if (!SwrveHelper.isNullOrEmpty(str4)) {
                outline28.put("receipt_signature", str4);
            }
            queueEvent("iap", outline28, (Map<String, String>) null);
            if (this.config.isAutoDownloadCampaignsAndResources()) {
                startCampaignsAndResourcesTimer(false);
            }
        }
    }

    public boolean _iap_check_parameters(int i, String str, double d, String str2, String str3) throws IllegalArgumentException {
        if (SwrveHelper.isNullOrEmpty(str)) {
            SwrveLogger.m2754e("IAP event illegal argument: productId cannot be empty", new Object[0]);
            return false;
        } else if (SwrveHelper.isNullOrEmpty(str2)) {
            SwrveLogger.m2754e("IAP event illegal argument: currency cannot be empty", new Object[0]);
            return false;
        } else if (SwrveHelper.isNullOrEmpty(str3)) {
            SwrveLogger.m2754e("IAP event illegal argument: paymentProvider cannot be empty", new Object[0]);
            return false;
        } else if (i <= 0) {
            SwrveLogger.m2754e("IAP event illegal argument: quantity must be greater than zero", new Object[0]);
            return false;
        } else if (d >= RoundRectDrawableWithShadow.COS_45) {
            return true;
        } else {
            SwrveLogger.m2754e("IAP event illegal argument: productPrice must be greater than or equal to zero", new Object[0]);
            return false;
        }
    }

    public void autoShowConversation(SwrveBase<T, C> swrveBase) {
        SwrveConversation conversationForEvent;
        try {
            if (this.conversationListener != null && this.autoShowMessagesEnabled && (conversationForEvent = swrveBase.getConversationForEvent(SWRVE_AUTOSHOW_AT_SESSION_START_TRIGGER, new HashMap())) != null) {
                this.conversationListener.onMessage(conversationForEvent);
                this.autoShowMessagesEnabled = false;
                QaUser.campaignTriggeredMessageNoDisplay(SWRVE_AUTOSHOW_AT_SESSION_START_TRIGGER, (Map<String, String>) null);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Could not launch conversation automatically.", e, new Object[0]);
        }
    }

    public void autoShowMessage(SwrveBase<T, C> swrveBase) {
        SwrveBaseMessage baseMessageForEvent;
        try {
            if (this.autoShowMessagesEnabled && this.messageListener != null && (baseMessageForEvent = swrveBase.getBaseMessageForEvent(SWRVE_AUTOSHOW_AT_SESSION_START_TRIGGER)) != null && baseMessageForEvent.supportsOrientation(getDeviceOrientation())) {
                if (baseMessageForEvent instanceof SwrveMessage) {
                    this.messageListener.onMessage((SwrveMessage) baseMessageForEvent);
                } else if (this.embeddedMessageListener != null && (baseMessageForEvent instanceof SwrveEmbeddedMessage)) {
                    this.embeddedMessageListener.onMessage(swrveBase.getContext(), (SwrveEmbeddedMessage) baseMessageForEvent, retrievePersonalizationProperties((Map<String, String>) null, (Map<String, String>) null));
                }
                this.autoShowMessagesEnabled = false;
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Could not launch campaign automatically.", e, new Object[0]);
        }
    }

    /* renamed from: autoShowMessages */
    public void lambda$downloadAssets$7$SwrveImp() {
        Activity activity;
        if (this.autoShowMessagesEnabled && this.campaignsAndResourcesInitialized && this.campaigns != null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (SwrveBaseCampaign canTrigger : this.campaigns) {
                SwrveBase swrveBase = (SwrveBase) this;
                if (this.campaignDisplayer.canTrigger(canTrigger, SWRVE_AUTOSHOW_AT_SESSION_START_TRIGGER, hashMap2, hashMap)) {
                    synchronized (this) {
                        if (!(!this.autoShowMessagesEnabled || this.activityContext == null || (activity = (Activity) this.activityContext.get()) == null)) {
                            activity.runOnUiThread(new Runnable(swrveBase) {
                                public final /* synthetic */ SwrveBase f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    SwrveImp.this.lambda$autoShowMessages$5$SwrveImp(this.f$1);
                                }
                            });
                        }
                    }
                    return;
                }
            }
        }
    }

    public void bindToActivity(Activity activity) {
        this.context = new WeakReference<>(activity.getApplicationContext());
        this.activityContext = new WeakReference<>(activity);
    }

    public void buildDeviceInfo(Context context2) {
        try {
            Display defaultDisplay = ((WindowManager) context2.getSystemService(VisionController.WINDOW)).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int displayWidth = SwrveHelper.getDisplayWidth(context2);
            int displayHeight = SwrveHelper.getDisplayHeight(context2);
            defaultDisplay.getMetrics(displayMetrics);
            float f = displayMetrics.xdpi;
            float f2 = displayMetrics.ydpi;
            if (displayWidth > displayHeight) {
                float f3 = f2;
                f2 = f;
                f = f3;
                int i = displayHeight;
                displayHeight = displayWidth;
                displayWidth = i;
            }
            this.deviceWidth = displayWidth;
            this.deviceHeight = displayHeight;
            this.deviceDpi = (float) displayMetrics.densityDpi;
            this.androidDeviceXdpi = f;
            this.androidDeviceYdpi = f2;
            ITelephonyManager telephonyManager = getTelephonyManager(context2);
            this.simOperatorName = telephonyManager.getSimOperatorName();
            this.simOperatorIsoCountryCode = telephonyManager.getSimCountryIso();
            this.simOperatorCode = telephonyManager.getSimOperator();
            if (this.config.isAndroidIdLoggingEnabled()) {
                this.androidId = Settings.Secure.getString(context2.getContentResolver(), VungleApiClient.ANDROID_ID);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Get device screen info failed", e, new Object[0]);
        }
    }

    /* renamed from: checkForCampaignAndResourcesUpdates */
    public void lambda$startCampaignsAndResourcesTimer$14$SwrveImp() {
        if (this.initialisedTime == null) {
            SwrveLogger.m2758w("Not executing checkForCampaignAndResourcesUpdates because initialisedTime is null indicating the sdk is not initialised.", new Object[0]);
            return;
        }
        String userId = this.profileManager.getUserId();
        String sessionToken = this.profileManager.getSessionToken();
        boolean hasQueuedEvents = this.multiLayerLocalStorage.hasQueuedEvents(userId);
        if (hasQueuedEvents || this.eventsWereSent) {
            SwrveLogger.m2752d("SwrveSDK events recently queued or sent, so sending and executing a delayed refresh of campaigns", new Object[0]);
            SwrveBase swrveBase = (SwrveBase) this;
            if (hasQueuedEvents) {
                swrveBase._sendQueuedEvents(userId, sessionToken, false);
            }
            this.eventsWereSent = false;
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            newSingleThreadScheduledExecutor.schedule(new Runnable(newSingleThreadScheduledExecutor) {
                public final /* synthetic */ ScheduledExecutorService f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SwrveImp.lambda$checkForCampaignAndResourcesUpdates$13(SwrveBase.this, this.f$1);
                }
            }, this.campaignsAndResourcesFlushRefreshDelay.longValue(), TimeUnit.MILLISECONDS);
        }
    }

    public boolean checkPermissionGranted(Context context2, String str) {
        return ContextCompat.checkSelfPermission(context2, str) == 0;
    }

    public void deviceUpdate(String str, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("attributes", jSONObject);
            queueEvent(str, "device_update", hashMap, (Map<String, String>) null, true);
        }
    }

    public void disableAutoShowAfterDelay() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        newSingleThreadScheduledExecutor.schedule(new Runnable(newSingleThreadScheduledExecutor) {
            public final /* synthetic */ ScheduledExecutorService f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SwrveImp.this.lambda$disableAutoShowAfterDelay$6$SwrveImp(this.f$1);
            }
        }, this.config.getInAppMessageConfig().getAutoShowMessagesMaxDelay(), TimeUnit.MILLISECONDS);
    }

    public void downloadAssets(Set<SwrveAssetsQueueItem> set) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            newSingleThreadExecutor.execute(SwrveRunnables.withoutExceptions(new Runnable(set, new SwrveAssetsCompleteCallback() {
                public final void complete() {
                    SwrveImp.this.lambda$downloadAssets$7$SwrveImp();
                }
            }) {
                public final /* synthetic */ Set f$1;
                public final /* synthetic */ SwrveAssetsCompleteCallback f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SwrveImp.this.lambda$downloadAssets$8$SwrveImp(this.f$1, this.f$2);
                }
            }));
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }

    public Boolean filterCampaignCapabilityRequest(SwrveInAppCampaign swrveInAppCampaign) {
        SwrveMessage message = swrveInAppCampaign.getMessage();
        if (message != null) {
            for (SwrveMessageFormat buttons : message.getFormats()) {
                Iterator<SwrveButton> it = buttons.getButtons().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (SwrveActionType.RequestCapabilty.equals(it.next().getActionType())) {
                            return Boolean.TRUE;
                        }
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    public void generateNewSessionInterval() {
        this.lastSessionTick = getSessionTime() + this.newSessionInterval;
    }

    @Nullable
    public Activity getActivityContext() {
        WeakReference<Activity> weakReference = this.activityContext;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (Activity) this.activityContext.get();
    }

    public Set<String> getAssetsOnDisk() {
        SwrveAssetsManager swrveAssetsManager2 = this.swrveAssetsManager;
        return swrveAssetsManager2 == null ? new HashSet() : swrveAssetsManager2.getAssetsOnDisk();
    }

    public Context getContext() {
        Context context2 = (Context) this.context.get();
        return context2 == null ? getActivityContext() : context2;
    }

    public String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        return GeneratedOutlineSupport.outline17(str, " ", str2);
    }

    public SwrveOrientation getDeviceOrientation() {
        Context context2 = (Context) this.context.get();
        if (context2 != null) {
            return SwrveOrientation.parse(context2.getResources().getConfiguration().orientation);
        }
        return SwrveOrientation.Both;
    }

    public Date getNow() {
        return new Date();
    }

    public long getSessionTime() {
        return getNow().getTime();
    }

    public ITelephonyManager getTelephonyManager(Context context2) {
        return new AndroidTelephonyManagerWrapper(context2);
    }

    public String getUniqueKey(String str) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(str);
        outline24.append(this.apiKey);
        return outline24.toString();
    }

    public void initABTestDetails(String str) {
        JSONObject optJSONObject;
        if (this.config.isABTestDetailsEnabled()) {
            try {
                String secureCacheEntryForUser = this.multiLayerLocalStorage.getSecureCacheEntryForUser(str, ISwrveCommon.CACHE_CAMPAIGNS, getUniqueKey(str));
                if (!SwrveHelper.isNullOrEmpty(secureCacheEntryForUser) && (optJSONObject = new JSONObject(secureCacheEntryForUser).optJSONObject("ab_test_details")) != null) {
                    this.resourceManager.setABTestDetailsFromJSON(optJSONObject);
                }
            } catch (JSONException e) {
                SwrveLogger.m2753e("Invalid json in cache, cannot load ab test information", e, new Object[0]);
            } catch (SecurityException e2) {
                SwrveLogger.m2753e("Signature validation failed when trying to load ab test information from cache.", e2, new Object[0]);
            }
        }
    }

    public void initCampaigns(String str) {
        this.campaigns = new ArrayList();
        this.campaignDisplayer = new SwrveCampaignDisplayer();
        this.campaignsState = new HashMap();
        try {
            String secureCacheEntryForUser = this.multiLayerLocalStorage.getSecureCacheEntryForUser(str, ISwrveCommon.CACHE_CAMPAIGNS, getUniqueKey(str));
            if (!SwrveHelper.isNullOrEmpty(secureCacheEntryForUser)) {
                JSONObject jSONObject = new JSONObject(secureCacheEntryForUser);
                loadCampaignsStateFromCache();
                loadCampaignsFromJSON(str, jSONObject, this.campaignsState, !QaUser.isResetDevice());
                SwrveLogger.m2755i("Loaded campaigns from cache.", new Object[0]);
                return;
            }
            invalidateETag(str);
        } catch (JSONException e) {
            invalidateETag(str);
            SwrveLogger.m2753e("Invalid json in cache, cannot load campaigns", e, new Object[0]);
        } catch (SecurityException e2) {
            invalidateETag(str);
            SwrveLogger.m2753e("Signature validation failed when trying to load campaigns from cache.", e2, new Object[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("name", "Swrve.signature_invalid");
            queueEvent(str, "event", hashMap, (Map<String, String>) null, false);
        }
    }

    public void initRealTimeUserProperties(String str) {
        this.realTimeUserProperties = new HashMap();
        try {
            String secureCacheEntryForUser = this.multiLayerLocalStorage.getSecureCacheEntryForUser(str, ISwrveCommon.CACHE_REALTIME_USER_PROPERTIES, getUniqueKey(str));
            if (!SwrveHelper.isNullOrEmpty(secureCacheEntryForUser)) {
                JSONObject jSONObject = new JSONObject(secureCacheEntryForUser);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        this.realTimeUserProperties.put(next, jSONObject.getString(next));
                    } catch (Exception e) {
                        SwrveLogger.m2753e("Could not load realtime user property for key: " + next, e, new Object[0]);
                    }
                }
            }
            SwrveLogger.m2755i("Loaded realtime user properties from cache.", new Object[0]);
        } catch (JSONException e2) {
            SwrveLogger.m2753e("Could not load real time user properties, bad JSON", e2, new Object[0]);
        }
    }

    public void initResources(String str) {
        String str2;
        try {
            str2 = this.multiLayerLocalStorage.getSecureCacheEntryForUser(str, ISwrveCommon.CACHE_RESOURCES, getUniqueKey(str));
        } catch (SecurityException unused) {
            invalidateETag(str);
            SwrveLogger.m2755i("Signature for %s invalid; could not retrieve data from cache", ISwrveCommon.CACHE_RESOURCES);
            HashMap hashMap = new HashMap();
            hashMap.put("name", "Swrve.signature_invalid");
            queueEvent(str, "event", hashMap, (Map<String, String>) null, false);
            str2 = null;
        }
        if (str2 != null) {
            try {
                this.resourceManager.setResourcesFromJSON(new JSONArray(str2));
            } catch (JSONException e) {
                SwrveLogger.m2753e("Could not parse cached json content for resources", e, new Object[0]);
            }
        } else {
            invalidateETag(str);
        }
    }

    public void invalidateETag(String str) {
        this.multiLayerLocalStorage.setCacheEntry(str, ISwrveCommon.CACHE_ETAG, "");
    }

    public void invokeResourceListener() {
        if (this.resourcesListener != null) {
            Activity activityContext2 = getActivityContext();
            if (activityContext2 != null) {
                activityContext2.runOnUiThread(new Runnable() {
                    public final void run() {
                        SwrveImp.this.lambda$invokeResourceListener$12$SwrveImp();
                    }
                });
            } else {
                this.resourcesListener.onResourcesUpdated();
            }
        }
    }

    public /* synthetic */ void lambda$autoShowMessages$5$SwrveImp(SwrveBase swrveBase) {
        autoShowConversation(swrveBase);
        autoShowMessage(swrveBase);
    }

    public /* synthetic */ void lambda$disableAutoShowAfterDelay$6$SwrveImp(ScheduledExecutorService scheduledExecutorService) {
        try {
            this.autoShowMessagesEnabled = false;
        } finally {
            scheduledExecutorService.shutdownNow();
        }
    }

    public /* synthetic */ void lambda$downloadAssets$8$SwrveImp(Set set, SwrveAssetsCompleteCallback swrveAssetsCompleteCallback) {
        this.swrveAssetsManager.downloadAssets(set, swrveAssetsCompleteCallback);
    }

    public /* synthetic */ void lambda$initProfileManager$0$SwrveImp() {
        this.profileManager.initUserId();
        this.profileManager.initTrackingState();
        if (this.profileManager.getTrackingState() == SwrveTrackingState.STOPPED) {
            SwrveLogger.m2755i("SwrveSDK is currently in stopped state and will not start until an api is called.", new Object[0]);
        } else if (shouldAutostart()) {
            this.profileManager.persistUser();
            if (this.profileManager.getTrackingState() == SwrveTrackingState.UNKNOWN) {
                this.profileManager.setTrackingState(SwrveTrackingState.STARTED);
            }
            this.started = true;
        }
    }

    public /* synthetic */ void lambda$invokeResourceListener$12$SwrveImp() {
        this.resourcesListener.onResourcesUpdated();
    }

    public /* synthetic */ void lambda$queueDeviceUpdateNow$11$SwrveImp(String str, SwrveBase swrveBase, boolean z, String str2) {
        try {
            deviceUpdate(str, swrveBase._getDeviceInfo());
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception queuing device update.", e, new Object[0]);
        }
        if (z) {
            storageExecutorExecute(new Runnable(str, swrveBase, str2) {
                public final /* synthetic */ String f$0;
                public final /* synthetic */ SwrveBase f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SwrveImp.lambda$null$10(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$saveCampaignsInCache$1$SwrveImp(String str, JSONObject jSONObject) {
        this.multiLayerLocalStorage.setAndFlushSecureSharedEntryForUser(str, ISwrveCommon.CACHE_CAMPAIGNS, jSONObject.toString(), getUniqueKey(str));
    }

    public /* synthetic */ void lambda$saveCampaignsState$9$SwrveImp(String str, String str2) {
        this.multiLayerLocalStorage.setCacheEntry(str, ISwrveCommon.CACHE_CAMPAIGNS_STATE, str2);
        SwrveLogger.m2755i("Saved and flushed campaign state in cache", new Object[0]);
    }

    public /* synthetic */ void lambda$saveRealTimeUserPropertiesInCache$3$SwrveImp(String str, JSONObject jSONObject) {
        this.multiLayerLocalStorage.setAndFlushSecureSharedEntryForUser(str, ISwrveCommon.CACHE_REALTIME_USER_PROPERTIES, jSONObject.toString(), getUniqueKey(str));
    }

    public /* synthetic */ void lambda$saveResourcesInCache$2$SwrveImp(String str, JSONArray jSONArray) {
        this.multiLayerLocalStorage.setAndFlushSecureSharedEntryForUser(str, ISwrveCommon.CACHE_RESOURCES, jSONArray.toString(), getUniqueKey(str));
    }

    public /* synthetic */ void lambda$updateQaUser$4$SwrveImp(String str, String str2) {
        this.multiLayerLocalStorage.setAndFlushSecureSharedEntryForUser(str, ISwrveCommon.CACHE_QA, str2, getUniqueKey(str));
        QaUser.update();
    }

    public boolean lifecycleExecutorExecute(Runnable runnable) {
        try {
            if (this.lifecycleExecutor.isShutdown()) {
                SwrveLogger.m2755i("Trying to handle a lifecycle execution while shutdown", new Object[0]);
                return false;
            }
            this.lifecycleExecutor.execute(SwrveRunnables.withoutExceptions(runnable));
            return true;
        } catch (Exception e) {
            SwrveLogger.m2753e("Error while scheduling a lifecycle execution", e, new Object[0]);
        }
    }

    public SwrveInAppCampaign loadCampaignFromJSON(JSONObject jSONObject, Set<SwrveAssetsQueueItem> set, Map<String, String> map) throws JSONException {
        return new SwrveInAppCampaign(this, this.campaignDisplayer, jSONObject, set, map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: com.swrve.sdk.messaging.SwrveConversationCampaign} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: com.swrve.sdk.messaging.SwrveEmbeddedCampaign} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: com.swrve.sdk.messaging.SwrveConversationCampaign} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: com.swrve.sdk.messaging.SwrveConversationCampaign} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: com.swrve.sdk.messaging.SwrveEmbeddedCampaign} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: com.swrve.sdk.messaging.SwrveInAppCampaign} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: com.swrve.sdk.messaging.SwrveEmbeddedCampaign} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: com.swrve.sdk.messaging.SwrveEmbeddedCampaign} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: com.swrve.sdk.messaging.SwrveConversationCampaign} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0204 A[SYNTHETIC, Splitter:B:90:0x0204] */
    @android.annotation.SuppressLint({"UseSparseArrays"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadCampaignsFromJSON(java.lang.String r23, org.json.JSONObject r24, java.util.Map<java.lang.Integer, com.swrve.sdk.messaging.SwrveCampaignState> r25, boolean r26) {
        /*
            r22 = this;
            r1 = r22
            r0 = r24
            java.lang.String r2 = "filters"
            java.lang.String r3 = "min_delay_between_messages"
            java.lang.String r4 = "app_store_url"
            java.lang.String r5 = "max_messages_per_session"
            java.lang.String r6 = "delay_first_message"
            java.lang.String r7 = "2"
            java.lang.String r8 = "version"
            r9 = 0
            if (r0 != 0) goto L_0x001d
            java.lang.Object[] r0 = new java.lang.Object[r9]
            java.lang.String r2 = "NULL JSON for campaigns, aborting load."
            com.swrve.sdk.SwrveLogger.m2755i(r2, r0)
            return
        L_0x001d:
            int r10 = r24.length()
            if (r10 != 0) goto L_0x0030
            java.lang.Object[] r0 = new java.lang.Object[r9]
            java.lang.String r2 = "Campaign JSON empty, no campaigns downloaded"
            com.swrve.sdk.SwrveLogger.m2755i(r2, r0)
            java.util.List<com.swrve.sdk.messaging.SwrveBaseCampaign> r0 = r1.campaigns
            r0.clear()
            return
        L_0x0030:
            r10 = 1
            java.lang.Object[] r11 = new java.lang.Object[r10]
            r11[r9] = r0
            java.lang.String r12 = "Campaign JSON data: %s"
            com.swrve.sdk.SwrveLogger.m2755i(r12, r11)
            boolean r11 = r0.has(r8)     // Catch:{ JSONException -> 0x02fd }
            if (r11 != 0) goto L_0x0041
            return
        L_0x0041:
            java.lang.String r8 = r0.getString(r8)     // Catch:{ JSONException -> 0x02fd }
            boolean r11 = r8.equals(r7)     // Catch:{ JSONException -> 0x02fd }
            r12 = 2
            if (r11 != 0) goto L_0x0058
            java.lang.String r0 = "Campaign JSON (%s) has the wrong version for this sdk (%s). No campaigns loaded."
            java.lang.Object[] r2 = new java.lang.Object[r12]     // Catch:{ JSONException -> 0x02fd }
            r2[r9] = r8     // Catch:{ JSONException -> 0x02fd }
            r2[r10] = r7     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveLogger.m2755i(r0, r2)     // Catch:{ JSONException -> 0x02fd }
            return
        L_0x0058:
            r1.updateCdnPaths(r0)     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r7 = "game_data"
            org.json.JSONObject r7 = r0.getJSONObject(r7)     // Catch:{ JSONException -> 0x02fd }
            if (r7 == 0) goto L_0x00a6
            java.util.Iterator r8 = r7.keys()     // Catch:{ JSONException -> 0x02fd }
        L_0x0067:
            boolean r11 = r8.hasNext()     // Catch:{ JSONException -> 0x02fd }
            if (r11 == 0) goto L_0x00a6
            java.lang.Object r11 = r8.next()     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x02fd }
            org.json.JSONObject r13 = r7.getJSONObject(r11)     // Catch:{ JSONException -> 0x02fd }
            boolean r14 = r13.has(r4)     // Catch:{ JSONException -> 0x02fd }
            if (r14 == 0) goto L_0x0067
            java.lang.String r13 = r13.getString(r4)     // Catch:{ JSONException -> 0x02fd }
            android.util.SparseArray<java.lang.String> r14 = r1.appStoreURLs     // Catch:{ JSONException -> 0x02fd }
            int r15 = java.lang.Integer.parseInt(r11)     // Catch:{ JSONException -> 0x02fd }
            r14.put(r15, r13)     // Catch:{ JSONException -> 0x02fd }
            boolean r14 = com.swrve.sdk.SwrveHelper.isNullOrEmpty((java.lang.String) r13)     // Catch:{ JSONException -> 0x02fd }
            if (r14 == 0) goto L_0x009a
            java.lang.String r13 = "App store link %s is empty!"
            java.lang.Object[] r14 = new java.lang.Object[r10]     // Catch:{ JSONException -> 0x02fd }
            r14[r9] = r11     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveLogger.m2754e(r13, r14)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x0067
        L_0x009a:
            java.lang.String r14 = "App store Link %s: %s"
            java.lang.Object[] r15 = new java.lang.Object[r12]     // Catch:{ JSONException -> 0x02fd }
            r15[r9] = r11     // Catch:{ JSONException -> 0x02fd }
            r15[r10] = r13     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveLogger.m2755i(r14, r15)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x0067
        L_0x00a6:
            java.lang.String r4 = "rules"
            org.json.JSONObject r4 = r0.getJSONObject(r4)     // Catch:{ JSONException -> 0x02fd }
            boolean r7 = r4.has(r6)     // Catch:{ JSONException -> 0x02fd }
            if (r7 == 0) goto L_0x00b7
            int r6 = r4.getInt(r6)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x00b9
        L_0x00b7:
            int r6 = DEFAULT_DELAY_FIRST_MESSAGE     // Catch:{ JSONException -> 0x02fd }
        L_0x00b9:
            boolean r7 = r4.has(r5)     // Catch:{ JSONException -> 0x02fd }
            if (r7 == 0) goto L_0x00c4
            long r7 = r4.getLong(r5)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x00c6
        L_0x00c4:
            long r7 = DEFAULT_MAX_SHOWS     // Catch:{ JSONException -> 0x02fd }
        L_0x00c6:
            boolean r5 = r4.has(r3)     // Catch:{ JSONException -> 0x02fd }
            if (r5 == 0) goto L_0x00d1
            int r3 = r4.getInt(r3)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x00d3
        L_0x00d1:
            int r3 = DEFAULT_MIN_DELAY     // Catch:{ JSONException -> 0x02fd }
        L_0x00d3:
            java.util.Date r4 = r22.getNow()     // Catch:{ JSONException -> 0x02fd }
            java.util.Date r5 = r1.initialisedTime     // Catch:{ JSONException -> 0x02fd }
            r11 = 13
            java.util.Date r5 = com.swrve.sdk.SwrveHelper.addTimeInterval(r5, r6, r11)     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveCampaignDisplayer r11 = r1.campaignDisplayer     // Catch:{ JSONException -> 0x02fd }
            r11.setShowMessagesAfterLaunch(r5)     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveCampaignDisplayer r11 = r1.campaignDisplayer     // Catch:{ JSONException -> 0x02fd }
            r11.setMinDelayBetweenMessage(r3)     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveCampaignDisplayer r3 = r1.campaignDisplayer     // Catch:{ JSONException -> 0x02fd }
            r3.setMessagesLeftToShow(r7)     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r3 = "App rules OK: Delay Seconds: %s Max shows: %s"
            java.lang.Object[] r11 = new java.lang.Object[r12]     // Catch:{ JSONException -> 0x02fd }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ JSONException -> 0x02fd }
            r11[r9] = r6     // Catch:{ JSONException -> 0x02fd }
            java.lang.Long r6 = java.lang.Long.valueOf(r7)     // Catch:{ JSONException -> 0x02fd }
            r11[r10] = r6     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveLogger.m2755i(r3, r11)     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r3 = "Time is %s show messages after %s"
            java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x02fd }
            r6[r9] = r4     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x02fd }
            r6[r10] = r4     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveLogger.m2755i(r3, r6)     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r3 = "campaigns"
            org.json.JSONArray r0 = r0.getJSONArray(r3)     // Catch:{ JSONException -> 0x02fd }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ JSONException -> 0x02fd }
            r3.<init>()     // Catch:{ JSONException -> 0x02fd }
            r22.saveCampaignsState(r23)     // Catch:{ JSONException -> 0x02fd }
            int r4 = r0.length()     // Catch:{ JSONException -> 0x02fd }
            r5 = 0
        L_0x0127:
            if (r5 >= r4) goto L_0x013d
            org.json.JSONObject r6 = r0.getJSONObject(r5)     // Catch:{ JSONException -> 0x02fd }
            java.lang.String r7 = "id"
            int r6 = r6.getInt(r7)     // Catch:{ JSONException -> 0x02fd }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ JSONException -> 0x02fd }
            r3.add(r6)     // Catch:{ JSONException -> 0x02fd }
            int r5 = r5 + 1
            goto L_0x0127
        L_0x013d:
            java.util.List<com.swrve.sdk.messaging.SwrveBaseCampaign> r4 = r1.campaigns     // Catch:{ JSONException -> 0x02fd }
            int r4 = r4.size()     // Catch:{ JSONException -> 0x02fd }
            int r4 = r4 - r10
        L_0x0144:
            if (r4 < 0) goto L_0x0164
            java.util.List<com.swrve.sdk.messaging.SwrveBaseCampaign> r5 = r1.campaigns     // Catch:{ JSONException -> 0x02fd }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.messaging.SwrveBaseCampaign r5 = (com.swrve.sdk.messaging.SwrveBaseCampaign) r5     // Catch:{ JSONException -> 0x02fd }
            int r5 = r5.getId()     // Catch:{ JSONException -> 0x02fd }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x02fd }
            boolean r5 = r3.contains(r5)     // Catch:{ JSONException -> 0x02fd }
            if (r5 != 0) goto L_0x0161
            java.util.List<com.swrve.sdk.messaging.SwrveBaseCampaign> r5 = r1.campaigns     // Catch:{ JSONException -> 0x02fd }
            r5.remove(r4)     // Catch:{ JSONException -> 0x02fd }
        L_0x0161:
            int r4 = r4 + -1
            goto L_0x0144
        L_0x0164:
            r3 = 0
            java.util.Map r4 = r1.retrievePersonalizationProperties(r3, r3)     // Catch:{ JSONException -> 0x02fd }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ JSONException -> 0x02fd }
            r5.<init>()     // Catch:{ JSONException -> 0x02fd }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ JSONException -> 0x02fd }
            r6.<init>()     // Catch:{ JSONException -> 0x02fd }
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ JSONException -> 0x02fd }
            r7.<init>()     // Catch:{ JSONException -> 0x02fd }
            int r8 = r0.length()     // Catch:{ JSONException -> 0x02fd }
            r11 = 0
        L_0x017d:
            if (r11 >= r8) goto L_0x02e9
            org.json.JSONObject r12 = r0.getJSONObject(r11)     // Catch:{ JSONException -> 0x02f9 }
            java.util.HashSet r13 = new java.util.HashSet     // Catch:{ JSONException -> 0x02f9 }
            r13.<init>()     // Catch:{ JSONException -> 0x02f9 }
            boolean r14 = r12.has(r2)     // Catch:{ JSONException -> 0x02f9 }
            if (r14 == 0) goto L_0x01ac
            org.json.JSONArray r14 = r12.getJSONArray(r2)     // Catch:{ JSONException -> 0x02fd }
            r17 = r3
            r15 = 0
            r16 = 1
        L_0x0197:
            int r3 = r14.length()     // Catch:{ JSONException -> 0x02fd }
            if (r15 >= r3) goto L_0x01b0
            if (r16 == 0) goto L_0x01b0
            java.lang.String r3 = r14.getString(r15)     // Catch:{ JSONException -> 0x02fd }
            boolean r16 = r1.supportsDeviceFilter(r3)     // Catch:{ JSONException -> 0x02fd }
            int r15 = r15 + 1
            r17 = r3
            goto L_0x0197
        L_0x01ac:
            r16 = 1
            r17 = 0
        L_0x01b0:
            if (r16 == 0) goto L_0x02cf
            java.lang.String r3 = "conversation"
            boolean r3 = r12.has(r3)     // Catch:{ JSONException -> 0x02f9 }
            if (r3 == 0) goto L_0x01d6
            java.lang.String r3 = "conversation_version"
            int r3 = r12.optInt(r3, r10)     // Catch:{ JSONException -> 0x02fd }
            r14 = 4
            if (r3 > r14) goto L_0x01c8
            com.swrve.sdk.messaging.SwrveConversationCampaign r3 = r1.loadConversationCampaignFromJSON(r12, r7)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x0202
        L_0x01c8:
            java.lang.String r12 = "Conversation version %s cannot be loaded with this SDK version"
            java.lang.Object[] r14 = new java.lang.Object[r10]     // Catch:{ JSONException -> 0x02fd }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ JSONException -> 0x02fd }
            r14[r9] = r3     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveLogger.m2755i(r12, r14)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x0201
        L_0x01d6:
            java.lang.String r3 = "message"
            boolean r3 = r12.has(r3)     // Catch:{ JSONException -> 0x02f9 }
            if (r3 == 0) goto L_0x01f4
            com.swrve.sdk.messaging.SwrveInAppCampaign r3 = r1.loadCampaignFromJSON(r12, r13, r4)     // Catch:{ JSONException -> 0x02fd }
            java.lang.Boolean r12 = r1.filterCampaignCapabilityRequest(r3)     // Catch:{ JSONException -> 0x02fd }
            boolean r12 = r12.booleanValue()     // Catch:{ JSONException -> 0x02fd }
            if (r12 == 0) goto L_0x0202
            java.lang.String r3 = "Campaign with capability request is currently not supported"
            java.lang.Object[] r12 = new java.lang.Object[r9]     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.SwrveLogger.m2755i(r3, r12)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x0201
        L_0x01f4:
            java.lang.String r3 = "embedded_message"
            boolean r3 = r12.has(r3)     // Catch:{ JSONException -> 0x02f9 }
            if (r3 == 0) goto L_0x0201
            com.swrve.sdk.messaging.SwrveEmbeddedCampaign r3 = r1.loadEmbeddedCampaignFromJSON(r12)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x0202
        L_0x0201:
            r3 = 0
        L_0x0202:
            if (r3 == 0) goto L_0x02ca
            r7.addAll(r13)     // Catch:{ JSONException -> 0x02f9 }
            if (r26 == 0) goto L_0x021f
            int r12 = r3.getId()     // Catch:{ JSONException -> 0x02fd }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ JSONException -> 0x02fd }
            r13 = r25
            java.lang.Object r12 = r13.get(r12)     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.messaging.SwrveCampaignState r12 = (com.swrve.sdk.messaging.SwrveCampaignState) r12     // Catch:{ JSONException -> 0x02fd }
            if (r12 == 0) goto L_0x0221
            r3.setSaveableState(r12)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x0221
        L_0x021f:
            r13 = r25
        L_0x0221:
            r6.add(r3)     // Catch:{ JSONException -> 0x02f9 }
            java.util.Map<java.lang.Integer, com.swrve.sdk.messaging.SwrveCampaignState> r12 = r1.campaignsState     // Catch:{ JSONException -> 0x02f9 }
            int r14 = r3.getId()     // Catch:{ JSONException -> 0x02f9 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ JSONException -> 0x02f9 }
            com.swrve.sdk.messaging.SwrveCampaignState r15 = r3.getSaveableState()     // Catch:{ JSONException -> 0x02f9 }
            r12.put(r14, r15)     // Catch:{ JSONException -> 0x02f9 }
            java.lang.String r12 = "Got campaign with id %s"
            java.lang.Object[] r14 = new java.lang.Object[r10]     // Catch:{ JSONException -> 0x02f9 }
            int r15 = r3.getId()     // Catch:{ JSONException -> 0x02f9 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ JSONException -> 0x02f9 }
            r14[r9] = r15     // Catch:{ JSONException -> 0x02f9 }
            com.swrve.sdk.SwrveLogger.m2755i(r12, r14)     // Catch:{ JSONException -> 0x02f9 }
            boolean r12 = com.swrve.sdk.QaUser.isLoggingEnabled()     // Catch:{ JSONException -> 0x02f9 }
            if (r12 == 0) goto L_0x02ca
            boolean r12 = r3 instanceof com.swrve.sdk.messaging.SwrveConversationCampaign     // Catch:{ JSONException -> 0x02f9 }
            if (r12 == 0) goto L_0x0277
            r12 = r3
            com.swrve.sdk.messaging.SwrveConversationCampaign r12 = (com.swrve.sdk.messaging.SwrveConversationCampaign) r12     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.conversations.SwrveConversation r12 = r12.getConversation()     // Catch:{ JSONException -> 0x02fd }
            int r12 = r12.getId()     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.QaCampaignInfo r15 = new com.swrve.sdk.QaCampaignInfo     // Catch:{ JSONException -> 0x02fd }
            int r14 = r3.getId()     // Catch:{ JSONException -> 0x02fd }
            long r9 = (long) r14     // Catch:{ JSONException -> 0x02fd }
            long r12 = (long) r12     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.QaCampaignInfo$CAMPAIGN_TYPE r19 = r3.getCampaignType()     // Catch:{ JSONException -> 0x02fd }
            r20 = 0
            java.lang.String r21 = ""
            r14 = r15
            r3 = r15
            r15 = r9
            r17 = r12
            r14.<init>(r15, r17, r19, r20, r21)     // Catch:{ JSONException -> 0x02fd }
            r5.add(r3)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x02ca
        L_0x0277:
            boolean r9 = r3 instanceof com.swrve.sdk.messaging.SwrveInAppCampaign     // Catch:{ JSONException -> 0x02f9 }
            if (r9 == 0) goto L_0x029d
            r9 = r3
            com.swrve.sdk.messaging.SwrveInAppCampaign r9 = (com.swrve.sdk.messaging.SwrveInAppCampaign) r9     // Catch:{ JSONException -> 0x02fd }
            int r9 = r9.getVariantId()     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.QaCampaignInfo r10 = new com.swrve.sdk.QaCampaignInfo     // Catch:{ JSONException -> 0x02fd }
            int r12 = r3.getId()     // Catch:{ JSONException -> 0x02fd }
            long r13 = (long) r12     // Catch:{ JSONException -> 0x02fd }
            r24 = r8
            long r8 = (long) r9     // Catch:{ JSONException -> 0x02fd }
            com.swrve.sdk.QaCampaignInfo$CAMPAIGN_TYPE r17 = r3.getCampaignType()     // Catch:{ JSONException -> 0x02fd }
            r18 = 0
            java.lang.String r19 = ""
            r12 = r10
            r15 = r8
            r12.<init>(r13, r15, r17, r18, r19)     // Catch:{ JSONException -> 0x02fd }
            r5.add(r10)     // Catch:{ JSONException -> 0x02fd }
            goto L_0x02c8
        L_0x029d:
            r24 = r8
            boolean r8 = r3 instanceof com.swrve.sdk.messaging.SwrveEmbeddedCampaign     // Catch:{ JSONException -> 0x02f9 }
            if (r8 == 0) goto L_0x02c8
            r8 = r3
            com.swrve.sdk.messaging.SwrveEmbeddedCampaign r8 = (com.swrve.sdk.messaging.SwrveEmbeddedCampaign) r8     // Catch:{ JSONException -> 0x02f9 }
            com.swrve.sdk.messaging.SwrveEmbeddedMessage r8 = r8.getMessage()     // Catch:{ JSONException -> 0x02f9 }
            int r8 = r8.getId()     // Catch:{ JSONException -> 0x02f9 }
            com.swrve.sdk.QaCampaignInfo r9 = new com.swrve.sdk.QaCampaignInfo     // Catch:{ JSONException -> 0x02f9 }
            int r10 = r3.getId()     // Catch:{ JSONException -> 0x02f9 }
            long r13 = (long) r10     // Catch:{ JSONException -> 0x02f9 }
            r10 = r0
            long r0 = (long) r8     // Catch:{ JSONException -> 0x02f9 }
            com.swrve.sdk.QaCampaignInfo$CAMPAIGN_TYPE r17 = r3.getCampaignType()     // Catch:{ JSONException -> 0x02f9 }
            r18 = 0
            java.lang.String r19 = ""
            r12 = r9
            r15 = r0
            r12.<init>(r13, r15, r17, r18, r19)     // Catch:{ JSONException -> 0x02f9 }
            r5.add(r9)     // Catch:{ JSONException -> 0x02f9 }
            goto L_0x02cd
        L_0x02c8:
            r10 = r0
            goto L_0x02cd
        L_0x02ca:
            r10 = r0
            r24 = r8
        L_0x02cd:
            r1 = 1
            goto L_0x02dd
        L_0x02cf:
            r10 = r0
            r24 = r8
            java.lang.String r0 = "Not all requirements were satisfied for this campaign: %s"
            r1 = 1
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ JSONException -> 0x02f9 }
            r8 = 0
            r3[r8] = r17     // Catch:{ JSONException -> 0x02f9 }
            com.swrve.sdk.SwrveLogger.m2755i(r0, r3)     // Catch:{ JSONException -> 0x02f9 }
        L_0x02dd:
            int r11 = r11 + 1
            r3 = 0
            r1 = r22
            r8 = r24
            r0 = r10
            r9 = 0
            r10 = 1
            goto L_0x017d
        L_0x02e9:
            com.swrve.sdk.QaUser.campaignsDownloaded(r5)     // Catch:{ JSONException -> 0x02f9 }
            r1 = r22
            r1.downloadAssets(r7)     // Catch:{ JSONException -> 0x02fd }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x02fd }
            r0.<init>(r6)     // Catch:{ JSONException -> 0x02fd }
            r1.campaigns = r0     // Catch:{ JSONException -> 0x02fd }
            goto L_0x0306
        L_0x02f9:
            r0 = move-exception
            r1 = r22
            goto L_0x02fe
        L_0x02fd:
            r0 = move-exception
        L_0x02fe:
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "Error parsing campaign JSON"
            com.swrve.sdk.SwrveLogger.m2753e(r3, r0, r2)
        L_0x0306:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveImp.loadCampaignsFromJSON(java.lang.String, org.json.JSONObject, java.util.Map, boolean):void");
    }

    public SwrveConversationCampaign loadConversationCampaignFromJSON(JSONObject jSONObject, Set<SwrveAssetsQueueItem> set) throws JSONException {
        return new SwrveConversationCampaign(this, this.campaignDisplayer, jSONObject, set);
    }

    public SwrveEmbeddedCampaign loadEmbeddedCampaignFromJSON(JSONObject jSONObject) throws JSONException {
        return new SwrveEmbeddedCampaign(this, this.campaignDisplayer, jSONObject);
    }

    public void processUserResourcesDiffData(String str, SwrveUserResourcesDiffListener swrveUserResourcesDiffListener) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                HashMap hashMap3 = new HashMap();
                HashMap hashMap4 = new HashMap();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(ProfileTable.Columns.COLUMN_UID);
                JSONObject jSONObject2 = jSONObject.getJSONObject("diff");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap3.put(next, jSONObject2.getJSONObject(next).getString("old"));
                    hashMap4.put(next, jSONObject2.getJSONObject(next).getString("new"));
                }
                hashMap.put(string, hashMap3);
                hashMap2.put(string, hashMap4);
            }
            swrveUserResourcesDiffListener.onUserResourcesDiffSuccess(hashMap, hashMap2, str);
        } catch (Exception e) {
            swrveUserResourcesDiffListener.onUserResourcesDiffError(e);
        }
    }

    public void queueDeviceUpdateNow(String str, String str2, boolean z) {
        storageExecutorExecute(new Runnable(str, (SwrveBase) this, z, str2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ SwrveBase f$2;
            public final /* synthetic */ boolean f$3;
            public final /* synthetic */ String f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                SwrveImp.this.lambda$queueDeviceUpdateNow$11$SwrveImp(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        });
    }

    public void queueEvent(String str, Map<String, Object> map, Map<String, String> map2) {
        queueEvent(this.profileManager.getUserId(), str, map, map2, true);
    }

    public void registerActivityLifecycleCallbacks() {
        Application application2 = (Application) this.application.get();
        if (application2 != null) {
            application2.registerActivityLifecycleCallbacks(this);
            SwrveLogger.m2755i("SwrveSDK registered ActivityLifecycleCallbacks.", new Object[0]);
        }
    }

    public void requestPermissions(Activity activity, String[] strArr) {
        ActivityCompat.requestPermissions(activity, strArr, 0);
    }

    public boolean restClientExecutorExecute(Runnable runnable) {
        try {
            if (this.restClientExecutor.isShutdown()) {
                SwrveLogger.m2755i("Trying to handle a rest execution while shutdown", new Object[0]);
                return false;
            }
            this.restClientExecutor.execute(SwrveRunnables.withoutExceptions(runnable));
            return true;
        } catch (Exception e) {
            SwrveLogger.m2753e("Error while scheduling a rest execution", e, new Object[0]);
        }
    }

    public Map<String, String> retrievePersonalizationProperties(Map<String, String> map, Map<String, String> map2) {
        Map<String, String> processRealTimeUserProperties = processRealTimeUserProperties(this.realTimeUserProperties);
        if (this.personalizationProvider == null || !SwrveHelper.isNullOrEmpty(map2)) {
            return !SwrveHelper.isNullOrEmpty(map2) ? SwrveHelper.combineTwoStringMaps(processRealTimeUserProperties, map2) : processRealTimeUserProperties;
        }
        return SwrveHelper.combineTwoStringMaps(processRealTimeUserProperties, this.personalizationProvider.personalize(map));
    }

    public void saveCampaignsInCache(JSONObject jSONObject) {
        storageExecutorExecute(new Runnable(this.profileManager.getUserId(), jSONObject) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ JSONObject f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                SwrveImp.this.lambda$saveCampaignsInCache$1$SwrveImp(this.f$1, this.f$2);
            }
        });
    }

    public void saveCampaignsState(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.campaignsState != null) {
                for (Integer intValue : this.campaignsState.keySet()) {
                    int intValue2 = intValue.intValue();
                    jSONObject.put(String.valueOf(intValue2), this.campaignsState.get(Integer.valueOf(intValue2)).toJSON());
                }
            }
            storageExecutorExecute(new Runnable(str, jSONObject.toString()) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SwrveImp.this.lambda$saveCampaignsState$9$SwrveImp(this.f$1, this.f$2);
                }
            });
        } catch (JSONException e) {
            SwrveLogger.m2753e("Error saving campaigns settings", e, new Object[0]);
        }
    }

    public void saveRealTimeUserPropertiesInCache(JSONObject jSONObject) {
        storageExecutorExecute(new Runnable(this.profileManager.getUserId(), jSONObject) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ JSONObject f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                SwrveImp.this.lambda$saveRealTimeUserPropertiesInCache$3$SwrveImp(this.f$1, this.f$2);
            }
        });
    }

    public void saveResourcesInCache(JSONArray jSONArray) {
        storageExecutorExecute(new Runnable(this.profileManager.getUserId(), jSONArray) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ JSONArray f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                SwrveImp.this.lambda$saveResourcesInCache$2$SwrveImp(this.f$1, this.f$2);
            }
        });
    }

    public void shutdownCampaignsAndResourcesTimer() {
        if (this.campaignsAndResourcesExecutor != null) {
            SwrveLogger.m2752d("SwrveSDK shutting down campaigns refresh timer.", new Object[0]);
            try {
                this.campaignsAndResourcesExecutor.shutdown();
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception occurred shutting down campaignsAndResourcesExecutor", e, new Object[0]);
            }
            this.campaignsAndResourcesExecutor = null;
        }
    }

    public void startCampaignsAndResourcesTimer(boolean z) {
        if (this.config.isAutoDownloadCampaignsAndResources() && this.initialised) {
            if (this.campaignsAndResourcesExecutor != null) {
                SwrveLogger.m2752d("SwrveSDK not creating a new timer for refreshing campaigns because there is already an existing one.", new Object[0]);
                return;
            }
            if (z) {
                SwrveLogger.m2752d("SwrveSDK sessionstart is true so executing an immediate refresh of campaigns before starting a delayed timer for refreshing campaigns.", new Object[0]);
                ((SwrveBase) this).refreshCampaignsAndResources();
                this.eventsWereSent = true;
            }
            SwrveLogger.m2752d("SwrveSDK starting repeating delayed timer for refreshing campaigns.", new Object[0]);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() {
                public final void run() {
                    SwrveImp.this.lambda$startCampaignsAndResourcesTimer$14$SwrveImp();
                }
            }, 0, this.campaignsAndResourcesFlushFrequency.longValue(), TimeUnit.MILLISECONDS);
            this.campaignsAndResourcesExecutor = scheduledThreadPoolExecutor;
        }
    }

    public boolean storageExecutorExecute(Runnable runnable) {
        try {
            if (this.storageExecutor.isShutdown()) {
                SwrveLogger.m2755i("Trying to handle a storage execution while shutdown", new Object[0]);
                return false;
            }
            this.storageExecutor.execute(SwrveRunnables.withoutExceptions(runnable));
            return true;
        } catch (Exception e) {
            SwrveLogger.m2753e("Error while scheduling a storage execution", e, new Object[0]);
        }
    }

    public void unregisterActivityLifecycleCallbacks() {
        Application application2 = (Application) this.application.get();
        if (application2 != null) {
            application2.unregisterActivityLifecycleCallbacks(this);
            SwrveLogger.m2755i("SwrveSDK unregistered ActivityLifecycleCallbacks.", new Object[0]);
        }
    }

    public void updateQaUser(String str) {
        storageExecutorExecute(new Runnable(this.profileManager.getUserId(), str) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                SwrveImp.this.lambda$updateQaUser$4$SwrveImp(this.f$1, this.f$2);
            }
        });
    }

    public boolean queueEvent(String str, String str2, Map<String, Object> map, Map<String, String> map2, boolean z) {
        if (this.profileManager.getTrackingState() == SwrveTrackingState.EVENT_SENDING_PAUSED) {
            SwrveLogger.m2752d("SwrveSDK event sending paused so attempt to queue events has failed. Will auto retry when event sending resumes.", new Object[0]);
            this.pausedEvents.add(new EventQueueItem(str, str2, map, map2, z));
            return false;
        }
        try {
            storageExecutorExecute(new QueueEventRunnable(this.multiLayerLocalStorage, str, str2, map, map2));
            if (!z || this.eventListener == null) {
                return true;
            }
            this.eventListener.onEvent(EventHelper.getEventName(str2, map), map2);
            return true;
        } catch (Exception e) {
            SwrveLogger.m2753e("Unable to queue event", e, new Object[0]);
            return true;
        }
    }
}
