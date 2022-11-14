package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.helpshift.util.ErrorReportProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: InstrumentUtility.kt */
public final class InstrumentUtility {
    public static final String ANALYSIS_REPORT_PREFIX = "analysis_log_";
    public static final String ANR_REPORT_PREFIX = "anr_log_";
    public static final String CODELESS_PREFIX = "com.facebook.appevents.codeless";
    public static final String CRASH_REPORT_PREFIX = "crash_log_";
    public static final String CRASH_SHIELD_PREFIX = "shield_log_";
    public static final String ERROR_REPORT_PREFIX = "error_log_";
    public static final String FBSDK_PREFIX = "com.facebook";
    public static final InstrumentUtility INSTANCE = new InstrumentUtility();
    public static final String INSTRUMENT_DIR = "instrument";
    public static final String SUGGESTED_EVENTS_PREFIX = "com.facebook.appevents.suggestedevents";
    public static final String THREAD_CHECK_PREFIX = "thread_check_log_";

    public static final boolean deleteFile(String str) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null) {
            return false;
        }
        return new File(instrumentReportDir, str).delete();
    }

    public static final String getCause(Throwable th) {
        if (th == null) {
            return null;
        }
        if (th.getCause() == null) {
            return th.toString();
        }
        return String.valueOf(th.getCause());
    }

    public static final File getInstrumentReportDir() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        File file = new File(FacebookSdk.getApplicationContext().getCacheDir(), INSTRUMENT_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static final String getStackTrace(Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (th != null && th != th2) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
            int i = 0;
            int length = stackTrace.length;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                i++;
                jSONArray.put(stackTraceElement.toString());
            }
            th2 = th;
            th = th.getCause();
        }
        return jSONArray.toString();
    }

    public static final boolean isSDKRelatedException(Throwable th) {
        if (th == null) {
            return false;
        }
        Throwable th2 = null;
        while (th != null && th != th2) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                i++;
                String className = stackTraceElement.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "element.className");
                if (CharsKt__CharKt.startsWith$default(className, FBSDK_PREFIX, false, 2)) {
                    return true;
                }
            }
            th2 = th;
            th = th.getCause();
        }
        return false;
    }

    public static final boolean isSDKRelatedThread(Thread thread) {
        StackTraceElement[] stackTrace;
        if (!(thread == null || (stackTrace = thread.getStackTrace()) == null)) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "element.className");
                if (CharsKt__CharKt.startsWith$default(className, FBSDK_PREFIX, false, 2)) {
                    String className2 = stackTraceElement.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className2, "element.className");
                    if (!CharsKt__CharKt.startsWith$default(className2, CODELESS_PREFIX, false, 2)) {
                        String className3 = stackTraceElement.getClassName();
                        Intrinsics.checkNotNullExpressionValue(className3, "element.className");
                        if (!CharsKt__CharKt.startsWith$default(className3, SUGGESTED_EVENTS_PREFIX, false, 2)) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    Intrinsics.checkNotNullExpressionValue(methodName, "element.methodName");
                    if (!CharsKt__CharKt.startsWith$default(methodName, "onClick", false, 2)) {
                        String methodName2 = stackTraceElement.getMethodName();
                        Intrinsics.checkNotNullExpressionValue(methodName2, "element.methodName");
                        if (!CharsKt__CharKt.startsWith$default(methodName2, "onItemClick", false, 2)) {
                            String methodName3 = stackTraceElement.getMethodName();
                            Intrinsics.checkNotNullExpressionValue(methodName3, "element.methodName");
                            if (!CharsKt__CharKt.startsWith$default(methodName3, "onTouch", false, 2)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public static final File[] listAnrReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles($$Lambda$maoa5aNYyaW_6qjduRfqgGYx_ro.INSTANCE);
        return listFiles == null ? new File[0] : listFiles;
    }

    /* renamed from: listAnrReportFiles$lambda-1  reason: not valid java name */
    public static final boolean m3639listAnrReportFiles$lambda1(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        return new Regex(GeneratedOutlineSupport.outline21(new Object[]{ANR_REPORT_PREFIX}, 1, "^%s[0-9]+.json$", "java.lang.String.format(format, *args)")).matches(str);
    }

    public static final File[] listExceptionAnalysisReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles($$Lambda$KKWKk7SozTv_PhaG8Q_Y9XtIc94.INSTANCE);
        return listFiles == null ? new File[0] : listFiles;
    }

    /* renamed from: listExceptionAnalysisReportFiles$lambda-2  reason: not valid java name */
    public static final boolean m3640listExceptionAnalysisReportFiles$lambda2(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        return new Regex(GeneratedOutlineSupport.outline21(new Object[]{ANALYSIS_REPORT_PREFIX}, 1, "^%s[0-9]+.json$", "java.lang.String.format(format, *args)")).matches(str);
    }

    public static final File[] listExceptionReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles($$Lambda$aOD1jvtU6JCTaH0LS4rXzlhizxo.INSTANCE);
        return listFiles == null ? new File[0] : listFiles;
    }

    /* renamed from: listExceptionReportFiles$lambda-3  reason: not valid java name */
    public static final boolean m3641listExceptionReportFiles$lambda3(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        return new Regex(GeneratedOutlineSupport.outline21(new Object[]{CRASH_REPORT_PREFIX, CRASH_SHIELD_PREFIX, THREAD_CHECK_PREFIX}, 3, "^(%s|%s|%s)[0-9]+.json$", "java.lang.String.format(format, *args)")).matches(str);
    }

    public static final JSONObject readFile(String str, boolean z) {
        File instrumentReportDir = getInstrumentReportDir();
        if (!(instrumentReportDir == null || str == null)) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(instrumentReportDir, str));
                Utility utility = Utility.INSTANCE;
                return new JSONObject(Utility.readStreamToString(fileInputStream));
            } catch (Exception unused) {
                if (z) {
                    deleteFile(str);
                }
            }
        }
        return null;
    }

    public static final void sendReports(String str, JSONArray jSONArray, GraphRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(jSONArray, "reports");
        if (jSONArray.length() != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str, jSONArray.toString());
                Utility utility = Utility.INSTANCE;
                JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
                if (dataProcessingOptions != null) {
                    Iterator<String> keys = dataProcessingOptions.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, dataProcessingOptions.get(next));
                    }
                }
                GraphRequest.Companion companion = GraphRequest.Companion;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                companion.newPostRequest((AccessToken) null, format, jSONObject, callback).executeAsync();
            } catch (JSONException unused) {
            }
        }
    }

    public static final void writeFile(String str, String str2) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && str != null && str2 != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
                byte[] bytes = str2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static final String getStackTrace(Thread thread) {
        Intrinsics.checkNotNullParameter(thread, ErrorReportProvider.KEY_THREAD_INFO);
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            i++;
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }
}
