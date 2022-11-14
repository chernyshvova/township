package com.swrve.sdk;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.Display;
import android.view.WindowManager;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.swrve.sdk.ISwrveCommon;
import com.vungle.warren.VisionController;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public final class SwrveHelper {
    public static final String CHARSET = "UTF-8";
    public static String appInstallTime;
    public static final SimpleDateFormat appInstallTimeFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
    public static String buildModel = Build.MODEL;

    /* renamed from: com.swrve.sdk.SwrveHelper$1 */
    public static /* synthetic */ class C16861 {
        public static final /* synthetic */ int[] $SwitchMap$com$swrve$sdk$ISwrveCommon$SupportedUIMode;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.swrve.sdk.ISwrveCommon$SupportedUIMode[] r0 = com.swrve.sdk.ISwrveCommon.SupportedUIMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$swrve$sdk$ISwrveCommon$SupportedUIMode = r0
                com.swrve.sdk.ISwrveCommon$SupportedUIMode r1 = com.swrve.sdk.ISwrveCommon.SupportedUIMode.TV     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$com$swrve$sdk$ISwrveCommon$SupportedUIMode     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.ISwrveCommon$SupportedUIMode r1 = com.swrve.sdk.ISwrveCommon.SupportedUIMode.MOBILE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveHelper.C16861.<clinit>():void");
        }
    }

    public static Map<String, String> JSONToMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.getString(next));
        }
        return hashMap;
    }

    public static Date addTimeInterval(Date date, int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(i2, i);
        return instance.getTime();
    }

    public static Map<String, String> combineTwoStringMaps(Map<String, String> map, Map<String, String> map2) {
        if (isNullOrEmpty(map) && isNullOrEmpty(map2)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        return hashMap;
    }

    public static JSONObject convertPayloadToJSONObject(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle.containsKey(SwrveNotificationInternalPayloadConstants.SWRVE_NESTED_JSON_PAYLOAD_KEY)) {
            try {
                jSONObject = new JSONObject(bundle.getString(SwrveNotificationInternalPayloadConstants.SWRVE_NESTED_JSON_PAYLOAD_KEY));
            } catch (Exception e) {
                SwrveLogger.m2753e("SwrveNotificationEngageReceiver. Could not parse deep Json", e, new Object[0]);
            }
        }
        for (String str : bundle.keySet()) {
            if (!str.equals(SwrveNotificationInternalPayloadConstants.SWRVE_NESTED_JSON_PAYLOAD_KEY)) {
                try {
                    jSONObject.put(str, bundle.get(str));
                } catch (Exception e2) {
                    SwrveLogger.m2754e("SwrveNotificationEngageReceiver. Could not add key to payload %s", str, e2);
                }
            }
        }
        return jSONObject;
    }

    public static String createHMACWithMD5(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac instance = Mac.getInstance("HmacMD5");
        instance.init(new SecretKeySpec(str2.getBytes(), instance.getAlgorithm()));
        return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
    }

    public static String encodeParameters(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
            sb2.append("=");
            sb2.append(next.getValue() == null ? "null" : URLEncoder.encode((String) next.getValue(), "UTF-8"));
            sb.append(sb2.toString());
        }
        return sb.toString();
    }

    public static String generateSessionToken(String str, int i, String str2) {
        String l = Long.toString(new Date().getTime() / 1000);
        String md5 = md5(str2 + l + str);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("=");
        sb.append(str2);
        sb.append("=");
        sb.append(l);
        return GeneratedOutlineSupport.outline18(sb, "=", md5);
    }

    public static String getAppInstallTime(Context context) {
        if (appInstallTime == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                currentTimeMillis = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            } catch (PackageManager.NameNotFoundException e) {
                SwrveLogger.m2753e("Could not get package info to retrieve appInstallTime so using current date.", e, new Object[0]);
            }
            appInstallTime = appInstallTimeFormat.format(new Date(currentTimeMillis));
        }
        return appInstallTime;
    }

    public static Map<String, String> getBundleAsMap(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.getString(str));
            }
        }
        return hashMap;
    }

    public static int getDisplayHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(VisionController.WINDOW);
        if (windowManager == null) {
            SwrveLogger.m2755i("Current device does not have a Window Service active", new Object[0]);
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT < 30) {
            return defaultDisplay.getHeight();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public static int getDisplayWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(VisionController.WINDOW);
        if (windowManager == null) {
            SwrveLogger.m2755i("Current device does not have a Window Service active", new Object[0]);
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT < 30) {
            return defaultDisplay.getWidth();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public static String getPlatformDeviceType(Context context) {
        return getSupportedUIMode(context).ordinal() != 1 ? ISwrveCommon.DEVICE_TYPE_MOBILE : ISwrveCommon.DEVICE_TYPE_TV;
    }

    public static String getPlatformOS(Context context) {
        return getPlatformOS(context, (SwrveFlavour) null);
    }

    public static String getRemotePushId(Bundle bundle) {
        Object obj;
        if (bundle == null || (obj = bundle.get(SwrveNotificationInternalPayloadConstants.SWRVE_TRACKING_KEY)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static String getSilentPushId(Bundle bundle) {
        Object obj;
        if (bundle == null || (obj = bundle.get(SwrveNotificationConstants.SWRVE_SILENT_TRACKING_KEY)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static ISwrveCommon.SupportedUIMode getSupportedUIMode(Context context) {
        if (((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4) {
            return ISwrveCommon.SupportedUIMode.TV;
        }
        return ISwrveCommon.SupportedUIMode.MOBILE;
    }

    public static int getTargetSdkVersion(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo != null) {
                return applicationInfo.targetSdkVersion;
            }
            return 0;
        } catch (Exception e) {
            SwrveLogger.m2753e("", e, new Object[0]);
            return 0;
        }
    }

    public static boolean hasFileAccess(String str) {
        if (Build.VERSION.SDK_INT <= 21) {
            return true;
        }
        return new File(str).canRead();
    }

    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isSwrvePush(Bundle bundle) {
        String remotePushId = getRemotePushId(bundle);
        if (isNullOrEmpty(remotePushId)) {
            remotePushId = getSilentPushId(bundle);
        }
        return isNotNullOrEmpty(remotePushId);
    }

    public static void logAndThrowException(String str) throws IllegalArgumentException {
        SwrveLogger.m2754e(str, new Object[0]);
        throw new IllegalArgumentException(str);
    }

    public static String md5(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                byte b2 = b & com.playrix.gplay.billing.Base64.EQUALS_SIGN_ENC;
                if (b2 < 16) {
                    sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            SwrveLogger.wtf("Couldn't find MD5 - what a strange JVM", e);
            return "";
        }
    }

    public static String readStringFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb.toString();
            }
            sb.append(readLine);
        }
    }

    public static boolean sdkAvailable() {
        return sdkAvailable((List<String>) null);
    }

    public static boolean serverErrorResponseCode(int i) {
        return i >= 500;
    }

    public static String sha1(byte[] bArr) {
        if (bArr.length == 0) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                byte b2 = b & com.playrix.gplay.billing.Base64.EQUALS_SIGN_ENC;
                if (b2 < 16) {
                    sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            SwrveLogger.wtf("Couldn't find SHA1 - what a strange JVM", e);
            return "";
        }
    }

    public static boolean successResponseCode(int i) {
        return i >= 200 && i < 300;
    }

    public static String toLanguageTag(Locale locale) {
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        if (!isNullOrEmpty(locale.getCountry())) {
            sb.append('-');
            sb.append(locale.getCountry());
        }
        if (!isNullOrEmpty(locale.getVariant())) {
            sb.append('-');
            sb.append(locale.getVariant());
        }
        return sb.toString();
    }

    public static boolean userErrorResponseCode(int i) {
        return i >= 400 && i < 500;
    }

    public static String getPlatformOS(Context context, SwrveFlavour swrveFlavour) {
        if (swrveFlavour == null) {
            if (isNullOrEmpty(Build.MANUFACTURER)) {
                return "android";
            }
            return Build.MANUFACTURER.equalsIgnoreCase(SwrveAppStore.Amazon) ? getSupportedUIMode(context).ordinal() != 1 ? ISwrveCommon.OS_AMAZON : ISwrveCommon.OS_AMAZON_TV : getSupportedUIMode(context).ordinal() != 1 ? "android" : ISwrveCommon.OS_ANDROID_TV;
        } else if (swrveFlavour == SwrveFlavour.AMAZON) {
            return getSupportedUIMode(context).ordinal() != 1 ? ISwrveCommon.OS_AMAZON : ISwrveCommon.OS_AMAZON_TV;
        } else {
            if (swrveFlavour == SwrveFlavour.HUAWEI) {
                return ISwrveCommon.OS_HUAWEI;
            }
            return getSupportedUIMode(context).ordinal() != 1 ? "android" : ISwrveCommon.OS_ANDROID_TV;
        }
    }

    public static boolean isNullOrEmpty(Map<String, String> map) {
        return map == null || map.isEmpty();
    }

    public static boolean sdkAvailable(List<String> list) {
        if (list == null || !list.contains(buildModel)) {
            return true;
        }
        SwrveLogger.m2755i("Current device is part of the model blacklist", new Object[0]);
        return false;
    }
}
