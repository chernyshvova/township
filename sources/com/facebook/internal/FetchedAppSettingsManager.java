package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FetchedAppSettings;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FetchedAppSettingsManager.kt */
public final class FetchedAppSettingsManager {
    public static final String APPLICATION_FIELDS = "fields";
    public static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    public static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    public static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
    public static final String APP_SETTING_APP_EVENTS_AAM_RULE = "aam_rules";
    public static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";
    public static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
    public static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
    public static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    public static final List<String> APP_SETTING_FIELDS = CollectionsKt__CollectionsKt.listOf(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_DIALOG_CONFIGS, APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES, APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, APP_SETTING_APP_EVENTS_FEATURE_BITMASK, APP_SETTING_APP_EVENTS_EVENT_BINDINGS, APP_SETTING_SMART_LOGIN_OPTIONS, SMART_LOGIN_BOOKMARK_ICON_URL, SMART_LOGIN_MENU_ICON_URL, APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD, APP_SETTING_APP_EVENTS_AAM_RULE, SUGGESTED_EVENTS_SETTING);
    public static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    public static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    public static final String APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD = "restrictive_data_filter_params";
    public static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
    public static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    public static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
    public static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 32;
    public static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;
    public static final FetchedAppSettingsManager INSTANCE = new FetchedAppSettingsManager();
    public static final int MONITOR_ENABLED_BITMASK_FIELD = 16384;
    public static final String SDK_UPDATE_MESSAGE = "sdk_update_message";
    public static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
    public static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
    public static final String SUGGESTED_EVENTS_SETTING = "suggested_events_setting";
    public static final String TAG;
    public static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 256;
    public static final Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    public static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue<>();
    public static boolean isUnityInit;
    public static final AtomicReference<FetchAppSettingState> loadingState = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);
    public static boolean printedSDKUpdatedMessage;
    public static JSONArray unityEventBindings;

    /* compiled from: FetchedAppSettingsManager.kt */
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    /* compiled from: FetchedAppSettingsManager.kt */
    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    static {
        String simpleName = FetchedAppSettingsManager.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "FetchedAppSettingsManager::class.java.simpleName");
        TAG = simpleName;
    }

    public static final void getAppSettingsAsync(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        Intrinsics.checkNotNullParameter(fetchedAppSettingsCallback, "callback");
        fetchedAppSettingsCallbacks.add(fetchedAppSettingsCallback);
        loadAppSettingsAsync();
    }

    private final JSONObject getAppSettingsQueryResponse(String str) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(APP_SETTING_FIELDS);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "app", (GraphRequest.Callback) null);
        newGraphPathRequest.setForceApplicationRequest(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        return jsonObject == null ? new JSONObject() : jsonObject;
    }

    public static final FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        if (str != null) {
            return fetchedAppSettings.get(str);
        }
        return null;
    }

    public static final void loadAppSettingsAsync() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            INSTANCE.pollCallbacks();
        } else if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
        } else {
            if (!(loadingState.compareAndSet(FetchAppSettingState.NOT_LOADED, FetchAppSettingState.LOADING) || loadingState.compareAndSet(FetchAppSettingState.ERROR, FetchAppSettingState.LOADING))) {
                INSTANCE.pollCallbacks();
                return;
            }
            String outline21 = GeneratedOutlineSupport.outline21(new Object[]{applicationId}, 1, APP_SETTINGS_PREFS_KEY_FORMAT, "java.lang.String.format(format, *args)");
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable(applicationContext, outline21, applicationId) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    FetchedAppSettingsManager.m3617loadAppSettingsAsync$lambda0(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    /* renamed from: loadAppSettingsAsync$lambda-0  reason: not valid java name */
    public static final void m3617loadAppSettingsAsync$lambda0(Context context, String str, String str2) {
        FetchAppSettingState fetchAppSettingState;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "$settingsKey");
        Intrinsics.checkNotNullParameter(str2, "$applicationId");
        SharedPreferences sharedPreferences = context.getSharedPreferences(APP_SETTINGS_PREFS_STORE, 0);
        FetchedAppSettings fetchedAppSettings2 = null;
        String string = sharedPreferences.getString(str, (String) null);
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string)) {
            if (string != null) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.logd(Utility.LOG_TAG, (Exception) e);
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    fetchedAppSettings2 = INSTANCE.parseAppSettingsFromJSON$facebook_core_release(str2, jSONObject);
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        JSONObject appSettingsQueryResponse = INSTANCE.getAppSettingsQueryResponse(str2);
        if (appSettingsQueryResponse != null) {
            INSTANCE.parseAppSettingsFromJSON$facebook_core_release(str2, appSettingsQueryResponse);
            sharedPreferences.edit().putString(str, appSettingsQueryResponse.toString()).apply();
        }
        if (fetchedAppSettings2 != null) {
            String sdkUpdateMessage = fetchedAppSettings2.getSdkUpdateMessage();
            if (!printedSDKUpdatedMessage && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                printedSDKUpdatedMessage = true;
                Log.w(TAG, sdkUpdateMessage);
            }
        }
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        FetchedAppGateKeepersManager.queryAppGateKeepers(str2, true);
        AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
        AutomaticAnalyticsLogger.logActivateAppEvent();
        AtomicReference<FetchAppSettingState> atomicReference = loadingState;
        if (fetchedAppSettings.containsKey(str2)) {
            fetchAppSettingState = FetchAppSettingState.SUCCESS;
        } else {
            fetchAppSettingState = FetchAppSettingState.ERROR;
        }
        atomicReference.set(fetchAppSettingState);
        INSTANCE.pollCallbacks();
    }

    private final Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            int i = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    FetchedAppSettings.DialogFeatureConfig.Companion companion = FetchedAppSettings.DialogFeatureConfig.Companion;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "dialogConfigData.optJSONObject(i)");
                    FetchedAppSettings.DialogFeatureConfig parseDialogConfig = companion.parseDialogConfig(optJSONObject);
                    if (parseDialogConfig != null) {
                        String dialogName = parseDialogConfig.getDialogName();
                        Map map = (Map) hashMap.get(dialogName);
                        if (map == null) {
                            map = new HashMap();
                            hashMap.put(dialogName, map);
                        }
                        map.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void pollCallbacks() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicReference<com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState> r0 = loadingState     // Catch:{ all -> 0x0065 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState) r0     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r1 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.NOT_LOADED     // Catch:{ all -> 0x0065 }
            if (r1 == r0) goto L_0x0063
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r1 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.LOADING     // Catch:{ all -> 0x0065 }
            if (r1 != r0) goto L_0x0012
            goto L_0x0063
        L_0x0012:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0065 }
            java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch:{ all -> 0x0065 }
            java.util.Map<java.lang.String, com.facebook.internal.FetchedAppSettings> r2 = fetchedAppSettings     // Catch:{ all -> 0x0065 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettings r1 = (com.facebook.internal.FetchedAppSettings) r1     // Catch:{ all -> 0x0065 }
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x0065 }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0065 }
            r2.<init>(r3)     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r3 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.ERROR     // Catch:{ all -> 0x0065 }
            if (r3 != r0) goto L_0x0048
        L_0x002d:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0065 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0046
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0065 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback) r0     // Catch:{ all -> 0x0065 }
            com.facebook.internal.-$$Lambda$uQT6TldPL3gwFdZiEmqolV_6Gyc r1 = new com.facebook.internal.-$$Lambda$uQT6TldPL3gwFdZiEmqolV_6Gyc     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            r2.post(r1)     // Catch:{ all -> 0x0065 }
            goto L_0x002d
        L_0x0046:
            monitor-exit(r4)
            return
        L_0x0048:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0065 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0061
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0065 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback) r0     // Catch:{ all -> 0x0065 }
            com.facebook.internal.-$$Lambda$g7wm_6qBdcfxFx1P0VEhJxOu3AI r3 = new com.facebook.internal.-$$Lambda$g7wm_6qBdcfxFx1P0VEhJxOu3AI     // Catch:{ all -> 0x0065 }
            r3.<init>(r1)     // Catch:{ all -> 0x0065 }
            r2.post(r3)     // Catch:{ all -> 0x0065 }
            goto L_0x0048
        L_0x0061:
            monitor-exit(r4)
            return
        L_0x0063:
            monitor-exit(r4)
            return
        L_0x0065:
            r0 = move-exception
            monitor-exit(r4)
            goto L_0x0069
        L_0x0068:
            throw r0
        L_0x0069:
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppSettingsManager.pollCallbacks():void");
    }

    /* renamed from: pollCallbacks$lambda-1  reason: not valid java name */
    public static final void m3618pollCallbacks$lambda1(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        fetchedAppSettingsCallback.onError();
    }

    /* renamed from: pollCallbacks$lambda-2  reason: not valid java name */
    public static final void m3619pollCallbacks$lambda2(FetchedAppSettingsCallback fetchedAppSettingsCallback, FetchedAppSettings fetchedAppSettings2) {
        fetchedAppSettingsCallback.onSuccess(fetchedAppSettings2);
    }

    public static final FetchedAppSettings queryAppSettings(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        if (!z && fetchedAppSettings.containsKey(str)) {
            return fetchedAppSettings.get(str);
        }
        JSONObject appSettingsQueryResponse = INSTANCE.getAppSettingsQueryResponse(str);
        if (appSettingsQueryResponse == null) {
            return null;
        }
        FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release = INSTANCE.parseAppSettingsFromJSON$facebook_core_release(str, appSettingsQueryResponse);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (Intrinsics.areEqual(str, FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
        }
        return parseAppSettingsFromJSON$facebook_core_release;
    }

    public static final void setIsUnityInit(boolean z) {
        isUnityInit = z;
        if (unityEventBindings != null && z) {
            UnityReflection unityReflection = UnityReflection.INSTANCE;
            UnityReflection.sendEventMapping(String.valueOf(unityEventBindings));
        }
    }

    public final FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(jSONObject2, "settingsJSON");
        FacebookRequestErrorClassification createFromJSON = FacebookRequestErrorClassification.Companion.createFromJSON(jSONObject2.optJSONArray(APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES));
        if (createFromJSON == null) {
            createFromJSON = FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification = createFromJSON;
        int optInt = jSONObject2.optInt(APP_SETTING_APP_EVENTS_FEATURE_BITMASK, 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        boolean z5 = (optInt & 16384) != 0;
        JSONArray optJSONArray = jSONObject2.optJSONArray(APP_SETTING_APP_EVENTS_EVENT_BINDINGS);
        unityEventBindings = optJSONArray;
        if (optJSONArray != null) {
            InternalSettings internalSettings = InternalSettings.INSTANCE;
            if (InternalSettings.isUnityApp()) {
                UnityReflection unityReflection = UnityReflection.INSTANCE;
                UnityReflection.sendEventMapping(optJSONArray == null ? null : optJSONArray.toString());
            }
        }
        boolean optBoolean = jSONObject2.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false);
        String optString = jSONObject2.optString(APP_SETTING_NUX_CONTENT, "");
        String str2 = optString;
        Intrinsics.checkNotNullExpressionValue(optString, "settingsJSON.optString(APP_SETTING_NUX_CONTENT, \"\")");
        boolean optBoolean2 = jSONObject2.optBoolean(APP_SETTING_NUX_ENABLED, false);
        Constants constants = Constants.INSTANCE;
        int optInt2 = jSONObject2.optInt(APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, Constants.getDefaultAppEventsSessionTimeoutInSeconds());
        EnumSet<SmartLoginOption> parseOptions = SmartLoginOption.Companion.parseOptions(jSONObject2.optLong(APP_SETTING_SMART_LOGIN_OPTIONS));
        Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations = parseDialogConfigurations(jSONObject2.optJSONObject(APP_SETTING_DIALOG_CONFIGS));
        String optString2 = jSONObject2.optString(SMART_LOGIN_BOOKMARK_ICON_URL);
        Intrinsics.checkNotNullExpressionValue(optString2, "settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL)");
        String optString3 = jSONObject2.optString(SMART_LOGIN_MENU_ICON_URL);
        String str3 = optString3;
        FetchedAppSettings fetchedAppSettings2 = r3;
        Intrinsics.checkNotNullExpressionValue(optString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String optString4 = jSONObject2.optString(SDK_UPDATE_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(optString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        FetchedAppSettings fetchedAppSettings3 = new FetchedAppSettings(optBoolean, str2, optBoolean2, optInt2, parseOptions, parseDialogConfigurations, z, facebookRequestErrorClassification, optString2, str3, z2, z3, optJSONArray, optString4, z4, z5, jSONObject2.optString(APP_SETTING_APP_EVENTS_AAM_RULE), jSONObject2.optString(SUGGESTED_EVENTS_SETTING), jSONObject2.optString(APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD));
        FetchedAppSettings fetchedAppSettings4 = fetchedAppSettings2;
        fetchedAppSettings.put(str, fetchedAppSettings4);
        return fetchedAppSettings4;
    }
}
