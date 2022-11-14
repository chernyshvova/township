package com.applovin.impl.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.applovin.impl.sdk.p027c.C1085b;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.applovin.impl.sdk.e */
public class C1105e {

    /* renamed from: a */
    public static final int f1946a = ((int) TimeUnit.SECONDS.toMillis(30));

    /* renamed from: l */
    public static final C1105e f1947l = new C1105e();

    /* renamed from: b */
    public final AtomicLong f1948b = new AtomicLong(0);

    /* renamed from: c */
    public Handler f1949c;

    /* renamed from: d */
    public final HandlerThread f1950d = new HandlerThread("applovin-anr-detector");

    /* renamed from: e */
    public Handler f1951e;

    /* renamed from: f */
    public final AtomicBoolean f1952f = new AtomicBoolean();

    /* renamed from: g */
    public final AtomicBoolean f1953g = new AtomicBoolean();

    /* renamed from: h */
    public long f1954h = TimeUnit.SECONDS.toMillis(4);

    /* renamed from: i */
    public long f1955i = TimeUnit.SECONDS.toMillis(3);

    /* renamed from: j */
    public long f1956j = TimeUnit.SECONDS.toMillis(3);

    /* renamed from: k */
    public URL f1957k = null;

    /* renamed from: com.applovin.impl.sdk.e$a */
    public class C1107a implements Runnable {
        public C1107a() {
        }

        public void run() {
            if (!C1105e.this.f1952f.get()) {
                long currentTimeMillis = System.currentTimeMillis() - C1105e.this.f1948b.get();
                if (currentTimeMillis < 0 || currentTimeMillis > C1105e.this.f1954h) {
                    C1105e.this.m1781a();
                    C1105e.this.m1784b();
                }
                C1105e.this.f1951e.postDelayed(this, C1105e.this.f1956j);
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.e$b */
    public class C1108b implements Runnable {
        public C1108b() {
        }

        public void run() {
            if (!C1105e.this.f1952f.get()) {
                C1105e.this.f1948b.set(System.currentTimeMillis());
                C1105e.this.f1949c.postDelayed(this, C1105e.this.f1955i);
            }
        }
    }

    /* renamed from: a */
    public static String m1779a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1781a() {
        if (this.f1953g.get()) {
            this.f1952f.set(true);
        }
    }

    /* renamed from: a */
    public static void m1782a(C1188m mVar) {
        if (mVar == null) {
            return;
        }
        if (((Boolean) mVar.mo10946a(C1085b.f1772eU)).booleanValue()) {
            f1947l.m1785b(mVar);
        } else {
            f1947l.m1781a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1784b() {
        try {
            if (this.f1957k != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) this.f1957k.openConnection();
                httpURLConnection.setConnectTimeout(f1946a);
                httpURLConnection.setReadTimeout(f1946a);
                httpURLConnection.setDefaultUseCaches(false);
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setDoOutput(false);
                int responseCode = httpURLConnection.getResponseCode();
                Log.d("applovin-anr-detector", "ANR reported with code " + responseCode);
            }
        } catch (Throwable th) {
            Log.w("applovin-anr-detector", "Failed to report ANR", th);
        }
    }

    /* renamed from: b */
    private void m1785b(C1188m mVar) {
        if (this.f1953g.compareAndSet(false, true)) {
            this.f1954h = ((Long) mVar.mo10946a(C1085b.f1773eV)).longValue();
            this.f1955i = ((Long) mVar.mo10946a(C1085b.f1774eW)).longValue();
            this.f1956j = ((Long) mVar.mo10946a(C1085b.f1775eX)).longValue();
            this.f1949c = new Handler(mVar.mo10932L().getMainLooper());
            this.f1957k = m1787c(mVar);
            this.f1950d.start();
            this.f1949c.post(new C1108b());
            Handler handler = new Handler(this.f1950d.getLooper());
            this.f1951e = handler;
            handler.postDelayed(new C1107a(), this.f1956j / 2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00b0 A[Catch:{ MalformedURLException -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00c0 A[Catch:{ MalformedURLException -> 0x00e7 }] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.net.URL m1787c(com.applovin.impl.sdk.C1188m r8) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            android.content.Context r1 = r8.mo10932L()
            r2 = 0
            r3 = 0
            android.content.pm.PackageManager r4 = r1.getPackageManager()     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0015 }
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r1, r3)     // Catch:{ all -> 0x0016 }
            goto L_0x0017
        L_0x0015:
            r1 = r0
        L_0x0016:
            r4 = r2
        L_0x0017:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.<init>()     // Catch:{ MalformedURLException -> 0x00e7 }
            com.applovin.impl.sdk.c.b<java.lang.String> r6 = com.applovin.impl.sdk.p027c.C1085b.f1627bf     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.Object r6 = r8.mo10946a(r6)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r6 = "?type=anr&platform="
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x00e7 }
            com.applovin.impl.sdk.o r6 = r8.mo10941V()     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r6 = r6.mo11211f()     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r6 = "&package_name="
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r1 = m1779a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r1)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r1 = "&applovin_random_token="
            r5.append(r1)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r1 = r8.mo10998o()     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r1 = m1779a((java.lang.String) r1)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r1)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r1 = "&compass_random_token="
            r5.append(r1)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = r8.mo10997n()     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = m1779a((java.lang.String) r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = "&model="
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = m1779a((java.lang.String) r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = "&brand="
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = android.os.Build.MANUFACTURER     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = m1779a((java.lang.String) r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = "&brand_name="
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = android.os.Build.BRAND     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = m1779a((java.lang.String) r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = "&hardware="
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = android.os.Build.HARDWARE     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = m1779a((java.lang.String) r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = "&revision="
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = android.os.Build.DEVICE     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = m1779a((java.lang.String) r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = "&app_version="
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            if (r4 == 0) goto L_0x00b2
            java.lang.String r0 = r4.versionName     // Catch:{ MalformedURLException -> 0x00e7 }
        L_0x00b2:
            java.lang.String r8 = m1779a((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = "&app_version_code="
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            if (r4 == 0) goto L_0x00c2
            int r3 = r4.versionCode     // Catch:{ MalformedURLException -> 0x00e7 }
        L_0x00c2:
            r5.append(r3)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = "&os="
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = m1779a((java.lang.String) r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = "&api_level="
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ MalformedURLException -> 0x00e7 }
            r5.append(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            java.lang.String r8 = r5.toString()     // Catch:{ MalformedURLException -> 0x00e7 }
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00e7 }
            r0.<init>(r8)     // Catch:{ MalformedURLException -> 0x00e7 }
            return r0
        L_0x00e7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1105e.m1787c(com.applovin.impl.sdk.m):java.net.URL");
    }
}
