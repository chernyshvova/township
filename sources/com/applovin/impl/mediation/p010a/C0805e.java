package com.applovin.impl.mediation.p010a;

import androidx.annotation.Nullable;
import com.applovin.impl.mediation.C0951g;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.e */
public abstract class C0805e extends C0801a {
    public C0805e(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, @Nullable C0951g gVar, C1188m mVar) {
        super(map, jSONObject, jSONObject2, gVar, mVar);
    }

    /* renamed from: D */
    public int mo9889D() {
        MaxAdFormat format = getFormat();
        C1085b bVar = format == MaxAdFormat.BANNER ? C1085b.f1610bO : format == MaxAdFormat.MREC ? C1085b.f1612bQ : format == MaxAdFormat.LEADER ? C1085b.f1614bS : format == MaxAdFormat.NATIVE ? C1085b.f1616bU : null;
        if (bVar != null) {
            return mo9919b("viewability_min_width", ((Integer) this.f605b.mo10946a(bVar)).intValue());
        }
        return 0;
    }

    /* renamed from: E */
    public int mo9890E() {
        MaxAdFormat format = getFormat();
        C1085b bVar = format == MaxAdFormat.BANNER ? C1085b.f1611bP : format == MaxAdFormat.MREC ? C1085b.f1613bR : format == MaxAdFormat.LEADER ? C1085b.f1615bT : format == MaxAdFormat.NATIVE ? C1085b.f1617bV : null;
        if (bVar != null) {
            return mo9919b("viewability_min_height", ((Integer) this.f605b.mo10946a(bVar)).intValue());
        }
        return 0;
    }

    /* renamed from: F */
    public float mo9891F() {
        return mo9909a("viewability_min_alpha", ((Float) this.f605b.mo10946a(C1085b.f1618bW)).floatValue() / 100.0f);
    }

    /* renamed from: G */
    public int mo9892G() {
        return mo9919b("viewability_min_pixels", -1);
    }

    /* renamed from: H */
    public boolean mo9893H() {
        return mo9892G() >= 0;
    }

    /* renamed from: I */
    public long mo9894I() {
        return mo9920b("viewability_timer_min_visible_ms", ((Long) this.f605b.mo10946a(C1085b.f1619bX)).longValue());
    }
}
