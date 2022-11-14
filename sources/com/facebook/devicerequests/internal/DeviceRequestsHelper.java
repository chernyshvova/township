package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONObject;

/* compiled from: DeviceRequestsHelper.kt */
public final class DeviceRequestsHelper {
    public static final String DEVICE_INFO_DEVICE = "device";
    public static final String DEVICE_INFO_MODEL = "model";
    public static final String DEVICE_INFO_PARAM = "device_info";
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    public static final DeviceRequestsHelper INSTANCE = new DeviceRequestsHelper();
    public static final String SDK_FLAVOR = "android";
    public static final String SDK_HEADER = "fbsdk";
    public static final String SERVICE_TYPE = "_fb._tcp.";
    public static final String TAG = DeviceRequestsHelper.class.getCanonicalName();
    public static final HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners = new HashMap<>();

    public static final void cleanUpAdvertisementService(String str) {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.cleanUpAdvertisementServiceImpl(str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @TargetApi(16)
    private final void cleanUpAdvertisementServiceImpl(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                NsdManager.RegistrationListener registrationListener = deviceRequestsListeners.get(str);
                if (registrationListener != null) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
                    if (systemService != null) {
                        ((NsdManager) systemService).unregisterService(registrationListener);
                        deviceRequestsListeners.remove(str);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
                }
            } catch (IllegalArgumentException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final Bitmap generateQRCode(String str) {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        Bitmap bitmap = null;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put(EncodeHintType.MARGIN, 2);
            try {
                BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 200, 200, enumMap);
                int i = encode.height;
                int i2 = encode.width;
                int[] iArr = new int[(i * i2)];
                if (i > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        int i5 = i3 * i2;
                        if (i2 > 0) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6 + 1;
                                iArr[i5 + i6] = encode.get(i6, i3) ? ViewCompat.MEASURED_STATE_MASK : -1;
                                if (i7 >= i2) {
                                    break;
                                }
                                i6 = i7;
                            }
                        }
                        if (i4 >= i) {
                            break;
                        }
                        i3 = i4;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                try {
                    createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i);
                    return createBitmap;
                } catch (WriterException unused) {
                    bitmap = createBitmap;
                }
            } catch (WriterException unused2) {
                return bitmap;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final String getDeviceInfo(Map<String, String> map) {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return null;
            }
        }
        String str = Build.DEVICE;
        Intrinsics.checkNotNullExpressionValue(str, "DEVICE");
        map.put(DEVICE_INFO_DEVICE, str);
        String str2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str2, "MODEL");
        map.put(DEVICE_INFO_MODEL, str2);
        String jSONObject = new JSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(deviceInfo as Map<*, *>).toString()");
        return jSONObject;
    }

    public static final boolean isAvailable() {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null || !appSettingsWithoutQuery.getSmartLoginOptions().contains(SmartLoginOption.Enabled)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean startAdvertisementService(String str) {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (isAvailable()) {
                return INSTANCE.startAdvertisementServiceImpl(str);
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    @TargetApi(16)
    private final boolean startAdvertisementServiceImpl(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (deviceRequestsListeners.containsKey(str)) {
                return true;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String str2 = "fbsdk_" + Intrinsics.stringPlus("android-", CharsKt__CharKt.replace$default(FacebookSdk.getSdkVersion(), '.', '|', false, 4)) + '_' + str;
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType(SERVICE_TYPE);
            nsdServiceInfo.setServiceName(str2);
            nsdServiceInfo.setPort(80);
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
            if (systemService != null) {
                C1548x8b27078b deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1 = new C1548x8b27078b(str2, str);
                deviceRequestsListeners.put(str, deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1);
                ((NsdManager) systemService).registerService(nsdServiceInfo, 1, deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1);
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public static final String getDeviceInfo() {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return getDeviceInfo((Map<String, String>) null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
