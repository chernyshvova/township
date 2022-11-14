package com.applovin.impl.mediation;

import android.content.Context;
import androidx.annotation.Nullable;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p011b.C0845b;
import com.applovin.impl.mediation.p011b.C0850c;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* renamed from: com.applovin.impl.mediation.d */
public class C0868d {

    /* renamed from: a */
    public final C1188m f782a;

    /* renamed from: b */
    public final Map<String, C0872b> f783b = new HashMap(4);

    /* renamed from: c */
    public final Object f784c = new Object();

    /* renamed from: d */
    public final Map<String, C0801a> f785d = new HashMap(4);

    /* renamed from: e */
    public final Object f786e = new Object();

    /* renamed from: com.applovin.impl.mediation.d$a */
    public static class C0870a implements C0836a.C0837a {

        /* renamed from: a */
        public final C1188m f794a;

        /* renamed from: b */
        public final Context f795b;

        /* renamed from: c */
        public final C0868d f796c;

        /* renamed from: d */
        public final C0872b f797d;

        /* renamed from: e */
        public final MaxAdFormat f798e;

        /* renamed from: f */
        public final Map<String, Object> f799f;

        /* renamed from: g */
        public C1231i f800g;

        public C0870a(Map<String, Object> map, C1231i iVar, C0872b bVar, MaxAdFormat maxAdFormat, C0868d dVar, C1188m mVar, Context context) {
            this.f794a = mVar;
            this.f795b = context;
            this.f796c = dVar;
            this.f797d = bVar;
            this.f798e = maxAdFormat;
            this.f800g = iVar;
            this.f799f = map;
        }

        public void onAdClicked(MaxAd maxAd) {
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }

        public void onAdLoadFailed(final String str, MaxError maxError) {
            if (!this.f794a.mo10961a(C1084a.f1509T, this.f798e) || this.f797d.f806c >= ((Integer) this.f794a.mo10946a(C1084a.f1508S)).intValue()) {
                int unused = this.f797d.f806c = 0;
                this.f797d.f805b.set(false);
                if (this.f797d.f807d != null) {
                    ((MaxErrorImpl) maxError).setLoadTag(this.f797d.f804a);
                    C1267j.m2552a((MaxAdListener) this.f797d.f807d, str, maxError);
                    C0836a.C0837a unused2 = this.f797d.f807d = null;
                    return;
                }
                return;
            }
            C0872b.m965e(this.f797d);
            final int pow = (int) Math.pow(2.0d, (double) this.f797d.f806c);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C0870a aVar = C0870a.this;
                    C1231i unused = aVar.f800g = new C1231i.C1233a(aVar.f800g).mo11200a("retry_delay_sec", String.valueOf(pow)).mo11200a("retry_attempt", String.valueOf(C0870a.this.f797d.f806c)).mo11201a();
                    C0870a.this.f796c.m949a(str, C0870a.this.f798e, C0870a.this.f799f, C0870a.this.f800g, C0870a.this.f795b, C0870a.this);
                }
            }, TimeUnit.SECONDS.toMillis((long) pow));
        }

        public void onAdLoaded(MaxAd maxAd) {
            C0801a aVar = (C0801a) maxAd;
            aVar.mo9828a(this.f797d.f804a);
            int unused = this.f797d.f806c = 0;
            if (this.f797d.f807d != null) {
                aVar.mo9834g().mo10255e().mo9805a(this.f797d.f807d);
                this.f797d.f807d.onAdLoaded(aVar);
                if (aVar.mo9831d().endsWith("load")) {
                    this.f797d.f807d.onAdRevenuePaid(aVar);
                }
                C0836a.C0837a unused2 = this.f797d.f807d = null;
                if ((this.f794a.mo10980b(C1084a.f1507R).contains(maxAd.getAdUnitId()) || this.f794a.mo10961a(C1084a.f1506Q, maxAd.getFormat())) && !this.f794a.mo10930J().mo10221a() && !this.f794a.mo10930J().mo10223b()) {
                    this.f796c.m949a(maxAd.getAdUnitId(), maxAd.getFormat(), this.f799f, this.f800g, this.f795b, this);
                    return;
                }
            } else {
                this.f796c.m946a(aVar);
            }
            this.f797d.f805b.set(false);
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
        }
    }

    /* renamed from: com.applovin.impl.mediation.d$b */
    public static class C0872b {

        /* renamed from: a */
        public final String f804a;

        /* renamed from: b */
        public final AtomicBoolean f805b;

        /* renamed from: c */
        public int f806c;

        /* renamed from: d */
        public volatile C0836a.C0837a f807d;

        public C0872b(String str) {
            this.f805b = new AtomicBoolean();
            this.f804a = str;
        }

        /* renamed from: e */
        public static /* synthetic */ int m965e(C0872b bVar) {
            int i = bVar.f806c;
            bVar.f806c = i + 1;
            return i;
        }
    }

    public C0868d(C1188m mVar) {
        this.f782a = mVar;
    }

    @Nullable
    /* renamed from: a */
    private C0801a m943a(String str) {
        C0801a aVar;
        synchronized (this.f786e) {
            aVar = this.f785d.get(str);
            this.f785d.remove(str);
        }
        return aVar;
    }

    /* renamed from: a */
    private C0872b m944a(String str, String str2) {
        String str3;
        C0872b bVar;
        synchronized (this.f784c) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (StringUtils.isValidString(str2)) {
                str3 = "-" + str2;
            } else {
                str3 = "";
            }
            sb.append(str3);
            String sb2 = sb.toString();
            bVar = this.f783b.get(sb2);
            if (bVar == null) {
                bVar = new C0872b(str2);
                this.f783b.put(sb2, bVar);
            }
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m946a(C0801a aVar) {
        synchronized (this.f786e) {
            if (this.f785d.containsKey(aVar.getAdUnitId())) {
                C1314v.m2663i(AppLovinSdk.TAG, "Ad in cache already: " + aVar.getAdUnitId());
            }
            this.f785d.put(aVar.getAdUnitId(), aVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m949a(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, C1231i iVar, Context context, C0836a.C0837a aVar) {
        final String str2 = str;
        final MaxAdFormat maxAdFormat2 = maxAdFormat;
        final Map<String, Object> map2 = map;
        final C1231i iVar2 = iVar;
        final Context context2 = context;
        final C0836a.C0837a aVar2 = aVar;
        this.f782a.mo10938S().mo10829a((C1109a) new C0845b(maxAdFormat, map, context, this.f782a, new C0845b.C0849a() {
            /* renamed from: a */
            public void mo10006a(JSONArray jSONArray) {
                C0868d.this.f782a.mo10938S().mo10828a((C1109a) new C0850c(str2, maxAdFormat2, map2, iVar2, jSONArray, context2, C0868d.this.f782a, aVar2));
            }
        }), C0867c.m935a(maxAdFormat));
    }

    /* renamed from: a */
    public void mo10031a(String str, @Nullable String str2, MaxAdFormat maxAdFormat, Map<String, Object> map, C1231i iVar, Context context, C0836a.C0837a aVar) {
        C0836a.C0837a aVar2 = aVar;
        C0801a a = (this.f782a.mo10930J().mo10223b() || Utils.isDspDemoApp(this.f782a.mo10932L())) ? null : m943a(str);
        String str3 = str2;
        if (a != null) {
            a.mo9828a(str2);
            a.mo9834g().mo10255e().mo9805a(aVar2);
            aVar2.onAdLoaded(a);
            if (a.mo9831d().endsWith("load")) {
                aVar2.onAdRevenuePaid(a);
            }
        }
        C0872b a2 = m944a(str, str2);
        if (a2.f805b.compareAndSet(false, true)) {
            if (a == null) {
                C0836a.C0837a unused = a2.f807d = aVar2;
            }
            m949a(str, maxAdFormat, map, iVar, context, new C0870a(map, iVar, a2, maxAdFormat, this, this.f782a, context));
            return;
        }
        if (!(a2.f807d == null || a2.f807d == aVar2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempting to load ad for same ad unit id (");
            String str4 = str;
            sb.append(str);
            sb.append(") while another ad load is already in progress!");
            C1314v.m2662h("MediationAdLoadManager", sb.toString());
        }
        C0836a.C0837a unused2 = a2.f807d = aVar2;
    }
}
