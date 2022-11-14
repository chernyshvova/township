package com.swrve.sdk;

import android.app.NotificationChannel;
import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public interface ISwrveCommon {
    public static final String BATCH_EVENT_KEY_APP_VERSION = "app_version";
    public static final String BATCH_EVENT_KEY_DATA = "data";
    public static final String BATCH_EVENT_KEY_SESSION_TOKEN = "session_token";
    public static final String BATCH_EVENT_KEY_UNIQUE_DEVICE_ID = "unique_device_id";
    public static final String BATCH_EVENT_KEY_USER = "user";
    public static final String BATCH_EVENT_KEY_VERSION = "version";
    public static final String CACHE_AD_CAMPAIGNS_DEBUG = "AdCampaign";
    public static final String CACHE_CAMPAIGNS = "CMCC2";
    public static final String CACHE_CAMPAIGNS_STATE = "SwrveCampaignSettings";
    public static final String CACHE_DEVICE_ID = "device_id";
    public static final String CACHE_DEVICE_PROP_KEY = "";
    public static final String CACHE_ETAG = "swrve.etag";
    public static final String CACHE_NOTIFICATION_CAMPAIGNS_DEBUG = "NotificationCampaign";
    public static final String CACHE_QA = "swrve.q1";
    public static final String CACHE_REALTIME_USER_PROPERTIES = "cmrp2s";
    public static final String CACHE_RESOURCES = "srcngt2";
    public static final String CACHE_RESOURCES_DIFF = "rsdfngt2";
    public static final String CACHE_SEQNUM = "seqnum";
    public static final String CACHE_USER_JOINED_TIME = "SwrveSDK.userJoinedTime";
    public static final String DEVICE_TYPE_MOBILE = "mobile";
    public static final String DEVICE_TYPE_TV = "tv";
    public static final String EVENT_FIRST_SESSION = "Swrve.first_session";
    public static final String EVENT_ID_KEY = "id";
    public static final String EVENT_PAYLOAD_KEY = "payload";
    public static final String EVENT_TYPE_GENERIC_CAMPAIGN = "generic_campaign_event";
    public static final String EVENT_TYPE_KEY = "type";
    public static final String GENERIC_EVENT_ACTION_TYPE_BUTTON_CLICK = "button_click";
    public static final String GENERIC_EVENT_ACTION_TYPE_DELIVERED = "delivered";
    public static final String GENERIC_EVENT_ACTION_TYPE_ENGAGED = "engaged";
    public static final String GENERIC_EVENT_ACTION_TYPE_IMPRESSION = "impression";
    public static final String GENERIC_EVENT_ACTION_TYPE_INFLUENCED = "influenced";
    public static final String GENERIC_EVENT_ACTION_TYPE_KEY = "actionType";
    public static final String GENERIC_EVENT_CAMPAIGN_ID_KEY = "campaignId";
    public static final String GENERIC_EVENT_CAMPAIGN_TYPE_GEO = "geo";
    public static final String GENERIC_EVENT_CAMPAIGN_TYPE_KEY = "campaignType";
    public static final String GENERIC_EVENT_CAMPAIGN_TYPE_PUSH = "push";
    public static final String GENERIC_EVENT_CONTEXT_ID_KEY = "contextId";
    public static final String GENERIC_EVENT_PAYLOAD_BUTTON_TEXT = "buttonText";
    public static final String GENERIC_EVENT_PAYLOAD_DISPLAYED = "displayed";
    public static final String GENERIC_EVENT_PAYLOAD_REASON = "reason";
    public static final String GENERIC_EVENT_PAYLOAD_RUN_NUMBER = "runNumber";
    public static final String GENERIC_EVENT_PAYLOAD_SILENT = "silent";
    public static final String OS_AMAZON = "amazon-android";
    public static final String OS_AMAZON_TV = "amazon-android-tv";
    public static final String OS_ANDROID = "android";
    public static final String OS_ANDROID_TV = "android-tv";
    public static final String OS_HUAWEI = "huawei-android";
    public static final String SDK_PREFS_KEY_FLUSH_DELAY = "swrve_cr_flush_delay";
    public static final String SDK_PREFS_KEY_FLUSH_FREQ = "swrve_cr_flush_frequency";
    public static final String SDK_PREFS_KEY_TRACKING_STATE = "trackingState";
    public static final String SDK_PREFS_KEY_USER_ID = "userId";
    public static final String SDK_PREFS_NAME = "swrve_prefs";
    public static final String SDK_PREFS_REFERRER_ID = "swrve.referrer_id";
    public static final String SWRVE_ANDROID_DEVICE_XDPI = "swrve.android_device_xdpi";
    public static final String SWRVE_ANDROID_DEVICE_YDPI = "swrve.android_device_ydpi";
    public static final String SWRVE_ANDROID_ID = "swrve.android_id";
    public static final String SWRVE_APP_STORE = "swrve.app_store";
    public static final String SWRVE_CAN_RECEIVE_AUTH_PUSH = "swrve.can_receive_authenticated_push";
    public static final String SWRVE_CONVERSATION_VERSION = "swrve.conversation_version";
    public static final String SWRVE_DEVICE_DPI = "swrve.device_dpi";
    public static final String SWRVE_DEVICE_HEIGHT = "swrve.device_height";
    public static final String SWRVE_DEVICE_NAME = "swrve.device_name";
    public static final String SWRVE_DEVICE_REGION = "swrve.device_region";
    public static final String SWRVE_DEVICE_TYPE = "swrve.device_type";
    public static final String SWRVE_DEVICE_WIDTH = "swrve.device_width";
    public static final String SWRVE_INIT_MODE = "swrve.sdk_init_mode";
    public static final String SWRVE_INSTALL_DATE = "swrve.install_date";
    public static final String SWRVE_LANGUAGE = "swrve.language";
    public static final String SWRVE_NOTIFICATIONS_ATTACHMENT = "swrve.support.rich_attachment";
    public static final String SWRVE_NOTIFICATIONS_BUTTONS = "swrve.support.rich_buttons";
    public static final String SWRVE_NOTIFICATIONS_ENABLED = "swrve.permission.notifications_enabled";
    public static final String SWRVE_NOTIFICATIONS_IMPORTANCE = "swrve.permission.notifications_importance";
    public static final String SWRVE_OS = "swrve.os";
    public static final String SWRVE_OS_VERSION = "swrve.os_version";
    public static final String SWRVE_REFERRER_ID = "swrve.referrer_id";
    public static final String SWRVE_SDK_FLAVOUR = "swrve.sdk_flavour";
    public static final String SWRVE_SDK_VERSION = "swrve.sdk_version";
    public static final String SWRVE_SIM_OPERATOR_CODE = "swrve.sim_operator.code";
    public static final String SWRVE_SIM_OPERATOR_ISO_COUNTRY = "swrve.sim_operator.iso_country_code";
    public static final String SWRVE_SIM_OPERATOR_NAME = "swrve.sim_operator.name";
    public static final String SWRVE_TIMEZONE_NAME = "swrve.timezone_name";
    public static final String SWRVE_TRACKING_STATE = "swrve.tracking_state";
    public static final String SWRVE_UTC_OFFSET_SECONDS = "swrve.utc_offset_seconds";

    public enum SupportedUIMode {
        MOBILE,
        TV
    }

    void fetchNotificationCampaigns(Set<Long> set);

    String getApiKey();

    int getAppId();

    String getAppVersion();

    String getBatchURL();

    File getCacheDir(Context context);

    String getCachedData(String str, String str2);

    String getContentURL();

    NotificationChannel getDefaultNotificationChannel();

    String getDeviceId();

    JSONObject getDeviceInfo() throws JSONException;

    String getEventsServer();

    int getFlushRefreshDelay();

    int getHttpTimeout();

    String getJoined();

    String getLanguage();

    int getNextSequenceNumber();

    SwrveNotificationConfig getNotificationConfig();

    SwrvePushNotificationListener getNotificationListener();

    String getSessionKey();

    SwrveSilentPushListener getSilentPushListener();

    String getSwrveSDKVersion();

    String getUniqueKey(String str);

    String getUserId();

    boolean isTrackingStateStopped();

    void saveEvent(String str);

    void saveNotificationAuthenticated(int i);

    void sendEventsInBackground(Context context, String str, ArrayList<String> arrayList);

    void setNotificationSwrveCampaignId(String str);

    void setSessionListener(SwrveSessionListener swrveSessionListener);

    void userUpdate(Map<String, String> map);
}
