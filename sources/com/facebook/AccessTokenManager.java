package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.Utility;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.util.ErrorReportProvider;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AccessTokenManager.kt */
public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    public static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    public static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    public static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    public static AccessTokenManager instanceField;
    public final AccessTokenCache accessTokenCache;
    public AccessToken currentAccessTokenField;
    public Date lastAttemptedTokenExtendDate = new Date(0);
    public final LocalBroadcastManager localBroadcastManager;
    public final AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    /* compiled from: AccessTokenManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            RefreshTokenInfo refreshTokenInfoForToken = getRefreshTokenInfoForToken(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", refreshTokenInfoForToken.getGrantType());
            bundle.putString("client_id", accessToken.getApplicationId());
            bundle.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, refreshTokenInfoForToken.getGraphPath(), callback);
            newGraphPathRequest.setParameters(bundle);
            newGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return newGraphPathRequest;
        }

        /* access modifiers changed from: private */
        public final GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            Bundle outline5 = GeneratedOutlineSupport.outline5("fields", "permission,status");
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, AccessTokenManager.ME_PERMISSIONS_GRAPH_PATH, callback);
            newGraphPathRequest.setParameters(outline5);
            newGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return newGraphPathRequest;
        }

        private final RefreshTokenInfo getRefreshTokenInfoForToken(AccessToken accessToken) {
            String graphDomain = accessToken.getGraphDomain();
            if (graphDomain == null) {
                graphDomain = AccessToken.DEFAULT_GRAPH_DOMAIN;
            }
            if (Intrinsics.areEqual(graphDomain, FacebookSdk.INSTAGRAM)) {
                return new InstagramRefreshTokenInfo();
            }
            return new FacebookRefreshTokenInfo();
        }

        public final AccessTokenManager getInstance() {
            AccessTokenManager access$getInstanceField$cp;
            AccessTokenManager access$getInstanceField$cp2 = AccessTokenManager.instanceField;
            if (access$getInstanceField$cp2 != null) {
                return access$getInstanceField$cp2;
            }
            synchronized (this) {
                access$getInstanceField$cp = AccessTokenManager.instanceField;
                if (access$getInstanceField$cp == null) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                    AccessTokenManager accessTokenManager = new AccessTokenManager(instance, new AccessTokenCache());
                    Companion companion = AccessTokenManager.Companion;
                    AccessTokenManager.instanceField = accessTokenManager;
                    access$getInstanceField$cp = accessTokenManager;
                }
            }
            return access$getInstanceField$cp;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    public static final class FacebookRefreshTokenInfo implements RefreshTokenInfo {
        public final String grantType = "fb_extend_sso_token";
        public final String graphPath = "oauth/access_token";

        public String getGrantType() {
            return this.grantType;
        }

        public String getGraphPath() {
            return this.graphPath;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    public static final class InstagramRefreshTokenInfo implements RefreshTokenInfo {
        public final String grantType = "ig_refresh_token";
        public final String graphPath = "refresh_access_token";

        public String getGrantType() {
            return this.grantType;
        }

        public String getGraphPath() {
            return this.graphPath;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    public static final class RefreshResult {
        public String accessToken;
        public Long dataAccessExpirationTime;
        public int expiresAt;
        public int expiresIn;
        public String graphDomain;

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final Long getDataAccessExpirationTime() {
            return this.dataAccessExpirationTime;
        }

        public final int getExpiresAt() {
            return this.expiresAt;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        public final String getGraphDomain() {
            return this.graphDomain;
        }

        public final void setAccessToken(String str) {
            this.accessToken = str;
        }

        public final void setDataAccessExpirationTime(Long l) {
            this.dataAccessExpirationTime = l;
        }

        public final void setExpiresAt(int i) {
            this.expiresAt = i;
        }

        public final void setExpiresIn(int i) {
            this.expiresIn = i;
        }

        public final void setGraphDomain(String str) {
            this.graphDomain = str;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    public interface RefreshTokenInfo {
        String getGrantType();

        String getGraphPath();
    }

    public AccessTokenManager(LocalBroadcastManager localBroadcastManager2, AccessTokenCache accessTokenCache2) {
        Intrinsics.checkNotNullParameter(localBroadcastManager2, "localBroadcastManager");
        Intrinsics.checkNotNullParameter(accessTokenCache2, "accessTokenCache");
        this.localBroadcastManager = localBroadcastManager2;
        this.accessTokenCache = accessTokenCache2;
    }

    public static final AccessTokenManager getInstance() {
        return Companion.getInstance();
    }

    /* renamed from: refreshCurrentAccessToken$lambda-0  reason: not valid java name */
    public static final void m3522refreshCurrentAccessToken$lambda0(AccessTokenManager accessTokenManager, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        Intrinsics.checkNotNullParameter(accessTokenManager, "this$0");
        accessTokenManager.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
    }

    private final void refreshCurrentAccessTokenImpl(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else if (this.tokenRefreshInProgress.compareAndSet(false, true)) {
            this.lastAttemptedTokenExtendDate = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            RefreshResult refreshResult = new RefreshResult();
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(Companion.createGrantedPermissionsRequest(currentAccessToken, new GraphRequest.Callback(atomicBoolean, hashSet, hashSet2, hashSet3) {
                public final /* synthetic */ AtomicBoolean f$0;
                public final /* synthetic */ Set f$1;
                public final /* synthetic */ Set f$2;
                public final /* synthetic */ Set f$3;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onCompleted(GraphResponse graphResponse) {
                    AccessTokenManager.m3523refreshCurrentAccessTokenImpl$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, graphResponse);
                }
            }), Companion.createExtendAccessTokenRequest(currentAccessToken, new GraphRequest.Callback() {
                public final void onCompleted(GraphResponse graphResponse) {
                    AccessTokenManager.m3524refreshCurrentAccessTokenImpl$lambda2(AccessTokenManager.RefreshResult.this, graphResponse);
                }
            }));
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback(currentAccessToken, accessTokenRefreshCallback, atomicBoolean, hashSet, hashSet2, hashSet3, this) {
                public final /* synthetic */ AccessToken f$1;
                public final /* synthetic */ AccessToken.AccessTokenRefreshCallback f$2;
                public final /* synthetic */ AtomicBoolean f$3;
                public final /* synthetic */ Set f$4;
                public final /* synthetic */ Set f$5;
                public final /* synthetic */ Set f$6;
                public final /* synthetic */ AccessTokenManager f$7;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                    this.f$7 = r8;
                }

                public final void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                    AccessTokenManager.m3525refreshCurrentAccessTokenImpl$lambda3(AccessTokenManager.RefreshResult.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, graphRequestBatch);
                }
            });
            graphRequestBatch.executeAsync();
        } else if (accessTokenRefreshCallback != null) {
            accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
        }
    }

    /* renamed from: refreshCurrentAccessTokenImpl$lambda-1  reason: not valid java name */
    public static final void m3523refreshCurrentAccessTokenImpl$lambda1(AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, GraphResponse graphResponse) {
        JSONArray optJSONArray;
        Intrinsics.checkNotNullParameter(atomicBoolean, "$permissionsCallSucceeded");
        Intrinsics.checkNotNullParameter(set, "$permissions");
        Intrinsics.checkNotNullParameter(set2, "$declinedPermissions");
        Intrinsics.checkNotNullParameter(set3, "$expiredPermissions");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        JSONObject jsonObject = graphResponse.getJsonObject();
        if (jsonObject != null && (optJSONArray = jsonObject.optJSONArray("data")) != null) {
            atomicBoolean.set(true);
            int i = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("permission");
                        String optString2 = optJSONObject.optString("status");
                        Utility utility = Utility.INSTANCE;
                        if (!Utility.isNullOrEmpty(optString)) {
                            Utility utility2 = Utility.INSTANCE;
                            if (!Utility.isNullOrEmpty(optString2)) {
                                Intrinsics.checkNotNullExpressionValue(optString2, "status");
                                Locale locale = Locale.US;
                                Intrinsics.checkNotNullExpressionValue(locale, "US");
                                String lowerCase = optString2.toLowerCase(locale);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "status");
                                int hashCode = lowerCase.hashCode();
                                if (hashCode != -1309235419) {
                                    if (hashCode != 280295099) {
                                        if (hashCode == 568196142 && lowerCase.equals("declined")) {
                                            set2.add(optString);
                                        }
                                    } else if (lowerCase.equals("granted")) {
                                        set.add(optString);
                                    }
                                } else if (lowerCase.equals("expired")) {
                                    set3.add(optString);
                                }
                                Log.w(TAG, Intrinsics.stringPlus("Unexpected status: ", lowerCase));
                            }
                        }
                    }
                    if (i2 < length) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: refreshCurrentAccessTokenImpl$lambda-2  reason: not valid java name */
    public static final void m3524refreshCurrentAccessTokenImpl$lambda2(RefreshResult refreshResult, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(refreshResult, "$refreshResult");
        Intrinsics.checkNotNullParameter(graphResponse, AnalyticsEventKey.RESPONSE);
        JSONObject jsonObject = graphResponse.getJsonObject();
        if (jsonObject != null) {
            refreshResult.setAccessToken(jsonObject.optString("access_token"));
            refreshResult.setExpiresAt(jsonObject.optInt(AccessToken.EXPIRES_AT_KEY));
            refreshResult.setExpiresIn(jsonObject.optInt(AccessToken.EXPIRES_IN_KEY));
            refreshResult.setDataAccessExpirationTime(Long.valueOf(jsonObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
            refreshResult.setGraphDomain(jsonObject.optString("graph_domain", (String) null));
        }
    }

    /* renamed from: refreshCurrentAccessTokenImpl$lambda-3  reason: not valid java name */
    public static final void m3525refreshCurrentAccessTokenImpl$lambda3(RefreshResult refreshResult, AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, AccessTokenManager accessTokenManager, GraphRequestBatch graphRequestBatch) {
        AccessToken accessToken2;
        Set<String> set4;
        Set<String> set5;
        Date date;
        AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
        AccessTokenManager accessTokenManager2 = accessTokenManager;
        Intrinsics.checkNotNullParameter(refreshResult, "$refreshResult");
        Intrinsics.checkNotNullParameter(atomicBoolean, "$permissionsCallSucceeded");
        Set set6 = set;
        Intrinsics.checkNotNullParameter(set6, "$permissions");
        Set set7 = set2;
        Intrinsics.checkNotNullParameter(set7, "$declinedPermissions");
        Set set8 = set3;
        Intrinsics.checkNotNullParameter(set8, "$expiredPermissions");
        Intrinsics.checkNotNullParameter(accessTokenManager2, "this$0");
        Intrinsics.checkNotNullParameter(graphRequestBatch, "it");
        String accessToken3 = refreshResult.getAccessToken();
        int expiresAt = refreshResult.getExpiresAt();
        Long dataAccessExpirationTime = refreshResult.getDataAccessExpirationTime();
        String graphDomain = refreshResult.getGraphDomain();
        try {
            if (Companion.getInstance().getCurrentAccessToken() != null) {
                AccessToken currentAccessToken = Companion.getInstance().getCurrentAccessToken();
                if ((currentAccessToken == null ? null : currentAccessToken.getUserId()) == accessToken.getUserId()) {
                    if (!atomicBoolean.get() && accessToken3 == null && expiresAt == 0) {
                        if (accessTokenRefreshCallback2 != null) {
                            accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                        }
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        return;
                    }
                    Date expires = accessToken.getExpires();
                    if (refreshResult.getExpiresAt() != 0) {
                        expires = new Date(((long) refreshResult.getExpiresAt()) * 1000);
                    } else if (refreshResult.getExpiresIn() != 0) {
                        expires = new Date((((long) refreshResult.getExpiresIn()) * 1000) + new Date().getTime());
                    }
                    Date date2 = expires;
                    if (accessToken3 == null) {
                        accessToken3 = accessToken.getToken();
                    }
                    String str = accessToken3;
                    String applicationId = accessToken.getApplicationId();
                    String userId = accessToken.getUserId();
                    Set<String> permissions = atomicBoolean.get() ? set6 : accessToken.getPermissions();
                    if (atomicBoolean.get()) {
                        set4 = set7;
                    } else {
                        set4 = accessToken.getDeclinedPermissions();
                    }
                    if (atomicBoolean.get()) {
                        set5 = set8;
                    } else {
                        set5 = accessToken.getExpiredPermissions();
                    }
                    AccessTokenSource source = accessToken.getSource();
                    Date date3 = new Date();
                    if (dataAccessExpirationTime != null) {
                        date = new Date(dataAccessExpirationTime.longValue() * 1000);
                    } else {
                        date = accessToken.getDataAccessExpirationTime();
                    }
                    Date date4 = date;
                    if (graphDomain == null) {
                        graphDomain = accessToken.getGraphDomain();
                    }
                    AccessToken accessToken4 = new AccessToken(str, applicationId, userId, permissions, set4, set5, source, date2, date3, date4, graphDomain);
                    try {
                        Companion.getInstance().setCurrentAccessToken(accessToken4);
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        if (accessTokenRefreshCallback2 != null) {
                            accessTokenRefreshCallback2.OnTokenRefreshed(accessToken4);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        accessToken2 = accessToken4;
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
                        throw th;
                    }
                }
            }
            if (accessTokenRefreshCallback2 != null) {
                accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
            accessTokenManager2.tokenRefreshInProgress.set(false);
        } catch (Throwable th2) {
            th = th2;
            accessToken2 = null;
            accessTokenManager2.tokenRefreshInProgress.set(false);
            if (!(accessTokenRefreshCallback2 == null || accessToken2 == null)) {
                accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
            }
            throw th;
        }
    }

    private final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    private final void setTokenExpirationBroadcastAlarm() {
        PendingIntent pendingIntent;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (AccessToken.Companion.isCurrentAccessTokenActive()) {
            if ((currentAccessToken == null ? null : currentAccessToken.getExpires()) != null && alarmManager != null) {
                Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
                intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
                if (Build.VERSION.SDK_INT >= 23) {
                    pendingIntent = PendingIntent.getBroadcast(applicationContext, 0, intent, 67108864);
                } else {
                    pendingIntent = PendingIntent.getBroadcast(applicationContext, 0, intent, 0);
                }
                try {
                    alarmManager.set(1, currentAccessToken.getExpires().getTime(), pendingIntent);
                } catch (Exception unused) {
                }
            }
        }
    }

    private final boolean shouldExtendAccessToken() {
        AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            return false;
        }
        long time = new Date().getTime();
        if (!currentAccessToken.getSource().canExtendToken() || time - this.lastAttemptedTokenExtendDate.getTime() <= 3600000 || time - currentAccessToken.getLastRefresh().getTime() <= ErrorReportProvider.BATCH_TIME) {
            return false;
        }
        return true;
    }

    public final void currentAccessTokenChanged() {
        sendCurrentAccessTokenChangedBroadcastIntent(getCurrentAccessToken(), getCurrentAccessToken());
    }

    public final void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken((AccessToken.AccessTokenRefreshCallback) null);
        }
    }

    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessTokenField;
    }

    public final boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAccessToken(load, false);
        return true;
    }

    public final void refreshCurrentAccessToken(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(accessTokenRefreshCallback) {
                public final /* synthetic */ AccessToken.AccessTokenRefreshCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AccessTokenManager.m3522refreshCurrentAccessToken$lambda0(AccessTokenManager.this, this.f$1);
                }
            });
        }
    }

    public final void setCurrentAccessToken(AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private final void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.currentAccessTokenField;
        this.currentAccessTokenField = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility utility = Utility.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        Utility utility2 = Utility.INSTANCE;
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
            setTokenExpirationBroadcastAlarm();
        }
    }
}
