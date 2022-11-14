package com.swrve.sdk;

import android.content.Context;
import com.google.gson.Gson;
import com.swrve.sdk.SwrveProfileManager;
import com.swrve.sdk.config.SwrveConfigBase;
import com.swrve.sdk.localstorage.SwrveSQLiteOpenHelper;
import com.swrve.sdk.rest.IRESTClient;
import com.swrve.sdk.rest.IRESTResponseListener;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SwrveProfileManager<C extends SwrveConfigBase> {
    public final String apiKey;
    public final int appId;
    public final SwrveConfigBase config;
    public final Context context;
    public IRESTClient restclient;
    public String sessionToken;
    public SwrveTrackingState trackingState;
    public String userId;

    public class IdentifyIRESTResponseListener implements IRESTResponseListener {
        public final SwrveIdentityResponse identityResponse;

        public IdentifyIRESTResponseListener(SwrveIdentityResponse swrveIdentityResponse) {
            this.identityResponse = swrveIdentityResponse;
        }

        public void onException(Exception exc) {
            SwrveLogger.m2753e("Error calling identity service", exc, new Object[0]);
            this.identityResponse.onError(503, exc.getMessage() == null ? "Unknown error" : exc.getMessage());
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0062  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResponse(com.swrve.sdk.rest.RESTResponse r7) {
            /*
                r6 = this;
                java.lang.String r0 = "message"
                java.lang.String r1 = "swrve_id"
                java.lang.String r2 = "status"
                r3 = 0
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0037 }
                java.lang.String r5 = r7.responseBody     // Catch:{ Exception -> 0x0037 }
                r4.<init>(r5)     // Catch:{ Exception -> 0x0037 }
                boolean r5 = r4.has(r2)     // Catch:{ Exception -> 0x0037 }
                if (r5 == 0) goto L_0x0019
                java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0037 }
                goto L_0x001a
            L_0x0019:
                r2 = r3
            L_0x001a:
                boolean r5 = r4.has(r1)     // Catch:{ Exception -> 0x0035 }
                if (r5 == 0) goto L_0x0025
                java.lang.String r1 = r4.getString(r1)     // Catch:{ Exception -> 0x0035 }
                goto L_0x0026
            L_0x0025:
                r1 = r3
            L_0x0026:
                boolean r5 = r4.has(r0)     // Catch:{ Exception -> 0x0039 }
                if (r5 == 0) goto L_0x0031
                java.lang.String r0 = r4.getString(r0)     // Catch:{ Exception -> 0x0039 }
                goto L_0x0033
            L_0x0031:
                java.lang.String r0 = r7.responseBody     // Catch:{ Exception -> 0x0039 }
            L_0x0033:
                r3 = r0
                goto L_0x0046
            L_0x0035:
                r1 = r3
                goto L_0x0039
            L_0x0037:
                r1 = r3
                r2 = r1
            L_0x0039:
                r0 = 1
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r4 = 0
                java.lang.String r5 = r7.responseBody
                r0[r4] = r5
                java.lang.String r4 = "SwrveSDK unable to decode identity JSON : \"%s\"."
                com.swrve.sdk.SwrveLogger.m2754e(r4, r0)
            L_0x0046:
                int r0 = r7.responseCode
                r4 = 200(0xc8, float:2.8E-43)
                if (r0 != r4) goto L_0x0062
                boolean r0 = com.swrve.sdk.SwrveHelper.isNullOrEmpty((java.lang.String) r1)
                if (r0 == 0) goto L_0x005c
                com.swrve.sdk.SwrveIdentityResponse r0 = r6.identityResponse
                int r7 = r7.responseCode
                java.lang.String r1 = "Swrve Id was missing from json payload"
                r0.onError(r7, r1)
                return
            L_0x005c:
                com.swrve.sdk.SwrveIdentityResponse r7 = r6.identityResponse
                r7.onSuccess(r2, r1)
                goto L_0x006b
            L_0x0062:
                r7 = 500(0x1f4, float:7.0E-43)
                if (r0 >= r7) goto L_0x006b
                com.swrve.sdk.SwrveIdentityResponse r7 = r6.identityResponse
                r7.onError(r0, r3)
            L_0x006b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveProfileManager.IdentifyIRESTResponseListener.onResponse(com.swrve.sdk.rest.RESTResponse):void");
        }
    }

    public SwrveProfileManager(Context context2, int i, String str, C c, IRESTClient iRESTClient) {
        this.context = context2;
        this.appId = i;
        this.apiKey = str;
        this.config = c;
        this.restclient = iRESTClient;
    }

    public String getIdentityBody(String str, String str2, String str3) {
        Gson gson = new Gson();
        HashMap hashMap = new HashMap();
        hashMap.put("swrve_id", str2);
        hashMap.put(SwrveSQLiteOpenHelper.USER_COLUMN_EXTERNAL_USER_ID, str);
        hashMap.put(ISwrveCommon.BATCH_EVENT_KEY_UNIQUE_DEVICE_ID, str3);
        hashMap.put("api_key", this.apiKey);
        return gson.toJson((Object) hashMap);
    }

    public String getIdentityUrl() {
        return this.config.getIdentityUrl() + SwrveImp.IDENTITY_ACTION;
    }

    public String getSavedUserIdFromPrefs() {
        return this.context.getSharedPreferences(ISwrveCommon.SDK_PREFS_NAME, 0).getString("userId", (String) null);
    }

    public String getSessionToken() {
        if (this.sessionToken == null) {
            this.sessionToken = SwrveHelper.generateSessionToken(this.apiKey, this.appId, this.userId);
        }
        return this.sessionToken;
    }

    public SwrveTrackingState getTrackingState() {
        if (this.trackingState == null) {
            initTrackingState();
        }
        return this.trackingState;
    }

    public String getUserId() {
        if (this.userId == null) {
            initUserId();
        }
        return this.userId;
    }

    public void identify(String str, String str2, String str3, SwrveIdentityResponse swrveIdentityResponse) {
        IdentifyIRESTResponseListener identifyIRESTResponseListener = new IdentifyIRESTResponseListener(swrveIdentityResponse);
        String identityBody = getIdentityBody(str, str2, str3);
        String identityUrl = getIdentityUrl();
        SwrveLogger.m2752d("Identity call: %s  body:  %s ", identityUrl, identityBody);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            newSingleThreadExecutor.execute(SwrveRunnables.withoutExceptions(new Runnable(identityUrl, identityBody, identifyIRESTResponseListener) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;
                public final /* synthetic */ SwrveProfileManager.IdentifyIRESTResponseListener f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    SwrveProfileManager.this.lambda$identify$0$SwrveProfileManager(this.f$1, this.f$2, this.f$3);
                }
            }));
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }

    public synchronized void initTrackingState() {
        if (this.trackingState == null) {
            SwrveTrackingState trackingState2 = SwrveTrackingState.getTrackingState(this.context);
            this.trackingState = trackingState2;
            SwrveLogger.m2755i("SwrveSDK: trackingState:%s", trackingState2);
        }
    }

    public synchronized void initUserId() {
        if (this.userId == null) {
            String savedUserIdFromPrefs = getSavedUserIdFromPrefs();
            if (SwrveHelper.isNullOrEmpty(savedUserIdFromPrefs)) {
                this.userId = UUID.randomUUID().toString();
            } else {
                this.userId = savedUserIdFromPrefs;
            }
            SwrveLogger.m2755i("SwrveSDK: userId is: %s", this.userId);
        }
    }

    public /* synthetic */ void lambda$identify$0$SwrveProfileManager(String str, String str2, IdentifyIRESTResponseListener identifyIRESTResponseListener) {
        this.restclient.post(str, str2, identifyIRESTResponseListener);
    }

    public void persistUser() {
        this.context.getSharedPreferences(ISwrveCommon.SDK_PREFS_NAME, 0).edit().putString("userId", getUserId()).commit();
    }

    public void setTrackingState(SwrveTrackingState swrveTrackingState) {
        this.trackingState = swrveTrackingState;
        SwrveTrackingState.saveTrackingState(this.context, swrveTrackingState);
        SwrveLogger.m2755i("SwrveSDK: trackingState is set to: %s", swrveTrackingState);
    }

    public void setUserId(String str) {
        this.userId = str;
        persistUser();
        SwrveLogger.m2755i("SwrveSDK: userId is set to: %s", str);
    }

    public void updateSessionToken() {
        this.sessionToken = SwrveHelper.generateSessionToken(this.apiKey, this.appId, this.userId);
    }
}
