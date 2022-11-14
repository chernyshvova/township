package com.unity3d.services.ads.operation;

import android.os.ConditionVariable;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import java.util.UUID;

public class OperationState implements IWebViewSharedObject {
    public static String _emptyPlacementId = "";
    public Configuration configuration;

    /* renamed from: id */
    public String f2838id;
    public String placementId;
    public ConditionVariable timeoutCV;

    public OperationState(String str, Configuration configuration2) {
        this.placementId = str == null ? _emptyPlacementId : str;
        this.configuration = configuration2;
        this.timeoutCV = new ConditionVariable();
        this.f2838id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.f2838id;
    }
}
