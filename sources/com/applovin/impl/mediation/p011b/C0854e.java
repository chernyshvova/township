package com.applovin.impl.mediation.p011b;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p012c.C0865a;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p028d.C1103f;
import com.applovin.impl.sdk.p028d.C1104g;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.utils.C1260e;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.e */
public class C0854e extends C1109a {

    /* renamed from: a */
    public static final AtomicBoolean f747a = new AtomicBoolean();

    /* renamed from: c */
    public final String f748c;

    /* renamed from: d */
    public final MaxAdFormat f749d;

    /* renamed from: e */
    public final JSONObject f750e;

    /* renamed from: f */
    public final List<C0801a> f751f;

    /* renamed from: g */
    public final C0836a.C0837a f752g;

    /* renamed from: h */
    public final WeakReference<Context> f753h;

    /* renamed from: i */
    public long f754i;

    /* renamed from: j */
    public final List<MaxNetworkResponseInfo> f755j;

    /* renamed from: com.applovin.impl.mediation.b.e$a */
    public class C0858a extends C1109a {

        /* renamed from: c */
        public final long f763c = SystemClock.elapsedRealtime();

        /* renamed from: d */
        public final int f764d;

        /* renamed from: e */
        public final C0801a f765e;

        /* renamed from: f */
        public final List<C0801a> f766f;

        public C0858a(int i, List<C0801a> list) {
            super(C0854e.this.mo10774e(), C0854e.this.f1961b);
            this.f764d = i;
            this.f765e = list.get(i);
            this.f766f = list;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m903a(C0801a aVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j, @Nullable MaxError maxError) {
            MaxNetworkResponseInfo.AdLoadState adLoadState2 = adLoadState;
            C0854e.this.f755j.add(new MaxNetworkResponseInfoImpl(adLoadState2, aVar.mo9845i(), new MaxMediatedNetworkInfoImpl(C0867c.m938a(aVar.mo9897O(), this.f1961b)), j, maxError));
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void m912e(String str) {
        }

        public void run() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loading ad ");
            outline24.append(this.f764d + 1);
            outline24.append(" of ");
            outline24.append(this.f766f.size());
            outline24.append(": ");
            outline24.append(this.f765e.mo9898P());
            mo10768a(outline24.toString());
            m912e("started to load ad");
            this.f1961b.mo10925E().loadThirdPartyMediatedAd(C0854e.this.f748c, this.f765e, C0854e.this.f753h.get() instanceof Activity ? (Activity) C0854e.this.f753h.get() : this.f1961b.mo10977ao(), new C0865a(C0854e.this.f752g) {
                public void onAdLoadFailed(String str, MaxError maxError) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - C0858a.this.f763c;
                    C0858a aVar = C0858a.this;
                    aVar.mo10768a("Ad failed to load in " + elapsedRealtime + " ms with error: " + maxError);
                    C0858a aVar2 = C0858a.this;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("failed to load ad: ");
                    outline24.append(maxError.getCode());
                    aVar2.m912e(outline24.toString());
                    C0858a aVar3 = C0858a.this;
                    aVar3.m903a(aVar3.f765e, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, elapsedRealtime, maxError);
                    if (C0858a.this.f764d < C0858a.this.f766f.size() - 1) {
                        C0858a aVar4 = C0858a.this;
                        C0858a.this.f1961b.mo10938S().mo10829a((C1109a) new C0858a(aVar4.f764d + 1, C0858a.this.f766f), C0867c.m935a(C0854e.this.f749d));
                        return;
                    }
                    C0854e.this.m895a((MaxError) new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                }

                public void onAdLoaded(MaxAd maxAd) {
                    C0858a.this.m912e("loaded ad");
                    long elapsedRealtime = SystemClock.elapsedRealtime() - C0858a.this.f763c;
                    C0858a aVar = C0858a.this;
                    aVar.mo10768a("Ad loaded in " + elapsedRealtime + "ms");
                    C0801a aVar2 = (C0801a) maxAd;
                    C0858a.this.m903a(aVar2, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, elapsedRealtime, (MaxError) null);
                    int b = C0858a.this.f764d;
                    while (true) {
                        b++;
                        if (b < C0858a.this.f766f.size()) {
                            C0858a aVar3 = C0858a.this;
                            aVar3.m903a((C0801a) aVar3.f766f.get(b), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1, (MaxError) null);
                        } else {
                            C0858a aVar4 = C0858a.this;
                            C0854e.this.m892a(aVar2, aVar4.f764d);
                            return;
                        }
                    }
                }
            });
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0854e(java.lang.String r3, com.applovin.mediation.MaxAdFormat r4, java.util.Map<java.lang.String, java.lang.Object> r5, org.json.JSONObject r6, android.content.Context r7, com.applovin.impl.sdk.C1188m r8, com.applovin.impl.mediation.ads.C0836a.C0837a r9) {
        /*
            r2 = this;
            java.lang.String r0 = "TaskProcessMediationWaterfall:"
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline27(r0, r3, r1)
            java.lang.String r1 = r4.getLabel()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0, r8)
            r2.f748c = r3
            r2.f749d = r4
            r2.f750e = r6
            r2.f752g = r9
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
            r3.<init>(r7)
            r2.f753h = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r6.length()
            r3.<init>(r4)
            r2.f751f = r3
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
            java.lang.String r4 = "ads"
            org.json.JSONArray r3 = com.applovin.impl.sdk.utils.JsonUtils.getJSONArray(r6, r4, r3)
            r4 = 0
        L_0x003c:
            int r7 = r3.length()
            if (r4 >= r7) goto L_0x0053
            r7 = 0
            org.json.JSONObject r7 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONArray) r3, (int) r4, (org.json.JSONObject) r7)
            java.util.List<com.applovin.impl.mediation.a.a> r9 = r2.f751f
            com.applovin.impl.mediation.a.a r7 = com.applovin.impl.mediation.p010a.C0801a.m654a(r5, r7, r6, r8)
            r9.add(r7)
            int r4 = r4 + 1
            goto L_0x003c
        L_0x0053:
            java.util.ArrayList r3 = new java.util.ArrayList
            java.util.List<com.applovin.impl.mediation.a.a> r4 = r2.f751f
            int r4 = r4.size()
            r3.<init>(r4)
            r2.f755j = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.p011b.C0854e.<init>(java.lang.String, com.applovin.mediation.MaxAdFormat, java.util.Map, org.json.JSONObject, android.content.Context, com.applovin.impl.sdk.m, com.applovin.impl.mediation.ads.a$a):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m892a(C0801a aVar, int i) {
        float f;
        final Float f2;
        this.f1961b.mo10926F().mo11378a(aVar);
        List<C0801a> list = this.f751f;
        List<C0801a> subList = list.subList(i + 1, list.size());
        long longValue = ((Long) this.f1961b.mo10946a(C1084a.f1511V)).longValue();
        float f3 = 1.0f;
        for (final C0801a next : subList) {
            Float h = next.mo9844h();
            if (h != null) {
                f = h.floatValue() * f3;
                f2 = Float.valueOf(f);
            } else {
                f = f3;
                f2 = null;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C0854e.this.f1961b.mo10925E().processAdLossPostback(next, f2);
                }
            }, TimeUnit.SECONDS.toMillis(longValue));
            f3 = f;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f754i;
        mo10770b("Waterfall loaded in " + elapsedRealtime + "ms for " + aVar.mo9898P());
        aVar.mo9827a((MaxAdWaterfallInfo) new MaxAdWaterfallInfoImpl(aVar, elapsedRealtime, this.f755j));
        C1267j.m2546a((MaxAdListener) this.f752g, (MaxAd) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m895a(MaxError maxError) {
        C1104g T;
        C1103f fVar;
        if (maxError.getCode() == 204) {
            T = this.f1961b.mo10939T();
            fVar = C1103f.f1938p;
        } else if (maxError.getCode() == -5001) {
            T = this.f1961b.mo10939T();
            fVar = C1103f.f1939q;
        } else {
            T = this.f1961b.mo10939T();
            fVar = C1103f.f1940r;
        }
        T.mo10757a(fVar);
        ArrayList arrayList = new ArrayList(this.f755j.size());
        for (MaxNetworkResponseInfo next : this.f755j) {
            if (next.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder("======FAILED AD LOADS======");
            sb.append("\n");
            int i = 0;
            while (i < arrayList.size()) {
                MaxNetworkResponseInfo maxNetworkResponseInfo = (MaxNetworkResponseInfo) arrayList.get(i);
                i++;
                sb.append(i);
                sb.append(") ");
                sb.append(maxNetworkResponseInfo.getMediatedNetwork().getName());
                sb.append("\n");
                sb.append("..code: ");
                sb.append(maxNetworkResponseInfo.getError().getCode());
                sb.append("\n");
                sb.append("..message: ");
                sb.append(maxNetworkResponseInfo.getError().getMessage());
                sb.append("\n");
            }
            ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb.toString());
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f754i;
        mo10770b("Waterfall failed in " + elapsedRealtime + "ms with error: " + maxError);
        ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl((C0801a) null, JsonUtils.getString(this.f750e, "waterfall_name", ""), JsonUtils.getString(this.f750e, "waterfall_test_name", ""), elapsedRealtime, this.f755j));
        C1267j.m2552a((MaxAdListener) this.f752g, this.f748c, maxError);
    }

    public void run() {
        this.f754i = SystemClock.elapsedRealtime();
        if (this.f750e.optBoolean("is_testing", false) && !this.f1961b.mo10930J().mo10221a() && f747a.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    Utils.showAlert("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", (Context) C0854e.this.f753h.get());
                }
            });
        }
        if (this.f751f.size() > 0) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Starting waterfall for ");
            outline24.append(this.f751f.size());
            outline24.append(" ad(s)...");
            mo10768a(outline24.toString());
            this.f1961b.mo10938S().mo10828a((C1109a) new C0858a(0, this.f751f));
            return;
        }
        mo10771c("No ads were returned from the server");
        Utils.maybeHandleNoFillResponseForPublisher(this.f748c, this.f749d, this.f750e, this.f1961b);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f750e, "settings", new JSONObject());
        long j = JsonUtils.getLong(jSONObject, "alfdcs", 0);
        final MaxErrorImpl maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device.");
        if (j > 0) {
            long millis = TimeUnit.SECONDS.toMillis(j);
            C08562 r4 = new Runnable() {
                public void run() {
                    C0854e.this.m895a(maxErrorImpl);
                }
            };
            if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", Boolean.FALSE).booleanValue()) {
                C1260e.m2499a(millis, this.f1961b, r4);
            } else {
                AppLovinSdkUtils.runOnUiThreadDelayed(r4, millis);
            }
        } else {
            m895a((MaxError) maxErrorImpl);
        }
    }
}
