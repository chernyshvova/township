package com.applovin.impl.adview;

import androidx.core.app.NotificationCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.s */
public class C0781s {

    /* renamed from: a */
    public final int f504a;

    /* renamed from: b */
    public final int f505b;

    /* renamed from: c */
    public final int f506c;

    /* renamed from: d */
    public final int f507d;

    /* renamed from: e */
    public final boolean f508e;

    /* renamed from: f */
    public final int f509f;

    /* renamed from: g */
    public final int f510g;

    /* renamed from: h */
    public final int f511h;

    /* renamed from: i */
    public final float f512i;

    /* renamed from: j */
    public final float f513j;

    public C0781s(JSONObject jSONObject, C1188m mVar) {
        C1314v B = mVar.mo10922B();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Updating video button properties with JSON = ");
        outline24.append(JsonUtils.maybeConvertToIndentedString(jSONObject));
        B.mo11374c("VideoButtonProperties", outline24.toString());
        this.f504a = JsonUtils.getInt(jSONObject, "width", 64);
        this.f505b = JsonUtils.getInt(jSONObject, "height", 7);
        this.f506c = JsonUtils.getInt(jSONObject, "margin", 20);
        this.f507d = JsonUtils.getInt(jSONObject, NotificationCompat.WearableExtender.KEY_GRAVITY, 85);
        this.f508e = JsonUtils.getBoolean(jSONObject, "tap_to_fade", Boolean.FALSE).booleanValue();
        this.f509f = JsonUtils.getInt(jSONObject, "tap_to_fade_duration_milliseconds", 500);
        this.f510g = JsonUtils.getInt(jSONObject, "fade_in_duration_milliseconds", 500);
        this.f511h = JsonUtils.getInt(jSONObject, "fade_out_duration_milliseconds", 500);
        this.f512i = JsonUtils.getFloat(jSONObject, "fade_in_delay_seconds", 1.0f);
        this.f513j = JsonUtils.getFloat(jSONObject, "fade_out_delay_seconds", 6.0f);
    }

    /* renamed from: a */
    public int mo9695a() {
        return this.f504a;
    }

    /* renamed from: b */
    public int mo9696b() {
        return this.f505b;
    }

    /* renamed from: c */
    public int mo9697c() {
        return this.f506c;
    }

    /* renamed from: d */
    public int mo9698d() {
        return this.f507d;
    }

    /* renamed from: e */
    public boolean mo9699e() {
        return this.f508e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0781s.class != obj.getClass()) {
            return false;
        }
        C0781s sVar = (C0781s) obj;
        return this.f504a == sVar.f504a && this.f505b == sVar.f505b && this.f506c == sVar.f506c && this.f507d == sVar.f507d && this.f508e == sVar.f508e && this.f509f == sVar.f509f && this.f510g == sVar.f510g && this.f511h == sVar.f511h && Float.compare(sVar.f512i, this.f512i) == 0 && Float.compare(sVar.f513j, this.f513j) == 0;
    }

    /* renamed from: f */
    public long mo9701f() {
        return (long) this.f509f;
    }

    /* renamed from: g */
    public long mo9702g() {
        return (long) this.f510g;
    }

    /* renamed from: h */
    public long mo9703h() {
        return (long) this.f511h;
    }

    public int hashCode() {
        int i = ((((((((((((((this.f504a * 31) + this.f505b) * 31) + this.f506c) * 31) + this.f507d) * 31) + (this.f508e ? 1 : 0)) * 31) + this.f509f) * 31) + this.f510g) * 31) + this.f511h) * 31;
        float f = this.f512i;
        int i2 = 0;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.f513j;
        if (f2 != 0.0f) {
            i2 = Float.floatToIntBits(f2);
        }
        return floatToIntBits + i2;
    }

    /* renamed from: i */
    public float mo9705i() {
        return this.f512i;
    }

    /* renamed from: j */
    public float mo9706j() {
        return this.f513j;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VideoButtonProperties{widthPercentOfScreen=");
        outline24.append(this.f504a);
        outline24.append(", heightPercentOfScreen=");
        outline24.append(this.f505b);
        outline24.append(", margin=");
        outline24.append(this.f506c);
        outline24.append(", gravity=");
        outline24.append(this.f507d);
        outline24.append(", tapToFade=");
        outline24.append(this.f508e);
        outline24.append(", tapToFadeDurationMillis=");
        outline24.append(this.f509f);
        outline24.append(", fadeInDurationMillis=");
        outline24.append(this.f510g);
        outline24.append(", fadeOutDurationMillis=");
        outline24.append(this.f511h);
        outline24.append(", fadeInDelay=");
        outline24.append(this.f512i);
        outline24.append(", fadeOutDelay=");
        outline24.append(this.f513j);
        outline24.append('}');
        return outline24.toString();
    }
}
