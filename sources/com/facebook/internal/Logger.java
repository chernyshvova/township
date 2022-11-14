package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.LegacyTokenHelper;
import com.facebook.LoggingBehavior;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: Logger.kt */
public final class Logger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    public static final HashMap<String, String> stringsToReplace = new HashMap<>();
    public final LoggingBehavior behavior;
    public StringBuilder contents;
    public int priority = 3;
    public final String tag;

    /* compiled from: Logger.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final synchronized String replaceStrings(String str) {
            for (Map.Entry entry : Logger.stringsToReplace.entrySet()) {
                str = CharsKt__CharKt.replace$default(str, (String) entry.getKey(), (String) entry.getValue(), false, 4);
            }
            return str;
        }

        public final void log(LoggingBehavior loggingBehavior, String str, String str2) {
            Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, LegacyTokenHelper.TYPE_STRING);
            log(loggingBehavior, 3, str, str2);
        }

        public final synchronized void registerAccessToken(String str) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(str, "ACCESS_TOKEN_REMOVED");
            }
        }

        public final synchronized void registerStringToReplace(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "original");
            Intrinsics.checkNotNullParameter(str2, "replace");
            Logger.stringsToReplace.put(str, str2);
        }

        public final void log(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
            Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, GraphRequest.FORMAT_PARAM);
            Intrinsics.checkNotNullParameter(objArr, "args");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                log(loggingBehavior, 3, str, format);
            }
        }

        public final void log(LoggingBehavior loggingBehavior, int i, String str, String str2, Object... objArr) {
            Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, GraphRequest.FORMAT_PARAM);
            Intrinsics.checkNotNullParameter(objArr, "args");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                log(loggingBehavior, i, str, format);
            }
        }

        public final void log(LoggingBehavior loggingBehavior, int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, LegacyTokenHelper.TYPE_STRING);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
                String replaceStrings = replaceStrings(str2);
                if (!CharsKt__CharKt.startsWith$default(str, Logger.LOG_TAG_BASE, false, 2)) {
                    str = Intrinsics.stringPlus(Logger.LOG_TAG_BASE, str);
                }
                Log.println(i, str, replaceStrings);
                if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }
    }

    public Logger(LoggingBehavior loggingBehavior, String str) {
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        Intrinsics.checkNotNullParameter(str, "tag");
        this.behavior = loggingBehavior;
        Validate validate = Validate.INSTANCE;
        this.tag = Intrinsics.stringPlus(LOG_TAG_BASE, Validate.notNullOrEmpty(str, "tag"));
        this.contents = new StringBuilder();
    }

    public static final void log(LoggingBehavior loggingBehavior, int i, String str, String str2) {
        Companion.log(loggingBehavior, i, str, str2);
    }

    public static final void log(LoggingBehavior loggingBehavior, int i, String str, String str2, Object... objArr) {
        Companion.log(loggingBehavior, i, str, str2, objArr);
    }

    public static final void log(LoggingBehavior loggingBehavior, String str, String str2) {
        Companion.log(loggingBehavior, str, str2);
    }

    public static final void log(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        Companion.log(loggingBehavior, str, str2, objArr);
    }

    public static final synchronized void registerAccessToken(String str) {
        synchronized (Logger.class) {
            Companion.registerAccessToken(str);
        }
    }

    public static final synchronized void registerStringToReplace(String str, String str2) {
        synchronized (Logger.class) {
            Companion.registerStringToReplace(str, str2);
        }
    }

    private final boolean shouldLog() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
    }

    public final void append(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "stringBuilder");
        if (shouldLog()) {
            this.contents.append(sb);
        }
    }

    public final void appendKeyValue(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        append("  %s:\t%s\n", str, obj);
    }

    public final String getContents() {
        Companion companion = Companion;
        String sb = this.contents.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "contents.toString()");
        return companion.replaceStrings(sb);
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void log() {
        String sb = this.contents.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "contents.toString()");
        logString(sb);
        this.contents = new StringBuilder();
    }

    public final void logString(String str) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenHelper.TYPE_STRING);
        Companion.log(this.behavior, this.priority, this.tag, str);
    }

    public final void setPriority(int i) {
        Validate validate = Validate.INSTANCE;
        Validate.oneOf(Integer.valueOf(i), "value", 7, 3, 6, 4, 2, 5);
        setPriority(i);
    }

    public final void append(String str) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenHelper.TYPE_STRING);
        if (shouldLog()) {
            this.contents.append(str);
        }
    }

    public final void append(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, GraphRequest.FORMAT_PARAM);
        Intrinsics.checkNotNullParameter(objArr, "args");
        if (shouldLog()) {
            StringBuilder sb = this.contents;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            sb.append(format);
        }
    }
}
