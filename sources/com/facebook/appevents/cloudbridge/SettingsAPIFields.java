package com.facebook.appevents.cloudbridge;

/* compiled from: AppEventsCAPIManager.kt */
public enum SettingsAPIFields {
    URL("endpoint"),
    ENABLED("is_enabled"),
    DATASETID("dataset_id"),
    ACCESSKEY("access_key");
    
    public final String rawValue;

    /* access modifiers changed from: public */
    SettingsAPIFields(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
