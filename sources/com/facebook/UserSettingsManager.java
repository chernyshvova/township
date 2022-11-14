package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserSettingsManager.kt */
public final class UserSettingsManager {
    public static final String ADVERTISERID_COLLECTION_FALSE_WARNING = "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.";
    public static final String ADVERTISERID_COLLECTION_NOT_SET_WARNING = "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";
    public static final String ADVERTISER_ID_KEY = "advertiser_id";
    public static final String APPLICATION_FIELDS = "fields";
    public static final String AUTOLOG_APPEVENT_NOT_SET_WARNING = "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";
    public static final String AUTO_APP_LINK_WARNING = "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest";
    public static final String EVENTS_CODELESS_SETUP_ENABLED = "auto_event_setup_enabled";
    public static final UserSettingsManager INSTANCE = new UserSettingsManager();
    public static final String LAST_TIMESTAMP = "last_timestamp";
    public static final String TAG;
    public static final long TIMEOUT_7D = 604800000;
    public static final String USER_SETTINGS = "com.facebook.sdk.USER_SETTINGS";
    public static final String USER_SETTINGS_BITMASK = "com.facebook.sdk.USER_SETTINGS_BITMASK";
    public static final String VALUE = "value";
    public static final UserSetting advertiserIDCollectionEnabled = new UserSetting(true, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY);
    public static final UserSetting autoInitEnabled = new UserSetting(true, FacebookSdk.AUTO_INIT_ENABLED_PROPERTY);
    public static final UserSetting autoLogAppEventsEnabled = new UserSetting(true, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY);
    public static final UserSetting codelessSetupEnabled = new UserSetting(false, EVENTS_CODELESS_SETUP_ENABLED);
    public static final AtomicBoolean isFetchingCodelessStatus = new AtomicBoolean(false);
    public static final AtomicBoolean isInitialized = new AtomicBoolean(false);
    public static final UserSetting monitorEnabled = new UserSetting(true, FacebookSdk.MONITOR_ENABLED_PROPERTY);
    public static SharedPreferences userSettingPref;

    /* compiled from: UserSettingsManager.kt */
    public static final class UserSetting {
        public boolean defaultVal;
        public String key;
        public long lastTS;
        public Boolean value;

        public UserSetting(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.defaultVal = z;
            this.key = str;
        }

        public final boolean getDefaultVal() {
            return this.defaultVal;
        }

        public final String getKey() {
            return this.key;
        }

        public final long getLastTS() {
            return this.lastTS;
        }

        public final Boolean getValue() {
            return this.value;
        }

        public final void setDefaultVal(boolean z) {
            this.defaultVal = z;
        }

        public final void setKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.key = str;
        }

        public final void setLastTS(long j) {
            this.lastTS = j;
        }

        public final void setValue(Boolean bool) {
            this.value = bool;
        }

        /* renamed from: getValue  reason: collision with other method in class */
        public final boolean m3544getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }

    static {
        String name = UserSettingsManager.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "UserSettingsManager::class.java.name");
        TAG = name;
    }

    public static final boolean getAdvertiserIDCollectionEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return advertiserIDCollectionEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean getAutoInitEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return autoInitEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return autoLogAppEventsEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean getCodelessSetupEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return codelessSetupEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean getMonitorEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return monitorEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private final void initializeCodelessSetupEnabledAsync() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                readSettingFromCache(codelessSetupEnabled);
                long currentTimeMillis = System.currentTimeMillis();
                if (codelessSetupEnabled.getValue() == null || currentTimeMillis - codelessSetupEnabled.getLastTS() >= TIMEOUT_7D) {
                    codelessSetupEnabled.setValue((Boolean) null);
                    codelessSetupEnabled.setLastTS(0);
                    if (isFetchingCodelessStatus.compareAndSet(false, true)) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        FacebookSdk.getExecutor().execute(new Runnable(currentTimeMillis) {
                            public final /* synthetic */ long f$0;

                            {
                                this.f$0 = r1;
                            }

                            public final void run() {
                                UserSettingsManager.m3543initializeCodelessSetupEnabledAsync$lambda0(this.f$0);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: initializeCodelessSetupEnabledAsync$lambda-0  reason: not valid java name */
    public static final void m3543initializeCodelessSetupEnabledAsync$lambda0(long j) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (advertiserIDCollectionEnabled.getValue()) {
                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                    if (queryAppSettings != null && queryAppSettings.getCodelessEventsEnabled()) {
                        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                        String androidAdvertiserId = (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) ? null : attributionIdentifiers.getAndroidAdvertiserId();
                        if (androidAdvertiserId != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString(ADVERTISER_ID_KEY, androidAdvertiserId);
                            bundle.putString("fields", EVENTS_CODELESS_SETUP_ENABLED);
                            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "app", (GraphRequest.Callback) null);
                            newGraphPathRequest.setParameters(bundle);
                            JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
                            if (jSONObject != null) {
                                codelessSetupEnabled.setValue(Boolean.valueOf(jSONObject.optBoolean(EVENTS_CODELESS_SETUP_ENABLED, false)));
                                codelessSetupEnabled.setLastTS(j);
                                INSTANCE.writeSettingToCache(codelessSetupEnabled);
                            }
                        }
                    }
                }
                isFetchingCodelessStatus.set(false);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void initializeIfNotInitialized() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.isInitialized() && isInitialized.compareAndSet(false, true)) {
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(USER_SETTINGS, 0);
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(USER_SETTINGS, Context.MODE_PRIVATE)");
                    userSettingPref = sharedPreferences;
                    initializeUserSetting(autoLogAppEventsEnabled, advertiserIDCollectionEnabled, autoInitEnabled);
                    initializeCodelessSetupEnabledAsync();
                    logWarnings();
                    logIfSDKSettingsChanged();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void initializeUserSetting(UserSetting... userSettingArr) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            int i = 0;
            try {
                int length = userSettingArr.length;
                while (i < length) {
                    UserSetting userSetting = userSettingArr[i];
                    i++;
                    if (userSetting == codelessSetupEnabled) {
                        initializeCodelessSetupEnabledAsync();
                    } else if (userSetting.getValue() == null) {
                        readSettingFromCache(userSetting);
                        if (userSetting.getValue() == null) {
                            loadSettingFromManifest(userSetting);
                        }
                    } else {
                        writeSettingToCache(userSetting);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void loadSettingFromManifest(UserSetting userSetting) {
        Bundle bundle;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                validateInitialized();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo == null) {
                    bundle = null;
                } else {
                    bundle = applicationInfo.metaData;
                }
                if (bundle != null && applicationInfo.metaData.containsKey(userSetting.getKey())) {
                    userSetting.setValue(Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.getKey(), userSetting.getDefaultVal())));
                }
            } catch (PackageManager.NameNotFoundException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final void logIfAutoAppLinkEnabled() {
        Bundle bundle;
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo == null) {
                    bundle = null;
                } else {
                    bundle = applicationInfo.metaData;
                }
                if (bundle != null && applicationInfo.metaData.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                    InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                    Bundle bundle2 = new Bundle();
                    Utility utility = Utility.INSTANCE;
                    if (!Utility.isAutoAppLinkSetup()) {
                        bundle2.putString("SchemeWarning", AUTO_APP_LINK_WARNING);
                        Log.w(TAG, AUTO_APP_LINK_WARNING);
                    }
                    internalAppEventsLogger.logEvent("fb_auto_applink", bundle2);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void logIfSDKSettingsChanged() {
        int i;
        int i2;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (isInitialized.get()) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    if (FacebookSdk.isInitialized()) {
                        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                        Context applicationContext = FacebookSdk.getApplicationContext();
                        int i3 = 0;
                        int i4 = ((autoInitEnabled.getValue() ? 1 : 0) << 0) | 0 | ((autoLogAppEventsEnabled.getValue() ? 1 : 0) << 1) | ((advertiserIDCollectionEnabled.getValue() ? 1 : 0) << 2) | ((monitorEnabled.getValue() ? 1 : 0) << 3);
                        SharedPreferences sharedPreferences = userSettingPref;
                        Bundle bundle = null;
                        if (sharedPreferences != null) {
                            int i5 = sharedPreferences.getInt(USER_SETTINGS_BITMASK, 0);
                            if (i5 != i4) {
                                SharedPreferences sharedPreferences2 = userSettingPref;
                                if (sharedPreferences2 != null) {
                                    sharedPreferences2.edit().putInt(USER_SETTINGS_BITMASK, i4).apply();
                                    try {
                                        ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                                        if (applicationInfo != null) {
                                            bundle = applicationInfo.metaData;
                                        }
                                        if (bundle != null) {
                                            String[] strArr = {FacebookSdk.AUTO_INIT_ENABLED_PROPERTY, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY, FacebookSdk.MONITOR_ENABLED_PROPERTY};
                                            boolean[] zArr = {true, true, true, true};
                                            int i6 = 0;
                                            i2 = 0;
                                            i = 0;
                                            while (true) {
                                                int i7 = i6 + 1;
                                                try {
                                                    i2 |= (applicationInfo.metaData.containsKey(strArr[i6]) ? 1 : 0) << i6;
                                                    i |= (applicationInfo.metaData.getBoolean(strArr[i6], zArr[i6]) ? 1 : 0) << i6;
                                                    if (i7 > 3) {
                                                        break;
                                                    }
                                                    i6 = i7;
                                                } catch (PackageManager.NameNotFoundException unused) {
                                                    i3 = i;
                                                    i = i3;
                                                    i3 = i2;
                                                    InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                                                    Bundle bundle2 = new Bundle();
                                                    bundle2.putInt("usage", i3);
                                                    bundle2.putInt("initial", i);
                                                    bundle2.putInt("previous", i5);
                                                    bundle2.putInt("current", i4);
                                                    internalAppEventsLogger.logChangedSettingsEvent(bundle2);
                                                }
                                            }
                                            i3 = i2;
                                            InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
                                            Bundle bundle22 = new Bundle();
                                            bundle22.putInt("usage", i3);
                                            bundle22.putInt("initial", i);
                                            bundle22.putInt("previous", i5);
                                            bundle22.putInt("current", i4);
                                            internalAppEventsLogger2.logChangedSettingsEvent(bundle22);
                                        }
                                        i = 0;
                                        InternalAppEventsLogger internalAppEventsLogger22 = new InternalAppEventsLogger(applicationContext);
                                        Bundle bundle222 = new Bundle();
                                        bundle222.putInt("usage", i3);
                                        bundle222.putInt("initial", i);
                                        bundle222.putInt("previous", i5);
                                        bundle222.putInt("current", i4);
                                        internalAppEventsLogger22.logChangedSettingsEvent(bundle222);
                                    } catch (PackageManager.NameNotFoundException unused2) {
                                        i2 = 0;
                                        i = i3;
                                        i3 = i2;
                                        InternalAppEventsLogger internalAppEventsLogger222 = new InternalAppEventsLogger(applicationContext);
                                        Bundle bundle2222 = new Bundle();
                                        bundle2222.putInt("usage", i3);
                                        bundle2222.putInt("initial", i);
                                        bundle2222.putInt("previous", i5);
                                        bundle2222.putInt("current", i4);
                                        internalAppEventsLogger222.logChangedSettingsEvent(bundle2222);
                                    }
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                                    throw null;
                                }
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                            throw null;
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void logWarnings() {
        Bundle bundle;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo == null) {
                    bundle = null;
                } else {
                    bundle = applicationInfo.metaData;
                }
                if (bundle != null) {
                    if (!applicationInfo.metaData.containsKey(FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY)) {
                        Log.w(TAG, AUTOLOG_APPEVENT_NOT_SET_WARNING);
                    }
                    if (!applicationInfo.metaData.containsKey(FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY)) {
                        Log.w(TAG, ADVERTISERID_COLLECTION_NOT_SET_WARNING);
                    }
                    if (!getAdvertiserIDCollectionEnabled()) {
                        Log.w(TAG, ADVERTISERID_COLLECTION_FALSE_WARNING);
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void readSettingFromCache(UserSetting userSetting) {
        String str = "";
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                validateInitialized();
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString(userSetting.getKey(), str);
                    if (string != null) {
                        str = string;
                    }
                    if (str.length() > 0) {
                        JSONObject jSONObject = new JSONObject(str);
                        userSetting.setValue(Boolean.valueOf(jSONObject.getBoolean("value")));
                        userSetting.setLastTS(jSONObject.getLong(LAST_TIMESTAMP));
                        return;
                    }
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                throw null;
            } catch (JSONException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final void setAdvertiserIDCollectionEnabled(boolean z) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                advertiserIDCollectionEnabled.setValue(Boolean.valueOf(z));
                advertiserIDCollectionEnabled.setLastTS(System.currentTimeMillis());
                if (isInitialized.get()) {
                    INSTANCE.writeSettingToCache(advertiserIDCollectionEnabled);
                } else {
                    INSTANCE.initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void setAutoInitEnabled(boolean z) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                autoInitEnabled.setValue(Boolean.valueOf(z));
                autoInitEnabled.setLastTS(System.currentTimeMillis());
                if (isInitialized.get()) {
                    INSTANCE.writeSettingToCache(autoInitEnabled);
                } else {
                    INSTANCE.initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void setAutoLogAppEventsEnabled(boolean z) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                autoLogAppEventsEnabled.setValue(Boolean.valueOf(z));
                autoLogAppEventsEnabled.setLastTS(System.currentTimeMillis());
                if (isInitialized.get()) {
                    INSTANCE.writeSettingToCache(autoLogAppEventsEnabled);
                } else {
                    INSTANCE.initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void setMonitorEnabled(boolean z) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                monitorEnabled.setValue(Boolean.valueOf(z));
                monitorEnabled.setLastTS(System.currentTimeMillis());
                if (isInitialized.get()) {
                    INSTANCE.writeSettingToCache(monitorEnabled);
                } else {
                    INSTANCE.initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void validateInitialized() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!isInitialized.get()) {
                    throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void writeSettingToCache(UserSetting userSetting) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                validateInitialized();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", userSetting.getValue());
                jSONObject.put(LAST_TIMESTAMP, userSetting.getLastTS());
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString(userSetting.getKey(), jSONObject.toString()).apply();
                    logIfSDKSettingsChanged();
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                throw null;
            } catch (Exception e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
