package com.unity3d.services.ads.operation.show;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.internal.ServerProtocol;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.AdModule;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.ISDKMetricSender;
import com.unity3d.services.core.request.SDKMetricEvents;
import com.unity3d.services.core.request.SDKMetricSender;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback;
import com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation;
import com.vungle.warren.VisionController;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowModule extends AdModule<IShowOperation, ShowOperationState> implements IShowModule {
    public static String errorMsgPlacementIdNull = "[UnityAds] Placement ID cannot be null";
    public static IShowModule instance;

    public ShowModule(ISDKMetricSender iSDKMetricSender) {
        super(iSDKMetricSender);
    }

    public static IShowModule getInstance() {
        if (instance == null) {
            instance = new ShowModuleDecoratorTimeout(new ShowModule(new SDKMetricSender()));
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void sendOnUnityAdsFailedToShow(final ShowOperationState showOperationState, final String str, final UnityAds.UnityAdsShowError unityAdsShowError) {
        if (showOperationState != null && showOperationState.listener != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    ShowOperationState showOperationState = showOperationState;
                    showOperationState.listener.onUnityAdsShowFailure(showOperationState.placementId, unityAdsShowError, str);
                }
            });
        }
    }

    public void onUnityAdsShowClick(String str) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation != null && iShowOperation.getShowOperationState() != null) {
            iShowOperation.onUnityAdsShowClick(iShowOperation.getShowOperationState().placementId);
        }
    }

    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation != null && iShowOperation.getShowOperationState() != null) {
            iShowOperation.onUnityAdsShowComplete(iShowOperation.getShowOperationState().placementId, unityAdsShowCompletionState);
            remove(str);
        }
    }

    public void onUnityAdsShowConsent(String str) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation == null || iShowOperation.getShowOperationState() == null) {
        }
    }

    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation != null && iShowOperation.getShowOperationState() != null) {
            iShowOperation.onUnityAdsShowFailure(iShowOperation.getShowOperationState().placementId, unityAdsShowError, str2);
            remove(str);
        }
    }

    public void onUnityAdsShowStart(String str) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation != null && iShowOperation.getShowOperationState() != null) {
            iShowOperation.onUnityAdsShowStart(iShowOperation.getShowOperationState().placementId);
        }
    }

    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, final ShowOperationState showOperationState) {
        if (TextUtils.isEmpty(showOperationState.placementId)) {
            sendOnUnityAdsFailedToShow(showOperationState, errorMsgPlacementIdNull, UnityAds.UnityAdsShowError.INVALID_ARGUMENT);
            return;
        }
        ShowOperation showOperation = new ShowOperation(showOperationState, new WebViewBridgeInvocation(this._executorService, iWebViewBridgeInvoker, new IWebViewBridgeInvocationCallback() {
            public void onFailure(String str, CallbackStatus callbackStatus) {
                final String str2;
                ShowModule.this.sendOnUnityAdsFailedToShow(showOperationState, str, UnityAds.UnityAdsShowError.INTERNAL_ERROR);
                if (callbackStatus == null) {
                    str2 = "invocationFailure";
                } else {
                    str2 = callbackStatus.toString();
                }
                ShowModule.this._sdkMetricSender.SendSDKMetricEventWithTag(SDKMetricEvents.native_show_callback_error, new HashMap<String, String>() {
                    {
                        put("cbs", str2);
                    }
                });
                ShowModule.this.remove(showOperationState.f2838id);
            }

            public void onSuccess() {
            }

            public void onTimeout() {
                ShowModule.this.sendOnUnityAdsFailedToShow(showOperationState, "[UnityAds] Show Invocation Timeout", UnityAds.UnityAdsShowError.INTERNAL_ERROR);
                ShowModule.this._sdkMetricSender.SendSDKMetricEvent(SDKMetricEvents.native_show_callback_timeout);
                ShowModule.this.remove(showOperationState.f2838id);
            }
        }));
        ClientProperties.setActivity(showOperationState.activity);
        Display defaultDisplay = ((WindowManager) showOperationState.activity.getSystemService(VisionController.WINDOW)).getDefaultDisplay();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("requestedOrientation", showOperationState.activity.getRequestedOrientation());
            jSONObject3.put("rotation", defaultDisplay.getRotation());
            Point point = new Point();
            defaultDisplay.getSize(point);
            jSONObject3.put("width", point.x);
            jSONObject3.put("height", point.y);
            jSONObject2.put(ServerProtocol.DIALOG_PARAM_DISPLAY, jSONObject3);
            jSONObject2.put("headerBiddingOptions", showOperationState.showOptions.getData());
            jSONObject.put("options", jSONObject2);
            jSONObject.put("listenerId", showOperation.getId());
            jSONObject.put(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID, showOperationState.placementId);
            jSONObject.put("time", Device.getElapsedRealtime());
            set(showOperation);
            showOperation.invoke(showOperationState.configuration.getWebViewBridgeTimeout(), jSONObject);
        } catch (JSONException unused) {
            sendOnUnityAdsFailedToShow(showOperationState, "[UnityAds] Error creating show options", UnityAds.UnityAdsShowError.INTERNAL_ERROR);
        } catch (NullPointerException unused2) {
            sendOnUnityAdsFailedToShow(showOperationState, "[UnityAds] Error creating show options", UnityAds.UnityAdsShowError.INTERNAL_ERROR);
        }
    }
}
