package com.facebook.ads.internal.util.process;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import java.lang.reflect.Field;

@AnyThread
@Keep
public final class ProcessUtils {
    @Nullable
    public static String sProcessName;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return getProcessNameAPI28();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r3 = r3.getApplicationContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if ((r3 instanceof android.app.Application) == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        r3 = getProcessNameViaReflection((android.app.Application) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        sProcessName = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002d, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getProcessName(android.content.Context r3) {
        /*
            java.lang.Class<com.facebook.ads.internal.util.process.ProcessUtils> r0 = com.facebook.ads.internal.util.process.ProcessUtils.class
            monitor-enter(r0)
            java.lang.String r1 = sProcessName     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x000b
            java.lang.String r3 = sProcessName     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r3
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0017
            java.lang.String r3 = getProcessNameAPI28()
            return r3
        L_0x0017:
            android.content.Context r3 = r3.getApplicationContext()
            boolean r1 = r3 instanceof android.app.Application
            if (r1 == 0) goto L_0x002d
            android.app.Application r3 = (android.app.Application) r3
            java.lang.String r3 = getProcessNameViaReflection(r3)
            monitor-enter(r0)
            sProcessName = r3     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return r3
        L_0x002a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r3
        L_0x002d:
            r3 = 0
            return r3
        L_0x002f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.util.process.ProcessUtils.getProcessName(android.content.Context):java.lang.String");
    }

    @Nullable
    public static String getProcessNameAPI28() {
        try {
            return (String) Application.class.getMethod("getProcessName", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static String getProcessNameViaReflection(Application application) {
        try {
            Field field = application.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(application);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", (Class[]) null).invoke(obj2, (Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getProcessSpecificName(String str, Context context) {
        String packageName = context.getPackageName();
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(processName) || packageName.equals(processName)) {
            return str;
        }
        if (processName.contains(CertificateUtil.DELIMITER)) {
            processName = processName.split(CertificateUtil.DELIMITER)[1];
        }
        return GeneratedOutlineSupport.outline17(str, "_", processName);
    }
}
