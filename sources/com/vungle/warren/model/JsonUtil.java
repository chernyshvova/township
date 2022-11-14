package com.vungle.warren.model;

import androidx.annotation.Nullable;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

public class JsonUtil {
    public static boolean getAsBoolean(@Nullable JsonElement jsonElement, String str, boolean z) {
        return hasNonNull(jsonElement, str) ? jsonElement.getAsJsonObject().get(str).getAsBoolean() : z;
    }

    public static int getAsInt(@Nullable JsonElement jsonElement, String str, int i) {
        return hasNonNull(jsonElement, str) ? jsonElement.getAsJsonObject().get(str).getAsInt() : i;
    }

    @Nullable
    public static JsonObject getAsObject(@Nullable JsonElement jsonElement, String str) {
        if (hasNonNull(jsonElement, str)) {
            return jsonElement.getAsJsonObject().get(str).getAsJsonObject();
        }
        return null;
    }

    public static String getAsString(@Nullable JsonElement jsonElement, String str, String str2) {
        return hasNonNull(jsonElement, str) ? jsonElement.getAsJsonObject().get(str).getAsString() : str2;
    }

    public static boolean hasNonNull(@Nullable JsonElement jsonElement, String str) {
        if (jsonElement == null || (jsonElement instanceof JsonNull) || !(jsonElement instanceof JsonObject)) {
            return false;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has(str) || asJsonObject.get(str) == null) {
            return false;
        }
        JsonElement jsonElement2 = asJsonObject.get(str);
        if (jsonElement2 == null) {
            throw null;
        } else if (!(jsonElement2 instanceof JsonNull)) {
            return true;
        } else {
            return false;
        }
    }
}
