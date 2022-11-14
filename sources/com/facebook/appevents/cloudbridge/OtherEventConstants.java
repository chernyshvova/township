package com.facebook.appevents.cloudbridge;

/* compiled from: AppEventsConversionsAPITransformer.kt */
public enum OtherEventConstants {
    EVENT("event"),
    ACTION_SOURCE("action_source"),
    APP("app"),
    MOBILE_APP_INSTALL("MobileAppInstall"),
    INSTALL_EVENT_TIME("install_timestamp");
    
    public final String rawValue;

    /* access modifiers changed from: public */
    OtherEventConstants(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
