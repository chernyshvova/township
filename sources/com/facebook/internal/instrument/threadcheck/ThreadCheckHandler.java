package com.facebook.internal.instrument.threadcheck;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: ThreadCheckHandler.kt */
public final class ThreadCheckHandler {
    public static final ThreadCheckHandler INSTANCE = new ThreadCheckHandler();
    public static final String TAG = ThreadCheckHandler.class.getCanonicalName();
    public static boolean enabled;

    public static final void enable() {
        enabled = true;
    }

    private final void log(String str, Class<?> cls, String str2, String str3) {
        if (enabled) {
            String format = String.format(Locale.US, "%s annotation violation detected in %s.%s%s. Current looper is %s and main looper is %s.", Arrays.copyOf(new Object[]{str, cls.getName(), str2, str3, Looper.myLooper(), Looper.getMainLooper()}, 6));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            Exception exc = new Exception();
            Log.e(TAG, format, exc);
            InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
            InstrumentData.Builder.build((Throwable) exc, InstrumentData.Type.ThreadCheck).save();
        }
    }

    public static final void uiThreadViolationDetected(Class<?> cls, String str, String str2) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(str2, "methodDesc");
        INSTANCE.log("@UiThread", cls, str, str2);
    }

    public static final void workerThreadViolationDetected(Class<?> cls, String str, String str2) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(str2, "methodDesc");
        INSTANCE.log("@WorkerThread", cls, str, str2);
    }
}
