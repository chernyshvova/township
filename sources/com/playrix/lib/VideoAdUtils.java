package com.playrix.lib;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.engine.Engine;
import com.playrix.township.BuildConfig;
import com.playrix.township.lib.Utils;
import java.io.File;
import java.net.URLEncoder;

public class VideoAdUtils {
    public static final String TAG = "VideoAdUtils";
    public static String mWebViewUserAgent;

    public static void CheckNoMedia(Activity activity) {
        SharedPreferences preferences;
        if (activity != null && (preferences = Engine.getPreferences()) != null) {
            for (String str : TextUtils.split(preferences.getString("_NoMediaCheckDirs_", "/supersonicads/graphicAssets,/UnityAdsCache"), ",")) {
                try {
                    if (new File(activity.getExternalCacheDir() + str).exists()) {
                        File file = new File(activity.getExternalCacheDir() + str, ".nomedia");
                        if (!file.exists()) {
                            Log.i(TAG, "Create nomedia: " + file.getPath());
                            file.createNewFile();
                        }
                    }
                } catch (Exception e) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error, can't create .nomedia, e:");
                    outline24.append(e.getMessage());
                    Log.w(TAG, outline24.toString());
                }
            }
        }
    }

    public static String ReplaceEncoded(String str, String str2, String str3) {
        try {
            return str.replace(str2, URLEncoder.encode(str3, "utf-8"));
        } catch (Exception e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("ReplaceEncoded excepction: ");
            outline24.append(e.getMessage());
            Log.e(TAG, outline24.toString());
            return str.replace(str2, str3);
        }
    }

    public static boolean checkCacheTime(SharedPreferences sharedPreferences, String str, int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = sharedPreferences.getLong(str + "_CacheTime", 0);
        return currentTimeMillis - j <= ((long) i) && j <= currentTimeMillis;
    }

    public static String fillVastTag(String str) {
        String str2;
        String str3;
        Context context = Engine.getContext();
        String replace = str.replace("&amp;", "&").replace("{{{bundleid}}}", context != null ? context.getPackageName() : BuildConfig.APPLICATION_ID);
        if (replace.contains("{{{webview_ua}}}")) {
            if (TextUtils.isEmpty(mWebViewUserAgent)) {
                mWebViewUserAgent = getDefaultUserAgentStringCached(Engine.getActivity());
            }
            replace = ReplaceEncoded(replace, "{{{webview_ua}}}", mWebViewUserAgent);
        }
        if (replace.contains("{{{screen_width}}}") || replace.contains("{{{screen_height}}}")) {
            Point displaySize = Engine.getDisplaySize();
            replace = replace.replace("{{{screen_width}}}", Integer.toString(displaySize.x)).replace("{{{screen_height}}}", Integer.toString(displaySize.y));
        }
        String replace2 = ReplaceEncoded(ReplaceEncoded(ReplaceEncoded(ReplaceEncoded(replace.replace("{{{device_type}}}", Engine.isDeviceTablet() ? "tablet" : Engine.isDevicePhablet() ? "phablet" : "phone"), "{{{model}}}", Build.MODEL), "{{{vendor}}}", Build.MANUFACTURER), "{{{os_version}}}", Build.VERSION.RELEASE), "{{{os_version_int}}}", Integer.toString(Build.VERSION.SDK_INT)).replace("{{{cache_breaker}}}", Long.toString(System.currentTimeMillis() / 1000)).replace("{{{appversion}}}", Engine.getAppVersion());
        String language = Utils.getLanguage("en");
        String replace3 = replace2.replace("{{{device_lang}}}", language);
        String countryTagByIp = Utils.getCountryTagByIp();
        if (!TextUtils.isEmpty(countryTagByIp)) {
            str2 = replace3.replace("{{{geoip}}}", countryTagByIp);
        } else {
            str2 = replace3.replace("{{{geoip}}}", language);
        }
        String publicIp = Utils.getPublicIp();
        if (!TextUtils.isEmpty(publicIp)) {
            str3 = str2.replace("{{{add_ip}}}", "&ip=" + publicIp).replace("{{{ip}}}", publicIp);
        } else {
            str3 = str2.replace("{{{add_ip}}}", "").replace("{{{ip}}}", "192.168.0.1");
        }
        String androidId = Engine.getAndroidId();
        if ((str3.contains("{{{aid_md5}}}") || str3.contains("{{{aid}}}")) && TextUtils.isEmpty(androidId)) {
            return "";
        }
        return str3.replace("{{{aid_md5}}}", Utils.getMD5(androidId)).replace("{{{aid}}}", androidId);
    }

    public static String getDefaultUserAgentString(Context context) {
        try {
            return WebSettings.getDefaultUserAgent(context);
        } catch (Exception unused) {
            return System.getProperty("http.agent");
        }
    }

    public static String getDefaultUserAgentStringCached(Context context) {
        SharedPreferences preferences = Engine.getPreferences();
        if (preferences == null) {
            return "";
        }
        if (!checkCacheTime(preferences, "WebViewAgent", 604800)) {
            String defaultUserAgentString = getDefaultUserAgentString(context);
            Log.i(TAG, "Cache WebViewAgent value: " + defaultUserAgentString);
            saveCacheTime(preferences, "WebViewAgent");
            preferences.edit().putString("WebViewAgent_Value", defaultUserAgentString).apply();
        }
        return preferences.getString("WebViewAgent_Value", "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isWebviewValid(android.content.Context r5) {
        /*
            java.lang.String r0 = "VideoAdUtils"
            java.lang.String r5 = getDefaultUserAgentStringCached(r5)     // Catch:{ Exception -> 0x001d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001b }
            r1.<init>()     // Catch:{ Exception -> 0x001b }
            java.lang.String r2 = "VastWebView, user agent: "
            r1.append(r2)     // Catch:{ Exception -> 0x001b }
            r1.append(r5)     // Catch:{ Exception -> 0x001b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x001b }
            android.util.Log.i(r0, r1)     // Catch:{ Exception -> 0x001b }
            goto L_0x001f
        L_0x001b:
            goto L_0x001f
        L_0x001d:
            java.lang.String r5 = ""
        L_0x001f:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            r2 = 0
            if (r1 != 0) goto L_0x0070
            java.lang.String r1 = "Chrome"
            int r1 = android.text.TextUtils.indexOf(r5, r1)
            if (r1 >= 0) goto L_0x002f
            goto L_0x0070
        L_0x002f:
            java.lang.String r1 = ".*Chrome/(\\d+)\\..*"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r5 = r1.matcher(r5)
            boolean r1 = r5.find()
            r3 = 1
            if (r1 == 0) goto L_0x0049
            java.lang.String r5 = r5.group(r3)     // Catch:{ NumberFormatException -> 0x0049 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x0049 }
            goto L_0x004a
        L_0x0049:
            r5 = 0
        L_0x004a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "VastWebView, Chrome: "
            r1.append(r4)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r1 < r4) goto L_0x0065
            return r3
        L_0x0065:
            r1 = 33
            if (r5 >= r1) goto L_0x006f
            java.lang.String r5 = "VastWebView disabled, chromeVersion < 33."
            android.util.Log.i(r0, r5)
            return r2
        L_0x006f:
            return r3
        L_0x0070:
            java.lang.String r5 = "VastWebView disabled, no Chrome in user agent."
            android.util.Log.i(r0, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.lib.VideoAdUtils.isWebviewValid(android.content.Context):boolean");
    }

    public static boolean isWebviewValidCached() {
        Context context = Engine.getContext();
        return context != null && isWebviewValidCached(context);
    }

    public static void saveCacheTime(SharedPreferences sharedPreferences, String str) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str + "_CacheTime", System.currentTimeMillis() / 1000).apply();
    }

    public static boolean isWebviewValidCached(Context context) {
        SharedPreferences preferences = Engine.getPreferences();
        if (preferences == null) {
            return false;
        }
        if (!checkCacheTime(preferences, "IsWebViewValid", 604800)) {
            boolean isWebviewValid = isWebviewValid(context);
            Log.i(TAG, "Cache IsWebViewValid value: " + isWebviewValid);
            saveCacheTime(preferences, "IsWebViewValid");
            preferences.edit().putBoolean("IsWebViewValid_Value", isWebviewValid).apply();
        }
        return preferences.getBoolean("IsWebViewValid_Value", false);
    }
}
