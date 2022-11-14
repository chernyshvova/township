package com.iab.omid.library.applovin;

import android.content.Context;
import com.iab.omid.library.applovin.p045b.C2842b;
import com.iab.omid.library.applovin.p045b.C2845d;
import com.iab.omid.library.applovin.p045b.C2848f;
import com.iab.omid.library.applovin.p047d.C2856b;
import com.iab.omid.library.applovin.p047d.C2860e;

/* renamed from: com.iab.omid.library.applovin.b */
public class C2840b {

    /* renamed from: a */
    public boolean f3392a;

    /* renamed from: b */
    private void m3280b(Context context) {
        C2860e.m3379a((Object) context, "Application Context cannot be null");
    }

    /* renamed from: a */
    public String mo36705a() {
        return "1.3.24-Applovin";
    }

    /* renamed from: a */
    public void mo36706a(Context context) {
        m3280b(context);
        if (!mo36708b()) {
            mo36707a(true);
            C2848f.m3325a().mo36751a(context);
            C2842b.m3292a().mo36715a(context);
            C2856b.m3357a(context);
            C2845d.m3305a().mo36732a(context);
        }
    }

    /* renamed from: a */
    public void mo36707a(boolean z) {
        this.f3392a = z;
    }

    /* renamed from: b */
    public boolean mo36708b() {
        return this.f3392a;
    }
}
