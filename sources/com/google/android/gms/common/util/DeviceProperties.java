package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.swrve.sdk.ISwrveCommon;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class DeviceProperties {
    @Nullable
    public static Boolean zza;
    @Nullable
    public static Boolean zzb;
    @Nullable
    public static Boolean zzc;
    @Nullable
    public static Boolean zzd;
    @Nullable
    public static Boolean zze;
    @Nullable
    public static Boolean zzf;
    @Nullable
    public static Boolean zzg;
    @Nullable
    public static Boolean zzh;

    @KeepForSdk
    public static boolean isAuto(@RecentlyNonNull Context context) {
        return isAuto(context.getPackageManager());
    }

    @KeepForSdk
    @Deprecated
    public static boolean isFeaturePhone(@RecentlyNonNull Context context) {
        return false;
    }

    @KeepForSdk
    public static boolean isLatchsky(@RecentlyNonNull Context context) {
        if (zze == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z = true;
            }
            zze = Boolean.valueOf(z);
        }
        return zze.booleanValue();
    }

    @TargetApi(21)
    @KeepForSdk
    public static boolean isSidewinder(@RecentlyNonNull Context context) {
        return zza(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (zzb.booleanValue() != false) goto L_0x0014;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isTablet(@androidx.annotation.RecentlyNonNull android.content.res.Resources r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.Boolean r1 = zza
            if (r1 != 0) goto L_0x0042
            android.content.res.Configuration r1 = r4.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 15
            r2 = 3
            r3 = 1
            if (r1 <= r2) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x003c
        L_0x0016:
            java.lang.Boolean r1 = zzb
            if (r1 != 0) goto L_0x0033
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.screenLayout
            r1 = r1 & 15
            if (r1 > r2) goto L_0x002c
            int r4 = r4.smallestScreenWidthDp
            r1 = 600(0x258, float:8.41E-43)
            if (r4 < r1) goto L_0x002c
            r4 = 1
            goto L_0x002d
        L_0x002c:
            r4 = 0
        L_0x002d:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            zzb = r4
        L_0x0033:
            java.lang.Boolean r4 = zzb
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x003c
            goto L_0x0014
        L_0x003c:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            zza = r4
        L_0x0042:
            java.lang.Boolean r4 = zza
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isTablet(android.content.res.Resources):boolean");
    }

    @KeepForSdk
    public static boolean isTv(@RecentlyNonNull Context context) {
        return isTv(context.getPackageManager());
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return ISwrveCommon.BATCH_EVENT_KEY_USER.equals(Build.TYPE);
    }

    @TargetApi(20)
    @KeepForSdk
    public static boolean isWearable(@RecentlyNonNull Context context) {
        return isWearable(context.getPackageManager());
    }

    @TargetApi(26)
    @KeepForSdk
    public static boolean isWearableWithoutPlayStore(@RecentlyNonNull Context context) {
        if (isWearable(context)) {
            if (!PlatformVersion.isAtLeastN()) {
                return true;
            }
            if (!zza(context) || PlatformVersion.isAtLeastO()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @TargetApi(21)
    public static boolean zza(@RecentlyNonNull Context context) {
        if (zzd == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            zzd = Boolean.valueOf(z);
        }
        return zzd.booleanValue();
    }

    public static boolean zzb(@RecentlyNonNull Context context) {
        if (zzf == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            zzf = Boolean.valueOf(z);
        }
        return zzf.booleanValue();
    }

    @KeepForSdk
    public static boolean isAuto(@RecentlyNonNull PackageManager packageManager) {
        if (zzg == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            zzg = Boolean.valueOf(z);
        }
        return zzg.booleanValue();
    }

    @KeepForSdk
    public static boolean isTv(@RecentlyNonNull PackageManager packageManager) {
        if (zzh == null) {
            boolean z = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                z = false;
            }
            zzh = Boolean.valueOf(z);
        }
        return zzh.booleanValue();
    }

    @TargetApi(20)
    @KeepForSdk
    public static boolean isWearable(@RecentlyNonNull PackageManager packageManager) {
        if (zzc == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            zzc = Boolean.valueOf(z);
        }
        return zzc.booleanValue();
    }
}
