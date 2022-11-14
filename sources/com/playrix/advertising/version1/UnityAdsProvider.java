package com.playrix.advertising.version1;

import android.app.Activity;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.advertising.version1.ProviderBase;
import com.swrve.sdk.rest.RESTClient;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MetaData;
import com.unity3d.services.core.log.DeviceLogLevel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class UnityAdsProvider extends ProviderBase {
    public final AtomicBoolean _isClicked = new AtomicBoolean(false);
    public final Map<String, Status> _placementAds = new HashMap();

    public enum Status {
        LOADING,
        READY
    }

    private boolean isAvailable() {
        return UnityAds.isSupported();
    }

    /* access modifiers changed from: private */
    public void logInfo(String str, String str2, String str3) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("[");
        outline24.append(getName());
        outline24.append("] ");
        outline24.append(str2);
        outline24.append(" location ");
        outline24.append(str);
        outline24.append(" ");
        outline24.append(str3);
        callOnLog(outline24.toString());
    }

    public boolean cache(int i, final String str) {
        Activity activity = getActivity();
        if (!isInitialized() || !isModeAvailable(i) || activity == null) {
            return false;
        }
        synchronized (this._placementAds) {
            if (this._placementAds.get(str) != null) {
                return false;
            }
            this._placementAds.put(str, Status.LOADING);
            UnityAds.load(str, new IUnityAdsLoadListener() {
                public void onUnityAdsAdLoaded(String str) {
                    synchronized (UnityAdsProvider.this._placementAds) {
                        UnityAdsProvider.this._placementAds.put(str, Status.READY);
                    }
                }

                public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
                    UnityAdsProvider unityAdsProvider = UnityAdsProvider.this;
                    unityAdsProvider.logInfo(str, "onUnityAdsFailedToLoad", unityAdsLoadError + RESTClient.COMMA_SEPARATOR + str2);
                    synchronized (UnityAdsProvider.this._placementAds) {
                        UnityAdsProvider.this._placementAds.remove(str);
                    }
                }
            });
            return true;
        }
    }

    public boolean doBackPressed(Activity activity) {
        return false;
    }

    public void doCreate(Activity activity, Map<String, String> map) {
        if (!isAvailable()) {
            setInitializationState(3);
            return;
        }
        boolean booleanParameter = ProviderBase.getBooleanParameter(map, "testMode");
        String str = map.get("gameId");
        if (str == null) {
            logInfo("not found setup settings");
            setInitializationState(3);
            return;
        }
        setInitializationState(2);
        setEnvironment(map);
        UnityAds.initialize(activity.getApplicationContext(), str, booleanParameter, new IUnityAdsInitializationListener() {
            public void onInitializationComplete() {
                UnityAdsProvider.this.setInitializationState(1);
            }

            public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                UnityAdsProvider unityAdsProvider = UnityAdsProvider.this;
                unityAdsProvider.logInfo("initialization error", "onInitializationFailed", unityAdsInitializationError + RESTClient.COMMA_SEPARATOR + str);
                UnityAdsProvider.this.setInitializationState(3);
            }
        });
    }

    public void doDestroy(Activity activity) {
    }

    public void doPause(Activity activity) {
    }

    public void doResume(Activity activity) {
    }

    public void doStart(Activity activity) {
    }

    public void doStop(Activity activity) {
    }

    public int getCacheMode() {
        return 0;
    }

    public String getName() {
        return DeviceLogLevel.LOG_TAG;
    }

    public String getVersion() {
        return UnityAds.getVersion();
    }

    public boolean isModeAvailable(int i) {
        return isAvailable() && i == 1;
    }

    public boolean isReady(int i, String str) {
        boolean z = false;
        if (!isInitialized() || !isModeAvailable(i) || isShowing()) {
            return false;
        }
        synchronized (this._placementAds) {
            Status status = this._placementAds.get(str);
            if (status != null && status == Status.READY) {
                z = true;
            }
        }
        return z;
    }

    public void setEnvironment(Map<String, String> map) {
        UnityAds.setDebugMode(ProviderBase.getBooleanParameter(map, "verboseLogging"));
        Activity activity = getActivity();
        if (activity != null) {
            if (map.containsKey(ProviderBase.ParameterName.HAS_USER_CONSENT)) {
                MetaData metaData = new MetaData(activity.getApplicationContext());
                metaData.set("gdpr.consent", (Object) Boolean.valueOf(ProviderBase.getBooleanParameter(map, ProviderBase.ParameterName.HAS_USER_CONSENT)));
                metaData.commit();
            }
            if (map.containsKey(ProviderBase.ParameterName.DO_NOT_SELL)) {
                MetaData metaData2 = new MetaData(activity.getApplicationContext());
                metaData2.set("privacy.consent", (Object) Boolean.valueOf(!ProviderBase.getBooleanParameter(map, ProviderBase.ParameterName.DO_NOT_SELL)));
                metaData2.commit();
            }
        }
    }

    public boolean show(int i, String str) {
        Activity activity = getActivity();
        if (!isReady(i, str) || activity == null) {
            return false;
        }
        synchronized (this._placementAds) {
            this._placementAds.remove(str);
        }
        this._isClicked.set(false);
        UnityAds.show(activity, str, (IUnityAdsShowListener) new IUnityAdsShowListener() {
            public void onUnityAdsShowClick(String str) {
                UnityAdsProvider.this.logInfo(str, "onUnityAdsShowClick", "");
                if (!UnityAdsProvider.this._isClicked.get()) {
                    UnityAdsProvider.this._isClicked.set(true);
                    UnityAdsProvider.this.callOnShowFinish(2);
                }
            }

            public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
                UnityAdsProvider.this.logInfo(str, "onUnityAdsShowComplete", unityAdsShowCompletionState.toString());
                int i = 1;
                if (UnityAdsProvider.this._isClicked.get()) {
                    UnityAdsProvider.this.callOnShowDone(2, "", true);
                    return;
                }
                UnityAdsProvider unityAdsProvider = UnityAdsProvider.this;
                if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.COMPLETED) {
                    i = 2;
                }
                unityAdsProvider.callOnShowFinishDone(i, "", false);
            }

            public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
                String str3 = unityAdsShowError + RESTClient.COMMA_SEPARATOR + str2;
                UnityAdsProvider.this.logInfo(str, "onUnityAdsShowFailure", str3);
                UnityAdsProvider.this.callOnShowDone(0, str3, false);
            }

            public void onUnityAdsShowStart(String str) {
                UnityAdsProvider.this.logInfo(str, "onUnityAdsShowStart", "");
                UnityAdsProvider.this.callOnShowStart();
            }
        });
        return true;
    }
}
