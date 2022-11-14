package com.playrix.engine;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.swrve.sdk.ISwrve;
import com.swrve.sdk.ISwrveBase;
import com.swrve.sdk.Swrve;
import com.swrve.sdk.SwrveEmpty;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveIdentityResponse;
import com.swrve.sdk.SwrveImp;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.SwrveSDK;
import com.swrve.sdk.SwrveSDKBase;
import com.swrve.sdk.SwrveUser;
import com.swrve.sdk.config.SwrveConfig;
import com.swrve.sdk.rest.IRESTClient;
import com.swrve.sdk.rest.IRESTResponseListener;
import com.swrve.sdk.rest.RESTClient;
import com.swrve.sdk.rest.RESTResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class SwrveSDKWrapperBase extends SwrveSDK {
    public static final String TAG = "[EngineSwrve] ";

    public static class SwrveEmptyMod extends SwrveEmpty {
        public SwrveEmptyMod(Application application, String str) {
            super(application, str);
        }
    }

    public static class SwrveMod extends Swrve {

        public static class RESTClientProxy implements IRESTClient {
            public final IRESTClient client;

            public static class RESTResponseProxy implements IRESTResponseListener {
                public final IRESTResponseListener callback;
                public final String endpoint;

                public RESTResponseProxy(String str, IRESTResponseListener iRESTResponseListener) {
                    this.endpoint = str;
                    this.callback = iRESTResponseListener;
                }

                public void onException(Exception exc) {
                    this.callback.onException(exc);
                }

                public void onResponse(RESTResponse rESTResponse) {
                    if (this.endpoint.endsWith(SwrveImp.BATCH_EVENTS_ACTION)) {
                        final int i = rESTResponse.responseCode;
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                EngineSwrve.nativeOnEventsSent(i);
                            }
                        });
                    }
                    this.callback.onResponse(rESTResponse);
                }
            }

            public RESTClientProxy(IRESTClient iRESTClient) {
                this.client = iRESTClient;
            }

            public void get(String str, IRESTResponseListener iRESTResponseListener) {
                this.client.get(str, new RESTResponseProxy(str, iRESTResponseListener));
            }

            public void post(String str, String str2, IRESTResponseListener iRESTResponseListener) {
                this.client.post(str, str2, new RESTResponseProxy(str, iRESTResponseListener));
            }

            public void get(String str, Map<String, String> map, IRESTResponseListener iRESTResponseListener) throws UnsupportedEncodingException {
                this.client.get(str, map, new RESTResponseProxy(str, iRESTResponseListener));
            }

            public void post(String str, String str2, IRESTResponseListener iRESTResponseListener, String str3) {
                this.client.post(str, str2, new RESTResponseProxy(str, iRESTResponseListener), str3);
            }
        }

        public SwrveMod(Application application, int i, String str, SwrveConfig swrveConfig) {
            super(application, i, str, swrveConfig);
            this.restClient = new RESTClientProxy(new RESTClient(swrveConfig.getHttpTimeout()));
        }

        public static String getSdkVersion() {
            return SwrveImp.version;
        }

        private boolean identifyCachedUser(SwrveUser swrveUser, SwrveIdentityResponse swrveIdentityResponse) {
            if (swrveUser == null || !swrveUser.isVerified() || swrveUser.getSwrveUserId() != swrveUser.getExternalUserId()) {
                return false;
            }
            switchUser(swrveUser.getSwrveUserId());
            if (swrveIdentityResponse != null) {
                swrveIdentityResponse.onSuccess("Loaded from cache", swrveUser.getSwrveUserId());
            }
            return true;
        }

        private void identifyImpl(String str, SwrveIdentityResponse swrveIdentityResponse) {
            if (SwrveHelper.isNullOrEmpty(str)) {
                SwrveLogger.m2752d("External user id cannot be null or empty", new Object[0]);
                if (swrveIdentityResponse != null) {
                    swrveIdentityResponse.onError(-1, "External user id cannot be null or empty");
                    return;
                }
                return;
            }
            openLocalStorageConnection();
            if (isStarted()) {
                sendQueuedEvents();
            }
            pauseEventSending();
            SwrveUser userByExternalUserId = this.multiLayerLocalStorage.getUserByExternalUserId(str);
            if (identifyCachedUser(userByExternalUserId, swrveIdentityResponse)) {
                SwrveLogger.m2752d("Identity API call skipped, user loaded from cache. Event sending reenabled", new Object[0]);
            } else {
                identifyUnknownUser(str, swrveIdentityResponse, userByExternalUserId);
            }
        }

        private void identifyUnknownUser(String str, SwrveIdentityResponse swrveIdentityResponse, SwrveUser swrveUser) {
            this.multiLayerLocalStorage.saveUser(new SwrveUser(str, str, true));
            switchUser(str);
            if (swrveIdentityResponse != null) {
                swrveIdentityResponse.onSuccess("Created new userId", str);
            }
        }

        public void identify(String str, SwrveIdentityResponse swrveIdentityResponse) {
            try {
                identifyImpl(str, swrveIdentityResponse);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }

        public void registerActivityLifecycleCallbacks() {
            Logger.logDebug("[EngineSwrve] registerActivityLifecycleCallbacks skip!");
        }
    }

    public static synchronized ISwrve createModInstance(Application application, int i, String str, SwrveConfig swrveConfig) {
        ISwrve iSwrve;
        synchronized (SwrveSDKWrapperBase.class) {
            if (application == null) {
                SwrveHelper.logAndThrowException("Application is null");
            } else if (SwrveHelper.isNullOrEmpty(str)) {
                SwrveHelper.logAndThrowException("Api key not specified");
            }
            if (!SwrveHelper.sdkAvailable(swrveConfig.getModelBlackList())) {
                SwrveSDKBase.instance = new SwrveEmptyMod(application, str);
            }
            if (SwrveSDKBase.instance == null) {
                SwrveLogger.setLogLevel(5);
                swrveConfig.setLanguage(Engine.getDeviceLocale());
                SwrveSDKBase.instance = new SwrveMod(application, i, str, swrveConfig);
            }
            iSwrve = (ISwrve) SwrveSDKBase.instance;
        }
        return iSwrve;
    }

    public static synchronized void destroyInstance(Activity activity) {
        synchronized (SwrveSDKWrapperBase.class) {
            if (SwrveSDKBase.instance != null) {
                try {
                    onActivityDestroyed(activity);
                } catch (Exception unused) {
                    Logger.logError("[EngineSwrve] Error in onDestroy() call while recreating instance. Ignoring.");
                }
                SwrveSDKBase.instance = null;
            }
        }
    }

    public static String getSdkVersion() {
        return SwrveMod.getSdkVersion();
    }

    public static synchronized boolean isReady() {
        boolean z;
        synchronized (SwrveSDKWrapperBase.class) {
            z = (SwrveSDKBase.instance == null || SwrveSDKBase.instance.getUserId() == null) ? false : true;
        }
        return z;
    }

    public static void onActivityCreated(Activity activity) {
        ISwrveBase iSwrveBase = SwrveSDKBase.instance;
        if (iSwrveBase != null && (iSwrveBase instanceof SwrveMod)) {
            ((SwrveMod) iSwrveBase).onActivityCreated(activity, (Bundle) null);
        }
    }

    public static void onActivityDestroyed(Activity activity) {
        ISwrveBase iSwrveBase = SwrveSDKBase.instance;
        if (iSwrveBase != null && (iSwrveBase instanceof SwrveMod)) {
            ((SwrveMod) iSwrveBase).onActivityDestroyed(activity);
        }
    }

    public static void onActivityPaused(Activity activity) {
        ISwrveBase iSwrveBase = SwrveSDKBase.instance;
        if (iSwrveBase != null && (iSwrveBase instanceof SwrveMod)) {
            ((SwrveMod) iSwrveBase).onActivityPaused(activity);
        }
    }

    public static void onActivityResumed(Activity activity) {
        ISwrveBase iSwrveBase = SwrveSDKBase.instance;
        if (iSwrveBase != null && (iSwrveBase instanceof SwrveMod)) {
            ((SwrveMod) iSwrveBase).onActivityResumed(activity);
        }
    }
}
