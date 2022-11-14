package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.configuration.IInitializationListener;
import com.unity3d.services.core.configuration.IInitializationNotificationCenter;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoadModuleDecoratorInitializationBuffer extends LoadModuleDecorator implements IInitializationListener {
    public static String errorMsgInitializationFailed = "[UnityAds] SDK Initialization Failed";
    public static String errorMsgInitializationFailure = "[UnityAds] SDK Initialization Failure";
    public ConcurrentHashMap<LoadOperationState, IWebViewBridgeInvoker> _queuedLoadEvents = new ConcurrentHashMap<>();

    /* renamed from: com.unity3d.services.ads.operation.load.LoadModuleDecoratorInitializationBuffer$2 */
    public static /* synthetic */ class C17712 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$properties$SdkProperties$InitializationState */
        public static final /* synthetic */ int[] f2839xe3e1bbe9;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.unity3d.services.core.properties.SdkProperties$InitializationState[] r0 = com.unity3d.services.core.properties.SdkProperties.InitializationState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2839xe3e1bbe9 = r0
                r1 = 2
                com.unity3d.services.core.properties.SdkProperties$InitializationState r2 = com.unity3d.services.core.properties.SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f2839xe3e1bbe9     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.unity3d.services.core.properties.SdkProperties$InitializationState r2 = com.unity3d.services.core.properties.SdkProperties.InitializationState.INITIALIZED_FAILED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 3
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.operation.load.LoadModuleDecoratorInitializationBuffer.C17712.<clinit>():void");
        }
    }

    public LoadModuleDecoratorInitializationBuffer(ILoadModule iLoadModule, IInitializationNotificationCenter iInitializationNotificationCenter) {
        super(iLoadModule);
        iInitializationNotificationCenter.addListener(this);
    }

    private void sendOnUnityAdsFailedToLoad(final LoadOperationState loadOperationState, final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str) {
        Utilities.runOnUiThread(new Runnable() {
            public void run() {
                LoadOperationState loadOperationState = loadOperationState;
                loadOperationState.listener.onUnityAdsFailedToLoad(loadOperationState.placementId, unityAdsLoadError, str);
            }
        });
    }

    public synchronized void onSdkInitializationFailed(String str, int i) {
        for (LoadOperationState sendOnUnityAdsFailedToLoad : this._queuedLoadEvents.keySet()) {
            sendOnUnityAdsFailedToLoad(sendOnUnityAdsFailedToLoad, UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, errorMsgInitializationFailure);
        }
        this._queuedLoadEvents.clear();
    }

    public synchronized void onSdkInitialized() {
        for (Map.Entry next : this._queuedLoadEvents.entrySet()) {
            super.executeAdOperation((IWebViewBridgeInvoker) next.getValue(), (LoadOperationState) next.getKey());
        }
        this._queuedLoadEvents.clear();
    }

    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, LoadOperationState loadOperationState) {
        if (loadOperationState != null) {
            int ordinal = SdkProperties.getCurrentInitializationState().ordinal();
            if (ordinal == 2) {
                super.executeAdOperation(iWebViewBridgeInvoker, loadOperationState);
            } else if (ordinal != 3) {
                this._queuedLoadEvents.put(loadOperationState, iWebViewBridgeInvoker);
            } else {
                sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, errorMsgInitializationFailed);
            }
        }
    }
}
