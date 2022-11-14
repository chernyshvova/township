package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeqw implements zzeqp<zzequ> {
    public final zzfqo zza;
    public final Context zzb;

    public zzeqw(zzfqo zzfqo, Context context) {
        this.zza = zzfqo;
        this.zzb = context;
    }

    public static ResolveInfo zzc(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    public final zzfqn<zzequ> zza() {
        return this.zza.zzb(new zzeqv(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4 A[Catch:{ Exception -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzequ zzb() throws java.lang.Exception {
        /*
            r22 = this;
            r0 = r22
            android.content.Context r1 = r0.zzb
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "geo:0,0?q=donuts"
            android.content.pm.ResolveInfo r3 = zzc(r1, r3)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0018
            r7 = 1
            goto L_0x0019
        L_0x0018:
            r7 = 0
        L_0x0019:
            java.lang.String r3 = "http://www.google.com"
            android.content.pm.ResolveInfo r3 = zzc(r1, r3)
            if (r3 == 0) goto L_0x0023
            r8 = 1
            goto L_0x0024
        L_0x0023:
            r8 = 0
        L_0x0024:
            java.lang.String r9 = r2.getCountry()
            java.lang.String r3 = android.os.Build.DEVICE
            java.lang.String r4 = "generic"
            boolean r10 = r3.startsWith(r4)
            android.content.Context r3 = r0.zzb
            boolean r11 = com.google.android.gms.common.util.DeviceProperties.isLatchsky(r3)
            android.content.Context r3 = r0.zzb
            boolean r12 = com.google.android.gms.common.util.DeviceProperties.isSidewinder(r3)
            java.lang.String r13 = r2.getLanguage()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0064
            android.os.LocaleList r2 = android.os.LocaleList.getDefault()
            r3 = 0
        L_0x0050:
            int r4 = r2.size()
            if (r3 >= r4) goto L_0x0064
            java.util.Locale r4 = r2.get(r3)
            java.lang.String r4 = r4.getLanguage()
            r14.add(r4)
            int r3 = r3 + 1
            goto L_0x0050
        L_0x0064:
            android.content.Context r2 = r0.zzb
            java.lang.String r3 = "market://details?id=com.google.android.gms.ads"
            android.content.pm.ResolveInfo r3 = zzc(r1, r3)
            java.lang.String r4 = "."
            if (r3 != 0) goto L_0x0072
        L_0x0070:
            r15 = 0
            goto L_0x00a4
        L_0x0072:
            android.content.pm.ActivityInfo r3 = r3.activityInfo
            if (r3 != 0) goto L_0x0077
            goto L_0x0070
        L_0x0077:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r2 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r2)     // Catch:{ NameNotFoundException -> 0x0070 }
            java.lang.String r15 = r3.packageName     // Catch:{ NameNotFoundException -> 0x0070 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r15, r5)     // Catch:{ NameNotFoundException -> 0x0070 }
            if (r2 == 0) goto L_0x0070
            int r2 = r2.versionCode     // Catch:{ NameNotFoundException -> 0x0070 }
            java.lang.String r3 = r3.packageName     // Catch:{ NameNotFoundException -> 0x0070 }
            java.lang.String r15 = java.lang.String.valueOf(r3)     // Catch:{ NameNotFoundException -> 0x0070 }
            int r15 = r15.length()     // Catch:{ NameNotFoundException -> 0x0070 }
            int r15 = r15 + 12
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0070 }
            r6.<init>(r15)     // Catch:{ NameNotFoundException -> 0x0070 }
            r6.append(r2)     // Catch:{ NameNotFoundException -> 0x0070 }
            r6.append(r4)     // Catch:{ NameNotFoundException -> 0x0070 }
            r6.append(r3)     // Catch:{ NameNotFoundException -> 0x0070 }
            java.lang.String r2 = r6.toString()     // Catch:{ NameNotFoundException -> 0x0070 }
            r15 = r2
        L_0x00a4:
            android.content.Context r2 = r0.zzb
            com.google.android.gms.common.wrappers.PackageManagerWrapper r2 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r2)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r3 = "com.android.vending"
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r6)     // Catch:{ Exception -> 0x00d7 }
            if (r2 == 0) goto L_0x00d7
            int r3 = r2.versionCode     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00d7 }
            int r6 = r6.length()     // Catch:{ Exception -> 0x00d7 }
            int r6 = r6 + 12
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00d7 }
            r5.append(r3)     // Catch:{ Exception -> 0x00d7 }
            r5.append(r4)     // Catch:{ Exception -> 0x00d7 }
            r5.append(r2)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x00d7 }
            r16 = r2
            goto L_0x00d9
        L_0x00d7:
            r16 = 0
        L_0x00d9:
            java.lang.String r2 = android.os.Build.FINGERPRINT
            android.content.Context r3 = r0.zzb
            if (r1 != 0) goto L_0x00e2
        L_0x00df:
            r18 = 0
            goto L_0x012d
        L_0x00e2:
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r5 = "http://www.example.com"
            android.net.Uri r5 = android.net.Uri.parse(r5)
            java.lang.String r6 = "android.intent.action.VIEW"
            r4.<init>(r6, r5)
            r5 = 0
            android.content.pm.ResolveInfo r6 = r1.resolveActivity(r4, r5)
            r5 = 65536(0x10000, float:9.18355E-41)
            java.util.List r1 = r1.queryIntentActivities(r4, r5)
            if (r1 == 0) goto L_0x00df
            if (r6 == 0) goto L_0x00df
            r4 = 0
        L_0x00ff:
            int r5 = r1.size()
            if (r4 >= r5) goto L_0x00df
            java.lang.Object r5 = r1.get(r4)
            android.content.pm.ResolveInfo r5 = (android.content.pm.ResolveInfo) r5
            android.content.pm.ActivityInfo r0 = r6.activityInfo
            java.lang.String r0 = r0.name
            android.content.pm.ActivityInfo r5 = r5.activityInfo
            java.lang.String r5 = r5.name
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0128
            android.content.pm.ActivityInfo r0 = r6.activityInfo
            java.lang.String r0 = r0.packageName
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgjv.zza(r3)
            boolean r5 = r0.equals(r1)
            r18 = r5
            goto L_0x012d
        L_0x0128:
            int r4 = r4 + 1
            r0 = r22
            goto L_0x00ff
        L_0x012d:
            com.google.android.gms.ads.internal.util.zzac r0 = com.google.android.gms.ads.internal.zzs.zze()
            long r20 = r0.zzi()
            com.google.android.gms.internal.ads.zzequ r0 = new com.google.android.gms.internal.ads.zzequ
            java.lang.String r19 = android.os.Build.MODEL
            r6 = r0
            r17 = r2
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeqw.zzb():com.google.android.gms.internal.ads.zzequ");
    }
}
