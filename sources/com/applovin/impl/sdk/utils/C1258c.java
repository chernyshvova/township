package com.applovin.impl.sdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.C1234o;
import com.applovin.impl.sdk.C1314v;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.applovin.impl.sdk.utils.c */
public class C1258c {

    /* renamed from: a */
    public static boolean f2429a = true;

    /* renamed from: b */
    public static final Object f2430b = new Object();

    /* renamed from: c */
    public static final Collection<CountDownLatch> f2431c = new HashSet();

    /* renamed from: d */
    public static boolean f2432d = false;

    /* renamed from: e */
    public static C1234o.C1240a f2433e = null;

    /* renamed from: a */
    public static C1234o.C1240a m2488a(Context context) {
        return m2490b(context);
    }

    /* renamed from: a */
    public static boolean m2489a() {
        return Utils.checkClassExistence("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r5 = m2491c(r5);
        r0 = f2430b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        f2432d = true;
        f2433e = r5;
        r5 = new java.util.HashSet(f2431c);
        f2431c.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r5 = r5.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r5.hasNext() == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        ((java.util.concurrent.CountDownLatch) r5.next()).countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r2.await(60, java.util.concurrent.TimeUnit.SECONDS) != false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        com.applovin.impl.sdk.C1314v.m2663i("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }: collection timeout");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0061, code lost:
        com.applovin.impl.sdk.C1314v.m2659c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", r5);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.applovin.impl.sdk.C1234o.C1240a m2490b(android.content.Context r5) {
        /*
            java.lang.Object r0 = f2430b
            monitor-enter(r0)
            boolean r1 = f2432d     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x000b
            com.applovin.impl.sdk.o$a r5 = f2433e     // Catch:{ all -> 0x0072 }
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            return r5
        L_0x000b:
            java.util.Collection<java.util.concurrent.CountDownLatch> r1 = f2431c     // Catch:{ all -> 0x0072 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0072 }
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x0072 }
            r3 = 1
            r2.<init>(r3)     // Catch:{ all -> 0x0072 }
            java.util.Collection<java.util.concurrent.CountDownLatch> r4 = f2431c     // Catch:{ all -> 0x0072 }
            r4.add(r2)     // Catch:{ all -> 0x0072 }
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x004e
            com.applovin.impl.sdk.o$a r5 = m2491c(r5)
            java.lang.Object r0 = f2430b
            monitor-enter(r0)
            f2432d = r3     // Catch:{ all -> 0x004b }
            f2433e = r5     // Catch:{ all -> 0x004b }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x004b }
            java.util.Collection<java.util.concurrent.CountDownLatch> r1 = f2431c     // Catch:{ all -> 0x004b }
            r5.<init>(r1)     // Catch:{ all -> 0x004b }
            java.util.Collection<java.util.concurrent.CountDownLatch> r1 = f2431c     // Catch:{ all -> 0x004b }
            r1.clear()     // Catch:{ all -> 0x004b }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            java.util.Iterator r5 = r5.iterator()
        L_0x003b:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x004e
            java.lang.Object r0 = r5.next()
            java.util.concurrent.CountDownLatch r0 = (java.util.concurrent.CountDownLatch) r0
            r0.countDown()
            goto L_0x003b
        L_0x004b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r5
        L_0x004e:
            r0 = 60
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0060 }
            boolean r5 = r2.await(r0, r5)     // Catch:{ InterruptedException -> 0x0060 }
            if (r5 != 0) goto L_0x0068
            java.lang.String r5 = "DataCollector"
            java.lang.String r0 = "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }: collection timeout"
            com.applovin.impl.sdk.C1314v.m2663i(r5, r0)     // Catch:{ InterruptedException -> 0x0060 }
            goto L_0x0068
        L_0x0060:
            r5 = move-exception
            java.lang.String r0 = "DataCollector"
            java.lang.String r1 = "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }"
            com.applovin.impl.sdk.C1314v.m2659c(r0, r1, r5)
        L_0x0068:
            java.lang.Object r5 = f2430b
            monitor-enter(r5)
            com.applovin.impl.sdk.o$a r0 = f2433e     // Catch:{ all -> 0x006f }
            monitor-exit(r5)     // Catch:{ all -> 0x006f }
            return r0
        L_0x006f:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x006f }
            throw r0
        L_0x0072:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            goto L_0x0076
        L_0x0075:
            throw r5
        L_0x0076:
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C1258c.m2490b(android.content.Context):com.applovin.impl.sdk.o$a");
    }

    /* renamed from: c */
    public static C1234o.C1240a m2491c(Context context) {
        C1234o.C1240a d = m2492d(context);
        if (d == null) {
            d = m2493e(context);
        }
        return d == null ? new C1234o.C1240a() : d;
    }

    @Nullable
    /* renamed from: d */
    public static C1234o.C1240a m2492d(Context context) {
        if (m2489a()) {
            try {
                C1234o.C1240a aVar = new C1234o.C1240a();
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                aVar.f2382a = advertisingIdInfo.isLimitAdTrackingEnabled();
                aVar.f2383b = advertisingIdInfo.getId();
                return aVar;
            } catch (Throwable th) {
                if (C1234o.m2392b(context)) {
                    return null;
                }
                C1314v.m2659c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
                return null;
            }
        } else if (C1234o.m2392b(context)) {
            return null;
        } else {
            C1314v.m2663i("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
            return null;
        }
    }

    @Nullable
    /* renamed from: e */
    public static C1234o.C1240a m2493e(Context context) {
        String str;
        if (f2429a) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                C1234o.C1240a aVar = new C1234o.C1240a();
                aVar.f2383b = StringUtils.emptyIfNull(Settings.Secure.getString(contentResolver, "advertising_id"));
                aVar.f2382a = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
                return aVar;
            } catch (Settings.SettingNotFoundException e) {
                th = e;
                str = "Unable to determine if Fire OS limited ad tracking is turned on";
                C1314v.m2659c("DataCollector", str, th);
                f2429a = false;
                return null;
            } catch (Throwable th) {
                th = th;
                str = "Unable to collect Fire OS IDFA";
                C1314v.m2659c("DataCollector", str, th);
                f2429a = false;
                return null;
            }
        }
        f2429a = false;
        return null;
    }
}
