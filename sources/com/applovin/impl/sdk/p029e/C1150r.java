package com.applovin.impl.sdk.p029e;

import androidx.annotation.Nullable;
import com.applovin.impl.p007a.C0639e;
import com.applovin.impl.p007a.C0640f;
import com.applovin.impl.p007a.C0647l;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.C1311r;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.r */
public abstract class C1150r extends C1109a {

    /* renamed from: a */
    public final AppLovinAdLoadListener f2072a;

    /* renamed from: c */
    public final C1151a f2073c;

    /* renamed from: com.applovin.impl.sdk.e.r$a */
    public static final class C1151a extends C0639e {
        public C1151a(JSONObject jSONObject, JSONObject jSONObject2, C1053b bVar, C1188m mVar) {
            super(jSONObject, jSONObject2, bVar, mVar);
        }

        /* renamed from: a */
        public void mo10847a(C1310q qVar) {
            if (qVar != null) {
                this.f104a.add(qVar);
                return;
            }
            throw new IllegalArgumentException("No aggregated vast response specified");
        }
    }

    /* renamed from: com.applovin.impl.sdk.e.r$b */
    public static final class C1152b extends C1150r {

        /* renamed from: a */
        public final String f2074a;

        public C1152b(String str, C0639e eVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
            super(eVar, appLovinAdLoadListener, mVar);
            this.f2074a = str;
        }

        public void run() {
            mo10845a(mo10846e(this.f2074a));
        }
    }

    /* renamed from: com.applovin.impl.sdk.e.r$c */
    public static final class C1153c extends C1150r {

        /* renamed from: a */
        public final JSONObject f2075a;

        public C1153c(C0639e eVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
            super(eVar, appLovinAdLoadListener, mVar);
            this.f2075a = eVar.mo9365c();
        }

        public void run() {
            C0640f fVar;
            mo10768a("Processing SDK JSON response...");
            String string = JsonUtils.getString(this.f2075a, "xml", (String) null);
            if (!StringUtils.isValidString(string)) {
                mo10773d("No VAST response received.");
                fVar = C0640f.NO_WRAPPER_RESPONSE;
            } else if (string.length() < ((Integer) this.f1961b.mo10946a(C1085b.f1788ek)).intValue()) {
                mo10845a(mo10846e(string));
                return;
            } else {
                mo10773d("VAST response is over max length");
                fVar = C0640f.XML_PARSING;
            }
            mo10844a(fVar);
        }
    }

    /* renamed from: com.applovin.impl.sdk.e.r$d */
    public static final class C1154d extends C1150r {

        /* renamed from: a */
        public final C1310q f2076a;

        public C1154d(C1310q qVar, C0639e eVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
            super(eVar, appLovinAdLoadListener, mVar);
            if (qVar == null) {
                throw new IllegalArgumentException("No response specified.");
            } else if (eVar == null) {
                throw new IllegalArgumentException("No context specified.");
            } else if (appLovinAdLoadListener != null) {
                this.f2076a = qVar;
            } else {
                throw new IllegalArgumentException("No callback specified.");
            }
        }

        public void run() {
            mo10768a("Processing VAST Wrapper response...");
            mo10845a(this.f2076a);
        }
    }

    public C1150r(C0639e eVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        super("TaskProcessVastResponse", mVar);
        if (eVar != null) {
            this.f2072a = appLovinAdLoadListener;
            this.f2073c = (C1151a) eVar;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    /* renamed from: a */
    public static C1150r m1939a(C1310q qVar, C0639e eVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        return new C1154d(qVar, eVar, appLovinAdLoadListener, mVar);
    }

    /* renamed from: a */
    public static C1150r m1940a(String str, JSONObject jSONObject, JSONObject jSONObject2, C1053b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        return new C1152b(str, new C1151a(jSONObject, jSONObject2, bVar, mVar), appLovinAdLoadListener, mVar);
    }

    /* renamed from: a */
    public static C1150r m1941a(JSONObject jSONObject, JSONObject jSONObject2, C1053b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        return new C1153c(new C1151a(jSONObject, jSONObject2, bVar, mVar), appLovinAdLoadListener, mVar);
    }

    /* renamed from: a */
    public void mo10844a(C0640f fVar) {
        mo10773d("Failed to process VAST response due to VAST error code " + fVar);
        C0647l.m150a((C0639e) this.f2073c, this.f2072a, fVar, -6, this.f1961b);
    }

    /* renamed from: a */
    public void mo10845a(C1310q qVar) {
        C0640f fVar;
        C1109a aVar;
        int a = this.f2073c.mo9363a();
        mo10768a("Finished parsing XML at depth " + a);
        this.f2073c.mo10847a(qVar);
        if (C0647l.m156a(qVar)) {
            int intValue = ((Integer) this.f1961b.mo10946a(C1085b.f1789el)).intValue();
            if (a < intValue) {
                mo10768a("VAST response is wrapper. Resolving...");
                aVar = new C1162x(this.f2073c, this.f2072a, this.f1961b);
            } else {
                mo10773d("Reached beyond max wrapper depth of " + intValue);
                fVar = C0640f.WRAPPER_LIMIT_REACHED;
                mo10844a(fVar);
                return;
            }
        } else if (C0647l.m159b(qVar)) {
            mo10768a("VAST response is inline. Rendering ad...");
            aVar = new C1156t(this.f2073c, this.f2072a, this.f1961b);
        } else {
            mo10773d("VAST response is an error");
            fVar = C0640f.NO_WRAPPER_RESPONSE;
            mo10844a(fVar);
            return;
        }
        this.f1961b.mo10938S().mo10828a(aVar);
    }

    @Nullable
    /* renamed from: e */
    public C1310q mo10846e(String str) {
        try {
            return C1311r.m2643a(str, this.f1961b);
        } catch (Throwable th) {
            mo10769a("Failed to process VAST response", th);
            mo10844a(C0640f.XML_PARSING);
            return null;
        }
    }
}
