package com.microsoft.appcenter.analytics;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.microsoft.appcenter.AbstractAppCenterService;
import com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget;
import com.microsoft.appcenter.analytics.channel.AnalyticsListener;
import com.microsoft.appcenter.analytics.channel.AnalyticsValidator;
import com.microsoft.appcenter.analytics.channel.SessionTracker;
import com.microsoft.appcenter.analytics.ingestion.models.json.EventLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.json.PageLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.json.StartSessionLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.one.json.CommonSchemaEventLogFactory;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.DefaultChannel;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.context.SessionContext;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Analytics extends AbstractAppCenterService {
    @SuppressLint({"StaticFieldLeak"})
    public static Analytics sInstance;
    public AnalyticsListener mAnalyticsListener;
    public Channel.Listener mAnalyticsTransmissionTargetListener;
    public AnalyticsValidator mAnalyticsValidator;
    public boolean mAutoPageTrackingEnabled = false;
    public Context mContext;
    public WeakReference<Activity> mCurrentActivity;
    public final Map<String, LogFactory> mFactories;
    public SessionTracker mSessionTracker;
    public boolean mStartedFromApp;
    public long mTransmissionInterval;

    public Analytics() {
        HashMap hashMap = new HashMap();
        this.mFactories = hashMap;
        hashMap.put("startSession", new StartSessionLogFactory());
        this.mFactories.put("page", new PageLogFactory());
        this.mFactories.put("event", new EventLogFactory());
        this.mFactories.put("commonSchemaEvent", new CommonSchemaEventLogFactory());
        new HashMap();
        this.mTransmissionInterval = TimeUnit.SECONDS.toMillis(3);
    }

    public static synchronized Analytics getInstance() {
        Analytics analytics;
        synchronized (Analytics.class) {
            if (sInstance == null) {
                sInstance = new Analytics();
            }
            analytics = sInstance;
        }
        return analytics;
    }

    public synchronized void applyEnabledState(boolean z) {
        if (z) {
            ((DefaultChannel) this.mChannel).addGroup("group_analytics_critical", 50, 3000, 3, (Ingestion) null, new Channel.GroupListener() {
                public void onBeforeSending(Log log) {
                    AnalyticsListener analyticsListener = Analytics.this.mAnalyticsListener;
                    if (analyticsListener != null) {
                        analyticsListener.onBeforeSending(log);
                    }
                }

                public void onFailure(Log log, Exception exc) {
                    AnalyticsListener analyticsListener = Analytics.this.mAnalyticsListener;
                    if (analyticsListener != null) {
                        analyticsListener.onSendingFailed(log, exc);
                    }
                }

                public void onSuccess(Log log) {
                    AnalyticsListener analyticsListener = Analytics.this.mAnalyticsListener;
                    if (analyticsListener != null) {
                        analyticsListener.onSendingSucceeded(log);
                    }
                }
            });
            startAppLevelFeatures();
        } else {
            ((DefaultChannel) this.mChannel).removeGroup("group_analytics_critical");
            if (this.mAnalyticsValidator != null) {
                Channel channel = this.mChannel;
                ((DefaultChannel) channel).mListeners.remove(this.mAnalyticsValidator);
                this.mAnalyticsValidator = null;
            }
            if (this.mSessionTracker != null) {
                Channel channel2 = this.mChannel;
                ((DefaultChannel) channel2).mListeners.remove(this.mSessionTracker);
                if (this.mSessionTracker != null) {
                    SessionContext instance = SessionContext.getInstance();
                    synchronized (instance) {
                        instance.mSessions.clear();
                        SharedPreferencesManager.remove("sessions");
                    }
                    this.mSessionTracker = null;
                } else {
                    throw null;
                }
            }
            if (this.mAnalyticsTransmissionTargetListener != null) {
                Channel channel3 = this.mChannel;
                ((DefaultChannel) channel3).mListeners.remove(this.mAnalyticsTransmissionTargetListener);
                this.mAnalyticsTransmissionTargetListener = null;
            }
        }
    }

    public Channel.GroupListener getChannelListener() {
        return new Channel.GroupListener() {
            public void onBeforeSending(Log log) {
                AnalyticsListener analyticsListener = Analytics.this.mAnalyticsListener;
                if (analyticsListener != null) {
                    analyticsListener.onBeforeSending(log);
                }
            }

            public void onFailure(Log log, Exception exc) {
                AnalyticsListener analyticsListener = Analytics.this.mAnalyticsListener;
                if (analyticsListener != null) {
                    analyticsListener.onSendingFailed(log, exc);
                }
            }

            public void onSuccess(Log log) {
                AnalyticsListener analyticsListener = Analytics.this.mAnalyticsListener;
                if (analyticsListener != null) {
                    analyticsListener.onSendingSucceeded(log);
                }
            }
        };
    }

    public String getGroupName() {
        return "group_analytics";
    }

    public Map<String, LogFactory> getLogFactories() {
        return this.mFactories;
    }

    public String getLoggerTag() {
        return "AppCenterAnalytics";
    }

    public String getServiceName() {
        return "Analytics";
    }

    public long getTriggerInterval() {
        return this.mTransmissionInterval;
    }

    public boolean isAppSecretRequired() {
        return false;
    }

    public synchronized void onActivityPaused(Activity activity) {
        final C29394 r2 = new Runnable() {
            public void run() {
                Analytics.this.mCurrentActivity = null;
            }
        };
        post(new Runnable() {
            public void run() {
                r2.run();
                SessionTracker sessionTracker = Analytics.this.mSessionTracker;
                if (sessionTracker != null) {
                    AppCenterLog.debug("AppCenterAnalytics", "onActivityPaused");
                    sessionTracker.mLastPausedTime = Long.valueOf(SystemClock.elapsedRealtime());
                }
            }
        }, r2, r2);
    }

    public synchronized void onActivityResumed(final Activity activity) {
        final C29372 r0 = new Runnable() {
            public void run() {
                Analytics.this.mCurrentActivity = new WeakReference<>(activity);
            }
        };
        post(new Runnable() {
            public void run() {
                r0.run();
                Analytics.this.processOnResume(activity);
            }
        }, r0, r0);
    }

    public void onConfigurationUpdated(String str, String str2) {
        this.mStartedFromApp = true;
        startAppLevelFeatures();
        setDefaultTransmissionTarget(str2);
    }

    public synchronized void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z) {
        this.mContext = context;
        this.mStartedFromApp = z;
        super.onStarted(context, channel, str, str2, z);
        setDefaultTransmissionTarget(str2);
    }

    public synchronized void post(Runnable runnable) {
        super.post(runnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        if (r2 == false) goto L_0x0099;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void processOnResume(android.app.Activity r15) {
        /*
            r14 = this;
            com.microsoft.appcenter.analytics.channel.SessionTracker r0 = r14.mSessionTracker
            if (r0 == 0) goto L_0x00d2
            r1 = 0
            if (r0 == 0) goto L_0x00d1
            java.lang.String r2 = "AppCenterAnalytics"
            java.lang.String r3 = "onActivityResumed"
            com.microsoft.appcenter.utils.AppCenterLog.debug(r2, r3)
            long r3 = android.os.SystemClock.elapsedRealtime()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r0.mLastResumedTime = r3
            java.util.UUID r3 = r0.mSid
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0072
            java.lang.Long r3 = r0.mLastPausedTime
            if (r3 != 0) goto L_0x0023
            goto L_0x006f
        L_0x0023:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r8 = r0.mLastQueuedLogTime
            long r6 = r6 - r8
            r8 = 20000(0x4e20, double:9.8813E-320)
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0032
            r3 = 1
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            java.lang.Long r6 = r0.mLastResumedTime
            long r6 = r6.longValue()
            java.lang.Long r10 = r0.mLastPausedTime
            long r10 = r10.longValue()
            long r12 = r0.mLastQueuedLogTime
            long r10 = java.lang.Math.max(r10, r12)
            long r6 = r6 - r10
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x004c
            r6 = 1
            goto L_0x004d
        L_0x004c:
            r6 = 0
        L_0x004d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "noLogSentForLong="
            r7.append(r8)
            r7.append(r3)
            java.lang.String r8 = " wasBackgroundForLong="
            r7.append(r8)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            com.microsoft.appcenter.utils.AppCenterLog.debug(r2, r7)
            if (r3 == 0) goto L_0x006f
            if (r6 == 0) goto L_0x006f
            r2 = 1
            goto L_0x0070
        L_0x006f:
            r2 = 0
        L_0x0070:
            if (r2 == 0) goto L_0x0099
        L_0x0072:
            java.util.UUID r2 = java.util.UUID.randomUUID()
            r0.mSid = r2
            com.microsoft.appcenter.utils.context.SessionContext r2 = com.microsoft.appcenter.utils.context.SessionContext.getInstance()
            java.util.UUID r3 = r0.mSid
            r2.addSession(r3)
            long r2 = android.os.SystemClock.elapsedRealtime()
            r0.mLastQueuedLogTime = r2
            com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog r2 = new com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog
            r2.<init>()
            java.util.UUID r3 = r0.mSid
            r2.sid = r3
            com.microsoft.appcenter.channel.Channel r3 = r0.mChannel
            java.lang.String r0 = r0.mGroupName
            com.microsoft.appcenter.channel.DefaultChannel r3 = (com.microsoft.appcenter.channel.DefaultChannel) r3
            r3.enqueue(r2, r0, r5)
        L_0x0099:
            boolean r0 = r14.mAutoPageTrackingEnabled
            if (r0 == 0) goto L_0x00d2
            java.lang.Class r15 = r15.getClass()
            java.lang.String r15 = r15.getSimpleName()
            java.lang.String r0 = "Activity"
            boolean r0 = r15.endsWith(r0)
            if (r0 == 0) goto L_0x00be
            int r0 = r15.length()
            r2 = 8
            if (r0 <= r2) goto L_0x00be
            int r0 = r15.length()
            int r0 = r0 - r2
            java.lang.String r15 = r15.substring(r4, r0)
        L_0x00be:
            com.microsoft.appcenter.analytics.ingestion.models.PageLog r0 = new com.microsoft.appcenter.analytics.ingestion.models.PageLog
            r0.<init>()
            r0.name = r15
            r0.properties = r1
            com.microsoft.appcenter.channel.Channel r15 = r14.mChannel
            com.microsoft.appcenter.channel.DefaultChannel r15 = (com.microsoft.appcenter.channel.DefaultChannel) r15
            java.lang.String r1 = "group_analytics"
            r15.enqueue(r0, r1, r5)
            goto L_0x00d2
        L_0x00d1:
            throw r1
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.analytics.Analytics.processOnResume(android.app.Activity):void");
    }

    @WorkerThread
    public final void setDefaultTransmissionTarget(String str) {
        if (str != null) {
            final AnalyticsTransmissionTarget analyticsTransmissionTarget = new AnalyticsTransmissionTarget(str, (AnalyticsTransmissionTarget) null);
            AppCenterLog.debug("AppCenterAnalytics", "Created transmission target with token " + str);
            C29361 r4 = new Runnable() {
                public void run() {
                    AnalyticsTransmissionTarget analyticsTransmissionTarget = analyticsTransmissionTarget;
                    Analytics analytics = Analytics.this;
                    Context context = analytics.mContext;
                    Channel channel = analytics.mChannel;
                    analyticsTransmissionTarget.mContext = context;
                    ((DefaultChannel) channel).mListeners.add(analyticsTransmissionTarget.mPropertyConfigurator);
                }
            };
            post(r4, r4, r4);
        }
    }

    @WorkerThread
    public final void startAppLevelFeatures() {
        Activity activity;
        if (this.mStartedFromApp) {
            AnalyticsValidator analyticsValidator = new AnalyticsValidator();
            this.mAnalyticsValidator = analyticsValidator;
            ((DefaultChannel) this.mChannel).mListeners.add(analyticsValidator);
            SessionTracker sessionTracker = new SessionTracker(this.mChannel, "group_analytics");
            this.mSessionTracker = sessionTracker;
            ((DefaultChannel) this.mChannel).mListeners.add(sessionTracker);
            WeakReference<Activity> weakReference = this.mCurrentActivity;
            if (!(weakReference == null || (activity = (Activity) weakReference.get()) == null)) {
                processOnResume(activity);
            }
            AnalyticsTransmissionTarget.C29427 r0 = new AbstractChannelListener() {
                public void onPreparingLog(@NonNull Log log, @NonNull String str) {
                }
            };
            this.mAnalyticsTransmissionTargetListener = r0;
            ((DefaultChannel) this.mChannel).mListeners.add(r0);
        }
    }
}
