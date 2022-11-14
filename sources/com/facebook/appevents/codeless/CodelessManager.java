package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: CodelessManager.kt */
public final class CodelessManager {
    public static final CodelessManager INSTANCE = new CodelessManager();
    public static String deviceSessionID;
    public static final AtomicBoolean isAppIndexingEnabled = new AtomicBoolean(false);
    public static volatile boolean isCheckingSession;
    public static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    public static SensorManager sensorManager;
    public static ViewIndexer viewIndexer;
    public static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    private final void checkCodelessSession(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!isCheckingSession) {
                    isCheckingSession = true;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new Runnable(str) {
                        public final /* synthetic */ String f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void run() {
                            CodelessManager.m3570checkCodelessSession$lambda1(this.f$0);
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: checkCodelessSession$lambda-1  reason: not valid java name */
    public static final void m3570checkCodelessSession$lambda1(String str) {
        String str2;
        String str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Bundle bundle = new Bundle();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
                if (attributionIdentifiers == null) {
                    str2 = null;
                } else {
                    str2 = attributionIdentifiers.getAndroidAdvertiserId();
                }
                if (str2 != null) {
                    jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
                } else {
                    jSONArray.put("");
                }
                jSONArray.put(str3);
                AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                if (AppEventUtility.isEmulator()) {
                    str3 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
                jSONArray.put(str3);
                Utility utility = Utility.INSTANCE;
                Locale currentLocale = Utility.getCurrentLocale();
                jSONArray.put(currentLocale.getLanguage() + '_' + currentLocale.getCountry());
                String jSONArray2 = jSONArray.toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "extInfoArray.toString()");
                bundle.putString(Constants.DEVICE_SESSION_ID, getCurrentDeviceSessionID$facebook_core_release());
                bundle.putString(Constants.EXTINFO, jSONArray2);
                GraphRequest.Companion companion = GraphRequest.Companion;
                boolean z = true;
                String format = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                JSONObject jSONObject = companion.newPostRequestWithBundle((AccessToken) null, format, bundle, (GraphRequest.Callback) null).executeAndWait().getJSONObject();
                AtomicBoolean atomicBoolean = isAppIndexingEnabled;
                if (jSONObject == null || !jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false)) {
                    z = false;
                }
                atomicBoolean.set(z);
                if (!isAppIndexingEnabled.get()) {
                    deviceSessionID = null;
                } else {
                    ViewIndexer viewIndexer2 = viewIndexer;
                    if (viewIndexer2 != null) {
                        viewIndexer2.schedule();
                    }
                }
                isCheckingSession = false;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void disable() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isCodelessEnabled.set(false);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void enable() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isCodelessEnabled.set(true);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final String getCurrentDeviceSessionID$facebook_core_release() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (deviceSessionID == null) {
                deviceSessionID = UUID.randomUUID().toString();
            }
            String str = deviceSessionID;
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final boolean getIsAppIndexingEnabled$facebook_core_release() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return isAppIndexingEnabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private final boolean isDebugOnEmulator() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
        }
        return false;
    }

    public static final void onActivityDestroyed(Activity activity) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                CodelessMatcher.Companion.getInstance().destroy(activity);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void onActivityPaused(Activity activity) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                if (isCodelessEnabled.get()) {
                    CodelessMatcher.Companion.getInstance().remove(activity);
                    ViewIndexer viewIndexer2 = viewIndexer;
                    if (viewIndexer2 != null) {
                        viewIndexer2.unschedule();
                    }
                    SensorManager sensorManager2 = sensorManager;
                    if (sensorManager2 != null) {
                        sensorManager2.unregisterListener(viewIndexingTrigger);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void onActivityResumed(Activity activity) {
        Boolean bool;
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                if (isCodelessEnabled.get()) {
                    CodelessMatcher.Companion.getInstance().add(activity);
                    Context applicationContext = activity.getApplicationContext();
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    String applicationId = FacebookSdk.getApplicationId();
                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                    FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
                    if (appSettingsWithoutQuery == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(appSettingsWithoutQuery.getCodelessEventsEnabled());
                    }
                    if (Intrinsics.areEqual(bool, Boolean.TRUE) || INSTANCE.isDebugOnEmulator()) {
                        SensorManager sensorManager2 = (SensorManager) applicationContext.getSystemService("sensor");
                        if (sensorManager2 != null) {
                            sensorManager = sensorManager2;
                            Sensor defaultSensor = sensorManager2.getDefaultSensor(1);
                            ViewIndexer viewIndexer2 = new ViewIndexer(activity);
                            viewIndexer = viewIndexer2;
                            viewIndexingTrigger.setOnShakeListener(new ViewIndexingTrigger.OnShakeListener(applicationId) {
                                public final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onShake() {
                                    CodelessManager.m3571onActivityResumed$lambda0(FetchedAppSettings.this, this.f$1);
                                }
                            });
                            sensorManager2.registerListener(viewIndexingTrigger, defaultSensor, 2);
                            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                                viewIndexer2.schedule();
                            }
                        } else {
                            return;
                        }
                    }
                    if (INSTANCE.isDebugOnEmulator() && !isAppIndexingEnabled.get()) {
                        INSTANCE.checkCodelessSession(applicationId);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: onActivityResumed$lambda-0  reason: not valid java name */
    public static final void m3571onActivityResumed$lambda0(FetchedAppSettings fetchedAppSettings, String str) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$appId");
                boolean z = true;
                boolean z2 = fetchedAppSettings != null && fetchedAppSettings.getCodelessEventsEnabled();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (!FacebookSdk.getCodelessSetupEnabled()) {
                    z = false;
                }
                if (z2 && z) {
                    INSTANCE.checkCodelessSession(str);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void updateAppIndexing$facebook_core_release(boolean z) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isAppIndexingEnabled.set(z);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
