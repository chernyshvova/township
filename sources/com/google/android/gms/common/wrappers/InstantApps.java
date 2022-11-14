package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class InstantApps {
    public static Context zza;
    @Nullable
    public static Boolean zzb;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0042 */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean isInstantApp(@androidx.annotation.RecentlyNonNull android.content.Context r3) {
        /*
            java.lang.Class<com.google.android.gms.common.wrappers.InstantApps> r0 = com.google.android.gms.common.wrappers.InstantApps.class
            monitor-enter(r0)
            android.content.Context r1 = r3.getApplicationContext()     // Catch:{ all -> 0x0050 }
            android.content.Context r2 = zza     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x001c
            java.lang.Boolean r2 = zzb     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x001c
            android.content.Context r2 = zza     // Catch:{ all -> 0x0050 }
            if (r2 == r1) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            java.lang.Boolean r3 = zzb     // Catch:{ all -> 0x0050 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)
            return r3
        L_0x001c:
            r2 = 0
            zzb = r2     // Catch:{ all -> 0x0050 }
            boolean r2 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x0034
            android.content.pm.PackageManager r3 = r1.getPackageManager()     // Catch:{ all -> 0x0050 }
            boolean r3 = r3.isInstantApp()     // Catch:{ all -> 0x0050 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0050 }
            zzb = r3     // Catch:{ all -> 0x0050 }
            goto L_0x0046
        L_0x0034:
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0042 }
            java.lang.String r2 = "com.google.android.instantapps.supervisor.InstantAppsRuntime"
            r3.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x0042 }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ ClassNotFoundException -> 0x0042 }
            zzb = r3     // Catch:{ ClassNotFoundException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0050 }
            zzb = r3     // Catch:{ all -> 0x0050 }
        L_0x0046:
            zza = r1     // Catch:{ all -> 0x0050 }
            java.lang.Boolean r3 = zzb     // Catch:{ all -> 0x0050 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)
            return r3
        L_0x0050:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.wrappers.InstantApps.isInstantApp(android.content.Context):boolean");
    }
}
