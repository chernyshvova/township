package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzfko {
    @CheckForNull
    public static final Object zza;
    @CheckForNull
    public static final Method zzb;
    @CheckForNull
    public static final Method zzc;

    static {
        Method method;
        Object zzc2 = zzc();
        zza = zzc2;
        Method method2 = null;
        if (zzc2 == null) {
            method = null;
        } else {
            method = zze("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        zzb = method;
        Object obj = zza;
        if (obj != null) {
            method2 = zzd(obj);
        }
        zzc = method2;
    }

    public static void zza(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    public static String zzb(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zzgcg.zzc(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @CheckForNull
    public static Object zzc() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    @CheckForNull
    public static Method zzd(Object obj) {
        try {
            Method zze = zze("getStackTraceDepth", Throwable.class);
            if (zze == null) {
                return null;
            }
            zze.invoke(obj, new Object[]{new Throwable()});
            return zze;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @CheckForNull
    public static Method zze(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }
}
