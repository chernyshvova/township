package com.unity3d.services.ads.operation.load;

import android.text.TextUtils;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.AdModule;
import com.unity3d.services.core.configuration.InitializationNotificationCenter;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.ISDKMetricSender;
import com.unity3d.services.core.request.SDKMetricEvents;
import com.unity3d.services.core.request.SDKMetricSender;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback;
import com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class LoadModule extends AdModule<ILoadOperation, LoadOperationState> implements ILoadModule {
    public static ILoadModule _instance = null;
    public static String errorMsgFailedToCreateLoadRequest = "[UnityAds] Failed to create load request";
    public static String errorMsgInternalCommunicationFailure = "[UnityAds] Internal communication failure";
    public static String errorMsgInternalCommunicationTimeout = "[UnityAds] Internal communication timeout";
    public static String errorMsgPlacementIdNull = "[UnityAds] Placement ID cannot be null";

    public LoadModule(ISDKMetricSender iSDKMetricSender) {
        super(iSDKMetricSender);
    }

    public static ILoadModule getInstance() {
        if (_instance == null) {
            _instance = new LoadModuleDecoratorTimeout(new LoadModuleDecoratorInitializationBuffer(new LoadModule(new SDKMetricSender()), InitializationNotificationCenter.getInstance()));
        }
        return _instance;
    }

    /* access modifiers changed from: private */
    public void sendOnUnityAdsFailedToLoad(final LoadOperationState loadOperationState, final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str) {
        if (loadOperationState != null && loadOperationState.listener != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    LoadOperationState loadOperationState = loadOperationState;
                    loadOperationState.listener.onUnityAdsFailedToLoad(loadOperationState.placementId, unityAdsLoadError, str);
                }
            });
        }
    }

    public void onUnityAdsAdLoaded(String str) {
        ILoadOperation iLoadOperation = (ILoadOperation) get(str);
        if (iLoadOperation != null && iLoadOperation.getLoadOperationState() != null) {
            iLoadOperation.onUnityAdsAdLoaded(iLoadOperation.getLoadOperationState().placementId);
            remove(str);
        }
    }

    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        ILoadOperation iLoadOperation = (ILoadOperation) get(str);
        if (iLoadOperation != null && iLoadOperation.getLoadOperationState() != null) {
            iLoadOperation.onUnityAdsFailedToLoad(iLoadOperation.getLoadOperationState().placementId, unityAdsLoadError, str2);
            remove(str);
        }
    }

    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, final LoadOperationState loadOperationState) {
        if (TextUtils.isEmpty(loadOperationState.placementId)) {
            sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INVALID_ARGUMENT, errorMsgPlacementIdNull);
            return;
        }
        LoadOperation loadOperation = new LoadOperation(loadOperationState, new WebViewBridgeInvocation(this._executorService, iWebViewBridgeInvoker, new IWebViewBridgeInvocationCallback() {
            public void onFailure(String str, CallbackStatus callbackStatus) {
                final String str2;
                LoadModule.this.sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadModule.errorMsgInternalCommunicationFailure);
                if (callbackStatus == null) {
                    str2 = "invocationFailure";
                } else {
                    str2 = callbackStatus.toString();
                }
                LoadModule.this._sdkMetricSender.SendSDKMetricEventWithTag(SDKMetricEvents.native_load_callback_error, new HashMap<String, String>() {
                    {
                        put("cbs", str2);
                    }
                });
                LoadModule.this.remove(loadOperationState.f2838id);
            }

            public void onSuccess() {
            }

            public void onTimeout() {
                LoadModule.this.sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadModule.errorMsgInternalCommunicationTimeout);
                LoadModule.this.getMetricSender().SendSDKMetricEvent(SDKMetricEvents.native_load_callback_timeout);
                LoadModule.this.remove(loadOperationState.f2838id);
            }
        }));
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("headerBiddingOptions", loadOperationState.loadOptions.getData());
            jSONObject.put("options", jSONObject2);
            jSONObject.put("listenerId", loadOperation.getId());
            jSONObject.put(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID, loadOperationState.placementId);
            jSONObject.put("time", Device.getElapsedRealtime());
            set(loadOperation);
            loadOperation.invoke(loadOperationState.configuration.getWebViewBridgeTimeout(), jSONObject);
        } catch (JSONException unused) {
            sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, errorMsgFailedToCreateLoadRequest);
        } catch (NullPointerException unused2) {
            sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, errorMsgFailedToCreateLoadRequest);
        }
    }
}
