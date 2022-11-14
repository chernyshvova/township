package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@ShowFirstParty
@CheckReturnValue
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class GoogleSignatureVerifier {
    @Nullable
    public static GoogleSignatureVerifier zza;
    public final Context zzb;
    public volatile String zzc;

    public GoogleSignatureVerifier(@RecentlyNonNull Context context) {
        this.zzb = context.getApplicationContext();
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(@RecentlyNonNull Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzm.zza(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @Nullable
    public static final zzi zza(PackageInfo packageInfo, zzi... zziArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzj zzj = new zzj(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zziArr.length; i++) {
            if (zziArr[i].equals(zzj)) {
                return zziArr[i];
            }
        }
        return null;
    }

    public static final boolean zzb(@RecentlyNonNull PackageInfo packageInfo, boolean z) {
        zzi zzi;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzi = zza(packageInfo, zzl.zza);
            } else {
                zzi = zza(packageInfo, zzl.zza[0]);
            }
            if (zzi != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r8 = r8.applicationInfo;
     */
    @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.common.zzw zzc(java.lang.String r6, boolean r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r7 = "null pkg"
            if (r6 != 0) goto L_0x0009
            com.google.android.gms.common.zzw r6 = com.google.android.gms.common.zzw.zzd(r7)
            return r6
        L_0x0009:
            java.lang.String r8 = r5.zzc
            boolean r8 = r6.equals(r8)
            if (r8 != 0) goto L_0x009c
            boolean r8 = com.google.android.gms.common.zzm.zzd()
            r0 = 0
            if (r8 == 0) goto L_0x0023
            android.content.Context r7 = r5.zzb
            boolean r7 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r7)
            com.google.android.gms.common.zzw r7 = com.google.android.gms.common.zzm.zzb(r6, r7, r0, r0)
            goto L_0x007d
        L_0x0023:
            android.content.Context r8 = r5.zzb     // Catch:{ NameNotFoundException -> 0x0084 }
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0084 }
            r1 = 64
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r6, r1)     // Catch:{ NameNotFoundException -> 0x0084 }
            android.content.Context r1 = r5.zzb
            boolean r1 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r1)
            if (r8 != 0) goto L_0x003c
            com.google.android.gms.common.zzw r7 = com.google.android.gms.common.zzw.zzd(r7)
            goto L_0x007d
        L_0x003c:
            android.content.pm.Signature[] r7 = r8.signatures
            if (r7 == 0) goto L_0x0077
            int r7 = r7.length
            r2 = 1
            if (r7 == r2) goto L_0x0045
            goto L_0x0077
        L_0x0045:
            com.google.android.gms.common.zzj r7 = new com.google.android.gms.common.zzj
            android.content.pm.Signature[] r3 = r8.signatures
            r3 = r3[r0]
            byte[] r3 = r3.toByteArray()
            r7.<init>(r3)
            java.lang.String r3 = r8.packageName
            com.google.android.gms.common.zzw r1 = com.google.android.gms.common.zzm.zzc(r3, r7, r1, r0)
            boolean r4 = r1.zza
            if (r4 == 0) goto L_0x0075
            android.content.pm.ApplicationInfo r8 = r8.applicationInfo
            if (r8 == 0) goto L_0x0075
            int r8 = r8.flags
            r8 = r8 & 2
            if (r8 == 0) goto L_0x0075
            com.google.android.gms.common.zzw r7 = com.google.android.gms.common.zzm.zzc(r3, r7, r0, r2)
            boolean r7 = r7.zza
            if (r7 == 0) goto L_0x0075
            java.lang.String r7 = "debuggable release cert app rejected"
            com.google.android.gms.common.zzw r7 = com.google.android.gms.common.zzw.zzd(r7)
            goto L_0x007d
        L_0x0075:
            r7 = r1
            goto L_0x007d
        L_0x0077:
            java.lang.String r7 = "single cert required"
            com.google.android.gms.common.zzw r7 = com.google.android.gms.common.zzw.zzd(r7)
        L_0x007d:
            boolean r8 = r7.zza
            if (r8 == 0) goto L_0x0083
            r5.zzc = r6
        L_0x0083:
            return r7
        L_0x0084:
            r7 = move-exception
            java.lang.String r8 = "no pkg "
            int r0 = r6.length()
            if (r0 == 0) goto L_0x0092
            java.lang.String r6 = r8.concat(r6)
            goto L_0x0097
        L_0x0092:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r8)
        L_0x0097:
            com.google.android.gms.common.zzw r6 = com.google.android.gms.common.zzw.zze(r6, r7)
            return r6
        L_0x009c:
            com.google.android.gms.common.zzw r6 = com.google.android.gms.common.zzw.zzb()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zzc(java.lang.String, boolean, boolean):com.google.android.gms.common.zzw");
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(@RecentlyNonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(@RecentlyNonNull String str) {
        zzw zzc2 = zzc(str, false, false);
        zzc2.zzf();
        return zzc2.zza;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        zzw zzw;
        int length;
        String[] packagesForUid = this.zzb.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzw = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Preconditions.checkNotNull(zzw);
                    break;
                }
                zzw = zzc(packagesForUid[i2], false, false);
                if (zzw.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzw = zzw.zzd("no pkgs");
        }
        zzw.zzf();
        return zzw.zza;
    }
}
