package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityLifecycleTracker.kt */
public final class ActivityLifecycleTracker {
    public static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
    public static final ActivityLifecycleTracker INSTANCE = new ActivityLifecycleTracker();
    public static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    public static final String TAG;
    public static int activityReferences;
    public static String appId;
    public static WeakReference<Activity> currActivity;
    public static long currentActivityAppearTime;
    public static volatile ScheduledFuture<?> currentFuture;
    public static final Object currentFutureLock = new Object();
    public static volatile SessionInfo currentSession;
    public static final AtomicInteger foregroundActivityCount = new AtomicInteger(0);
    public static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    public static final AtomicBoolean tracking = new AtomicBoolean(false);

    static {
        String canonicalName = ActivityLifecycleTracker.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        TAG = canonicalName;
    }

    private final void cancelCurrentTask() {
        synchronized (currentFutureLock) {
            if (currentFuture != null) {
                ScheduledFuture<?> scheduledFuture = currentFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
            currentFuture = null;
        }
    }

    public static final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = currActivity;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public static final UUID getCurrentSessionGuid() {
        SessionInfo sessionInfo;
        if (currentSession == null || (sessionInfo = currentSession) == null) {
            return null;
        }
        return sessionInfo.getSessionId();
    }

    private final int getSessionTimeoutInSeconds() {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery != null) {
            return appSettingsWithoutQuery.getSessionTimeoutInSeconds();
        }
        Constants constants = Constants.INSTANCE;
        return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isInBackground() {
        return activityReferences == 0;
    }

    public static final boolean isTracking() {
        return tracking.get();
    }

    public static final void onActivityCreated(Activity activity) {
        singleThreadExecutor.execute($$Lambda$XOX9ESVnlXeW178B9Ol43TaNwnA.INSTANCE);
    }

    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    public static final void m3581onActivityCreated$lambda1() {
        if (currentSession == null) {
            currentSession = SessionInfo.Companion.getStoredSessionInfo();
        }
    }

    /* access modifiers changed from: private */
    public final void onActivityDestroyed(Activity activity) {
        CodelessManager codelessManager = CodelessManager.INSTANCE;
        CodelessManager.onActivityDestroyed(activity);
    }

    /* access modifiers changed from: private */
    public final void onActivityPaused(Activity activity) {
        if (foregroundActivityCount.decrementAndGet() < 0) {
            foregroundActivityCount.set(0);
            Log.w(TAG, INCORRECT_IMPL_WARNING);
        }
        cancelCurrentTask();
        long currentTimeMillis = System.currentTimeMillis();
        Utility utility = Utility.INSTANCE;
        String activityName = Utility.getActivityName(activity);
        CodelessManager codelessManager = CodelessManager.INSTANCE;
        CodelessManager.onActivityPaused(activity);
        singleThreadExecutor.execute(new Runnable(currentTimeMillis, activityName) {
            public final /* synthetic */ long f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r3;
            }

            public final void run() {
                ActivityLifecycleTracker.m3582onActivityPaused$lambda6(this.f$0, this.f$1);
            }
        });
    }

    /* renamed from: onActivityPaused$lambda-6  reason: not valid java name */
    public static final void m3582onActivityPaused$lambda6(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
        }
        SessionInfo sessionInfo = currentSession;
        if (sessionInfo != null) {
            sessionInfo.setSessionLastEventTime(Long.valueOf(j));
        }
        if (foregroundActivityCount.get() <= 0) {
            $$Lambda$3_sU20C6cin3z58vx2KmrQAdBZ8 r0 = new Runnable(j, str) {
                public final /* synthetic */ long f$0;
                public final /* synthetic */ String f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r3;
                }

                public final void run() {
                    ActivityLifecycleTracker.m3583onActivityPaused$lambda6$lambda4(this.f$0, this.f$1);
                }
            };
            synchronized (currentFutureLock) {
                currentFuture = singleThreadExecutor.schedule(r0, (long) INSTANCE.getSessionTimeoutInSeconds(), TimeUnit.SECONDS);
            }
        }
        long j2 = currentActivityAppearTime;
        long j3 = 0;
        if (j2 > 0) {
            j3 = (j - j2) / ((long) 1000);
        }
        AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
        AutomaticAnalyticsLogger.logActivityTimeSpentEvent(str, j3);
        SessionInfo sessionInfo2 = currentSession;
        if (sessionInfo2 != null) {
            sessionInfo2.writeSessionToDisk();
        }
    }

    /* renamed from: onActivityPaused$lambda-6$lambda-4  reason: not valid java name */
    public static final void m3583onActivityPaused$lambda6$lambda4(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
        }
        if (foregroundActivityCount.get() <= 0) {
            SessionLogger sessionLogger = SessionLogger.INSTANCE;
            SessionLogger.logDeactivateApp(str, currentSession, appId);
            SessionInfo.Companion.clearSavedSessionFromDisk();
            currentSession = null;
        }
        synchronized (currentFutureLock) {
            currentFuture = null;
        }
    }

    public static final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        currActivity = new WeakReference<>(activity);
        foregroundActivityCount.incrementAndGet();
        INSTANCE.cancelCurrentTask();
        long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        Utility utility = Utility.INSTANCE;
        String activityName = Utility.getActivityName(activity);
        CodelessManager codelessManager = CodelessManager.INSTANCE;
        CodelessManager.onActivityResumed(activity);
        MetadataIndexer metadataIndexer = MetadataIndexer.INSTANCE;
        MetadataIndexer.onActivityResumed(activity);
        SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
        SuggestedEventsManager.trackActivity(activity);
        InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
        InAppPurchaseManager.startTracking();
        singleThreadExecutor.execute(new Runnable(currentTimeMillis, activityName, activity.getApplicationContext()) {
            public final /* synthetic */ long f$0;
            public final /* synthetic */ String f$1;
            public final /* synthetic */ Context f$2;

            {
                this.f$0 = r1;
                this.f$1 = r3;
                this.f$2 = r4;
            }

            public final void run() {
                ActivityLifecycleTracker.m3584onActivityResumed$lambda2(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    /* renamed from: onActivityResumed$lambda-2  reason: not valid java name */
    public static final void m3584onActivityResumed$lambda2(long j, String str, Context context) {
        SessionInfo sessionInfo;
        Intrinsics.checkNotNullParameter(str, "$activityName");
        SessionInfo sessionInfo2 = currentSession;
        Long sessionLastEventTime = sessionInfo2 == null ? null : sessionInfo2.getSessionLastEventTime();
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
            SessionLogger sessionLogger = SessionLogger.INSTANCE;
            String str2 = appId;
            Intrinsics.checkNotNullExpressionValue(context, "appContext");
            SessionLogger.logActivateApp(str, (SourceApplicationInfo) null, str2, context);
        } else if (sessionLastEventTime != null) {
            long longValue = j - sessionLastEventTime.longValue();
            if (longValue > ((long) (INSTANCE.getSessionTimeoutInSeconds() * 1000))) {
                SessionLogger sessionLogger2 = SessionLogger.INSTANCE;
                SessionLogger.logDeactivateApp(str, currentSession, appId);
                SessionLogger sessionLogger3 = SessionLogger.INSTANCE;
                String str3 = appId;
                Intrinsics.checkNotNullExpressionValue(context, "appContext");
                SessionLogger.logActivateApp(str, (SourceApplicationInfo) null, str3, context);
                currentSession = new SessionInfo(Long.valueOf(j), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
            } else if (longValue > 1000 && (sessionInfo = currentSession) != null) {
                sessionInfo.incrementInterruptionCount();
            }
        }
        SessionInfo sessionInfo3 = currentSession;
        if (sessionInfo3 != null) {
            sessionInfo3.setSessionLastEventTime(Long.valueOf(j));
        }
        SessionInfo sessionInfo4 = currentSession;
        if (sessionInfo4 != null) {
            sessionInfo4.writeSessionToDisk();
        }
    }

    public static final void startTracking(Application application, String str) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (tracking.compareAndSet(false, true)) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.CodelessEvents, $$Lambda$8hcyK5i_zMiQ9qMOxD4eNscIJqM.INSTANCE);
            appId = str;
            application.registerActivityLifecycleCallbacks(new ActivityLifecycleTracker$startTracking$2());
        }
    }

    /* renamed from: startTracking$lambda-0  reason: not valid java name */
    public static final void m3585startTracking$lambda0(boolean z) {
        if (z) {
            CodelessManager codelessManager = CodelessManager.INSTANCE;
            CodelessManager.enable();
            return;
        }
        CodelessManager codelessManager2 = CodelessManager.INSTANCE;
        CodelessManager.disable();
    }
}
