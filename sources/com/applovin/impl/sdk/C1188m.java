package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.adview.C0740d;
import com.applovin.impl.mediation.C0868d;
import com.applovin.impl.mediation.C0948e;
import com.applovin.impl.mediation.C0949f;
import com.applovin.impl.mediation.C0996h;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.debugger.C0873a;
import com.applovin.impl.mediation.debugger.p017ui.testmode.C0947b;
import com.applovin.impl.mediation.p010a.C0806f;
import com.applovin.impl.mediation.p012c.C0866b;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.C1213b;
import com.applovin.impl.sdk.network.C1219d;
import com.applovin.impl.sdk.network.C1222f;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.p024a.C1021f;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p027c.C1086c;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p027c.C1088e;
import com.applovin.impl.sdk.p028d.C1095c;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.p028d.C1104g;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1127i;
import com.applovin.impl.sdk.p029e.C1137n;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.C1303m;
import com.applovin.impl.sdk.utils.C1306o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTargetingData;
import com.applovin.sdk.AppLovinUserSegment;
import com.applovin.sdk.AppLovinUserService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.m */
public class C1188m {

    /* renamed from: a */
    public static Context f2157a;

    /* renamed from: c */
    public static C1008a f2158c;

    /* renamed from: A */
    public C1095c f2159A;

    /* renamed from: B */
    public C1319z f2160B;

    /* renamed from: C */
    public C1248s f2161C;

    /* renamed from: D */
    public C1318y f2162D;

    /* renamed from: E */
    public C1219d f2163E;

    /* renamed from: F */
    public C1172i f2164F;

    /* renamed from: G */
    public C1303m f2165G;

    /* renamed from: H */
    public C1169h f2166H;

    /* renamed from: I */
    public C1243p f2167I;

    /* renamed from: J */
    public C1194n f2168J;

    /* renamed from: K */
    public C1021f f2169K;

    /* renamed from: L */
    public C1252u f2170L;

    /* renamed from: M */
    public PostbackServiceImpl f2171M;

    /* renamed from: N */
    public C1222f f2172N;

    /* renamed from: O */
    public C0949f f2173O;

    /* renamed from: P */
    public C0948e f2174P;

    /* renamed from: Q */
    public MediationServiceImpl f2175Q;

    /* renamed from: R */
    public C0996h f2176R;

    /* renamed from: S */
    public C0873a f2177S;

    /* renamed from: T */
    public C1316w f2178T;

    /* renamed from: U */
    public C0868d f2179U;

    /* renamed from: V */
    public C0947b f2180V;

    /* renamed from: W */
    public List<MaxAdFormat> f2181W;

    /* renamed from: X */
    public final Object f2182X = new Object();

    /* renamed from: Y */
    public final AtomicBoolean f2183Y = new AtomicBoolean(true);

    /* renamed from: Z */
    public boolean f2184Z = false;

    /* renamed from: aa */
    public boolean f2185aa = false;

    /* renamed from: ab */
    public boolean f2186ab = false;

    /* renamed from: ac */
    public boolean f2187ac = false;

    /* renamed from: ad */
    public boolean f2188ad = false;

    /* renamed from: ae */
    public int f2189ae = 0;

    /* renamed from: af */
    public AppLovinSdk.SdkInitializationListener f2190af;

    /* renamed from: ag */
    public AppLovinSdk.SdkInitializationListener f2191ag;

    /* renamed from: ah */
    public AppLovinSdkConfiguration f2192ah;

    /* renamed from: b */
    public C1086c f2193b;

    /* renamed from: d */
    public String f2194d;

    /* renamed from: e */
    public WeakReference<Activity> f2195e;

    /* renamed from: f */
    public long f2196f;

    /* renamed from: g */
    public AppLovinSdkSettings f2197g;

    /* renamed from: h */
    public AppLovinUserSegment f2198h;

    /* renamed from: i */
    public AppLovinTargetingData f2199i;

    /* renamed from: j */
    public String f2200j;

    /* renamed from: k */
    public AppLovinAdServiceImpl f2201k;

    /* renamed from: l */
    public AppLovinNativeAdService f2202l;

    /* renamed from: m */
    public EventServiceImpl f2203m;

    /* renamed from: n */
    public UserServiceImpl f2204n;

    /* renamed from: o */
    public VariableServiceImpl f2205o;

    /* renamed from: p */
    public AppLovinSdk f2206p;

    /* renamed from: q */
    public C1314v f2207q;

    /* renamed from: r */
    public C1140o f2208r;

    /* renamed from: s */
    public C1213b f2209s;

    /* renamed from: t */
    public C1104g f2210t;

    /* renamed from: u */
    public C1234o f2211u;

    /* renamed from: v */
    public C1088e f2212v;

    /* renamed from: w */
    public C1181l f2213w;

    /* renamed from: x */
    public C1306o f2214x;

    /* renamed from: y */
    public C1083c f2215y;

    /* renamed from: z */
    public C1247r f2216z;

    /* renamed from: M */
    public static Context m2053M() {
        return f2157a;
    }

    /* renamed from: a */
    public static C1008a m2054a(Context context) {
        if (f2158c == null) {
            f2158c = new C1008a(context);
        }
        return f2158c;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2058a(JSONObject jSONObject) {
        for (String i : JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList())) {
            C1314v.m2663i(AppLovinSdk.TAG, i);
        }
    }

    /* renamed from: ap */
    private void m2059ap() {
        this.f2163E.mo11141a((C1219d.C1220a) new C1219d.C1220a() {
            /* renamed from: a */
            public void mo11014a() {
                C1188m.this.f2207q.mo11374c(AppLovinSdk.TAG, "Connected to internet - re-initializing SDK");
                synchronized (C1188m.this.f2182X) {
                    if (!C1188m.this.f2184Z) {
                        C1188m.this.mo10981b();
                    }
                }
                C1188m.this.f2163E.mo11142b(this);
            }

            /* renamed from: b */
            public void mo11015b() {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<MaxAdFormat> m2061b(JSONObject jSONObject) {
        List<String> asList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(asList.size());
        for (String formatFromString : asList) {
            MaxAdFormat formatFromString2 = MaxAdFormat.formatFromString(formatFromString);
            if (formatFromString2 != null) {
                arrayList.add(formatFromString2);
            }
        }
        return arrayList;
    }

    /* renamed from: A */
    public boolean mo10921A() {
        return this.f2186ab;
    }

    /* renamed from: B */
    public C1314v mo10922B() {
        return this.f2207q;
    }

    /* renamed from: C */
    public C0949f mo10923C() {
        return this.f2173O;
    }

    /* renamed from: D */
    public C0948e mo10924D() {
        return this.f2174P;
    }

    /* renamed from: E */
    public MediationServiceImpl mo10925E() {
        return this.f2175Q;
    }

    /* renamed from: F */
    public C1316w mo10926F() {
        return this.f2178T;
    }

    /* renamed from: G */
    public C0873a mo10927G() {
        return this.f2177S;
    }

    /* renamed from: H */
    public C0996h mo10928H() {
        return this.f2176R;
    }

    /* renamed from: I */
    public C0868d mo10929I() {
        return this.f2179U;
    }

    /* renamed from: J */
    public C0947b mo10930J() {
        return this.f2180V;
    }

    /* renamed from: K */
    public C1086c mo10931K() {
        return this.f2193b;
    }

    /* renamed from: L */
    public Context mo10932L() {
        return f2157a;
    }

    /* renamed from: N */
    public Activity mo10933N() {
        WeakReference<Activity> weakReference = this.f2195e;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* renamed from: O */
    public long mo10934O() {
        return this.f2196f;
    }

    /* renamed from: P */
    public boolean mo10935P() {
        return this.f2187ac;
    }

    /* renamed from: Q */
    public boolean mo10936Q() {
        return this.f2188ad;
    }

    /* renamed from: R */
    public C1213b mo10937R() {
        return this.f2209s;
    }

    /* renamed from: S */
    public C1140o mo10938S() {
        return this.f2208r;
    }

    /* renamed from: T */
    public C1104g mo10939T() {
        return this.f2210t;
    }

    /* renamed from: U */
    public C1222f mo10940U() {
        return this.f2172N;
    }

    /* renamed from: V */
    public C1234o mo10941V() {
        return this.f2211u;
    }

    /* renamed from: W */
    public C1181l mo10942W() {
        return this.f2213w;
    }

    /* renamed from: X */
    public PostbackServiceImpl mo10943X() {
        return this.f2171M;
    }

    /* renamed from: Y */
    public AppLovinSdk mo10944Y() {
        return this.f2206p;
    }

    /* renamed from: Z */
    public C1083c mo10945Z() {
        return this.f2215y;
    }

    /* renamed from: a */
    public <T> T mo10946a(C1085b<T> bVar) {
        return this.f2193b.mo10678a(bVar);
    }

    /* renamed from: a */
    public <T> T mo10947a(C1087d<T> dVar) {
        return mo10978b(dVar, (Object) null);
    }

    /* renamed from: a */
    public <T> T mo10948a(String str, @Nullable T t, Class<?> cls, SharedPreferences sharedPreferences) {
        return C1088e.m1668a(str, t, (Class) cls, sharedPreferences);
    }

    /* renamed from: a */
    public void mo10949a() {
        synchronized (this.f2182X) {
            if (!this.f2184Z && !this.f2185aa) {
                mo10981b();
            }
        }
    }

    /* renamed from: a */
    public void mo10950a(long j) {
        this.f2213w.mo10912a(j);
    }

    /* renamed from: a */
    public void mo10951a(SharedPreferences sharedPreferences) {
        this.f2212v.mo10690a(sharedPreferences);
    }

    /* renamed from: a */
    public void mo10952a(C0806f fVar) {
        if (!this.f2208r.mo10832a()) {
            List<String> b = mo10980b(C1084a.f1516a);
            if (b.size() > 0 && this.f2174P.mo10233c().containsAll(b)) {
                this.f2207q.mo11372b(AppLovinSdk.TAG, "All required adapters initialized");
                this.f2208r.mo10836e();
                mo10993j();
            }
        }
    }

    /* renamed from: a */
    public <T> void mo10953a(C1087d<T> dVar, @Nullable T t) {
        this.f2212v.mo10692a(dVar, t);
    }

    /* renamed from: a */
    public <T> void mo10954a(C1087d<T> dVar, @Nullable T t, SharedPreferences sharedPreferences) {
        this.f2212v.mo10693a(dVar, t, sharedPreferences);
    }

    /* renamed from: a */
    public void mo10955a(final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (!mo10987d()) {
            this.f2190af = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    sdkInitializationListener.onSdkInitialized(C1188m.this.f2192ah);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo10956a(AppLovinSdk appLovinSdk) {
        this.f2206p = appLovinSdk;
    }

    /* renamed from: a */
    public void mo10957a(String str) {
        C1314v.m2660f(AppLovinSdk.TAG, "Setting plugin version: " + str);
        this.f2193b.mo10680a((C1085b<?>) C1085b.f1700dA, (Object) str);
        this.f2193b.mo10679a();
    }

    /* renamed from: a */
    public void mo10958a(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        C1087d<String> dVar;
        C1088e eVar;
        String str2;
        this.f2194d = str;
        this.f2196f = System.currentTimeMillis();
        this.f2197g = appLovinSdkSettings;
        this.f2198h = new C1168g();
        this.f2199i = new C1167f();
        this.f2192ah = new SdkConfigurationImpl(this);
        f2157a = context.getApplicationContext();
        if (context instanceof Activity) {
            this.f2195e = new WeakReference<>((Activity) context);
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f2212v = new C1088e(this);
        this.f2193b = new C1086c(this);
        this.f2207q = new C1314v(this);
        this.f2216z = new C1247r(this);
        this.f2215y = new C1083c(this);
        this.f2203m = new EventServiceImpl(this);
        this.f2204n = new UserServiceImpl(this);
        this.f2205o = new VariableServiceImpl(this);
        this.f2159A = new C1095c(this);
        this.f2208r = new C1140o(this);
        this.f2209s = new C1213b(this);
        this.f2210t = new C1104g(this);
        this.f2169K = new C1021f(this);
        this.f2211u = new C1234o(this);
        this.f2201k = new AppLovinAdServiceImpl(this);
        this.f2202l = new AppLovinNativeAdService(this);
        this.f2160B = new C1319z(this);
        this.f2161C = new C1248s(this);
        this.f2171M = new PostbackServiceImpl(this);
        this.f2172N = new C1222f(this);
        this.f2173O = new C0949f(this);
        this.f2174P = new C0948e(this);
        this.f2175Q = new MediationServiceImpl(this);
        this.f2178T = new C1316w(this);
        this.f2177S = new C0873a(this);
        this.f2176R = new C0996h();
        this.f2179U = new C0868d(this);
        this.f2213w = new C1181l(this);
        this.f2162D = new C1318y(this);
        this.f2165G = new C1303m(this);
        this.f2166H = new C1169h(this);
        this.f2167I = new C1243p(this);
        this.f2180V = new C0947b(this);
        this.f2168J = new C1194n(this);
        this.f2170L = new C1252u(this);
        this.f2164F = new C1172i(this);
        this.f2214x = new C1306o(this);
        this.f2211u.mo11220o();
        if (appLovinSdkSettings.isExceptionHandlerEnabled() && ((Boolean) mo10946a(C1085b.f1589au)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        if (((Boolean) mo10946a(C1085b.f1728dc)).booleanValue()) {
            this.f2163E = new C1219d(context);
        }
        if (TextUtils.isEmpty(str)) {
            this.f2186ab = true;
            C1314v.m2663i(AppLovinSdk.TAG, "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
            C1314v.m2663i(AppLovinSdk.TAG, "Called with an invalid SDK key from: " + Log.getStackTraceString(new Throwable("")));
        }
        if (str.length() != 86 && Utils.isPubInDebugMode(context)) {
            StringBuilder outline27 = GeneratedOutlineSupport.outline27("Please double-check that you entered your SDK key correctly (", str, ") : ");
            outline27.append(Log.getStackTraceString(new Throwable("")));
            C1314v.m2663i(AppLovinSdk.TAG, outline27.toString());
        }
        if (Utils.isProguardRulesOmitted()) {
            C1314v.m2663i(AppLovinSdk.TAG, "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!Utils.hasAndroidCoreJsonLibrary(this)) {
            C1314v.m2663i(AppLovinSdk.TAG, "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (!mo10921A()) {
            if (Utils.isVerboseLoggingEnabled(context)) {
                appLovinSdkSettings.setVerboseLogging(true);
            }
            mo10931K().mo10680a((C1085b<?>) C1085b.f1576ah, (Object) Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled()));
            mo10931K().mo10679a();
            Class<C0740d> cls = C0740d.class;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (TextUtils.isEmpty((String) this.f2212v.mo10697b(C1087d.f1818a, null, defaultSharedPreferences))) {
                this.f2187ac = true;
                eVar = this.f2212v;
                dVar = C1087d.f1818a;
                str2 = Boolean.toString(true);
            } else {
                eVar = this.f2212v;
                dVar = C1087d.f1818a;
                str2 = Boolean.toString(false);
            }
            eVar.mo10693a(dVar, str2, defaultSharedPreferences);
            if (((Boolean) this.f2212v.mo10696b(C1087d.f1819b, Boolean.FALSE)).booleanValue()) {
                this.f2207q.mo11372b(AppLovinSdk.TAG, "Initializing SDK for non-maiden launch");
                this.f2188ad = true;
            } else {
                this.f2207q.mo11372b(AppLovinSdk.TAG, "Initializing SDK for maiden launch");
                this.f2212v.mo10692a(C1087d.f1819b, Boolean.TRUE);
            }
            String str3 = (String) this.f2212v.mo10696b(C1087d.f1820c, null);
            if (!StringUtils.isValidString(str3) || AppLovinSdk.VERSION_CODE > Utils.toVersionCode(str3)) {
                this.f2212v.mo10692a(C1087d.f1820c, AppLovinSdk.VERSION);
            }
            boolean a = C1264h.m2521a(mo10932L());
            if (!((Boolean) mo10946a(C1085b.f1729dd)).booleanValue() || a) {
                mo10981b();
            }
            if (((Boolean) mo10946a(C1085b.f1728dc)).booleanValue() && !a) {
                this.f2207q.mo11374c(AppLovinSdk.TAG, "SDK initialized with no internet connection - listening for connection");
                m2059ap();
            }
        } else {
            mo10960a(false);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    public <T> void mo10959a(String str, @Nullable T t, SharedPreferences.Editor editor) {
        this.f2212v.mo10694a(str, t, editor);
    }

    /* renamed from: a */
    public void mo10960a(boolean z) {
        synchronized (this.f2182X) {
            this.f2184Z = false;
            this.f2185aa = z;
        }
        if (this.f2193b != null && this.f2208r != null) {
            List<String> b = mo10980b(C1084a.f1516a);
            if (b.isEmpty()) {
                this.f2208r.mo10836e();
                mo10993j();
                return;
            }
            long longValue = ((Long) mo10946a(C1084a.f1519b)).longValue();
            C1166z zVar = new C1166z(this, true, new Runnable() {
                public void run() {
                    if (!C1188m.this.f2208r.mo10832a()) {
                        C1188m.this.f2207q.mo11372b(AppLovinSdk.TAG, "Timing out adapters init...");
                        C1188m.this.f2208r.mo10836e();
                        C1188m.this.mo10993j();
                    }
                }
            });
            C1314v vVar = this.f2207q;
            vVar.mo11372b(AppLovinSdk.TAG, "Waiting for required adapters to init: " + b + " - timing out in " + longValue + "ms...");
            this.f2208r.mo10831a((C1109a) zVar, C1140o.C1142a.MEDIATION_TIMEOUT, longValue, true);
        }
    }

    /* renamed from: a */
    public boolean mo10961a(C1085b<String> bVar, MaxAdFormat maxAdFormat) {
        return mo10984c(bVar).contains(maxAdFormat);
    }

    /* renamed from: a */
    public boolean mo10962a(MaxAdFormat maxAdFormat) {
        List<MaxAdFormat> list = this.f2181W;
        return list != null && list.size() > 0 && !this.f2181W.contains(maxAdFormat);
    }

    /* renamed from: aa */
    public C1247r mo10963aa() {
        return this.f2216z;
    }

    /* renamed from: ab */
    public C1095c mo10964ab() {
        return this.f2159A;
    }

    /* renamed from: ac */
    public C1319z mo10965ac() {
        return this.f2160B;
    }

    /* renamed from: ad */
    public C1248s mo10966ad() {
        return this.f2161C;
    }

    /* renamed from: ae */
    public C1008a mo10967ae() {
        return f2158c;
    }

    /* renamed from: af */
    public C1318y mo10968af() {
        return this.f2162D;
    }

    /* renamed from: ag */
    public C1172i mo10969ag() {
        return this.f2164F;
    }

    /* renamed from: ah */
    public C1303m mo10970ah() {
        return this.f2165G;
    }

    /* renamed from: ai */
    public C1169h mo10971ai() {
        return this.f2166H;
    }

    /* renamed from: aj */
    public AppLovinBroadcastManager mo10972aj() {
        return AppLovinBroadcastManager.getInstance(f2157a);
    }

    /* renamed from: ak */
    public C1243p mo10973ak() {
        return this.f2167I;
    }

    /* renamed from: al */
    public C1194n mo10974al() {
        return this.f2168J;
    }

    /* renamed from: am */
    public C1021f mo10975am() {
        return this.f2169K;
    }

    /* renamed from: an */
    public C1252u mo10976an() {
        return this.f2170L;
    }

    /* renamed from: ao */
    public Activity mo10977ao() {
        Activity a = mo10967ae().mo10434a();
        if (a != null) {
            return a;
        }
        Activity N = mo10933N();
        if (N != null) {
            return N;
        }
        return null;
    }

    /* renamed from: b */
    public <T> T mo10978b(C1087d<T> dVar, @Nullable T t) {
        return this.f2212v.mo10696b(dVar, t);
    }

    /* renamed from: b */
    public <T> T mo10979b(C1087d<T> dVar, @Nullable T t, SharedPreferences sharedPreferences) {
        return this.f2212v.mo10697b(dVar, t, sharedPreferences);
    }

    /* renamed from: b */
    public List<String> mo10980b(C1085b<String> bVar) {
        return this.f2193b.mo10682b(bVar);
    }

    /* renamed from: b */
    public void mo10981b() {
        synchronized (this.f2182X) {
            this.f2184Z = true;
            mo10938S().mo10835d();
            int i = this.f2189ae + 1;
            this.f2189ae = i;
            mo10938S().mo10830a(new C1127i(i, this, new C1127i.C1129a() {
                /* renamed from: a */
                public void mo10820a(JSONObject jSONObject) {
                    boolean z = jSONObject.length() > 0;
                    C1264h.m2526d(jSONObject, C1188m.this);
                    C1264h.m2525c(jSONObject, C1188m.this);
                    C1105e.m1782a(C1188m.this);
                    C1264h.m2528e(jSONObject, C1188m.this);
                    C1264h.m2518a(jSONObject, z, C1188m.this);
                    C0866b.m930a(jSONObject, C1188m.this);
                    C0866b.m932b(jSONObject, C1188m.this);
                    C1188m.this.mo10927G().mo10036a(JsonUtils.getBoolean(jSONObject, "smd", Boolean.FALSE).booleanValue());
                    C1188m mVar = C1188m.this;
                    List unused = mVar.f2181W = mVar.m2061b(jSONObject);
                    C1264h.m2530f(jSONObject, C1188m.this);
                    C1188m.this.mo10930J().mo10219a(jSONObject);
                    C1188m.this.m2058a(jSONObject);
                    C1188m.this.mo10938S().mo10828a((C1109a) new C1137n(C1188m.this));
                }
            }), C1140o.C1142a.MAIN, (long) ((Integer) mo10946a(C1085b.f1724dY)).intValue());
        }
    }

    /* renamed from: b */
    public <T> void mo10982b(C1087d<T> dVar) {
        this.f2212v.mo10691a(dVar);
    }

    /* renamed from: b */
    public void mo10983b(String str) {
        C1314v vVar = this.f2207q;
        vVar.mo11372b(AppLovinSdk.TAG, "Setting user id: " + str);
        this.f2214x.mo11339a(str);
    }

    /* renamed from: c */
    public List<MaxAdFormat> mo10984c(C1085b<String> bVar) {
        return this.f2193b.mo10684c(bVar);
    }

    /* renamed from: c */
    public void mo10985c(String str) {
        this.f2200j = str;
        mo10982b(C1087d.f1815B);
    }

    /* renamed from: c */
    public boolean mo10986c() {
        boolean z;
        synchronized (this.f2182X) {
            z = this.f2184Z;
        }
        return z;
    }

    /* renamed from: d */
    public boolean mo10987d() {
        boolean z;
        synchronized (this.f2182X) {
            z = this.f2185aa;
        }
        return z;
    }

    /* renamed from: e */
    public boolean mo10988e() {
        return "HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(mo11010z());
    }

    /* renamed from: f */
    public boolean mo10989f() {
        return StringUtils.containsIgnoreCase(mo11003t(), AppLovinMediationProvider.MAX);
    }

    /* renamed from: g */
    public boolean mo10990g() {
        return Utils.checkClassExistence("com.unity3d.player.UnityPlayerActivity");
    }

    /* renamed from: h */
    public void mo10991h() {
        String str = (String) this.f2212v.mo10696b(C1087d.f1820c, null);
        if (StringUtils.isValidString(str) && AppLovinSdk.VERSION_CODE < Utils.toVersionCode(str)) {
            C1314v.m2663i(AppLovinSdk.TAG, GeneratedOutlineSupport.outline20(GeneratedOutlineSupport.outline24("Current version ("), AppLovinSdk.VERSION, ") is older than earlier installed version (", str, "), which may cause compatibility issues."));
        }
    }

    /* renamed from: i */
    public void mo10992i() {
        this.f2164F.mo10892a();
    }

    /* renamed from: j */
    public void mo10993j() {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener = this.f2190af;
        if (sdkInitializationListener != null) {
            if (mo10987d()) {
                this.f2190af = null;
                this.f2191ag = null;
            } else if (this.f2191ag != sdkInitializationListener) {
                if (((Boolean) mo10946a(C1085b.f1584ap)).booleanValue()) {
                    this.f2190af = null;
                } else {
                    this.f2191ag = sdkInitializationListener;
                }
            } else {
                return;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1188m.this.f2207q.mo11372b(AppLovinSdk.TAG, "Calling back publisher's initialization completion handler...");
                    sdkInitializationListener.onSdkInitialized(C1188m.this.f2192ah);
                }
            }, Math.max(0, ((Long) mo10946a(C1085b.f1585aq)).longValue()));
        }
    }

    /* renamed from: k */
    public void mo10994k() {
        C1314v.m2663i(AppLovinSdk.TAG, "Resetting SDK state...");
        long b = this.f2210t.mo10760b(C1103f.f1929g);
        this.f2193b.mo10685c();
        this.f2193b.mo10679a();
        this.f2210t.mo10759a();
        this.f2159A.mo10719b();
        this.f2210t.mo10762b(C1103f.f1929g, b + 1);
        if (this.f2183Y.compareAndSet(true, false)) {
            mo10981b();
        } else {
            this.f2183Y.set(true);
        }
    }

    /* renamed from: l */
    public void mo10995l() {
        this.f2177S.mo10038c();
    }

    /* renamed from: m */
    public String mo10996m() {
        return this.f2214x.mo11338a();
    }

    /* renamed from: n */
    public String mo10997n() {
        return this.f2214x.mo11340b();
    }

    /* renamed from: o */
    public String mo10998o() {
        return this.f2214x.mo11341c();
    }

    /* renamed from: p */
    public AppLovinSdkSettings mo10999p() {
        return this.f2197g;
    }

    /* renamed from: q */
    public AppLovinUserSegment mo11000q() {
        return this.f2198h;
    }

    /* renamed from: r */
    public C1167f mo11001r() {
        return (C1167f) this.f2199i;
    }

    /* renamed from: s */
    public AppLovinSdkConfiguration mo11002s() {
        return this.f2192ah;
    }

    /* renamed from: t */
    public String mo11003t() {
        String str = (String) mo10947a(C1087d.f1815B);
        return StringUtils.isValidString(str) ? str : this.f2200j;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("CoreSdk{sdkKey='");
        GeneratedOutlineSupport.outline33(outline24, this.f2194d, '\'', ", enabled=");
        outline24.append(this.f2185aa);
        outline24.append(", isFirstSession=");
        outline24.append(this.f2187ac);
        outline24.append('}');
        return outline24.toString();
    }

    /* renamed from: u */
    public AppLovinAdServiceImpl mo11005u() {
        return this.f2201k;
    }

    /* renamed from: v */
    public AppLovinNativeAdService mo11006v() {
        return this.f2202l;
    }

    /* renamed from: w */
    public AppLovinEventService mo11007w() {
        return this.f2203m;
    }

    /* renamed from: x */
    public AppLovinUserService mo11008x() {
        return this.f2204n;
    }

    /* renamed from: y */
    public VariableServiceImpl mo11009y() {
        return this.f2205o;
    }

    /* renamed from: z */
    public String mo11010z() {
        return this.f2194d;
    }
}
