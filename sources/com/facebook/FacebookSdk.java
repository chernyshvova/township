package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.android.billingclient.api.zzam;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.vungle.warren.log.LogEntry;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookSdk.kt */
public final class FacebookSdk {
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    public static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    public static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    public static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    public static final String CLOUDBRIDGE_SAVED_CREDENTIALS = "com.facebook.sdk.CloudBridgeSavedCredentials";
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";
    public static final String DATA_PROCESSION_OPTIONS = "data_processing_options";
    public static final String DATA_PROCESSION_OPTIONS_COUNTRY = "data_processing_options_country";
    public static final String DATA_PROCESSION_OPTIONS_STATE = "data_processing_options_state";
    public static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    public static final String FACEBOOK_COM = "facebook.com";
    public static final String FB_GG = "fb.gg";
    public static final String GAMING = "gaming";
    public static final String INSTAGRAM = "instagram";
    public static final String INSTAGRAM_COM = "instagram.com";
    public static final FacebookSdk INSTANCE = new FacebookSdk();
    public static final ReentrantLock LOCK = new ReentrantLock();
    public static final int MAX_REQUEST_CODE_RANGE = 100;
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";
    public static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    public static final String TAG = FacebookSdk.class.getCanonicalName();
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    public static volatile String appClientToken;
    public static Context applicationContext;
    public static volatile String applicationId;
    public static volatile String applicationName;
    public static boolean bypassAppSwitch;
    public static LockOnGetVariable<File> cacheDir;
    public static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    public static volatile Boolean codelessDebugLogEnabled;
    public static Executor executor;
    public static volatile String facebookDomain = FACEBOOK_COM;
    public static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    public static GraphRequestCreator graphRequestCreator = $$Lambda$2ro22SgLIEGEQvscKl0ZvNzqZbA.INSTANCE;
    public static boolean hasCustomTabsPrefetching;
    public static boolean ignoreAppSwitchToLoggedOut;
    public static volatile String instagramDomain = INSTAGRAM_COM;
    public static volatile boolean isDebugEnabledField;
    public static boolean isFullyInitialized;
    public static boolean isLegacyTokenUpgradeSupported;
    public static final HashSet<LoggingBehavior> loggingBehaviors = zzam.hashSetOf(LoggingBehavior.DEVELOPER_ERRORS);
    public static AtomicLong onProgressThreshold = new AtomicLong(65536);
    public static final AtomicBoolean sdkInitialized = new AtomicBoolean(false);

    @VisibleForTesting
    /* compiled from: FacebookSdk.kt */
    public interface GraphRequestCreator {
        GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback);
    }

    /* compiled from: FacebookSdk.kt */
    public interface InitializeCallback {
        void onInitialized();
    }

    static {
        ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
    }

    public static final void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(loggingBehavior);
            INSTANCE.updateGraphDebugBehavior();
        }
    }

    public static final void clearLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            loggingBehaviors.clear();
        }
    }

    public static final void fullyInitialize() {
        isFullyInitialized = true;
    }

    public static final boolean getAdvertiserIDCollectionEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    public static final Context getApplicationContext() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }

    public static final String getApplicationId() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    public static final String getApplicationName() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        return applicationName;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getApplicationSignature(android.content.Context r4) {
        /*
            java.lang.Class<com.facebook.FacebookSdk> r0 = com.facebook.FacebookSdk.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            com.facebook.internal.Validate r1 = com.facebook.internal.Validate.INSTANCE     // Catch:{ all -> 0x004e }
            com.facebook.internal.Validate.sdkInitialized()     // Catch:{ all -> 0x004e }
            if (r4 != 0) goto L_0x0012
            return r2
        L_0x0012:
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x0019
            return r2
        L_0x0019:
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x004e }
            r3 = 64
            android.content.pm.PackageInfo r4 = r1.getPackageInfo(r4, r3)     // Catch:{ NameNotFoundException -> 0x004d }
            android.content.pm.Signature[] r1 = r4.signatures     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x004d
            int r1 = r1.length     // Catch:{ all -> 0x004e }
            r3 = 0
            if (r1 != 0) goto L_0x002d
            r1 = 1
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            if (r1 == 0) goto L_0x0031
            goto L_0x004d
        L_0x0031:
            java.lang.String r1 = "SHA-1"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{  }
            android.content.pm.Signature[] r4 = r4.signatures     // Catch:{ all -> 0x004e }
            r4 = r4[r3]     // Catch:{ all -> 0x004e }
            byte[] r4 = r4.toByteArray()     // Catch:{ all -> 0x004e }
            r1.update(r4)     // Catch:{ all -> 0x004e }
            byte[] r4 = r1.digest()     // Catch:{ all -> 0x004e }
            r1 = 9
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r1)     // Catch:{ all -> 0x004e }
            return r4
        L_0x004d:
            return r2
        L_0x004e:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.getApplicationSignature(android.content.Context):java.lang.String");
    }

    public static final boolean getAutoInitEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getAutoInitEnabled();
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    public static final File getCacheDir() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        LockOnGetVariable<File> lockOnGetVariable = cacheDir;
        if (lockOnGetVariable != null) {
            return lockOnGetVariable.getValue();
        }
        Intrinsics.throwUninitializedPropertyAccessException("cacheDir");
        throw null;
    }

    public static final int getCallbackRequestCodeOffset() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    public static final String getClientToken() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        String str = appClientToken;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    public static final boolean getCodelessDebugLogEnabled() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        Boolean bool = codelessDebugLogEnabled;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static final boolean getCodelessSetupEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    /* JADX INFO: finally extract failed */
    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String getFacebookDomain() {
        return facebookDomain;
    }

    public static final String getGraphApiVersion() {
        Utility utility = Utility.INSTANCE;
        String str = TAG;
        String format = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{graphApiVersion}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        Utility.logd(str, format);
        return graphApiVersion;
    }

    public static final String getGraphDomain() {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        String graphDomain = currentAccessToken != null ? currentAccessToken.getGraphDomain() : null;
        Utility utility = Utility.INSTANCE;
        return Utility.getGraphDomainFromTokenDomain(graphDomain);
    }

    public static final String getInstagramDomain() {
        return instagramDomain;
    }

    public static final boolean getLimitEventAndDataUsage(Context context) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        synchronized (loggingBehaviors) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
            Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(HashSet(loggingBehaviors))");
        }
        return unmodifiableSet;
    }

    public static final boolean getMonitorEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getMonitorEnabled();
    }

    public static final long getOnProgressThreshold() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    public static final String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    /* renamed from: graphRequestCreator$lambda-0  reason: not valid java name */
    public static final GraphRequest m3528graphRequestCreator$lambda0(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return GraphRequest.Companion.newPostRequest(accessToken, str, jSONObject, callback);
    }

    public static final boolean isDebugEnabled() {
        return isDebugEnabledField;
    }

    public static final boolean isFacebookRequestCode(int i) {
        int i2 = callbackRequestCodeOffset;
        return i >= i2 && i < i2 + 100;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final synchronized boolean isFullyInitialized() {
        boolean z;
        synchronized (FacebookSdk.class) {
            z = isFullyInitialized;
        }
        return z;
    }

    public static final boolean isInitialized() {
        return sdkInitialized.get();
    }

    public static final boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        synchronized (loggingBehaviors) {
            z = isDebugEnabled() && loggingBehaviors.contains(loggingBehavior);
        }
        return z;
    }

    public static final void loadDefaultsFromMetadata$facebook_core_release(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    if (applicationId == null) {
                        Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            Locale locale = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                            String lowerCase = str.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            if (CharsKt__CharKt.startsWith$default(lowerCase, "fb", false, 2)) {
                                String substring = str.substring(2);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                                applicationId = substring;
                            } else {
                                applicationId = str;
                            }
                        } else if (obj instanceof Number) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (applicationName == null) {
                        applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
                    }
                    if (appClientToken == null) {
                        appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
                    }
                    if (callbackRequestCodeOffset == 64206) {
                        callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
                    }
                    if (codelessDebugLogEnabled == null) {
                        codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    private final void publishInstallAndWaitForResponse(Context context, String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
                String stringPlus = Intrinsics.stringPlus(str, "ping");
                long j = sharedPreferences.getLong(stringPlus, 0);
                AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
                JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
                String format = String.format("%s/activities", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                GraphRequest createPostRequest = graphRequestCreator.createPostRequest((AccessToken) null, format, jSONObjectForGraphAPICall, (GraphRequest.Callback) null);
                if (j == 0 && createPostRequest.executeAndWait().getError() == null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(stringPlus, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (JSONException e) {
                throw new FacebookException("An error occurred while publishing install.", (Throwable) e);
            } catch (Exception e2) {
                try {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd("Facebook-publish", e2);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    @VisibleForTesting(otherwise = 3)
    public static final void publishInstallAsync(Context context, String str) {
        Class<FacebookSdk> cls = FacebookSdk.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
                Intrinsics.checkNotNullParameter(str, "applicationId");
                getExecutor().execute(new Runnable(context.getApplicationContext(), str) {
                    public final /* synthetic */ Context f$0;
                    public final /* synthetic */ String f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        FacebookSdk.m3529publishInstallAsync$lambda15(this.f$0, this.f$1);
                    }
                });
                FeatureManager featureManager = FeatureManager.INSTANCE;
                if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing)) {
                    OnDeviceProcessingManager onDeviceProcessingManager = OnDeviceProcessingManager.INSTANCE;
                    if (OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                        OnDeviceProcessingManager onDeviceProcessingManager2 = OnDeviceProcessingManager.INSTANCE;
                        OnDeviceProcessingManager.sendInstallEventAsync(str, ATTRIBUTION_PREFERENCES);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: publishInstallAsync$lambda-15  reason: not valid java name */
    public static final void m3529publishInstallAsync$lambda15(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "$applicationId");
        FacebookSdk facebookSdk = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
        facebookSdk.publishInstallAndWaitForResponse(context, str);
    }

    public static final void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        synchronized (loggingBehaviors) {
            loggingBehaviors.remove(loggingBehavior);
        }
    }

    public static final synchronized void sdkInitialize(Context context, int i) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            sdkInitialize(context, i, (InitializeCallback) null);
        }
    }

    /* renamed from: sdkInitialize$lambda-3  reason: not valid java name */
    public static final File m3530sdkInitialize$lambda3() {
        Context context = applicationContext;
        if (context != null) {
            return context.getCacheDir();
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }

    /* renamed from: sdkInitialize$lambda-4  reason: not valid java name */
    public static final void m3531sdkInitialize$lambda4(boolean z) {
        if (z) {
            InstrumentManager instrumentManager = InstrumentManager.INSTANCE;
            InstrumentManager.start();
        }
    }

    /* renamed from: sdkInitialize$lambda-5  reason: not valid java name */
    public static final void m3532sdkInitialize$lambda5(boolean z) {
        if (z) {
            AppEventsManager appEventsManager = AppEventsManager.INSTANCE;
            AppEventsManager.start();
        }
    }

    /* renamed from: sdkInitialize$lambda-6  reason: not valid java name */
    public static final void m3533sdkInitialize$lambda6(boolean z) {
        if (z) {
            hasCustomTabsPrefetching = true;
        }
    }

    /* renamed from: sdkInitialize$lambda-7  reason: not valid java name */
    public static final void m3534sdkInitialize$lambda7(boolean z) {
        if (z) {
            ignoreAppSwitchToLoggedOut = true;
        }
    }

    /* renamed from: sdkInitialize$lambda-8  reason: not valid java name */
    public static final void m3535sdkInitialize$lambda8(boolean z) {
        if (z) {
            bypassAppSwitch = true;
        }
    }

    /* renamed from: sdkInitialize$lambda-9  reason: not valid java name */
    public static final Void m3536sdkInitialize$lambda9(InitializeCallback initializeCallback) {
        AccessTokenManager.Companion.getInstance().loadCurrentAccessToken();
        ProfileManager.Companion.getInstance().loadCurrentProfile();
        if (AccessToken.Companion.isCurrentAccessTokenActive() && Profile.Companion.getCurrentProfile() == null) {
            Profile.Companion.fetchProfileForCurrentAccessToken();
        }
        if (initializeCallback != null) {
            initializeCallback.onInitialized();
        }
        AppEventsLogger.Companion.initializeLib(getApplicationContext(), applicationId);
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.logIfAutoAppLinkEnabled();
        AppEventsLogger.Companion companion = AppEventsLogger.Companion;
        Context applicationContext2 = getApplicationContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext().applicationContext");
        companion.newLogger(applicationContext2).flush();
        return null;
    }

    public static final void setAdvertiserIDCollectionEnabled(boolean z) {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.setAdvertiserIDCollectionEnabled(z);
    }

    public static final void setApplicationId(String str) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(str, "applicationId");
        applicationId = str;
    }

    public static final void setApplicationName(String str) {
        applicationName = str;
    }

    public static final void setAutoInitEnabled(boolean z) {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.setAutoInitEnabled(z);
        if (z) {
            fullyInitialize();
        }
    }

    public static final void setAutoLogAppEventsEnabled(boolean z) {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.setAutoLogAppEventsEnabled(z);
        if (z) {
            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
            ActivityLifecycleTracker.startTracking((Application) getApplicationContext(), getApplicationId());
        }
    }

    public static final void setCacheDir(File file) {
        Intrinsics.checkNotNullParameter(file, "cacheDir");
        cacheDir = new LockOnGetVariable<>(file);
    }

    public static final void setClientToken(String str) {
        appClientToken = str;
    }

    public static final void setCodelessDebugLogEnabled(boolean z) {
        codelessDebugLogEnabled = Boolean.valueOf(z);
    }

    public static final void setDataProcessingOptions(String[] strArr) {
        Class<FacebookSdk> cls = FacebookSdk.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                setDataProcessingOptions(strArr, 0, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void setExecutor(Executor executor2) {
        Intrinsics.checkNotNullParameter(executor2, "executor");
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            executor = executor2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static final void setFacebookDomain(String str) {
        Intrinsics.checkNotNullParameter(str, "facebookDomain");
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = str;
    }

    public static final void setGraphApiVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "graphApiVersion");
        Log.w(TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(str) && !Intrinsics.areEqual(graphApiVersion, str)) {
            graphApiVersion = str;
        }
    }

    @VisibleForTesting
    public static final void setGraphRequestCreator$facebook_core_release(GraphRequestCreator graphRequestCreator2) {
        Intrinsics.checkNotNullParameter(graphRequestCreator2, "graphRequestCreator");
        graphRequestCreator = graphRequestCreator2;
    }

    public static final void setIsDebugEnabled(boolean z) {
        isDebugEnabledField = z;
    }

    public static final void setLegacyTokenUpgradeSupported(boolean z) {
        isLegacyTokenUpgradeSupported = z;
    }

    public static final void setLimitEventAndDataUsage(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    public static final void setMonitorEnabled(boolean z) {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.setMonitorEnabled(z);
    }

    public static final void setOnProgressThreshold(long j) {
        onProgressThreshold.set(j);
    }

    private final void updateGraphDebugBehavior() {
        if (loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
        }
    }

    public static final synchronized void sdkInitialize(Context context, int i, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            if (sdkInitialized.get()) {
                if (i != callbackRequestCodeOffset) {
                    throw new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
                }
            }
            if (i >= 0) {
                callbackRequestCodeOffset = i;
                sdkInitialize(context, initializeCallback);
            } else {
                throw new FacebookException(CALLBACK_OFFSET_NEGATIVE);
            }
        }
    }

    public static final void setDataProcessingOptions(String[] strArr, int i, int i2) {
        Class<FacebookSdk> cls = FacebookSdk.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if (strArr == null) {
                try {
                    strArr = new String[0];
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DATA_PROCESSION_OPTIONS, new JSONArray(zzam.toList(strArr)));
                jSONObject.put(DATA_PROCESSION_OPTIONS_COUNTRY, i);
                jSONObject.put(DATA_PROCESSION_OPTIONS_STATE, i2);
                Context context = applicationContext;
                if (context != null) {
                    context.getSharedPreferences(DATA_PROCESSING_OPTIONS_PREFERENCES, 0).edit().putString(DATA_PROCESSION_OPTIONS, jSONObject.toString()).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                    throw null;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public static final synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            sdkInitialize(context, (InitializeCallback) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void sdkInitialize(android.content.Context r4, com.facebook.FacebookSdk.InitializeCallback r5) {
        /*
            java.lang.Class<com.facebook.FacebookSdk> r0 = com.facebook.FacebookSdk.class
            monitor-enter(r0)
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)     // Catch:{ all -> 0x0109 }
            java.util.concurrent.atomic.AtomicBoolean r1 = sdkInitialized     // Catch:{ all -> 0x0109 }
            boolean r1 = r1.get()     // Catch:{ all -> 0x0109 }
            if (r1 == 0) goto L_0x0018
            if (r5 != 0) goto L_0x0013
            goto L_0x0016
        L_0x0013:
            r5.onInitialized()     // Catch:{ all -> 0x0109 }
        L_0x0016:
            monitor-exit(r0)
            return
        L_0x0018:
            com.facebook.internal.Validate r1 = com.facebook.internal.Validate.INSTANCE     // Catch:{ all -> 0x0109 }
            r1 = 0
            com.facebook.internal.Validate.hasFacebookActivity(r4, r1)     // Catch:{ all -> 0x0109 }
            com.facebook.internal.Validate r2 = com.facebook.internal.Validate.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.Validate.hasInternetPermissions(r4, r1)     // Catch:{ all -> 0x0109 }
            android.content.Context r2 = r4.getApplicationContext()     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = "applicationContext.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0109 }
            applicationContext = r2     // Catch:{ all -> 0x0109 }
            com.facebook.appevents.AppEventsLogger$Companion r2 = com.facebook.appevents.AppEventsLogger.Companion     // Catch:{ all -> 0x0109 }
            r2.getAnonymousAppDeviceGUID(r4)     // Catch:{ all -> 0x0109 }
            android.content.Context r4 = applicationContext     // Catch:{ all -> 0x0109 }
            r2 = 0
            if (r4 == 0) goto L_0x0103
            loadDefaultsFromMetadata$facebook_core_release(r4)     // Catch:{ all -> 0x0109 }
            java.lang.String r4 = applicationId     // Catch:{ all -> 0x0109 }
            r3 = 1
            if (r4 == 0) goto L_0x0049
            int r4 = r4.length()     // Catch:{ all -> 0x0109 }
            if (r4 != 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r4 = 0
            goto L_0x004a
        L_0x0049:
            r4 = 1
        L_0x004a:
            if (r4 != 0) goto L_0x00fb
            java.lang.String r4 = appClientToken     // Catch:{ all -> 0x0109 }
            if (r4 == 0) goto L_0x0056
            int r4 = r4.length()     // Catch:{ all -> 0x0109 }
            if (r4 != 0) goto L_0x0057
        L_0x0056:
            r1 = 1
        L_0x0057:
            if (r1 != 0) goto L_0x00f3
            java.util.concurrent.atomic.AtomicBoolean r4 = sdkInitialized     // Catch:{ all -> 0x0109 }
            r4.set(r3)     // Catch:{ all -> 0x0109 }
            boolean r4 = getAutoInitEnabled()     // Catch:{ all -> 0x0109 }
            if (r4 == 0) goto L_0x0067
            fullyInitialize()     // Catch:{ all -> 0x0109 }
        L_0x0067:
            android.content.Context r4 = applicationContext     // Catch:{ all -> 0x0109 }
            if (r4 == 0) goto L_0x00ed
            boolean r4 = r4 instanceof android.app.Application     // Catch:{ all -> 0x0109 }
            if (r4 == 0) goto L_0x008b
            com.facebook.UserSettingsManager r4 = com.facebook.UserSettingsManager.INSTANCE     // Catch:{ all -> 0x0109 }
            boolean r4 = com.facebook.UserSettingsManager.getAutoLogAppEventsEnabled()     // Catch:{ all -> 0x0109 }
            if (r4 == 0) goto L_0x008b
            com.facebook.appevents.internal.ActivityLifecycleTracker r4 = com.facebook.appevents.internal.ActivityLifecycleTracker.INSTANCE     // Catch:{ all -> 0x0109 }
            android.content.Context r4 = applicationContext     // Catch:{ all -> 0x0109 }
            if (r4 == 0) goto L_0x0085
            android.app.Application r4 = (android.app.Application) r4     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = applicationId     // Catch:{ all -> 0x0109 }
            com.facebook.appevents.internal.ActivityLifecycleTracker.startTracking(r4, r1)     // Catch:{ all -> 0x0109 }
            goto L_0x008b
        L_0x0085:
            java.lang.String r4 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x0109 }
            throw r2
        L_0x008b:
            com.facebook.internal.FetchedAppSettingsManager r4 = com.facebook.internal.FetchedAppSettingsManager.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FetchedAppSettingsManager.loadAppSettingsAsync()     // Catch:{ all -> 0x0109 }
            com.facebook.internal.NativeProtocol r4 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.NativeProtocol.updateAllAvailableProtocolVersionsAsync()     // Catch:{ all -> 0x0109 }
            com.facebook.internal.BoltsMeasurementEventListener$Companion r4 = com.facebook.internal.BoltsMeasurementEventListener.Companion     // Catch:{ all -> 0x0109 }
            android.content.Context r1 = applicationContext     // Catch:{ all -> 0x0109 }
            if (r1 == 0) goto L_0x00e7
            r4.getInstance(r1)     // Catch:{ all -> 0x0109 }
            com.facebook.internal.LockOnGetVariable r4 = new com.facebook.internal.LockOnGetVariable     // Catch:{ all -> 0x0109 }
            com.facebook.-$$Lambda$J0805Clgxed1K59G9leFVPRGzM4 r1 = com.facebook.$$Lambda$J0805Clgxed1K59G9leFVPRGzM4.INSTANCE     // Catch:{ all -> 0x0109 }
            r4.<init>(r1)     // Catch:{ all -> 0x0109 }
            cacheDir = r4     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.Instrument     // Catch:{ all -> 0x0109 }
            com.facebook.-$$Lambda$fGv4uIuB4ckkxwOf8O4RgtXZub4 r1 = com.facebook.$$Lambda$fGv4uIuB4ckkxwOf8O4RgtXZub4.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager.checkFeature(r4, r1)     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.AppEvents     // Catch:{ all -> 0x0109 }
            com.facebook.-$$Lambda$8Xi3kKcv5EqcfpghgczttKFq8YE r1 = com.facebook.$$Lambda$8Xi3kKcv5EqcfpghgczttKFq8YE.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager.checkFeature(r4, r1)     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.ChromeCustomTabsPrefetching     // Catch:{ all -> 0x0109 }
            com.facebook.-$$Lambda$PFMuGw4-GX6YxoewlCboSNJ46iw r1 = com.facebook.$$Lambda$PFMuGw4GX6YxoewlCboSNJ46iw.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager.checkFeature(r4, r1)     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.IgnoreAppSwitchToLoggedOut     // Catch:{ all -> 0x0109 }
            com.facebook.-$$Lambda$xnPiGMIrZY-efkOoczDJVIjnueQ r1 = com.facebook.$$Lambda$xnPiGMIrZYefkOoczDJVIjnueQ.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager.checkFeature(r4, r1)     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.BypassAppSwitch     // Catch:{ all -> 0x0109 }
            com.facebook.-$$Lambda$4yZ8An2h0IO8z381mtb9us73H-E r1 = com.facebook.$$Lambda$4yZ8An2h0IO8z381mtb9us73HE.INSTANCE     // Catch:{ all -> 0x0109 }
            com.facebook.internal.FeatureManager.checkFeature(r4, r1)     // Catch:{ all -> 0x0109 }
            java.util.concurrent.FutureTask r4 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x0109 }
            com.facebook.-$$Lambda$0kbXjfnH1rWqSbnFNjnUSyk2drw r1 = new com.facebook.-$$Lambda$0kbXjfnH1rWqSbnFNjnUSyk2drw     // Catch:{ all -> 0x0109 }
            r1.<init>()     // Catch:{ all -> 0x0109 }
            r4.<init>(r1)     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r5 = getExecutor()     // Catch:{ all -> 0x0109 }
            r5.execute(r4)     // Catch:{ all -> 0x0109 }
            monitor-exit(r0)
            return
        L_0x00e7:
            java.lang.String r4 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x0109 }
            throw r2
        L_0x00ed:
            java.lang.String r4 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x0109 }
            throw r2
        L_0x00f3:
            com.facebook.FacebookException r4 = new com.facebook.FacebookException     // Catch:{ all -> 0x0109 }
            java.lang.String r5 = "A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk."
            r4.<init>((java.lang.String) r5)     // Catch:{ all -> 0x0109 }
            throw r4     // Catch:{ all -> 0x0109 }
        L_0x00fb:
            com.facebook.FacebookException r4 = new com.facebook.FacebookException     // Catch:{ all -> 0x0109 }
            java.lang.String r5 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk."
            r4.<init>((java.lang.String) r5)     // Catch:{ all -> 0x0109 }
            throw r4     // Catch:{ all -> 0x0109 }
        L_0x0103:
            java.lang.String r4 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x0109 }
            throw r2
        L_0x0109:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.sdkInitialize(android.content.Context, com.facebook.FacebookSdk$InitializeCallback):void");
    }
}
