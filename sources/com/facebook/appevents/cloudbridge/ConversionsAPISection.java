package com.facebook.appevents.cloudbridge;

import com.vungle.warren.log.LogEntry;

/* compiled from: AppEventsConversionsAPITransformer.kt */
public enum ConversionsAPISection {
    USER_DATA("user_data"),
    APP_DATA("app_data"),
    CUSTOM_DATA(LogEntry.LOG_ITEM_CUSTOM_DATA),
    CUSTOM_EVENTS("custom_events");
    
    public final String rawValue;

    /* access modifiers changed from: public */
    ConversionsAPISection(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
