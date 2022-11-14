package com.applovin.impl.sdk.p029e;

import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1213b;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p027c.C1086c;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.e.u */
public abstract class C1157u<T> extends C1109a implements C1213b.C1216c<T> {

    /* renamed from: a */
    public final C1217c<T> f2083a;

    /* renamed from: c */
    public final C1213b.C1216c<T> f2084c;

    /* renamed from: d */
    public C1213b.C1214a f2085d;

    /* renamed from: e */
    public C1140o.C1142a f2086e;

    /* renamed from: f */
    public C1085b<String> f2087f;

    /* renamed from: g */
    public C1085b<String> f2088g;

    public C1157u(C1217c<T> cVar, C1188m mVar) {
        this(cVar, mVar, false);
    }

    public C1157u(C1217c<T> cVar, final C1188m mVar, boolean z) {
        super("TaskRepeatRequest", mVar, z);
        this.f2086e = C1140o.C1142a.BACKGROUND;
        this.f2087f = null;
        this.f2088g = null;
        if (cVar != null) {
            this.f2083a = cVar;
            this.f2085d = new C1213b.C1214a();
            this.f2084c = new C1213b.C1216c<T>() {
                /* renamed from: a */
                public void mo10008a(int i, String str, T t) {
                    C1085b bVar;
                    C1157u uVar;
                    boolean z = false;
                    boolean z2 = i < 200 || i >= 500;
                    boolean z3 = i == 429;
                    if ((i != -1009) && (z2 || z3 || C1157u.this.f2083a.mo11120m())) {
                        String f = C1157u.this.f2083a.mo11112f();
                        if (C1157u.this.f2083a.mo11114h() > 0) {
                            C1157u uVar2 = C1157u.this;
                            StringBuilder outline25 = GeneratedOutlineSupport.outline25("Unable to send request due to server failure (code ", i, "). ");
                            outline25.append(C1157u.this.f2083a.mo11114h());
                            outline25.append(" attempts left, retrying in ");
                            outline25.append(TimeUnit.MILLISECONDS.toSeconds((long) C1157u.this.f2083a.mo11118k()));
                            outline25.append(" seconds...");
                            uVar2.mo10771c(outline25.toString());
                            int h = C1157u.this.f2083a.mo11114h() - 1;
                            C1157u.this.f2083a.mo11104a(h);
                            if (h == 0) {
                                C1157u uVar3 = C1157u.this;
                                uVar3.m1950c(uVar3.f2087f);
                                if (StringUtils.isValidString(f) && f.length() >= 4) {
                                    C1157u.this.mo10770b("Switching to backup endpoint " + f);
                                    C1157u.this.f2083a.mo11105a(f);
                                    z = true;
                                }
                            }
                            long millis = (!((Boolean) mVar.mo10946a(C1085b.f1732dg)).booleanValue() || !z) ? C1157u.this.f2083a.mo11119l() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, (double) C1157u.this.f2083a.mo11116i())) : (long) C1157u.this.f2083a.mo11118k() : 0;
                            C1140o S = mVar.mo10938S();
                            C1157u uVar4 = C1157u.this;
                            S.mo10830a(uVar4, uVar4.f2086e, millis);
                            return;
                        }
                        if (f == null || !f.equals(C1157u.this.f2083a.mo11103a())) {
                            uVar = C1157u.this;
                            bVar = uVar.f2087f;
                        } else {
                            uVar = C1157u.this;
                            bVar = uVar.f2088g;
                        }
                        uVar.m1950c(bVar);
                    }
                    C1157u.this.mo10008a(i, str, t);
                }

                /* renamed from: a */
                public void mo10010a(T t, int i) {
                    C1157u.this.f2083a.mo11104a(0);
                    C1157u.this.mo10010a(t, i);
                }
            };
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public <ST> void m1950c(C1085b<ST> bVar) {
        if (bVar != null) {
            C1086c K = mo10772d().mo10931K();
            K.mo10680a((C1085b<?>) bVar, (Object) bVar.mo10675b());
            K.mo10679a();
        }
    }

    /* renamed from: a */
    public abstract void mo10008a(int i, String str, T t);

    /* renamed from: a */
    public void mo10853a(C1085b<String> bVar) {
        this.f2087f = bVar;
    }

    /* renamed from: a */
    public void mo10854a(C1140o.C1142a aVar) {
        this.f2086e = aVar;
    }

    /* renamed from: a */
    public abstract void mo10010a(T t, int i);

    /* renamed from: b */
    public void mo10855b(C1085b<String> bVar) {
        this.f2088g = bVar;
    }

    public void run() {
        int i;
        C1213b R = mo10772d().mo10937R();
        if (!mo10772d().mo10986c() && !mo10772d().mo10987d()) {
            C1314v.m2663i(AppLovinSdk.TAG, "AppLovin SDK is disabled");
            i = -22;
        } else if (!StringUtils.isValidString(this.f2083a.mo11103a()) || this.f2083a.mo11103a().length() < 4) {
            mo10773d("Task has an invalid or null request endpoint.");
            i = AppLovinErrorCodes.INVALID_URL;
        } else {
            if (TextUtils.isEmpty(this.f2083a.mo11106b())) {
                this.f2083a.mo11107b(this.f2083a.mo11110e() != null ? "POST" : "GET");
            }
            R.mo11095a(this.f2083a, this.f2085d, this.f2084c);
            return;
        }
        mo10008a(i, (String) null, (Object) null);
    }
}
