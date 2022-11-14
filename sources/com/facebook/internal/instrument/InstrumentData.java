package com.facebook.internal.instrument;

import android.os.Build;
import androidx.annotation.RestrictTo;
import com.facebook.internal.Utility;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: InstrumentData.kt */
public final class InstrumentData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAM_APP_VERSION = "app_version";
    public static final String PARAM_CALLSTACK = "callstack";
    public static final String PARAM_DEVICE_MODEL = "device_model";
    public static final String PARAM_DEVICE_OS = "device_os_version";
    public static final String PARAM_FEATURE_NAMES = "feature_names";
    public static final String PARAM_REASON = "reason";
    public static final String PARAM_TIMESTAMP = "timestamp";
    public static final String PARAM_TYPE = "type";
    public static final String UNKNOWN = "Unknown";
    public String appVersion;
    public String cause;
    public JSONArray featureNames;
    public String filename;
    public String stackTrace;
    public Long timestamp;
    public Type type;

    /* compiled from: InstrumentData.kt */
    public static final class Builder {
        public static final Builder INSTANCE = new Builder();

        public static final InstrumentData build(Throwable th, Type type) {
            Intrinsics.checkNotNullParameter(type, "t");
            return new InstrumentData(th, type, (DefaultConstructorMarker) null);
        }

        public static final InstrumentData load(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new InstrumentData(file, (DefaultConstructorMarker) null);
        }

        public static final InstrumentData build(JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(jSONArray, "features");
            return new InstrumentData(jSONArray, (DefaultConstructorMarker) null);
        }

        public static final InstrumentData build(String str, String str2) {
            return new InstrumentData(str, str2, (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: InstrumentData.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Type getType(String str) {
            if (CharsKt__CharKt.startsWith$default(str, InstrumentUtility.CRASH_REPORT_PREFIX, false, 2)) {
                return Type.CrashReport;
            }
            if (CharsKt__CharKt.startsWith$default(str, InstrumentUtility.CRASH_SHIELD_PREFIX, false, 2)) {
                return Type.CrashShield;
            }
            if (CharsKt__CharKt.startsWith$default(str, InstrumentUtility.THREAD_CHECK_PREFIX, false, 2)) {
                return Type.ThreadCheck;
            }
            if (CharsKt__CharKt.startsWith$default(str, InstrumentUtility.ANALYSIS_REPORT_PREFIX, false, 2)) {
                return Type.Analysis;
            }
            if (CharsKt__CharKt.startsWith$default(str, InstrumentUtility.ANR_REPORT_PREFIX, false, 2)) {
                return Type.AnrReport;
            }
            return Type.Unknown;
        }
    }

    /* compiled from: InstrumentData.kt */
    public enum Type {
        Unknown,
        Analysis,
        AnrReport,
        CrashReport,
        CrashShield,
        ThreadCheck;

        /* compiled from: InstrumentData.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Type.values().length];
                Type type = Type.Analysis;
                iArr[1] = 1;
                Type type2 = Type.AnrReport;
                iArr[2] = 2;
                Type type3 = Type.CrashReport;
                iArr[3] = 3;
                Type type4 = Type.CrashShield;
                iArr[4] = 4;
                Type type5 = Type.ThreadCheck;
                iArr[5] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final String getLogPrefix() {
            int ordinal = ordinal();
            if (ordinal == 1) {
                return InstrumentUtility.ANALYSIS_REPORT_PREFIX;
            }
            if (ordinal == 2) {
                return InstrumentUtility.ANR_REPORT_PREFIX;
            }
            if (ordinal == 3) {
                return InstrumentUtility.CRASH_REPORT_PREFIX;
            }
            if (ordinal != 4) {
                return ordinal != 5 ? "Unknown" : InstrumentUtility.THREAD_CHECK_PREFIX;
            }
            return InstrumentUtility.CRASH_SHIELD_PREFIX;
        }

        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 1) {
                return "Analysis";
            }
            if (ordinal == 2) {
                return "AnrReport";
            }
            if (ordinal == 3) {
                return "CrashReport";
            }
            if (ordinal != 4) {
                return ordinal != 5 ? "Unknown" : "ThreadCheck";
            }
            return "CrashShield";
        }
    }

    /* compiled from: InstrumentData.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            Type type = Type.Analysis;
            iArr[1] = 1;
            Type type2 = Type.AnrReport;
            iArr[2] = 2;
            Type type3 = Type.CrashReport;
            iArr[3] = 3;
            Type type4 = Type.CrashShield;
            iArr[4] = 4;
            Type type5 = Type.ThreadCheck;
            iArr[5] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ InstrumentData(File file, DefaultConstructorMarker defaultConstructorMarker) {
        this(file);
    }

    public /* synthetic */ InstrumentData(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ InstrumentData(Throwable th, Type type2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, type2);
    }

    public InstrumentData(JSONArray jSONArray) {
        this.type = Type.Analysis;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.featureNames = jSONArray;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ANALYSIS_REPORT_PREFIX);
        stringBuffer.append(String.valueOf(this.timestamp));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "StringBuffer()\n            .append(InstrumentUtility.ANALYSIS_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.filename = stringBuffer2;
    }

    public /* synthetic */ InstrumentData(JSONArray jSONArray, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONArray);
    }

    private final JSONObject getAnalysisReportParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.featureNames != null) {
                jSONObject.put(PARAM_FEATURE_NAMES, this.featureNames);
            }
            if (this.timestamp != null) {
                jSONObject.put("timestamp", this.timestamp);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final JSONObject getExceptionReportParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAM_DEVICE_OS, Build.VERSION.RELEASE);
            jSONObject.put(PARAM_DEVICE_MODEL, Build.MODEL);
            if (this.appVersion != null) {
                jSONObject.put("app_version", this.appVersion);
            }
            if (this.timestamp != null) {
                jSONObject.put("timestamp", this.timestamp);
            }
            if (this.cause != null) {
                jSONObject.put("reason", this.cause);
            }
            if (this.stackTrace != null) {
                jSONObject.put(PARAM_CALLSTACK, this.stackTrace);
            }
            if (this.type != null) {
                jSONObject.put("type", this.type);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final JSONObject getParameters() {
        Type type2 = this.type;
        int i = type2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type2.ordinal()];
        if (i == 1) {
            return getAnalysisReportParameters();
        }
        if (i == 2 || i == 3 || i == 4 || i == 5) {
            return getExceptionReportParameters();
        }
        return null;
    }

    public final void clear() {
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        InstrumentUtility.deleteFile(this.filename);
    }

    public final int compareTo(InstrumentData instrumentData) {
        Intrinsics.checkNotNullParameter(instrumentData, "data");
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        long longValue = l.longValue();
        Long l2 = instrumentData.timestamp;
        if (l2 == null) {
            return 1;
        }
        long longValue2 = l2.longValue();
        if (longValue2 < longValue) {
            return -1;
        }
        return longValue2 == longValue ? 0 : 1;
    }

    public final boolean isValid() {
        Type type2 = this.type;
        int i = type2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if ((i != 3 && i != 4 && i != 5) || this.stackTrace == null || this.timestamp == null) {
                    return false;
                }
                return true;
            } else if (this.stackTrace == null || this.cause == null || this.timestamp == null) {
                return false;
            }
        } else if (this.featureNames == null || this.timestamp == null) {
            return false;
        }
        return true;
    }

    public final void save() {
        if (isValid()) {
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            String jSONObject = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
            return jSONObject;
        }
        String jSONObject2 = parameters.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "params.toString()");
        return jSONObject2;
    }

    public InstrumentData(Throwable th, Type type2) {
        this.type = type2;
        Utility utility = Utility.INSTANCE;
        this.appVersion = Utility.getAppVersion();
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        this.cause = InstrumentUtility.getCause(th);
        InstrumentUtility instrumentUtility2 = InstrumentUtility.INSTANCE;
        this.stackTrace = InstrumentUtility.getStackTrace(th);
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(type2.getLogPrefix());
        stringBuffer.append(String.valueOf(this.timestamp));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "StringBuffer().append(t.logPrefix).append(timestamp.toString()).append(\".json\").toString()");
        this.filename = stringBuffer2;
    }

    public InstrumentData(String str, String str2) {
        this.type = Type.AnrReport;
        Utility utility = Utility.INSTANCE;
        this.appVersion = Utility.getAppVersion();
        this.cause = str;
        this.stackTrace = str2;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ANR_REPORT_PREFIX);
        stringBuffer.append(String.valueOf(this.timestamp));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "StringBuffer()\n            .append(InstrumentUtility.ANR_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.filename = stringBuffer2;
    }

    public InstrumentData(File file) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        this.filename = name;
        this.type = Companion.getType(name);
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        JSONObject readFile = InstrumentUtility.readFile(this.filename, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0));
            this.appVersion = readFile.optString("app_version", (String) null);
            this.cause = readFile.optString("reason", (String) null);
            this.stackTrace = readFile.optString(PARAM_CALLSTACK, (String) null);
            this.featureNames = readFile.optJSONArray(PARAM_FEATURE_NAMES);
        }
    }
}
