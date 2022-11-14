package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class ProcessUtils {
    @Nullable
    public static String zza;
    public static int zzb;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.RecentlyNullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMyProcessName() {
        /*
            java.lang.String r0 = zza
            if (r0 != 0) goto L_0x005c
            int r0 = zzb
            if (r0 != 0) goto L_0x000e
            int r0 = android.os.Process.myPid()
            zzb = r0
        L_0x000e:
            int r0 = zzb
            r1 = 0
            if (r0 > 0) goto L_0x0014
            goto L_0x005a
        L_0x0014:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            r3 = 25
            r2.<init>(r3)     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            java.lang.String r3 = "/proc/"
            r2.append(r3)     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            r2.append(r0)     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            java.lang.String r0 = "/cmdline"
            r2.append(r0)     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            android.os.StrictMode$ThreadPolicy r2 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x004c }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x004c }
            r4.<init>(r0)     // Catch:{ all -> 0x004c }
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            android.os.StrictMode.setThreadPolicy(r2)     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            java.lang.String r0 = r3.readLine()     // Catch:{ IOException -> 0x0057, all -> 0x0049 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ IOException -> 0x0057, all -> 0x0049 }
            java.lang.String r1 = r0.trim()     // Catch:{ IOException -> 0x0057, all -> 0x0049 }
            goto L_0x0057
        L_0x0049:
            r0 = move-exception
            r1 = r3
            goto L_0x0052
        L_0x004c:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r2)     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            throw r0     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
        L_0x0051:
            r0 = move-exception
        L_0x0052:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r1)
            throw r0
        L_0x0056:
            r3 = r1
        L_0x0057:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
        L_0x005a:
            zza = r1
        L_0x005c:
            java.lang.String r0 = zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.ProcessUtils.getMyProcessName():java.lang.String");
    }
}
