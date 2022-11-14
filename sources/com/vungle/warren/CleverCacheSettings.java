package com.vungle.warren;

import androidx.annotation.Nullable;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.vungle.warren.model.JsonUtil;

public class CleverCacheSettings {
    public static final boolean DEFAULT_ENABLED = true;
    public static final long DEFAULT_TIMESTAMP = -1;
    public static final String KEY_CLEVER_CACHE = "clever_cache";
    public static final String KEY_ENABLED = "enabled";
    public static final String KEY_TIMESTAMP = "clear_shared_cache_timestamp";
    @SerializedName("enabled")
    public final boolean enabled;
    @SerializedName("clear_shared_cache_timestamp")
    public final long timestamp;

    public CleverCacheSettings(boolean z, long j) {
        this.enabled = z;
        this.timestamp = j;
    }

    @Nullable
    public static CleverCacheSettings deserializeFromString(String str) {
        if (str == null) {
            return null;
        }
        try {
            return fromJson((JsonObject) new GsonBuilder().create().fromJson(str, JsonObject.class));
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    @Nullable
    public static CleverCacheSettings fromJson(JsonObject jsonObject) {
        if (!JsonUtil.hasNonNull(jsonObject, "clever_cache")) {
            return null;
        }
        long j = -1;
        boolean z = true;
        JsonObject asJsonObject = jsonObject.getAsJsonObject("clever_cache");
        try {
            if (asJsonObject.has(KEY_TIMESTAMP)) {
                j = asJsonObject.get(KEY_TIMESTAMP).getAsLong();
            }
        } catch (NumberFormatException unused) {
        }
        if (asJsonObject.has(KEY_ENABLED)) {
            JsonElement jsonElement = asJsonObject.get(KEY_ENABLED);
            if (jsonElement == null) {
                throw null;
            } else if ((jsonElement instanceof JsonPrimitive) && "false".equalsIgnoreCase(jsonElement.getAsString())) {
                z = false;
            }
        }
        return new CleverCacheSettings(z, j);
    }

    public static CleverCacheSettings getDefault() {
        return new CleverCacheSettings(true, -1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CleverCacheSettings.class != obj.getClass()) {
            return false;
        }
        CleverCacheSettings cleverCacheSettings = (CleverCacheSettings) obj;
        if (this.enabled == cleverCacheSettings.enabled && this.timestamp == cleverCacheSettings.timestamp) {
            return true;
        }
        return false;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        long j = this.timestamp;
        return ((this.enabled ? 1 : 0) * true) + ((int) (j ^ (j >>> 32)));
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String serializeToString() {
        JsonObject jsonObject = new JsonObject();
        Object jsonTree = new GsonBuilder().create().toJsonTree(this);
        LinkedTreeMap<String, JsonElement> linkedTreeMap = jsonObject.members;
        if (jsonTree == null) {
            jsonTree = JsonNull.INSTANCE;
        }
        linkedTreeMap.put("clever_cache", jsonTree);
        return jsonObject.toString();
    }
}
