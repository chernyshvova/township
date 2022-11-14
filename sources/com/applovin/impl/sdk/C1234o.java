package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.network.C1213b;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.p028d.C1104g;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1120f;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.C1258c;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.C1302l;
import com.applovin.impl.sdk.utils.C1306o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.helpshift.support.res.values.HSConsts;
import com.swrve.sdk.ISwrveCommon;
import com.swrve.sdk.SwrveAppStore;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.o */
public class C1234o {

    /* renamed from: h */
    public static String f2365h;

    /* renamed from: i */
    public static int f2366i;

    /* renamed from: j */
    public static final AtomicReference<C1240a> f2367j = new AtomicReference<>();

    /* renamed from: l */
    public static final AtomicReference<C1241b> f2368l = new AtomicReference<>();

    /* renamed from: a */
    public final C1188m f2369a;

    /* renamed from: b */
    public final C1314v f2370b;

    /* renamed from: c */
    public final Context f2371c;

    /* renamed from: d */
    public final Map<String, Object> f2372d;

    /* renamed from: e */
    public final Object f2373e = new Object();

    /* renamed from: f */
    public final Map<String, Object> f2374f;

    /* renamed from: g */
    public boolean f2375g;

    /* renamed from: k */
    public final AtomicReference<Integer> f2376k = new AtomicReference<>();

    /* renamed from: com.applovin.impl.sdk.o$a */
    public static class C1240a {

        /* renamed from: a */
        public boolean f2382a;

        /* renamed from: b */
        public String f2383b = "";
    }

    /* renamed from: com.applovin.impl.sdk.o$b */
    public static class C1241b {

        /* renamed from: a */
        public final String f2384a;

        /* renamed from: b */
        public final int f2385b;

        public C1241b(String str, int i) {
            this.f2384a = str;
            this.f2385b = i;
        }
    }

    /* renamed from: com.applovin.impl.sdk.o$c */
    public static class C1242c {

        /* renamed from: a */
        public int f2386a = -1;

        /* renamed from: b */
        public int f2387b = -1;
    }

    public C1234o(C1188m mVar) {
        if (mVar != null) {
            this.f2369a = mVar;
            this.f2370b = mVar.mo10922B();
            this.f2371c = mVar.mo10932L();
            this.f2372d = m2398s();
            this.f2374f = m2400u();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: A */
    private String m2369A() {
        AudioManager audioManager = (AudioManager) this.f2371c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (C1263g.m2509e()) {
            for (AudioDeviceInfo type : audioManager.getDevices(2)) {
                String a = m2384a(type.getType());
                if (!TextUtils.isEmpty(a)) {
                    sb.append(a);
                    sb.append(",");
                }
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append("headphones");
                sb.append(",");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append("bluetootha2dpoutput");
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            this.f2370b.mo11372b("DataCollector", "No sound outputs detected");
        }
        return sb2;
    }

    /* renamed from: B */
    private String m2370B() {
        if (!C1263g.m2510f()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList locales = this.f2371c.getResources().getConfiguration().getLocales();
            for (int i = 0; i < locales.size(); i++) {
                sb.append(locales.get(i));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r0 = (r0 = (r0 = (r0 = r2.f2369a.mo10977ao()).getWindow()).getDecorView().getRootWindowInsets()).getDisplayCutout();
     */
    /* renamed from: C */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2371C() {
        /*
            r2 = this;
            boolean r0 = com.applovin.impl.sdk.utils.C1263g.m2511g()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            com.applovin.impl.sdk.m r0 = r2.f2369a
            android.app.Activity r0 = r0.mo10977ao()
            if (r0 != 0) goto L_0x0011
            return r1
        L_0x0011:
            android.view.Window r0 = r0.getWindow()
            if (r0 != 0) goto L_0x0018
            return r1
        L_0x0018:
            android.view.View r0 = r0.getDecorView()
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 != 0) goto L_0x0023
            return r1
        L_0x0023:
            android.view.DisplayCutout r0 = r0.getDisplayCutout()
            if (r0 != 0) goto L_0x002a
            return r1
        L_0x002a:
            int r0 = r0.getSafeInsetTop()
            if (r0 <= 0) goto L_0x0031
            r1 = 1
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1234o.m2371C():boolean");
    }

    /* access modifiers changed from: private */
    @Nullable
    /* renamed from: D */
    public Integer m2372D() {
        AudioManager audioManager = (AudioManager) this.f2371c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Integer.valueOf((int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.f2369a.mo10946a(C1085b.f1712dM)).floatValue()));
    }

    /* renamed from: E */
    private double m2373E() {
        double offset = (double) TimeZone.getDefault().getOffset(new Date().getTime());
        Double.isNaN(offset);
        double round = (double) Math.round((offset * 10.0d) / 3600000.0d);
        Double.isNaN(round);
        return round / 10.0d;
    }

    /* renamed from: F */
    private boolean m2374F() {
        if (m2394d(this.f2371c)) {
            return true;
        }
        return this.f2371c.getPackageManager().hasSystemFeature(C1263g.m2508d() ? "android.software.leanback" : "android.hardware.type.television");
    }

    /* renamed from: G */
    private boolean m2375G() {
        SensorManager sensorManager = (SensorManager) this.f2371c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    /* renamed from: H */
    private String m2376H() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2371c.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    /* renamed from: I */
    private String m2377I() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2371c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            this.f2370b.mo11373b("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    /* renamed from: J */
    private String m2378J() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2371c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            this.f2370b.mo11373b("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    /* renamed from: K */
    private String m2379K() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2371c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            this.f2370b.mo11373b("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    /* renamed from: L */
    private boolean m2380L() {
        try {
            return m2381M() || m2382N();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: M */
    private boolean m2381M() {
        String str = Build.TAGS;
        return str != null && str.contains(m2390b("lz}$blpz"));
    }

    /* renamed from: N */
    private boolean m2382N() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i = 0; i < 9; i++) {
            if (new File(m2390b(strArr[i])).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private String m2384a(int i) {
        if (i == 1) {
            return "receiver";
        }
        if (i == 2) {
            return "speaker";
        }
        if (i == 4 || i == 3) {
            return "headphones";
        }
        if (i == 8) {
            return "bluetootha2dpoutput";
        }
        if (i == 13 || i == 19 || i == 5 || i == 6 || i == 12 || i == 11) {
            return "lineout";
        }
        if (i == 9 || i == 10) {
            return "hdmioutput";
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01a7 A[SYNTHETIC, Splitter:B:50:0x01a7] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0387  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.Object> m2385a(java.util.Map<java.lang.String, java.lang.Object> r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "tds"
            java.lang.String r1 = "fs"
            java.lang.String r2 = "DataCollector"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>(r7)
            android.content.Context r7 = r6.f2371c
            android.graphics.Point r7 = com.applovin.impl.sdk.utils.C1263g.m2503a(r7)
            int r4 = r7.x
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "dx"
            r3.put(r5, r4)
            int r7 = r7.y
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r4 = "dy"
            r3.put(r4, r7)
            if (r8 == 0) goto L_0x004a
            java.util.concurrent.atomic.AtomicReference<com.applovin.impl.sdk.o$a> r7 = f2367j
            java.lang.Object r7 = r7.get()
            com.applovin.impl.sdk.o$a r7 = (com.applovin.impl.sdk.C1234o.C1240a) r7
            if (r7 == 0) goto L_0x0037
            r6.mo11220o()
            goto L_0x0054
        L_0x0037:
            boolean r7 = com.applovin.impl.sdk.utils.Utils.isMainThread()
            if (r7 == 0) goto L_0x004a
            com.applovin.impl.sdk.o$a r7 = new com.applovin.impl.sdk.o$a
            r7.<init>()
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            java.lang.String r5 = "inc"
            r3.put(r5, r4)
            goto L_0x0054
        L_0x004a:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.o r7 = r7.mo10941V()
            com.applovin.impl.sdk.o$a r7 = r7.mo11217l()
        L_0x0054:
            java.lang.String r4 = r7.f2383b
            boolean r5 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r4)
            if (r5 == 0) goto L_0x0061
            java.lang.String r5 = "idfa"
            r3.put(r5, r4)
        L_0x0061:
            boolean r7 = r7.f2382a
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r4 = "dnt"
            r3.put(r4, r7)
            java.util.concurrent.atomic.AtomicReference<com.applovin.impl.sdk.o$b> r7 = f2368l
            java.lang.Object r7 = r7.get()
            com.applovin.impl.sdk.o$b r7 = (com.applovin.impl.sdk.C1234o.C1241b) r7
            com.applovin.impl.sdk.m r4 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r5 = com.applovin.impl.sdk.p027c.C1085b.f1744ds
            java.lang.Object r4 = r4.mo10946a(r5)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0098
            if (r7 == 0) goto L_0x0098
            java.lang.String r4 = r7.f2384a
            java.lang.String r5 = "idfv"
            r3.put(r5, r4)
            int r7 = r7.f2385b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r4 = "idfv_scope"
            r3.put(r4, r7)
        L_0x0098:
            com.applovin.impl.sdk.j$a r7 = com.applovin.impl.sdk.C1173j.m2018b()
            android.content.Context r4 = r6.f2371c
            java.lang.Boolean r7 = r7.mo10902a((android.content.Context) r4)
            if (r7 == 0) goto L_0x00a9
            java.lang.String r4 = "huc"
            r3.put(r4, r7)
        L_0x00a9:
            com.applovin.impl.sdk.j$a r7 = com.applovin.impl.sdk.C1173j.m2013a()
            android.content.Context r4 = r6.f2371c
            java.lang.Boolean r7 = r7.mo10902a((android.content.Context) r4)
            if (r7 == 0) goto L_0x00ba
            java.lang.String r4 = "aru"
            r3.put(r4, r7)
        L_0x00ba:
            com.applovin.impl.sdk.j$a r7 = com.applovin.impl.sdk.C1173j.m2020c()
            android.content.Context r4 = r6.f2371c
            java.lang.Boolean r7 = r7.mo10902a((android.content.Context) r4)
            if (r7 == 0) goto L_0x00cb
            java.lang.String r4 = "dns"
            r3.put(r4, r7)
        L_0x00cb:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.p027c.C1085b.f1701dB
            java.lang.Object r7 = r7.mo10946a(r4)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00f5
            com.applovin.impl.sdk.o$c r7 = r6.m2403x()
            int r4 = r7.f2386a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "act"
            r3.put(r5, r4)
            int r7 = r7.f2387b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r4 = "acm"
            r3.put(r4, r7)
        L_0x00f5:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.p027c.C1085b.f1709dJ
            java.lang.Object r7 = r7.mo10946a(r4)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0118
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.z r7 = r7.mo10965ac()
            int r7 = r7.mo11387b()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r4 = "mtl"
            r3.put(r4, r7)
        L_0x0118:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.p027c.C1085b.f1711dL
            java.lang.Object r7 = r7.mo10946a(r4)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0135
            boolean r7 = r6.m2380L()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r4 = "adr"
            r3.put(r4, r7)
        L_0x0135:
            if (r8 == 0) goto L_0x0140
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r7 = r6.f2376k
            java.lang.Object r7 = r7.get()
            java.lang.Integer r7 = (java.lang.Integer) r7
            goto L_0x0144
        L_0x0140:
            java.lang.Integer r7 = r6.m2372D()
        L_0x0144:
            if (r7 == 0) goto L_0x014c
            java.lang.String r8 = "volume"
            r3.put(r8, r7)
        L_0x014c:
            android.content.Context r7 = r6.f2371c     // Catch:{ SettingNotFoundException -> 0x016b }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x016b }
            java.lang.String r8 = "screen_brightness"
            int r7 = android.provider.Settings.System.getInt(r7, r8)     // Catch:{ SettingNotFoundException -> 0x016b }
            float r7 = (float) r7     // Catch:{ SettingNotFoundException -> 0x016b }
            r8 = 1132396544(0x437f0000, float:255.0)
            float r7 = r7 / r8
            java.lang.String r8 = "sb"
            r4 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 * r4
            int r7 = (int) r7     // Catch:{ SettingNotFoundException -> 0x016b }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ SettingNotFoundException -> 0x016b }
            r3.put(r8, r7)     // Catch:{ SettingNotFoundException -> 0x016b }
            goto L_0x0173
        L_0x016b:
            r7 = move-exception
            com.applovin.impl.sdk.v r8 = r6.f2370b
            java.lang.String r4 = "Unable to collect screen brightness"
            r8.mo11373b(r2, r4, r7)
        L_0x0173:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p027c.C1085b.f1714dO
            java.lang.Object r7 = r7.mo10946a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0197
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.C1046ac.m1445b(r7)
            java.lang.String r7 = com.applovin.impl.sdk.C1046ac.m1440a()
            boolean r8 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r7)
            if (r8 == 0) goto L_0x0197
            java.lang.String r8 = "ua"
            r3.put(r8, r7)
        L_0x0197:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p027c.C1085b.f1703dD
            java.lang.Object r7 = r7.mo10946a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x01dd
            java.io.File r7 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x01c6 }
            long r7 = r7.getFreeSpace()     // Catch:{ all -> 0x01c6 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x01c6 }
            r3.put(r1, r7)     // Catch:{ all -> 0x01c6 }
            java.io.File r7 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x01c6 }
            long r7 = r7.getTotalSpace()     // Catch:{ all -> 0x01c6 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x01c6 }
            r3.put(r0, r7)     // Catch:{ all -> 0x01c6 }
            goto L_0x01dd
        L_0x01c6:
            r7 = move-exception
            r8 = -1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r3.put(r1, r4)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r3.put(r0, r8)
            com.applovin.impl.sdk.v r8 = r6.f2370b
            java.lang.String r0 = "Unable to collect total & free space."
            r8.mo11373b(r2, r0, r7)
        L_0x01dd:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p027c.C1085b.f1704dE
            java.lang.Object r7 = r7.mo10946a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x022d
            android.content.Context r7 = r6.f2371c
            java.lang.String r8 = "activity"
            java.lang.Object r7 = r7.getSystemService(r8)
            android.app.ActivityManager r7 = (android.app.ActivityManager) r7
            android.app.ActivityManager$MemoryInfo r8 = new android.app.ActivityManager$MemoryInfo
            r8.<init>()
            if (r7 == 0) goto L_0x022d
            r7.getMemoryInfo(r8)
            long r0 = r8.availMem
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "fm"
            r3.put(r0, r7)
            long r0 = r8.totalMem
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "tm"
            r3.put(r0, r7)
            long r0 = r8.threshold
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = "lmt"
            r3.put(r0, r7)
            boolean r7 = r8.lowMemory
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "lm"
            r3.put(r8, r7)
        L_0x022d:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p027c.C1085b.f1705dF
            java.lang.Object r7 = r7.mo10946a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0264
            android.content.Context r7 = r6.f2371c
            java.lang.String r8 = "android.permission.READ_PHONE_STATE"
            boolean r7 = com.applovin.impl.sdk.utils.C1263g.m2505a(r8, r7)
            if (r7 == 0) goto L_0x0264
            boolean r7 = com.applovin.impl.sdk.utils.C1263g.m2510f()
            if (r7 == 0) goto L_0x0264
            android.content.Context r7 = r6.f2371c
            java.lang.String r8 = "phone"
            java.lang.Object r7 = r7.getSystemService(r8)
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7
            int r7 = r7.getDataNetworkType()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "rat"
            r3.put(r8, r7)
        L_0x0264:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.c r7 = r7.mo10931K()
            com.applovin.impl.sdk.c.b<java.lang.String> r8 = com.applovin.impl.sdk.p027c.C1085b.f1716dQ
            java.lang.Object r7 = r7.mo10678a(r8)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = f2365h
            boolean r8 = r7.equalsIgnoreCase(r8)
            java.lang.String r0 = "wvvc"
            if (r8 != 0) goto L_0x029b
            r8 = 0
            f2365h = r7     // Catch:{ all -> 0x0298 }
            android.content.Context r1 = r6.f2371c     // Catch:{ all -> 0x0298 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x0298 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r8)     // Catch:{ all -> 0x0298 }
            int r1 = r7.versionCode     // Catch:{ all -> 0x0298 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0298 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0298 }
            int r7 = r7.versionCode     // Catch:{ all -> 0x0298 }
            f2366i = r7     // Catch:{ all -> 0x0298 }
            goto L_0x02a4
        L_0x0298:
            f2366i = r8
            goto L_0x02a4
        L_0x029b:
            int r7 = f2366i
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3.put(r0, r7)
        L_0x02a4:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p027c.C1085b.f1702dC
            java.lang.Object r7 = r7.mo10946a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x02c3
            java.lang.String r7 = r6.m2369A()
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x02c3
            java.lang.String r8 = "so"
            r3.put(r8, r7)
        L_0x02c3:
            java.lang.String r7 = r6.m2399t()
            java.lang.String r8 = "orientation_lock"
            r3.put(r8, r7)
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p027c.C1085b.f1706dG
            java.lang.Object r7 = r7.mo10946a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x02ea
            boolean r7 = com.applovin.impl.sdk.utils.Utils.isVPNConnected()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "vs"
            r3.put(r8, r7)
        L_0x02ea:
            boolean r7 = com.applovin.impl.sdk.utils.C1263g.m2508d()
            if (r7 == 0) goto L_0x0309
            android.content.Context r7 = r6.f2371c
            java.lang.String r8 = "power"
            java.lang.Object r7 = r7.getSystemService(r8)
            android.os.PowerManager r7 = (android.os.PowerManager) r7
            if (r7 == 0) goto L_0x0309
            boolean r7 = r7.isPowerSaveMode()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "lpm"
            r3.put(r8, r7)
        L_0x0309:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p027c.C1085b.f1717dR
            java.lang.Object r7 = r7.mo10946a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0334
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.utils.m r7 = r7.mo10970ah()
            if (r7 == 0) goto L_0x0334
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.utils.m r7 = r7.mo10970ah()
            float r7 = r7.mo11330c()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.String r8 = "da"
            r3.put(r8, r7)
        L_0x0334:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.p027c.C1085b.f1718dS
            java.lang.Object r7 = r7.mo10946a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x035f
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.utils.m r7 = r7.mo10970ah()
            if (r7 == 0) goto L_0x035f
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.utils.m r7 = r7.mo10970ah()
            float r7 = r7.mo11329b()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.String r8 = "dm"
            r3.put(r8, r7)
        L_0x035f:
            com.applovin.impl.sdk.m r7 = r6.f2369a
            com.applovin.impl.sdk.h r7 = r7.mo10971ai()
            int r7 = r7.mo10887a()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "mute_switch"
            r3.put(r8, r7)
            com.applovin.impl.sdk.m r7 = r6.f2369a
            java.lang.String r7 = com.applovin.impl.sdk.utils.C1264h.m2529f(r7)
            java.lang.String r8 = "network"
            r3.put(r8, r7)
            java.lang.String r7 = r6.m2370B()
            boolean r8 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r7)
            if (r8 == 0) goto L_0x038c
            java.lang.String r8 = "kb"
            r3.put(r8, r7)
        L_0x038c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1234o.m2385a(java.util.Map, boolean):java.util.Map");
    }

    /* renamed from: a */
    public static void m2386a(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                C1234o.f2367j.set(C1258c.m2488a(context));
            }
        }).start();
    }

    /* renamed from: a */
    private void m2387a(Map<String, Object> map) {
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1707dH)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(m2404y()));
        }
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1708dI)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(m2405z()));
        }
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1715dP)).booleanValue()) {
            C1046ac.m1447c(this.f2369a);
        }
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1714dO)).booleanValue()) {
            C1046ac.m1445b(this.f2369a);
        }
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1713dN)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1710dK)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(m2402w()));
        }
        map.put("htn", Boolean.valueOf(m2371C()));
    }

    /* renamed from: a */
    private boolean m2388a(String str) {
        try {
            return Settings.Secure.getInt(this.f2371c.getContentResolver(), str) == 1;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m2389a(String str, String str2) {
        for (String startsWith : CollectionUtils.explode(str2)) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private String m2390b(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = 9; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static boolean m2392b(Context context) {
        return SwrveAppStore.Amazon.equalsIgnoreCase(Build.MANUFACTURER) || m2394d(context);
    }

    /* renamed from: c */
    public static void m2393c(final Context context) {
        if (Utils.checkClassExistence("com.google.android.gms.appset.AppSet")) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() {
                            /* renamed from: a */
                            public void onSuccess(AppSetIdInfo appSetIdInfo) {
                                C1234o.f2368l.set(new C1241b(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                            }
                        });
                    } catch (Throwable unused) {
                        C1314v.m2660f("DataCollector", "Could not collect AppSet ID.");
                    }
                }
            }).start();
        } else {
            C1314v.m2660f("DataCollector", "Could not collect AppSet ID.");
        }
    }

    /* renamed from: d */
    public static boolean m2394d(Context context) {
        return context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
    }

    /* renamed from: r */
    private Map<String, String> m2397r() {
        return Utils.stringifyObjectMap(mo11205a((Map<String, String>) null, true, false));
    }

    /* renamed from: s */
    private Map<String, Object> m2398s() {
        Map<String, String> metaData;
        HashMap hashMap = new HashMap(32);
        hashMap.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("brand_name", Build.BRAND);
        hashMap.put("hardware", Build.HARDWARE);
        hashMap.put("sim", Boolean.valueOf(mo11219n()));
        hashMap.put("aida", Boolean.valueOf(C1258c.m2489a()));
        hashMap.put("locale", Locale.getDefault().toString());
        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("platform", mo11211f());
        hashMap.put("revision", Build.DEVICE);
        hashMap.put("tz_offset", Double.valueOf(m2373E()));
        hashMap.put("gy", Boolean.valueOf(m2375G()));
        hashMap.put("country_code", m2376H());
        hashMap.put("mcc", m2377I());
        hashMap.put("mnc", m2378J());
        hashMap.put("carrier", m2379K());
        hashMap.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.f2371c)));
        hashMap.put(ISwrveCommon.DEVICE_TYPE_TV, Boolean.valueOf(m2374F()));
        DisplayMetrics displayMetrics = this.f2371c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            hashMap.put("adns", Float.valueOf(displayMetrics.density));
            hashMap.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            hashMap.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            hashMap.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            Point a = C1263g.m2503a(this.f2371c);
            double sqrt = Math.sqrt(Math.pow((double) a.y, 2.0d) + Math.pow((double) a.x, 2.0d));
            double d = (double) displayMetrics.xdpi;
            Double.isNaN(d);
            hashMap.put("screen_size_in", Double.valueOf(sqrt / d));
        }
        hashMap.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        if (this.f2369a.mo10990g() && (metaData = Utils.getMetaData(this.f2369a.mo10999p())) != null) {
            String str = metaData.get("GraphicsMemorySizeMegabytes");
            if (StringUtils.isValidString(str)) {
                try {
                    hashMap.put("gms_mb", Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException unused) {
                    C1314v vVar = this.f2370b;
                    vVar.mo11376e("DataCollector", "Graphics memory size megabytes couldn't be parsed to an integer: " + str);
                }
            }
        }
        m2387a((Map<String, Object>) hashMap);
        return hashMap;
    }

    /* renamed from: t */
    private String m2399t() {
        int orientation = Utils.getOrientation(this.f2371c);
        return orientation == 1 ? "portrait" : orientation == 2 ? "landscape" : IntegrityManager.INTEGRITY_TYPE_NONE;
    }

    /* renamed from: u */
    private Map<String, Object> m2400u() {
        PackageInfo packageInfo;
        HashMap hashMap = new HashMap(20);
        PackageManager packageManager = this.f2371c.getPackageManager();
        ApplicationInfo applicationInfo = this.f2371c.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        String str = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f2371c.getPackageName(), 0);
            try {
                str = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        hashMap.put("app_name", packageManager.getApplicationLabel(applicationInfo));
        Object obj = "";
        hashMap.put("app_version", packageInfo != null ? packageInfo.versionName : obj);
        hashMap.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        hashMap.put("package_name", applicationInfo.packageName);
        hashMap.put("vz", StringUtils.toShortSHA1Hash(applicationInfo.packageName));
        if (str == null) {
            str = obj;
        }
        hashMap.put("installer_name", str);
        hashMap.put("tg", C1306o.m2623a(this.f2369a));
        hashMap.put(GraphRequest.DEBUG_PARAM, Boolean.valueOf(Utils.isPubInDebugMode(this.f2369a.mo10932L())));
        hashMap.put(HSConsts.ISSUE_ARCHIVAL_KEY, Long.valueOf(lastModified));
        Long l = (Long) this.f2369a.mo10947a(C1087d.f1821d);
        if (l != null) {
            hashMap.put("ia_v2", l);
        } else {
            this.f2369a.mo10953a(C1087d.f1821d, Long.valueOf(lastModified));
        }
        hashMap.put(FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, AppLovinSdk.VERSION);
        hashMap.put("omid_sdk_version", this.f2369a.mo10975am().mo10475c());
        String userEngagementSdkVersion = Utils.getUserEngagementSdkVersion();
        if (StringUtils.isValidString(userEngagementSdkVersion)) {
            hashMap.put("ue_sdk_version", userEngagementSdkVersion);
        }
        hashMap.put("api_did", this.f2369a.mo10946a(C1085b.f1572ad));
        hashMap.put("first_install", Boolean.valueOf(this.f2369a.mo10935P()));
        hashMap.put("first_install_v2", Boolean.valueOf(!this.f2369a.mo10936Q()));
        if (packageInfo != null) {
            obj = Long.valueOf(packageInfo.firstInstallTime);
        }
        hashMap.put("first_install_v3_ms", obj);
        hashMap.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        hashMap.put("epv", Integer.valueOf(Utils.tryToGetExoPlayerVersionCode()));
        return hashMap;
    }

    /* renamed from: v */
    private Map<String, Object> m2401v() {
        HashMap hashMap = new HashMap(2);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f2371c);
        String str = (String) this.f2369a.mo10979b(C1087d.f1831n, null, defaultSharedPreferences);
        if (StringUtils.isValidString(str)) {
            hashMap.put("IABTCF_TCString", str);
        }
        Object obj = defaultSharedPreferences.getAll().get(C1087d.f1832o.mo10687a());
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean)) {
            hashMap.put("IABTCF_gdprApplies", obj);
        }
        return hashMap;
    }

    /* renamed from: w */
    private boolean m2402w() {
        ConnectivityManager connectivityManager;
        if (C1263g.m2510f() && (connectivityManager = (ConnectivityManager) this.f2371c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                this.f2369a.mo10922B().mo11373b("DataCollector", "Unable to collect constrained network info.", th);
            }
        }
        return false;
    }

    /* renamed from: x */
    private C1242c m2403x() {
        C1242c cVar = new C1242c();
        Intent registerReceiver = this.f2371c.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = -1;
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : -1;
        int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.f2387b = -1;
        } else {
            cVar.f2387b = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
        }
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        cVar.f2386a = i;
        return cVar;
    }

    /* renamed from: y */
    private long m2404y() {
        List asList = Arrays.asList(StringUtils.emptyIfNull(Settings.Secure.getString(this.f2371c.getContentResolver(), "enabled_accessibility_services")).split(CertificateUtil.DELIMITER));
        long j = asList.contains("AccessibilityMenuService") ? 256 : 0;
        if (asList.contains("SelectToSpeakService")) {
            j |= 512;
        }
        if (asList.contains("SoundAmplifierService")) {
            j |= 2;
        }
        if (asList.contains("SpeechToTextAccessibilityService")) {
            j |= 128;
        }
        if (asList.contains("SwitchAccessService")) {
            j |= 4;
        }
        if ((this.f2371c.getResources().getConfiguration().uiMode & 48) == 32) {
            j |= 1024;
        }
        if (m2388a("accessibility_enabled")) {
            j |= 8;
        }
        if (m2388a("touch_exploration_enabled")) {
            j |= 16;
        }
        if (!C1263g.m2508d()) {
            return j;
        }
        if (m2388a("accessibility_display_inversion_enabled")) {
            j |= 32;
        }
        return m2388a("skip_first_use_hints") ? j | 64 : j;
    }

    /* renamed from: z */
    private float m2405z() {
        try {
            return Settings.System.getFloat(this.f2371c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            this.f2370b.mo11373b("DataCollector", "Error collecting font scale", e);
            return -1.0f;
        }
    }

    /* renamed from: a */
    public String mo11204a() {
        String encodeToString = Base64.encodeToString(new JSONObject(m2397r()).toString().getBytes(Charset.defaultCharset()), 2);
        if (!((Boolean) this.f2369a.mo10946a(C1085b.f1798eu)).booleanValue()) {
            return encodeToString;
        }
        return C1302l.m2600a(encodeToString, this.f2369a.mo11010z(), Utils.getServerAdjustedUnixTimestampMillis(this.f2369a));
    }

    /* renamed from: a */
    public Map<String, Object> mo11205a(@Nullable Map<String, String> map, boolean z, boolean z2) {
        HashMap hashMap = new HashMap(64);
        Map<String, Object> a = mo11206a(z);
        Map<String, Object> h = mo11213h();
        Map<String, Object> j = mo11215j();
        Map<String, Object> k = mo11216k();
        Map<String, String> a2 = this.f2369a.mo11001r().mo10868a();
        if (z2) {
            hashMap.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, a);
            hashMap.put("app_info", h);
            if (j != null) {
                hashMap.put("connection_info", j);
            }
            if (map != null) {
                hashMap.put("ad_info", map);
            }
            if (k != null) {
                hashMap.put("location_info", k);
            }
            if (a2 != null) {
                hashMap.put("targeting_data", a2);
            }
        } else {
            hashMap.putAll(a);
            hashMap.putAll(h);
            if (j != null) {
                hashMap.putAll(j);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
            if (k != null) {
                hashMap.putAll(k);
            }
            if (a2 != null) {
                hashMap.putAll(a2);
            }
        }
        hashMap.put("accept", "custom_size,launch_app,video");
        hashMap.put(GraphRequest.FORMAT_PARAM, GraphRequest.FORMAT_JSON);
        Utils.putObjectForStringIfValid("mediation_provider", this.f2369a.mo11003t(), hashMap);
        Utils.putObjectForStringIfValid("plugin_version", (String) this.f2369a.mo10946a(C1085b.f1700dA), hashMap);
        if (!((Boolean) this.f2369a.mo10946a(C1085b.f1797et)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2369a.mo11010z());
        }
        hashMap.putAll(mo11214i());
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1780ec)).booleanValue()) {
            C1104g T = this.f2369a.mo10939T();
            hashMap.put("li", Long.valueOf(T.mo10760b(C1103f.f1924b)));
            hashMap.put("si", Long.valueOf(T.mo10760b(C1103f.f1926d)));
            hashMap.put("pf", Long.valueOf(T.mo10760b(C1103f.f1930h)));
            hashMap.put("mpf", Long.valueOf(T.mo10760b(C1103f.f1937o)));
            hashMap.put("gpf", Long.valueOf(T.mo10760b(C1103f.f1931i)));
            hashMap.put("asoac", Long.valueOf(T.mo10760b(C1103f.f1935m)));
        }
        hashMap.put("rid", UUID.randomUUID().toString());
        return hashMap;
    }

    /* renamed from: a */
    public Map<String, Object> mo11206a(boolean z) {
        HashMap hashMap;
        synchronized (this.f2373e) {
            hashMap = new HashMap(this.f2372d);
        }
        return m2385a((Map<String, Object>) hashMap, z);
    }

    /* renamed from: b */
    public Map<String, Object> mo11207b() {
        return new HashMap(this.f2372d);
    }

    /* renamed from: c */
    public Map<String, Object> mo11208c() {
        return new HashMap(this.f2374f);
    }

    /* renamed from: d */
    public Map<String, Object> mo11209d() {
        return mo11206a(false);
    }

    /* renamed from: e */
    public void mo11210e() {
        synchronized (this.f2373e) {
            m2387a(this.f2372d);
        }
    }

    /* renamed from: f */
    public String mo11211f() {
        return m2392b(this.f2371c) ? "fireos" : "android";
    }

    /* renamed from: g */
    public boolean mo11212g() {
        return this.f2375g;
    }

    /* renamed from: h */
    public Map<String, Object> mo11213h() {
        HashMap hashMap = new HashMap(this.f2374f);
        hashMap.put("test_ads", Boolean.valueOf(this.f2375g));
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1745dt)).booleanValue()) {
            Utils.putObjectForStringIfValid("cuid", this.f2369a.mo10996m(), hashMap);
        }
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1748dw)).booleanValue()) {
            hashMap.put("compass_random_token", this.f2369a.mo10997n());
        }
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1750dy)).booleanValue()) {
            hashMap.put("applovin_random_token", this.f2369a.mo10998o());
        }
        String name = this.f2369a.mo11000q().getName();
        if (StringUtils.isValidString(name)) {
            hashMap.put("user_segment_name", name);
        }
        hashMap.putAll(m2401v());
        return hashMap;
    }

    /* renamed from: i */
    public Map<String, Object> mo11214i() {
        HashMap hashMap = new HashMap(5);
        hashMap.put("sc", this.f2369a.mo10946a(C1085b.f1577ai));
        hashMap.put("sc2", this.f2369a.mo10946a(C1085b.f1578aj));
        hashMap.put("sc3", this.f2369a.mo10946a(C1085b.f1579ak));
        hashMap.put("server_installed_at", this.f2369a.mo10946a(C1085b.f1580al));
        Utils.putObjectForStringIfValid("persisted_data", (String) this.f2369a.mo10947a(C1087d.f1814A), hashMap);
        return hashMap;
    }

    @Nullable
    /* renamed from: j */
    public Map<String, Object> mo11215j() {
        C1213b.C1215b a = this.f2369a.mo10937R().mo11094a();
        if (a == null) {
            return null;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("lrm_ts_ms", Long.valueOf(a.mo11098a()));
        hashMap.put("lrm_url", a.mo11099b());
        hashMap.put("lrm_ct_ms", Long.valueOf(a.mo11101d()));
        hashMap.put("lrm_rs", Long.valueOf(a.mo11100c()));
        return hashMap;
    }

    @Nullable
    /* renamed from: k */
    public Map<String, Object> mo11216k() {
        if (!this.f2369a.mo10999p().isLocationCollectionEnabled() || !((Boolean) this.f2369a.mo10946a(C1085b.f1725dZ)).booleanValue()) {
            return null;
        }
        HashMap hashMap = new HashMap(4);
        C1252u an = this.f2369a.mo10976an();
        boolean b = an.mo11260b();
        hashMap.put("loc_services_enabled", Boolean.valueOf(b));
        if (!b) {
            return hashMap;
        }
        hashMap.put("loc_auth", Boolean.valueOf(an.mo11259a()));
        C1251t c = an.mo11261c();
        if (c != null) {
            hashMap.put("loc_lat", Utils.formatDoubleValue(c.mo11256a(), ((Integer) this.f2369a.mo10946a(C1085b.f1779eb)).intValue()));
            hashMap.put("loc_long", Utils.formatDoubleValue(c.mo11257b(), ((Integer) this.f2369a.mo10946a(C1085b.f1779eb)).intValue()));
        }
        return hashMap;
    }

    /* renamed from: l */
    public C1240a mo11217l() {
        C1240a a = C1258c.m2488a(this.f2371c);
        if (((Boolean) this.f2369a.mo10946a(C1085b.f1743dr)).booleanValue()) {
            if (a.f2382a && !((Boolean) this.f2369a.mo10946a(C1085b.f1742dq)).booleanValue()) {
                a.f2383b = "";
            }
            f2367j.set(a);
        } else {
            a = new C1240a();
        }
        this.f2375g = StringUtils.isValidString(a.f2383b) ? this.f2369a.mo10999p().getTestDeviceAdvertisingIds().contains(a.f2383b) : false;
        return a;
    }

    @Nullable
    /* renamed from: m */
    public C1241b mo11218m() {
        return f2368l.get();
    }

    /* renamed from: n */
    public boolean mo11219n() {
        return m2389a(Build.DEVICE, "goldfish,vbox") || m2389a(Build.HARDWARE, "ranchu,generic,vbox") || m2389a(Build.MANUFACTURER, "Genymotion") || m2389a(Build.MODEL, "Android SDK built for x86");
    }

    /* renamed from: o */
    public void mo11220o() {
        this.f2369a.mo10938S().mo10829a((C1109a) new C1120f(this.f2369a, new C1120f.C1121a() {
            /* renamed from: a */
            public void mo10803a(C1240a aVar) {
                C1234o.f2367j.set(aVar);
            }
        }), C1140o.C1142a.ADVERTISING_INFO_COLLECTION);
        this.f2369a.mo10938S().mo10829a((C1109a) new C1166z(this.f2369a, true, new Runnable() {
            public void run() {
                C1234o.this.f2376k.set(C1234o.this.m2372D());
            }
        }), C1140o.C1142a.CACHING_OTHER);
    }
}
