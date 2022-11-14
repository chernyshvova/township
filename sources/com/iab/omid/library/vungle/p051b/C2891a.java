package com.iab.omid.library.vungle.p051b;

import com.iab.omid.library.vungle.adsession.C2889a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.vungle.b.a */
public class C2891a {

    /* renamed from: a */
    public static C2891a f3501a = new C2891a();

    /* renamed from: b */
    public final ArrayList<C2889a> f3502b = new ArrayList<>();

    /* renamed from: c */
    public final ArrayList<C2889a> f3503c = new ArrayList<>();

    /* renamed from: b */
    public Collection<C2889a> mo36837b() {
        return Collections.unmodifiableCollection(this.f3502b);
    }

    /* renamed from: c */
    public Collection<C2889a> mo36838c() {
        return Collections.unmodifiableCollection(this.f3503c);
    }

    /* renamed from: d */
    public boolean mo36839d() {
        return this.f3503c.size() > 0;
    }
}
