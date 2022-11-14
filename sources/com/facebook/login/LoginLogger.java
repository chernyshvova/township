package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import com.vungle.warren.log.LogEntry;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginLogger.kt */
public final class LoginLogger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
    public static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    public static final String EVENT_EXTRAS_FAILURE = "failure";
    public static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
    public static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
    public static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
    public static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
    public static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
    public static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
    public static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    public static final String EVENT_EXTRAS_TARGET_APP = "target_app";
    public static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
    public static final String EVENT_NAME_FOA_LOGIN_COMPLETE = "foa_mobile_login_complete";
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE = "foa_mobile_login_method_complete";
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED = "foa_mobile_login_method_not_tried";
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_START = "foa_mobile_login_method_start";
    public static final String EVENT_NAME_FOA_LOGIN_START = "foa_mobile_login_start";
    public static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
    public static final String EVENT_NAME_LOGIN_HEARTBEAT = "fb_mobile_login_heartbeat";
    public static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
    public static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
    public static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
    public static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
    public static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";
    public static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";
    public static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    public static final String EVENT_PARAM_CHALLENGE = "7_challenge";
    public static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
    public static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
    public static final String EVENT_PARAM_EXTRAS = "6_extras";
    public static final String EVENT_PARAM_FOA_METHOD_RESULT_SKIPPED = "foa_skipped";
    public static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
    public static final String EVENT_PARAM_METHOD = "3_method";
    public static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
    public static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    public static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    public static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    public final String applicationId;
    public String facebookVersion;
    public final InternalAppEventsLogger logger;

    /* compiled from: LoginLogger.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Bundle newAuthorizationLoggingBundle(String str) {
            Bundle bundle = new Bundle();
            bundle.putLong(LoginLogger.EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
            bundle.putString(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, str);
            bundle.putString(LoginLogger.EVENT_PARAM_METHOD, "");
            bundle.putString(LoginLogger.EVENT_PARAM_LOGIN_RESULT, "");
            bundle.putString(LoginLogger.EVENT_PARAM_ERROR_MESSAGE, "");
            bundle.putString(LoginLogger.EVENT_PARAM_ERROR_CODE, "");
            bundle.putString(LoginLogger.EVENT_PARAM_EXTRAS, "");
            return bundle;
        }
    }

    public LoginLogger(Context context, String str) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(str, "applicationId");
        this.applicationId = str;
        this.logger = new InternalAppEventsLogger(context, this.applicationId);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) != null) {
                this.facebookVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static /* synthetic */ void logAuthorizationMethodComplete$default(LoginLogger loginLogger, String str, String str2, String str3, String str4, String str5, Map map, String str6, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                loginLogger.logAuthorizationMethodComplete(str, str2, str3, str4, str5, map, (i & 64) != 0 ? EVENT_NAME_LOGIN_METHOD_COMPLETE : str6);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static /* synthetic */ void logAuthorizationMethodNotTried$default(LoginLogger loginLogger, String str, String str2, String str3, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 4) != 0) {
                str3 = EVENT_NAME_LOGIN_METHOD_NOT_TRIED;
            }
            try {
                loginLogger.logAuthorizationMethodNotTried(str, str2, str3);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static /* synthetic */ void logAuthorizationMethodStart$default(LoginLogger loginLogger, String str, String str2, String str3, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 4) != 0) {
                str3 = EVENT_NAME_LOGIN_METHOD_START;
            }
            try {
                loginLogger.logAuthorizationMethodStart(str, str2, str3);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static /* synthetic */ void logCompleteLogin$default(LoginLogger loginLogger, String str, Map map, LoginClient.Result.Code code, Map map2, Exception exc, String str2, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 32) != 0) {
                str2 = EVENT_NAME_LOGIN_COMPLETE;
            }
            try {
                loginLogger.logCompleteLogin(str, map, code, map2, exc, str2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void logHeartbeatEvent(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                worker.schedule(new Runnable(Companion.newAuthorizationLoggingBundle(str)) {
                    public final /* synthetic */ Bundle f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        LoginLogger.m3661logHeartbeatEvent$lambda0(LoginLogger.this, this.f$1);
                    }
                }, 5, TimeUnit.SECONDS);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* renamed from: logHeartbeatEvent$lambda-0  reason: not valid java name */
    public static final void m3661logHeartbeatEvent$lambda0(LoginLogger loginLogger, Bundle bundle) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(loginLogger, "this$0");
                Intrinsics.checkNotNullParameter(bundle, "$bundle");
                loginLogger.logger.logEventImplicitly(EVENT_NAME_LOGIN_HEARTBEAT, bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static /* synthetic */ void logStartLogin$default(LoginLogger loginLogger, LoginClient.Request request, String str, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 2) != 0) {
                str = EVENT_NAME_LOGIN_START;
            }
            try {
                loginLogger.logStartLogin(request, str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static /* synthetic */ void logUnexpectedError$default(LoginLogger loginLogger, String str, String str2, String str3, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            try {
                loginLogger.logUnexpectedError(str, str2, str3);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final String getApplicationId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.applicationId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logAuthorizationMethodComplete$default(this, str, str2, str3, str4, str5, map, (String) null, 64, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                if (str3 != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, str3);
                }
                if (str4 != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str4);
                }
                if (str5 != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_CODE, str5);
                }
                if (map != null && (!map.isEmpty())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry next : map.entrySet()) {
                        if (((String) next.getKey()) != null) {
                            linkedHashMap.put(next.getKey(), next.getValue());
                        }
                    }
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, new JSONObject(linkedHashMap).toString());
                }
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
                this.logger.logEventImplicitly(str6, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logAuthorizationMethodNotTried(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logAuthorizationMethodNotTried$default(this, str, str2, (String) null, 4, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logAuthorizationMethodNotTried(String str, String str2, String str3) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
                this.logger.logEventImplicitly(str3, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logAuthorizationMethodStart(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logAuthorizationMethodStart$default(this, str, str2, (String) null, 4, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logAuthorizationMethodStart(String str, String str2, String str3) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
                this.logger.logEventImplicitly(str3, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logCompleteLogin(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(map, "loggingExtras");
                logCompleteLogin$default(this, str, map, code, map2, exc, (String) null, 32, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logCompleteLogin(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc, String str2) {
        String str3;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(map, "loggingExtras");
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                if (code != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, code.getLoggingValue());
                }
                JSONObject jSONObject = null;
                if (exc == null) {
                    str3 = null;
                } else {
                    str3 = exc.getMessage();
                }
                if (str3 != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.getMessage());
                }
                if (!map.isEmpty()) {
                    jSONObject = new JSONObject(map);
                }
                if (map2 != null) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    try {
                        for (Map.Entry next : map2.entrySet()) {
                            String str4 = (String) next.getKey();
                            String str5 = (String) next.getValue();
                            if (str4 != null) {
                                jSONObject.put(str4, str5);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
                if (jSONObject != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
                }
                this.logger.logEventImplicitly(str2, access$newAuthorizationLoggingBundle);
                if (code == LoginClient.Result.Code.SUCCESS) {
                    logHeartbeatEvent(str);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusError(String str, Exception exc) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(exc, "exception");
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.toString());
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusFailure(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, EVENT_EXTRAS_FAILURE);
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusStart(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_START, Companion.newAuthorizationLoggingBundle(str));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusSuccess(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.SUCCESS.getLoggingValue());
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logStartLogin(LoginClient.Request request) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(request, "pendingLoginRequest");
                logStartLogin$default(this, request, (String) null, 2, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:4|5|6|7|(1:9)|10|(1:12)|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x007f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void logStartLogin(com.facebook.login.LoginClient.Request r6, java.lang.String r7) {
        /*
            r5 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = "pendingLoginRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)     // Catch:{ all -> 0x0085 }
            com.facebook.login.LoginLogger$Companion r0 = Companion     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = r6.getAuthId()     // Catch:{ all -> 0x0085 }
            android.os.Bundle r0 = r0.newAuthorizationLoggingBundle(r1)     // Catch:{ all -> 0x0085 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007f }
            r1.<init>()     // Catch:{ JSONException -> 0x007f }
            java.lang.String r2 = "login_behavior"
            com.facebook.login.LoginBehavior r3 = r6.getLoginBehavior()     // Catch:{ JSONException -> 0x007f }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x007f }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x007f }
            java.lang.String r2 = "request_code"
            com.facebook.login.LoginClient$Companion r3 = com.facebook.login.LoginClient.Companion     // Catch:{ JSONException -> 0x007f }
            int r3 = r3.getLoginRequestCode()     // Catch:{ JSONException -> 0x007f }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x007f }
            java.lang.String r2 = "permissions"
            java.lang.String r3 = ","
            java.util.Set r4 = r6.getPermissions()     // Catch:{ JSONException -> 0x007f }
            java.lang.String r3 = android.text.TextUtils.join(r3, r4)     // Catch:{ JSONException -> 0x007f }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x007f }
            java.lang.String r2 = "default_audience"
            com.facebook.login.DefaultAudience r3 = r6.getDefaultAudience()     // Catch:{ JSONException -> 0x007f }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x007f }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x007f }
            java.lang.String r2 = "isReauthorize"
            boolean r3 = r6.isRerequest()     // Catch:{ JSONException -> 0x007f }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x007f }
            java.lang.String r2 = r5.facebookVersion     // Catch:{ JSONException -> 0x007f }
            if (r2 == 0) goto L_0x0063
            java.lang.String r2 = "facebookVersion"
            java.lang.String r3 = r5.facebookVersion     // Catch:{ JSONException -> 0x007f }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x007f }
        L_0x0063:
            com.facebook.login.LoginTargetApp r2 = r6.getLoginTargetApp()     // Catch:{ JSONException -> 0x007f }
            if (r2 == 0) goto L_0x0076
            java.lang.String r2 = "target_app"
            com.facebook.login.LoginTargetApp r6 = r6.getLoginTargetApp()     // Catch:{ JSONException -> 0x007f }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x007f }
            r1.put(r2, r6)     // Catch:{ JSONException -> 0x007f }
        L_0x0076:
            java.lang.String r6 = "6_extras"
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x007f }
            r0.putString(r6, r1)     // Catch:{ JSONException -> 0x007f }
        L_0x007f:
            com.facebook.appevents.InternalAppEventsLogger r6 = r5.logger     // Catch:{ all -> 0x0085 }
            r6.logEventImplicitly(r7, r0)     // Catch:{ all -> 0x0085 }
            return
        L_0x0085:
            r6 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginLogger.logStartLogin(com.facebook.login.LoginClient$Request, java.lang.String):void");
    }

    public final void logUnexpectedError(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logUnexpectedError$default(this, str, str2, (String) null, 4, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logUnexpectedError(String str, String str2, String str3) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle("");
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str2);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str3);
                this.logger.logEventImplicitly(str, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
