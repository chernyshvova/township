package com.swrve.sdk.messaging;

import com.swrve.sdk.SwrveDeeplinkManager;

public enum SwrveActionType {
    Dismiss,
    Custom,
    Install,
    CopyToClipboard,
    RequestCapabilty;

    public static SwrveActionType parse(String str) {
        if (str.equalsIgnoreCase(SwrveDeeplinkManager.SWRVE_AD_INSTALL)) {
            return Install;
        }
        if (str.equalsIgnoreCase("dismiss")) {
            return Dismiss;
        }
        if (str.equalsIgnoreCase("copy_to_clipboard")) {
            return CopyToClipboard;
        }
        if (str.equalsIgnoreCase("request_capability")) {
            return RequestCapabilty;
        }
        return Custom;
    }
}
