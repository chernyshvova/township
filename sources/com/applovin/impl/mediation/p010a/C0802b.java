package com.applovin.impl.mediation.p010a;

import android.view.View;
import androidx.annotation.Nullable;
import com.applovin.impl.mediation.C0951g;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.b */
public class C0802b extends C0805e {
    public C0802b(C0802b bVar, C0951g gVar) {
        super(bVar.mo9905W(), bVar.mo9896N(), bVar.mo9895M(), gVar, bVar.f605b);
    }

    public C0802b(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, C1188m mVar) {
        super(map, jSONObject, jSONObject2, (C0951g) null, mVar);
    }

    /* renamed from: A */
    public long mo9859A() {
        long b = mo9920b("ad_refresh_ms", -1);
        return b >= 0 ? b : mo9911a("ad_refresh_ms", ((Long) this.f605b.mo10946a(C1084a.f1530m)).longValue());
    }

    /* renamed from: B */
    public boolean mo9860B() {
        return mo9921b("proe", (Boolean) this.f605b.mo10946a(C1084a.f1503N)).booleanValue();
    }

    /* renamed from: C */
    public long mo9861C() {
        return Utils.parseColor(mo9922b("bg_color", (String) null));
    }

    /* renamed from: a */
    public C0801a mo9824a(C0951g gVar) {
        return new C0802b(this, gVar);
    }

    /* renamed from: v */
    public int mo9862v() {
        int b = mo9919b("ad_view_width", -2);
        if (b != -2) {
            return b;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    /* renamed from: w */
    public int mo9863w() {
        int b = mo9919b("ad_view_height", -2);
        if (b != -2) {
            return b;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getHeight();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    @Nullable
    /* renamed from: x */
    public View mo9864x() {
        C0951g gVar;
        if (!mo9832e() || (gVar = this.f596a) == null) {
            return null;
        }
        return gVar.mo10244a();
    }

    /* renamed from: y */
    public long mo9865y() {
        return mo9920b("viewability_imp_delay_ms", ((Long) this.f605b.mo10946a(C1085b.f1609bN)).longValue());
    }

    /* renamed from: z */
    public boolean mo9866z() {
        return mo9859A() >= 0;
    }
}
