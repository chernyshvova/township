package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppEventQueue.kt */
public final class AppEventQueue {
    public static final int FLUSH_PERIOD_IN_SECONDS = 15;
    public static final AppEventQueue INSTANCE = new AppEventQueue();
    public static final int NO_CONNECTIVITY_ERROR_CODE = -1;
    public static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    public static final String TAG;
    public static volatile AppEventCollection appEventCollection = new AppEventCollection();
    public static final Runnable flushRunnable = $$Lambda$JfKbahcEddW7eTw_HAXhtpIoDNY.INSTANCE;
    public static ScheduledFuture<?> scheduledFuture;
    public static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    static {
        String name = AppEventQueue.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "AppEventQueue::class.java.name");
        TAG = name;
    }

    public static final void add(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppId");
                Intrinsics.checkNotNullParameter(appEvent, "appEvent");
                singleThreadExecutor.execute(new Runnable(appEvent) {
                    public final /* synthetic */ AppEvent f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AppEventQueue.m3547add$lambda3(AccessTokenAppIdPair.this, this.f$1);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: add$lambda-3  reason: not valid java name */
    public static final void m3547add$lambda3(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "$accessTokenAppId");
                Intrinsics.checkNotNullParameter(appEvent, "$appEvent");
                appEventCollection.addEvent(accessTokenAppIdPair, appEvent);
                if (AppEventsLogger.Companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY && appEventCollection.getEventCount() > NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER) {
                    flushAndWait(FlushReason.EVENT_THRESHOLD);
                } else if (scheduledFuture == null) {
                    scheduledFuture = singleThreadExecutor.schedule(flushRunnable, 15, TimeUnit.SECONDS);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final GraphRequest buildRequestForSession(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState, boolean z, FlushStatistics flushStatistics) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppId");
            Intrinsics.checkNotNullParameter(sessionEventsState, "appEvents");
            Intrinsics.checkNotNullParameter(flushStatistics, "flushState");
            String applicationId = accessTokenAppIdPair.getApplicationId();
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            boolean z2 = false;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
            GraphRequest.Companion companion = GraphRequest.Companion;
            String format = String.format("%s/activities", Arrays.copyOf(new Object[]{applicationId}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            GraphRequest newPostRequest = companion.newPostRequest((AccessToken) null, format, (JSONObject) null, (GraphRequest.Callback) null);
            newPostRequest.setForceApplicationRequest(true);
            Bundle parameters = newPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
            String pushNotificationsRegistrationId = InternalAppEventsLogger.Companion.getPushNotificationsRegistrationId();
            if (pushNotificationsRegistrationId != null) {
                parameters.putString("device_token", pushNotificationsRegistrationId);
            }
            String installReferrer = AppEventsLoggerImpl.Companion.getInstallReferrer();
            if (installReferrer != null) {
                parameters.putString(ReferrerDetails.KEY_INSTALL_REFERRER, installReferrer);
            }
            newPostRequest.setParameters(parameters);
            if (queryAppSettings != null) {
                z2 = queryAppSettings.supportsImplicitLogging();
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            int populateRequest = sessionEventsState.populateRequest(newPostRequest, FacebookSdk.getApplicationContext(), z2, z);
            if (populateRequest == 0) {
                return null;
            }
            flushStatistics.setNumEvents(flushStatistics.getNumEvents() + populateRequest);
            newPostRequest.setCallback(new GraphRequest.Callback(newPostRequest, sessionEventsState, flushStatistics) {
                public final /* synthetic */ GraphRequest f$1;
                public final /* synthetic */ SessionEventsState f$2;
                public final /* synthetic */ FlushStatistics f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onCompleted(GraphResponse graphResponse) {
                    AppEventQueue.m3548buildRequestForSession$lambda4(AccessTokenAppIdPair.this, this.f$1, this.f$2, this.f$3, graphResponse);
                }
            });
            return newPostRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* renamed from: buildRequestForSession$lambda-4  reason: not valid java name */
    public static final void m3548buildRequestForSession$lambda4(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, SessionEventsState sessionEventsState, FlushStatistics flushStatistics, GraphResponse graphResponse) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "$accessTokenAppId");
                Intrinsics.checkNotNullParameter(graphRequest, "$postRequest");
                Intrinsics.checkNotNullParameter(sessionEventsState, "$appEvents");
                Intrinsics.checkNotNullParameter(flushStatistics, "$flushState");
                Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
                handleResponse(accessTokenAppIdPair, graphRequest, graphResponse, sessionEventsState, flushStatistics);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final List<GraphRequest> buildRequests(AppEventCollection appEventCollection2, FlushStatistics flushStatistics) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(appEventCollection2, "appEventCollection");
            Intrinsics.checkNotNullParameter(flushStatistics, "flushResults");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(applicationContext);
            ArrayList arrayList = new ArrayList();
            for (AccessTokenAppIdPair next : appEventCollection2.keySet()) {
                SessionEventsState sessionEventsState = appEventCollection2.get(next);
                if (sessionEventsState != null) {
                    GraphRequest buildRequestForSession = buildRequestForSession(next, sessionEventsState, limitEventAndDataUsage, flushStatistics);
                    if (buildRequestForSession != null) {
                        arrayList.add(buildRequestForSession);
                        if (AppEventsCAPIManager.INSTANCE.isEnabled$facebook_core_release()) {
                            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                            AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint(buildRequestForSession);
                        }
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void flush(FlushReason flushReason) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(flushReason, "reason");
                singleThreadExecutor.execute(new Runnable() {
                    public final void run() {
                        AppEventQueue.m3549flush$lambda2(FlushReason.this);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: flush$lambda-2  reason: not valid java name */
    public static final void m3549flush$lambda2(FlushReason flushReason) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(flushReason, "$reason");
                flushAndWait(flushReason);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void flushAndWait(com.facebook.appevents.FlushReason r4) {
        /*
            java.lang.Class<com.facebook.appevents.AppEventQueue> r0 = com.facebook.appevents.AppEventQueue.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "reason"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)     // Catch:{ all -> 0x0051 }
            com.facebook.appevents.AppEventStore r1 = com.facebook.appevents.AppEventStore.INSTANCE     // Catch:{ all -> 0x0051 }
            com.facebook.appevents.PersistedEvents r1 = com.facebook.appevents.AppEventStore.readAndClearStore()     // Catch:{ all -> 0x0051 }
            com.facebook.appevents.AppEventCollection r2 = appEventCollection     // Catch:{ all -> 0x0051 }
            r2.addPersistedEvents(r1)     // Catch:{ all -> 0x0051 }
            com.facebook.appevents.AppEventCollection r1 = appEventCollection     // Catch:{ Exception -> 0x0048 }
            com.facebook.appevents.FlushStatistics r4 = sendEventsToServer(r4, r1)     // Catch:{ Exception -> 0x0048 }
            if (r4 == 0) goto L_0x0047
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "com.facebook.sdk.APP_EVENTS_FLUSHED"
            r1.<init>(r2)     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED"
            int r3 = r4.getNumEvents()     // Catch:{ all -> 0x0051 }
            r1.putExtra(r2, r3)     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT"
            com.facebook.appevents.FlushResult r4 = r4.getResult()     // Catch:{ all -> 0x0051 }
            r1.putExtra(r2, r4)     // Catch:{ all -> 0x0051 }
            com.facebook.FacebookSdk r4 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0051 }
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0051 }
            androidx.localbroadcastmanager.content.LocalBroadcastManager r4 = androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(r4)     // Catch:{ all -> 0x0051 }
            r4.sendBroadcast(r1)     // Catch:{ all -> 0x0051 }
        L_0x0047:
            return
        L_0x0048:
            r4 = move-exception
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "Caught unexpected exception while flushing app events: "
            android.util.Log.w(r1, r2, r4)     // Catch:{ all -> 0x0051 }
            return
        L_0x0051:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventQueue.flushAndWait(com.facebook.appevents.FlushReason):void");
    }

    /* renamed from: flushRunnable$lambda-0  reason: not valid java name */
    public static final void m3550flushRunnable$lambda0() {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                scheduledFuture = null;
                if (AppEventsLogger.Companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                    flushAndWait(FlushReason.TIMER);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final Set<AccessTokenAppIdPair> getKeySet() {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return appEventCollection.keySet();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void handleResponse(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        String str;
        AccessTokenAppIdPair accessTokenAppIdPair2 = accessTokenAppIdPair;
        SessionEventsState sessionEventsState2 = sessionEventsState;
        FlushStatistics flushStatistics2 = flushStatistics;
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair2, "accessTokenAppId");
                Intrinsics.checkNotNullParameter(graphRequest, "request");
                Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
                Intrinsics.checkNotNullParameter(sessionEventsState2, "appEvents");
                Intrinsics.checkNotNullParameter(flushStatistics2, "flushState");
                FacebookRequestError error = graphResponse.getError();
                String str2 = "Success";
                FlushResult flushResult = FlushResult.SUCCESS;
                boolean z = true;
                if (error != null) {
                    if (error.getErrorCode() == -1) {
                        str2 = "Failed: No Connectivity";
                        flushResult = FlushResult.NO_CONNECTIVITY;
                    } else {
                        str2 = String.format("Failed:\n  Response: %s\n  Error %s", Arrays.copyOf(new Object[]{graphResponse.toString(), error.toString()}, 2));
                        Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
                        flushResult = FlushResult.SERVER_ERROR;
                    }
                }
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
                    try {
                        str = new JSONArray((String) graphRequest.getTag()).toString(2);
                        Intrinsics.checkNotNullExpressionValue(str, "{\n            val jsonArray = JSONArray(eventsJsonString)\n            jsonArray.toString(2)\n          }");
                    } catch (JSONException unused) {
                        str = "<Can't encode events for debug logging>";
                    }
                    Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", String.valueOf(graphRequest.getGraphObject()), str2, str);
                }
                if (error == null) {
                    z = false;
                }
                sessionEventsState2.clearInFlightAndStats(z);
                if (flushResult == FlushResult.NO_CONNECTIVITY) {
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new Runnable(sessionEventsState2) {
                        public final /* synthetic */ SessionEventsState f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            AppEventQueue.m3551handleResponse$lambda5(AccessTokenAppIdPair.this, this.f$1);
                        }
                    });
                }
                if (flushResult != FlushResult.SUCCESS && flushStatistics.getResult() != FlushResult.NO_CONNECTIVITY) {
                    flushStatistics2.setResult(flushResult);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: handleResponse$lambda-5  reason: not valid java name */
    public static final void m3551handleResponse$lambda5(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "$accessTokenAppId");
                Intrinsics.checkNotNullParameter(sessionEventsState, "$appEvents");
                AppEventStore appEventStore = AppEventStore.INSTANCE;
                AppEventStore.persistEvents(accessTokenAppIdPair, sessionEventsState);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void persistToDisk() {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                singleThreadExecutor.execute($$Lambda$62J7sj8JMyiA3W4h7e07NMp8t6E.INSTANCE);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: persistToDisk$lambda-1  reason: not valid java name */
    public static final void m3552persistToDisk$lambda1() {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                AppEventStore appEventStore = AppEventStore.INSTANCE;
                AppEventStore.persistEvents(appEventCollection);
                appEventCollection = new AppEventCollection();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @VisibleForTesting(otherwise = 2)
    public static final FlushStatistics sendEventsToServer(FlushReason flushReason, AppEventCollection appEventCollection2) {
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(flushReason, "reason");
            Intrinsics.checkNotNullParameter(appEventCollection2, "appEventCollection");
            FlushStatistics flushStatistics = new FlushStatistics();
            List<GraphRequest> buildRequests = buildRequests(appEventCollection2, flushStatistics);
            if (!(!buildRequests.isEmpty())) {
                return null;
            }
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.getNumEvents()), flushReason.toString());
            for (GraphRequest executeAndWait : buildRequests) {
                executeAndWait.executeAndWait();
            }
            return flushStatistics;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
