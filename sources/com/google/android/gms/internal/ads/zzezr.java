package com.google.android.gms.internal.ads;

import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzezr {
    public static zzbdd zza(Throwable th) {
        if (th instanceof zzedr) {
            zzedr zzedr = (zzedr) th;
            return zzc(zzedr.zza(), zzedr.zzb());
        } else if (th instanceof zzdxy) {
            if (th.getMessage() == null) {
                return zzd(((zzdxy) th).zza(), (String) null, (zzbdd) null);
            }
            return zzd(((zzdxy) th).zza(), th.getMessage(), (zzbdd) null);
        } else if (!(th instanceof zzba)) {
            return zzd(1, (String) null, (zzbdd) null);
        } else {
            zzba zzba = (zzba) th;
            return new zzbdd(zzba.zza(), zzfkm.zza(zzba.getMessage()), MobileAds.ERROR_DOMAIN, (zzbdd) null, (IBinder) null);
        }
    }

    public static zzbdd zzb(Throwable th, @Nullable zzeds zzeds) {
        zzbdd zzbdd;
        zzbdd zza = zza(th);
        int i = zza.zza;
        if ((i == 3 || i == 0) && (zzbdd = zza.zzd) != null && !zzbdd.zzc.equals(MobileAds.ERROR_DOMAIN)) {
            zza.zzd = null;
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfJ)).booleanValue() && zzeds != null) {
            zza.zze = zzeds.zzd();
        }
        return zza;
    }

    public static zzbdd zzc(int i, zzbdd zzbdd) {
        if (i != 0) {
            if (i == 8) {
                if (((Integer) zzbex.zzc().zzb(zzbjn.zzfG)).intValue() > 0) {
                    return zzbdd;
                }
                i = 8;
            }
            return zzd(i, (String) null, zzbdd);
        }
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        r4 = "No fill.";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzbdd zzd(int r8, @androidx.annotation.Nullable java.lang.String r9, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzbdd r10) {
        /*
            java.lang.String r0 = "No fill."
            r1 = 0
            if (r9 != 0) goto L_0x0054
            int r9 = r8 + -1
            if (r8 == 0) goto L_0x0053
            switch(r9) {
                case 1: goto L_0x0050;
                case 2: goto L_0x004e;
                case 3: goto L_0x004b;
                case 4: goto L_0x0048;
                case 5: goto L_0x0045;
                case 6: goto L_0x0042;
                case 7: goto L_0x003f;
                case 8: goto L_0x003c;
                case 9: goto L_0x0039;
                case 10: goto L_0x0036;
                case 11: goto L_0x000c;
                case 12: goto L_0x0021;
                case 13: goto L_0x001e;
                case 14: goto L_0x001b;
                case 15: goto L_0x0018;
                case 16: goto L_0x0015;
                case 17: goto L_0x0012;
                case 18: goto L_0x000f;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.String r9 = "Internal error."
            goto L_0x0054
        L_0x000f:
            java.lang.String r9 = "Ad inspector cannot be opened because it is already open."
            goto L_0x0054
        L_0x0012:
            java.lang.String r9 = "Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information."
            goto L_0x0054
        L_0x0015:
            java.lang.String r9 = "Ad inspector failed to load."
            goto L_0x0054
        L_0x0018:
            java.lang.String r9 = "Ad inspector had an internal error."
            goto L_0x0054
        L_0x001b:
            java.lang.String r9 = "Invalid ad string."
            goto L_0x0054
        L_0x001e:
            java.lang.String r9 = "Mismatch request IDs."
            goto L_0x0054
        L_0x0021:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r9 = com.google.android.gms.internal.ads.zzbjn.zzfK
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r9 = r2.zzb(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r9 > 0) goto L_0x004e
            java.lang.String r9 = "The mediation adapter did not return an ad."
            goto L_0x0054
        L_0x0036:
            java.lang.String r9 = "The ad can not be shown when app is not in foreground."
            goto L_0x0054
        L_0x0039:
            java.lang.String r9 = "The ad has already been shown."
            goto L_0x0054
        L_0x003c:
            java.lang.String r9 = "The ad is not ready."
            goto L_0x0054
        L_0x003f:
            java.lang.String r9 = "A mediation adapter failed to show the ad."
            goto L_0x0054
        L_0x0042:
            java.lang.String r9 = "Invalid request: Invalid ad size."
            goto L_0x0054
        L_0x0045:
            java.lang.String r9 = "Invalid request: Invalid ad unit ID."
            goto L_0x0054
        L_0x0048:
            java.lang.String r9 = "Network error."
            goto L_0x0054
        L_0x004b:
            java.lang.String r9 = "App ID missing."
            goto L_0x0054
        L_0x004e:
            r4 = r0
            goto L_0x0055
        L_0x0050:
            java.lang.String r9 = "Invalid request."
            goto L_0x0054
        L_0x0053:
            throw r1
        L_0x0054:
            r4 = r9
        L_0x0055:
            int r9 = r8 + -1
            com.google.android.gms.internal.ads.zzbdd r0 = new com.google.android.gms.internal.ads.zzbdd
            if (r8 == 0) goto L_0x00ee
            r1 = 0
            switch(r9) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0097;
                case 2: goto L_0x0094;
                case 3: goto L_0x008f;
                case 4: goto L_0x008c;
                case 5: goto L_0x0097;
                case 6: goto L_0x0097;
                case 7: goto L_0x0089;
                case 8: goto L_0x008c;
                case 9: goto L_0x0097;
                case 10: goto L_0x0094;
                case 11: goto L_0x009a;
                case 12: goto L_0x0072;
                case 13: goto L_0x006d;
                case 14: goto L_0x0068;
                case 15: goto L_0x009a;
                case 16: goto L_0x0097;
                case 17: goto L_0x008c;
                case 18: goto L_0x0094;
                default: goto L_0x005f;
            }
        L_0x005f:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            switch(r8) {
                case 1: goto L_0x00d7;
                case 2: goto L_0x00d4;
                case 3: goto L_0x00d1;
                case 4: goto L_0x00ce;
                case 5: goto L_0x00cb;
                case 6: goto L_0x00c8;
                case 7: goto L_0x00c5;
                case 8: goto L_0x00c2;
                case 9: goto L_0x00bf;
                case 10: goto L_0x00bc;
                case 11: goto L_0x00b9;
                case 12: goto L_0x00b6;
                case 13: goto L_0x00b3;
                case 14: goto L_0x00b0;
                case 15: goto L_0x00ad;
                case 16: goto L_0x00aa;
                case 17: goto L_0x00a7;
                case 18: goto L_0x00a4;
                default: goto L_0x0064;
            }
        L_0x0064:
            java.lang.String r8 = "AD_INSPECTOR_ALREADY_OPEN"
            goto L_0x00d9
        L_0x0068:
            r8 = 11
            r3 = 11
            goto L_0x009b
        L_0x006d:
            r8 = 10
            r3 = 10
            goto L_0x009b
        L_0x0072:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Integer> r8 = com.google.android.gms.internal.ads.zzbjn.zzfK
            com.google.android.gms.internal.ads.zzbjl r9 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r8 = r9.zzb(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 > 0) goto L_0x0094
            r8 = 9
            r3 = 9
            goto L_0x009b
        L_0x0089:
            r8 = 4
            r3 = 4
            goto L_0x009b
        L_0x008c:
            r8 = 2
            r3 = 2
            goto L_0x009b
        L_0x008f:
            r8 = 8
            r3 = 8
            goto L_0x009b
        L_0x0094:
            r8 = 3
            r3 = 3
            goto L_0x009b
        L_0x0097:
            r8 = 1
            r3 = 1
            goto L_0x009b
        L_0x009a:
            r3 = 0
        L_0x009b:
            r7 = 0
            java.lang.String r5 = "com.google.android.gms.ads"
            r2 = r0
            r6 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x00a4:
            java.lang.String r8 = "AD_INSPECTOR_NOT_IN_TEST_MODE"
            goto L_0x00d9
        L_0x00a7:
            java.lang.String r8 = "AD_INSPECTOR_FAILED_TO_LOAD"
            goto L_0x00d9
        L_0x00aa:
            java.lang.String r8 = "AD_INSPECTOR_INTERNAL_ERROR"
            goto L_0x00d9
        L_0x00ad:
            java.lang.String r8 = "INVALID_AD_STRING"
            goto L_0x00d9
        L_0x00b0:
            java.lang.String r8 = "REQUEST_ID_MISMATCH"
            goto L_0x00d9
        L_0x00b3:
            java.lang.String r8 = "MEDIATION_NO_FILL"
            goto L_0x00d9
        L_0x00b6:
            java.lang.String r8 = "INTERNAL_SHOW_ERROR"
            goto L_0x00d9
        L_0x00b9:
            java.lang.String r8 = "APP_NOT_FOREGROUND"
            goto L_0x00d9
        L_0x00bc:
            java.lang.String r8 = "AD_REUSED"
            goto L_0x00d9
        L_0x00bf:
            java.lang.String r8 = "NOT_READY"
            goto L_0x00d9
        L_0x00c2:
            java.lang.String r8 = "MEDIATION_SHOW_ERROR"
            goto L_0x00d9
        L_0x00c5:
            java.lang.String r8 = "INVALID_AD_SIZE"
            goto L_0x00d9
        L_0x00c8:
            java.lang.String r8 = "INVALID_AD_UNIT_ID"
            goto L_0x00d9
        L_0x00cb:
            java.lang.String r8 = "NETWORK_ERROR"
            goto L_0x00d9
        L_0x00ce:
            java.lang.String r8 = "APP_ID_MISSING"
            goto L_0x00d9
        L_0x00d1:
            java.lang.String r8 = "NO_FILL"
            goto L_0x00d9
        L_0x00d4:
            java.lang.String r8 = "INVALID_REQUEST"
            goto L_0x00d9
        L_0x00d7:
            java.lang.String r8 = "INTERNAL_ERROR"
        L_0x00d9:
            int r10 = r8.length()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r10 = r10 + 18
            r0.<init>(r10)
            java.lang.String r10 = "Unknown SdkError: "
            java.lang.String r8 = com.android.tools.p006r8.GeneratedOutlineSupport.outline18(r0, r10, r8)
            r9.<init>(r8)
            throw r9
        L_0x00ee:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzezr.zzd(int, java.lang.String, com.google.android.gms.internal.ads.zzbdd):com.google.android.gms.internal.ads.zzbdd");
    }
}
