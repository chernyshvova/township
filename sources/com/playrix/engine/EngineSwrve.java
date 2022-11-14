package com.playrix.engine;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.engine.LifeCycleActivity;
import com.playrix.engine.PushNotifications;
import com.swrve.sdk.SwrveIdentityResponse;
import com.swrve.sdk.SwrveInitMode;
import com.swrve.sdk.SwrveNotificationInternalPayloadConstants;
import com.swrve.sdk.SwrveSDKBase;
import com.swrve.sdk.SwrveUserResourcesDiffListener;
import com.swrve.sdk.config.SwrveConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class EngineSwrve {
    public static String LOG_TAG = "EngineSwrve ";
    public static final Object locker = new Object();
    public static Activity mActivity = null;
    public static boolean mIsPaused = false;
    public static volatile boolean mPushNotifsEnabled = true;
    public static boolean mSessionActive = false;

    public static class LifecycleCallbacks implements LifeCycleActivity.ILifecycleCallbacks {
        public LifecycleCallbacks() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            synchronized (EngineSwrve.locker) {
                Activity unused = EngineSwrve.mActivity = activity;
                if (SwrveSDKWrapperBase.isReady()) {
                    SwrveSDKWrapperBase.onActivityCreated(EngineSwrve.mActivity);
                }
            }
        }

        public void onActivityDestroyed(Activity activity) {
            synchronized (EngineSwrve.locker) {
                if (SwrveSDKWrapperBase.isReady()) {
                    SwrveSDKWrapperBase.onActivityDestroyed(EngineSwrve.mActivity);
                }
            }
        }

        public void onActivityPaused(Activity activity) {
            synchronized (EngineSwrve.locker) {
                if (EngineSwrve.isSessionActive() && !EngineSwrve.mIsPaused) {
                    EngineSwrve.trackEvent("App.Deactivated", (Map<String, String>) new HashMap());
                }
                boolean unused = EngineSwrve.mIsPaused = true;
                if (SwrveSDKWrapperBase.isReady()) {
                    SwrveSDKWrapperBase.onActivityPaused(EngineSwrve.mActivity);
                }
            }
        }

        public boolean onActivityResult(int i, int i2, Intent intent) {
            return false;
        }

        public void onActivityResumed(Activity activity) {
            synchronized (EngineSwrve.locker) {
                if (SwrveSDKWrapperBase.isReady()) {
                    SwrveSDKWrapperBase.onActivityResumed(EngineSwrve.mActivity);
                }
                boolean unused = EngineSwrve.mIsPaused = false;
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onLowMemory() {
        }

        public void onNewIntent(Intent intent) {
        }
    }

    public static void createActivityLifecycleCallbacks() {
        Engine.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof EngineActivity) {
                    Engine.getActivity().registerActivityLifecycleCallbacks(new LifecycleCallbacks());
                }
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }
        });
    }

    public static void downloadUserResources() {
        synchronized (locker) {
            if (!SwrveSDKWrapperBase.isReady()) {
                nativeOnUserResourcesDownloaded(1, "");
                return;
            }
            final String userId = SwrveSDKBase.getUserId();
            SwrveSDKBase.getUserResourcesDiff(new SwrveUserResourcesDiffListener() {
                public boolean mResultHandled = false;

                public void onUserResourcesDiffError(Exception exc) {
                    if (!this.mResultHandled) {
                        this.mResultHandled = true;
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                EngineSwrve.nativeOnUserResourcesDownloaded(1, "");
                            }
                        });
                    }
                }

                public void onUserResourcesDiffSuccess(Map<String, Map<String, String>> map, Map<String, Map<String, String>> map2, final String str) {
                    if (!this.mResultHandled) {
                        this.mResultHandled = true;
                        final String userId = SwrveSDKBase.getUserId();
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                String str = userId;
                                if (str == null || !str.equals(userId)) {
                                    EngineSwrve.nativeOnUserResourcesDownloaded(2, "");
                                } else {
                                    EngineSwrve.nativeOnUserResourcesDownloaded(0, str);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static boolean initialize() {
        return NativeThread.getInstance().queueInitalizeEvent(new Runnable() {
            public void run() {
                EngineSwrve.createActivityLifecycleCallbacks();
                EngineSwrve.registerPushNotificationsDelegate();
            }
        });
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isSessionActive() {
        return mSessionActive;
    }

    public static URL makeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static native void nativeOnEventsSent(int i);

    public static native void nativeOnFinishResourcesDownloadRequest(long j, int i, String str);

    public static native void nativeOnUserResourcesDownloaded(int i, String str);

    public static void passExternalUserId(String str) {
        SwrveSDKBase.identify(str, new SwrveIdentityResponse() {
            public void onError(int i, String str) {
                Logger.logError(EngineSwrve.LOG_TAG + "identify competed with error; responseCode=" + i + " " + str);
            }

            public void onSuccess(String str, String str2) {
                Logger.logDebug(EngineSwrve.LOG_TAG + "identify competed successfully; status=" + str + " swrveId=" + str2);
            }
        });
    }

    public static void registerPushNotificationsDelegate() {
        PushNotifications.registerPushNotificationsDelegate(new PushNotifications.IPushNotificationsDelegate() {
            public static final String TAG = "Swrve PushNotificationsDelegate ";

            public PushNotifications.PushNotificationData processPushNotification(Bundle bundle) {
                if (bundle.getString(SwrveNotificationInternalPayloadConstants.SWRVE_TRACKING_KEY, "").isEmpty() || !EngineSwrve.mPushNotifsEnabled) {
                    return null;
                }
                Logger.logInfo("Swrve PushNotificationsDelegate Processing Swrve notification");
                String string = GlobalConstants.getString("notif_channel_swrve_default", "");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sound", "default");
                    jSONObject.put("source", "swrve");
                    jSONObject.put("message", bundle.getString("message", bundle.getString("text", "")));
                    jSONObject.put("channel", bundle.getString("notifChannel", string));
                    jSONObject.put("category", Notifications.defaultCategoryId());
                    boolean z = false;
                    String string2 = bundle.getString(SwrveNotificationInternalPayloadConstants.SWRVE_NESTED_JSON_PAYLOAD_KEY, "");
                    if (!string2.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject(string2).getJSONObject("payload");
                        if (jSONObject2 != null) {
                            jSONObject.put(Notifications.PAYLOAD_KEY, jSONObject2);
                            z = true;
                        }
                    }
                    if (!z) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("payload", bundle.getString("payload", ""));
                        jSONObject.put(Notifications.PAYLOAD_KEY, jSONObject3);
                    }
                } catch (JSONException e) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Swrve PushNotificationsDelegate Error in extractPushData: ");
                    outline24.append(e.toString());
                    Logger.logError(outline24.toString());
                }
                return new PushNotifications.PushNotificationData(jSONObject);
            }
        });
    }

    public static void registerPushToken(String str) {
        synchronized (locker) {
            if (SwrveSDKBase.getInstance() == null || mActivity == null) {
                Logger.logError(LOG_TAG + "registerPushToken called before init");
            } else {
                Logger.logDebug(LOG_TAG + "registerPushToken");
                SwrveSDKWrapper.registerPushToken(str);
            }
        }
    }

    public static void sendQueuedEvents() {
        synchronized (locker) {
            SwrveSDKBase.sendQueuedEvents();
        }
    }

    public static void setPushNotificationsEnabled(boolean z) {
        mPushNotifsEnabled = z;
    }

    public static void startSession(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        synchronized (locker) {
            try {
                if (SwrveSDKBase.getInstance() == null) {
                    Logger.logDebug(LOG_TAG + "Creating swrve instance");
                } else if (SwrveSDKBase.getUserId() == null || !SwrveSDKBase.getUserId().equals(str)) {
                    Logger.logDebug(LOG_TAG + "Recreating swrve instance because of userId change");
                    SwrveSDKWrapperBase.destroyInstance(mActivity);
                } else {
                    Logger.logDebug(LOG_TAG + "swrve sessionStart");
                    if (!mSessionActive) {
                        SwrveSDKBase.sessionStart();
                        mSessionActive = true;
                    }
                    return;
                }
                SwrveConfig swrveConfig = new SwrveConfig();
                swrveConfig.setInitMode(SwrveInitMode.MANAGED);
                swrveConfig.setAutoDownloadCampaignsAndResources(false);
                swrveConfig.setAutoStartLastUser(false);
                SwrveSDKWrapper.configuration(swrveConfig);
                swrveConfig.setAppStore(str3);
                swrveConfig.generateUrls(i);
                swrveConfig.setEventsUrl(makeUrl(str4));
                swrveConfig.setIdentityUrl(makeUrl(str5));
                swrveConfig.setContentUrl(makeUrl(str6));
                SwrveSDKWrapperBase.createModInstance(Engine.getApplication(), i, str2, swrveConfig);
                SwrveSDKWrapperBase.onActivityCreated(mActivity);
                mSessionActive = true;
                passExternalUserId(str);
            } catch (Exception e) {
                Logger.logError(LOG_TAG + e.toString());
            }
        }
    }

    public static void stopSession() {
        synchronized (locker) {
            Logger.logDebug(LOG_TAG + "Stop session");
            mSessionActive = false;
            SwrveSDKBase.sessionEnd();
            SwrveSDKBase.sendQueuedEvents();
            SwrveSDKBase.stopTracking();
            SwrveSDKWrapperBase.destroyInstance(mActivity);
        }
    }

    public static void trackCurrencyGiven(String str, int i) {
        synchronized (locker) {
            SwrveSDKBase.currencyGiven(str, (double) i);
            if (mIsPaused) {
                SwrveSDKBase.flushToDisk();
            }
        }
    }

    public static void trackEvent(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (str2 != null && !str2.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder();
                GeneratedOutlineSupport.outline34(sb, LOG_TAG, "trackEvent: payload parse exception: ", str2, " ");
                sb.append(e.getMessage());
                Logger.logError(sb.toString());
            }
        }
        trackEvent(str, (Map<String, String>) hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void trackIAP(java.lang.String r7, java.lang.String r8, double r9, java.lang.String r11, com.swrve.sdk.SwrveIAPRewards r12, java.lang.String r13, java.lang.String r14) {
        /*
            java.lang.Object r7 = locker
            monitor-enter(r7)
            java.lang.String r0 = com.swrve.sdk.SwrveSDKBase.getUserId()     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r7)     // Catch:{ all -> 0x002d }
            return
        L_0x000b:
            boolean r0 = isNullOrEmpty(r13)     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0013
            java.lang.String r13 = "{\"emptyReceipt\":\"empty\"}"
        L_0x0013:
            r5 = r13
            boolean r13 = isNullOrEmpty(r14)     // Catch:{ all -> 0x002d }
            if (r13 == 0) goto L_0x001c
            java.lang.String r14 = "emptySignature"
        L_0x001c:
            r6 = r14
            r0 = r8
            r1 = r9
            r3 = r11
            r4 = r12
            com.playrix.engine.SwrveSDKWrapper.trackIap(r0, r1, r3, r4, r5, r6)     // Catch:{ all -> 0x002d }
            boolean r8 = mIsPaused     // Catch:{ all -> 0x002d }
            if (r8 == 0) goto L_0x002b
            com.swrve.sdk.SwrveSDKBase.flushToDisk()     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r7)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x002d }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.EngineSwrve.trackIAP(java.lang.String, java.lang.String, double, java.lang.String, com.swrve.sdk.SwrveIAPRewards, java.lang.String, java.lang.String):void");
    }

    public static void trackPurchase(String str, int i, String str2, int i2) {
        synchronized (locker) {
            SwrveSDKBase.purchase(str, str2, i, i2);
            if (mIsPaused) {
                SwrveSDKBase.flushToDisk();
            }
        }
    }

    public static void userUpdate(Map<String, String> map) {
        synchronized (locker) {
            if (SwrveSDKWrapperBase.isReady()) {
                SwrveSDKBase.userUpdate(map);
            }
        }
    }

    public static void downloadUserResources(final long j) {
        synchronized (locker) {
            if (!SwrveSDKWrapperBase.isReady()) {
                nativeOnFinishResourcesDownloadRequest(j, 1, "");
                return;
            }
            final String userId = SwrveSDKBase.getUserId();
            SwrveSDKBase.getUserResourcesDiff(new SwrveUserResourcesDiffListener() {
                public boolean mResultHandled = false;

                public void onUserResourcesDiffError(Exception exc) {
                    if (!this.mResultHandled) {
                        this.mResultHandled = true;
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                EngineSwrve.nativeOnFinishResourcesDownloadRequest(j, 1, "");
                            }
                        });
                    }
                }

                public void onUserResourcesDiffSuccess(Map<String, Map<String, String>> map, Map<String, Map<String, String>> map2, final String str) {
                    if (!this.mResultHandled) {
                        this.mResultHandled = true;
                        final String userId = SwrveSDKBase.getUserId();
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                String str = userId;
                                if (str == null || !str.equals(userId)) {
                                    EngineSwrve.nativeOnFinishResourcesDownloadRequest(j, 2, "");
                                } else {
                                    EngineSwrve.nativeOnFinishResourcesDownloadRequest(j, 0, str);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static void trackEvent(String str, Map<String, String> map) {
        synchronized (locker) {
            SwrveSDKBase.event(str, map);
            if (mIsPaused) {
                SwrveSDKBase.flushToDisk();
            }
        }
    }
}
