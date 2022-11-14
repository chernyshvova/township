package com.iab.omid.library.vungle.adsession;

import com.facebook.internal.AnalyticsEvents;

public enum AdSessionContextType {
    HTML("html"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript");
    
    public final String typeString;

    /* access modifiers changed from: public */
    AdSessionContextType(String str) {
        this.typeString = str;
    }

    public String toString() {
        return this.typeString;
    }
}
