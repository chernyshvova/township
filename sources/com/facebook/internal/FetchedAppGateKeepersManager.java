package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: FetchedAppGateKeepersManager.kt */
public final class FetchedAppGateKeepersManager {
    public static final String APPLICATION_FIELDS = "fields";
    public static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    public static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    public static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    public static final String APPLICATION_GRAPH_DATA = "data";
    public static final String APPLICATION_PLATFORM = "platform";
    public static final String APPLICATION_SDK_VERSION = "sdk_version";
    public static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    public static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    public static final String APP_PLATFORM = "android";
    public static final FetchedAppGateKeepersManager INSTANCE = new FetchedAppGateKeepersManager();
    public static final String TAG;
    public static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    public static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();
    public static GateKeeperRuntimeCache gateKeeperRuntimeCache;
    public static final AtomicBoolean isLoading = new AtomicBoolean(false);
    public static Long timestamp;

    /* compiled from: FetchedAppGateKeepersManager.kt */
    public interface Callback {
        void onCompleted();
    }

    static {
        Class<FetchedAppGateKeepersManager> cls = FetchedAppGateKeepersManager.class;
        if (Reflection.factory != null) {
            TAG = new ClassReference(cls).getSimpleName();
            return;
        }
        throw null;
    }

    private final JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle outline5 = GeneratedOutlineSupport.outline5("platform", "android");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        outline5.putString(APPLICATION_SDK_VERSION, FacebookSdk.getSdkVersion());
        outline5.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest.Companion companion = GraphRequest.Companion;
        String format = String.format("app/%s", Arrays.copyOf(new Object[]{APPLICATION_GATEKEEPER_EDGE}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        GraphRequest newGraphPathRequest = companion.newGraphPathRequest((AccessToken) null, format, (GraphRequest.Callback) null);
        newGraphPathRequest.setParameters(outline5);
        JSONObject jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        return jsonObject == null ? new JSONObject() : jsonObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r1 = r2.get(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean getGateKeeperForKey(java.lang.String r1, java.lang.String r2, boolean r3) {
        /*
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            com.facebook.internal.FetchedAppGateKeepersManager r0 = INSTANCE
            java.util.Map r2 = r0.getGateKeepersForApplication(r2)
            boolean r0 = r2.containsKey(r1)
            if (r0 != 0) goto L_0x0012
            goto L_0x001f
        L_0x0012:
            java.lang.Object r1 = r2.get(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            if (r1 != 0) goto L_0x001b
            return r3
        L_0x001b:
            boolean r3 = r1.booleanValue()
        L_0x001f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppGateKeepersManager.getGateKeeperForKey(java.lang.String, java.lang.String, boolean):boolean");
    }

    private final boolean isTimestampValid(Long l) {
        return l != null && System.currentTimeMillis() - l.longValue() < 3600000;
    }

    /* renamed from: loadAppGateKeepersAsync$lambda-0  reason: not valid java name */
    public static final void m3615loadAppGateKeepersAsync$lambda0(String str, Context context, String str2) {
        Intrinsics.checkNotNullParameter(str, "$applicationId");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str2, "$gateKeepersKey");
        JSONObject appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(str);
        if (appGateKeepersQueryResponse.length() != 0) {
            parseAppGateKeepersFromJSON$facebook_core_release(str, appGateKeepersQueryResponse);
            context.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(str2, appGateKeepersQueryResponse.toString()).apply();
            timestamp = Long.valueOf(System.currentTimeMillis());
        }
        INSTANCE.pollCallbacks();
        isLoading.set(false);
    }

    @VisibleForTesting(otherwise = 2)
    public static final synchronized JSONObject parseAppGateKeepersFromJSON$facebook_core_release(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (FetchedAppGateKeepersManager.class) {
            Intrinsics.checkNotNullParameter(str, "applicationId");
            jSONObject2 = fetchedAppGateKeepers.get(str);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            int i = 0;
            JSONObject jSONObject3 = null;
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    jSONObject3 = optJSONArray.optJSONObject(0);
                }
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            JSONArray optJSONArray2 = jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
            if (optJSONArray2 == null) {
                optJSONArray2 = new JSONArray();
            }
            int length = optJSONArray2.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    try {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i);
                        jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean("value"));
                    } catch (JSONException e) {
                        Utility utility = Utility.INSTANCE;
                        Utility.logd(Utility.LOG_TAG, (Exception) e);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            fetchedAppGateKeepers.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    private final void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (!callbacks.isEmpty()) {
            Callback poll = callbacks.poll();
            if (poll != null) {
                handler.post(new Runnable() {
                    public final void run() {
                        FetchedAppGateKeepersManager.m3616pollCallbacks$lambda1(FetchedAppGateKeepersManager.Callback.this);
                    }
                });
            }
        }
    }

    /* renamed from: pollCallbacks$lambda-1  reason: not valid java name */
    public static final void m3616pollCallbacks$lambda1(Callback callback) {
        callback.onCompleted();
    }

    public static final JSONObject queryAppGateKeepers(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        if (z || !fetchedAppGateKeepers.containsKey(str)) {
            JSONObject appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(str);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getApplicationContext().getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(GeneratedOutlineSupport.outline21(new Object[]{str}, 1, APP_GATEKEEPERS_PREFS_KEY_FORMAT, "java.lang.String.format(format, *args)"), appGateKeepersQueryResponse.toString()).apply();
            return parseAppGateKeepersFromJSON$facebook_core_release(str, appGateKeepersQueryResponse);
        }
        JSONObject jSONObject = fetchedAppGateKeepers.get(str);
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    public static final void resetRuntimeGateKeeperCache() {
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 != null) {
            GateKeeperRuntimeCache.resetCache$default(gateKeeperRuntimeCache2, (String) null, 1, (Object) null);
        }
    }

    public static final void setRuntimeGateKeeper(String str, GateKeeper gateKeeper) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(gateKeeper, "gateKeeper");
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if ((gateKeeperRuntimeCache2 == null ? null : gateKeeperRuntimeCache2.getGateKeeper(str, gateKeeper.getName())) != null) {
            GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
            if (gateKeeperRuntimeCache3 != null) {
                gateKeeperRuntimeCache3.setGateKeeper(str, gateKeeper);
                return;
            }
            return;
        }
        Log.w(TAG, "Missing gatekeeper runtime cache");
    }

    public static /* synthetic */ void setRuntimeGateKeeper$default(String str, GateKeeper gateKeeper, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        setRuntimeGateKeeper(str, gateKeeper);
    }

    public final Map<String, Boolean> getGateKeepersForApplication(String str) {
        loadAppGateKeepersAsync();
        if (str == null || !fetchedAppGateKeepers.containsKey(str)) {
            return new HashMap();
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        List<GateKeeper> dumpGateKeepers = gateKeeperRuntimeCache2 == null ? null : gateKeeperRuntimeCache2.dumpGateKeepers(str);
        if (dumpGateKeepers != null) {
            HashMap hashMap = new HashMap();
            for (GateKeeper gateKeeper : dumpGateKeepers) {
                hashMap.put(gateKeeper.getName(), Boolean.valueOf(gateKeeper.getValue()));
            }
            return hashMap;
        }
        HashMap hashMap2 = new HashMap();
        JSONObject jSONObject = fetchedAppGateKeepers.get(str);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "key");
            hashMap2.put(next, Boolean.valueOf(jSONObject.optBoolean(next)));
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache3 == null) {
            gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
        }
        ArrayList arrayList = new ArrayList(hashMap2.size());
        for (Map.Entry entry : hashMap2.entrySet()) {
            arrayList.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
        }
        gateKeeperRuntimeCache3.setGateKeepers(str, arrayList);
        gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
        return hashMap2;
    }

    public final void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync((Callback) null);
    }

    public static final synchronized void loadAppGateKeepersAsync(Callback callback) {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (callback != null) {
                callbacks.add(callback);
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String applicationId = FacebookSdk.getApplicationId();
            if (!INSTANCE.isTimestampValid(timestamp) || !fetchedAppGateKeepers.containsKey(applicationId)) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                if (applicationContext != null) {
                    JSONObject jSONObject = null;
                    String string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(format, (String) null);
                    Utility utility = Utility.INSTANCE;
                    if (!Utility.isNullOrEmpty(string)) {
                        try {
                            jSONObject = new JSONObject(string);
                        } catch (JSONException e) {
                            Utility utility2 = Utility.INSTANCE;
                            Utility.logd(Utility.LOG_TAG, (Exception) e);
                        }
                        if (jSONObject != null) {
                            parseAppGateKeepersFromJSON$facebook_core_release(applicationId, jSONObject);
                        }
                    }
                    FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                    Executor executor = FacebookSdk.getExecutor();
                    if (executor != null) {
                        if (isLoading.compareAndSet(false, true)) {
                            executor.execute(new Runnable(applicationId, applicationContext, format) {
                                public final /* synthetic */ String f$0;
                                public final /* synthetic */ Context f$1;
                                public final /* synthetic */ String f$2;

                                {
                                    this.f$0 = r1;
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void run() {
                                    FetchedAppGateKeepersManager.m3615loadAppGateKeepersAsync$lambda0(this.f$0, this.f$1, this.f$2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            INSTANCE.pollCallbacks();
        }
    }
}
