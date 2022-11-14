package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.AdOperation;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocation;

public class ShowOperation extends AdOperation implements IShowOperation {
    public ShowOperationState showOperationState;

    public ShowOperation(ShowOperationState showOperationState2, IWebViewBridgeInvocation iWebViewBridgeInvocation) {
        super(iWebViewBridgeInvocation, "show");
        this.showOperationState = showOperationState2;
    }

    public String getId() {
        return this.showOperationState.f2838id;
    }

    public ShowOperationState getShowOperationState() {
        return this.showOperationState;
    }

    public void onUnityAdsShowClick(final String str) {
        ShowOperationState showOperationState2 = this.showOperationState;
        if (showOperationState2 != null && showOperationState2.listener != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    ShowOperation.this.showOperationState.listener.onUnityAdsShowClick(str);
                }
            });
        }
    }

    public void onUnityAdsShowComplete(final String str, final UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        ShowOperationState showOperationState2 = this.showOperationState;
        if (showOperationState2 != null && showOperationState2.listener != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    ShowOperation.this.showOperationState.listener.onUnityAdsShowComplete(str, unityAdsShowCompletionState);
                }
            });
        }
    }

    public void onUnityAdsShowFailure(final String str, final UnityAds.UnityAdsShowError unityAdsShowError, final String str2) {
        ShowOperationState showOperationState2 = this.showOperationState;
        if (showOperationState2 != null && showOperationState2.listener != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    ShowOperation.this.showOperationState.listener.onUnityAdsShowFailure(str, unityAdsShowError, str2);
                }
            });
        }
    }

    public void onUnityAdsShowStart(final String str) {
        ShowOperationState showOperationState2 = this.showOperationState;
        if (showOperationState2 != null && showOperationState2.listener != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    ShowOperation.this.showOperationState.listener.onUnityAdsShowStart(str);
                }
            });
        }
    }
}
