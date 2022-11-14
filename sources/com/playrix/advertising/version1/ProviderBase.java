package com.playrix.advertising.version1;

import android.app.Activity;
import android.content.Intent;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.playrix.advertising.version1.ProviderInterface;
import java.util.Map;

public abstract class ProviderBase implements ProviderInterface {
    public Activity _activity = null;
    public boolean _activityResumed = false;
    public boolean _activityStarted = false;
    public ProviderInterface.Callbacks _callbacks = null;
    public Map<String, String> _initializeParameters = null;
    public boolean _isShowing = false;
    public int _state = 0;

    public final class ParameterName {
        public static final String DO_NOT_SELL = "trackingOptOut";
        public static final String HAS_USER_CONSENT = "usePrivateInfo";

        public ParameterName() {
        }
    }

    /* access modifiers changed from: private */
    public void callDoCreate(Activity activity, Map<String, String> map) {
        if (!ProviderAdapter.onInitializeAsProvider(getClass())) {
            logInfo("Already initialized as adapter");
            setInitializationState(3);
            return;
        }
        doCreate(activity, map);
    }

    public static String getAdvertisingTypeName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "Unknown" : "MoreApps" : "RewardedVideo" : "Intersititial";
    }

    public static boolean getBooleanParameter(Map<String, String> map, String str) {
        String str2 = map.get(str);
        return str2 != null && (str2.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || str2.equalsIgnoreCase("yes") || str2.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_YES));
    }

    public static String getMethodName() {
        try {
            return new Exception().getStackTrace()[2].getMethodName();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String[] getStringListParameter(Map<String, String> map, String str) {
        String[] split;
        String str2 = map.get(str);
        if (str2 == null || (split = str2.split(",")) == null || split.length == 0) {
            return null;
        }
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        return split;
    }

    public void assertInfo(String str) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("[");
        outline24.append(getName());
        outline24.append("] ");
        outline24.append(getMethodName());
        outline24.append(" ");
        outline24.append(str);
        callOnAssert(outline24.toString());
    }

    public boolean cache(int i, String str) {
        return false;
    }

    public synchronized void callOnAssert(String str) {
        if (this._callbacks != null) {
            this._callbacks.onAssert(str);
        }
    }

    public synchronized void callOnLoadFailed(int i, String str, String str2) {
        if (this._callbacks != null) {
            this._callbacks.onLoadFailed(i, str, str2);
        }
    }

    public synchronized void callOnLoadSuccess(int i, String str, String str2) {
        if (this._callbacks != null) {
            this._callbacks.onLoadSuccess(i, str, str2);
        }
    }

    public synchronized void callOnLog(String str) {
        if (this._callbacks != null) {
            this._callbacks.onLog(str);
        }
    }

    public synchronized void callOnShowDone(int i, String str, boolean z) {
        this._isShowing = false;
        if (this._callbacks != null) {
            this._callbacks.onShowDone(i, str, z);
        }
    }

    public synchronized void callOnShowFinish(int i) {
        if (this._callbacks != null) {
            this._callbacks.onShowFinish(i);
        }
    }

    public synchronized void callOnShowFinishDone(int i, String str, boolean z) {
        if (i != 0) {
            callOnShowFinish(i);
        }
        callOnShowDone(i, str, z);
    }

    public synchronized void callOnShowStart() {
        this._isShowing = true;
        if (this._callbacks != null) {
            this._callbacks.onShowStart();
        }
    }

    public synchronized void callOnTrackMediation(String str) {
        if (this._callbacks != null) {
            this._callbacks.onTrackMediation(str);
        }
    }

    public boolean doActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    public abstract boolean doBackPressed(Activity activity);

    public abstract void doCreate(Activity activity, Map<String, String> map);

    public abstract void doDestroy(Activity activity);

    public abstract void doPause(Activity activity);

    public abstract void doResume(Activity activity);

    public abstract void doStart(Activity activity);

    public abstract void doStop(Activity activity);

    public void enableAutoCache(boolean z) {
    }

    public void execute() {
    }

    public synchronized Activity getActivity() {
        return this._activity;
    }

    public int getCacheMode() {
        return 1;
    }

    public String getDebugInfo() {
        return null;
    }

    public String getName() {
        return null;
    }

    public synchronized int getState() {
        return this._state;
    }

    public String getVersion() {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize(final java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, java.lang.String> r0 = r2._initializeParameters     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.app.Activity r0 = r2._activity     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0016
            android.app.Activity r0 = r2._activity     // Catch:{ all -> 0x001a }
            com.playrix.advertising.version1.ProviderBase$1 r1 = new com.playrix.advertising.version1.ProviderBase$1     // Catch:{ all -> 0x001a }
            r1.<init>(r3)     // Catch:{ all -> 0x001a }
            r0.runOnUiThread(r1)     // Catch:{ all -> 0x001a }
            goto L_0x0018
        L_0x0016:
            r2._initializeParameters = r3     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r2)
            return
        L_0x001a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.advertising.version1.ProviderBase.initialize(java.util.Map):void");
    }

    public synchronized boolean isInitialized() {
        boolean z;
        z = true;
        if (this._state != 1) {
            z = false;
        }
        return z;
    }

    public boolean isModeAvailable(int i) {
        return false;
    }

    public boolean isReady(int i, String str) {
        return false;
    }

    public synchronized boolean isShowing() {
        if (!isInitialized()) {
            return false;
        }
        return this._isShowing;
    }

    public void logInfo(String str) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("[");
        outline24.append(getName());
        outline24.append("] ");
        outline24.append(getMethodName());
        outline24.append(" ");
        outline24.append(str);
        callOnLog(outline24.toString());
    }

    public synchronized boolean onActivityResult(int i, int i2, Intent intent) {
        if (this._initializeParameters == null) {
            return false;
        }
        return doActivityResult(i, i2, intent);
    }

    public synchronized boolean onBackPressed(Activity activity) {
        if (this._activity != activity || this._initializeParameters == null) {
            return false;
        }
        return doBackPressed(activity);
    }

    public synchronized void onCreate(Activity activity) {
        if (this._activity == null) {
            this._activity = activity;
            this._activityStarted = false;
            this._activityResumed = false;
            if (this._initializeParameters != null) {
                callDoCreate(activity, this._initializeParameters);
            }
        }
    }

    public synchronized void onDestroy(Activity activity) {
        if (this._activity == activity) {
            this._activity = null;
            this._activityStarted = false;
            this._activityResumed = false;
            if (this._initializeParameters != null) {
                doDestroy(activity);
            }
        }
    }

    public synchronized void onPause(Activity activity) {
        if (this._activity == activity) {
            this._activityResumed = false;
            if (this._initializeParameters != null) {
                doPause(activity);
            }
        }
    }

    public synchronized void onResume(Activity activity) {
        if (this._activity == activity) {
            this._activityResumed = true;
            if (this._initializeParameters != null) {
                doResume(activity);
            }
        }
    }

    public synchronized void onStart(Activity activity) {
        if (this._activity == activity) {
            this._activityStarted = true;
            if (this._initializeParameters != null) {
                doStart(activity);
            }
        }
    }

    public synchronized void onStop(Activity activity) {
        if (this._activity == activity) {
            this._activityStarted = false;
            if (this._initializeParameters != null) {
                doStop(activity);
            }
        }
    }

    public synchronized void setCallbacks(ProviderInterface.Callbacks callbacks) {
        this._callbacks = callbacks;
    }

    public synchronized void setCallbacksId(int i) {
        this._callbacks = new ProviderCallbacks(i);
    }

    public void setEnvironment(Map<String, String> map) {
    }

    public void setImmersiveMode(boolean z) {
    }

    public synchronized void setInitializationState(int i) {
        this._state = i;
    }

    public boolean show(int i, String str) {
        return false;
    }
}
