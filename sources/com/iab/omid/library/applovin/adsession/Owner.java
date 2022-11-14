package com.iab.omid.library.applovin.adsession;

import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;

public enum Owner {
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript"),
    NONE(IntegrityManager.INTEGRITY_TYPE_NONE);
    
    public final String owner;

    /* access modifiers changed from: public */
    Owner(String str) {
        this.owner = str;
    }

    public String toString() {
        return this.owner;
    }
}
