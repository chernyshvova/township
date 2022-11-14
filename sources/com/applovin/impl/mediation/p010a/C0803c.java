package com.applovin.impl.mediation.p010a;

import android.os.SystemClock;
import com.applovin.impl.mediation.C0951g;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p026b.C1082c;
import com.applovin.impl.sdk.p027c.C1084a;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.c */
public class C0803c extends C0801a {

    /* renamed from: c */
    public final AtomicReference<C1082c> f600c;

    /* renamed from: d */
    public final AtomicBoolean f601d;

    /* renamed from: e */
    public final AtomicBoolean f602e;

    public C0803c(C0803c cVar, C0951g gVar) {
        super(cVar.mo9905W(), cVar.mo9896N(), cVar.mo9895M(), gVar, cVar.f605b);
        this.f602e = new AtomicBoolean();
        this.f600c = cVar.f600c;
        this.f601d = cVar.f601d;
    }

    public C0803c(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, C1188m mVar) {
        super(map, jSONObject, jSONObject2, (C0951g) null, mVar);
        this.f602e = new AtomicBoolean();
        this.f600c = new AtomicReference<>();
        this.f601d = new AtomicBoolean();
    }

    /* renamed from: A */
    public long mo9867A() {
        long b = mo9920b("fullscreen_display_delay_ms", -1);
        return b >= 0 ? b : ((Long) this.f605b.mo10946a(C1084a.f1490A)).longValue();
    }

    /* renamed from: B */
    public long mo9868B() {
        return mo9920b("ahdm", ((Long) this.f605b.mo10946a(C1084a.f1491B)).longValue());
    }

    /* renamed from: C */
    public String mo9869C() {
        return mo9922b("bcode", "");
    }

    /* renamed from: D */
    public String mo9870D() {
        return mo9914a("mcode", "");
    }

    /* renamed from: E */
    public boolean mo9871E() {
        return this.f601d.get();
    }

    /* renamed from: F */
    public void mo9872F() {
        this.f601d.set(true);
    }

    /* renamed from: G */
    public C1082c mo9873G() {
        return this.f600c.getAndSet((Object) null);
    }

    /* renamed from: H */
    public boolean mo9874H() {
        return mo9921b("show_nia", mo9912a("show_nia", Boolean.FALSE)).booleanValue();
    }

    /* renamed from: I */
    public String mo9875I() {
        return mo9922b("nia_title", mo9914a("nia_title", ""));
    }

    /* renamed from: J */
    public String mo9876J() {
        return mo9922b("nia_message", mo9914a("nia_message", ""));
    }

    /* renamed from: K */
    public String mo9877K() {
        return mo9922b("nia_button_title", mo9914a("nia_button_title", ""));
    }

    /* renamed from: L */
    public AtomicBoolean mo9878L() {
        return this.f602e;
    }

    /* renamed from: a */
    public C0801a mo9824a(C0951g gVar) {
        return new C0803c(this, gVar);
    }

    /* renamed from: a */
    public void mo9879a(C1082c cVar) {
        this.f600c.set(cVar);
    }

    /* renamed from: v */
    public long mo9862v() {
        long b = mo9920b("ad_expiration_ms", -1);
        return b >= 0 ? b : mo9911a("ad_expiration_ms", ((Long) this.f605b.mo10946a(C1084a.f1497H)).longValue());
    }

    /* renamed from: w */
    public long mo9880w() {
        long b = mo9920b("ad_hidden_timeout_ms", -1);
        return b >= 0 ? b : mo9911a("ad_hidden_timeout_ms", ((Long) this.f605b.mo10946a(C1084a.f1500K)).longValue());
    }

    /* renamed from: x */
    public boolean mo9881x() {
        if (mo9921b("schedule_ad_hidden_on_ad_dismiss", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return mo9912a("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f605b.mo10946a(C1084a.f1501L)).booleanValue();
    }

    /* renamed from: y */
    public long mo9882y() {
        long b = mo9920b("ad_hidden_on_ad_dismiss_callback_delay_ms", -1);
        return b >= 0 ? b : mo9911a("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f605b.mo10946a(C1084a.f1502M)).longValue());
    }

    /* renamed from: z */
    public long mo9883z() {
        if (mo9854r() > 0) {
            return SystemClock.elapsedRealtime() - mo9854r();
        }
        return -1;
    }
}
