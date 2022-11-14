package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class WorkSourceUtil {
    public static final int zza = Process.myUid();
    @Nullable
    public static final Method zzb;
    @Nullable
    public static final Method zzc;
    @Nullable
    public static final Method zzd;
    @Nullable
    public static final Method zze;
    @Nullable
    public static final Method zzf;
    @Nullable
    public static final Method zzg;
    @Nullable
    public static final Method zzh;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[SYNTHETIC, Splitter:B:23:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            int r2 = android.os.Process.myUid()
            zza = r2
            r2 = 1
            r3 = 0
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x001a }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x001a }
            r5[r3] = r6     // Catch:{ Exception -> 0x001a }
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r5 = r6.getMethod(r1, r5)     // Catch:{ Exception -> 0x001a }
            goto L_0x001b
        L_0x001a:
            r5 = r4
        L_0x001b:
            zzb = r5
            boolean r5 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r6 = 2
            if (r5 == 0) goto L_0x0033
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x0033 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0033 }
            r5[r3] = r7     // Catch:{ Exception -> 0x0033 }
            r5[r2] = r0     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<android.os.WorkSource> r7 = android.os.WorkSource.class
            java.lang.reflect.Method r1 = r7.getMethod(r1, r5)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            r1 = r4
        L_0x0034:
            zzc = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "size"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0041 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r1 = r4
        L_0x0042:
            zzd = r1
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0053 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0053 }
            r1[r3] = r5     // Catch:{ Exception -> 0x0053 }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "get"
            java.lang.reflect.Method r1 = r5.getMethod(r7, r1)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0054
        L_0x0053:
            r1 = r4
        L_0x0054:
            zze = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r1 == 0) goto L_0x006b
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x006b }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x006b }
            r1[r3] = r5     // Catch:{ Exception -> 0x006b }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.String r7 = "getName"
            java.lang.reflect.Method r1 = r5.getMethod(r7, r1)     // Catch:{ Exception -> 0x006b }
            goto L_0x006c
        L_0x006b:
            r1 = r4
        L_0x006c:
            zzf = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r5 = "WorkSourceUtil"
            if (r1 == 0) goto L_0x0087
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r7 = "createWorkChain"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0081 }
            java.lang.reflect.Method r1 = r1.getMethod(r7, r8)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0088
        L_0x0081:
            r1 = move-exception
            java.lang.String r7 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r5, r7, r1)
        L_0x0087:
            r1 = r4
        L_0x0088:
            zzg = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r1 == 0) goto L_0x00ab
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x00a5 }
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x00a5 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00a5 }
            r6[r3] = r7     // Catch:{ Exception -> 0x00a5 }
            r6[r2] = r0     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r0 = "addNode"
            java.lang.reflect.Method r4 = r1.getMethod(r0, r6)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00ab
        L_0x00a5:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r5, r1, r0)
        L_0x00ab:
            zzh = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    @KeepForSdk
    @RecentlyNullable
    public static WorkSource fromPackage(@RecentlyNonNull Context context, @Nullable String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                int i = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                zza(workSource, i, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
            }
        }
        return null;
    }

    @KeepForSdk
    @RecentlyNullable
    public static WorkSource fromPackageAndModuleExperimentalPi(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        String str3;
        String str4;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                if (str.length() != 0) {
                    str4 = "Could not get applicationInfo from package: ".concat(str);
                } else {
                    str4 = new String("Could not get applicationInfo from package: ");
                }
                Log.e("WorkSourceUtil", str4);
            } else {
                i = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            if (str.length() != 0) {
                str3 = "Could not find package: ".concat(str);
            } else {
                str3 = new String("Could not find package: ");
            }
            Log.e("WorkSourceUtil", str3);
        }
        if (i < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method = zzg;
        if (method == null || zzh == null) {
            zza(workSource, i, str);
        } else {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                if (i != zza) {
                    zzh.invoke(invoke, new Object[]{Integer.valueOf(i), str});
                }
                zzh.invoke(invoke, new Object[]{Integer.valueOf(zza), str2});
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e);
            }
        }
        return workSource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> getNames(@androidx.annotation.Nullable android.os.WorkSource r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "Unable to assign blame through WorkSource"
            java.lang.String r2 = "WorkSourceUtil"
            r3 = 0
            if (r10 != 0) goto L_0x000e
        L_0x000c:
            r4 = 0
            goto L_0x0027
        L_0x000e:
            java.lang.reflect.Method r4 = zzd
            if (r4 == 0) goto L_0x000c
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0022 }
            java.lang.Object r4 = r4.invoke(r10, r5)     // Catch:{ Exception -> 0x0022 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ Exception -> 0x0022 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x0022 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0027
        L_0x0022:
            r4 = move-exception
            android.util.Log.wtf(r2, r1, r4)
            goto L_0x000c
        L_0x0027:
            if (r4 == 0) goto L_0x0055
            r5 = 0
        L_0x002a:
            if (r5 >= r4) goto L_0x0055
            java.lang.reflect.Method r6 = zzf
            r7 = 0
            if (r6 == 0) goto L_0x0046
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0042 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0042 }
            r8[r3] = r9     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r6 = r6.invoke(r10, r8)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0042 }
            r7 = r6
            goto L_0x0046
        L_0x0042:
            r6 = move-exception
            android.util.Log.wtf(r2, r1, r6)
        L_0x0046:
            boolean r6 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r7)
            if (r6 != 0) goto L_0x0052
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            r0.add(r7)
        L_0x0052:
            int r5 = r5 + 1
            goto L_0x002a
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.getNames(android.os.WorkSource):java.util.List");
    }

    @KeepForSdk
    public static boolean hasWorkSourcePermission(@RecentlyNonNull Context context) {
        if (context == null || context.getPackageManager() == null || Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static void zza(@RecentlyNonNull WorkSource workSource, int i, @Nullable String str) {
        Method method = zzc;
        if (method != null) {
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                }
            }
        }
    }
}
