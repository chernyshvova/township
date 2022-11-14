package com.facebook.internal.instrument.crashshield;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CrashShieldHandler.kt */
public final class CrashShieldHandler {
    public static final CrashShieldHandler INSTANCE = new CrashShieldHandler();
    public static final Set<Object> crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    public static boolean enabled;

    @VisibleForTesting
    public static final void disable() {
        enabled = false;
    }

    public static final void enable() {
        enabled = true;
    }

    public static final void handleThrowable(Throwable th, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "o");
        if (enabled) {
            crashingObjects.add(obj);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer exceptionAnalyzer = ExceptionAnalyzer.INSTANCE;
                ExceptionAnalyzer.execute(th);
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                InstrumentData.Builder.build(th, InstrumentData.Type.CrashShield).save();
            }
            scheduleCrashInDebug(th);
        }
    }

    @VisibleForTesting
    public static final boolean isDebug() {
        return false;
    }

    public static final boolean isObjectCrashing(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "o");
        return crashingObjects.contains(obj);
    }

    public static final void methodFinished(Object obj) {
    }

    public static final void reset() {
        resetCrashingObjects();
    }

    public static final void resetCrashingObjects() {
        crashingObjects.clear();
    }

    @VisibleForTesting
    public static final void scheduleCrashInDebug(Throwable th) {
        if (isDebug()) {
            new Handler(Looper.getMainLooper()).post(new CrashShieldHandler$scheduleCrashInDebug$1(th));
        }
    }
}
