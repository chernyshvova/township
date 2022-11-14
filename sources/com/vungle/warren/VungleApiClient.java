package com.vungle.warren;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.GraphRequest;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.swrve.sdk.ISwrveCommon;
import com.swrve.sdk.SwrveAppStore;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.log.LogEntry;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.CacheBust;
import com.vungle.warren.model.CacheBustDBAdapter;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.model.VisionDataDBAdapter;
import com.vungle.warren.network.APIFactory;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.VungleApi;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.GraphicDesigner;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.TimeoutProvider;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealInterceptorChain;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.RealBufferedSink;

public class VungleApiClient {
    public static final String AMAZON_ADVERTISING_ID = "amazon_advertising_id";
    public static final String ANDROID_ID = "android_id";
    public static String BASE_URL = "https://ads.api.vungle.com/";
    public static final String GAID = "gaid";

    /* renamed from: ID */
    public static final String f2847ID = "id";
    public static final String IFA = "ifa";
    public static final String MANUFACTURER_AMAZON = "Amazon";
    public static final String TAG = "com.vungle.warren.VungleApiClient";
    public static WrapperFramework WRAPPER_FRAMEWORK_SELECTED;
    public static String headerUa = GeneratedOutlineSupport.outline18(new StringBuilder(), MANUFACTURER_AMAZON.equals(Build.MANUFACTURER) ? "VungleAmazon/" : "VungleDroid/", BuildConfig.VERSION_NAME);
    public static Set<Interceptor> logInterceptors = new HashSet();
    public static Set<Interceptor> networkInterceptors = new HashSet();
    public VungleApi api;
    public JsonObject appBody;
    public String appSetId;
    public String bustAnalyticsEndpoint;
    public String cacheBustEndpoint;
    public CacheManager cacheManager;
    public OkHttpClient client;
    public Context context;
    public AtomicReference<Boolean> coppaStatus;
    public boolean defaultIdFallbackDisabled;
    public JsonObject deviceBody;
    public AtomicReference<Boolean> disableAdIdIfCoppa;
    public boolean enableOm;
    public VungleApi gzipApi;
    public Boolean isGooglePlayServicesAvailable;
    public String logEndpoint;
    public String newEndpoint;
    public final OMInjector omInjector;
    public String reportAdEndpoint;
    public Repository repository;
    public String requestAdEndpoint;
    public Map<String, Long> retryAfterDataMap = new ConcurrentHashMap();
    public String riEndpoint;
    public VungleApi timeoutApi;
    public TimeoutProvider timeoutProvider;
    public String uaString = System.getProperty("http.agent");
    public JsonObject userBody;
    public boolean willPlayAdEnabled;
    public String willPlayAdEndpoint;
    public int willPlayAdTimeout;

    public static class ClearTextTrafficException extends IOException {
        public ClearTextTrafficException(String str) {
            super(str);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionTypeDetail {
        public static final String CDMA_1XRTT = "cdma_1xrtt";
        public static final String CDMA_EVDO_0 = "cdma_evdo_0";
        public static final String CDMA_EVDO_A = "cdma_evdo_a";
        public static final String CDMA_EVDO_B = "cdma_evdo_b";
        public static final String EDGE = "edge";
        public static final String GPRS = "gprs";
        public static final String HRPD = "hrpd";
        public static final String HSDPA = "hsdpa";
        public static final String HSUPA = "hsupa";
        public static final String LTE = "LTE";
        public static final String UNKNOWN = "unknown";
        public static final String WCDMA = "wcdma";
    }

    public static class GzipRequestInterceptor implements Interceptor {
        public static final String CONTENT_ENCODING = "Content-Encoding";
        public static final String GZIP = "gzip";

        private RequestBody gzip(final RequestBody requestBody) throws IOException {
            final Buffer buffer = new Buffer();
            RealBufferedSink realBufferedSink = new RealBufferedSink(new GzipSink(buffer));
            requestBody.writeTo(realBufferedSink);
            realBufferedSink.close();
            return new RequestBody() {
                public long contentLength() {
                    return buffer.size;
                }

                public MediaType contentType() {
                    return requestBody.contentType();
                }

                public void writeTo(@NonNull BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(buffer.snapshot());
                }
            };
        }

        @NonNull
        public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
            Request request = ((RealInterceptorChain) chain).request;
            if (request.body == null || request.headers.get("Content-Encoding") != null) {
                RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
                return realInterceptorChain.proceed(request, realInterceptorChain.streamAllocation, realInterceptorChain.httpCodec, realInterceptorChain.connection);
            }
            Request.Builder builder = new Request.Builder(request);
            builder.header("Content-Encoding", "gzip");
            builder.method(request.method, gzip(request.body));
            RealInterceptorChain realInterceptorChain2 = (RealInterceptorChain) chain;
            return realInterceptorChain2.proceed(builder.build(), realInterceptorChain2.streamAllocation, realInterceptorChain2.httpCodec, realInterceptorChain2.connection);
        }
    }

    @Keep
    public enum WrapperFramework {
        admob,
        air,
        cocos2dx,
        corona,
        dfp,
        heyzap,
        marmalade,
        mopub,
        unity,
        fyber,
        ironsource,
        upsight,
        appodeal,
        aerserv,
        adtoapp,
        tapdaq,
        vunglehbs,
        max,
        none
    }

    public VungleApiClient(@NonNull Context context2, @NonNull CacheManager cacheManager2, @NonNull Repository repository2, @NonNull OMInjector oMInjector) {
        this.cacheManager = cacheManager2;
        this.context = context2.getApplicationContext();
        this.repository = repository2;
        this.omInjector = oMInjector;
        C19481 r3 = new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = ((RealInterceptorChain) chain).request;
                String encodedPath = request.url.encodedPath();
                Long l = (Long) VungleApiClient.this.retryAfterDataMap.get(encodedPath);
                if (l != null) {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(l.longValue() - System.currentTimeMillis());
                    if (seconds > 0) {
                        Response.Builder builder = new Response.Builder();
                        builder.request = request;
                        builder.addHeader("Retry-After", String.valueOf(seconds));
                        builder.code = 500;
                        builder.protocol = Protocol.HTTP_1_1;
                        builder.message = "Server is busy";
                        builder.body = ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"Error\":\"Retry-After\"}");
                        return builder.build();
                    }
                    VungleApiClient.this.retryAfterDataMap.remove(encodedPath);
                }
                RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
                Response proceed = realInterceptorChain.proceed(request, realInterceptorChain.streamAllocation, realInterceptorChain.httpCodec, realInterceptorChain.connection);
                int i = proceed.code;
                if (i == 429 || i == 500 || i == 502 || i == 503) {
                    String str = proceed.headers.get("Retry-After");
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            long parseLong = Long.parseLong(str);
                            if (parseLong > 0) {
                                VungleApiClient.this.retryAfterDataMap.put(encodedPath, Long.valueOf((parseLong * 1000) + System.currentTimeMillis()));
                            }
                        } catch (NumberFormatException unused) {
                            Log.d(VungleApiClient.TAG, "Retry-After value is not an valid value");
                        }
                    }
                }
                return proceed;
            }
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors.add(r3);
        this.client = new OkHttpClient(builder);
        builder.interceptors.add(new GzipRequestInterceptor());
        OkHttpClient okHttpClient = new OkHttpClient(builder);
        this.api = new APIFactory(this.client, BASE_URL).createAPI();
        this.gzipApi = new APIFactory(okHttpClient, BASE_URL).createAPI();
        this.timeoutProvider = (TimeoutProvider) ServiceLocator.getInstance(context2).getService(TimeoutProvider.class);
    }

    /* access modifiers changed from: private */
    public void addUserAgentInCookie(String str) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie(Cookie.USER_AGENT_ID_COOKIE);
        cookie.putValue(Cookie.USER_AGENT_ID_COOKIE, str);
        this.repository.save(cookie);
    }

    private String getAppSetId() {
        if (TextUtils.isEmpty(this.appSetId)) {
            Cookie cookie = this.repository.load(Cookie.APP_SET_ID_COOKIE, Cookie.class).get(this.timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
            this.appSetId = cookie != null ? cookie.getString(Cookie.APP_SET_ID) : null;
        }
        return this.appSetId;
    }

    private String getConnectionTypeDetail(int i) {
        switch (i) {
            case 1:
                return ConnectionTypeDetail.GPRS;
            case 2:
                return ConnectionTypeDetail.EDGE;
            case 4:
                return ConnectionTypeDetail.WCDMA;
            case 5:
                return ConnectionTypeDetail.CDMA_EVDO_0;
            case 6:
                return ConnectionTypeDetail.CDMA_EVDO_A;
            case 7:
                return ConnectionTypeDetail.CDMA_1XRTT;
            case 8:
                return ConnectionTypeDetail.HSDPA;
            case 9:
                return ConnectionTypeDetail.HSUPA;
            case 12:
                return ConnectionTypeDetail.CDMA_EVDO_B;
            case 13:
                return ConnectionTypeDetail.LTE;
            case 14:
                return ConnectionTypeDetail.HRPD;
            default:
                return "unknown";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0348 A[Catch:{ SettingNotFoundException -> 0x0372 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0362 A[Catch:{ SettingNotFoundException -> 0x0372 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01b6  */
    @android.annotation.SuppressLint({"HardwareIds", "NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.gson.JsonObject getDeviceBody() throws java.lang.IllegalStateException {
        /*
            r15 = this;
            java.lang.String r0 = "Amazon"
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
            r1.<init>()
            r2 = 0
            r3 = 0
            r4 = 1
            java.lang.String r5 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0077 }
            boolean r5 = r0.equals(r5)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r6 = "advertising_id"
            if (r5 == 0) goto L_0x003a
            android.content.Context r5 = r15.context     // Catch:{ SettingNotFoundException -> 0x002c }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x002c }
            java.lang.String r7 = "limit_ad_tracking"
            int r7 = android.provider.Settings.Secure.getInt(r5, r7)     // Catch:{ SettingNotFoundException -> 0x002c }
            if (r7 != r4) goto L_0x0024
            r7 = 1
            goto L_0x0025
        L_0x0024:
            r7 = 0
        L_0x0025:
            java.lang.String r5 = android.provider.Settings.Secure.getString(r5, r6)     // Catch:{ SettingNotFoundException -> 0x002a }
            goto L_0x0083
        L_0x002a:
            r5 = move-exception
            goto L_0x002e
        L_0x002c:
            r5 = move-exception
            r7 = 1
        L_0x002e:
            java.lang.String r6 = TAG     // Catch:{ Exception -> 0x0037 }
            java.lang.String r8 = "Error getting Amazon advertising info"
            android.util.Log.w(r6, r8, r5)     // Catch:{ Exception -> 0x0037 }
            r5 = r2
            goto L_0x0083
        L_0x0037:
            r5 = r7
            r7 = r2
            goto L_0x0079
        L_0x003a:
            android.content.Context r5 = r15.context     // Catch:{ NoClassDefFoundError -> 0x0050 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r5 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r5)     // Catch:{ NoClassDefFoundError -> 0x0050 }
            if (r5 == 0) goto L_0x004d
            java.lang.String r7 = r5.getId()     // Catch:{ NoClassDefFoundError -> 0x0050 }
            boolean r5 = r5.isLimitAdTrackingEnabled()     // Catch:{ NoClassDefFoundError -> 0x004b }
            goto L_0x0080
        L_0x004b:
            r5 = move-exception
            goto L_0x0052
        L_0x004d:
            r5 = r2
        L_0x004e:
            r7 = 1
            goto L_0x0083
        L_0x0050:
            r5 = move-exception
            r7 = r2
        L_0x0052:
            java.lang.String r8 = TAG     // Catch:{ Exception -> 0x0078 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0078 }
            r9.<init>()     // Catch:{ Exception -> 0x0078 }
            java.lang.String r10 = "Play services Not available: "
            r9.append(r10)     // Catch:{ Exception -> 0x0078 }
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ Exception -> 0x0078 }
            r9.append(r5)     // Catch:{ Exception -> 0x0078 }
            java.lang.String r5 = r9.toString()     // Catch:{ Exception -> 0x0078 }
            android.util.Log.e(r8, r5)     // Catch:{ Exception -> 0x0078 }
            android.content.Context r5 = r15.context     // Catch:{ Exception -> 0x0078 }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ Exception -> 0x0078 }
            java.lang.String r5 = android.provider.Settings.Secure.getString(r5, r6)     // Catch:{ Exception -> 0x0078 }
            goto L_0x004e
        L_0x0077:
            r7 = r2
        L_0x0078:
            r5 = 1
        L_0x0079:
            java.lang.String r6 = TAG
            java.lang.String r8 = "Cannot load Advertising ID"
            android.util.Log.e(r6, r8)
        L_0x0080:
            r14 = r7
            r7 = r5
            r5 = r14
        L_0x0083:
            boolean r6 = r15.noAdvertisingIdsIfCoppa()
            java.lang.String r8 = "amazon_advertising_id"
            java.lang.String r9 = "gaid"
            java.lang.String r10 = ""
            java.lang.String r11 = "android_id"
            java.lang.String r12 = "ifa"
            if (r6 != 0) goto L_0x00d2
            if (r5 == 0) goto L_0x00a9
            java.lang.String r6 = android.os.Build.MANUFACTURER
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L_0x009f
            r6 = r8
            goto L_0x00a0
        L_0x009f:
            r6 = r9
        L_0x00a0:
            r1.addProperty((java.lang.String) r6, (java.lang.String) r5)
            com.google.gson.JsonObject r6 = r15.deviceBody
            r6.addProperty((java.lang.String) r12, (java.lang.String) r5)
            goto L_0x00d2
        L_0x00a9:
            android.content.Context r5 = r15.context
            android.content.ContentResolver r5 = r5.getContentResolver()
            java.lang.String r5 = android.provider.Settings.Secure.getString(r5, r11)
            com.google.gson.JsonObject r6 = r15.deviceBody
            boolean r13 = r15.defaultIdFallbackDisabled
            if (r13 == 0) goto L_0x00bb
        L_0x00b9:
            r13 = r10
            goto L_0x00c2
        L_0x00bb:
            boolean r13 = android.text.TextUtils.isEmpty(r5)
            if (r13 != 0) goto L_0x00b9
            r13 = r5
        L_0x00c2:
            r6.addProperty((java.lang.String) r12, (java.lang.String) r13)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x00d2
            boolean r6 = r15.defaultIdFallbackDisabled
            if (r6 != 0) goto L_0x00d2
            r1.addProperty((java.lang.String) r11, (java.lang.String) r5)
        L_0x00d2:
            boolean r5 = r15.noAdvertisingIdsIfCoppa()
            if (r5 == 0) goto L_0x00fa
            com.google.gson.JsonObject r5 = r15.deviceBody
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r5 = r5.members
            java.lang.Object r5 = r5.remove(r12)
            com.google.gson.JsonElement r5 = (com.google.gson.JsonElement) r5
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r5 = r1.members
            java.lang.Object r5 = r5.remove(r11)
            com.google.gson.JsonElement r5 = (com.google.gson.JsonElement) r5
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r5 = r1.members
            java.lang.Object r5 = r5.remove(r9)
            com.google.gson.JsonElement r5 = (com.google.gson.JsonElement) r5
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r5 = r1.members
            java.lang.Object r5 = r5.remove(r8)
            com.google.gson.JsonElement r5 = (com.google.gson.JsonElement) r5
        L_0x00fa:
            com.google.gson.JsonObject r5 = r15.deviceBody
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            java.lang.String r7 = "lmt"
            r5.addProperty((java.lang.String) r7, (java.lang.Number) r6)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.lang.Boolean r6 = r15.isGooglePlayServicesAvailable()
            boolean r5 = r5.equals(r6)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.String r6 = "is_google_play_services_available"
            r1.addProperty((java.lang.String) r6, (java.lang.Boolean) r5)
            java.lang.String r5 = r15.getAppSetId()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0129
            java.lang.String r5 = r15.appSetId
            java.lang.String r6 = "app_set_id"
            r1.addProperty((java.lang.String) r6, (java.lang.String) r5)
        L_0x0129:
            android.content.Context r5 = r15.context
            if (r5 == 0) goto L_0x0138
            android.content.IntentFilter r6 = new android.content.IntentFilter
            java.lang.String r7 = "android.intent.action.BATTERY_CHANGED"
            r6.<init>(r7)
            android.content.Intent r2 = r5.registerReceiver(r2, r6)
        L_0x0138:
            r5 = 4
            r6 = 2
            java.lang.String r7 = "UNKNOWN"
            if (r2 == 0) goto L_0x0185
            java.lang.String r8 = "level"
            r9 = -1
            int r8 = r2.getIntExtra(r8, r9)
            java.lang.String r11 = "scale"
            int r11 = r2.getIntExtra(r11, r9)
            if (r8 <= 0) goto L_0x015b
            if (r11 <= 0) goto L_0x015b
            float r8 = (float) r8
            float r11 = (float) r11
            float r8 = r8 / r11
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            java.lang.String r11 = "battery_level"
            r1.addProperty((java.lang.String) r11, (java.lang.Number) r8)
        L_0x015b:
            java.lang.String r8 = "status"
            int r8 = r2.getIntExtra(r8, r9)
            if (r8 != r9) goto L_0x0164
            goto L_0x0185
        L_0x0164:
            if (r8 == r6) goto L_0x016d
            r11 = 5
            if (r8 != r11) goto L_0x016a
            goto L_0x016d
        L_0x016a:
            java.lang.String r2 = "NOT_CHARGING"
            goto L_0x0186
        L_0x016d:
            java.lang.String r8 = "plugged"
            int r2 = r2.getIntExtra(r8, r9)
            if (r2 == r4) goto L_0x0182
            if (r2 == r6) goto L_0x017f
            if (r2 == r5) goto L_0x017c
            java.lang.String r2 = "BATTERY_PLUGGED_OTHERS"
            goto L_0x0186
        L_0x017c:
            java.lang.String r2 = "BATTERY_PLUGGED_WIRELESS"
            goto L_0x0186
        L_0x017f:
            java.lang.String r2 = "BATTERY_PLUGGED_USB"
            goto L_0x0186
        L_0x0182:
            java.lang.String r2 = "BATTERY_PLUGGED_AC"
            goto L_0x0186
        L_0x0185:
            r2 = r7
        L_0x0186:
            java.lang.String r8 = "battery_state"
            r1.addProperty((java.lang.String) r8, (java.lang.String) r2)
            android.content.Context r2 = r15.context
            java.lang.String r8 = "power"
            java.lang.Object r2 = r2.getSystemService(r8)
            android.os.PowerManager r2 = (android.os.PowerManager) r2
            if (r2 == 0) goto L_0x019f
            boolean r2 = r2.isPowerSaveMode()
            if (r2 == 0) goto L_0x019f
            r2 = 1
            goto L_0x01a0
        L_0x019f:
            r2 = 0
        L_0x01a0:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r8 = "battery_saver_enabled"
            r1.addProperty((java.lang.String) r8, (java.lang.Number) r2)
            android.content.Context r2 = r15.context
            java.lang.String r8 = "android.permission.ACCESS_NETWORK_STATE"
            int r2 = androidx.core.content.PermissionChecker.checkCallingOrSelfPermission(r2, r8)
            r8 = 24
            r9 = 3
            if (r2 != 0) goto L_0x0236
            android.content.Context r2 = r15.context
            java.lang.String r11 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r11)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            java.lang.String r11 = "unknown"
            if (r2 == 0) goto L_0x01f2
            android.net.NetworkInfo r12 = r2.getActiveNetworkInfo()
            if (r12 == 0) goto L_0x01f2
            int r13 = r12.getType()
            if (r13 == 0) goto L_0x01e7
            if (r13 == r4) goto L_0x01e4
            r12 = 6
            if (r13 == r12) goto L_0x01e4
            r12 = 7
            if (r13 == r12) goto L_0x01e1
            r12 = 9
            if (r13 == r12) goto L_0x01de
            r12 = r7
            goto L_0x01f4
        L_0x01de:
            java.lang.String r12 = "ETHERNET"
            goto L_0x01f4
        L_0x01e1:
            java.lang.String r12 = "BLUETOOTH"
            goto L_0x01f4
        L_0x01e4:
            java.lang.String r12 = "WIFI"
            goto L_0x01f4
        L_0x01e7:
            int r11 = r12.getSubtype()
            java.lang.String r11 = r15.getConnectionTypeDetail(r11)
            java.lang.String r12 = "MOBILE"
            goto L_0x01f4
        L_0x01f2:
            java.lang.String r12 = "NONE"
        L_0x01f4:
            java.lang.String r13 = "connection_type"
            r1.addProperty((java.lang.String) r13, (java.lang.String) r12)
            java.lang.String r12 = "connection_type_detail"
            r1.addProperty((java.lang.String) r12, (java.lang.String) r11)
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 < r8) goto L_0x0236
            boolean r11 = r2.isActiveNetworkMetered()
            java.lang.String r12 = "network_metered"
            java.lang.String r13 = "data_saver_status"
            if (r11 == 0) goto L_0x022a
            int r2 = r2.getRestrictBackgroundStatus()
            if (r2 == r4) goto L_0x021d
            if (r2 == r6) goto L_0x021a
            if (r2 == r9) goto L_0x0217
            goto L_0x021f
        L_0x0217:
            java.lang.String r7 = "ENABLED"
            goto L_0x021f
        L_0x021a:
            java.lang.String r7 = "WHITELISTED"
            goto L_0x021f
        L_0x021d:
            java.lang.String r7 = "DISABLED"
        L_0x021f:
            r1.addProperty((java.lang.String) r13, (java.lang.String) r7)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r1.addProperty((java.lang.String) r12, (java.lang.Number) r2)
            goto L_0x0236
        L_0x022a:
            java.lang.String r2 = "NOT_APPLICABLE"
            r1.addProperty((java.lang.String) r13, (java.lang.String) r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r1.addProperty((java.lang.String) r12, (java.lang.Number) r2)
        L_0x0236:
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r2 = r2.toString()
            java.lang.String r6 = "locale"
            r1.addProperty((java.lang.String) r6, (java.lang.String) r2)
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r2 = r2.getLanguage()
            java.lang.String r6 = "language"
            r1.addProperty((java.lang.String) r6, (java.lang.String) r2)
            java.util.TimeZone r2 = java.util.TimeZone.getDefault()
            java.lang.String r2 = r2.getID()
            java.lang.String r6 = "time_zone"
            r1.addProperty((java.lang.String) r6, (java.lang.String) r2)
            android.content.Context r2 = r15.context
            java.lang.String r6 = "audio"
            java.lang.Object r2 = r2.getSystemService(r6)
            android.media.AudioManager r2 = (android.media.AudioManager) r2
            if (r2 == 0) goto L_0x028c
            int r6 = r2.getStreamMaxVolume(r9)
            int r2 = r2.getStreamVolume(r9)
            float r7 = (float) r2
            float r6 = (float) r6
            float r7 = r7 / r6
            java.lang.Float r6 = java.lang.Float.valueOf(r7)
            java.lang.String r7 = "volume_level"
            r1.addProperty((java.lang.String) r7, (java.lang.Number) r6)
            if (r2 <= 0) goto L_0x0282
            r2 = 1
            goto L_0x0283
        L_0x0282:
            r2 = 0
        L_0x0283:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r6 = "sound_enabled"
            r1.addProperty((java.lang.String) r6, (java.lang.Number) r2)
        L_0x028c:
            com.vungle.warren.persistence.CacheManager r2 = r15.cacheManager
            java.io.File r2 = r2.getCache()
            r2.getPath()
            boolean r6 = r2.exists()
            if (r6 == 0) goto L_0x02b0
            boolean r2 = r2.isDirectory()
            if (r2 == 0) goto L_0x02b0
            com.vungle.warren.persistence.CacheManager r2 = r15.cacheManager
            long r6 = r2.getBytesAvailable()
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            java.lang.String r6 = "storage_bytes_available"
            r1.addProperty((java.lang.String) r6, (java.lang.Number) r2)
        L_0x02b0:
            java.lang.String r2 = android.os.Build.MANUFACTURER
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x02c9
            android.content.Context r2 = r15.context
            android.content.Context r2 = r2.getApplicationContext()
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            java.lang.String r5 = "amazon.hardware.fire_tv"
            boolean r2 = r2.hasSystemFeature(r5)
            goto L_0x0308
        L_0x02c9:
            int r2 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r2 < r6) goto L_0x02e3
            android.content.Context r2 = r15.context
            java.lang.String r6 = "uimode"
            java.lang.Object r2 = r2.getSystemService(r6)
            android.app.UiModeManager r2 = (android.app.UiModeManager) r2
            int r2 = r2.getCurrentModeType()
            if (r2 != r5) goto L_0x02e1
        L_0x02df:
            r2 = 1
            goto L_0x0308
        L_0x02e1:
            r2 = 0
            goto L_0x0308
        L_0x02e3:
            android.content.Context r2 = r15.context
            android.content.Context r2 = r2.getApplicationContext()
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            java.lang.String r5 = "com.google.android.tv"
            boolean r2 = r2.hasSystemFeature(r5)
            if (r2 != 0) goto L_0x02df
            android.content.Context r2 = r15.context
            android.content.Context r2 = r2.getApplicationContext()
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            java.lang.String r5 = "android.hardware.touchscreen"
            boolean r2 = r2.hasSystemFeature(r5)
            if (r2 != 0) goto L_0x02e1
            goto L_0x02df
        L_0x0308:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r5 = "is_tv"
            r1.addProperty((java.lang.String) r5, (java.lang.Boolean) r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r5 = "os_api_level"
            r1.addProperty((java.lang.String) r5, (java.lang.Number) r2)
            android.content.Context r2 = r15.context
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()
            int r2 = r2.targetSdkVersion
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r5 = "app_target_sdk_version"
            r1.addProperty((java.lang.String) r5, (java.lang.Number) r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r8) goto L_0x0342
            android.content.Context r2 = r15.context
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()
            int r2 = r2.minSdkVersion
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r5 = "app_min_sdk_version"
            r1.addProperty((java.lang.String) r5, (java.lang.Number) r2)
        L_0x0342:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ SettingNotFoundException -> 0x0372 }
            r5 = 26
            if (r2 < r5) goto L_0x0362
            android.content.Context r2 = r15.context     // Catch:{ SettingNotFoundException -> 0x0372 }
            java.lang.String r4 = "android.permission.REQUEST_INSTALL_PACKAGES"
            int r2 = r2.checkCallingOrSelfPermission(r4)     // Catch:{ SettingNotFoundException -> 0x0372 }
            if (r2 != 0) goto L_0x037a
            android.content.Context r2 = r15.context     // Catch:{ SettingNotFoundException -> 0x0372 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ SettingNotFoundException -> 0x0372 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ SettingNotFoundException -> 0x0372 }
            boolean r2 = r2.canRequestPackageInstalls()     // Catch:{ SettingNotFoundException -> 0x0372 }
            r3 = r2
            goto L_0x037a
        L_0x0362:
            android.content.Context r2 = r15.context     // Catch:{ SettingNotFoundException -> 0x0372 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0372 }
            java.lang.String r5 = "install_non_market_apps"
            int r2 = android.provider.Settings.Secure.getInt(r2, r5)     // Catch:{ SettingNotFoundException -> 0x0372 }
            if (r2 != r4) goto L_0x037a
            r3 = 1
            goto L_0x037a
        L_0x0372:
            r2 = move-exception
            java.lang.String r4 = TAG
            java.lang.String r5 = "isInstallNonMarketAppsEnabled Settings not found"
            android.util.Log.e(r4, r5, r2)
        L_0x037a:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            java.lang.String r3 = "is_sideload_enabled"
            r1.addProperty((java.lang.String) r3, (java.lang.Boolean) r2)
            java.lang.String r2 = android.os.Environment.getExternalStorageState()
            java.lang.String r3 = "mounted"
            boolean r2 = r2.equals(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "sd_card_available"
            r1.addProperty((java.lang.String) r3, (java.lang.Number) r2)
            java.lang.String r2 = android.os.Build.FINGERPRINT
            java.lang.String r3 = "os_name"
            r1.addProperty((java.lang.String) r3, (java.lang.String) r2)
            java.lang.String r2 = "vduid"
            r1.addProperty((java.lang.String) r2, (java.lang.String) r10)
            com.google.gson.JsonObject r2 = r15.deviceBody
            java.lang.String r3 = "ext"
            com.google.gson.JsonObject r2 = r2.getAsJsonObject(r3)
            java.lang.String r3 = "vungle"
            com.google.gson.JsonObject r2 = r2.getAsJsonObject(r3)
            java.lang.String r3 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x03bc
            java.lang.String r0 = "amazon"
            goto L_0x03be
        L_0x03bc:
            java.lang.String r0 = "android"
        L_0x03be:
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r2 = r2.members
            r2.put(r0, r1)
            com.google.gson.JsonObject r0 = r15.deviceBody
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.VungleApiClient.getDeviceBody():com.google.gson.JsonObject");
    }

    public static String getHeaderUa() {
        return headerUa;
    }

    private String getUserAgentFromCookie() {
        Cookie cookie = this.repository.load(Cookie.USER_AGENT_ID_COOKIE, Cookie.class).get();
        if (cookie == null) {
            return System.getProperty("http.agent");
        }
        String string = cookie.getString(Cookie.USER_AGENT_ID_COOKIE);
        return TextUtils.isEmpty(string) ? System.getProperty("http.agent") : string;
    }

    private JsonObject getUserBody() {
        long j;
        String str;
        String str2;
        String str3;
        Class<Cookie> cls = Cookie.class;
        JsonObject jsonObject = new JsonObject();
        Cookie cookie = this.repository.load(Cookie.CONSENT_COOKIE, cls).get(this.timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
        String str4 = "";
        if (cookie != null) {
            str2 = cookie.getString("consent_status");
            str = cookie.getString("consent_source");
            j = cookie.getLong("timestamp").longValue();
            str3 = cookie.getString("consent_message_version");
        } else {
            j = 0;
            str2 = "unknown";
            str = "no_interaction";
            str3 = str4;
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("consent_status", str2);
        jsonObject2.addProperty("consent_source", str);
        jsonObject2.addProperty("consent_timestamp", (Number) Long.valueOf(j));
        if (!TextUtils.isEmpty(str3)) {
            str4 = str3;
        }
        jsonObject2.addProperty("consent_message_version", str4);
        jsonObject.members.put("gdpr", jsonObject2);
        Cookie cookie2 = this.repository.load(Cookie.CCPA_COOKIE, cls).get();
        String string = cookie2 != null ? cookie2.getString(Cookie.CCPA_CONSENT_STATUS) : Cookie.CONSENT_STATUS_OPTED_IN;
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("status", string);
        jsonObject.members.put("ccpa", jsonObject3);
        AtomicReference<Boolean> atomicReference = this.coppaStatus;
        if (!(atomicReference == null || atomicReference.get() == null)) {
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty(Cookie.COPPA_STATUS_KEY, Boolean.valueOf(this.coppaStatus.get().booleanValue()));
            jsonObject.members.put(Cookie.COPPA_KEY, jsonObject4);
        }
        return jsonObject;
    }

    @SuppressLint({"NewApi"})
    private void initUserAgentLazy() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    String unused = VungleApiClient.this.uaString = WebSettings.getDefaultUserAgent(VungleApiClient.this.context);
                    VungleApiClient.this.deviceBody.addProperty("ua", VungleApiClient.this.uaString);
                    VungleApiClient.this.addUserAgentInCookie(VungleApiClient.this.uaString);
                } catch (Exception e) {
                    String access$100 = VungleApiClient.TAG;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Cannot Get UserAgent. Setting Default Device UserAgent.");
                    outline24.append(e.getLocalizedMessage());
                    Log.e(access$100, outline24.toString());
                }
            }
        }, "vng_iual").start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.disableAdIdIfCoppa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean noAdvertisingIdsIfCoppa() {
        /*
            r1 = this;
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r1.coppaStatus
            if (r0 == 0) goto L_0x0032
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x0032
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r1.disableAdIdIfCoppa
            if (r0 == 0) goto L_0x0032
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x0032
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r1.coppaStatus
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0032
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r1.disableAdIdIfCoppa
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.VungleApiClient.noAdvertisingIdsIfCoppa():boolean");
    }

    public static void setHeaderUa(String str) {
        headerUa = str;
    }

    private void updateAppSetID() {
        try {
            AppSet.getClient(this.context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() {
                public void onSuccess(AppSetIdInfo appSetIdInfo) {
                    if (appSetIdInfo != null) {
                        String unused = VungleApiClient.this.appSetId = appSetIdInfo.getId();
                        Cookie cookie = new Cookie(Cookie.APP_SET_ID_COOKIE);
                        cookie.putValue(Cookie.APP_SET_ID, VungleApiClient.this.appSetId);
                        try {
                            VungleApiClient.this.repository.save(cookie);
                        } catch (DatabaseHelper.DBException e) {
                            String access$100 = VungleApiClient.TAG;
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("error saving AppSetId in Cookie: ");
                            outline24.append(e.getLocalizedMessage());
                            Log.e(access$100, outline24.toString());
                        }
                    }
                }
            });
        } catch (NoClassDefFoundError e) {
            String str = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Required libs to get AppSetID Not available: ");
            outline24.append(e.getLocalizedMessage());
            Log.e(str, outline24.toString());
        }
    }

    @VisibleForTesting
    public void addPlaySvcAvailabilityInCookie(boolean z) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie(Cookie.IS_PLAY_SERVICE_AVAILABLE);
        cookie.putValue(Cookie.IS_PLAY_SERVICE_AVAILABLE, Boolean.valueOf(z));
        this.repository.save(cookie);
    }

    public Call<JsonObject> bustAnalytics(Collection<CacheBust> collection) {
        if (this.bustAnalyticsEndpoint != null) {
            JsonObject jsonObject = new JsonObject();
            Object deviceBody2 = getDeviceBody();
            LinkedTreeMap<String, JsonElement> linkedTreeMap = jsonObject.members;
            if (deviceBody2 == null) {
                deviceBody2 = JsonNull.INSTANCE;
            }
            linkedTreeMap.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, deviceBody2);
            Object obj = this.appBody;
            LinkedTreeMap<String, JsonElement> linkedTreeMap2 = jsonObject.members;
            if (obj == null) {
                obj = JsonNull.INSTANCE;
            }
            linkedTreeMap2.put("app", obj);
            JsonObject jsonObject2 = new JsonObject();
            JsonArray jsonArray = new JsonArray(collection.size());
            for (CacheBust next : collection) {
                for (String addProperty : next.getEventIds()) {
                    JsonObject jsonObject3 = new JsonObject();
                    jsonObject3.addProperty(AnimatedVectorDrawableCompat.TARGET, next.getIdType() == 1 ? "campaign" : VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE);
                    jsonObject3.addProperty("id", next.getId());
                    jsonObject3.addProperty(LogEntry.LOG_ITEM_EVENT_ID, addProperty);
                    jsonArray.elements.add(jsonObject3);
                }
            }
            jsonObject2.members.put(CacheBustDBAdapter.CacheBustColumns.TABLE_NAME, jsonArray);
            jsonObject2.members.put("sessionReport", new JsonObject());
            jsonObject.members.put("request", jsonObject2);
            return this.gzipApi.bustAnalytics(getHeaderUa(), this.bustAnalyticsEndpoint, jsonObject);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> cacheBust(long j) {
        if (this.cacheBustEndpoint != null) {
            JsonObject jsonObject = new JsonObject();
            Object deviceBody2 = getDeviceBody();
            LinkedTreeMap<String, JsonElement> linkedTreeMap = jsonObject.members;
            if (deviceBody2 == null) {
                deviceBody2 = JsonNull.INSTANCE;
            }
            linkedTreeMap.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, deviceBody2);
            Object obj = this.appBody;
            LinkedTreeMap<String, JsonElement> linkedTreeMap2 = jsonObject.members;
            if (obj == null) {
                obj = JsonNull.INSTANCE;
            }
            linkedTreeMap2.put("app", obj);
            Object userBody2 = getUserBody();
            LinkedTreeMap<String, JsonElement> linkedTreeMap3 = jsonObject.members;
            if (userBody2 == null) {
                userBody2 = JsonNull.INSTANCE;
            }
            linkedTreeMap3.put(ISwrveCommon.BATCH_EVENT_KEY_USER, userBody2);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(Cookie.LAST_CACHE_BUST, (Number) Long.valueOf(j));
            jsonObject.members.put("request", jsonObject2);
            return this.gzipApi.cacheBust(getHeaderUa(), this.cacheBustEndpoint, jsonObject);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public boolean canCallWillPlayAd() {
        return this.willPlayAdEnabled && !TextUtils.isEmpty(this.willPlayAdEndpoint);
    }

    public com.vungle.warren.network.Response config() throws VungleException, IOException {
        JsonObject jsonObject = new JsonObject();
        Object deviceBody2 = getDeviceBody();
        LinkedTreeMap<String, JsonElement> linkedTreeMap = jsonObject.members;
        if (deviceBody2 == null) {
            deviceBody2 = JsonNull.INSTANCE;
        }
        linkedTreeMap.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, deviceBody2);
        Object obj = this.appBody;
        LinkedTreeMap<String, JsonElement> linkedTreeMap2 = jsonObject.members;
        if (obj == null) {
            obj = JsonNull.INSTANCE;
        }
        linkedTreeMap2.put("app", obj);
        Object userBody2 = getUserBody();
        LinkedTreeMap<String, JsonElement> linkedTreeMap3 = jsonObject.members;
        if (userBody2 == null) {
            userBody2 = JsonNull.INSTANCE;
        }
        linkedTreeMap3.put(ISwrveCommon.BATCH_EVENT_KEY_USER, userBody2);
        com.vungle.warren.network.Response<JsonObject> execute = this.api.config(getHeaderUa(), jsonObject).execute();
        if (!execute.isSuccessful()) {
            return execute;
        }
        JsonObject body = execute.body();
        String str = TAG;
        Log.d(str, "Config Response: " + body);
        if (JsonUtil.hasNonNull(body, "sleep")) {
            String asString = JsonUtil.hasNonNull(body, GraphRequest.DEBUG_SEVERITY_INFO) ? body.get(GraphRequest.DEBUG_SEVERITY_INFO).getAsString() : "";
            String str2 = TAG;
            Log.e(str2, "Error Initializing Vungle. Please try again. " + asString);
            throw new VungleException(3);
        } else if (JsonUtil.hasNonNull(body, "endpoints")) {
            JsonObject asJsonObject = body.getAsJsonObject("endpoints");
            HttpUrl parse = HttpUrl.parse(asJsonObject.get("new").getAsString());
            HttpUrl parse2 = HttpUrl.parse(asJsonObject.get("ads").getAsString());
            HttpUrl parse3 = HttpUrl.parse(asJsonObject.get("will_play_ad").getAsString());
            HttpUrl parse4 = HttpUrl.parse(asJsonObject.get("report_ad").getAsString());
            HttpUrl parse5 = HttpUrl.parse(asJsonObject.get("ri").getAsString());
            HttpUrl parse6 = HttpUrl.parse(asJsonObject.get("log").getAsString());
            HttpUrl parse7 = HttpUrl.parse(asJsonObject.get(CacheBustDBAdapter.CacheBustColumns.TABLE_NAME).getAsString());
            HttpUrl parse8 = HttpUrl.parse(asJsonObject.get("sdk_bi").getAsString());
            if (parse == null || parse2 == null || parse3 == null || parse4 == null || parse5 == null || parse6 == null || parse7 == null) {
                Log.e(TAG, "Error Initializing Vungle. Please try again. ");
                throw new VungleException(3);
            }
            this.newEndpoint = parse.url;
            this.requestAdEndpoint = parse2.url;
            this.willPlayAdEndpoint = parse3.url;
            this.reportAdEndpoint = parse4.url;
            this.riEndpoint = parse5.url;
            this.logEndpoint = parse6.url;
            this.cacheBustEndpoint = parse7.url;
            this.bustAnalyticsEndpoint = parse8.url;
            JsonObject asJsonObject2 = body.getAsJsonObject("will_play_ad");
            this.willPlayAdTimeout = asJsonObject2.get("request_timeout").getAsInt();
            this.willPlayAdEnabled = asJsonObject2.get(CleverCacheSettings.KEY_ENABLED).getAsBoolean();
            this.enableOm = JsonUtil.getAsBoolean(body.getAsJsonObject("viewability"), "om", false);
            if (this.willPlayAdEnabled) {
                Log.v(TAG, "willPlayAd is enabled, generating a timeout client.");
                OkHttpClient okHttpClient = this.client;
                if (okHttpClient != null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder(okHttpClient);
                    builder.readTimeout((long) this.willPlayAdTimeout, TimeUnit.MILLISECONDS);
                    this.timeoutApi = new APIFactory(new OkHttpClient(builder), "https://api.vungle.com/").createAPI();
                } else {
                    throw null;
                }
            }
            if (getOmEnabled()) {
                this.omInjector.init();
            }
            return execute;
        } else {
            Log.e(TAG, "Error Initializing Vungle. Please try again. ");
            throw new VungleException(3);
        }
    }

    public boolean getOmEnabled() {
        return this.enableOm;
    }

    @VisibleForTesting
    public Boolean getPlayServicesAvailabilityFromAPI() {
        try {
            GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
            if (instance == null) {
                return null;
            }
            Boolean valueOf = Boolean.valueOf(instance.isGooglePlayServicesAvailable(this.context) == 0);
            addPlaySvcAvailabilityInCookie(valueOf.booleanValue());
            return valueOf;
        } catch (NoClassDefFoundError unused) {
            Log.w(TAG, "Play services Not available");
            Boolean bool = Boolean.FALSE;
            try {
                addPlaySvcAvailabilityInCookie(false);
                return bool;
            } catch (DatabaseHelper.DBException unused2) {
                Log.w(TAG, "Failure to write GPS availability to DB");
                return bool;
            }
        } catch (Exception unused3) {
            Log.w(TAG, "Unexpected exception from Play services lib.");
            return null;
        }
    }

    @VisibleForTesting
    public Boolean getPlayServicesAvailabilityFromCookie() {
        Cookie cookie = this.repository.load(Cookie.IS_PLAY_SERVICE_AVAILABLE, Cookie.class).get(this.timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
        if (cookie != null) {
            return cookie.getBoolean(Cookie.IS_PLAY_SERVICE_AVAILABLE);
        }
        return null;
    }

    public long getRetryAfterHeaderValue(com.vungle.warren.network.Response response) {
        try {
            return Long.parseLong(response.headers().get("Retry-After")) * 1000;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void init() {
        init(this.context);
    }

    @VisibleForTesting
    public Boolean isGooglePlayServicesAvailable() {
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromCookie();
        }
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        }
        return this.isGooglePlayServicesAvailable;
    }

    @VisibleForTesting
    public void overrideApi(VungleApi vungleApi) {
        this.api = vungleApi;
    }

    public boolean pingTPAT(String str) throws ClearTextTrafficException, MalformedURLException {
        boolean z;
        if (TextUtils.isEmpty(str) || HttpUrl.parse(str) == null) {
            throw new MalformedURLException(GeneratedOutlineSupport.outline16("Invalid URL : ", str));
        }
        try {
            String host = new URL(str).getHost();
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                z = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(host);
            } else {
                z = i >= 23 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : true;
            }
            if (z || !URLUtil.isHttpUrl(str)) {
                try {
                    this.api.pingTPAT(this.uaString, str).execute();
                    return true;
                } catch (IOException unused) {
                    Log.d(TAG, "Error on pinging TPAT");
                    return false;
                }
            } else {
                throw new ClearTextTrafficException("Clear Text Traffic is blocked");
            }
        } catch (MalformedURLException unused2) {
            throw new MalformedURLException(GeneratedOutlineSupport.outline16("Invalid URL : ", str));
        }
    }

    public Call<JsonObject> reportAd(JsonObject jsonObject) {
        if (this.reportAdEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            Object deviceBody2 = getDeviceBody();
            LinkedTreeMap<String, JsonElement> linkedTreeMap = jsonObject2.members;
            if (deviceBody2 == null) {
                deviceBody2 = JsonNull.INSTANCE;
            }
            linkedTreeMap.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, deviceBody2);
            Object obj = this.appBody;
            LinkedTreeMap<String, JsonElement> linkedTreeMap2 = jsonObject2.members;
            if (obj == null) {
                obj = JsonNull.INSTANCE;
            }
            linkedTreeMap2.put("app", obj);
            LinkedTreeMap<String, JsonElement> linkedTreeMap3 = jsonObject2.members;
            JsonElement jsonElement = jsonObject;
            if (jsonObject == null) {
                jsonElement = JsonNull.INSTANCE;
            }
            linkedTreeMap3.put("request", jsonElement);
            Object userBody2 = getUserBody();
            LinkedTreeMap<String, JsonElement> linkedTreeMap4 = jsonObject2.members;
            if (userBody2 == null) {
                userBody2 = JsonNull.INSTANCE;
            }
            linkedTreeMap4.put(ISwrveCommon.BATCH_EVENT_KEY_USER, userBody2);
            return this.gzipApi.reportAd(getHeaderUa(), this.reportAdEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> reportNew() throws IllegalStateException {
        if (this.newEndpoint != null) {
            HashMap hashMap = new HashMap(2);
            JsonElement jsonElement = this.appBody.get("id");
            String str = "";
            hashMap.put("app_id", jsonElement != null ? jsonElement.getAsString() : str);
            if (!noAdvertisingIdsIfCoppa()) {
                JsonElement jsonElement2 = this.deviceBody.get(IFA);
                if (jsonElement2 != null) {
                    str = jsonElement2.getAsString();
                }
                hashMap.put(IFA, str);
            }
            return this.api.reportNew(getHeaderUa(), this.newEndpoint, hashMap);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> requestAd(String str, String str2, boolean z, @Nullable JsonObject jsonObject) throws IllegalStateException {
        if (this.requestAdEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            Object deviceBody2 = getDeviceBody();
            LinkedTreeMap<String, JsonElement> linkedTreeMap = jsonObject2.members;
            if (deviceBody2 == null) {
                deviceBody2 = JsonNull.INSTANCE;
            }
            linkedTreeMap.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, deviceBody2);
            Object obj = this.appBody;
            LinkedTreeMap<String, JsonElement> linkedTreeMap2 = jsonObject2.members;
            if (obj == null) {
                obj = JsonNull.INSTANCE;
            }
            linkedTreeMap2.put("app", obj);
            JsonObject userBody2 = getUserBody();
            if (jsonObject != null) {
                userBody2.members.put(VisionController.VISION, jsonObject);
            }
            LinkedTreeMap<String, JsonElement> linkedTreeMap3 = jsonObject2.members;
            JsonElement jsonElement = userBody2;
            if (userBody2 == null) {
                jsonElement = JsonNull.INSTANCE;
            }
            linkedTreeMap3.put(ISwrveCommon.BATCH_EVENT_KEY_USER, jsonElement);
            JsonObject jsonObject3 = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(str);
            jsonObject3.members.put("placements", jsonArray);
            jsonObject3.addProperty("header_bidding", Boolean.valueOf(z));
            if (!TextUtils.isEmpty(str2)) {
                jsonObject3.addProperty("ad_size", str2);
            }
            jsonObject2.members.put("request", jsonObject3);
            return this.gzipApi.ads(getHeaderUa(), this.requestAdEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    /* renamed from: ri */
    public Call<JsonObject> mo21815ri(JsonObject jsonObject) {
        if (this.riEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            Object deviceBody2 = getDeviceBody();
            LinkedTreeMap<String, JsonElement> linkedTreeMap = jsonObject2.members;
            if (deviceBody2 == null) {
                deviceBody2 = JsonNull.INSTANCE;
            }
            linkedTreeMap.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, deviceBody2);
            Object obj = this.appBody;
            LinkedTreeMap<String, JsonElement> linkedTreeMap2 = jsonObject2.members;
            if (obj == null) {
                obj = JsonNull.INSTANCE;
            }
            linkedTreeMap2.put("app", obj);
            LinkedTreeMap<String, JsonElement> linkedTreeMap3 = jsonObject2.members;
            JsonElement jsonElement = jsonObject;
            if (jsonObject == null) {
                jsonElement = JsonNull.INSTANCE;
            }
            linkedTreeMap3.put("request", jsonElement);
            Object userBody2 = getUserBody();
            LinkedTreeMap<String, JsonElement> linkedTreeMap4 = jsonObject2.members;
            if (userBody2 == null) {
                userBody2 = JsonNull.INSTANCE;
            }
            linkedTreeMap4.put(ISwrveCommon.BATCH_EVENT_KEY_USER, userBody2);
            return this.api.mo22127ri(getHeaderUa(), this.riEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> sendLog(JsonObject jsonObject) {
        if (this.logEndpoint != null) {
            return this.gzipApi.sendLog(getHeaderUa(), this.logEndpoint, jsonObject);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public void setAppId(String str) {
        setAppId(str, this.appBody);
    }

    public void setCoppaFlags(AtomicReference<Boolean> atomicReference, AtomicReference<Boolean> atomicReference2) {
        this.coppaStatus = atomicReference;
        this.disableAdIdIfCoppa = atomicReference2;
    }

    public void setDefaultIdFallbackDisabled(boolean z) {
        this.defaultIdFallbackDisabled = z;
    }

    public Call<JsonObject> willPlayAd(String str, boolean z, String str2) {
        JsonObject jsonObject = new JsonObject();
        Object deviceBody2 = getDeviceBody();
        LinkedTreeMap<String, JsonElement> linkedTreeMap = jsonObject.members;
        if (deviceBody2 == null) {
            deviceBody2 = JsonNull.INSTANCE;
        }
        linkedTreeMap.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, deviceBody2);
        Object obj = this.appBody;
        LinkedTreeMap<String, JsonElement> linkedTreeMap2 = jsonObject.members;
        if (obj == null) {
            obj = JsonNull.INSTANCE;
        }
        linkedTreeMap2.put("app", obj);
        Object userBody2 = getUserBody();
        LinkedTreeMap<String, JsonElement> linkedTreeMap3 = jsonObject.members;
        if (userBody2 == null) {
            userBody2 = JsonNull.INSTANCE;
        }
        linkedTreeMap3.put(ISwrveCommon.BATCH_EVENT_KEY_USER, userBody2);
        JsonObject jsonObject2 = new JsonObject();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("reference_id", str);
        jsonObject3.addProperty("is_auto_cached", Boolean.valueOf(z));
        jsonObject2.members.put("placement", jsonObject3);
        jsonObject2.addProperty(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_TOKEN, str2);
        jsonObject.members.put("request", jsonObject2);
        return this.timeoutApi.willPlayAd(getHeaderUa(), this.willPlayAdEndpoint, jsonObject);
    }

    private void setAppId(String str, JsonObject jsonObject) {
        jsonObject.addProperty("id", str);
    }

    @VisibleForTesting
    public synchronized void init(Context context2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("bundle", context2.getPackageName());
        String str = null;
        try {
            str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (str == null) {
            str = "1.0";
        }
        jsonObject.addProperty("ver", str);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("make", Build.MANUFACTURER);
        jsonObject2.addProperty(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        jsonObject2.addProperty("osv", Build.VERSION.RELEASE);
        jsonObject2.addProperty("carrier", ((TelephonyManager) context2.getSystemService("phone")).getNetworkOperatorName());
        jsonObject2.addProperty("os", MANUFACTURER_AMAZON.equals(Build.MANUFACTURER) ? SwrveAppStore.Amazon : "android");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context2.getSystemService(VisionController.WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
        jsonObject2.addProperty("w", (Number) Integer.valueOf(displayMetrics.widthPixels));
        jsonObject2.addProperty("h", (Number) Integer.valueOf(displayMetrics.heightPixels));
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.members.put(GraphicDesigner.FOLDER_NAME, new JsonObject());
        jsonObject2.members.put("ext", jsonObject3);
        try {
            this.uaString = getUserAgentFromCookie();
            initUserAgentLazy();
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
        }
        jsonObject2.addProperty("ua", this.uaString);
        this.deviceBody = jsonObject2;
        this.appBody = jsonObject;
        this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        updateAppSetID();
    }
}
