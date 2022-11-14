package com.iab.omid.library.applovin.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.applovin.walking.p049a.C2874b;
import com.iab.omid.library.applovin.walking.p049a.C2877c;
import com.iab.omid.library.applovin.walking.p049a.C2878d;
import com.iab.omid.library.applovin.walking.p049a.C2879e;
import com.iab.omid.library.applovin.walking.p049a.C2880f;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.walking.b */
public class C2881b implements C2874b.C2876b {

    /* renamed from: a */
    public JSONObject f3481a;

    /* renamed from: b */
    public final C2877c f3482b;

    public C2881b(C2877c cVar) {
        this.f3482b = cVar;
    }

    /* renamed from: a */
    public void mo36826a() {
        this.f3482b.mo36819b(new C2878d(this));
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo36817a(JSONObject jSONObject) {
        this.f3481a = jSONObject;
    }

    /* renamed from: a */
    public void mo36827a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f3482b.mo36819b(new C2880f(this, hashSet, jSONObject, j));
    }

    @VisibleForTesting
    /* renamed from: b */
    public JSONObject mo36818b() {
        return this.f3481a;
    }

    /* renamed from: b */
    public void mo36828b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f3482b.mo36819b(new C2879e(this, hashSet, jSONObject, j));
    }
}
