package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.request.SDKMetricEvents;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShowModuleDecoratorTimeout extends ShowModuleDecorator {
    public static String errorMsgTimeout = "[UnityAds] Timeout while trying to show ";
    public ExecutorService _executorService = Executors.newSingleThreadExecutor();

    public ShowModuleDecoratorTimeout(IShowModule iShowModule) {
        super(iShowModule);
    }

    /* access modifiers changed from: private */
    public void onOperationTimeout(ShowOperationState showOperationState, UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        remove(showOperationState.f2838id);
        showOperationState.listener.onUnityAdsShowFailure(showOperationState.placementId, unityAdsShowError, str);
        getMetricSender().SendSDKMetricEvent(SDKMetricEvents.native_show_timeout_error);
    }

    private void releaseOperationTimeoutLock(String str) {
        IShowOperation iShowOperation = get(str);
        if (iShowOperation != null && iShowOperation.getShowOperationState() != null && iShowOperation.getShowOperationState().timeoutCV != null) {
            iShowOperation.getShowOperationState().timeoutCV.open();
        }
    }

    private void startShowTimeout(final ShowOperationState showOperationState) {
        this._executorService.submit(new Runnable() {
            public void run() {
                ShowOperationState showOperationState = showOperationState;
                if (!showOperationState.timeoutCV.block((long) showOperationState.configuration.getShowTimeout())) {
                    ShowModuleDecoratorTimeout showModuleDecoratorTimeout = ShowModuleDecoratorTimeout.this;
                    ShowOperationState showOperationState2 = showOperationState;
                    UnityAds.UnityAdsShowError unityAdsShowError = UnityAds.UnityAdsShowError.INTERNAL_ERROR;
                    showModuleDecoratorTimeout.onOperationTimeout(showOperationState2, unityAdsShowError, ShowModuleDecoratorTimeout.errorMsgTimeout + showOperationState.placementId);
                }
            }
        });
    }

    public void onUnityAdsShowConsent(String str) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsShowConsent(str);
    }

    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsShowFailure(str, unityAdsShowError, str2);
    }

    public void onUnityAdsShowStart(String str) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsShowStart(str);
    }

    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, ShowOperationState showOperationState) {
        startShowTimeout(showOperationState);
        super.executeAdOperation(iWebViewBridgeInvoker, showOperationState);
    }
}
