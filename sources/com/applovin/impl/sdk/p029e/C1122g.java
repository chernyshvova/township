package com.applovin.impl.sdk.p029e;

import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.adview.C0740d;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1229h;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.g */
public class C1122g extends C1109a {

    /* renamed from: a */
    public final C1229h f1984a;

    /* renamed from: c */
    public final AppLovinPostbackListener f1985c;

    /* renamed from: d */
    public final C1140o.C1142a f1986d;

    public C1122g(C1229h hVar, C1140o.C1142a aVar, C1188m mVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", mVar);
        if (hVar != null) {
            this.f1984a = hVar;
            this.f1985c = appLovinPostbackListener;
            this.f1986d = aVar;
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1861a() {
        C11242 r0 = new C1157u<Object>(this.f1984a, mo10772d()) {

            /* renamed from: a */
            public final String f1988a = C1122g.this.f1984a.mo11103a();

            /* renamed from: a */
            public void mo10008a(int i, String str, Object obj) {
                StringBuilder outline25 = GeneratedOutlineSupport.outline25("Failed to dispatch postback. Error code: ", i, " URL: ");
                outline25.append(this.f1988a);
                mo10773d(outline25.toString());
                if (C1122g.this.f1985c != null) {
                    C1122g.this.f1985c.onPostbackFailure(this.f1988a, i);
                }
                if (C1122g.this.f1984a.mo11178q()) {
                    this.f1961b.mo10969ag().mo10898a(C1122g.this.f1984a.mo11179r(), this.f1988a, i, obj, str, false);
                }
            }

            /* renamed from: a */
            public void mo10010a(Object obj, int i) {
                if (obj instanceof String) {
                    for (String next : this.f1961b.mo10980b(C1085b.f1565aU)) {
                        if (next.startsWith(next)) {
                            String str = (String) obj;
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    C1264h.m2526d(jSONObject, this.f1961b);
                                    C1264h.m2525c(jSONObject, this.f1961b);
                                    C1264h.m2528e(jSONObject, this.f1961b);
                                    break;
                                } catch (JSONException unused) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                if (C1122g.this.f1985c != null) {
                    C1122g.this.f1985c.onPostbackSuccess(this.f1988a);
                }
                if (C1122g.this.f1984a.mo11178q()) {
                    this.f1961b.mo10969ag().mo10898a(C1122g.this.f1984a.mo11179r(), this.f1988a, i, obj, (String) null, true);
                }
            }
        };
        r0.mo10854a(this.f1986d);
        mo10772d().mo10938S().mo10828a((C1109a) r0);
    }

    public void run() {
        if (!StringUtils.isValidString(this.f1984a.mo11103a())) {
            mo10770b("Requested URL is not valid; nothing to do...");
            AppLovinPostbackListener appLovinPostbackListener = this.f1985c;
            if (appLovinPostbackListener != null) {
                appLovinPostbackListener.onPostbackFailure(this.f1984a.mo11103a(), AppLovinErrorCodes.INVALID_URL);
            }
        } else if (this.f1984a.mo11180s()) {
            C0740d.m488a(this.f1984a, mo10772d(), new AppLovinPostbackListener() {
                public void onPostbackFailure(String str, int i) {
                    C1122g.this.m1861a();
                }

                public void onPostbackSuccess(String str) {
                    if (C1122g.this.f1985c != null) {
                        C1122g.this.f1985c.onPostbackSuccess(C1122g.this.f1984a.mo11103a());
                    }
                }
            });
        } else {
            m1861a();
        }
    }
}
