package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.p030ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IntegrityManager.kt */
public final class IntegrityManager {
    public static final IntegrityManager INSTANCE = new IntegrityManager();
    public static final String INTEGRITY_TYPE_ADDRESS = "address";
    public static final String INTEGRITY_TYPE_HEALTH = "health";
    public static final String INTEGRITY_TYPE_NONE = "none";
    public static final String RESTRICTIVE_ON_DEVICE_PARAMS_KEY = "_onDeviceParams";
    public static boolean enabled;
    public static boolean isSampleEnabled;

    public static final void enable() {
        Class<IntegrityManager> cls = IntegrityManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                enabled = true;
                FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final String getIntegrityPredictionResult(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            for (int i = 0; i < 30; i++) {
                fArr[i] = 0.0f;
            }
            ModelManager modelManager = ModelManager.INSTANCE;
            String[] predict = ModelManager.predict(ModelManager.Task.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
            if (predict == null) {
                return INTEGRITY_TYPE_NONE;
            }
            String str2 = predict[0];
            if (str2 == null) {
                return INTEGRITY_TYPE_NONE;
            }
            return str2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final void processParameters(Map<String, String> map) {
        Class<IntegrityManager> cls = IntegrityManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(map, "parameters");
                if (enabled && !map.isEmpty()) {
                    try {
                        List<T> list = CollectionsKt__CollectionsKt.toList(map.keySet());
                        JSONObject jSONObject = new JSONObject();
                        for (T t : list) {
                            String str = map.get(t);
                            if (str != null) {
                                String str2 = str;
                                if (INSTANCE.shouldFilter(t) || INSTANCE.shouldFilter(str2)) {
                                    map.remove(t);
                                    if (!isSampleEnabled) {
                                        str2 = "";
                                    }
                                    jSONObject.put(t, str2);
                                }
                            } else {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                        }
                        if (jSONObject.length() != 0) {
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "restrictiveParamJson.toString()");
                            map.put(RESTRICTIVE_ON_DEVICE_PARAMS_KEY, jSONObject2);
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final boolean shouldFilter(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return !Intrinsics.areEqual(INTEGRITY_TYPE_NONE, getIntegrityPredictionResult(str));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
