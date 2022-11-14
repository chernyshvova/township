package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.p030ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: SuggestedEventsManager.kt */
public final class SuggestedEventsManager {
    public static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    public static final SuggestedEventsManager INSTANCE = new SuggestedEventsManager();
    public static final String PRODUCTION_EVENTS_KEY = "production_events";
    public static final Set<String> eligibleEvents = new LinkedHashSet();
    public static final AtomicBoolean enabled = new AtomicBoolean(false);
    public static final Set<String> productionEvents = new LinkedHashSet();

    public static final synchronized void enable() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute($$Lambda$bPTNKB1roqNzalSpP7WmTIMErc.INSTANCE);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m3593enable$lambda0() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!enabled.get()) {
                    enabled.set(true);
                    INSTANCE.initialize();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void initialize() {
        String suggestedEventsSetting;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null && (suggestedEventsSetting = queryAppSettings.getSuggestedEventsSetting()) != null) {
                    populateEventsFromRawJsonString$facebook_core_release(suggestedEventsSetting);
                    if ((!productionEvents.isEmpty()) || (!eligibleEvents.isEmpty())) {
                        ModelManager modelManager = ModelManager.INSTANCE;
                        File ruleFile = ModelManager.getRuleFile(ModelManager.Task.MTML_APP_EVENT_PREDICTION);
                        if (ruleFile != null) {
                            FeatureExtractor featureExtractor = FeatureExtractor.INSTANCE;
                            FeatureExtractor.initialize(ruleFile);
                            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                            Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
                            if (currentActivity != null) {
                                trackActivity(currentActivity);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final boolean isEligibleEvents$facebook_core_release(String str) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "event");
            return eligibleEvents.contains(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean isEnabled() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return enabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean isProductionEvents$facebook_core_release(String str) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "event");
            return productionEvents.contains(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final void trackActivity(Activity activity) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                try {
                    if (enabled.get()) {
                        FeatureExtractor featureExtractor = FeatureExtractor.INSTANCE;
                        if (FeatureExtractor.isInitialized() && (!productionEvents.isEmpty() || !eligibleEvents.isEmpty())) {
                            ViewObserver.Companion.startTrackingActivity(activity);
                            return;
                        }
                    }
                    ViewObserver.Companion.stopTrackingActivity(activity);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r9 = r2.getJSONArray(ELIGIBLE_EVENTS_KEY);
     */
    @androidx.annotation.VisibleForTesting(otherwise = 2)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void populateEventsFromRawJsonString$facebook_core_release(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "eligible_for_prediction_events"
            java.lang.String r1 = "production_events"
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r8)
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            r2.<init>(r9)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            boolean r9 = r2.has(r1)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            java.lang.String r3 = "jsonArray.getString(i)"
            r4 = 0
            if (r9 == 0) goto L_0x0037
            org.json.JSONArray r9 = r2.getJSONArray(r1)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            int r1 = r9.length()     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r1 <= 0) goto L_0x0037
            r5 = 0
        L_0x0024:
            int r6 = r5 + 1
            java.util.Set<java.lang.String> r7 = productionEvents     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            r7.add(r5)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r6 < r1) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r5 = r6
            goto L_0x0024
        L_0x0037:
            boolean r9 = r2.has(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r9 == 0) goto L_0x005e
            org.json.JSONArray r9 = r2.getJSONArray(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            int r0 = r9.length()     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r0 <= 0) goto L_0x005e
        L_0x0047:
            int r1 = r4 + 1
            java.util.Set<java.lang.String> r2 = eligibleEvents     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            java.lang.String r4 = r9.getString(r4)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            r2.add(r4)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r1 < r0) goto L_0x0058
            goto L_0x005e
        L_0x0058:
            r4 = r1
            goto L_0x0047
        L_0x005a:
            r9 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r8)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.SuggestedEventsManager.populateEventsFromRawJsonString$facebook_core_release(java.lang.String):void");
    }
}
