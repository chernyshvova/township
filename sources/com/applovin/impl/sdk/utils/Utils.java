package com.applovin.impl.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.icu.util.VersionInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.p025ad.AppLovinAdImpl;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p025ad.C1063f;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1093a;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.drive.DriveFile;
import com.vungle.warren.VisionController;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

@Keep
public abstract class Utils {
    public static final int BYTES_PER_KB = 1024;
    public static final String MACRO_CLCODE = "{CLCODE}";
    public static final String MACRO_CLICK_X = "{CLICK_X}";
    public static final String MACRO_CLICK_Y = "{CLICK_Y}";
    public static final String MACRO_EVENT_ID = "{EVENT_ID}";
    public static final String MACRO_IS_VIDEO_CLICK = "{IS_VIDEO_CLICK}";
    public static final String MACRO_SCREEN_HEIGHT = "{SCREEN_HEIGHT}";
    public static final String MACRO_SCREEN_WIDTH = "{SCREEN_WIDTH}";
    public static final String PLACEMENT_MACRO = "{PLACEMENT}";
    public static final String PLAY_STORE_PACKAGE_NAME = "com.android.vending";
    public static final String PLAY_STORE_SCHEME = "market";
    public static final String SHOWN_OUT_OF_CONTEXT_MACRO = "{SOC}";
    public static final String TAG = "Utils";
    public static final DecimalFormat decimalFormat = new DecimalFormat();
    public static Boolean isDspDemoApp;
    public static Boolean isExoPlayerEligible;

    public static boolean bitMaskContainsFlag(long j, long j2) {
        return (j & j2) != 0;
    }

    public static List<Uri> checkCachedResourcesExist(boolean z, C1057e eVar, C1188m mVar, Context context) {
        if (eVar instanceof C0631a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = new ArrayList(eVar.mo10635y()).iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!mVar.mo10963aa().mo11247b(uri.getLastPathSegment(), context)) {
                C1314v B = mVar.mo10922B();
                B.mo11376e("Utils", "Cached HTML asset missing: " + uri);
                arrayList.add(uri);
            }
        }
        if (z) {
            Uri g = eVar.mo9317g();
            if (!mVar.mo10963aa().mo11247b(g.getLastPathSegment(), context)) {
                C1314v B2 = mVar.mo10922B();
                B2.mo11376e("Utils", "Cached video missing: " + g);
                arrayList.add(g);
            }
        }
        return arrayList;
    }

    public static boolean checkClassExistence(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean checkClassesExistence(List<String> list) {
        for (String checkClassExistence : list) {
            if (checkClassExistence(checkClassExistence)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkExoPlayerEligibility(C1188m mVar) {
        if (isExoPlayerEligible == null) {
            int tryToGetExoPlayerVersionCode = tryToGetExoPlayerVersionCode();
            int intValue = ((Integer) mVar.mo10946a(C1085b.f1657cJ)).intValue();
            isExoPlayerEligible = Boolean.valueOf(checkClassExistence("com.google.android.exoplayer2.ui.PlayerView") && tryToGetExoPlayerVersionCode >= ((Integer) mVar.mo10946a(C1085b.f1656cI)).intValue() && (intValue < 0 || tryToGetExoPlayerVersionCode <= intValue));
        }
        return isExoPlayerEligible.booleanValue();
    }

    public static void close(Closeable closeable, C1188m mVar) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                if (mVar != null) {
                    C1314v B = mVar.mo10922B();
                    B.mo11373b("Utils", "Unable to close stream: " + closeable, th);
                }
            }
        }
    }

    public static int compare(String str, String str2) {
        String digitsOnlyVersionString = StringUtils.toDigitsOnlyVersionString(str);
        String digitsOnlyVersionString2 = StringUtils.toDigitsOnlyVersionString(str2);
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                int compareTo = VersionInfo.getInstance(digitsOnlyVersionString).compareTo(VersionInfo.getInstance(digitsOnlyVersionString2));
                return compareTo == 0 ? compareTo : compareTo > 0 ? 1 : -1;
            }
            String[] split = digitsOnlyVersionString.split("\\.");
            String[] split2 = digitsOnlyVersionString2.split("\\.");
            int max = Math.max(split.length, split2.length);
            int i = 0;
            while (i < max) {
                boolean isValidString = StringUtils.isValidString(split[i]);
                String str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                String str4 = isValidString ? split[i] : str3;
                if (StringUtils.isValidString(split2[i])) {
                    str3 = split2[i];
                }
                int parseInt = i < split.length ? Integer.parseInt(str4) : 0;
                int parseInt2 = i < split2.length ? Integer.parseInt(str3) : 0;
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            }
            return 0;
        } catch (Throwable th) {
            C1314v.m2659c("Utils", "Failed to process version string.", th);
            return 0;
        }
    }

    public static void disconnect(HttpURLConnection httpURLConnection, C1188m mVar) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                if (mVar != null) {
                    C1314v B = mVar.mo10922B();
                    B.mo11373b("Utils", "Unable to disconnect connection: " + httpURLConnection, th);
                }
            }
        }
    }

    public static String encodeUrlMap(Map<String, String> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            TreeMap treeMap = new TreeMap(new Comparator<String>() {
                /* renamed from: a */
                public int compare(String str, String str2) {
                    return str.compareToIgnoreCase(str2);
                }
            });
            treeMap.putAll(map);
            map = treeMap;
        }
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(next.getKey());
            sb.append('=');
            sb.append(next.getValue());
        }
        return sb.toString();
    }

    public static long floatToLong(float f) {
        return (long) Math.round(f);
    }

    public static String formatDoubleValue(double d, int i) {
        decimalFormat.setMaximumFractionDigits(i);
        return decimalFormat.format(d);
    }

    public static List<Class> generateClassesList(List<String> list, C1188m mVar) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String next : list) {
            try {
                arrayList.add(Class.forName(next));
            } catch (ClassNotFoundException unused) {
                C1314v B = mVar.mo10922B();
                B.mo11376e("Utils", "Failed to create class for name: " + next);
            }
        }
        return arrayList;
    }

    public static int getAlwaysFinishActivitiesSetting(Context context) {
        boolean b = C1263g.m2506b();
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
    }

    public static String getAndroidOSInfo() {
        try {
            return Build.VERSION.RELEASE + " (" + getAndroidSdkCodename() + " - API " + Build.VERSION.SDK_INT + ")";
        } catch (Throwable th) {
            C1314v.m2659c("Utils", "Unable to get Android OS info", th);
            return "";
        }
    }

    public static String getAndroidSdkCodename() {
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt((Object) null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th) {
            C1314v.m2659c("Utils", "Unable to get Android SDK codename", th);
            return "";
        }
    }

    public static boolean getBooleanForProbability(int i) {
        return i > 0 && i <= 100 && ((int) (Math.random() * 100.0d)) + 1 <= i;
    }

    public static Field getField(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return getField(superclass, str);
        }
    }

    @Nullable
    public static Map<String, String> getMetaData(AppLovinSdkSettings appLovinSdkSettings) {
        try {
            Field field = getField(appLovinSdkSettings.getClass(), "metaData");
            if (field != null) {
                field.setAccessible(true);
            }
            return (Map) field.get(appLovinSdkSettings);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getOrientation(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    public static List<C1093a> getPostbacks(String str, JSONObject jSONObject, String str2, String str3, C1188m mVar) {
        return getPostbacks(str, jSONObject, str2, (Map<String, String>) null, str3, mVar);
    }

    public static List<C1093a> getPostbacks(String str, JSONObject jSONObject, String str2, String str3, Map<String, String> map, C1188m mVar) {
        return getPostbacks(str, jSONObject, str2, Collections.emptyMap(), str3, map, false, mVar);
    }

    public static List<C1093a> getPostbacks(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, C1188m mVar) {
        return getPostbacks(str, jSONObject, str2, map, str3, (Map<String, String>) null, false, mVar);
    }

    public static List<C1093a> getPostbacks(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, Map<String, String> map2, boolean z, C1188m mVar) {
        if (map == null) {
            map = new HashMap<>(1);
        }
        Map<String, String> map3 = map;
        map3.put(MACRO_CLCODE, str2);
        return getPostbacks(str, jSONObject, map3, str3, map2, z, mVar);
    }

    public static List<C1093a> getPostbacks(String str, JSONObject jSONObject, Map<String, String> map, String str2, C1188m mVar) {
        return getPostbacks(str, jSONObject, map, str2, (Map<String, String>) null, mVar);
    }

    public static List<C1093a> getPostbacks(String str, JSONObject jSONObject, Map<String, String> map, String str2, Map<String, String> map2, C1188m mVar) {
        return getPostbacks(str, jSONObject, map, str2, map2, false, mVar);
    }

    public static List<C1093a> getPostbacks(String str, JSONObject jSONObject, Map<String, String> map, String str2, Map<String, String> map2, boolean z, C1188m mVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, str, new JSONObject());
        ArrayList arrayList = new ArrayList(jSONObject2.length() + 1);
        if (StringUtils.isValidString(str2)) {
            arrayList.add(new C1093a(str2, (String) null, map2, z));
        }
        if (jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String optString = jSONObject2.optString(next);
                        String replace = StringUtils.replace(next, map);
                        if (!TextUtils.isEmpty(optString)) {
                            optString = StringUtils.replace(optString, map);
                        }
                        arrayList.add(new C1093a(replace, optString, map2, z));
                    }
                } catch (Throwable th) {
                    mVar.mo10922B().mo11373b("Utils", "Failed to create and add postback url.", th);
                }
            }
        }
        return arrayList;
    }

    public static View getRootView(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        return findViewById != null ? findViewById : rootView;
    }

    public static int getRotation(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(VisionController.WINDOW);
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    public static String getSafedkSdkKey() {
        return getSafedkString("getSdkKey");
    }

    public static String getSafedkString(String str) {
        Class<?> cls;
        try {
            cls = Class.forName("com.applovin.quality.AppLovinQualityService");
        } catch (Throwable unused) {
            return "";
        }
        return (String) cls.getMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }

    public static String getSafedkVersion() {
        return getSafedkString("getVersion");
    }

    public static long getServerAdjustedUnixTimestampMillis(C1188m mVar) {
        long longValue = ((Long) mVar.mo10946a(C1085b.f1799ev)).longValue();
        long longValue2 = ((Long) mVar.mo10946a(C1085b.f1800ew)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        return (longValue <= 0 || longValue2 <= 0) ? currentTimeMillis : (longValue - longValue2) + currentTimeMillis;
    }

    public static String getString(Class cls, String str) {
        try {
            Field field = getField(cls, str);
            field.setAccessible(true);
            return (String) field.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getUserEngagementSdkVersion() {
        try {
            return (String) Class.forName("com.applovin.sdk.userengagement.impl.api.AppLovinUserEngagementSdkImpl").getMethod("getVersion", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int getVideoCompletionPercent(JSONObject jSONObject) {
        int i = JsonUtils.getInt(jSONObject, "video_completion_percent", -1);
        if (i < 0 || i > 100) {
            return 95;
        }
        return i;
    }

    public static C1056d getZone(JSONObject jSONObject, C1188m mVar) {
        return C1056d.m1472a(AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", (String) null)), AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", (String) null)), JsonUtils.getString(jSONObject, "zone_id", (String) null));
    }

    public static byte[] gzip(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean hasAndroidCoreJsonLibrary(C1188m mVar) {
        if (!C1263g.m2507c()) {
            return true;
        }
        try {
            JSONObject.wrap(JSONObject.NULL);
            return true;
        } catch (Throwable th) {
            mVar.mo10922B().mo11371a("Utils", "Failed to wrap JSONObject with exception", th);
            return false;
        }
    }

    public static boolean isAppLovinTestEnvironment(Context context) {
        return C1259d.m2494a(context).mo11274a("applovin.sdk.is_test_environment");
    }

    public static boolean isBML(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER || appLovinAdSize == AppLovinAdSize.CROSS_PROMO;
    }

    public static boolean isCurrentProcessInForeground() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th) {
            C1314v.m2659c("Utils", "Exception thrown while getting memory state.", th);
        }
        int i = runningAppProcessInfo.importance;
        return i == 100 || i == 200;
    }

    public static boolean isDeepLinkPlusUrl(Uri uri) {
        return uri != null && AppLovinNativeAdImpl.AD_RESPONSE_TYPE_APPLOVIN.equalsIgnoreCase(uri.getScheme()) && "com.applovin.sdk".equalsIgnoreCase(uri.getHost()) && "/adservice/deeplink".equals(uri.getPath());
    }

    public static boolean isDomainWhitelisted(String str, List<String> list) {
        for (String startsWith : list) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDspDemoApp(Context context) {
        if (isDspDemoApp == null) {
            isDspDemoApp = Boolean.valueOf("com.applovin.apps.dspdemo".equals(context.getPackageName()));
        }
        return isDspDemoApp.booleanValue();
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isProguardRulesOmitted() {
        try {
            Class.forName("com.applovin.sdk.AppLovinSdk");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        }
    }

    public static boolean isPubInDebugMode(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean isTestApp(Context context) {
        String packageName = context.getPackageName();
        return "com.revolverolver.fliptrickster".equals(packageName) || "com.mindstormstudios.idlemakeover".equals(packageName);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000a A[Catch:{ all -> 0x002e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isVPNConnected() {
        /*
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ all -> 0x002e }
        L_0x0004:
            boolean r1 = r0.hasMoreElements()     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.nextElement()     // Catch:{ all -> 0x002e }
            java.net.NetworkInterface r1 = (java.net.NetworkInterface) r1     // Catch:{ all -> 0x002e }
            java.lang.String r1 = r1.getDisplayName()     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "tun"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = "ppp"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = "ipsec"
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0004
        L_0x002c:
            r0 = 1
            return r0
        L_0x002e:
            r0 = move-exception
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "Unable to check Network Interfaces"
            com.applovin.impl.sdk.C1314v.m2659c(r1, r2, r0)
        L_0x0036:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.Utils.isVPNConnected():boolean");
    }

    @Keep
    public static boolean isVerboseLoggingConfigured() {
        Context M = C1188m.m2053M();
        if (M != null) {
            return C1259d.m2494a(M).mo11274a("applovin.sdk.verbose_logging");
        }
        return false;
    }

    public static boolean isVerboseLoggingEnabled(Context context) {
        if (context == null) {
            context = C1188m.m2053M();
        }
        if (context != null) {
            return C1259d.m2494a(context).mo11275a("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    public static boolean isVideoMutedInitially(C1188m mVar) {
        return ((Boolean) mVar.mo10946a(C1085b.f1699cz)).booleanValue() ? mVar.mo10999p().isMuted() : ((Boolean) mVar.mo10946a(C1085b.f1697cx)).booleanValue();
    }

    public static boolean isViewInChildView(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (isViewInChildView(view, viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isViewInTopActivity(View view, Activity activity) {
        View rootView;
        if (!(activity == null || view == null)) {
            Window window = activity.getWindow();
            if (window != null) {
                rootView = window.getDecorView();
            } else {
                View findViewById = activity.findViewById(16908290);
                if (findViewById != null) {
                    rootView = findViewById.getRootView();
                }
            }
            return isViewInChildView(view, rootView);
        }
        return false;
    }

    public static void maybeHandleNoFillResponseForPublisher(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, C1188m mVar) {
        if (jSONObject.has("no_fill_reason")) {
            Object object = JsonUtils.getObject(jSONObject, "no_fill_reason", new Object());
            StringBuilder outline27 = GeneratedOutlineSupport.outline27("\n**************************************************\nNO FILL received:\n..ID: \"", str, "\"\n..FORMAT: \"");
            outline27.append(maxAdFormat.getLabel());
            outline27.append("\"\n..SDK KEY: \"");
            outline27.append(mVar.mo11010z());
            outline27.append("\"\n..PACKAGE NAME: \"");
            outline27.append(mVar.mo10932L().getPackageName());
            outline27.append("\"\n..Reason: ");
            outline27.append(object);
            outline27.append("\n**************************************************\n");
            C1314v.m2663i(AppLovinSdk.TAG, outline27.toString());
        }
    }

    public static AppLovinAd maybeRetrieveNonDummyAd(AppLovinAd appLovinAd, C1188m mVar) {
        if (!(appLovinAd instanceof C1063f)) {
            return appLovinAd;
        }
        C1063f fVar = (C1063f) appLovinAd;
        AppLovinAd dequeueAd = mVar.mo11005u().dequeueAd(fVar.getAdZone());
        C1314v B = mVar.mo10922B();
        B.mo11372b("Utils", "Dequeued ad for dummy ad: " + dequeueAd);
        if (dequeueAd == null) {
            return fVar.mo10637a();
        }
        fVar.mo10638a(dequeueAd);
        ((AppLovinAdImpl) dequeueAd).setDummyAd(fVar);
        return dequeueAd;
    }

    public static double millisToSeconds(long j) {
        double d = (double) j;
        Double.isNaN(d);
        return d / 1000.0d;
    }

    public static boolean objectIsOfType(Object obj, List<String> list, C1188m mVar) {
        if (list == null) {
            return false;
        }
        for (Class isInstance : generateClassesList(list, mVar)) {
            if (isInstance.isInstance(obj)) {
                if (obj instanceof Map) {
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        if (!(entry.getKey() instanceof String)) {
                            mVar.mo10922B().mo11372b("Utils", "Invalid key type used. Map keys should be of type String.");
                            return false;
                        } else if (!objectIsOfType(entry.getValue(), list, mVar)) {
                            return false;
                        }
                    }
                    return true;
                } else if (!(obj instanceof List)) {
                    return true;
                } else {
                    for (Object objectIsOfType : (List) obj) {
                        if (!objectIsOfType(objectIsOfType, list, mVar)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        C1314v B = mVar.mo10922B();
        B.mo11372b("Utils", "Object '" + obj + "' does not match any of the required types '" + list + "'.");
        return false;
    }

    public static boolean openUri(Context context, Uri uri, C1188m mVar) {
        boolean z = false;
        if (uri == null) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
            }
            if (PLAY_STORE_SCHEME.equals(intent.getScheme())) {
                intent.setPackage("com.android.vending");
            }
            mVar.mo10965ac().mo11388c();
            context.startActivity(intent);
            z = true;
        } catch (Throwable th) {
            C1314v B = mVar.mo10922B();
            B.mo11373b("Utils", "Unable to open \"" + uri + "\".", th);
        }
        if (!z) {
            mVar.mo10965ac().mo11389d();
        }
        return z;
    }

    public static long parseColor(String str) {
        if (!StringUtils.isValidString(str)) {
            return RecyclerView.FOREVER_NS;
        }
        try {
            return (long) Color.parseColor(str);
        } catch (Throwable unused) {
            return RecyclerView.FOREVER_NS;
        }
    }

    public static void putObjectForStringIfValid(String str, String str2, Map map) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public static void renameKeyInObjectMap(String str, String str2, Map<String, Object> map) {
        if (map.containsKey(str)) {
            map.put(str2, map.get(str));
            map.remove(str);
        }
    }

    public static String replaceCommonMacros(String str) {
        return replaceCommonMacros(false, str);
    }

    public static String replaceCommonMacros(boolean z, String str) {
        return str.replace(PLACEMENT_MACRO, "").replace(SHOWN_OUT_OF_CONTEXT_MACRO, String.valueOf(z));
    }

    public static String retrieveLauncherActivityFullyQualifiedName(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (!queryIntentActivities.isEmpty()) {
            return queryIntentActivities.get(0).activityInfo.name;
        }
        return null;
    }

    public static Activity retrieveParentActivity(View view, C1188m mVar) {
        if (view == null) {
            return null;
        }
        int i = 0;
        while (i < 1000) {
            i++;
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                mVar.mo10922B().mo11373b("Utils", "Encountered error while retrieving activity from view", th);
            }
        }
        return null;
    }

    public static Object sanitizeSuperProperty(Object obj, C1188m mVar) {
        int i;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            HashMap hashMap = new HashMap(map.size());
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                hashMap.put(key instanceof String ? (String) key : String.valueOf(key), sanitizeSuperProperty(entry.getValue(), mVar));
            }
            return hashMap;
        } else if (obj instanceof List) {
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (Object sanitizeSuperProperty : list) {
                arrayList.add(sanitizeSuperProperty(sanitizeSuperProperty, mVar));
            }
            return arrayList;
        } else if (obj instanceof Date) {
            return String.valueOf(((Date) obj).getTime());
        } else {
            String valueOf = String.valueOf(obj);
            if (obj instanceof String) {
                i = ((Integer) mVar.mo10946a(C1085b.f1633bl)).intValue();
                if (i <= 0 || valueOf.length() <= i) {
                    return valueOf;
                }
            } else if (!(obj instanceof Uri) || (i = ((Integer) mVar.mo10946a(C1085b.f1634bm)).intValue()) <= 0 || valueOf.length() <= i) {
                return valueOf;
            }
            return valueOf.substring(0, i);
        }
    }

    public static float secondsToMillis(float f) {
        return f * 1000.0f;
    }

    public static long secondsToMillisLong(float f) {
        return floatToLong(secondsToMillis(f));
    }

    public static String shortenKey(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    public static void showAlert(String str, String str2, Context context) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(17039370, (DialogInterface.OnClickListener) null).create().show();
    }

    public static void showToast(final String str, final Context context) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                Toast makeText = Toast.makeText(context, str, 0);
                makeText.setMargin(0.0f, 0.1f);
                makeText.show();
            }
        });
    }

    public static void showToast(String str, MaxAd maxAd, Context context) {
        Toast.makeText(context, maxAd.getFormat().getDisplayName() + ": " + str, 1).show();
    }

    public static Map<String, String> stringifyObjectMap(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                hashMap.put(next.getKey(), String.valueOf(next.getValue()));
            }
        }
        return hashMap;
    }

    public static Map<String, String> toUrlSafeMap(Map<String, String> map) {
        HashMap hashMap = new HashMap(map);
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (str2 != null) {
                hashMap.put(str, StringUtils.encodeUrlString(str2));
            }
        }
        return hashMap;
    }

    public static int toVersionCode(String str) {
        int i = 0;
        for (String str2 : str.replaceAll("-beta", CodelessMatcher.CURRENT_CLASS_NAME).split("\\.")) {
            if (str2.length() > 2) {
                C1314v.m2663i("Utils", "Version number components cannot be longer than two digits -> " + str);
                return i;
            }
            i = (i * 100) + Integer.parseInt(str2);
        }
        return !str.contains("-beta") ? (i * 100) + 99 : i;
    }

    public static double tryParseDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable th) {
            C1314v.m2659c("Utils", "Failed to parse double from String: " + str, th);
            return d;
        }
    }

    public static int tryToGetExoPlayerVersionCode() {
        try {
            Field field = getField(Class.forName("com.google.android.exoplayer2.ExoPlayerLibraryInfo"), "VERSION_INT");
            field.setAccessible(true);
            return ((Integer) field.get((Object) null)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String urlStringWithoutQueryParameters(String str) {
        Uri parse = Uri.parse(str);
        return new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).build().toString();
    }

    public static void validateAdSdkKey(AppLovinAd appLovinAd, C1188m mVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            String z = mVar.mo11010z();
            String z2 = ((AppLovinAdBase) appLovinAd).getSdk().mo11010z();
            if (!z.equals(z2)) {
                C1314v.m2663i("AppLovinAd", "Ad was loaded from sdk with key: " + z2 + ", but is being rendered from sdk with key: " + z);
                mVar.mo10939T().mo10757a(C1103f.f1934l);
            }
        }
    }
}
