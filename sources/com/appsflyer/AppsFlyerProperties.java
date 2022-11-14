package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.C1387af;
import com.swrve.sdk.SwrveImp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    public static final String AF_KEY = "AppsFlyerKey";
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_FINGER_PRINT = "collectFingerPrint";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_MAC = "collectMAC";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    public static final String HTTP_CACHE = "http_cache";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";
    public static AppsFlyerProperties valueOf = new AppsFlyerProperties();
    public Map<String, Object> AFInAppEventParameterName = new HashMap();
    public String AFInAppEventType;
    public boolean AFKeystoreWrapper = false;
    public boolean values;

    public enum EmailsCryptType {
        NONE(0),
        SHA256(3);
        
        public final int values;

        /* access modifiers changed from: public */
        EmailsCryptType(int i) {
            this.values = i;
        }

        public final int getValue() {
            return this.values;
        }
    }

    public static AppsFlyerProperties getInstance() {
        return valueOf;
    }

    private boolean valueOf() {
        return this.AFKeystoreWrapper;
    }

    public final boolean AFKeystoreWrapper() {
        return this.values;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        if (string == null) {
            return z;
        }
        return Boolean.valueOf(string).booleanValue();
    }

    public int getInt(String str, int i) {
        String string = getString(str);
        if (string == null) {
            return i;
        }
        return Integer.valueOf(string).intValue();
    }

    public long getLong(String str, long j) {
        String string = getString(str);
        if (string == null) {
            return j;
        }
        return Long.valueOf(string).longValue();
    }

    public synchronized Object getObject(String str) {
        return this.AFInAppEventParameterName.get(str);
    }

    public String getReferrer(Context context) {
        String str = this.AFInAppEventType;
        if (str != null) {
            return str;
        }
        if (getString("AF_REFERRER") != null) {
            return getString("AF_REFERRER");
        }
        if (context == null) {
            return null;
        }
        return C1387af.AFInAppEventType(context).getString(SwrveImp.REFERRER, (String) null);
    }

    public synchronized String getString(String str) {
        return (String) this.AFInAppEventParameterName.get(str);
    }

    public boolean isEnableLog() {
        return getInt("logLevel", AFLogger.LogLevel.NONE.getLevel()) > AFLogger.LogLevel.NONE.getLevel();
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadProperties(android.content.Context r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.valueOf()     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            android.content.SharedPreferences r5 = com.appsflyer.internal.C1387af.AFInAppEventType((android.content.Context) r5)     // Catch:{ all -> 0x0061 }
            java.lang.String r0 = "savedProperties"
            r1 = 0
            java.lang.String r5 = r5.getString(r0, r1)     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x005f
            java.lang.String r0 = "Loading properties.."
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0)     // Catch:{ all -> 0x0061 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0046 }
            r0.<init>(r5)     // Catch:{ JSONException -> 0x0046 }
            java.util.Iterator r5 = r0.keys()     // Catch:{ JSONException -> 0x0046 }
        L_0x0024:
            boolean r1 = r5.hasNext()     // Catch:{ JSONException -> 0x0046 }
            if (r1 == 0) goto L_0x0042
            java.lang.Object r1 = r5.next()     // Catch:{ JSONException -> 0x0046 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x0046 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = r4.AFInAppEventParameterName     // Catch:{ JSONException -> 0x0046 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ JSONException -> 0x0046 }
            if (r2 != 0) goto L_0x0024
            java.util.Map<java.lang.String, java.lang.Object> r2 = r4.AFInAppEventParameterName     // Catch:{ JSONException -> 0x0046 }
            java.lang.String r3 = r0.getString(r1)     // Catch:{ JSONException -> 0x0046 }
            r2.put(r1, r3)     // Catch:{ JSONException -> 0x0046 }
            goto L_0x0024
        L_0x0042:
            r5 = 1
            r4.AFKeystoreWrapper = r5     // Catch:{ JSONException -> 0x0046 }
            goto L_0x004c
        L_0x0046:
            r5 = move-exception
            java.lang.String r0 = "Failed loading properties"
            com.appsflyer.AFLogger.values(r0, r5)     // Catch:{ all -> 0x0061 }
        L_0x004c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            java.lang.String r0 = "Done loading properties: "
            r5.<init>(r0)     // Catch:{ all -> 0x0061 }
            boolean r0 = r4.AFKeystoreWrapper     // Catch:{ all -> 0x0061 }
            r5.append(r0)     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0061 }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r5)     // Catch:{ all -> 0x0061 }
        L_0x005f:
            monitor-exit(r4)
            return
        L_0x0061:
            r5 = move-exception
            monitor-exit(r4)
            goto L_0x0065
        L_0x0064:
            throw r5
        L_0x0065:
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerProperties.loadProperties(android.content.Context):void");
    }

    public synchronized void remove(String str) {
        this.AFInAppEventParameterName.remove(str);
    }

    public synchronized void saveProperties(SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putString("savedProperties", new JSONObject(this.AFInAppEventParameterName).toString()).apply();
    }

    public synchronized void set(String str, String str2) {
        this.AFInAppEventParameterName.put(str, str2);
    }

    public synchronized void setCustomData(String str) {
        this.AFInAppEventParameterName.put(ADDITIONAL_CUSTOM_DATA, str);
    }

    public synchronized void setUserEmails(String str) {
        this.AFInAppEventParameterName.put(USER_EMAILS, str);
    }

    public synchronized void set(String str, String[] strArr) {
        this.AFInAppEventParameterName.put(str, strArr);
    }

    public synchronized void set(String str, int i) {
        this.AFInAppEventParameterName.put(str, Integer.toString(i));
    }

    public synchronized void set(String str, long j) {
        this.AFInAppEventParameterName.put(str, Long.toString(j));
    }

    public synchronized void set(String str, boolean z) {
        this.AFInAppEventParameterName.put(str, Boolean.toString(z));
    }
}
