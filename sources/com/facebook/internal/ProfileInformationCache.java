package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ProfileInformationCache.kt */
public final class ProfileInformationCache {
    public static final ProfileInformationCache INSTANCE = new ProfileInformationCache();
    public static final ConcurrentHashMap<String, JSONObject> infoCache = new ConcurrentHashMap<>();

    public static final JSONObject getProfileInformation(String str) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        return infoCache.get(str);
    }

    public static final void putProfileInformation(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jSONObject, "value");
        infoCache.put(str, jSONObject);
    }
}
