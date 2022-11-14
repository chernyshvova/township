package com.swrve.sdk;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessaging$$Lambda$2;
import com.swrve.sdk.localstorage.SwrveMultiLayerLocalStorage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveGoogleUtil implements SwrvePlatformUtil {
    public static final String CACHE_GOOGLE_ADVERTISING_ID = "GoogleAdvertisingId";
    public static final String CACHE_REGISTRATION_ID = "RegistrationId";
    public static final String SWRVE_FIREBASE_TOKEN = "swrve.gcm_token";
    public static final String SWRVE_GOOGLE_ADVERTISING_ID = "swrve.GAID";
    public String advertisingId;
    public final Context context;
    public String registrationId;

    public SwrveGoogleUtil(Context context2) {
        this.context = context2;
    }

    public void appendDeviceUpdate(JSONObject jSONObject) throws JSONException {
        if (!SwrveHelper.isNullOrEmpty(this.registrationId)) {
            jSONObject.put(SWRVE_FIREBASE_TOKEN, this.registrationId);
        }
        if (!SwrveHelper.isNullOrEmpty(this.advertisingId)) {
            jSONObject.put(SWRVE_GOOGLE_ADVERTISING_ID, this.advertisingId);
        }
    }

    public void fetchGAIDAsync(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            newSingleThreadExecutor.execute(new Runnable(str, swrveMultiLayerLocalStorage) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ SwrveMultiLayerLocalStorage f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SwrveGoogleUtil.this.lambda$fetchGAIDAsync$3$SwrveGoogleUtil(this.f$1, this.f$2);
                }
            });
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }

    public String getAdvertisingId() throws Exception {
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
        if (advertisingIdInfo != null) {
            return advertisingIdInfo.getId();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0012, code lost:
        com.swrve.sdk.SwrveLogger.m2753e("SwrveSDK cannot get instance of FirebaseMessaging and therefore cannot get token registration id.", r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.messaging.FirebaseMessaging getFirebaseMessagingInstance() {
        /*
            r3 = this;
            java.lang.Class<com.google.firebase.messaging.FirebaseMessaging> r0 = com.google.firebase.messaging.FirebaseMessaging.class
            monitor-enter(r0)     // Catch:{ IllegalStateException -> 0x000d }
            com.google.firebase.FirebaseApp r1 = com.google.firebase.FirebaseApp.getInstance()     // Catch:{ all -> 0x000f }
            com.google.firebase.messaging.FirebaseMessaging r1 = com.google.firebase.messaging.FirebaseMessaging.getInstance(r1)     // Catch:{ all -> 0x000f }
            monitor-exit(r0)     // Catch:{ IllegalStateException -> 0x000d }
            goto L_0x001b
        L_0x000d:
            r0 = move-exception
            goto L_0x0012
        L_0x000f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ IllegalStateException -> 0x000d }
            throw r1     // Catch:{ IllegalStateException -> 0x000d }
        L_0x0012:
            java.lang.String r1 = "SwrveSDK cannot get instance of FirebaseMessaging and therefore cannot get token registration id."
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r2)
            r1 = 0
        L_0x001b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveGoogleUtil.getFirebaseMessagingInstance():com.google.firebase.messaging.FirebaseMessaging");
    }

    public String getRegistrationId(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str) {
        String cacheEntry = swrveMultiLayerLocalStorage.getCacheEntry(str, CACHE_REGISTRATION_ID);
        return SwrveHelper.isNullOrEmpty(cacheEntry) ? "" : cacheEntry;
    }

    public void init(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str, boolean z, boolean z2) {
        if (z) {
            obtainRegistrationId(swrveMultiLayerLocalStorage, str);
        }
        if (z2) {
            obtainGAID(swrveMultiLayerLocalStorage, str);
        }
    }

    public /* synthetic */ void lambda$fetchGAIDAsync$3$SwrveGoogleUtil(String str, SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage) {
        try {
            String advertisingId2 = getAdvertisingId();
            this.advertisingId = advertisingId2;
            if (SwrveHelper.isNotNullOrEmpty(advertisingId2)) {
                swrveMultiLayerLocalStorage.setAndFlushSecureSharedEntryForUser(str, CACHE_GOOGLE_ADVERTISING_ID, this.advertisingId, SwrveCommon.getInstance().getUniqueKey(str));
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: Couldn't obtain Advertising Id.", e, new Object[0]);
        }
    }

    public void obtainGAID(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str) {
        this.advertisingId = swrveMultiLayerLocalStorage.getCacheEntry(str, CACHE_GOOGLE_ADVERTISING_ID);
        fetchGAIDAsync(swrveMultiLayerLocalStorage, str);
    }

    public void obtainRegistrationId(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str) {
        try {
            String registrationId2 = getRegistrationId(swrveMultiLayerLocalStorage, str);
            if (SwrveHelper.isNullOrEmpty(registrationId2)) {
                registerForTokenInBackground(swrveMultiLayerLocalStorage, str);
            } else {
                this.registrationId = registrationId2;
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: Couldn't obtain the registration token id", e, new Object[0]);
        }
    }

    public void registerForTokenInBackground(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str) {
        FirebaseMessaging firebaseMessagingInstance = getFirebaseMessagingInstance();
        if (firebaseMessagingInstance != null) {
            firebaseMessagingInstance.iid.getInstanceId().continueWith(FirebaseMessaging$$Lambda$2.$instance).addOnSuccessListener(new OnSuccessListener(swrveMultiLayerLocalStorage, str) {
                public final /* synthetic */ SwrveMultiLayerLocalStorage f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onSuccess(Object obj) {
                    SwrveGoogleUtil.this.lambda$registerForTokenInBackground$0$SwrveGoogleUtil(this.f$1, this.f$2, (String) obj);
                }
            }).addOnFailureListener($$Lambda$SwrveGoogleUtil$QspUyo4EjiWFZVDvVtlt8eRN2aE.INSTANCE);
        }
    }

    /* renamed from: registerForTokenOnSuccessListener */
    public void lambda$registerForTokenInBackground$0$SwrveGoogleUtil(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str, String str2) {
        if (!SwrveHelper.isNullOrEmpty(str2)) {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            try {
                newSingleThreadExecutor.execute(new Runnable(swrveMultiLayerLocalStorage, str, str2) {
                    public final /* synthetic */ SwrveMultiLayerLocalStorage f$1;
                    public final /* synthetic */ String f$2;
                    public final /* synthetic */ String f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        SwrveGoogleUtil.this.lambda$registerForTokenOnSuccessListener$2$SwrveGoogleUtil(this.f$1, this.f$2, this.f$3);
                    }
                });
            } finally {
                newSingleThreadExecutor.shutdown();
            }
        }
    }

    /* renamed from: saveAndSendRegistrationId */
    public void lambda$registerForTokenOnSuccessListener$2$SwrveGoogleUtil(SwrveMultiLayerLocalStorage swrveMultiLayerLocalStorage, String str, String str2) {
        String str3 = this.registrationId;
        if (str3 == null || !str3.equals(str2)) {
            this.registrationId = str2;
            swrveMultiLayerLocalStorage.setCacheEntry(str, CACHE_REGISTRATION_ID, str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            appendDeviceUpdate(jSONObject);
            EventHelper.sendUninitiatedDeviceUpdateEvent(this.context, str, jSONObject);
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK exception in saveAndSendRegistrationId", e, new Object[0]);
        }
    }
}
