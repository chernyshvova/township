package com.vungle.warren.log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonObject;

public class LogEntry {
    public static final String LOG_ITEM_BUNDLE_ID = "bundle_id";
    public static final String LOG_ITEM_CONTEXT = "context";
    public static final String LOG_ITEM_CREATION_DATE = "device_timestamp";
    public static final String LOG_ITEM_CUSTOM_DATA = "custom_data";
    public static final String LOG_ITEM_EVENT_ID = "event_id";
    public static final String LOG_ITEM_EX_CLASS = "exception_class";
    public static final String LOG_ITEM_LEVEL = "log_level";
    public static final String LOG_ITEM_MESSAGE = "raw_log";
    public static final String LOG_ITEM_SDK_USER_AGENT = "sdk_user_agent";
    public static final String LOG_ITEM_THREAD_ID = "thread_id";
    public static final String LOG_ITEM_TIME_ZONE = "time_zone";
    public static final String LOG_METADATA = "metadata";
    public String bundleID;
    public String context;
    public String creationDate;
    public String customData;
    public String eventID;
    public String exClass;
    public String level;
    public String message;
    public String threadId;
    public String timeZone;
    public String userAgent;

    public LogEntry(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.level = str2;
        this.message = str;
        this.context = str3;
        this.eventID = str4;
        this.userAgent = str5;
        this.bundleID = str6;
        this.timeZone = str7;
        this.creationDate = str8;
        this.customData = str9;
        this.exClass = str10;
        this.threadId = str11;
    }

    private void addMetadataProperty(@NonNull JsonObject jsonObject, @NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            jsonObject.addProperty(str, str2);
        }
    }

    @NonNull
    public String toJsonString() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(LOG_ITEM_MESSAGE, this.message);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.members.put(LOG_METADATA, jsonObject2);
        addMetadataProperty(jsonObject2, LOG_ITEM_LEVEL, this.level);
        addMetadataProperty(jsonObject2, LOG_ITEM_CONTEXT, this.context);
        addMetadataProperty(jsonObject2, LOG_ITEM_EVENT_ID, this.eventID);
        addMetadataProperty(jsonObject2, LOG_ITEM_SDK_USER_AGENT, this.userAgent);
        addMetadataProperty(jsonObject2, LOG_ITEM_BUNDLE_ID, this.bundleID);
        addMetadataProperty(jsonObject2, LOG_ITEM_TIME_ZONE, this.timeZone);
        addMetadataProperty(jsonObject2, LOG_ITEM_CREATION_DATE, this.creationDate);
        addMetadataProperty(jsonObject2, LOG_ITEM_CUSTOM_DATA, this.customData);
        addMetadataProperty(jsonObject2, LOG_ITEM_EX_CLASS, this.exClass);
        addMetadataProperty(jsonObject2, LOG_ITEM_THREAD_ID, this.threadId);
        return jsonObject.toString();
    }
}
