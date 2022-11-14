package com.appsflyer.internal;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.C1471d;
import com.vungle.warren.VungleApiClient;

/* renamed from: com.appsflyer.internal.ab */
public final class C1380ab {
    public static String AFInAppEventType;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052 A[RETURN] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.C1471d.C1472a.C1473d AFInAppEventType(android.content.Context r6) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = AFInAppEventType
            r2 = 1
            if (r1 == 0) goto L_0x000b
            r1 = 1
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            r3 = 0
            if (r1 == 0) goto L_0x0013
            java.lang.String r6 = AFInAppEventType
        L_0x0011:
            r0 = r3
            goto L_0x0044
        L_0x0013:
            java.lang.String r4 = "collectOAID"
            boolean r2 = r0.getBoolean(r4, r2)
            if (r2 == 0) goto L_0x0042
            com.appsflyer.oaid.OaidClient r2 = new com.appsflyer.oaid.OaidClient     // Catch:{ all -> 0x003b }
            r2.<init>(r6)     // Catch:{ all -> 0x003b }
            boolean r6 = r0.isEnableLog()     // Catch:{ all -> 0x003b }
            r2.setLogging(r6)     // Catch:{ all -> 0x003b }
            com.appsflyer.oaid.OaidClient$Info r6 = r2.fetch()     // Catch:{ all -> 0x003b }
            if (r6 == 0) goto L_0x0042
            java.lang.String r0 = r6.getId()     // Catch:{ all -> 0x003b }
            java.lang.Boolean r6 = r6.getLat()     // Catch:{ all -> 0x0039 }
            r5 = r0
            r0 = r6
            r6 = r5
            goto L_0x0044
        L_0x0039:
            r6 = r0
            goto L_0x003c
        L_0x003b:
            r6 = r3
        L_0x003c:
            java.lang.String r0 = "No OAID library"
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0)
            goto L_0x0011
        L_0x0042:
            r6 = r3
            r0 = r6
        L_0x0044:
            if (r6 == 0) goto L_0x0052
            com.appsflyer.internal.d$a$d r2 = new com.appsflyer.internal.d$a$d
            r2.<init>(r6, r0)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
            r2.values = r6
            return r2
        L_0x0052:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1380ab.AFInAppEventType(android.content.Context):com.appsflyer.internal.d$a$d");
    }

    @Nullable
    public static C1471d.C1472a.C1473d AFKeystoreWrapper(ContentResolver contentResolver) {
        String str;
        if (contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !VungleApiClient.MANUFACTURER_AMAZON.equals(Build.MANUFACTURER)) {
            return null;
        }
        int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
        if (i == 0) {
            return new C1471d.C1472a.C1473d(Settings.Secure.getString(contentResolver, "advertising_id"), Boolean.FALSE);
        }
        if (i == 2) {
            return null;
        }
        try {
            str = Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Throwable th) {
            AFLogger.values("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
            str = "";
        }
        return new C1471d.C1472a.C1473d(str, Boolean.TRUE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r8.length() == 0) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084 A[SYNTHETIC, Splitter:B:31:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.C1471d.C1472a.C1473d AFKeystoreWrapper(android.content.Context r12, java.util.Map<java.lang.String, java.lang.Object> r13) {
        /*
            java.lang.String r0 = "advertiserIdEnabled"
            java.lang.String r1 = "advertiserId"
            java.lang.String r2 = "Trying to fetch GAID.."
            com.appsflyer.AFLogger.AFInAppEventParameterName(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.common.GoogleApiAvailability r3 = com.google.android.gms.common.GoogleApiAvailability.getInstance()     // Catch:{ all -> 0x0017 }
            int r3 = r3.isGooglePlayServicesAvailable(r12)     // Catch:{ all -> 0x0017 }
            goto L_0x0018
        L_0x0017:
            r3 = -1
        L_0x0018:
            r4 = 0
            r5 = 1
            r6 = 0
            java.lang.String r7 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
            java.lang.Class.forName(r7)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r12)     // Catch:{ all -> 0x0059 }
            if (r7 == 0) goto L_0x004c
            java.lang.String r8 = r7.getId()     // Catch:{ all -> 0x0059 }
            boolean r7 = r7.isLimitAdTrackingEnabled()     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0048 }
            if (r8 == 0) goto L_0x003a
            int r6 = r8.length()     // Catch:{ all -> 0x0042 }
            if (r6 != 0) goto L_0x003f
        L_0x003a:
            java.lang.String r6 = "emptyOrNull |"
            r2.append(r6)     // Catch:{ all -> 0x0042 }
        L_0x003f:
            r6 = 1
            goto L_0x00ec
        L_0x0042:
            r6 = move-exception
            r7 = r6
            r6 = r4
            r4 = r8
            r8 = 1
            goto L_0x005c
        L_0x0048:
            r7 = move-exception
            r6 = r4
            r4 = r8
            goto L_0x005b
        L_0x004c:
            java.lang.String r7 = "gpsAdInfo-null |"
            r2.append(r7)     // Catch:{ all -> 0x0059 }
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0059 }
            java.lang.String r8 = "GpsAdIndo is null"
            r7.<init>(r8)     // Catch:{ all -> 0x0059 }
            throw r7     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r7 = move-exception
            r6 = r4
        L_0x005b:
            r8 = 0
        L_0x005c:
            java.lang.String r9 = r7.getMessage()
            com.appsflyer.AFLogger.values(r9, r7)
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            r2.append(r7)
            java.lang.String r7 = " |"
            r2.append(r7)
            java.lang.String r9 = "WARNING: Google Play Services is missing."
            com.appsflyer.AFLogger.AFInAppEventParameterName(r9)
            com.appsflyer.AppsFlyerProperties r9 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r10 = "enableGpsFallback"
            boolean r9 = r9.getBoolean(r10, r5)
            if (r9 == 0) goto L_0x00e8
            com.appsflyer.internal.ad$e r4 = com.appsflyer.internal.C1382ad.AFKeystoreWrapper(r12)     // Catch:{ all -> 0x00a0 }
            java.lang.String r6 = r4.AFInAppEventParameterName     // Catch:{ all -> 0x00a0 }
            boolean r4 = r4.values()     // Catch:{ all -> 0x00a0 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x00a0 }
            if (r6 == 0) goto L_0x009a
            int r9 = r6.length()     // Catch:{ all -> 0x00a0 }
            if (r9 != 0) goto L_0x00e5
        L_0x009a:
            java.lang.String r9 = "emptyOrNull (bypass) |"
            r2.append(r9)     // Catch:{ all -> 0x00a0 }
            goto L_0x00e5
        L_0x00a0:
            r4 = move-exception
            java.lang.String r6 = r4.getMessage()
            com.appsflyer.AFLogger.values(r6, r4)
            java.lang.Class r6 = r4.getClass()
            java.lang.String r6 = r6.getSimpleName()
            r2.append(r6)
            r2.append(r7)
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r6 = r6.getString(r1)
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r7 = r7.getString(r0)
            boolean r7 = java.lang.Boolean.parseBoolean(r7)
            r7 = r7 ^ r5
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r9 = r4.getLocalizedMessage()
            if (r9 == 0) goto L_0x00dd
            java.lang.String r4 = r4.getLocalizedMessage()
            com.appsflyer.AFLogger.AFInAppEventParameterName(r4)
            goto L_0x00e4
        L_0x00dd:
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.AFInAppEventParameterName(r4)
        L_0x00e4:
            r4 = r7
        L_0x00e5:
            r11 = r8
            r8 = r6
            goto L_0x00eb
        L_0x00e8:
            r11 = r8
            r8 = r4
            r4 = r6
        L_0x00eb:
            r6 = r11
        L_0x00ec:
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getName()
            java.lang.String r7 = "android.app.ReceiverRestrictedContext"
            boolean r12 = r12.equals(r7)
            if (r12 == 0) goto L_0x011a
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r12.getString(r1)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r12 = r12.getString(r0)
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            r12 = r12 ^ r5
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r12)
            java.lang.String r12 = "context = android.app.ReceiverRestrictedContext |"
            r2.append(r12)
        L_0x011a:
            int r12 = r2.length()
            if (r12 <= 0) goto L_0x0139
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r3)
            java.lang.String r3 = ": "
            r12.append(r3)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            java.lang.String r2 = "gaidError"
            r13.put(r2, r12)
        L_0x0139:
            if (r8 == 0) goto L_0x016c
            if (r4 == 0) goto L_0x016c
            r13.put(r1, r8)
            boolean r12 = r4.booleanValue()
            r12 = r12 ^ r5
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r13.put(r0, r12)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            r12.set((java.lang.String) r1, (java.lang.String) r8)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r1 = r4.booleanValue()
            r1 = r1 ^ r5
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r12.set((java.lang.String) r0, (java.lang.String) r1)
            java.lang.String r12 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "isGaidWithGps"
            r13.put(r0, r12)
        L_0x016c:
            com.appsflyer.internal.d$a$d r12 = new com.appsflyer.internal.d$a$d
            r12.<init>(r8, r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1380ab.AFKeystoreWrapper(android.content.Context, java.util.Map):com.appsflyer.internal.d$a$d");
    }
}
