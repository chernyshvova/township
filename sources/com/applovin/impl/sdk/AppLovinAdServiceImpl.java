package com.applovin.impl.sdk;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.C0725b;
import com.applovin.impl.sdk.network.C1226g;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p025ad.AppLovinAdImpl;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p025ad.C1063f;
import com.applovin.impl.sdk.p028d.C1093a;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1131j;
import com.applovin.impl.sdk.p029e.C1132k;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class AppLovinAdServiceImpl implements AppLovinAdService {

    /* renamed from: a */
    public final C1188m f1242a;

    /* renamed from: b */
    public final C1314v f1243b;

    /* renamed from: c */
    public final Handler f1244c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    public final Map<C1056d, C1001b> f1245d;

    /* renamed from: e */
    public final Object f1246e = new Object();

    /* renamed from: f */
    public final Map<String, String> f1247f = new HashMap();

    /* renamed from: g */
    public final AtomicReference<JSONObject> f1248g = new AtomicReference<>();

    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$a */
    public class C1000a implements AppLovinAdLoadListener {

        /* renamed from: b */
        public final C1001b f1256b;

        public C1000a(C1001b bVar) {
            this.f1256b = bVar;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            HashSet hashSet;
            AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
            C1056d adZone = appLovinAdImpl.getAdZone();
            if (!(appLovinAd instanceof C1063f)) {
                AppLovinAdServiceImpl.this.f1242a.mo10945Z().mo10670a(appLovinAdImpl);
                appLovinAd = new C1063f(adZone, AppLovinAdServiceImpl.this.f1242a);
            }
            synchronized (this.f1256b.f1257a) {
                hashSet = new HashSet(this.f1256b.f1259c);
                this.f1256b.f1259c.clear();
                this.f1256b.f1258b = false;
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.m1348a(appLovinAd, (AppLovinAdLoadListener) it.next());
            }
        }

        public void failedToReceiveAd(int i) {
            HashSet hashSet;
            synchronized (this.f1256b.f1257a) {
                hashSet = new HashSet(this.f1256b.f1259c);
                this.f1256b.f1259c.clear();
                this.f1256b.f1258b = false;
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.m1339a(i, (AppLovinAdLoadListener) it.next());
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$b */
    public static class C1001b {

        /* renamed from: a */
        public final Object f1257a;

        /* renamed from: b */
        public boolean f1258b;

        /* renamed from: c */
        public final Collection<AppLovinAdLoadListener> f1259c;

        public C1001b() {
            this.f1257a = new Object();
            this.f1259c = new HashSet();
        }

        @NonNull
        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("AdLoadState{, isWaitingForAd=");
            outline24.append(this.f1258b);
            outline24.append(", pendingAdListeners=");
            outline24.append(this.f1259c);
            outline24.append('}');
            return outline24.toString();
        }
    }

    public AppLovinAdServiceImpl(C1188m mVar) {
        this.f1242a = mVar;
        this.f1243b = mVar.mo10922B();
        HashMap hashMap = new HashMap(5);
        this.f1245d = hashMap;
        hashMap.put(C1056d.m1477g(), new C1001b());
        this.f1245d.put(C1056d.m1478h(), new C1001b());
        this.f1245d.put(C1056d.m1479i(), new C1001b());
        this.f1245d.put(C1056d.m1480j(), new C1001b());
        this.f1245d.put(C1056d.m1481k(), new C1001b());
    }

    @Nullable
    /* renamed from: a */
    private Uri m1334a(Uri uri, String str) {
        try {
            return Uri.parse(uri.getQueryParameter(str));
        } catch (Throwable unused) {
            C1314v B = this.f1242a.mo10922B();
            B.mo11375d("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            return null;
        }
    }

    /* renamed from: a */
    private C1001b m1335a(C1056d dVar) {
        C1001b bVar;
        synchronized (this.f1246e) {
            bVar = this.f1245d.get(dVar);
            if (bVar == null) {
                bVar = new C1001b();
                this.f1245d.put(dVar, bVar);
            }
        }
        return bVar;
    }

    /* renamed from: a */
    private String m1337a(String str, long j, int i, String str2, boolean z) {
        try {
            if (!StringUtils.isValidString(str)) {
                return null;
            }
            if (i < 0 || i > 100) {
                i = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j)).appendQueryParameter("pv", Integer.toString(i)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z)).build().toString();
        } catch (Throwable th) {
            C1314v vVar = this.f1243b;
            vVar.mo11373b("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            return null;
        }
    }

    /* renamed from: a */
    private String m1338a(String str, long j, long j2, List<Long> list, boolean z, int i) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j)).appendQueryParameter("vs_ms", Long.toString(j2));
        if (list != null && list.size() > 0) {
            appendQueryParameter.appendQueryParameter("ec_ms", list.toString());
        }
        if (i != C1169h.f2109a) {
            appendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z));
            appendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(C1169h.m1994a(i)));
        }
        return appendQueryParameter.build().toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1339a(final int i, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1244c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                } catch (Throwable th) {
                    C1314v.m2659c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
                }
            }
        });
    }

    /* renamed from: a */
    private void m1340a(Uri uri, C1057e eVar, AppLovinAdView appLovinAdView, C0725b bVar) {
        if (Utils.openUri(appLovinAdView.getContext(), uri, this.f1242a)) {
            C1267j.m2574c(bVar.mo9584g(), (AppLovinAd) eVar, appLovinAdView);
        }
        bVar.mo9592o();
    }

    /* renamed from: a */
    private void m1341a(Uri uri, C1057e eVar, @Nullable AppLovinAdView appLovinAdView, @Nullable C0725b bVar, Context context, C1188m mVar) {
        if (uri == null || !StringUtils.isValidString(uri.getQuery())) {
            mVar.mo10922B().mo11376e("AppLovinAdService", "Failed to execute Deep Link+ command - no query parameters found");
            return;
        }
        Uri a = m1334a(uri, "primaryUrl");
        List<Uri> b = m1350b(uri, "primaryTrackingUrl");
        Uri a2 = m1334a(uri, "fallbackUrl");
        List<Uri> b2 = m1350b(uri, "fallbackTrackingUrl");
        if (a == null && a2 == null) {
            mVar.mo10922B().mo11376e("AppLovinAdService", "Failed to parse both primary and backup URLs for Deep Link+ command");
            return;
        }
        if (!m1349a(a, "primary", b, eVar, appLovinAdView, bVar, context, mVar)) {
            m1349a(a2, "backup", b2, eVar, appLovinAdView, bVar, context, mVar);
        }
        if (bVar != null) {
            bVar.mo9592o();
        }
    }

    /* renamed from: a */
    private void m1344a(C1056d dVar, C1231i iVar, C1000a aVar) {
        AppLovinAdImpl a = this.f1242a.mo10945Z().mo10669a(dVar);
        if (a != null) {
            C1314v vVar = this.f1243b;
            vVar.mo11372b("AppLovinAdService", "Using pre-loaded ad: " + a + " for " + dVar);
            aVar.adReceived(a);
            return;
        }
        m1347a((C1109a) new C1132k(dVar, iVar, aVar, this.f1242a));
    }

    /* renamed from: a */
    private void m1345a(C1056d dVar, C1231i iVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (dVar == null) {
            throw new IllegalArgumentException("No zone specified");
        } else if (appLovinAdLoadListener != null) {
            C1314v B = this.f1242a.mo10922B();
            B.mo11372b("AppLovinAdService", "Loading next ad of zone {" + dVar + "}...");
            C1001b a = m1335a(dVar);
            synchronized (a.f1257a) {
                a.f1259c.add(appLovinAdLoadListener);
                if (!a.f1258b) {
                    a.f1258b = true;
                    m1344a(dVar, iVar, new C1000a(a));
                } else {
                    this.f1243b.mo11372b("AppLovinAdService", "Already waiting on an ad load...");
                }
            }
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    /* renamed from: a */
    private void m1346a(C1093a aVar) {
        if (StringUtils.isValidString(aVar.mo10710a())) {
            this.f1242a.mo10940U().mo11145a(C1226g.m2290o().mo11174c(Utils.replaceCommonMacros(aVar.mo10710a())).mo11177d(StringUtils.isValidString(aVar.mo10711b()) ? Utils.replaceCommonMacros(aVar.mo10711b()) : null).mo11172b(aVar.mo10712c()).mo11169a(false).mo11176c(aVar.mo10713d()).mo11170a());
            return;
        }
        this.f1243b.mo11375d("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
    }

    /* renamed from: a */
    private void m1347a(C1109a aVar) {
        if (!this.f1242a.mo10987d()) {
            C1314v.m2662h(AppLovinSdk.TAG, "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f1242a.mo10949a();
        this.f1242a.mo10938S().mo10829a(aVar, C1140o.C1142a.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1348a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1244c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.adReceived(appLovinAd);
                } catch (Throwable th) {
                    C1314v.m2659c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
                }
            }
        });
    }

    /* renamed from: a */
    private boolean m1349a(Uri uri, String str, List<Uri> list, C1057e eVar, @Nullable AppLovinAdView appLovinAdView, @Nullable C0725b bVar, Context context, C1188m mVar) {
        C1314v B = mVar.mo10922B();
        B.mo11372b("AppLovinAdService", "Opening " + str + " URL: " + uri);
        boolean openUri = Utils.openUri(context, uri, mVar);
        C1314v B2 = mVar.mo10922B();
        if (openUri) {
            B2.mo11372b("AppLovinAdService", "URL opened successfully, dispatching tracking URLs: " + list);
            for (Uri uri2 : list) {
                mVar.mo10943X().dispatchPostbackAsync(uri2.toString(), (AppLovinPostbackListener) null);
            }
            if (bVar != null) {
                C1267j.m2574c(bVar.mo9584g(), (AppLovinAd) eVar, appLovinAdView);
            }
        } else {
            B2.mo11376e("AppLovinAdService", "URL failed to open");
        }
        return openUri;
    }

    /* renamed from: b */
    private List<Uri> m1350b(Uri uri, String str) {
        List<String> queryParameters = uri.getQueryParameters(str);
        ArrayList arrayList = new ArrayList(queryParameters.size());
        for (String parse : queryParameters) {
            try {
                arrayList.add(Uri.parse(parse));
            } catch (Throwable unused) {
                C1314v B = this.f1242a.mo10922B();
                B.mo11375d("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            }
        }
        return arrayList;
    }

    public void addCustomQueryParams(Map<String, String> map) {
        synchronized (this.f1247f) {
            this.f1247f.putAll(map);
        }
    }

    public AppLovinAd dequeueAd(C1056d dVar) {
        AppLovinAdImpl b = this.f1242a.mo10945Z().mo10671b(dVar);
        C1314v vVar = this.f1243b;
        vVar.mo11372b("AppLovinAdService", "Dequeued ad: " + b + " for zone: " + dVar + "...");
        return b;
    }

    public JSONObject getAndResetCustomPostBody() {
        return this.f1248g.getAndSet((Object) null);
    }

    public Map<String, String> getAndResetCustomQueryParams() {
        HashMap hashMap;
        synchronized (this.f1247f) {
            hashMap = new HashMap(this.f1247f);
            this.f1247f.clear();
        }
        return hashMap;
    }

    public String getBidToken() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String a = this.f1242a.mo10941V().mo11204a();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return a;
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        m1345a(C1056d.m1471a(appLovinAdSize, AppLovinAdType.REGULAR), (C1231i) null, appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, C1231i iVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1314v vVar = this.f1243b;
        vVar.mo11372b("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        m1345a(C1056d.m1472a(appLovinAdSize, AppLovinAdType.REGULAR, str), iVar, appLovinAdLoadListener);
    }

    /* JADX WARNING: type inference failed for: r11v23, types: [com.applovin.impl.sdk.e.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadNextAdForAdToken(java.lang.String r11, com.applovin.sdk.AppLovinAdLoadListener r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0007
            java.lang.String r11 = r11.trim()
            goto L_0x0008
        L_0x0007:
            r11 = 0
        L_0x0008:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = -8
            java.lang.String r2 = "AppLovinAdService"
            if (r0 == 0) goto L_0x001a
            java.lang.String r11 = "Invalid ad token specified"
            com.applovin.impl.sdk.C1314v.m2663i(r2, r11)
            r10.m1339a((int) r1, (com.applovin.sdk.AppLovinAdLoadListener) r12)
            return
        L_0x001a:
            com.applovin.impl.sdk.ad.c r0 = new com.applovin.impl.sdk.ad.c
            com.applovin.impl.sdk.m r3 = r10.f1242a
            r0.<init>(r11, r3)
            com.applovin.impl.sdk.ad.c$a r11 = r0.mo10541b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.p025ad.C1054c.C1055a.REGULAR
            if (r11 != r3) goto L_0x004b
            com.applovin.impl.sdk.v r11 = r10.f1243b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Loading next ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r11.mo11372b(r2, r1)
            com.applovin.impl.sdk.e.l r11 = new com.applovin.impl.sdk.e.l
            com.applovin.impl.sdk.m r1 = r10.f1242a
            r11.<init>(r0, r12, r1)
        L_0x0046:
            r10.m1347a((com.applovin.impl.sdk.p029e.C1109a) r11)
            goto L_0x00e6
        L_0x004b:
            com.applovin.impl.sdk.ad.c$a r11 = r0.mo10541b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.p025ad.C1054c.C1055a.AD_RESPONSE_JSON
            if (r11 != r3) goto L_0x00cf
            org.json.JSONObject r5 = r0.mo10543d()
            if (r5 == 0) goto L_0x00c7
            com.applovin.impl.sdk.m r11 = r10.f1242a
            com.applovin.impl.sdk.utils.C1264h.m2530f(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.f1242a
            com.applovin.impl.sdk.utils.C1264h.m2526d(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.f1242a
            com.applovin.impl.sdk.utils.C1264h.m2525c(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.f1242a
            com.applovin.impl.sdk.utils.C1264h.m2528e(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.f1242a
            com.applovin.impl.sdk.C1105e.m1782a((com.applovin.impl.sdk.C1188m) r11)
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            java.lang.String r1 = "ads"
            org.json.JSONArray r11 = com.applovin.impl.sdk.utils.JsonUtils.getJSONArray(r5, r1, r11)
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x00ab
            com.applovin.impl.sdk.v r11 = r10.f1243b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Rendering ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo11372b(r2, r0)
            com.applovin.impl.sdk.m r11 = r10.f1242a
            com.applovin.impl.sdk.ad.d r6 = com.applovin.impl.sdk.utils.Utils.getZone(r5, r11)
            com.applovin.impl.sdk.e.p r11 = new com.applovin.impl.sdk.e.p
            com.applovin.impl.sdk.ad.b r7 = com.applovin.impl.sdk.p025ad.C1053b.DECODED_AD_TOKEN_JSON
            com.applovin.impl.sdk.m r9 = r10.f1242a
            r4 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0046
        L_0x00ab:
            com.applovin.impl.sdk.v r11 = r10.f1243b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "No ad returned from the server for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo11376e(r2, r0)
            r11 = 204(0xcc, float:2.86E-43)
            r12.failedToReceiveAd(r11)
            goto L_0x00e6
        L_0x00c7:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r3 = "Unable to retrieve ad response JSON from token: "
            goto L_0x00d6
        L_0x00cf:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r3 = "Invalid ad token specified: "
        L_0x00d6:
            r11.append(r3)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.applovin.impl.sdk.C1314v.m2663i(r2, r11)
            r12.failedToReceiveAd(r1)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinAdServiceImpl.loadNextAdForAdToken(java.lang.String, com.applovin.sdk.AppLovinAdLoadListener):void");
    }

    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!TextUtils.isEmpty(str)) {
            C1314v vVar = this.f1243b;
            vVar.mo11372b("AppLovinAdService", "Loading next ad of zone {" + str + "}");
            m1345a(C1056d.m1473a(str), (C1231i) null, appLovinAdLoadListener);
            return;
        }
        throw new IllegalArgumentException("No zone id specified");
    }

    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List<String> removeTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(list);
        if (removeTrimmedEmptyStrings == null || removeTrimmedEmptyStrings.isEmpty()) {
            C1314v.m2663i("AppLovinAdService", "No zones were provided");
            m1339a(-7, appLovinAdLoadListener);
            return;
        }
        C1314v vVar = this.f1243b;
        vVar.mo11372b("AppLovinAdService", "Loading next ad for zones: " + removeTrimmedEmptyStrings);
        m1347a((C1109a) new C1131j(removeTrimmedEmptyStrings, appLovinAdLoadListener, this.f1242a));
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1314v vVar = this.f1243b;
        vVar.mo11372b("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        m1345a(C1056d.m1475b(str), (C1231i) null, appLovinAdLoadListener);
    }

    public void maybeSubmitPersistentPostbacks(List<C1093a> list) {
        if (list != null && !list.isEmpty()) {
            for (C1093a a : list) {
                m1346a(a);
            }
        }
    }

    public void setCustomPostBody(JSONObject jSONObject) {
        this.f1248g.set(jSONObject);
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinAdService{adLoadStates=");
        outline24.append(this.f1245d);
        outline24.append('}');
        return outline24.toString();
    }

    public void trackAndLaunchClick(C1057e eVar, AppLovinAdView appLovinAdView, C0725b bVar, Uri uri, PointF pointF, boolean z) {
        if (eVar == null) {
            this.f1243b.mo11376e("AppLovinAdService", "Unable to track ad view click. No ad specified");
            return;
        }
        this.f1243b.mo11372b("AppLovinAdService", "Tracking click on an ad...");
        maybeSubmitPersistentPostbacks(eVar.mo10583a(pointF, z));
        if (appLovinAdView == null) {
            this.f1243b.mo11376e("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
        } else if (Utils.isDeepLinkPlusUrl(uri)) {
            m1341a(uri, eVar, appLovinAdView, bVar, appLovinAdView.getContext(), this.f1242a);
        } else {
            m1340a(uri, eVar, appLovinAdView, bVar);
        }
    }

    public void trackAndLaunchVideoClick(C1057e eVar, Uri uri, PointF pointF, Context context) {
        if (eVar == null) {
            this.f1243b.mo11376e("AppLovinAdService", "Unable to track video click. No ad specified");
            return;
        }
        this.f1243b.mo11372b("AppLovinAdService", "Tracking VIDEO click on an ad...");
        maybeSubmitPersistentPostbacks(eVar.mo10582a(pointF));
        if (Utils.isDeepLinkPlusUrl(uri)) {
            m1341a(uri, eVar, (AppLovinAdView) null, (C0725b) null, context, this.f1242a);
            return;
        }
        Utils.openUri(context, uri, this.f1242a);
    }

    public void trackAppKilled(C1057e eVar) {
        if (eVar == null) {
            this.f1243b.mo11376e("AppLovinAdService", "Unable to track app killed. No ad specified");
            return;
        }
        this.f1243b.mo11372b("AppLovinAdService", "Tracking app killed during ad...");
        List<C1093a> ao = eVar.mo10609ao();
        if (ao == null || ao.isEmpty()) {
            C1314v vVar = this.f1243b;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to track app killed during AD #");
            outline24.append(eVar.getAdIdNumber());
            outline24.append(". Missing app killed tracking URL.");
            vVar.mo11375d("AppLovinAdService", outline24.toString());
            return;
        }
        for (C1093a next : ao) {
            m1346a(new C1093a(next.mo10710a(), next.mo10711b()));
        }
    }

    public void trackFullScreenAdClosed(C1057e eVar, long j, List<Long> list, long j2, boolean z, int i) {
        C1314v vVar = this.f1243b;
        if (eVar == null) {
            vVar.mo11376e("AppLovinAdService", "Unable to track ad closed. No ad specified.");
            return;
        }
        vVar.mo11372b("AppLovinAdService", "Tracking ad closed...");
        List<C1093a> an = eVar.mo10608an();
        if (an == null || an.isEmpty()) {
            C1314v vVar2 = this.f1243b;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to track ad closed for AD #");
            outline24.append(eVar.getAdIdNumber());
            outline24.append(". Missing ad close tracking URL.");
            outline24.append(eVar.getAdIdNumber());
            vVar2.mo11375d("AppLovinAdService", outline24.toString());
            return;
        }
        for (C1093a next : an) {
            long j3 = j;
            long j4 = j2;
            List<Long> list2 = list;
            boolean z2 = z;
            int i2 = i;
            String a = m1338a(next.mo10710a(), j3, j4, list2, z2, i2);
            String a2 = m1338a(next.mo10711b(), j3, j4, list2, z2, i2);
            if (StringUtils.isValidString(a)) {
                m1346a(new C1093a(a, a2));
            } else {
                C1314v vVar3 = this.f1243b;
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Failed to parse url: ");
                outline242.append(next.mo10710a());
                vVar3.mo11376e("AppLovinAdService", outline242.toString());
            }
        }
    }

    public void trackImpression(C1057e eVar) {
        if (eVar == null) {
            this.f1243b.mo11376e("AppLovinAdService", "Unable to track impression click. No ad specified");
            return;
        }
        this.f1243b.mo11372b("AppLovinAdService", "Tracking impression on ad...");
        maybeSubmitPersistentPostbacks(eVar.mo9310ap());
    }

    public void trackVideoEnd(C1057e eVar, long j, int i, boolean z) {
        C1314v vVar = this.f1243b;
        if (eVar == null) {
            vVar.mo11376e("AppLovinAdService", "Unable to track video end. No ad specified");
            return;
        }
        vVar.mo11372b("AppLovinAdService", "Tracking video end on ad...");
        List<C1093a> am = eVar.mo10607am();
        if (am == null || am.isEmpty()) {
            C1314v vVar2 = this.f1243b;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to submit persistent postback for AD #");
            outline24.append(eVar.getAdIdNumber());
            outline24.append(". Missing video end tracking URL.");
            vVar2.mo11375d("AppLovinAdService", outline24.toString());
            return;
        }
        String l = Long.toString(System.currentTimeMillis());
        for (C1093a next : am) {
            if (StringUtils.isValidString(next.mo10710a())) {
                long j2 = j;
                int i2 = i;
                String str = l;
                boolean z2 = z;
                String a = m1337a(next.mo10710a(), j2, i2, str, z2);
                String a2 = m1337a(next.mo10711b(), j2, i2, str, z2);
                if (a != null) {
                    m1346a(new C1093a(a, a2));
                } else {
                    C1314v vVar3 = this.f1243b;
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("Failed to parse url: ");
                    outline242.append(next.mo10710a());
                    vVar3.mo11376e("AppLovinAdService", outline242.toString());
                }
            } else {
                this.f1243b.mo11375d("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
            }
        }
    }
}
