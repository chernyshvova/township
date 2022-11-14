package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AccessTokenCache.kt */
public final class AccessTokenCache {
    public static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final SharedPreferences sharedPreferences;
    public final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;
    public LegacyTokenHelper tokenCachingStrategyField;

    /* compiled from: AccessTokenCache.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AccessTokenCache.kt */
    public static final class SharedPreferencesTokenCachingStrategyFactory {
        public final LegacyTokenHelper create() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return new LegacyTokenHelper(FacebookSdk.getApplicationContext(), (String) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public AccessTokenCache(SharedPreferences sharedPreferences2, SharedPreferencesTokenCachingStrategyFactory sharedPreferencesTokenCachingStrategyFactory) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(sharedPreferencesTokenCachingStrategyFactory, "tokenCachingStrategyFactory");
        this.sharedPreferences = sharedPreferences2;
        this.tokenCachingStrategyFactory = sharedPreferencesTokenCachingStrategyFactory;
    }

    private final AccessToken getCachedAccessToken() {
        String string = this.sharedPreferences.getString(CACHED_ACCESS_TOKEN_KEY, (String) null);
        if (string == null) {
            return null;
        }
        try {
            return AccessToken.Companion.createFromJSONObject$facebook_core_release(new JSONObject(string));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final AccessToken getLegacyAccessToken() {
        Bundle load = getTokenCachingStrategy().load();
        if (load == null || !LegacyTokenHelper.Companion.hasTokenInformation(load)) {
            return null;
        }
        return AccessToken.Companion.createFromLegacyCache$facebook_core_release(load);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0033, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.facebook.LegacyTokenHelper getTokenCachingStrategy() {
        /*
            r3 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            com.facebook.LegacyTokenHelper r0 = r3.tokenCachingStrategyField     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x001e
            monitor-enter(r3)     // Catch:{ all -> 0x002f }
            com.facebook.LegacyTokenHelper r0 = r3.tokenCachingStrategyField     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            com.facebook.AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory r0 = r3.tokenCachingStrategyFactory     // Catch:{ all -> 0x001b }
            com.facebook.LegacyTokenHelper r0 = r0.create()     // Catch:{ all -> 0x001b }
            r3.tokenCachingStrategyField = r0     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r3)     // Catch:{ all -> 0x002f }
            goto L_0x001e
        L_0x001b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002f }
            throw r0     // Catch:{ all -> 0x002f }
        L_0x001e:
            com.facebook.LegacyTokenHelper r0 = r3.tokenCachingStrategyField     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0023
            return r0
        L_0x0023:
            java.lang.String r0 = "Required value was null."
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002f }
            r2.<init>(r0)     // Catch:{ all -> 0x002f }
            throw r2     // Catch:{ all -> 0x002f }
        L_0x002f:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessTokenCache.getTokenCachingStrategy():com.facebook.LegacyTokenHelper");
    }

    private final boolean hasCachedAccessToken() {
        return this.sharedPreferences.contains(CACHED_ACCESS_TOKEN_KEY);
    }

    private final boolean shouldCheckLegacyToken() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.isLegacyTokenUpgradeSupported();
    }

    public final void clear() {
        this.sharedPreferences.edit().remove(CACHED_ACCESS_TOKEN_KEY).apply();
        if (shouldCheckLegacyToken()) {
            getTokenCachingStrategy().clear();
        }
    }

    public final AccessToken load() {
        if (hasCachedAccessToken()) {
            return getCachedAccessToken();
        }
        if (!shouldCheckLegacyToken()) {
            return null;
        }
        AccessToken legacyAccessToken = getLegacyAccessToken();
        if (legacyAccessToken == null) {
            return legacyAccessToken;
        }
        save(legacyAccessToken);
        getTokenCachingStrategy().clear();
        return legacyAccessToken;
    }

    public final void save(AccessToken accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        try {
            this.sharedPreferences.edit().putString(CACHED_ACCESS_TOKEN_KEY, accessToken.toJSONObject$facebook_core_release().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AccessTokenCache() {
        /*
            r3 = this;
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()
            java.lang.String r1 = "com.facebook.AccessTokenManager.SharedPreferences"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "FacebookSdk.getApplicationContext()\n              .getSharedPreferences(\n                  AccessTokenManager.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.facebook.AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory r1 = new com.facebook.AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory
            r1.<init>()
            r3.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessTokenCache.<init>():void");
    }
}
