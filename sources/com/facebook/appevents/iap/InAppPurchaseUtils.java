package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.vungle.warren.log.LogEntry;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppPurchaseUtils.kt */
public final class InAppPurchaseUtils {
    public static final InAppPurchaseUtils INSTANCE = new InAppPurchaseUtils();

    public static final Class<?> getClass(String str) {
        Class<InAppPurchaseUtils> cls = InAppPurchaseUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "className");
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final Class<?> getClassFromContext$facebook_core_release(Context context, String str) {
        Class<InAppPurchaseUtils> cls = InAppPurchaseUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(str, "className");
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final Method getDeclaredMethod$facebook_core_release(Class<?> cls, String str, Class<?>... clsArr) {
        Class<InAppPurchaseUtils> cls2 = InAppPurchaseUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            Intrinsics.checkNotNullParameter(str, "methodName");
            Intrinsics.checkNotNullParameter(clsArr, "args");
            try {
                return cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls2);
            return null;
        }
    }

    public static final Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Class<InAppPurchaseUtils> cls2 = InAppPurchaseUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            Intrinsics.checkNotNullParameter(str, "methodName");
            Intrinsics.checkNotNullParameter(clsArr, "args");
            try {
                return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls2);
            return null;
        }
    }

    public static final Object invokeMethod(Class<?> cls, Method method, Object obj, Object... objArr) {
        Class<InAppPurchaseUtils> cls2 = InAppPurchaseUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(objArr, "args");
            if (obj != null) {
                obj = cls.cast(obj);
            }
            try {
                return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls2);
            return null;
        }
    }
}
